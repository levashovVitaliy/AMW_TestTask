package pages.nebula_section;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class NebulaSection extends BasePage {

    public NebulaSection(WebDriver driver) {
        super(driver);
    }

    // WEB-ELEMENTS ====================================================================================================

    @FindBy(xpath = "//div[@class = \"NebulaStyled__NebulaTitle-sc-75cnp2-2 iEMhGy\"]/div[1]")
    private WebElement checkOutRealTimeUsageText;

    @FindBy(xpath = "//div[@class = \"NebulaStyled__NebulaTitle-sc-75cnp2-2 iEMhGy\"]/div[2]")
    private WebElement onInteractiveNebulaMapText;

    @FindBy(xpath = "//a[text() = \"Enter the Nebula\"]")
    private WebElement enterTheNebulaButton;

    @FindBy(xpath = "//div[@class = \"NebulaStyled__NebulaSection-sc-75cnp2-0 ktByJU\"]/img[1]")
    private WebElement sectionBackgroundImg;


    // SCENARIOS =======================================================================================================

    public String checkOutRealTimeUsageText() {
        return checkOutRealTimeUsageText.getText();
    }

    public String checkOnInteractiveNebulaMapText() {
        return onInteractiveNebulaMapText.getText();
    }

    public boolean checkSectionBackgroundImg() {
        String defaultClassName = sectionBackgroundImg.getAttribute("class");

        action.scrollIntoView(enterTheNebulaButton);
        action.hover(enterTheNebulaButton);

        String currentClassName = sectionBackgroundImg.getAttribute("class");
        return defaultClassName.equals(currentClassName);
    }

    public String clickEnterTheNebulaButton() {
        businessAction.openLink(enterTheNebulaButton);
        return businessAction.getCurrentUrlWithRedirectPageSettle();
    }
}
