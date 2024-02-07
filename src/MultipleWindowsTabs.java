import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class MultipleWindowsTabs {

	public static void main(String[] args) {
		
		//Instantiate webdriver - ms edge
		System.setProperty("webriver.edge.driver", "C:/webdriver/msedgedriver.exe");
		WebDriver driver = new EdgeDriver(); 
				
		//Invoking Multiple Windows/Tabs from Selenium using one Driver Instance 
		//Supported by Selenium versions > 4.0
		
		//Scenario: 
		//Navigate to https://rahulshettyacademy.com/angularpractice/
		//Fill the "Name" field with the first course name available at https://rahulshettyacademy.com/
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		String parentWindowId = iterator.next();
		String childWindowId = iterator.next();
		driver.switchTo().window(childWindowId);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
		driver.switchTo().window(parentWindowId);
		driver.findElements(By.cssSelector("[name='name']")).get(0).sendKeys(courseName);
		
		
		
		driver.quit();
		
	}

}
