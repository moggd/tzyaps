# Покриття бізнес-логіки «Персонал+»

Джерело правил — SRS П3 §5, стор. 5–6, та журнал змін редакції 1.1 (верхня межа BL-50). Базовий набір створено за допомогою Codex. Подані учасниками класи перевірено в окремій інтеграції.

| Вимога | Правило та дані | JUnit |
|---|---|---|
| BL-10 | 2 дні за місяць, максимум 24; 11/12/13 міс., 0 і −1 | LeaveCalculatorTest.accrualCapsAtTwentyFour, rejectsNegativeMonths, keepsAnnualCapAfterTwoYears |
| BL-20 | min(залишок, 5); 4/5/6 днів, 0 і −1 | LeaveCalculatorTest.carryOverCapsAtFive, rejectsNegativeRemainder, capsFullUnusedAnnualAllowance |
| BL-30 | Обидві дати включно, Пн–Пт; один день, перехід через вихідні, нуль робочих днів, інверсія та null | LeaveCalculatorTest.countsWeekdaysInclusively, rejectsInvalidInterval, countsCalendarWeekdaysAcrossNewYear |
| BL-40 | 1 ≤ тривалість ≤ баланс; −1/0/1, 4/5/6 за балансу 5, нульовий баланс | LeaveCalculatorTest.requiresPositiveDurationWithinBalance, allowsMinimumDurationWithExactBalance |
| BL-50 | 0,77 × gross; HALF_UP; нуль, дробова сума, межа ±0,01, від’ємна сума та null | PayrollCalculatorTest.deductsBothTaxesFromGross, rejectsGrossAboveLimit, rejectsInvalidGross, roundsNetUpAtHalfCent |
| BL-60 | monthly / 168 з HALF_UP; 0,83/0,84/0,85 навколо округлення, типові оклади, null та від’ємне число | PayrollCalculatorTest.roundsHourlyRate, rejectsInvalidMonthlySalary, roundsHourlyHalfCentUp |
| BL-70 | Округлена ставка × 1,5 × hours; цілі й дробові години, нулі, HALF_UP, null та від’ємні аргументи | PayrollCalculatorTest.overtimeUsesRoundedHourlyRate, rejectsInvalidOvertimeInputs, usesHalfUpHourlyRateInOvertime, roundsFractionalOvertimeUpAtHalfCent |
| BL-80 | Формат пошти, довжина зони 1/2/3, РНОКПП 9/10/11, зайві символи, дата найму ±1 день, вік ±1 день від 16-річчя, коди помилок, null | EmployeeValidatorTest.validatesEmail, requiresTenTaxIdDigits, hireDateCannotBeInFuture, requiresFullSixteenYears, rejectsMissingDates, validRecordHasNoErrors, returnsEveryApplicableError, rejectsSpaceInEmailLocalPart, acceptsSixteenthBirthdayAcrossYears, returnsOnlyEmailAndAgeErrors, returnsOnlyTaxIdAndHireDateErrors |

Розширений набір охоплює 33 методи й 83 виклики. Додано перехід року, мінімальний точний баланс, округлення половини копійки у трьох правилах, складений набір помилок і перевірки полів BL-80. Висновки про відхилення див. у [протоколі](surefire-summary.md).

## Подані класи та особиста рецензія

| Клас | Вимоги | Автор | Отримана рецензія 28.11.2026 |
|---|---|---|---|
| LeaveAccrualContributionTest | BL-10, BL-20, BL-30 | Микуляк Марко | Лебідь Антон, погоджено |
| PayrollContributionTest | BL-50, BL-60, BL-70 | Гавриш Роман | Микуляк Марко, погоджено |
| EmployeeFieldsContributionTest | BL-80 | Дарнопих Артем | Гавриш Роман і Микуляк Марко, погоджено |
| EmployeeErrorsContributionTest | BL-80 | Лебідь Антон | Дарнопих Артем і Микуляк Марко, погоджено |

Інтеграція охопила 45 методів, 95 викликів на версію. Особисті коміти й рецензії на базові класи в актуальній редакції обліковуються окремо. [Звіряння внесків](team/individual-junit.md) · [Журнал рецензій](team/review-confirmations.md)

[Розподіл рецензування базових класів](team/base-test-reviews.md).
