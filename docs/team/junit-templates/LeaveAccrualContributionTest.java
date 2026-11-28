package ua.kpi.tzyapz.personal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Замініть кожен fail власним викликом і твердженням. Потім вилучіть імпорт fail.
class LeaveAccrualContributionTest {
    @Test
    @DisplayName("BL-10 4 дні за 2 повні місяці")
    void accruesFourDaysAfterTwoMonths() {
        LeaveCalculator calculator = new LeaveCalculator();
        // calculator.accrued(2) має повернути 4.
        fail("Додайте власну перевірку");
    }

    @Test
    @DisplayName("BL-20 Перенести залишок 2 дні")
    void carriesTwoUnusedDays() {
        LeaveCalculator calculator = new LeaveCalculator();
        // calculator.carryOver(2) має повернути 2.
        fail("Додайте власну перевірку");
    }

    @Test
    @DisplayName("BL-30 Субота–понеділок містить один робочий день")
    void countsOneWeekdayFromSaturdayToMonday() {
        LeaveCalculator calculator = new LeaveCalculator();
        // calculator.durationDays(LocalDate.of(2026, 9, 5), LocalDate.of(2026, 9, 7)) має повернути 1.
        fail("Додайте власну перевірку");
    }

}
