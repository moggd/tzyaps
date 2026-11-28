# Чотири персональні коміти у GitHub Web

Після дозволу Марка опублікувати гілку `codex/sprints-3-5-audit` і надати кожному учасникові доступ на запис як collaborator репозиторію `moggd/tzyaps`. Учасники приймають запрошення у власних акаунтах. Доступ адміністратора не потрібен. Посилання нижче стане робочим після публікації гілки. [Права collaborator](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/repository-access-and-collaboration/permission-levels-for-a-personal-account-repository)

| Учасник | Завантажити лише цей готовий файл з локального пакета | Назва особистої гілки | Повідомлення коміту |
|---|---|---|---|
| Микуляк Марко | `LeaveAccrualContributionTest.java` | `contribution/marko-leave` | Add individual leave JUnit checks |
| Гавриш Роман | `PayrollContributionTest.java` | `contribution/roman-payroll` | Add individual payroll JUnit checks |
| Дарнопих Артем | `EmployeeFieldsContributionTest.java` | `contribution/artem-employee-fields` | Add individual employee field JUnit checks |
| Лебідь Антон | `EmployeeErrorsContributionTest.java` | `contribution/anton-employee-errors` | Add individual employee validation error JUnit checks |

1. Увійти під власним GitHub-акаунтом і відкрити [папку тестів гілки досьє](https://github.com/moggd/tzyaps/tree/codex/sprints-3-5-audit/src/test/java/ua/kpi/tzyapz/personal).
2. Натиснути **Add file → Upload files**, вибрати свій готовий файл. За відсутності кнопки створити свою гілку з гілки досьє через меню гілок, відкрити ту саму папку й повторити.
3. Увести повідомлення коміту. Вибрати створення нової гілки, якщо ще не створили свою. Натиснути **Propose changes** або **Commit changes**, залежно від вибору в інтерфейсі.
4. Створити PR з особистої гілки в `codex/sprints-3-5-audit`. У вкладці **Commits** перевірити, що коміт пов’язаний із власним акаунтом. Передати Марку посилання на PR.
5. Марко звіряє кожну зміну із SHA-256 перевірених файлів, зливає через **Create a merge commit**, повторює повний JUnit-прогін на двох версіях і оновлює докази, якщо є зміни.

Перевірені готові Java-файли передаються учасникам окремим ZIP. Папка шаблонів має лише початкові заготовки. [SHA-256 перевірених файлів](individual-junit.md) · [Вебзавантаження](https://docs.github.com/en/repositories/working-with-files/managing-files/adding-a-file-to-a-repository) · [Збереження комітів у PR](https://docs.github.com/en/pull-requests/reference/pull-request-merges)
