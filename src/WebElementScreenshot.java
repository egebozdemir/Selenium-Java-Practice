import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WebElementScreenshot {

	public static void main(String[] args) throws IOException {

		//Instantiate webdriver - ms edge
		System.setProperty("webriver.edge.driver", "C:/webdriver/msedgedriver.exe");
		WebDriver driver = new EdgeDriver(); 
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Taking WebElement Partial Screenshot
		//Supported by Selenium versions > 4.0
		
		WebElement nameField = driver.findElements(By.cssSelector("[name='name']")).get(0);
		nameField.sendKeys("To be seen on the captured Screenshot");
		File file = nameField.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\m.bozdemir\\Desktop\\nameField_entered.png"));
		
		
		
		driver.close();
		
	}

}
