package ua.kpi.tzyapz.personal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Замініть кожен fail власним викликом і твердженням. Потім вилучіть імпорт fail.
class PayrollContributionTest {
    @Test
    @DisplayName("BL-50 Сума на руки з 42,42 грн")
    void deductsTaxesFromGrossOf42Point42() {
        PayrollCalculator calculator = new PayrollCalculator();
        // calculator.net(new BigDecimal("42.42")) має повернути BigDecimal "32.66".
        fail("Додайте власну перевірку");
    }

    @Test
    @DisplayName("BL-60 Ставка за окладу 16 800 грн")
    void calculatesHourlyRateFrom16800() {
        PayrollCalculator calculator = new PayrollCalculator();
        // calculator.hourlyRate(new BigDecimal("16800")) має повернути BigDecimal "100.00".
        fail("Додайте власну перевірку");
    }

    @Test
    @DisplayName("BL-70 Оплата за 0,5 год понаднормових")
    void roundsOvertimePayForHalfAnHour() {
        PayrollCalculator calculator = new PayrollCalculator();
        // calculator.overtimePay(new BigDecimal("84"), new BigDecimal("0.5")) має повернути BigDecimal "0.38".
        fail("Додайте власну перевірку");
    }

}
