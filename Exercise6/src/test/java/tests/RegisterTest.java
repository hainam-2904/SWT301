package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import pages.RegisterPage;
import utils.DriverFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterTest {
    static WebDriver driver;
    static RegisterPage registerPage;
    static WebDriverWait wait;

    @BeforeAll
    static void setup() {
        driver = DriverFactory.createDriver();
        registerPage = new RegisterPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void testFullRegisterFlow() {

        registerPage.navigate();
        registerPage.sendOtp("namrp103@gmail.com");

        System.out.println("👉 Vui lòng nhập OTP thủ công trong vòng 60 giây...");
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("name"))); // chờ input name

        registerPage.fillRegistrationForm();
        registerPage.submitRegistrationForm();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("/auth/login"));

        assertTrue(driver.getCurrentUrl().contains("/auth/login"));
        System.out.println("✅ Đăng ký thành công!");
    }


    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
