import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntro {

	public static void main(String[] args) {

		//Invoking Browser
		//Chrome - ChromeDriver (class) --> Methods (wrapped under the class)
		//Firefox - FirefoxDriver --> Methods (same method names as for other browsers, just different implementations)
		//Safari - SafariDriver --> Methods (ie. .close, .get ...)
		//WebDriver --> Main Interface for the browser drivers (close, get..)
		//Webdriver methods + class methods --> instead of ChromeDriver driver = ... / use WebDriver driver = ...
		
		//invoke(file"chromedriver.exe") --> Chrome browser
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		//webdriver.chrome.driver --> value of path (key value)
		WebDriver driver = new ChromeDriver();
		
		//Firefox Launch(geckodriver)
		//webdriver.gecko.driver
		System.setProperty("webriver.gecko.driver", "C:/webdriver/geckodriver.exe");
		WebDriver driver1 = new FirefoxDriver();
		
		//MS Edge Launch(msedgedriver)
		//webdriver.msedge.driver
		System.setProperty("webriver.edge.driver", "C:/webdriver/msedgedriver.exe");
		WebDriver driver2 = new EdgeDriver();
		
		//Test in Chrome
		driver.get("https://rahulshettyacademy.com");
		System.out.println("Page Title: " + driver.getTitle()); //getTitle: fetches page title
		System.out.println("Page URL: " + driver.getCurrentUrl()); //getCurrentUrl: fetches current url
		driver.close(); // closes only the original window opened (single tab)
		//driver.quit(); // closes driver - all associated windows (all tabs - including redirected pages on new tabs etc.)
		
		//Test in Firefox
		driver1.get("https://rahulshettyacademy.com");
		System.out.println("Page Title: " + driver1.getTitle()); 
		System.out.println("Page URL: " + driver1.getCurrentUrl()); 
		driver1.close(); 
		
		//Test in MS Edge
		driver2.get("https://rahulshettyacademy.com");
		System.out.println("Page Title: " + driver2.getTitle()); 
		System.out.println("Page URL: " + driver2.getCurrentUrl()); 
		driver2.close(); 
		
		
		}

}
