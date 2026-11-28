# Протокол запуску JUnit

28.11.2026, macOS 27.2.1, JDK 17, Maven 3.10.2, JUnit 5.10.2. Початковий `code/starter` — 7 пройшли, 0 падінь. Власний набір — [21 тест-метод](coverage-matrix.md), 71 запуск на версію з урахуванням параметризації.

| Версія | Passed | Failed | Errors | Skipped | Доказ |
|---|---:|---:|---:|---:|---|
| personal v1 | 57 | 14 | 0 | 0 | [Surefire v1](sprint5/surefire-v1/) |
| personal v2 | 65 | 6 | 0 | 0 | [Surefire v2](sprint5/surefire-v2/) |

Команди `mvn clean test` і `mvn -f .qa-local/v2/pom.xml clean test` завершилися ненульовим кодом через невдалі твердження. Падіння v1 охоплюють [сім дефектів](sprint4/module-defects.md). Повторна перевірка встановила [чотири виправлення, три відтворені дефекти й одну регресію](sprint5/defects-regression.md). Протокол стосується Java-модуля, прогони WebDriver оформлено окремо.
