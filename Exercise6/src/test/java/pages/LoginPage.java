package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By alertBox = By.className("alert");

    // Nút đăng nhập Google dựa trên nội dung văn bản
    private By googleLoginButton = By.xpath("//span[contains(text(), 'Google') or contains(text(), 'Đăng nhập bằng Google')]");

    public void navigate() {
        driver.get("http://localhost:3000/auth/login");
    }

    public void login(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void clickGoogleLogin(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(googleLoginButton)).click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public By getAlertBox() {
        return alertBox;
    }
}
