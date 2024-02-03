import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * This test script is created for practising Locators
 * for Selenium with Java. Traversal ways to reach an
 * an element are considered. 
 * 1-Parent to Child 
 * 2-Child to Child
 * 3-Child to Parent
 * Note: these traversals don't work for css locators
 */


public class Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Parent to Child traversal
		//header/div/button[2]
		System.out.println(driver.findElement(By.xpath("//header/div/button[2]")).getText());
		
		// Sibling to Sibling traversal
		//header/div/button[1]/following-sibling::button[1]
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());

		// Sibling,Child to Parent traversal
		//header/div/button[1]/parent::div/button[2]
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());

	}

}
