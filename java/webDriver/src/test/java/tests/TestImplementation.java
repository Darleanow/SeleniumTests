package tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

//localhost:5500

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
    //     // Arrange
    //     driver.get("https://tomavt.with16.glpi-network.cloud/index.php");

    //     // Act
    //     WebElement loginName = driver.findElement(By.id("login_name"));
    //     loginName.click();
    //     loginName.sendKeys("admin");

    //     WebElement passwd = driver.findElement(By.cssSelector("input[type='password']"));
    //     passwd .click();
    //     passwd .sendKeys("???");

    //     WebElement loginButton = driver.findElement(By.cssSelector("button[name='submit']"));
    //     JavascriptExecutor jse = (JavascriptExecutor)driver;
    //     jse.executeScript("arguments[0].scrollIntoView(true);", loginButton);
    //     loginButton.click();

    //     // Assert
    //     String HOME_URL = "https://tomavt.with16.glpi-network.cloud/front/central.php";
    //     assertEquals("The home page is expected",
    //             HOME_URL,
    //             driver.getCurrentUrl());
    // }

	@Test
    public void testAddElementTodoApp() {
        // Arrange
        driver.get("https://lambdatest.github.io/sample-todo-app/");

        // Act
        WebElement sampletodotext= driver.findElement(By.id("sampletodotext"));
        sampletodotext.click();
        sampletodotext.sendKeys("test");

        driver.findElement(By.id("addbutton")).click();

        // Assert
        WebElement newTodoElement = driver.findElement(By.cssSelector("li:last-child span"));
        System.out.println(newTodoElement.getText());
        assertEquals(newTodoElement.getText(), "test");
        // assertThat("The new element is not found", newTodoElement.getText().equals "test");
    }

}
