package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;
import utils.DriverFactory;

public class SearchSteps {

    private WebDriver driver = DriverFactory.getDriver();
    private SearchPage searchPage = new SearchPage(driver);

    @Given("utilizatorul este pe pagina principală pentru căutare")
    public void utilizatorul_este_pe_pagina_principală_pentru_căutare() {
        driver.get(DriverFactory.BASE_URL);
    }

    @When("utilizatorul caută produsul {string}")
    public void utilizatorul_caută_produsul(String produs) {
        searchPage.enterSearchText(produs);
        searchPage.clickSearchButton();
    }

    @Then("produsul {string} a fost găsit")
    public void produsul_a_fost_găsit(String produs) {
        boolean gasit = searchPage.isProductFound(produs);
        // Revenim la pagina principală pentru următorul test
        searchPage.goBackToHome();
        // Dacă produsul nu a fost găsit, testul eșuează
        Assert.assertTrue("Produsul '" + produs + "' nu a fost găsit!", gasit);


    }
}
