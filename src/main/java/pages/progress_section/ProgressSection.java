package pages.progress_section;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class ProgressSection extends BasePage {

    public ProgressSection(WebDriver driver) {
        super(driver);
    }

    // WEB-ELEMENTS ====================================================================================================

    @FindBy(xpath = "//div[@class = \"ProgressStyled__ProgressContainer-sc-1k2nvlb-2 gLauci\"]/div/div")
    private List<WebElement> sectionTextElements;

    @FindBy(xpath = "//a[@class = \"ProgressStyled__LearMoreBtn-sc-1k2nvlb-6 dYXmGF\"]")
    private WebElement learnMoreAboutUsLink;

    @FindBy(xpath = "//div[@class = \"ProgressStyled__IconWrap-sc-1k2nvlb-5 gitivt\"]")
    private WebElement learnMoreAboutUsArrow;

    // SCENARIOS =======================================================================================================

    public boolean checkSectionTextQuantity() {
        return sectionTextElements.size() == 6;
    }


    public ProgressSection hoverLearnMoreAboutUsLink() {
        action.scrollIntoView(learnMoreAboutUsLink);
        action.hover(learnMoreAboutUsLink);
        return this;
    }


    public ProgressSection hoverLearnMoreAboutUsArrowIcon() {
        action.scrollIntoView(learnMoreAboutUsArrow);
        action.hover(learnMoreAboutUsArrow);
        return this;
    }


    public double getLearnMoreAboutUsArrowPosition() {
        return learnMoreAboutUsArrow.getLocation().getX();
    }


    public String clickLearnMoreAboutUsLink() {
        businessAction.openLink(learnMoreAboutUsLink);
        return businessAction.getCurrentUrlWithRedirectPageSettle();
    }
}



