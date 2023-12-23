package helpers;

import org.openqa.selenium.WebElement;

public class TestElement {

    private final WebElement element;

    public TestElement(WebElement element) {
        this.element = element;
    }

    public void click() {
        this.element.click();
    }

    public WebElement sendKeys(String keys) {
        this.element.sendKeys(keys);
        return this.element;
    }

    public Boolean isDisplayed() {
        return this.element.isDisplayed();
    }

    public String getText() {
        return this.element.getText();
    }
    
}
