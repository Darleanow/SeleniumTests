package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.TestDriver;
import helpers.TestElement;

public abstract class FacadiaPageObject {

    protected final TestDriver driver;
    private final String page_url;

    protected FacadiaPageObject(TestDriver driver, String page_url) {
        this.driver = driver;
        this.page_url = page_url;
    }

    public final String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public final String getExpectedUrl() {
        return this.page_url;
    }

    public final void timeout(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait((WebDriver) this.driver, seconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public final TestElement getContent(By by) {
        return driver.findElement(by);
    }

    public final FacadiaPageObject close() {
        this.driver.quit();
        return this;
    }
}
