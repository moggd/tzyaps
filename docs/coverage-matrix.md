# Покриття бізнес-логіки «Персонал+»

Джерело правил — SRS П3 §5, стор. 5–6, та журнал змін редакції 1.1 (верхня межа BL-50). Набір створено за допомогою Codex. Особисте рецензування колегами очікує підтвердження.

| Вимога | Правило та дані | JUnit |
|---|---|---|
| BL-10 | 2 дні за місяць, максимум 24; 11/12/13 міс., 0 і −1 | LeaveCalculatorTest.accrualCapsAtTwentyFour, rejectsNegativeMonths |
| BL-20 | min(залишок, 5); 4/5/6 днів, 0 і −1 | LeaveCalculatorTest.carryOverCapsAtFive, rejectsNegativeRemainder |
| BL-30 | Обидві дати включно, Пн–Пт; один день, перехід через вихідні, нуль робочих днів, інверсія та null | LeaveCalculatorTest.countsWeekdaysInclusively, rejectsInvalidInterval |
| BL-40 | 1 ≤ тривалість ≤ баланс; −1/0/1, 4/5/6 за балансу 5, нульовий баланс | LeaveCalculatorTest.requiresPositiveDurationWithinBalance |
| BL-50 | 0,77 × gross; HALF_UP; нуль, дробова сума, межа ±0,01, від’ємна сума та null | PayrollCalculatorTest.deductsBothTaxesFromGross, rejectsGrossAboveLimit, rejectsInvalidGross |
| BL-60 | monthly / 168 з HALF_UP; 0,83/0,84/0,85 навколо округлення, типові оклади, null та від’ємне число | PayrollCalculatorTest.roundsHourlyRate, rejectsInvalidMonthlySalary |
| BL-70 | Округлена ставка × 1,5 × hours; цілі й дробові години, нулі, HALF_UP, null та від’ємні аргументи | PayrollCalculatorTest.overtimeUsesRoundedHourlyRate, rejectsInvalidOvertimeInputs |
| BL-80 | Формат пошти, довжина зони 1/2/3, РНОКПП 9/10/11, зайві символи, дата найму ±1 день, вік ±1 день від 16-річчя, коди помилок, null | EmployeeValidatorTest.validatesEmail, requiresTenTaxIdDigits, hireDateCannotBeInFuture, requiresFullSixteenYears, rejectsMissingDates, validRecordHasNoErrors, returnsEveryApplicableError |
