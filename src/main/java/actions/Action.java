package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Action extends Act {

    public Action(WebDriver webDriver) {
        super(webDriver);
    }


    @Override
    public void hover(WebElement element) {
        waitForVisible(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).pause(500).build().perform();
    }

    @Override
    public void click(WebElement element) {
        element.click();
    }


    public void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }
}
