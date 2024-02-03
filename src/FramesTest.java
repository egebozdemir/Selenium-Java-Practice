import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		//fails because driver can not find element in the frame
		//driver.findElement(By.id("draggable")).click();  
		
		//accessing to a iframe by index
		List <WebElement> iframes = driver.findElements(By.tagName("iframe"));
		System.out.println(iframes.size());
		driver.switchTo().frame(0);
		
		//accessing to a iframe by webelement
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.findElement(By.id("draggable")).click();  //now it throws no error
		
		//drag and drop actions in the iframe
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
		

		}

}
