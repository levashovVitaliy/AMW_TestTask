package pages.base;

import actions.Action;
import actions.ActionJs;
import constants.project_env.BaseUrl;
import constants.project_env.Project;
import constants.test.PageState;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.home_page.HomePage;
import utils.BusinessAction;

import java.util.Objects;

/* WebElements naming convention:
+----------+----------------------------+--------+-----------------+
| Category |      UI/Control type       | Prefix |     Example     |
+----------+----------------------------+--------+-----------------+
| Basic    | Button                     | btn    | btnExit         |
| Basic    | Check box                  | chb    | chbReadOnly     |
| Basic    | Combo box                  | cbo    | cboEnglish      |
| Basic    | Common dialog              | dlg    | dlgFileOpen     |
| Basic    | Container                  | cont   | contProduct     |
| Basic    | Counter                    | cntr   | cntrCartItems   |
| Basic    | Date picker                | dtp    | dtpPublished    |
| Basic    | Dropdown List / Select tag | dd     | ddlCountry      |
| Basic    | Form                       | form   | formEntry       |
| Basic    | Frame                      | fra    | fraLanguage     |
| Basic    | Image                      | img    | imgIcon         |
| Basic    | Input                      | inp    | inpUser         |
| Basic    | Label                      | lbl    | lblHelpMessage  |
| Basic    | Links/Anchor Tags          | link   | linkForgotPwd   |
| Basic    | List box                   | list   | listPolicyCodes |
| Basic    | Menu                       | menu   | menuFileOpen    |
| Basic    | Message Box                | msgb   | msgbWrongEmail  |
| Basic    | Radio button / group       | rdo    | rdoGender       |
| Basic    | RichTextBox                | rtf    | rtfReport       |
| Basic    | Table                      | tbl    | tblCustomer     |
| Basic    | TabStrip                   | tab    | tabOptions      |
| Basic    | Text Area                  | txa    | txaDescription  |
| Basic    | Text Box                   | txt    | txtLastName     |
| Complex  | Chevron                    | chv    | chvProtocol     |
| Complex  | Data grid                  | dgd    | dgdTitles       |
| Complex  | Data list                  | dbl    | dblPublisher    |
| Complex  | Directory list box         | dir    | dirSource       |
| Complex  | Drive list box             | drv    | drvTarget       |
| Complex  | File list box              | fil    | filSource       |
| Complex  | Panel/Fieldset             | pnl    | pnlGroup        |
| Complex  | ProgressBar                | prg    | prgLoadFile     |
| Complex  | Slider                     | sld    | sldScale        |
| Complex  | Spinner                    | spn    | spnPages        |
| Complex  | StatusBar                  | sta    | staDateTime     |
| Complex  | Timer                      | tmr    | tmrAlarm        |
| Complex  | Toolbar                    | tlb    | tlbActions      |
| Complex  | TreeView                   | tre    | treOrganization |
+----------+----------------------------+--------+-----------------+*/

public class BasePage {

    protected WebDriver driver;
    protected Action action;
    protected ActionJs actionJs;
    protected BusinessAction businessAction;
    protected String projectLabel;
    protected String projectEnv;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Action(driver);
        this.actionJs = new ActionJs(driver);
        PageState.PARENT_WINDOW = driver.getWindowHandle();
        businessAction = new BusinessAction(driver, action);
    }

    public BasePage(WebDriver driver, String projectLabel, String projectEnv) {
        this.driver = driver;
        this.action = new Action(driver);
        this.actionJs = new ActionJs(driver);
        this.projectLabel = projectLabel;
        this.projectEnv = projectEnv;
        PageState.PARENT_WINDOW = driver.getWindowHandle();
    }


    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return PageFactory.initElements(driver, pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    public HomePage openHomePage() {
        if (this.projectLabel == null || this.projectEnv == null)
            throw new RuntimeException("" +
                    "\nInitiate basePage using projectLabel and projectEnv before using 'openBaseUrl()' method" +
                    "\nor call 'openBaseUrl' method with parameters");
        return openHomePage(projectLabel, projectEnv);
    }


    public HomePage openHomePage(String projectLabel, String projectEnv) {
        this.projectLabel = projectLabel;
        this.projectEnv = projectEnv;

        String url;
        if (Objects.equals(projectLabel, Project.US.toString()))
            url = BaseUrl.getBaseUrl(projectEnv);
        else throw new RuntimeException("\nUnexpected value: " + projectLabel + ".\nPlease check projectLabel or 'project' field value in '.env' file.");

        driver.get(url);
        action.waitForPageLoaded();

        return getInstance(HomePage.class);
    }
}
