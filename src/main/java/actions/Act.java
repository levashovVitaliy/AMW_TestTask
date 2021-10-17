package actions;

import com.google.gson.Gson;
import constants.test.PageState;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public abstract class Act {

    protected WebDriver driver;
    public WebDriverWait wait;


    public Act(WebDriver driver) {
        this.driver = driver;
        this.wait = setWebDriverWait();
    }


    private WebDriverWait setWebDriverWait() {
        Duration timeout = Duration.ofSeconds(
                Long.parseLong(
                        Objects.requireNonNull(
                                Dotenv.load().get("implicitlyWait"))));
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.pollingEvery(Duration.ofMillis(1000));
        return wait;
    }


    abstract void hover(WebElement element);


    abstract void click(WebElement element);


    protected WebElement findWebElement(By by) {
        waitForPageLoaded();
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px dashed #ffe207'", element);
        return element;
    }


    public void type(WebElement element, String value) {
        waitForVisible(element);
        element.clear();
        element.sendKeys(value);
    }


    public WebElement waitElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }


    public WebElement fastWaitForVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }


    public List<WebElement> fastWaitForVisible(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
    }


    public WebElement waitForVisible(WebElement element) {
        waitForPageLoaded();
        return fastWaitForVisible(element);
    }


    public List<WebElement> waitForVisible(List<WebElement> elements) {
        waitForPageLoaded();
        return fastWaitForVisible(elements);
    }


    public WebElement fastWaitForInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
        return element;
    }


    public WebElement waitForInvisible(WebElement element) {
        waitForPageLoaded();
        return fastWaitForInvisible(element);
    }


    public WebElement fastWaitToDisappear(WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
        return element;
    }


    public WebElement waitToDisappear(WebElement element) {
        waitForPageLoaded();
        return fastWaitToDisappear(element);
    }


    public void waitForPageLoaded() {
        wait.until(WebDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .equals("complete"));
    }


    public void waitForJQueryLoaded() {
        wait.until(WebDriver -> (Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
    }


    public void contextClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).contextClick().build().perform();
    }


    public void setAttribute(WebElement element, String attName, String attValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                element, attName, attValue);
    }


    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }


    public void openNewTabAndSwitchTo() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }


    public void switchToChildWindow() {
        for (String childWindow : driver.getWindowHandles()) {
            if (!childWindow.equals(PageState.PARENT_WINDOW)) {
                driver.switchTo().window(childWindow);
                break;
            }
        }
    }

    public void switchToParentWindow() {
        driver.switchTo().window(PageState.PARENT_WINDOW);
    }


    public void setCookies(String url, String filepath) {
        driver.get(url);
        try {
            Cookie[] cookies = new Gson().fromJson(
                    new String(Files.readAllBytes(Paths.get(filepath))), Cookie[].class);

            // update expiry time for each cookie
            Date expiryTime = new Date(System.currentTimeMillis() + 1000000000);
            for (Cookie item : cookies) {
                Cookie cookie = new Cookie(item.getName(), item.getValue(), item.getDomain(), item.getPath(), expiryTime, item.isSecure(), item.isHttpOnly());
                driver.manage().addCookie(cookie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
        waitForPageLoaded();
    }


    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public void redirectPageSettle() {
        wait.until(new DocumentSettleCondition(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body"))));
    }


    public void closeAllWindowsExceptParent() {
        for (String item : driver.getWindowHandles()) {
            if (!item.equals(PageState.PARENT_WINDOW)) {
                driver.switchTo().window(item).close();
            }
        }
        driver.switchTo().window(PageState.PARENT_WINDOW);
    }


    public void moveElement(WebElement element, Dimension dimension) {
        new Actions(driver)
                .dragAndDropBy(element, dimension.getWidth(), dimension.getHeight())
                .build()
                .perform();

    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
