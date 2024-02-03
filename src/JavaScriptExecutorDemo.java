import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Instantiate webdriver - chrome
		//System.setProperty("webriver.chrome.driver", "C:/webDrivers/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();		
		
		//Instantiate webdriver - ms edge
		System.setProperty("webriver.edge.driver", "C:/webdriver/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		//driver.get("https://chromedriver.chromium.org/downloads/version-selection");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//to make webdriver able to execute javascripts (like via console in devtools)
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("window.scrollBy(0,500)"); //scroll the page
		Thread.sleep(3000);
		jsExecutor.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000"); //scroll on a table (DOM element)
		
		//4th column of the targeted table by css (traversing from parent table element, since there are multiple td elements in the page)
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		//iterate over the list and retrieve the values to sum
		for (int i = 0; i < values.size(); i++) {
			sum += Integer.parseInt(values.get(i).getText()); //casts the string text retrieved into integer and add to sum
		
		}
		//System.out.println(sum);
		
		//Validate the sum value against the total amount
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim()); //retrieve the text split, trim and cast to integer
		Assert.assertEquals(sum, total);
		System.out.println("Test is passed! Counted sum value matches with the total: " + sum);
	
		//close the driver
		driver.close();
	}

}
