package hooks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import utils.DriverManager;

public class Hooks {

	@BeforeEach
	public void setUp() {
		DriverManager.getDriver();
	}

	@AfterEach
	public void tearDown() {
		DriverManager.closeDriver();
	}

}
