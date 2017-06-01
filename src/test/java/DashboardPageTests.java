import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.AdminLoginPageObject;
import pages.DashboardPageObject;
import utils.Browser;

public class DashboardPageTests {

	@Before
	public void beforeMethod() {
		// Preconditions - put your system under test in the desired initial
		// state:
		Browser.init();
		AdminLoginPageObject.open();
		AdminLoginPageObject.login("admin", "parola");
		DashboardPageObject.assertLoggedAs("admin");
	}

	@After
	public void afterMethod() {
		Browser.tearDwon();
	}

	// Test methods:

	@Test
	public void verifyRangeDropdwonValues(){
		
		int actualNumberOfOptions = DashboardPageObject.getNumberOfRangeOptions();
		assertEquals("Expected number of 'range' options doesn't match", 4, actualNumberOfOptions);
		
		List<String> expectedOptions = new ArrayList<String>(Arrays.asList("Today", "This Week", "This Month", "This Year"));
		System.out.println("expectedOptions= " + expectedOptions);
		System.out.println("DashboardPageObject.getRangeOptions() = " + DashboardPageObject.getRangeOptions());
		
		assertEquals("Range options doesn't match expected", expectedOptions, DashboardPageObject.getRangeOptions());
	}

}
