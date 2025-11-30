package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ContactPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locator pentru butonul Contact
    private By contactButton = By.xpath("//a[@href='/contact']");

    // Locator pentru un element de pe pagina Contact, exemplu titlu
    private By contactTitle = By.tagName("h2"); // sau alt selector relevant

    // Apasă pe butonul Contact
    public void clickContact() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(contactButton));
        button.click();
    }

    // Verifică dacă pagina Contact s-a deschis
    public boolean isContactPageOpened() {
        try {
            WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(contactTitle));
            return title.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Revine la pagina principală
    public void goBackToHome() {
        driver.get(utils.DriverFactory.BASE_URL);
    }
}
