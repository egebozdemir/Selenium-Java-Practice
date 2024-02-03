import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("name")).sendKeys("ege");
		driver.findElement(By.id("alertbtn")).click();
		//Thread.sleep(1000);
		
		System.out.println(driver.switchTo().alert().getText()); //grab the alert message and print 
		driver.switchTo().alert().accept(); //switch to alert mode and accept (click positive)
		
		// 2 types of JS alerts: 
		// One of them is only the option to accept
		// Second one is that user can accept or cancel 
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss(); // to cancel (click negative)
		
		// alert mode can not handle authentication windows/pop-ups
		// for them, we use another mechanism called 'AutoIt' to handle them

	}

}
