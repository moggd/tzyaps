# Спринт 3 — симуляційний реєстр дефектів

> **УВАГА:** наведені результати є навчальною моделлю, а не реальним виконанням OrangeHRM. Жоден `SIM-BUG` не є підтвердженим дефектом продукту чи опублікованим GitHub Issue. Два реальні GitHub Issues існували до цього пакета.

Кандидатів у модельному реєстрі: **9** (Major 3, Normal 4, Minor 2). Фактичних створених цим пакетом Issues: **0**.

| ID | Severity | Priority | TC | SRS | GitHub | Evidence status |
|---|---|---|---|---|---|---|
| BUG-001 | Major | P2 | TC-018, TC-023 | F-130 | https://github.com/moggd/tzyaps/issues/2 | existing - historical issue; evidence partial |
| BUG-002 | Major | P3 | TC-006 | F-30 | https://github.com/moggd/tzyaps/issues/1 | existing - visually supported older evidence |
| BUG-003 | Major | P3 | TC-022 | GUI-50, S-10 | Не створено | simulation-only; original screenshot proves indicator, not save |
| SIM-BUG-004 | Normal | P3 | TC-010 | F-70, BL-30 | Не створено | counterfactual only; TC-010 main modeled run PASSED |
| SIM-BUG-005 | Normal | P3 | TC-025 | F-30 | Не створено | counterfactual only; TC-025 main modeled run PASSED |
| SIM-BUG-006 | Minor | P4 | TC-007 | GUI-60 | Не створено | counterfactual only; not validated |
| SIM-BUG-007 | Normal | P3 | TC-027 | F-100, GUI-40 | Не створено | counterfactual only; not validated |
| SIM-BUG-008 | Minor | P4 | TC-028 | F-130, GUI-40 | Не створено | counterfactual only; not validated |
| SIM-BUG-009 | Normal | P3 | TC-029 | F-90 | Не створено | counterfactual only; not validated |

## BUG-001 — XML-експорт відсутній на Edit Vacancy

- **Severity:** Major; **Priority:** P2; **Test cases:** TC-018, TC-023; **SRS:** F-130.
- **Передумови / кроки:** див. відповідний кейс у `test-cases.xlsx` і `execution-log.xlsx`.
- **Очікувано:** XML для ручного експорту має завантажуватися.
- **Симуляційна поведінка або альтернативна гіпотеза:** Симуляція: активна вакансія збережена, XML-контроль відсутній.
- **Статус доказу:** existing - historical issue; evidence partial.
- **Issue:** https://github.com/moggd/tzyaps/issues/2.
- **Зображення:** відповідний `attachments/TC-XXX-simulation.png` — синтетична ілюстрація, не скрін реального стенду.

## BUG-002 — Збереження Username із кирилицею та _

- **Severity:** Major; **Priority:** P3; **Test cases:** TC-006; **SRS:** F-30.
- **Передумови / кроки:** див. відповідний кейс у `test-cases.xlsx` і `execution-log.xlsx`.
- **Очікувано:** Лише латинські літери та цифри, Save заблоковано.
- **Симуляційна поведінка або альтернативна гіпотеза:** Симуляція: тест_юзер1 створено.
- **Статус доказу:** existing - visually supported older evidence.
- **Issue:** https://github.com/moggd/tzyaps/issues/1.
- **Зображення:** відповідний `attachments/TC-XXX-simulation.png` — синтетична ілюстрація, не скрін реального стенду.

## BUG-003 — Дозволене збереження слабкого пароля

- **Severity:** Major; **Priority:** P3; **Test cases:** TC-022; **SRS:** GUI-50, S-10.
- **Передумови / кроки:** див. відповідний кейс у `test-cases.xlsx` і `execution-log.xlsx`.
- **Очікувано:** Форма блокує слабкий пароль.
- **Симуляційна поведінка або альтернативна гіпотеза:** Симуляція: password1 збережено (9 символів без uppercase/special).
- **Статус доказу:** simulation-only; original screenshot proves indicator, not save.
- **Issue:** відсутній; новий Issue не створювався.
- **Зображення:** відповідний `attachments/TC-XXX-simulation.png` — синтетична ілюстрація, не скрін реального стенду.

## SIM-BUG-004 — Неправильна тривалість п’ятниця–понеділок

