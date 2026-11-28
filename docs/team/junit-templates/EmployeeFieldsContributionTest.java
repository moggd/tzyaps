package ua.kpi.tzyapz.personal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

// Замініть кожен fail власним викликом і твердженням. Потім вилучіть імпорт fail.
class EmployeeFieldsContributionTest {
    @Test
    @DisplayName("BL-80 Відхилити пошту без локальної частини")
    void rejectsEmailWithNoLocalPart() {
        EmployeeValidator validator = new EmployeeValidator();
        // validator.isValidEmail("@example.test") має повернути false.
        fail("Додайте власну перевірку");
    }

    @Test
    @DisplayName("BL-80 Відхилити РНОКПП із пробілом")
    void rejectsTaxIdWithSpaceAndNineDigits() {
        EmployeeValidator validator = new EmployeeValidator();
        // validator.isValidTaxId("01234 5678") має повернути false.
        fail("Додайте власну перевірку");
    }

    @Test
    @DisplayName("BL-80 Прийняти дату найму у високосний день")
    void acceptsLeapDayHireDateBeforeToday() {
        EmployeeValidator validator = new EmployeeValidator();
        // validator.isHireDateValid(LocalDate.of(2024, 2, 29), LocalDate.of(2024, 3, 1)) має повернути true.
        fail("Додайте власну перевірку");
    }

}
