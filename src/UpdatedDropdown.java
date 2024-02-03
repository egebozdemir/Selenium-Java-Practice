import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		driver.findElement(By.id("divpaxinfo")).click(); //click dropdown
		Thread.sleep(1000); //wait for 1s for dropdown to be opened (synchronization)
		System.out.println("Defult pre-selected value: "+driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("hrefIncAdt")).click(); //click to increment for an option
		int i=1;
		while (i<5) { //repeat clicking until incremented to '6'
			driver.findElement(By.id("hrefIncAdt")).click(); 
			i++;
		} 
		driver.findElement(By.id("btnclosepaxoption")).click(); //close the dropdown
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult"); //assertion statement
		System.out.println("Final selected value: "+driver.findElement(By.id("divpaxinfo")).getText());

	}

}
