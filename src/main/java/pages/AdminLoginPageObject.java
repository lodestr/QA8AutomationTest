package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.Browser;

public class AdminLoginPageObject {

	@FindBy(how = How.NAME, using = "username")
	private static WebElement username;

	@FindBy(how = How.NAME, using = "password")
	private static WebElement password;

	@FindBy(how = How.XPATH, using = ".//a[@class='button']")
	private static WebElement loginButton;

	public static void open() {
		Browser.driver.get("http://shop.pragmatic.bg/admin/");
		PageFactory.initElements(Browser.driver, AdminLoginPageObject.class);
	}

	public static void populateUsername(String usernameParam) {
		username.sendKeys(usernameParam);
	}

	public static void populatePassword(String passParam) {
		password.sendKeys(passParam);
	}

	public static void populateCredentials(String user, String pass) {

		populateUsername(user);
		populatePassword(pass);

	}

	public static void clickLogin() {
		loginButton.click();
	}

	/**
	 * Populates the provided credentials and clicks the Login button. <br/>
	 * At the end, the user should be logged in and land on the Dashboard page (if
	 * valid credentials were supplied)
	 * 
	 * @param username
	 *            The username to be used.
	 * @param password
	 *            The password to be used.
	 */
	public static void login(String username, String password) {
		populateCredentials(username, password);
		clickLogin();
	}

}
