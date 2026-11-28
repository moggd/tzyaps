package ua.kpi.tzyapz.personal;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class LeaveCalculatorTest {
    private final LeaveCalculator leave = new LeaveCalculator();
    private final LocalDate monday = LocalDate.of(2026, 9, 7);

    @DisplayName("BL-10 · Два дні за місяць у межах річної стелі")
    @ParameterizedTest
    @CsvSource({"0,0", "1,2", "5,10", "11,22", "12,24", "13,24"})
    void accrualCapsAtTwentyFour(int months, int expected) {
        assertEquals(expected, leave.accrued(months));
    }

    @DisplayName("BL-10 · Від’ємний стаж заборонено")
    @Test
    void rejectsNegativeMonths() {
        assertThrows(IllegalArgumentException.class, () -> leave.accrued(-1));
    }

    @DisplayName("BL-20 · Перенесення не більше п’яти днів")
    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "4,4", "5,5", "6,5", "9,5"})
    void carryOverCapsAtFive(int unused, int expected) {
        assertEquals(expected, leave.carryOver(unused));
    }

    @DisplayName("BL-20 · Від’ємний залишок заборонено")
    @Test
    void rejectsNegativeRemainder() {
        assertThrows(IllegalArgumentException.class, () -> leave.carryOver(-1));
    }

    @DisplayName("BL-30 · Обидві межі включно, вихідні виключено")
    @ParameterizedTest
    @CsvSource({"0,0,1", "0,4,5", "4,7,2", "5,6,0", "6,6,0"})
    void countsWeekdaysInclusively(int start, int end, int expected) {
        assertEquals(expected, leave.durationDays(monday.plusDays(start), monday.plusDays(end)));
    }

    @DisplayName("BL-30 · Некоректний інтервал або відсутня межа")
    @Test
    void rejectsInvalidInterval() {
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> leave.durationDays(monday.plusDays(1), monday)),
            () -> assertThrows(IllegalArgumentException.class, () -> leave.durationDays(null, monday)),
            () -> assertThrows(IllegalArgumentException.class, () -> leave.durationDays(monday, null))
        );
    }

    @DisplayName("BL-40 · Запит від одного дня до залишку включно")
    @ParameterizedTest
    @CsvSource({"5,-1,false", "5,0,false", "5,1,true", "5,4,true", "5,5,true", "5,6,false", "0,1,false"})
    void requiresPositiveDurationWithinBalance(int balance, int days, boolean expected) {
        assertEquals(expected, leave.canRequest(balance, days));
    }
}
