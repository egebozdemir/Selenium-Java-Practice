import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> windows = driver.getWindowHandles(); //[parentWindowID, childWindowID, subChildWindowId, ...]
		Iterator<String> iter = windows.iterator(); //starts outside of the set (-1th index)
		String parentID = iter.next();
		String childID = iter.next();
		
		driver.switchTo().window(childID);
		System.out.println("Text: " + driver.findElement(By.cssSelector(".im-para.red")).getText());
		
		//parse the text to grab e-mail
		String emailIDString = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println("Email: " + emailIDString);
		
		//switch to parent window and enter the emailID into username input field
		driver.switchTo().window(parentID);
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(emailIDString);

	}

}
