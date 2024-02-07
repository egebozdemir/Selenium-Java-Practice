import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class WebTableFilter {

	public static void main(String[] args) {
		
		//Instantiate webdriver - ms edge
		System.setProperty("webriver.edge.driver", "C:/webdriver/msedgedriver.exe");
		WebDriver driver = new EdgeDriver(); 
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String searchedItem = "Rice";
		
		//enter the item name into search input field
		driver.findElement(By.id("search-field")).sendKeys(searchedItem);
		//get first column of all the search result rows into a list
		List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
		//ie, 5 results found -> store the text value in the list if item name contains the searched keyword
		List<WebElement> filteredList = items.stream()
		.filter(item->item.getText().contains(searchedItem))
		.collect(Collectors.toList());
		//1 result
		Assert.assertEquals(items.size(), filteredList.size());
		
		
		
		
		driver.close();		
	}

}
