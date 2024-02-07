import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WebElementHeightWidth {

	public static void main(String[] args) {
		
		//Instantiate webdriver - ms edge
		System.setProperty("webriver.edge.driver", "C:/webdriver/msedgedriver.exe");
		WebDriver driver = new EdgeDriver(); 
		driver.get("https://rahulshettyacademy.com/angularpractice/");
				
		//Capturing Height and Width of WebElement for UX
		//Supported by Selenium versions > 4.0
		
		WebElement nameField = driver.findElements(By.cssSelector("[name='name']")).get(0);
		
		//Get Height and Width
		System.out.println(nameField.getRect().getDimension().getHeight());
		System.out.println(nameField.getRect().getDimension().getWidth());
		
		
		driver.close();

	}

}
