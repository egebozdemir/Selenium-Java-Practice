import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CourseAssignment3 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		String userName = "rahulshettyacademy";
		String password = "learning";
		
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//span[contains(text(), 'User')]/following-sibling::span")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id='okayBtn']")));
		driver.findElement(By.cssSelector("button[id='okayBtn']")).click();
		
		driver.findElement(By.cssSelector("option[value='consult']")).click();
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		addProducts(driver);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")), "Checkout ( 4 )"));
		driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();

	}
	
	
	public static void addProducts(WebDriver driver) {
		
		List <WebElement> productCards = driver.findElements(By.xpath("//app-card/div/div[2]/button"));
		for (int i = 0; i < productCards.size(); i++) {
			productCards.get(i).click();
		}
		
	}

}
