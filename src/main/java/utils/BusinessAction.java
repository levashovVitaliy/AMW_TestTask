package utils;

import actions.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BusinessAction {

    private WebDriver driver;
    private Action action;


    public BusinessAction(WebDriver currentDriver, Action currentAction) {
        this.driver = currentDriver;
        this.action = currentAction;
    }


    public String getCurrentUrlWithRedirectPageSettle() {
        String url = "";
        action.redirectPageSettle();

        if (driver.getWindowHandles().size() > 1) {
            action.switchToChildWindow();

            url = action.getCurrentUrl();

            action.switchToParentWindow();
            action.closeAllWindowsExceptParent();
        } else {
            url = action.getCurrentUrl();
        }
        return url;
    }


    public void openLink(WebElement link) {
        action.scrollIntoView(link);
        action.click(link);
    }


    public void openLinkInDropdownMenu(WebElement dropdownMenu, WebElement menuLink) {
        action.waitElementToBeClickable(dropdownMenu);
        action.hover(dropdownMenu);
        action.waitForVisible(menuLink);
        openLink(menuLink);
    }
}
