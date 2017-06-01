package pages;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Browser;

public class DashboardPageObject {

	static Select rangeDropdown;

	private static void init() {
		if (rangeDropdown == null) {
			rangeDropdown = new Select(Browser.driver.findElement(By.xpath(".//select[@id='range']")));
		}
	}

	public static void assertLoggedAs(String expectedUsername) {
		String actualUsername = null;
		try {
			actualUsername = Browser.driver.findElement(By.xpath(".//*[@id='header']//div/span")).getText();
		} catch (NoSuchElementException e) {
			System.out.println("You are not logged in (or Dashboard not displayed/loaded)");
			throw new Error("You are not logged in (or Dashboard not displayed/loaded)");
		}

		assertEquals("You are not logged in as the expected user!", expectedUsername, actualUsername);
	}

	public static int getNumberOfRangeOptions() {
		int numberOfOptions = 0;

		init();
		numberOfOptions = rangeDropdown.getOptions().size();

		return numberOfOptions;
	}

	public static List<String> getRangeOptions() {
		init();
		
		List<String> options = new ArrayList();
		
		rangeDropdown.getOptions().stream().forEach(entry -> {options.add(entry.getText());});
		
		return options;
	}

}
