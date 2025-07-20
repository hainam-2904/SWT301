package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By genderMale = By.xpath("//label[text()='Male']");
    private final By mobile = By.id("userNumber");
    private final By hobbiesSports = By.xpath("//label[text()='Sports']");
    private final By uploadPicture = By.id("uploadPicture");
    private final By currentAddress = By.id("currentAddress");
    private final By stateDropdown = By.id("react-select-3-input");
    private final By cityDropdown = By.id("react-select-4-input");
    private final By submitButton = By.id("submit");

    private final By confirmationModal = By.id("example-modal-sizes-title-lg");
    private final By closePopupAd = By.id("close-fixedban");

    public void navigate() {
        navigateTo("https://demoqa.com/automation-practice-form");

        // Thử đóng popup nếu có
        try {
            driver.switchTo().frame("google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0");
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", driver.findElement(By.tagName("iframe")));
            driver.switchTo().defaultContent();
        } catch (Exception ignored) {}

        try {
            click(closePopupAd);
        } catch (Exception ignored) {}
    }

    public void fillForm(String fName, String lName, String emailAddr, String phone, String address, String filePath) {
        type(firstName, fName);
        type(lastName, lName);
        type(email, emailAddr);
        click(genderMale);
        type(mobile, phone);
        click(hobbiesSports);
        type(uploadPicture, filePath);
        type(currentAddress, address);
        selectDropdown(stateDropdown, "NCR");
        selectDropdown(cityDropdown, "Delhi");
    }

    public void submit() {
        click(submitButton);
    }

    public boolean isSubmissionSuccessful() {
        return isElementVisible(confirmationModal);
    }

    private void selectDropdown(By locator, String value) {
        waitForVisibility(locator).sendKeys(value);
        waitForVisibility(locator).sendKeys(Keys.ENTER);
    }
}
