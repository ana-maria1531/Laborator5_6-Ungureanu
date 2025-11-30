package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final String mensUrl = "https://loving-hermann-e2094b.netlify.app/mens";

    private final By firstProductPrice = By.cssSelector(".item_price");
    private final By firstAddToCartButton = By.xpath("(//input[@value='Add to cart'])[1]");
    private final By cartButton = By.cssSelector("button.w3view-cart");
    private final By cartSubtotal = By.cssSelector(".minicart-subtotal");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    public void openMensPage() {
        driver.get(mensUrl);
    }

    public double getFirstProductPrice() {
        WebElement priceEl = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductPrice));
        return parsePrice(priceEl.getText());
    }

    public void addFirstProductToCart() {
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(firstAddToCartButton));
        addBtn.click();
    }

    public void openCart() {
        WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartBtn.click();
    }

    public double getCartSubtotal() {
        WebElement subtotalEl = wait.until(ExpectedConditions.visibilityOfElementLocated(cartSubtotal));
        String text = subtotalEl.getText().replaceAll(".*\\$(\\d+\\.\\d+).*", "$1");
        return Double.parseDouble(text);
    }

    private double parsePrice(String text) {
        return Double.parseDouble(text.replaceAll("[^0-9.]", ""));
    }
}
