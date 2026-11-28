# Чотири персональні коміти у GitHub Web

Учасник входить у власний GitHub-акаунт з доступом на запис до `moggd/tzyaps`. Якщо доступу ще немає, власник відкриває [Settings → Collaborators](https://github.com/moggd/tzyaps/settings/access), натискає **Add people**, обирає GitHub-логін і надсилає запрошення. Учасник приймає його під своїм акаунтом. [Як запросити collaborator](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/repository-access-and-collaboration/inviting-collaborators-to-a-personal-repository)

| Учасник | Завантажити лише цей готовий файл з локального пакета | Назва особистої гілки | Повідомлення коміту |
|---|---|---|---|
| Микуляк Марко | `LeaveAccrualContributionTest.java` | `contribution/marko-leave` | Add individual leave JUnit checks |
| Гавриш Роман | `PayrollContributionTest.java` | `contribution/roman-payroll` | Add individual payroll JUnit checks |
| Дарнопих Артем | `EmployeeFieldsContributionTest.java` | `contribution/artem-employee-fields` | Add individual employee field JUnit checks |
| Лебідь Антон | `EmployeeErrorsContributionTest.java` | `contribution/anton-employee-errors` | Add individual employee validation error JUnit checks |

1. Увійти під власним GitHub-акаунтом і відкрити [папку тестів гілки досьє](https://github.com/moggd/tzyaps/tree/codex/sprints-3-5-audit/src/test/java/ua/kpi/tzyapz/personal).
2. Натиснути **Add file → Upload files**, вибрати свій готовий файл. Якщо гілка досьє захищена й завантаження в ній недоступне, створити особисту гілку від гілки досьє через меню гілок, відкрити ту саму папку й повторити.
3. Увести повідомлення коміту. Вибрати створення нової гілки, якщо ще не створили свою. Натиснути **Propose changes** або **Commit changes**, залежно від вибору в інтерфейсі.
4. Відкрити своє посилання PR нижче. Перевірити **base** `codex/sprints-3-5-audit` і **compare** — свою гілку. У **Files changed** має бути один Java-файл. Натиснути **Create pull request**, використати повідомлення коміту як заголовок, ще раз натиснути **Create pull request**. У вкладці **Commits** звірити власний акаунт і передати Марку посилання.
5. Марко звіряє кожну зміну із SHA-256 перевірених файлів, зливає через **Create a merge commit**, повторює повний JUnit-прогін на двох версіях і оновлює докази, якщо є зміни.

Перевірені готові Java-файли передаються учасникам окремим ZIP. Папка шаблонів має лише початкові заготовки. [SHA-256 перевірених файлів](individual-junit.md) · [Вебзавантаження](https://docs.github.com/en/repositories/working-with-files/managing-files/adding-a-file-to-a-repository) · [Збереження комітів у PR](https://docs.github.com/en/pull-requests/reference/pull-request-merges)


## Прямі посилання для створення PR

- [Марко · contribution/marko-leave](https://github.com/moggd/tzyaps/compare/codex/sprints-3-5-audit...contribution/marko-leave?expand=1)
- [Роман · contribution/roman-payroll](https://github.com/moggd/tzyaps/compare/codex/sprints-3-5-audit...contribution/roman-payroll?expand=1)
- [Артем · contribution/artem-employee-fields](https://github.com/moggd/tzyaps/compare/codex/sprints-3-5-audit...contribution/artem-employee-fields?expand=1)
- [Антон · contribution/anton-employee-errors](https://github.com/moggd/tzyaps/compare/codex/sprints-3-5-audit...contribution/anton-employee-errors?expand=1)

Ці посилання відкриють порівняння після створення особистої гілки. Резервний шлях — **Pull requests → New pull request** та вибір тих самих base і compare.

## Робоче середовище

Розпакувати ZIP спринту 4 з курсу, відкрити термінал у `code/starter/` і виконати:

```sh
mvn -v
mvn test
```

Надіслати Марку в одному повідомленні рядок `Java version: 17...` і підсумок `Tests run: 7, Failures: 0, Errors: 0, Skipped: 0`. Це окрема вимога до робочого місця за методичкою С4, с. 15.

## Короткі відповіді на вже отримані підтвердження

- Роман. «Дякую. Зафіксував твоє підтвердження результатів регресії 128 Passed, 19 Failed, 2 Blocked і рішення No-Go».
- Артем. «Дякую. Зафіксував твоє підтвердження актуальних метрик і Pass Rate 87,1%».
- Антон. «Дякую. Зафіксував підтверджені ID: BUG-002, BUG-003, BUG-010, BUG-011, BUG-013, BUG-014, BUG-015, BUG-016».
