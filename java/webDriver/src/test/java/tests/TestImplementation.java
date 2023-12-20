package tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

//localhost:5000

public class TestImplementation {
    private WebDriver driver;

    @BeforeClass
    public static void setupWebdriverChromeDriver() {
        System.setProperty("webdriver.gecko.driver", "C:/Dev/seleniumDrivers/ff/geckodriver.exe");
    }

    @Before
    public void setup() {
        driver = new FirefoxDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // @Test
    // public void testLoginToGlpi() {
    // // Arrange
    // driver.get("https://tomavt.with16.glpi-network.cloud/index.php");

    // // Act
    // WebElement loginName = driver.findElement(By.id("login_name"));
    // loginName.click();
    // loginName.sendKeys("admin");

    // WebElement passwd =
    // driver.findElement(By.cssSelector("input[type='password']"));
    // passwd .click();
    // passwd .sendKeys("???");

    // WebElement loginButton =
    // driver.findElement(By.cssSelector("button[name='submit']"));
    // JavascriptExecutor jse = (JavascriptExecutor)driver;
    // jse.executeScript("arguments[0].scrollIntoView(true);", loginButton);
    // loginButton.click();

    // // Assert
    // String HOME_URL =
    // "https://tomavt.with16.glpi-network.cloud/front/central.php";
    // assertEquals("The home page is expected",
    // HOME_URL,
    // driver.getCurrentUrl());
    // }

    @Test
    public void testLoginScenario() {
        // Utils / Time-out
        WebDriverWait timeout;

        // Web elements
        WebElement emailField;
        WebElement passwordField;
        WebElement submitButton;

        // Set-up base URL
        driver.get("http://localhost:5500/");

        // Setup email content
        emailField = driver.findElement(By.id("user-email"));
        emailField.click();
        emailField.sendKeys("thomas@facadia.com");

        // Setup password content
        passwordField = driver.findElement(By.id("user-password"));
        passwordField.click();
        passwordField.sendKeys("azerty");

        // Press submit
        submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        // Wait until we get redirected
        timeout = new WebDriverWait(this.driver, 10);
        timeout.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Façadia")));

        // Check if we have been redirected
        assertEquals("http://localhost:5500/#/home", driver.getCurrentUrl());

        // WebDriverWait wait = new WebDriverWait(this.driver, 10);
        // WebElement element = wait.until( ExpectedConditions.elementToBeClickable(by)
        // );

        // String currentUrl = driver.getCurrentUrl();
        // System.out.println("The current URL is: " + currentUrl);

        // Act
        // WebElement sampletodotext= driver.findElement(By.id("sampletodotext"));
        // sampletodotext.click();
        // sampletodotext.sendKeys("test");

        // driver.findElement(By.id("addbutton")).click();

        // // Assert
        // WebElement newTodoElement = driver.findElement(By.cssSelector("li:last-child
        // span"));
        // System.out.println(newTodoElement.getText());
        // assertEquals(newTodoElement.getText(), "test");
        // // assertThat("The new element is not found", newTodoElement.getText().equals
        // "test");
    }

    @Test
    public void testHomeScenario() {
        //
        // LOGIN
        //

        // Utils / Time-out
        WebDriverWait timeout;

        // Web elements
        WebElement emailField;
        WebElement passwordField;
        WebElement submitButton;

        // Set-up base URL
        driver.get("http://localhost:5500/");

        // Setup email content
        emailField = driver.findElement(By.id("user-email"));
        emailField.click();
        emailField.sendKeys("thomas@facadia.com");

        // Setup password content
        passwordField = driver.findElement(By.id("user-password"));
        passwordField.click();
        passwordField.sendKeys("azerty");

        // Press submit
        submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        // Wait until we get redirected
        timeout = new WebDriverWait(this.driver, 10);
        timeout.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Façadia")));

        //
        // TEST
        //
        WebElement sectionTitleElement;
        String sectionTitleText;

        sectionTitleElement = driver.findElement(By.className("section-title"));

        assertEquals(sectionTitleElement.isDisplayed(), true);

        sectionTitleText = sectionTitleElement.getText();

        assertEquals(sectionTitleText, "Vos capteurs");
    }

    @Test
    public void testCaptorScenario() {
        //
        // LOGIN
        //

        // Utils / Time-out
        WebDriverWait timeout;

        // Web elements
        WebElement emailField;
        WebElement passwordField;
        WebElement submitButton;

        // Set-up base URL
        driver.get("http://localhost:5500/");

        // Setup email content
        emailField = driver.findElement(By.id("user-email"));
        emailField.click();
        emailField.sendKeys("thomas@facadia.com");

        // Setup password content
        passwordField = driver.findElement(By.id("user-password"));
        passwordField.click();
        passwordField.sendKeys("azerty");

        // Press submit
        submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        // Wait until we get redirected
        timeout = new WebDriverWait(this.driver, 10);
        timeout.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Accueil")));

        //
        // TEST
        //
        WebElement sensorButton;
        WebElement sectionTitleElement;
        String sectionTitleText;

        sensorButton = driver.findElement(By.cssSelector(".sensor-info-btn:first-of-type"));
        sensorButton.click();

        timeout = new WebDriverWait(this.driver, 10);
        timeout.until(ExpectedConditions.presenceOfElementLocated(By.className("sensor-details")));

        sectionTitleElement = driver.findElement(By.className("section-title"));

        assertEquals(sectionTitleElement.isDisplayed(), true);

        sectionTitleText = sectionTitleElement.getText();

        assertEquals(sectionTitleText, "Détails du capteur #7");
    }

    @Test
    public void testLogoutScenario() {
        //
        // LOGIN
        //

        // Utils / Time-out
        WebDriverWait timeout;

        // Web elements
        WebElement emailField;
        WebElement passwordField;
        WebElement submitButton;

        // Set-up base URL
        driver.get("http://localhost:5500/");

        // Setup email content
        emailField = driver.findElement(By.id("user-email"));
        emailField.click();
        emailField.sendKeys("thomas@facadia.com");

        // Setup password content
        passwordField = driver.findElement(By.id("user-password"));
        passwordField.click();
        passwordField.sendKeys("azerty");

        // Press submit
        submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        // Wait until we get redirected
        timeout = new WebDriverWait(this.driver, 10);
        timeout.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Façadia")));

        // Check if we have been redirected
        assertEquals("http://localhost:5500/#/home", driver.getCurrentUrl());

        //
        // TEST
        //

        WebElement logoutButton;

        logoutButton = driver.findElement(
                By.cssSelector(".main-nav .main-nav-item:last-child .main-nav-link"));
        logoutButton.click();

        timeout = new WebDriverWait(this.driver, 10);
        timeout.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Veuillez vous connecter']")));

        assertEquals("http://localhost:5500/", driver.getCurrentUrl());

    }
}
