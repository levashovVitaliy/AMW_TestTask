package suites.main_page_test;

import pages.evolution_section.EvolutionSection;
import pages.faq_section.FaqSection;
import pages.footer_section.Footer;
import pages.header_section.Header;
import pages.nebula_section.NebulaSection;
import pages.progress_section.ProgressSection;
import pages.wtf_section.WtfSection;
import suites.UiTest;

public class MainPageClass extends UiTest {

    protected Header header;
    protected WtfSection wtfSection;
    protected ProgressSection progressSection;
    protected EvolutionSection evolutionSection;
    protected NebulaSection nebulaSection;
    protected FaqSection faqSection;
    protected Footer footer;

    @Override
    protected void initPages() {
        super.initPages();

        header = homePage.getHeader();
        wtfSection = homePage.getWtfSection();
        progressSection = homePage.getProgressSection();
        evolutionSection = homePage.getEvolutionSection();
        nebulaSection = homePage.getNebulaSection();
        faqSection = homePage.getFaqSection();
        footer = homePage.getFooter();
    }
}
