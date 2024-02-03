import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//full-screen mode
		driver.manage().window().maximize();	
		
		driver.get("http://google.com"); //get() waits the page to be load all elements
		driver.navigate().to("https://rahulshettyacademy.com"); //this is opens the url and directly continues (should probably used with implicit wait)
		
		//navigating back (<--)
		driver.navigate().back();
		//navigating forward (-->)
		driver.navigate().forward();
		
		
	}

}
