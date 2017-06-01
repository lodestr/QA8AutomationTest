import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

import pages.AdminLoginPageObject;
import pages.DashboardPageObject;
import utils.Browser;

public class AdminLoginPageTests {

	// template method for successful login
	public void successfulLogin(String bowser) {
		Browser.init(bowser);
		AdminLoginPageObject.open();
		AdminLoginPageObject.login("admin", "parola");
	}

	@After
	public void afterMethod() {
		Browser.tearDwon();
	}

	// Test methods start here:

	@Test
	public void loginWithChrome() {
		successfulLogin("chrome");
		DashboardPageObject.assertLoggedAs("admin");
	}

	@Test
	public void loginWithForefox() {
		successfulLogin("firefox");
	}

	@Test
	public void failLogin() throws Throwable {
		Browser.init("chrome");
		AdminLoginPageObject.open();

		AdminLoginPageObject.populateCredentials("admin", "parafin");
		AdminLoginPageObject.clickLogin();

		assertEquals("Wrong validation message", "No match for Username and/or Password.",
				Browser.driver.findElement(By.className("warning")).getText());
	}

}
