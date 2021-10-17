package actions;

import org.jetbrains.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class MovableElementSettleCondition implements ExpectedCondition<java.lang.Boolean> {

    private final WebElement webElement;
    private final long settleTimeInMillis;
    private long lastComplete = 0L;
    private Point lastPosition;


    public MovableElementSettleCondition(WebElement webElement, long settleTimeInMillis) {
        this.webElement = webElement;
        this.settleTimeInMillis = settleTimeInMillis;
    }


    public MovableElementSettleCondition(WebElement webElement) {
        this(webElement, 2000L);
    }


    @Nullable
    @Override
    public Boolean apply(@org.checkerframework.checker.nullness.qual.Nullable WebDriver driver) {
        if (driver instanceof JavascriptExecutor) {
            Point currentPosition = webElement.getLocation();
            String readyState = String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"));
            boolean complete = readyState.equalsIgnoreCase("complete");

            if (!complete) {
                lastComplete = 0L;
                return null;
            }

            if (lastPosition != null && !lastPosition.equals(currentPosition)) {
                lastComplete = 0L;
            }

            lastPosition = currentPosition;

            if (lastComplete == 0L) {
                lastComplete = System.currentTimeMillis();
                return null;
            }

            long settleTime = System.currentTimeMillis() - lastComplete;
            if (settleTime < this.settleTimeInMillis) {
                return null;
            }
        }
        return true;
    }
}
