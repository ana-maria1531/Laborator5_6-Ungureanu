package steps;

import io.cucumber.java.Before;
import utils.DriverFactory;

public class Hooks {

    @Before
    public void setUp() {
        // Inițializează driver-ul dacă nu e deja pornit
        DriverFactory.getDriver();
    }

}
