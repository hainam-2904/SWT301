package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Registration Form - demoqa.com")
public class RegistrationTest extends BaseTest {
    static RegistrationPage formPage;

    @BeforeAll
    static void init() {
        formPage = new RegistrationPage(driver);
    }

    @Test
    @Order(1)
    @DisplayName("Should submit registration form successfully")
    void testSubmitRegistrationForm() {
        formPage.navigate();

        formPage.fillForm(
                "John",
                "Doe",
                "john.doe@example.com",
                "0123456789",
                "123 Sample Street",
                System.getProperty("user.dir") + "/src/test/resources/test-image.png"
        );

        formPage.submit();

        assertTrue(formPage.isSubmissionSuccessful(), "Form was not submitted successfully.");
    }
    @AfterAll
    static void tearDown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
