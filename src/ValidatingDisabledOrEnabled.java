import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class ValidatingDisabledOrEnabled {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); //click on checkbox for 'round trip'
		// 'return date' calendar UI should switch to enabled state
		Assert.assertTrue(driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).isEnabled()); //assertion to validate if it's enabled
		System.out.println("Enabled: " + driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).isEnabled());
		// checking a style attribute 'opacity' to validate if the element is disabled or not
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("opacity: 0.5")) {
			System.out.println("The element is disabled!");
			Assert.assertTrue(false); //fail the test 
		}
		else {
			System.out.println("The element is enabled!\nStyle attribute of the element is: '" + driver.findElement(By.id("Div1")).getAttribute("style") + "'");
			Assert.assertTrue(true); //pass the test 
		}
		

	}

}
