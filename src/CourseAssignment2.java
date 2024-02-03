import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class CourseAssignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		// Fill the fields completely for the 'Student' employee and submit the form
		// Capture the success message appears and print as the output
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Ege");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("ege@ege.com");
		driver.findElement(By.cssSelector("input[id='exampleInputPassword1']")).sendKeys("egeEge123!");
		driver.findElement(By.id("exampleCheck1")).click();
		Assert.assertTrue(driver.findElement(By.id("exampleCheck1")).isSelected());
		driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']/option[2]")).click();
		driver.findElement(By.id("inlineRadio1")).click();
		Assert.assertTrue(driver.findElement(By.id("inlineRadio1")).isSelected());
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("01011990");
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).isDisplayed(), true);
		
		
		
		
		

	}

}
