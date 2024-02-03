import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class CourseAssignment8 {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		* Assignment Task:
		* Type first three characters for the country in the auto-suggestion dropdown
		* Move the mouse onto the country desired among suggestions and click
		* Verify if the selected value matches with the desired country
		*/
		
		//Instantiate webdriver - ms edge
		System.setProperty("webriver.edge.driver", "C:/webdriver/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		//Task: find auto-suggestion dropdown and type first three characters
		String desiredCountry = "Turkey";
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id=\"autocomplete\"]")).sendKeys("tur");
		Thread.sleep(2000);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		Assert.assertEquals(driver.findElement(By.id("autocomplete")).getAttribute("value"), desiredCountry);
		System.out.println("Desired country is selected!");
		System.out.println("Auto-completed value: " + desiredCountry);
		

	
	
	
	}

}
