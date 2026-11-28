package ua.kpi.tzyapz.personal.ui;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Tag("ui")
class OrangeHrmUiTest {
    private static final String DEMO = "https://opensource-demo.orangehrmlive.com";
    private static final By USERNAME = By.name("username");
    private static final By PASSWORD = By.name("password");
    private static final By SUBMIT = By.cssSelector("button[type='submit']");
    private static final By DASHBOARD = By.xpath("//h6[normalize-space()='Dashboard']");
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void openLogin() {
        ChromeOptions options = new ChromeOptions();
        if (!Boolean.getBoolean("ui.visible")) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=1440,960", "--lang=en");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get(DEMO);
        visible(USERNAME);
    }

    @AfterEach
    void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    private WebElement visible(By locator) {
        return wait.until(visibilityOfElementLocated(locator));
    }

    private void click(By locator) {
        wait.until(elementToBeClickable(locator)).click();
    }

    private static By button(String text) {
        return By.xpath("//button[normalize-space()='" + text + "']");
    }

    private static By fieldGroup(String label) {
        return By.xpath("//div[contains(@class,'oxd-input-group')][.//label[normalize-space()='" + label + "']]");
    }

    private String displayedCredential(String label) {
        String text = visible(By.xpath("//p[starts-with(normalize-space(),'" + label + " :')]")).getText();
        return text.substring(text.indexOf(':') + 1).trim();
    }

    private void signIn() {
        visible(USERNAME).sendKeys(displayedCredential("Username"));
        visible(PASSWORD).sendKeys(displayedCredential("Password"));
        click(SUBMIT);
        visible(DASHBOARD);
    }

    private void signOut() {
        click(By.cssSelector(".oxd-userdropdown-tab"));
        click(By.linkText("Logout"));
        visible(USERNAME);
        assertTrue(driver.getCurrentUrl().endsWith("/auth/login"));
    }

    private void addUser() {
        signIn();
        click(By.linkText("Admin"));
        click(button("Add"));
        visible(fieldGroup("User Role"));
    }

    @Test
    @DisplayName("TC-001 · F-10, GUI-10, GUI-30 · Вхід адміністратора та вихід")
    void validLoginAndLogout() {
        assertAll("Форма входу",
                () -> assertTrue(visible(By.cssSelector(".orangehrm-login-branding img")).isDisplayed()),
                () -> assertEquals("Username", visible(USERNAME).getAttribute("placeholder")),
                () -> assertEquals("password", visible(PASSWORD).getAttribute("type")),
                () -> assertEquals("Password", visible(PASSWORD).getAttribute("placeholder")),
                () -> assertEquals("Login", visible(SUBMIT).getText().trim()));
        signIn();
        assertTrue(driver.getCurrentUrl().endsWith("/dashboard/index"));
        for (String module : List.of("PIM", "Leave", "Time", "Recruitment", "My Info", "Admin")) {
            assertTrue(visible(By.linkText(module)).isDisplayed(), module);
        }
        signOut();
    }

    @Test
    @DisplayName("TC-002 · F-20 · Відмова у вході з неправильним паролем")
    void invalidPassword() {
        visible(USERNAME).sendKeys(displayedCredential("Username"));
        visible(PASSWORD).sendKeys("wrongpass123");
        click(SUBMIT);
        assertEquals("Invalid credentials", visible(By.cssSelector("[role='alert'] p")).getText());
        assertAll("Форма залишається доступною",
                () -> assertTrue(driver.getCurrentUrl().endsWith("/auth/login")),
                () -> assertTrue(visible(SUBMIT).isDisplayed()));
    }

    @Test
    @DisplayName("TC-004 · F-30 · Username із чотирьох символів")
    void usernameBelowMinimum() {
        addUser();
        WebElement usernameGroup = visible(fieldGroup("Username"));
        usernameGroup.findElement(By.cssSelector("input")).sendKeys("usr4", Keys.TAB);
        click(SUBMIT);
        wait.until(d -> usernameGroup.getText().contains("Should be at least 5 characters"));
        assertTrue(driver.getCurrentUrl().endsWith("/admin/saveSystemUser"));
        signOut();
    }

    @Test
    @DisplayName("TC-009 · F-60 · Вкладки профілю працівника")
    void employeeProfileTabs() {
        signIn();
        click(By.linkText("My Info"));
        for (String tab : List.of("Personal Details", "Contact Details", "Emergency Contacts", "Dependents",
                "Immigration", "Job", "Salary", "Report-to", "Qualifications", "Memberships")) {
            assertTrue(visible(By.linkText(tab)).isDisplayed(), tab);
        }
        for (String tab : List.of("Personal Details", "Contact Details", "Job")) {
            click(By.linkText(tab));
            String heading = tab.equals("Job") ? "Job Details" : tab;
            visible(By.xpath("//h6[normalize-space()='" + heading + "']"));
        }
        signOut();
    }

    @Test
    @DisplayName("TC-020 · GUI-40, U-10 · Порожня форма додавання працівника")
    void employeeNameRequired() {
        signIn();
        click(By.linkText("PIM"));
        click(By.linkText("Add Employee"));
        WebElement label = visible(By.xpath("//label[normalize-space()='Employee Full Name']"));
        String marker = (String) ((JavascriptExecutor) driver).executeScript(
                "return getComputedStyle(arguments[0],'::after').content", label);
        assertTrue(label.getText().contains("*") || (marker != null && marker.contains("*")), "Видима зірочка обов'язкової групи");
        click(SUBMIT);
        for (String field : List.of("firstName", "lastName")) {
            By warning = By.xpath("//input[@name='" + field + "']/ancestor::div[contains(@class,'oxd-input-group')][1]"
                    + "//span[normalize-space()='Required']");
            assertEquals("Required", visible(warning).getText());
        }
        assertTrue(driver.getCurrentUrl().endsWith("/pim/addEmployee"));
        signOut();
    }

    @Test
    @DisplayName("TC-032 · GUI-40, U-10 · Порожня форма входу")
    void emptyLoginFieldsAreRequired() {
        click(SUBMIT);
        By required = By.xpath("//span[normalize-space()='Required']");
        wait.until(numberOfElementsToBe(required, 2));
        assertAll("Форма входу",
                () -> assertTrue(visible(USERNAME).isDisplayed()),
                () -> assertTrue(visible(PASSWORD).isDisplayed()),
                () -> assertTrue(driver.getCurrentUrl().endsWith("/auth/login")));
    }
}
