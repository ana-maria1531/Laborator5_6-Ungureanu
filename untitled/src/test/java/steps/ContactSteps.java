package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ContactPage;
import utils.DriverFactory;

public class ContactSteps {

    private WebDriver driver = DriverFactory.getDriver();
    private ContactPage contactPage = new ContactPage(driver);

    @Given("utilizatorul este pe pagina principală pentru contactare")
    public void utilizatorul_este_pe_pagina_principală_pentru_contactare() {
        driver.get(DriverFactory.BASE_URL);
    }

    @When("utilizatorul accesează secțiunea Contact")
    public void utilizatorul_accesează_secțiunea_contact() {
        contactPage.clickContact();
    }

    @Then("pagina Contact se deschide corect")
    public void pagina_contact_se_deschide_corect() {
        Assert.assertTrue("Pagina Contact nu s-a deschis!", contactPage.isContactPageOpened());
        System.out.println("Navigarea la pagina Contact a fost realizată cu succes!");

        // Revenim la pagina principală pentru următorul test
        contactPage.goBackToHome();
    }
}
