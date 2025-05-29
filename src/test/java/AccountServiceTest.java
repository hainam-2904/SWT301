import hnam.example.AccountService;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {

    AccountService service;

    @BeforeEach
    void init() {
        service = new AccountService();
    }

    @Test
    void testRegisterFromCSV() throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("test-data.csv");
        assertNotNull(is, "Không tìm thấy file test-data.csv");

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        File output = new File("target/test-output/UnitTest.csv");
        output.getParentFile().mkdirs();
        System.out.println("Ghi kết quả vào: " + output.getAbsolutePath());

        BufferedWriter writer = new BufferedWriter(new FileWriter(output));
        writer.write("username,password,email,expected,result\n");

        String line = reader.readLine(); // bỏ qua tiêu đề
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String username = parts[0];
            String password = parts[1];
            String email = parts[2];
            boolean expected = Boolean.parseBoolean(parts[3]);

            boolean result = service.registerAccount(username, password, email);
            writer.write(String.join(",", username, password, email, String.valueOf(expected), String.valueOf(result)) + "\n");

            assertEquals(expected, result);
        }

        reader.close();
        writer.close();
    }

    @Test
    void testInvalidEmails() {
        assertFalse(service.isValidEmail("invalid@"));
        assertFalse(service.isValidEmail("no-domain.com"));
        assertFalse(service.isValidEmail("test@.com"));
    }

    @Test
    void testValidEmail() {
        assertTrue(service.isValidEmail("test@example.com"));
    }

    @Test
    void testShortPassword() {
        assertFalse(service.registerAccount("user", "123", "user@mail.com"));
    }

    @Test
    void testEmptyUsername() {
        assertFalse(service.registerAccount("", "password123", "email@example.com"));
    }
}
