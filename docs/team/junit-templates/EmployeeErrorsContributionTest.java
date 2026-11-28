package ua.kpi.tzyapz.personal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Замініть кожен fail власним викликом і твердженням. Потім вилучіть імпорт fail.
class EmployeeErrorsContributionTest {
    // Порядок: email, taxId, birthDate, hireDate, today.
    // Валідні значення email = "qa@example.test", taxId = "0123456789", hireDate = TODAY.
    private static final LocalDate TODAY = LocalDate.of(2026, 9, 7);
    private static final LocalDate BIRTH_DATE = LocalDate.of(2000, 1, 1);

    @Test
    @DisplayName("BL-80 Єдина помилка EMAIL")
    void reportsOnlyEmailError() {
        EmployeeValidator validator = new EmployeeValidator();
        // Пошта "invalid", інші поля валідні. Очікується List.of("EMAIL").
        fail("Додайте власну перевірку");
    }

    @Test
    @DisplayName("BL-80 Єдина помилка TAX_ID")
    void reportsOnlyTaxIdError() {
        EmployeeValidator validator = new EmployeeValidator();
        // РНОКПП "01234A6789", інші поля валідні. Очікується List.of("TAX_ID").
        fail("Додайте власну перевірку");
    }

    @Test
    @DisplayName("BL-80 Єдина помилка HIRE_DATE")
    void reportsOnlyFutureHireDateError() {
        EmployeeValidator validator = new EmployeeValidator();
        // Дата найму TODAY.plusDays(1), інші поля валідні. Очікується List.of("HIRE_DATE").
        fail("Додайте власну перевірку");
    }

}
