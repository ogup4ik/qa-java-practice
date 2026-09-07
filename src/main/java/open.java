import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;
public class open {
   protected WebDriver driver;
    protected WebDriverWait wait;

   @BeforeMethod
    public void openChrome(){
       ChromeOptions options = new ChromeOptions();
       Map<String, Object> prefs = new HashMap<>();
       prefs.put("credentials_enable_service", false);
       prefs.put("profile.password_manager_enabled", false);
       options.setExperimentalOption("prefs", prefs);
       options.addArguments("--incognito");
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver(options);
       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       driver.manage().window().maximize();
       driver.get("https://www.saucedemo.com");
    }
      @AfterMethod
      public void exitChrome(){
         if (driver !=null){
             driver.quit();
         }
   }
}
