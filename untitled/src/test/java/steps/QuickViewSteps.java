package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.QuickViewPage;
import utils.DriverFactory;

public class QuickViewSteps {

    private WebDriver driver;
    private QuickViewPage page;
    private Actions actions;

    private String firstUrl;
    private String secondUrl;

    public QuickViewSteps() {
        this.driver = DriverFactory.getDriver();
        this.page = new QuickViewPage(driver);
        this.actions = new Actions(driver);
    }

    @Given("utilizatorul este pe pagina mens pentru Quick View")
    public void user_is_on_mens_page_for_quick_view() {
        page.open();
    }

    @When("utilizatorul deschide Quick View pentru primul produs")
    public void user_opens_quick_view_first_product() {
        firstUrl = page.openQuickViewAndReturnUrl(0);
    }

    @When("utilizatorul deschide Quick View pentru al doilea produs")
    public void user_opens_quick_view_second_product() {
        secondUrl = page.openQuickViewAndReturnUrl(1);
    }

    @Then("URL-urile paginilor de produs sunt diferite")
    public void product_urls_are_different() {
        assert !firstUrl.equals(secondUrl) :
                "Quick View trimite pe aceeași pagină pentru ambele produse!";
    }
}
