package pages;

import helpers.TestDriver;
import org.openqa.selenium.By;

public class LoginPage extends FacadiaPageObject {

    private static final String PAGE_URL = "http://localhost:5500/";

    public LoginPage(TestDriver driver) {
        super(driver, PAGE_URL);
    }

    public LoginPage gotoPage() {
        this.driver.get(PAGE_URL);
        return this;
    }

    public LoginPage setUser(String username) {
        driver.clickAndSendKeys(By.id("user-email"), username);
        return this;
    }

    public LoginPage setPassword(String password) {
        driver.clickAndSendKeys(By.id("user-password"), password);
        return this;
    }

    public HomePage clickLoginButton() {
        driver.click(By.cssSelector("button[type='submit']"));
        return new HomePage(driver);
    }

    public HomePage loginUser(String username,String password) {
        this.gotoPage().setUser(username).setPassword(password).clickLoginButton();
        return new HomePage(driver);
    }
}
