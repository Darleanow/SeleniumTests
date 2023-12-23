package tests;

import helpers.MyTestDriver;
import helpers.TestElement;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.FacadiaPageObject;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;

public class TestsFacadia {

    private static final String TEST_USER = "thomas@facadia.com";
    private static final String TEST_PASSWORD = "azerty";
    private FirefoxDriver driver = null;

    @BeforeClass
    public static void setupWebdriverFireFoxDriver() {
        System.setProperty("webdriver.gecko.driver", "C:/Dev/seleniumDrivers/ff/geckodriver.exe");
    }

    @Before
    public void setup() {
        this.driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        this.driver.close();
    }

    @Test
    public void testLoginScenario() {
        // Arrange - nothing

        // Act
        FacadiaPageObject loginPage = new LoginPage(new MyTestDriver(driver)).loginUser(TEST_USER, TEST_PASSWORD);

        // Assert
        assertEquals("We are supposed to be on the Home page", loginPage.getExpectedUrl(), loginPage.getCurrentUrl());
    }

    @Test
    public void testHomeScenario() {
        // Act
        HomePage homePage = new LoginPage(new MyTestDriver(driver)).loginUser(TEST_USER, TEST_PASSWORD);

        // Assert
        String sectionTitleText = homePage.getSectionTitleText();
        assertEquals("Vos capteurs", sectionTitleText);
    }

    @Test
    public void testCaptorScenario() {
        // Act
        HomePage homePage = new LoginPage(new MyTestDriver(driver))
                .loginUser("thomas@facadia.com", "azerty");

        homePage.clickFirstSensorInfoButton();

        // Assert
        String sensorDetailsTitleText = homePage.getSensorDetailsTitleText();
        assertEquals("Détails du capteur #7", sensorDetailsTitleText);
    }

    @Test
    public void testLogoutScenario() {
        // Act
        HomePage homePage = new LoginPage(new MyTestDriver(driver))
                .loginUser(TEST_USER, TEST_PASSWORD)
                .clickLogoutButton();

        // Assert
        assertEquals("http://localhost:5500/", driver.getCurrentUrl());
    }
}
