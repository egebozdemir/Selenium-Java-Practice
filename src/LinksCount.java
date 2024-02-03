import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksCount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//find links by accessing elements with tag "a" over all page
		System.out.println("Total link count: " + driver.findElements(By.tagName("a")).size());
		
		//find links on just footer by limiting scope of the driver 
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println("Footer link count: " + footerDriver.findElements(By.tagName("a")).size());

		//find links on just first footer column by limiting the webdriver's scope more
		WebElement columnDriver = driver.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));
		System.out.println("Column link count: " + columnDriver.findElements(By.tagName("a")).size());
		
		//click on each link in the column and check if the pages are opening
		for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
			
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			//instead of clicking each link and come back to continue with next one
			//open links in the new tab by CNTRL+ENTER
			//then go to each opened tab and verify (grab the title) in bulk
		}
		
		Thread.sleep(5000); //wait 5s for pages to be opened

		//go to each opened tab and grab the title 
		Set <String> openedTabs = driver.getWindowHandles(); //4 window
		Iterator<String> iter = openedTabs.iterator();
		while (iter.hasNext()) {
			driver.switchTo().window(iter.next());
			System.out.println(driver.getTitle());
		}
		
		//this script is independent from link names, we're accessing links by tag locators
		//if link names are changed, tests will not fail
		
	}

}
