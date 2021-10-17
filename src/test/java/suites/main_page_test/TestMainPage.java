package suites.main_page_test;

import constants.test.Page;
import constants.test.PageSourceName;
import org.testng.Assert;
import org.testng.ITestNGListener;
import org.testng.annotations.Test;
import pages.evolution_section.EvolutionPageDescription;
import pages.faq_section.FaqSectionDescription;
import pages.header_section.HeaderPageDescription;
import pages.nebula_section.NebulaSectionDescription;
import pages.wtf_section.WtfSectionDescription;

public class TestMainPage extends MainPageClass implements ITestNGListener {

    @Test(groups = {"smoke", "regression"})
    public void test_01_checkPageTitle() {
        Assert.assertEquals(header.checkTitleText(), HeaderPageDescription.TITLE_TEXT.description);
    }


    @Test(groups = {"smoke", "regression"})
    public void test_02_checkHeaderText() {
        Assert.assertTrue(header.checkHeaderText().contains(HeaderPageDescription.BECOME_A_PART_OF_THE_NEBULA_DAO.description));
    }


    @Test(groups = {"smoke", "regression"})
    public void test_03_checkScreenResizer() {
        header.waitForEndScreenResizerStartAnimation();

        Assert.assertFalse(header.isRightSlideContentActive());
        Assert.assertFalse(header.isLeftSlideContentActive());

        header.moveScreenResizerToRightSide();
        Assert.assertTrue(header.isRightSlideContentActive());

        header
                .moveScreenResizerToStartPosition()
                .moveScreenResizerToLeftSide();
        Assert.assertTrue(header.isLeftSlideContentActive());
    }


    @Test(groups = {"smoke", "regression"})
    public void test_04_checkWtfText() {
        Assert.assertEquals(wtfSection.checkWtfText(), WtfSectionDescription.WTF_TEXT.description.toUpperCase());
    }


    @Test(groups = {"smoke", "regression"})
    public void test_05_checkVideoSourceName() {
        Assert.assertEquals(wtfSection.getVideoSourceName(), PageSourceName.WTF_SECTION_VIDEO_SOURCE.sourceName);
    }


    @Test(groups = {"smoke", "regression"})
    public void test_06_checkProgressSectionText() {
        Assert.assertTrue(progressSection.checkSectionTextQuantity());
    }


    @Test(groups = {"smoke", "regression"})
    public void test_07_checkAboutUsLinkHover() {
        double arrowStartPosition = progressSection.getLearnMoreAboutUsArrowPosition();

        progressSection
                .hoverLearnMoreAboutUsLink()
                .getLearnMoreAboutUsArrowPosition();

        double arrowDestinyPosition = progressSection.getLearnMoreAboutUsArrowPosition();
        Assert.assertTrue(arrowDestinyPosition > arrowStartPosition);
    }


    @Test(groups = {"smoke", "regression"})
    public void test_08_checkAboutUsLinkArrowHover() {
        double arrowStartPosition = progressSection.getLearnMoreAboutUsArrowPosition();

        progressSection
                .hoverLearnMoreAboutUsArrowIcon()
                .getLearnMoreAboutUsArrowPosition();

        double arrowDestinyPosition = progressSection.getLearnMoreAboutUsArrowPosition();
        Assert.assertTrue(arrowDestinyPosition > arrowStartPosition);
    }


    @Test(groups = {"smoke", "regression"})
    public void test_09_checkAboutUsLink() {
        String url = progressSection.clickLearnMoreAboutUsLink();
        Assert.assertEquals(url, Page.WHO_WILL_OWN_MACHINES.route);
    }


