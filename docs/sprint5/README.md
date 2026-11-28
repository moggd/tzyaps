# Досьє якості · Спринт 5

- [План і критерії випуску](regression-plan.md)
- [Журнал регресії](regression-log.xlsx)
- [Матриця простежуваності](traceability-matrix.xlsx)
- [Повторна перевірка дефектів](defects-regression.md)
- [Звіт про якість](quality-report.pdf) · [редагований DOCX](quality-report.docx)
- [Презентація до захисту](presentation.pdf)

- [Технічна рецензія](technical-review.md) · [Чекліст рецензента](review-checklist.md) · [Пакет GitHub Issues](issues-publication.md)
- [Завдання та доповідачі](tasks.md) · [Ретроспектива семестру](retro-semester.md)
- [Підсумковий аудит](final-audit.md)

У тимчасовій інтеграції з чотирма персональними класами зіставлено 149 пар. Початковий набір — 116 Passed, 31 Failed, 2 Blocked. У регресії — 128 Passed, 19 Failed, 2 Blocked. Pass rate — 87,1%. Відкрита регресія MOD-008 і невиконаний поріг pass rate обґрунтовують No-Go для продукту.

Окреме [відтворення сценарію Selenium IDE](ui/selenium-ide-recorded-replay.log) завершилось успішно. У 149 пар враховано підтверджені браузерні та WebDriver-прогони і новий інтеграційний JUnit-прогін. Роман підтвердив 128/19/2 і No-Go, Артем — 87,1%. Підтвердження передав Марко. Після злиття персональних комітів належить повторити JUnit з гілки. [Авторські внески](../team/individual-junit.md)
