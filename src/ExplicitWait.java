import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	
	@SuppressWarnings("deprecation") //for dep. implicitlyWait method
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //implicit wait defined

		String[] productsToAdd = {"Cucumber","Brocolli","Carrot","Beetroot"}; //items to add
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		addItems(driver, productsToAdd); //method call to add the items
	
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click(); 
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//explicit wait 
		//(text is displayed after loading more than 3 seconds defined as implicitly)
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo"))); //targeted only this promoInfo element
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());  
		
	}
	
	
	
	//method to find the products on a PLP (check EcommerceApp class)
		@SuppressWarnings("rawtypes")
		public static void addItems(WebDriver driver, String[] productsToAdd) {
			List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
			int j=0;
			for (int i = 0; i < products.size(); i++) {
				String productName = products.get(i).getText().split("-")[0].trim();
				List productsToAddList = Arrays.asList(productsToAdd);
				if (productsToAddList.contains(productName)) {
					j++;
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); // instead static xpath with parent to child travel is used 
					if (j==productsToAdd.length) {
						break;
					}
				}
			}
		}

}