- **Severity:** Normal; **Priority:** P3; **Test cases:** TC-010; **SRS:** F-70, BL-30.
- **Передумови / кроки:** див. відповідний кейс у `test-cases.xlsx` і `execution-log.xlsx`.
- **Очікувано:** П’ятниця+понеділок=2.00.
- **Симуляційна поведінка або альтернативна гіпотеза:** Альтернативна гіпотеза: 4.00 замість 2.00.
- **Статус доказу:** counterfactual only; TC-010 main modeled run PASSED.
- **Issue:** відсутній; новий Issue не створювався.
- **Зображення:** відповідний `attachments/TC-XXX-simulation.png` — синтетична ілюстрація, не скрін реального стенду.

## SIM-BUG-005 — Пробіл у Username пропущено

- **Severity:** Normal; **Priority:** P3; **Test cases:** TC-025; **SRS:** F-30.
- **Передумови / кроки:** див. відповідний кейс у `test-cases.xlsx` і `execution-log.xlsx`.
- **Очікувано:** Пробіл відхиляється.
- **Симуляційна поведінка або альтернативна гіпотеза:** Альтернативна гіпотеза: qauser 26 збережено.
- **Статус доказу:** counterfactual only; TC-025 main modeled run PASSED.
- **Issue:** відсутній; новий Issue не створювався.
- **Зображення:** відповідний `attachments/TC-XXX-simulation.png` — синтетична ілюстрація, не скрін реального стенду.

## SIM-BUG-006 — Перекриття стовпців при 100% zoom

- **Severity:** Minor; **Priority:** P4; **Test cases:** TC-007; **SRS:** GUI-60.
- **Передумови / кроки:** див. відповідний кейс у `test-cases.xlsx` і `execution-log.xlsx`.
- **Очікувано:** Колонки читаються, скрол працює.
- **Симуляційна поведінка або альтернативна гіпотеза:** Альтернативна гіпотеза: текст перекривається.
- **Статус доказу:** counterfactual only; not validated.
- **Issue:** відсутній; новий Issue не створювався.
- **Зображення:** відповідний `attachments/TC-XXX-simulation.png` — синтетична ілюстрація, не скрін реального стенду.

## SIM-BUG-007 — Assign без To Date

- **Severity:** Normal; **Priority:** P3; **Test cases:** TC-027; **SRS:** F-100, GUI-40.
- **Передумови / кроки:** див. відповідний кейс у `test-cases.xlsx` і `execution-log.xlsx`.
- **Очікувано:** Required; збереження заблоковано.
- **Симуляційна поведінка або альтернативна гіпотеза:** Альтернативна гіпотеза: неповні дані збережено.
- **Статус доказу:** counterfactual only; not validated.
- **Issue:** відсутній; новий Issue не створювався.
- **Зображення:** відповідний `attachments/TC-XXX-simulation.png` — синтетична ілюстрація, не скрін реального стенду.

## SIM-BUG-008 — Vacancy без назви

- **Severity:** Minor; **Priority:** P4; **Test cases:** TC-028; **SRS:** F-130, GUI-40.
- **Передумови / кроки:** див. відповідний кейс у `test-cases.xlsx` і `execution-log.xlsx`.
- **Очікувано:** Required; збереження заблоковано.
- **Симуляційна поведінка або альтернативна гіпотеза:** Альтернативна гіпотеза: порожнє Vacancy Name прийнято.
- **Статус доказу:** counterfactual only; not validated.
- **Issue:** відсутній; новий Issue не створювався.
- **Зображення:** відповідний `attachments/TC-XXX-simulation.png` — синтетична ілюстрація, не скрін реального стенду.

## SIM-BUG-009 — Reject не зберігає коментар

- **Severity:** Normal; **Priority:** P3; **Test cases:** TC-029; **SRS:** F-90.
- **Передумови / кроки:** див. відповідний кейс у `test-cases.xlsx` і `execution-log.xlsx`.
- **Очікувано:** Коментар збережено.
- **Симуляційна поведінка або альтернативна гіпотеза:** Альтернативна гіпотеза: статус Rejected без коментаря.
- **Статус доказу:** counterfactual only; not validated.
- **Issue:** відсутній; новий Issue не створювався.
- **Зображення:** відповідний `attachments/TC-XXX-simulation.png` — синтетична ілюстрація, не скрін реального стенду.

## Історичні BUG-004…BUG-009

Історичні твердження Run 1 не зникають і не підтверджуються цим симуляційним звітом. Із вихідного `evidence-review.md`: BUG-004 не підтверджений; BUG-005 частково; BUG-006 не доведений як вимога SRS; BUG-007 доказ відсутній; BUG-008 і BUG-009 не підтверджені. `SIM-BUG-*` — окремі альтернативні сценарії, не продовження їхньої історії.
