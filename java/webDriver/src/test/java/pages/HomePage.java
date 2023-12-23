package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.TestDriver;
import helpers.TestElement;

public class HomePage extends FacadiaPageObject {

    private static final String PAGE_URL = "http://localhost:5500/#/home";

    public HomePage(TestDriver driver) {
        super(driver, PAGE_URL);
    }

    public String getSectionTitleText() {
        TestElement sectionTitleElement = getContent(By.className("section-title"));
        return sectionTitleElement.getText();
    }

    public TestElement clickFirstSensorInfoButton() {
        TestElement sensorButton = getContent(By.cssSelector(".sensor-info-btn:first-of-type"));
        sensorButton.click();
        timeout(By.className("sensor-details"),10);
        return sensorButton;
    }

    public String getSensorDetailsTitleText() {
        TestElement sectionTitleElement = getContent(By.className("section-title"));
        return sectionTitleElement.getText();
    }

    public HomePage clickLogoutButton() {
        TestElement logoutButton = getContent(By.cssSelector(".main-nav .main-nav-item:last-child .main-nav-link"));
        logoutButton.click();
        return this;
    }

}
