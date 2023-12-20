package tests;

import helpers.Helpers;
import helpers.MyTestDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
// import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.GlpiPageObject;
import pages.HomePage;
import pages.LoginPage;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class TestWithPageObject {

    private static final String TEST_USER = "admin";
    private static final String TEST_PASSWORD = "???";
    private FirefoxDriver driver = null;
    private GlpiPageObject page;

    @BeforeClass
    public static void setupWebdriverChromeDriver() {
        // System.setProperty("webdriver.firefox.driver", "C:/Dev/seleniumDrivers/ff");
    }

    @Before
    public void setup() {
        this.driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        Optional.ofNullable(page).map(GlpiPageObject::close);
    }

    // @Test
    // public void testLoginToGlpi() {
    //     // Arrange - nothing

    //     // Act
    //     GlpiPageObject page = new LoginPage(new MyTestDriver(driver))
    //             .gotoPage()
    //             .setUser(TEST_USER)
    //             .setPassword(TEST_PASSWORD)
    //             .clickLoginButton();

    //     // Assert
    //     assertEquals(
    //             "The home page is expected",
    //             page.getExpectedUrl(),
    //             page.getCurrentUrl());
    // }
}
