
package pages.header_section;

import actions.MovableElementSettleCondition;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;


public class Header extends BasePage {

    public Header(WebDriver driver) {
        super(driver);
    }

    // WEB-ELEMENTS ====================================================================================================

    @FindBy(xpath = "//div[@class = \"HeaderStyled__ResizerIcon-sc-bidnym-7 fZnOsB\"]")
    private WebElement iconResizer;

    @FindBy(xpath = "//div[@class = \"HeaderStyled__SliderWrapper-sc-bidnym-2 fIBKog\"]/div[2]")
    private WebElement leftSlideContent;

    @FindBy(xpath = "//div[@class = \"HeaderStyled__SliderWrapper-sc-bidnym-2 fIBKog\"]/div[1]")
    private WebElement rightSlideContent;

    @FindBy(xpath = "//img[@alt = \"charger\"]")
    private WebElement chargerImg;

    @FindBy(xpath = "//img[@alt = \"supernova\"]")
    private WebElement supernovaImg;

    @FindBy(xpath = "//div[@class = \"HeaderStyled__SingleSlide-sc-bidnym-9 bOzhOJ\"]/div[1]")
    private WebElement sectionText;


    // SCENARIOS =======================================================================================================

    public String checkTitleText() {
        return driver.getTitle().trim();
    }


    public String checkHeaderText() {
        return sectionText.getText();
    }


    public Header waitForEndScreenResizerStartAnimation() {
        action.wait.until(new MovableElementSettleCondition(iconResizer, 2000));
        return this;
    }


    public Header moveScreenResizerToLeftSide() {
        int screenWidth = driver.manage().window().getSize().getWidth();
        int target = (int) -((screenWidth / 2) * 0.85);
        action.moveElement(iconResizer, new Dimension(target, 0));
        return this;
    }


    public Header moveScreenResizerToRightSide() {
        int screenWidth = driver.manage().window().getSize().getWidth();
        int target = (int) ((screenWidth / 2) * 0.85);
        action.moveElement(iconResizer, new Dimension(target, 0));
        return this;
    }


    public Header moveScreenResizerToStartPosition() {
        int screenWidth = driver.manage().window().getSize().getWidth();
        Point currentLocation = iconResizer.getLocation();

        if (currentLocation.getX() > screenWidth / 2) {
            moveScreenResizerToLeftSide();
        } else {
            moveScreenResizerToRightSide();
        }

        return this;
    }


    public boolean isLeftSlideContentActive() {
        return leftSlideContent.getAttribute("class").contains("active");
    }


    public boolean isRightSlideContentActive() {
        return rightSlideContent.getAttribute("class").contains("active");
    }
}
