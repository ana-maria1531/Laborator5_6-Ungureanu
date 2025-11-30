package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    // Locator pentru câmpul de search
    private By searchInput = By.name("search");

    // Locator pentru butonul de search
    private By searchButton = By.cssSelector("input[type='submit']");

    // Introduce text în câmpul de search
    public void enterSearchText(String text) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        input.clear();
        input.sendKeys(text);
    }

    // Apasă butonul de search
    public void clickSearchButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        button.click();
    }

    // Verifică dacă produsul există pe pagină
    public boolean isProductFound(String productName) {
        try {
            By productLocator = By.xpath("//*[contains(text(),'" + productName + "')]");
            WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));
            return product.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    // Revine la pagina principală
    public void goBackToHome() {
        driver.get(utils.DriverFactory.BASE_URL);

    }
}
