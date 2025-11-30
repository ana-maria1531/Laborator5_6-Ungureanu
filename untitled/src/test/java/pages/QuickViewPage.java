package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import utils.DriverFactory;

public class QuickViewPage {

    private WebDriver driver;

    private By productContainers = By.cssSelector(".men-thumb-item");
    private By quickViewButton = By.cssSelector(".inner-men-cart-pro .link-product-add-cart");

    public QuickViewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(DriverFactory.BASE_URL + "/mens");
    }

    public String openQuickViewAndReturnUrl(int index) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        Actions actions = new Actions(driver);

        List<WebElement> products =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productContainers));

        WebElement product = products.get(index);

        actions.moveToElement(product).perform();

        WebElement quickView =
                wait.until(ExpectedConditions.visibilityOf(product.findElement(quickViewButton)));

        quickView.click();

        wait.until(ExpectedConditions.urlContains("/single"));

        return driver.getCurrentUrl();
    }
}
