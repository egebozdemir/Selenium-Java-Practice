import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class EcommerceApp {
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		// goal is to add the 'Cucumber', 'Brocolli' and 'Carrot' to the cart on the PLP
		// try adding different products into the array, it's the only thing to change. generic as hell! :) 
		String[] productsToAdd = {"Cucumber","Brocolli","Carrot","Beetroot"};
		// store all the product names having same locator into the list of web elements
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		int j=0;
		
		// iterate over all product names to find 'Cucumber'
		// the reason why we don't try to access to the exact button by providing index to the locator 
		// is that when any new product added, indexing would change and our test would fail
		// so we are implementing a generic crawling solution for the scenario 
		for (int i = 0; i < products.size(); i++) {
			String productName = products.get(i).getText().split("-")[0].trim(); //split() and trim() is for formatting the text into expected values
			// check whether name extracted is presented in the array or not
			// first, convert array into array list for easy search (contains() method)--> recommended for memory usage (converting to array list when running)
			List productsToAddList = Arrays.asList(productsToAdd);
			if (productsToAddList.contains(productName)) {
				j++;
				// click 'Add to Cart' button on the product's have names present in the array
				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(); // bad practise to use text locator on a dynamic element (text changes after clicking)
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); // instead static xpath with parent to child travel is used 
				// 'break' statement is not used here, instead we're checking how many times our 'if' block is executed. to count it we use variable "j"
				if (j==productsToAdd.length) {
					break;
				}
			}
		}
		
		// check if the desired number of products added to cart
		Integer number = productsToAdd.length; // to access the casting method for comparison in the assertion statement
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='cart-info']/table/tbody/tr/td/strong")).getText(), number.toString());
		
		

	}
	
	

}
