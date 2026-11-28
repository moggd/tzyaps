# Рецензування базових тест-класів · С4

Марко веде облік як рецензент С4. Особисті підтвердження для цих чотирьох класів ще очікуються. Отримані погодження чотирьох окремих авторських класів зафіксовано у [журналі](review-confirmations.md).

| Рецензент | Клас | Що звірити за §5.3 |
|---|---|---|
| Гавриш Роман | [LeaveCalculatorTest](../../src/test/java/ua/kpi/tzyapz/personal/LeaveCalculatorTest.java) | BL-10–BL-40, включення обох дат, рівність тривалості й балансу, MOD-002 і MOD-008. |
| Дарнопих Артем | [PayrollCalculatorTest](../../src/test/java/ua/kpi/tzyapz/personal/PayrollCalculatorTest.java) | BL-50–BL-70, суми з двома знаками, HALF_UP і межа gross за SRS 1.1. |
| Лебідь Антон | [EmployeeValidatorTest](../../src/test/java/ua/kpi/tzyapz/personal/EmployeeValidatorTest.java) | BL-80, межі довжини РНОКПП й віку, фіксовані дати, перелік помилок. |
| Микуляк Марко | [OrangeHrmUiTest](../../src/test/java/ua/kpi/tzyapz/personal/ui/OrangeHrmUiTest.java) | Відповідність TC-ID, явні очікування, чиста сесія і quit, використання власних тестових записів. |

Звірити назви, структуру кроків, незалежність і джерело очікуваного результату. Передати Марку одним рядком: `Клас · SHA у GitHub · дата · погоджено / конкретне зауваження`. Зауваження можна лишити в PR або Issue після погодження публікації. Огляд можна виконати в браузері GitHub. Експорт Selenium IDE лишається додатковим артефактом поза набором Maven.
