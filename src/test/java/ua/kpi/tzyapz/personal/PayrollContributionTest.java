package ua.kpi.tzyapz.personal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayrollContributionTest {
    @Test
    @DisplayName("BL-50 Сума на руки з 42,42 грн")
    void deductsTaxesFromGrossOf42Point42() {
        PayrollCalculator calculator = new PayrollCalculator();
        assertEquals(new BigDecimal("32.66"), calculator.net(new BigDecimal("42.42")));
    }

    @Test
    @DisplayName("BL-60 Ставка за окладу 16 800 грн")
    void calculatesHourlyRateFrom16800() {
        PayrollCalculator calculator = new PayrollCalculator();
        assertEquals(new BigDecimal("100.00"), calculator.hourlyRate(new BigDecimal("16800")));
    }

    @Test
    @DisplayName("BL-70 Оплата за 0,5 год понаднормових")
    void roundsOvertimePayForHalfAnHour() {
        PayrollCalculator calculator = new PayrollCalculator();
        assertEquals(new BigDecimal("0.38"), calculator.overtimePay(new BigDecimal("84"), new BigDecimal("0.5")));
    }
}