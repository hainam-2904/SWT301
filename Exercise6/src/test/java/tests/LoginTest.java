package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import pages.LoginPage;
import utils.DriverFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    static WebDriver driver;
    static LoginPage loginPage;
    static WebDriverWait wait;

    @BeforeAll
    static void setup() {
        driver = DriverFactory.createDriver();
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // tăng thời gian đợi
    }

    @Test
    void testLoginFail() {
        loginPage.navigate();
        loginPage.login("wrong@email.com", "wrongpass");

        WebElement alert = wait.until(ExpectedConditions
                .visibilityOfElementLocated(loginPage.getAlertBox()));

        assertTrue(alert.getText().toLowerCase().contains("mật khẩu")
                || alert.getText().toLowerCase().contains("sai"));
    }

    @Test
    void testLoginWithGoogle() {
        loginPage.navigate();

        loginPage.clickGoogleLogin(wait);

        System.out.println("🔒 Vui lòng hoàn tất đăng nhập Google thủ công trong vòng 60 giây...");
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.urlContains("localhost:3000"));

        assertTrue(driver.getCurrentUrl().contains("localhost:3000"));
    }


    @AfterAll
    static void tearDown() {
        if (driver != null) driver.quit();
    }
}
