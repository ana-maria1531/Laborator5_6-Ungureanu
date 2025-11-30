package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.FilterMensPage;
import utils.DriverFactory;

import java.util.List;

public class FilterSteps {
    private WebDriver driver = DriverFactory.getDriver();
    private FilterMensPage filterPage = new FilterMensPage(driver);

    @Given("utilizatorul este pe pagina mens pentru filtrare")
    public void utilizatorul_este_pe_pagina_mens_pentru_filtrare() {
        driver.get(DriverFactory.BASE_URL + "/mens");
    }

    @When("utilizatorul selectează filtrul după preț mic spre mare")
    public void utilizatorul_selectează_filtrul() {
        filterPage.selectPriceLowToHigh();
    }

    @Then("produsele ar trebui să fie afișate în ordinea corectă după preț")
    public void produsele_ar_trebui_să_fie_afișate_corect() {
        List<Double> prices = filterPage.getProductPrices();
        List<Double> sorted = new java.util.ArrayList<>(prices);
        sorted.sort(Double::compareTo);
        Assert.assertEquals("Produsele nu sunt afișate în ordine crescătoare după preț!", sorted, prices);
    }
}
