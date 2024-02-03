import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	@SuppressWarnings("deprecation") //for dep. implicitlyWait method
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//don't immediately fail if a web element is not available, wait for 5 seconds - wait globally
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //implicit wait defined

		String[] productsToAdd = {"Cucumber","Brocolli","Carrot","Beetroot"}; //items to add
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		addItems(driver, productsToAdd); //method call to add the items
		
		//if addItems method was not defined as static 
		//(static method you can directly access without creating object)
		//we would have needed to create the object of the class and access the method as:
		//ImplicitWait wait = new ImplicitWait();
		//wait.addItems(driver, productsToAdd);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		//we are using the text to access the element since the text is static (not changing, not dynamic)
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click(); 
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//after clicking apply button, it'll wait for maximum 5s for the text to be displayed
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
