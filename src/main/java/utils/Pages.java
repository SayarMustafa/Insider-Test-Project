package utils;

import pages.*;
import lombok.Data;

@Data
public class Pages {

	private InsiderHomePage insiderHomePage;

	private CareerPage careerPage;

	private QualityAssurancePage qualityAssurancePage;

	private BrowseOpenPositionsPage browseOpenPositionsPage;

	private ApplicationFormPage applicationFormPage;

	public Pages() {
		insiderHomePage = new InsiderHomePage();
		careerPage = new CareerPage();
		qualityAssurancePage = new QualityAssurancePage();
		browseOpenPositionsPage = new BrowseOpenPositionsPage();
		applicationFormPage = new ApplicationFormPage();
	}

}
