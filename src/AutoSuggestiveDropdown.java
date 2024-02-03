import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		// to find all the options listed after "ind" is typed and store it in a list holds WebElements
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		// Iterate the 'options' list to find desired element --> Goal is to find 'India'
		for (WebElement option : options) {
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
				break; //if searched element is found, get out of the loop
			}
		}
		
		
		

	}

}
