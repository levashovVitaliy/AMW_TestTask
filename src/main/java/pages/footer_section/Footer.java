package pages.footer_section;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import org.openqa.selenium.WebDriver;


public class Footer extends BasePage {

    public Footer(WebDriver driver) {
        super(driver);
    }

    // WEB-ELEMENTS ====================================================================================================

    @FindBy(xpath = "//ul[@class = \"Footer__SocialList-sc-1hzzf3r-1 bSsDIK\"]/li[1]")
    private WebElement discordLink;

    @FindBy(xpath = "//ul[@class = \"Footer__SocialList-sc-1hzzf3r-1 bSsDIK\"]/li[2]")
    private WebElement twitterLink;

    @FindBy(xpath = "//ul[@class = \"Footer__SocialList-sc-1hzzf3r-1 bSsDIK\"]/li[3]")
    private WebElement mediumLink;

    // SCENARIOS =======================================================================================================

    public String clickDiscordLink(){
        businessAction.openLink(discordLink);
        return businessAction.getCurrentUrlWithRedirectPageSettle();
    }


    public String clickTwitterLink(){
        businessAction.openLink(twitterLink);
        return businessAction.getCurrentUrlWithRedirectPageSettle();
    }


    public String clickMediumLink(){
        businessAction.openLink(mediumLink);
        return businessAction.getCurrentUrlWithRedirectPageSettle();
    }
}









