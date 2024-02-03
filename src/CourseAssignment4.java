import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CourseAssignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("a[href='/windows']")).click();
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator(); 
		String parentID = iter.next();
		String childID = iter.next();
		
		driver.switchTo().window(childID);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		driver.switchTo().window(parentID);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		

	}

}
