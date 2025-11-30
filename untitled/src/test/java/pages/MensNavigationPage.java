package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MensNavigationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MensNavigationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By mensWear = By.xpath("//a[contains(text(),\"Men's wear\")]");
    private By accessories = By.xpath("//a[contains(text(),'Accessories')]");
    private By clothing = By.xpath("//a[contains(text(),'Clothing')]");
    private By productItems = By.cssSelector("div.men-pro-item.simpleCart_shelfItem");

    public void clickMensWear() {
        driver.findElement(mensWear).click();
    }

    public void clickAccessories() {
        driver.findElement(accessories).click();
    }

    public void clickClothing() {
        driver.findElement(clothing).click();
    }

    public boolean areProductsDisplayed() {
        List<WebElement> products = driver.findElements(productItems);
        return products.stream().anyMatch(WebElement::isDisplayed);
    }

    public void waitForProductsToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productItems));
    }
}
