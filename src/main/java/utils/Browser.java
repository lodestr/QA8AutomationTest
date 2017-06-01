package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Browser {

	public static WebDriver driver;
	public static final String DRIVERS_PATH = "/Users/Halov/Downloads/Drivers/";

	/**
	 * Opens the desired browser. If input parameter is not recognized as valid
	 * option, the default browser will be opened.
	 * 
	 * @param browser
	 *            The browser we want to be instantiated:
	 *            <ul>
	 *            <li>'firefox' - for Firefox</li>
	 *            <li>'chrome' - for Chrome /default/</li>
	 *            <li>'opera' - for Opera</li>
	 *            <li>'ie' - for Internet Explorer</li>
	 *            </ul>
	 */
	public static void init(String browser) {
		System.out.println("Starting browser. Input param=[" + browser + "]");
		browser = browser.toLowerCase();
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", DRIVERS_PATH + "chromedriver");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", DRIVERS_PATH + "geckodriver");
			driver = new FirefoxDriver();
			break;
		case "opera":
			System.setProperty("webdriver.opera.driver", DRIVERS_PATH + "operadriver");
			driver = new OperaDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", DRIVERS_PATH + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Input param not recognized. Starting default browser.");
			System.setProperty("webdriver.chrome.driver", DRIVERS_PATH + "chromedriver");
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	/**
	 * Opens the default browser
	 */
	public static void init() {
		init("");
	}

	public static void tearDwon() {
		System.out.println("Closing browser instance !");
		driver.quit();		
	}

}
