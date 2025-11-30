package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FilterMensPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public FilterMensPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By sortDropdown = By.id("country1");
    private By productTiles = By.cssSelector("div.men-pro-item.simpleCart_shelfItem");

    public void selectPriceLowToHigh() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(sortDropdown));
        Select select = new Select(dropdown);
        // Folosim value pentru a evita probleme cu <font>
        select.selectByValue("3");
        // Așteptăm să se aplice filtrul
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
    }

    public List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        List<WebElement> tiles = driver.findElements(productTiles);
        for (WebElement tile : tiles) {
            if (tile.isDisplayed()) {
                String priceText = tile.findElement(By.cssSelector("span.item_price"))
                        .getText().replaceAll("[^0-9.]", "");
                prices.add(Double.parseDouble(priceText));
            }
        }
        return prices;
    }
}
