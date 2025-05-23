import hooks.Hooks;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.DriverManager;
import utils.NavigationUtils;
import utils.Pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsiderTest extends Hooks {

	protected final Pages PAGES = new Pages();

	public static final Logger LOGGER = LogManager.getLogger(InsiderTest.class);

	@Test
	public void insiderTest() throws InterruptedException {
		Thread.sleep(2000);
		PAGES.getInsiderHomePage().acceptCookies();
		LOGGER.info("The user accepts cookies");

		PAGES.getInsiderHomePage().checkTheUserIsOnHomePage();
		Assertions.assertThat(PAGES.getInsiderHomePage().getTextOfLoginButton()).isEqualTo("Login");
		LOGGER.info("The user is on Home Page");

		PAGES.getInsiderHomePage().clickOnCareerButton();
		LOGGER.info("The user clicks on Careers Button");

		PAGES.getCareerPage().checkTheUserIsOnCareersPage();
		Assertions.assertThat(PAGES.getCareerPage().checkTheUserIsOnCareersPage()).isEqualTo("Ready to disrupt?");
		LOGGER.info("The user is on Careers Page");

		PAGES.getCareerPage().isSeeAllTeamsButtonDisplayed();
		Assertions.assertThat(PAGES.getCareerPage().isSeeAllTeamsButtonDisplayed()).isTrue();
		LOGGER.info("See all teams button is displayed");

		PAGES.getCareerPage().clickOnSeeAllTeamsButton();
		LOGGER.info("The user clicks on See all teams button");

		PAGES.getCareerPage().isSeeAllTeamsSectionDisplayed();
		Assertions.assertThat(PAGES.getCareerPage().isSeeAllTeamsSectionDisplayed()).isTrue();
		LOGGER.info("See all teams section is displayed");

		PAGES.getCareerPage().isOurLocationsTextFieldDisplayed();
		Assertions.assertThat(PAGES.getCareerPage().isOurLocationsTextFieldDisplayed()).isTrue();
		LOGGER.info("Our locations text field is displayed");

		PAGES.getCareerPage().isLifeAtInsiderTextFieldDisplayed();
		Assertions.assertThat(PAGES.getCareerPage().isLifeAtInsiderTextFieldDisplayed()).isTrue();
		LOGGER.info("Life at Insider text field is displayed");

		NavigationUtils.goToQualityAssurancePage();
		Assertions.assertThat(DriverManager.getDriver().getCurrentUrl())
			.isEqualTo("https://useinsider.com/careers/quality-assurance/");
		LOGGER.info("The user is on Quality Assurance Page");

		PAGES.getQualityAssurancePage().clickOnSeeAllQaJobsButton();
		LOGGER.info("The user clicks on See all QA jobs button");

		Assertions.assertThat(PAGES.getBrowseOpenPositionsPage().isBrowseOpenPositionsTextFieldDisplayed()).isTrue();
		LOGGER.info("The user is on Open Positions Page");

		PAGES.getBrowseOpenPositionsPage().selectComboBox();
		Thread.sleep(2000);
		LOGGER.info("The User selects 'İstanbul,Türkiye'");

		PAGES.getBrowseOpenPositionsPage().isJoblistDisplayed();
		LOGGER.info("The User sees the filtered Job List");

		PAGES.getBrowseOpenPositionsPage().verifyJobs();
		LOGGER.info("The User verifies the filtered job list ");

		PAGES.getBrowseOpenPositionsPage().clickViewRoleAndSwitchToNewWindow();
		LOGGER.info("The User clicks on View Role Button and redirects to Application Form Page ");

		Assertions.assertThat(PAGES.getApplicationFormPage().isJobTitleTextFieldDisplayed()).isTrue();
		LOGGER.info("The User verifies the Application Form Page is displayed");

	}

}
