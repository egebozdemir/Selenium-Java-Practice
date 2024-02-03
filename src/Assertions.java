import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
// TestNG is one of the testing framework (library) we'll use for assertions

public class Assertions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		Assert.assertFalse(false); //expects 'false' in the argument, if 'true' --> throws AssertionError
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).isSelected()); //initially not selected so, 'false' is passed as expected
		
		driver.findElement(By.id("divpaxinfo")).click(); //click dropdown
		Thread.sleep(1000); 
		for (int i = 0; i < 5; i++) { //increment 5 times
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click(); //close the dropdown
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult"); //assertion is implemented for checking if the value incremented as expected
		
		
		

	}

}
