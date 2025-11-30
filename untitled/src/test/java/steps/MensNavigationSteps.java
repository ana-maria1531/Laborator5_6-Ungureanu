package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MensNavigationPage;
import utils.DriverFactory;

public class MensNavigationSteps {

    private WebDriver driver = DriverFactory.getDriver();
    private MensNavigationPage mensPage = new MensNavigationPage(driver);

    @Given("utilizatorul este pe pagina principală")
    public void utilizatorul_este_pe_pagina_principală() {
        driver.get(DriverFactory.BASE_URL);
        System.out.println("Pagina principală a fost deschisă cu succes.");
    }

    @When("utilizatorul navighează la categoria Accessories din Men's wear")
    public void navighează_la_accessories() {
        mensPage.clickMensWear();
        mensPage.clickAccessories();
        System.out.println("S-a navigat la Accessories.");
        mensPage.waitForProductsToBeVisible();
    }

    @When("utilizatorul navighează la categoria Clothing din Men's wear")
    public void navighează_la_clothing() {
        mensPage.clickMensWear();
        mensPage.clickClothing();
        System.out.println("S-a navigat la Clothing.");
        mensPage.waitForProductsToBeVisible();
    }

    @Then("produsele pentru categoria Accessories sunt afișate")
    public void produsele_accessories_sunt_afisate() {
        System.out.println("Verificăm dacă produsele pentru Accessories sunt afișate...");
        Assert.assertTrue("Produsele pentru Accessories nu sunt afișate!", mensPage.areProductsDisplayed());
        System.out.println("Navigarea la Accessories a fost realizată cu succes! Produsele sunt afișate, dar nu sunt sortate.");
    }

    @Then("produsele pentru categoria Clothing sunt afișate")
    public void produsele_clothing_sunt_afisate() {
        System.out.println("Verificăm dacă produsele pentru Clothing sunt afișate...");
        Assert.assertTrue("Produsele pentru Clothing nu sunt afișate!", mensPage.areProductsDisplayed());
        System.out.println("Navigarea la Clothing a fost realizată cu succes! Produsele sunt afișate, dar nu sunt sortate.");
    }
}
