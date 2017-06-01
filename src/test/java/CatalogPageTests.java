import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import pages.AdminLoginPageObject;
import pages.CatalogPageObject;
import pages.DashboardPageObject;
import utils.Browser;

public class CatalogPageTests {

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

	@Test
	public void catalogTest() {

		CatalogPageObject.catalogProductSelect();
		
		CatalogPageObject.searchByProductName();
		
		try {

			CatalogPageObject.assertResult();

			CatalogPageObject.clickResult();

			CatalogPageObject.deleteResult();

			CatalogPageObject.addProduct();

			CatalogPageObject.assertResult();
			
		} catch (NoSuchElementException | AssertionError e) {
			
			CatalogPageObject.addProduct();
			
			CatalogPageObject.assertResult();
		}

	}
}