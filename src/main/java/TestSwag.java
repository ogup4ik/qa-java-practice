import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
public class TestSwag {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logo = driver.findElement(By.className("login_logo"));
        if (logo.isDisplayed()) {
            System.out.println("Логотип є");
        }else {
            System.out.println("Логотипу немає");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='input_error form_input']"))).sendKeys("ogup4ik");
        System.out.println("Лонін водиться");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("12345678");
        System.out.println("Пароль водиться");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='submit-button btn_action']"))).click();
    }
}
