# Персонал+ · Досьє якості бригади С

Репозиторій П3 «Персонал+», ФБ-46. [Трекер дефектів](https://github.com/moggd/tzyaps/issues).

- [Спринт 1. Продукт, беклог і процеси](docs/sprint1/product.md)
- [Спринт 2. Вимоги та стратегія](docs/sprint2/SRS-1.1.md)
- [Спринт 3. Кейси, прогони і дефекти](docs/sprint3/README.md)
- [Спринт 4. Автоматизовані перевірки](docs/sprint4/README.md)
- [Спринт 5. Регресія та готовність](docs/sprint5/README.md)
- [Команда і ротація](docs/team/charter.md) · [власні тести та рецензування](docs/team/participation.md)

## Відтворення автоматизованих перевірок

Потрібні Python 3, JDK 17, Maven, Chrome для WebDriver та доступ до demo. Завантажте оригінальні ZIP спринтів 4 і 5 з курсу у `_materials/`. Скрипт перевіряє SHA-256 і розпаковує лише модуль `personal`. Файли модуля залишаються локально. Підготовка v2 копіює актуальні тестові файли з тієї самої копії Git.

```sh
mvn -v
python3 scripts/prepare-module.py v1 _materials/*4_code.zip
mvn clean test
mvn -Dtest=OrangeHrmUiTest -DexcludedGroups=none test
python3 scripts/prepare-module.py v2 _materials/*5_code.zip
mvn -f .qa-local/v2/pom.xml clean test
```

На macOS із Homebrew встановіть JDK 17 через формулу `openjdk@17` і вкажіть його шлях у `JAVA_HOME`, якщо `mvn -v` показує іншу версію. Для Selenium IDE відкрийте файл `selenium-ide/personal.side` і запустіть TC032 Empty Login. Підсумок v1/v2 з фактичними падіннями — [протокол](docs/surefire-summary.md).

Тести розроблено за допомогою Codex. Особисті внески, рецензування та захист підтверджує команда.
