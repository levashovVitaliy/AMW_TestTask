package pages.faq_section;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class FaqSection extends BasePage {

    public FaqSection(WebDriver driver) {
        super(driver);
    }

    // WEB-ELEMENTS ====================================================================================================

    @FindBy(xpath = "//div[text() = \"faq\"]")
    private WebElement faqTitleText;

    @FindBy(xpath = "//div[@class = \"FaqStyled__Accordion-sc-6l7lex-1 fgTnqP\"]/div")
    private List<WebElement> faqDropdownMenus;

    @FindBy(xpath = "//li[@class = \"FaqStyled__AccordionListItem-sc-6l7lex-6 gBdFdT\"]//a")
    private WebElement electronToGoAppLink;

    @FindBy(xpath = "//div[@class = \"FaqStyled__AccordionText-sc-6l7lex-7 fKNPOu\"]//a")
    private WebElement stellarEvolutionLink;


    // SCENARIOS =======================================================================================================

    public int getDropdownMenusSize() {
        return faqDropdownMenus.size();
    }


    public FaqSection openSummeryMenu(){
        openMenu(0);
        return this;
    }


    public FaqSection openWhyDynamicNftAndHowItWorksMenu(){
        openMenu(4);
        return this;
    }


    public boolean openMenu(int index) {
        WebElement buttonArrow = faqDropdownMenus.get(index).findElement(By.xpath("./div[1]"));

        String defaultButtonClass = buttonArrow.getAttribute("class");

        action.scrollIntoView(buttonArrow);
        action.click(buttonArrow);

        String currentButtonClass = buttonArrow.getAttribute("class");
        return !defaultButtonClass.equals(currentButtonClass);
    }


    public String getMenuName(int index) {
        return faqDropdownMenus.get(index).findElement(By.xpath(".//div[2]")).getText();
    }


    public int getMenuSingleTextElementQuantity(int index) {
        return faqDropdownMenus.get(index).findElements(By.xpath(".//div[3]/div")).size();
    }


    public int getMenuTextElementsQuantity(int index) {
        return faqDropdownMenus.get(index).findElements(By.xpath(".//li")).size();
    }


    public String clickElectronToGoAppLink() {
        businessAction.openLink(electronToGoAppLink);
        return businessAction.getCurrentUrlWithRedirectPageSettle();
    }


    public String clickStellarEvolutionLink() {
        businessAction.openLink(stellarEvolutionLink);
        return businessAction.getCurrentUrlWithRedirectPageSettle();
    }


    public String getFaqTitleText() {
        return faqTitleText.getText().trim();
    }
}
