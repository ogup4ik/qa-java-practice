package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Inventory {
        WebDriver driver;
        By productsTitle = By.className("title");
        By burgerMenu = By.id("react-burger-menu-btn");
        By cart = By.className("shopping_cart_link");
        By sort = By.className("product_sort_container");
        By logout = By.id("logout_sidebar_link");
        public Inventory(WebDriver driver){
            this.driver = driver;
        }
        public boolean isInventoryOpened(){
            return driver.findElement(productsTitle).isDisplayed();
        }
        public void openMenu(){
            driver.findElement(burgerMenu).click();
        }
        public boolean isMenuOpened() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
            return true;
        }
        public void openCart(){
            driver.findElement(cart).click();
        }
        public void openSort(){
            driver.findElement(sort).click();
        }

}
