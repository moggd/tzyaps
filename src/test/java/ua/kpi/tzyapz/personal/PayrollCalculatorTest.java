package ua.kpi.tzyapz.personal;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class PayrollCalculatorTest {
    private final PayrollCalculator payroll = new PayrollCalculator();

    @DisplayName("BL-50 · Обидва утримання від нарахованої суми, HALF_UP")
    @ParameterizedTest
    @CsvSource({"0,0.00", "0.01,0.01", "0.50,0.39", "10000,7700.00", "12345.67,9506.17",
                "9999999.99,7699999.99", "10000000.00,7700000.00"})
    void deductsBothTaxesFromGross(BigDecimal gross, BigDecimal expected) {
        assertEquals(expected, payroll.net(gross));
    }

    @DisplayName("BL-50 · Межа 10 000 000,00 у редакції SRS 1.1")
    @Test
    void rejectsGrossAboveLimit() {
        assertThrows(IllegalArgumentException.class, () -> payroll.net(new BigDecimal("10000000.01")));
    }

    @DisplayName("BL-50 · Відсутня та від’ємна сума")
    @Test
    void rejectsInvalidGross() {
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> payroll.net(null)),
            () -> assertThrows(IllegalArgumentException.class, () -> payroll.net(new BigDecimal("-0.01")))
        );
    }

    @DisplayName("BL-60 · Оклад поділено на 168, ставку округлено HALF_UP")
    @ParameterizedTest
    @CsvSource({"0,0.00", "0.83,0.00", "0.84,0.01", "0.85,0.01", "10000,59.52", "25000,148.81"})
    void roundsHourlyRate(BigDecimal monthly, BigDecimal expected) {
        assertEquals(expected, payroll.hourlyRate(monthly));
    }

    @DisplayName("BL-60 · Відсутній та від’ємний оклад")
    @Test
    void rejectsInvalidMonthlySalary() {
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> payroll.hourlyRate(null)),
            () -> assertThrows(IllegalArgumentException.class, () -> payroll.hourlyRate(new BigDecimal("-0.01")))
        );
    }

    @DisplayName("BL-70 · Округлена ставка, півторакратна оплата та дробові години")
    @ParameterizedTest
    @CsvSource({"16800,2.5,375.00", "16800,0,0.00", "0,1,0.00", "10000,2,178.56", "168,0.01,0.02"})
    void overtimeUsesRoundedHourlyRate(BigDecimal monthly, BigDecimal hours, BigDecimal expected) {
        assertEquals(expected, payroll.overtimePay(monthly, hours));
    }

    @DisplayName("BL-70 · Заборонені значення годин й окладу")
    @Test
    void rejectsInvalidOvertimeInputs() {
        BigDecimal negative = new BigDecimal("-0.01");
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> payroll.overtimePay(BigDecimal.ONE, negative)),
            () -> assertThrows(IllegalArgumentException.class, () -> payroll.overtimePay(BigDecimal.ONE, null)),
            () -> assertThrows(IllegalArgumentException.class, () -> payroll.overtimePay(negative, BigDecimal.ONE)),
            () -> assertThrows(IllegalArgumentException.class, () -> payroll.overtimePay(null, BigDecimal.ONE))
        );
    }

    @DisplayName("BL-50 · Половина копійки в сумі після утримань")
    @Test
    void roundsNetUpAtHalfCent() {
        BigDecimal gross = new BigDecimal("33.50");

        // MOD-003: 33,50 × 0,77 = 25,795.
        assertEquals(new BigDecimal("25.80"), payroll.net(gross));
    }

    @DisplayName("BL-60 · Округлення точної половини копійки в ставці")
    @Test
    void roundsHourlyHalfCentUp() {
        BigDecimal monthly = new BigDecimal("9.24");

        // MOD-004: 9,24 / 168 = 0,055.
        assertEquals(new BigDecimal("0.06"), payroll.hourlyRate(monthly));
    }

    @DisplayName("BL-70 · У проміжному добутку використовується округлена ставка")
    @Test
    void usesHalfUpHourlyRateInOvertime() {
        BigDecimal monthly = new BigDecimal("2.52");
        BigDecimal hours = new BigDecimal("10");

        // MOD-004: 2,52 / 168 = 0,015 → 0,02, далі 0,02 × 1,5 × 10 = 0,30.
        assertEquals(new BigDecimal("0.30"), payroll.overtimePay(monthly, hours));
    }

    @DisplayName("BL-70 · Половина копійки у фінальній оплаті")
    @Test
    void roundsFractionalOvertimeUpAtHalfCent() {
        BigDecimal monthly = new BigDecimal("1680.00");
        BigDecimal hours = new BigDecimal("0.125");

        assertEquals(new BigDecimal("1.88"), payroll.overtimePay(monthly, hours));
    }
}
