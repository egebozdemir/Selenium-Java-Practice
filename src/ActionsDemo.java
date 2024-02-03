import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		//creating object from Actions class
		Actions a = new Actions(driver);
		
		//moves mouse over to specific element
		a.moveToElement(driver.findElement(By.cssSelector("span[id='nav-link-accountList-nav-line-1']"))).build().perform();
		
		//composite action: move to element, click, pressShift(capital letter), sendKeys, select, enter
		a.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		//right-click (to unselect the search text
		a.moveToElement(driver.findElement(By.cssSelector("span[id='nav-link-accountList-nav-line-1']"))).contextClick().build().perform();

	}

}
