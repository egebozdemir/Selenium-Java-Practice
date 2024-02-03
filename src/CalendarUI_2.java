import java.time.Duration;
import java.util.List;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarUI_2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Task: Select Date "August 23"
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://path2usa.com/travel-companion");
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='form-field-travel_comp_date']")));
		
		//Thread.sleep(5000);
		
		System.out.println(driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).getText());

		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
		
		//grab elements with common attribute, put into list and iterate
		List<WebElement> dates = driver.findElements(By.className("flatpickr-day"));
		
		for (int i = 0; i < dates.size(); i++) {
			String text = driver.findElements(By.className("flatpickr-day")).get(i).getText();
			if(text.equalsIgnoreCase("23")) {
				driver.findElements(By.className("flatpickr-day")).get(i).click();
				break;
			}
		}
		
		

	}

}