    @Test(groups = {"smoke", "regression"})
    public void test_10_checkEvolutionSectionText() {
        Assert.assertTrue(evolutionSection.checkTitleText().contains(EvolutionPageDescription.SECTION_TITLE_PART_TEXT.description));
        Assert.assertTrue(evolutionSection.checkFollowingStarEvolutionText().contains(EvolutionPageDescription.FOLLOWING_STAR_EVOLUTION_TEXT.description));
        Assert.assertTrue(evolutionSection.checkTimeText().contains(EvolutionPageDescription.TIME_TEXT.description));
        Assert.assertTrue(evolutionSection.checkMassText().contains(EvolutionPageDescription.MASS_TEXT.description));
        Assert.assertTrue(evolutionSection.checkStarEvolutionText().contains(EvolutionPageDescription.STAR_EVOLUTION_TEXT.description));
    }


    @Test(groups = {"smoke", "regression"})
    public void test_11_checkEvolutionSectionImage() {
        Assert.assertTrue(evolutionSection.isStarsStagesImageDisplayed());
    }


    @Test(groups = {"smoke", "regression"})
    public void test_12_checkNebulaSectionText() {
        Assert.assertTrue(nebulaSection.checkOutRealTimeUsageText().contains(NebulaSectionDescription.CHECK_OUT_REAL_TIME_USAGE.description.toUpperCase()));
        Assert.assertTrue(nebulaSection.checkOnInteractiveNebulaMapText().contains(NebulaSectionDescription.ON_INTERACTIVE_NEBULA_MAP.description.toUpperCase()));
    }


    @Test(groups = {"smoke", "regression"})
    public void test_13_checkNebulaBackgroundImage() {
        Assert.assertFalse(nebulaSection.checkSectionBackgroundImg());
    }


    @Test(groups = {"smoke", "regression"})
    public void test_14_checkEnterTheNebulaButton() {
        String url = nebulaSection.clickEnterTheNebulaButton();
        Assert.assertEquals(url, Page.NEBULA_DAO.route);
    }


    @Test(groups = {"smoke", "regression"})
    public void test_15_checkFaqTitleText() {
        Assert.assertTrue(faqSection.getFaqTitleText().contains(FaqSectionDescription.FAQ_TEXT.dropdownMenuName.toUpperCase()));
    }


    @Test(groups = {"smoke", "regression"})
    public void test_16_checkElectronToGoAppLink() {
        faqSection.openSummeryMenu();
        String url = faqSection.clickElectronToGoAppLink();
        Assert.assertEquals(url, Page.ELECTRON_TOGO_APP.route);
    }


    @Test(groups = {"smoke", "regression"})
    public void test_17_checkStellarEvolutionLink() {
        faqSection.openWhyDynamicNftAndHowItWorksMenu();
        String url = faqSection.clickStellarEvolutionLink();
        Assert.assertEquals(url, Page.STELLAR_EVOLUTION.route);
    }


    @Test(groups = {"smoke", "regression"})
    public void test_18_checkFaqMenus() {
        for (int i = 0; i < faqSection.getDropdownMenusSize(); i++) {
            Assert.assertEquals(faqSection.getMenuName(i), FaqSectionDescription.getDropdownMenuName(i));
            Assert.assertTrue(faqSection.openMenu(i));

            int textQuantity = 0;

            if (FaqSectionDescription.getTextQuantity(i) > 1) {
                textQuantity += faqSection.getMenuTextElementsQuantity(i);
            }

            if (textQuantity < FaqSectionDescription.getTextQuantity(i)) {
                textQuantity += faqSection.getMenuSingleTextElementQuantity(i);
            }
            Assert.assertEquals(textQuantity, FaqSectionDescription.getTextQuantity(i));
        }
    }


    @Test(groups = {"smoke", "regression"})
    public void test_19_checkDiscordLink() {
        String url = footer.clickDiscordLink();
        Assert.assertEquals(url, Page.DISCORD.route);
    }


    @Test(groups = {"smoke", "regression"})
    public void test_20_checkTwitterLink() {
        String url = footer.clickTwitterLink();
        Assert.assertEquals(url, Page.TWITTER.route);
    }


    @Test(groups = {"smoke", "regression"})
    public void test_21_checkMediumLink() {
        String url = footer.clickMediumLink();
        Assert.assertEquals(url, Page.MEDIUM.route);
    }
}
