import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Miscelleanous {

	public static void main(String[] args) throws InterruptedException, IOException {

		//Instantiate webdriver - ms edge
		System.setProperty("webriver.edge.driver", "C:/webdriver/msedgedriver.exe");
		WebDriver driver = new EdgeDriver(); 
		
		//maximize window
		driver.manage().window().maximize();
		
		//delete all the cookies
		driver.manage().deleteAllCookies();
		
		//deleting a specific cookie
		driver.manage().deleteCookieNamed("cookie_name");
		
		//delete session key then verify that logged-in user is redirected to login url after clicking any link
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(1000);
		System.out.println(driver.getCurrentUrl());
		driver.manage().deleteCookieNamed("sessionKey");
		driver.findElement(By.xpath("(//a)[2]")).click();
		System.out.println(driver.getCurrentUrl());
		
		//capturing a screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://Users//m.bozdemir/Desktop/example_ss.png"));
	
	
	}

}
