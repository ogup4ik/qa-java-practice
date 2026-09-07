import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import pages.Inventory;
import pages.LoginPage;

public class Swag extends open {
        @DataProvider(name = "loginData")
        public Object[][] loginData() {
            return new Object[][]{
                    {"Ogup4ik", "172y7uyf7"},
                    {"Ogupchik", "difwihdfojweokfj"},
                    {"standard_user", "secret_sauce"}
            };
        }
    @Test(priority = 1)
    public void Test1(){
        WebElement logo = driver.findElement(By.className("login_logo"));
        if (logo.isDisplayed()) {
            System.out.println("Логотип є");
        }else {
            System.out.println("Логотипу немає");
        }
    }
    @Test(priority = 2,dataProvider = "loginData")
    public void loginTest(String login,String password){
        LoginPage page = new LoginPage(driver);
        page.login(login,password);
        if(driver.getCurrentUrl().contains("inventory.html")){
            System.out.println("Логін успішний");
        }else{
            WebElement error = driver.findElement(By.cssSelector("data-test='error'"));
            System.out.println("Помилка логіну");

        }
    }
    @Test(priority = 3)
    public void burgerMenu () {
        LoginPage page = new LoginPage(driver);
        page.login("standard_user", "secret_sauce");
        Inventory inventory = new Inventory(driver);
        inventory.openMenu();
        Assert.assertTrue(inventory.isMenuOpened());
    }

}