import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize(); //element ids for dropdowns changes when the window size is changes, so work in full screen 

		// Initially, click on the first dynamicDropdown to load the options (then we can access elements -options- with Xpaths)
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		// Xpath for 'Chennai': //a[@value='MAA']
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		Thread.sleep(1000); // wait for 1s to open the second dropdown
		// Xpath for 'Bengaluru' (in second dynamicDropdown) after the selection is made on first dynamicDropdown is selected: (//a[@value='BLR'])[2]
		// By the selection for the first dropdown, the second one opens as default so no need to click again for the second dropdown
		//driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
		// We could select the element (2nd dropdown option) with using parent-child relationship (xpath) to avoid indexing
		// parent-child relationship (xpath): "//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='AMD']"
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='AMD']")).click();
		
		// same parent-child travel for css locator
		//driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		
		
		
	}

}
