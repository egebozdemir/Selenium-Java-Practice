import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		// find element with css selector by using regular expression and click
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).click();
		// check if the checkbox is selected (with assertion)
		Assert.assertEquals(true, driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).isSelected());
		
		// store all the checkbox elements on the page in a list
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		// print the size of the elements (checkboxes) found on the page
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size()+" checkboxes found in the page");
		// iterate on all the checkboxes to find desired one ('Student')
		for(WebElement checkbox : checkboxes) {
			if (checkbox.findElement(By.xpath("parent::div")).getText().contains("Student")) { // the one's parent div has 'Student' text --> parent::div (relative xpath for the 'checkbox' element)
				checkbox.click();
				break;
			}
		}
		
		
		
	}

}
