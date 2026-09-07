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
import org.testng.annotations.DataProvider;
public class TestListSwag extends open {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"Ogup4ik", "172y7uyf7"},
                {"Ogupchik", "difwihdfojweokfj"},
                {"standard_user", "secret_sauce"}
        };
    }
    @Test
    public void Test1(){
        WebElement logo = driver.findElement(By.className("login_logo"));
        if (logo.isDisplayed()) {
            System.out.println("Логотип є");
        }else {
            System.out.println("Логотипу немає");
        }
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String login,String password){
            driver.findElement(By.id("user-name")).clear();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(login);
            driver.findElement(By.id("password")).clear();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();
            if (driver.getCurrentUrl().contains("pages.inventory")){
            }else {
                WebElement error = driver.findElement(By.cssSelector("data-test='error'"));
            }
        }
//    @Test
//    public void Test2 (){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='input_error form_input']"))).sendKeys("ogup4ik");
//        System.out.println("Login");
//    }
//    @Test
//    public void Test3 (){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("12345678");
//        System.out.println("Password");
//    }
}
