package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.Browser;

public class CatalogPageObject {

	public static String product = "qwerty";

	public static void catalogProductSelect() {
		WebElement catalogMenu = Browser.driver.findElement(By.id("catalog"));
		WebElement productsMenu = Browser.driver.findElement(By.xpath("//div//li[@id='catalog']//ul//li[2]/a"));
		Actions productClick = new Actions(Browser.driver);
		productClick.moveToElement(catalogMenu).moveToElement(productsMenu).click().perform();
	}

	public static void searchByProductName() {
		WebElement filterName = Browser.driver.findElement(By.name("filter_name"));
		filterName.sendKeys(product, Keys.RETURN);
	}

	public static void assertResult() {
		WebElement filterResult = Browser.driver.findElement(By.xpath("//tbody//tr//td[@class='left']"));
		assertEquals(CatalogPageObject.product, filterResult.getText());

	}

	public static void clickResult() {
		WebElement productCheckbox = Browser.driver.findElement(By.xpath("//tbody//tr//td//input[@type='checkbox']"));
		if (!productCheckbox.isSelected())
			productCheckbox.click();
	}

	public static void deleteResult() {
		WebElement productDelete = Browser.driver
				.findElement(By.xpath("//div[@class='heading']//div[@class='buttons']//a[3]"));
		productDelete.click();
		Alert alert = Browser.driver.switchTo().alert();
		alert.accept();
	}

	public static void addProduct() {
		WebElement productInsert = Browser.driver
				.findElement(By.xpath("//div[@class='heading']//div[@class='buttons']//a[1]"));
		productInsert.click();
		WebElement productFieldName = Browser.driver.findElement(By.xpath("//tbody/tr/td[2]/input"));
		productFieldName.sendKeys(CatalogPageObject.product);
		WebElement productData = Browser.driver.findElement(By.xpath("//div[@id='tabs']/a[2]"));
		productData.click();
		WebElement productModel = Browser.driver.findElement(By.xpath("//tbody//tr//input[@name='model']"));
		productModel.sendKeys(CatalogPageObject.product);
		WebElement saveProduct = Browser.driver.findElement(By.xpath("//div[@id='content']//div[@class='buttons']//a"));
		saveProduct.click();
	}

}
