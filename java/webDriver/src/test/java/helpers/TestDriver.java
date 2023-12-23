package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface TestDriver {

    TestElement findElement(By by);

    void get(String url);

    String getCurrentUrl();

    TestElement click(By by);

    TestElement clickAndSendKeys(By by, String content);
    
    TestDriver newTestDriverInIFrame(By by);

    void quit();

    WebDriver getUnderlyingDriver();
}
