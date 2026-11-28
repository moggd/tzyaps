# Сценарії публічного demo

Клас `OrangeHrmUiTest`, окремий Chrome на метод і явні очікування, тег `ui`. Автоматизовано визначені контрольні точки кейсів спринту 3.

| TC · метод | Дія і локатор | Перевірка |
|---|---|---|
| TC-001 · validLoginAndLogout | name=username, name=password, button[type=submit], назви модулів, меню Logout | Форма маскує пароль, відкривається Dashboard, видно ключові модулі, вихід повертає Login |
| TC-002 · invalidPassword | Ввести неправильний пароль один раз, чекати [role=alert] | Invalid credentials за F-20, форма доступна після відмови |
| TC-004 · usernameBelowMinimum | Admin → Add, поле Username під власним label, Save | Менше 5 символів відхилено, маршрут створення лишається |
| TC-009 · employeeProfileTabs | My Info, вкладки за linkText | Є 10 вкладок, Personal Details, Contact Details та Job відкривають свої розділи |
| TC-020 · employeeNameRequired | PIM → Add Employee, Save, помилки поряд з name=firstName і name=lastName | Позначка *, два Required, Add Employee лишається відкритою |
| TC-032 · emptyLoginFieldsAreRequired | Login, кнопка submit, видимі span Required | Два Required, поля й маршрут входу лишаються доступними |

[Тест Selenium IDE TC-032](../selenium-ide/personal.side) додано у форматі SIDE. Використано команди open, click, waitForElementVisible, assertElementPresent, assertText і verifyText. [Java-експорт](../selenium-ide/export/) створено офіційним експортером. Відтворення виконано [Selenium IDE SIDE Runner](sprint4/ui/selenium-ide.log) з одним воркером. У [графічному Selenium IDE](sprint4/ui/selenium-ide-desktop.log) перевірено початкові дев’ять команд. Пізніше натискання Login записано в режимі Record і додано на місце кроку Click. Основний локатор уточнено. [Запис](sprint4/ui/selenium-ide-record.log) · [перший запуск з тайм-аутом](sprint4/ui/selenium-ide-first-replay.log) · [успішне відтворення С4](sprint4/ui/selenium-ide-recorded-replay.log) · [незалежне відтворення С5](sprint5/ui/selenium-ide-recorded-replay.log).

Результати WebDriver — [С4](sprint4/ui/maven.log) і [С5](sprint5/ui/maven.log).
