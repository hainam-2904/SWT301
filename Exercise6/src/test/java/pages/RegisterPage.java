package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // OTP input step
    private By emailInput = By.name("email");
    private By submitButton = By.cssSelector("button[type='submit']");
    private By toastMessage = By.className("Toastify__toast");

    // Registration form selectors
    private By nameInput = By.name("name");
    private By phoneInput = By.name("phone");
    private By dobInput = By.name("date_of_birth");
    private By genderSelect = By.name("gender");
    private By passwordInput = By.name("password");
    private By confirmPasswordInput = By.name("confirmPassword");
    private By registerSubmitButton = By.cssSelector("button[type='submit']");

    public void navigate() {
        driver.get("http://localhost:3000/auth/user-register");
    }

    public void sendOtp(String email) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(submitButton).click();
    }

    public void fillRegistrationForm() {
        driver.findElement(nameInput).sendKeys("ahihihi");
        driver.findElement(phoneInput).sendKeys("0912345678");
        driver.findElement(dobInput).sendKeys("2000-01-01");
        new Select(driver.findElement(genderSelect)).selectByValue("male");
        driver.findElement(passwordInput).sendKeys("Test@1234");
        driver.findElement(confirmPasswordInput).sendKeys("Test@1234");
    }

    public void submitRegistrationForm() {
        driver.findElement(registerSubmitButton).click();
    }

    public By getToastMessage() {
        return toastMessage;
    }
}
