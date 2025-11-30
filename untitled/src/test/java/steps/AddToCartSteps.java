package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import utils.DriverFactory;

import static org.junit.Assert.assertEquals;

public class AddToCartSteps {

    private WebDriver driver;
    private CartPage cartPage;
    private double firstProductPrice;

    public AddToCartSteps() {
        this.driver = DriverFactory.getDriver();
    }

    @Given("utilizatorul este pe pagina mens")
    public void user_is_on_mens_page() {
        cartPage = new CartPage(driver);
        cartPage.openMensPage();
    }

    @When("utilizatorul adaugă primul produs în coș")
    public void user_adds_first_product_to_cart() {
        firstProductPrice = cartPage.getFirstProductPrice();
        cartPage.addFirstProductToCart();
        cartPage.openCart();
    }

    @Then("subtotalul coșului este corect")
    public void cart_subtotal_is_correct() {
        double subtotal = cartPage.getCartSubtotal();
        assertEquals(firstProductPrice, subtotal, 0.01);
    }
}

