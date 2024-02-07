import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class WebTableSorting {

	public static void main(String[] args) {
		
		//Instantiate webdriver - ms edge
		System.setProperty("webriver.edge.driver", "C:/webdriver/msedgedriver.exe");
		WebDriver driver = new EdgeDriver(); 
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//PART-1
		//click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capture all the webelements into list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all webelements into new list -> original list (stream - map)
		List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort on the original list -> sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		//compare original list vs sorted list (they should be same)
		Assert.assertTrue(originalList.equals(sortedList));
		
		
		
		//PART-2
		//scan the name column with getText -> ie, 'Rice' -> print the price (retrieved with custom method) of 'Rice'
		String veggie = "Rice";
		List<String> price;		
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price =  rows.stream()
			.filter(s->s.getText().contains(veggie))
			.map(s->getPriceVeggie(s))
			.collect(Collectors.toList());
			
			price.forEach(a->System.out.println(a));
			
			//what if the veggie ('Rice') is not present in the first page -> go to next page and keep scan the names  
			if (price.size()<1) { 
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
			
		//iterate until there is one price value retrieved
		}while(price.size()<1); 
		
		
		
		//close the driver
		driver.close();
		

	}

	
	
	//webelement of veggie ('Rice') is passed as argument, 
	//just need to move to the sibling element for price
	private static String getPriceVeggie(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
