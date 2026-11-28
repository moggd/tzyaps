package ua.kpi.tzyapz.personal;

import java.time.LocalDate;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeValidatorTest {
    private final EmployeeValidator employee = new EmployeeValidator();
    private final LocalDate hire = LocalDate.of(2026, 9, 7);

    @DisplayName("BL-80 · Формат пошти та довжина зони")
    @ParameterizedTest
    @CsvSource({"a-b+c_d%2@qa-1.example.test,true", "a@b.x,false", "a@b.xy,true", "a@b.xyz,true",
                "a.example.test,false", "a@b.12,false", ",false"})
    void validatesEmail(String email, boolean expected) {
        assertEquals(expected, employee.isValidEmail(email));
    }

    @DisplayName("BL-80 · РНОКПП містить рівно десять цифр")
    @ParameterizedTest
    @CsvSource({"012345678,false", "0123456789,true", "01234567890,false", "01234A6789,false", "'',false", ",false"})
    void requiresTenTaxIdDigits(String taxId, boolean expected) {
        assertEquals(expected, employee.isValidTaxId(taxId));
    }

    @DisplayName("BL-80 · Найм у минулому або сьогодні")
    @ParameterizedTest
    @CsvSource({"-1,true", "0,true", "1,false"})
    void hireDateCannotBeInFuture(int offset, boolean expected) {
        assertEquals(expected, employee.isHireDateValid(hire.plusDays(offset), hire));
    }

    @DisplayName("BL-80 · Вік від шістнадцятого дня народження включно")
    @ParameterizedTest
    @CsvSource({"-1,false", "0,true", "1,true"})
    void requiresFullSixteenYears(int daysFromBirthday, boolean expected) {
        assertEquals(expected, employee.isOldEnough(hire.minusYears(16), hire.plusDays(daysFromBirthday)));
    }

    @DisplayName("BL-80 · Відсутні дати відхиляються")
    @Test
    void rejectsMissingDates() {
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> employee.isHireDateValid(null, hire)),
            () -> assertThrows(IllegalArgumentException.class, () -> employee.isHireDateValid(hire, null)),
            () -> assertThrows(IllegalArgumentException.class, () -> employee.isOldEnough(null, hire)),
            () -> assertThrows(IllegalArgumentException.class, () -> employee.isOldEnough(hire, null)),
            () -> assertThrows(IllegalArgumentException.class,
                () -> employee.validate("qa@example.test", "0123456789", null, hire, hire))
        );
    }

    @DisplayName("BL-80 · Валідна картка повертає порожній список")
    @Test
    void validRecordHasNoErrors() {
        assertTrue(employee.validate("qa@example.test", "0123456789", hire.minusYears(22), hire, hire).isEmpty());
    }

    @DisplayName("BL-80 · Незалежні порушення повертають усі чотири коди")
    @Test
    void returnsEveryApplicableError() {
        var codes = employee.validate("invalid", "x", hire.minusYears(10), hire.plusDays(1), hire);
        assertEquals(Set.of("EMAIL", "TAX_ID", "HIRE_DATE", "AGE"), Set.copyOf(codes));
        assertEquals(4, codes.size());
    }

    @DisplayName("BL-80 · Локальна частина пошти не містить пробілів")
    @Test
    void rejectsSpaceInEmailLocalPart() {
        assertFalse(employee.isValidEmail("qa team@example.test"));
    }

    @DisplayName("BL-80 · Повних шістнадцять років після переходу року")
    @Test
    void acceptsSixteenthBirthdayAcrossYears() {
        LocalDate birth = LocalDate.of(2010, 12, 31);
        LocalDate start = LocalDate.of(2027, 1, 1);

        assertTrue(employee.isOldEnough(birth, start));
    }

    @DisplayName("BL-80 · Заборонена адреса і недостатній вік")
    @Test
    void returnsOnlyEmailAndAgeErrors() {
        var errors = employee.validate("invalid", "0123456789", hire.minusYears(15), hire, hire);

        assertEquals(2, errors.size());
        assertEquals(Set.of("EMAIL", "AGE"), Set.copyOf(errors));
    }

    @DisplayName("BL-80 · РНОКПП і дата найму перевіряються незалежно")
    @Test
    void returnsOnlyTaxIdAndHireDateErrors() {
        var errors = employee.validate("qa@example.test", "invalid", hire.minusYears(22), hire.plusDays(1), hire);

        assertEquals(2, errors.size());
        assertEquals(Set.of("TAX_ID", "HIRE_DATE"), Set.copyOf(errors));
    }
}
