package pages.wtf_section;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class WtfSection extends BasePage {

    public WtfSection(WebDriver driver) {
        super(driver);
    }

    // WEB-ELEMENTS ====================================================================================================

    @FindBy(xpath = "//div[text() = \"wtf?\"]")
    private WebElement wtfText;

    @FindBy(xpath = "//video/source")
    private WebElement videoSectionSource;


    // SCENARIOS =======================================================================================================

    public String getVideoSourceName() {
        action.scrollIntoView(videoSectionSource);

        String srcName = videoSectionSource.getAttribute("src");
        int index = srcName.lastIndexOf("/");
        return srcName.substring(index + 1);
    }


    public String checkWtfText() {
        return wtfText.getText();
    }
}
