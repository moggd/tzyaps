# Дефекти Java-модуля v1

Середовище — оригінальний модуль personal 1.0.0, macOS 27.2.1, OpenJDK 17, Maven 3.10.2, JUnit 5.10.2, Surefire 3.2.5. Виконавець — Codex. Дата та повний протокол у [звіті Maven](../sprint5/surefire-v1/maven.log). Для відтворення виконати команду `mvn -Dtest=Клас#метод test` на v1 за [інструкцією](../../README.md). Перші шість причин встановлено за правилами початкової SRS, MOD-007 виявлено за зміною 1.1. ID локальні до реєстрації в Issues.

| ID · вимога | Метод і вхід | Очікувано | Фактично на v1 | Severity / Priority та наслідок |
|---|---|---|---|---|
| MOD-001 · BL-10 | LeaveCalculatorTest#accrualCapsAtTwentyFour, 13 місяців | 24 | 26 | Major / P2. Річна квота завищена. |
| MOD-002 · BL-30 | LeaveCalculatorTest#countsWeekdaysInclusively, 07–11.09.2026 | 5 | 4 | Major / P2. Кінцевий робочий день не списується. Для одного робочого дня повертається 0. |
| MOD-003 · BL-50 | PayrollCalculatorTest#deductsBothTaxesFromGross, 10 000 грн | 7 700,00 грн | 7 790,00 грн | Critical / P2. Помилкова база військового збору змінює виплату. |
| MOD-004 · BL-60 | PayrollCalculatorTest#roundsHourlyRate, 25 000 грн | 148,81 грн | 148,80 грн | Minor / P3. Відхилення в копійках на годину накопичується при багаторазовому розрахунку. |
| MOD-005 · BL-80 | EmployeeValidatorTest#requiresTenTaxIdDigits, 012345678 | false | true | Major / P2. До картки може пройти неповний РНОКПП. |
| MOD-006 · BL-80 | EmployeeValidatorTest#requiresFullSixteenYears, народження 07.09.2010, найм 06.09.2026 | false | true | Major / P2. Перевірка пропускає найм до досягнення вікової межі. |
| MOD-007 · BL-50 (1.1) | PayrollCalculatorTest#rejectsGrossAboveLimit, 10 000 000,01 грн | IllegalArgumentException | Обчислення завершилося без винятку | Major / P2. Модуль обчислює виплату за межами явно встановленого діапазону. |
