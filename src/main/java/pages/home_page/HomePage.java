package pages.home_page;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.evolution_section.EvolutionSection;
import pages.faq_section.FaqSection;
import pages.footer_section.Footer;
import pages.header_section.Header;
import pages.nebula_section.NebulaSection;
import pages.progress_section.ProgressSection;
import pages.wtf_section.WtfSection;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    // GETTERS =========================================================================================================

    public Header getHeader() {
        return super.getInstance(Header.class);
    }


    public WtfSection getWtfSection() {
        return super.getInstance(WtfSection.class);
    }


    public ProgressSection getProgressSection() {
        return super.getInstance(ProgressSection.class);
    }


    public EvolutionSection getEvolutionSection() {
        return super.getInstance(EvolutionSection.class);
    }


    public NebulaSection getNebulaSection() {
        return super.getInstance(NebulaSection.class);
    }


    public FaqSection getFaqSection() {
        return super.getInstance(FaqSection.class);
    }


    public Footer getFooter() {
        return super.getInstance(Footer.class);
    }
}
