package pages.evolution_section;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class EvolutionSection extends BasePage {

    public EvolutionSection(WebDriver driver) {
        super(driver);
    }

    // WEB-ELEMENTS ====================================================================================================

    @FindBy(xpath = "//div[@class = \"EvolutionStyled__EvolutionSection-sc-jdrm0f-0 icIKZI\"]/div[1]")
    private WebElement sectionTitleText;

    @FindBy(xpath = "//div[@class = \"EvolutionStyled__EvolutionText-sc-jdrm0f-2 gplFTu\"]")
    private WebElement followingStarEvolutionText;

    @FindBy(xpath = "//span[text()= \"Time\"]")
    private WebElement timeText;

    @FindBy(xpath = "//span[text()= \"Mass\"]")
    private WebElement massText;

    @FindBy(xpath = "//div[text()= \"STAR EVOLUTION\"]")
    private WebElement starEvolutionText;

    @FindBy(xpath = "//div[@class = \"EvolutionStyled__StarsImage-sc-jdrm0f-6 ftdLuw\"]/div/img")
    private WebElement starsStagesImg;


    // SCENARIOS =======================================================================================================

    public String checkTitleText() {
        return sectionTitleText.getText();
    }


    public String checkFollowingStarEvolutionText() {
        return followingStarEvolutionText.getText();
    }


    public String checkTimeText() {
        return timeText.getText();
    }


    public String checkMassText() {
        return massText.getText();
    }


    public String checkStarEvolutionText() {
        return starEvolutionText.getText();
    }


    public boolean isStarsStagesImageDisplayed() {
        return starsStagesImg.isDisplayed();
    }
}
