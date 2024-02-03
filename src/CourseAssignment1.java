import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CourseAssignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//1- Check the first  Checkbox and verify if it is successfully checked 
		//and Uncheck it again to verify if it is successfully Unchecked
		driver.findElement(By.cssSelector("input[name='checkBoxOption1']")).click(); //select
		Assert.assertEquals(true, driver.findElement(By.cssSelector("input[name='checkBoxOption1]'")).isSelected());
		driver.findElement(By.cssSelector("input[name='checkBoxOption1'")).click(); //unselect
		Assert.assertFalse(driver.findElement(By.cssSelector("input[name='checkBoxOption1'")).isSelected());
		
		
		//2- Get the Count of number of check boxes present in the page
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
	

	}

}
