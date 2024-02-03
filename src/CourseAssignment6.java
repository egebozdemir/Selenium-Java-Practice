import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CourseAssignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input[id='checkBoxOption2']")).click();
		
		String labelText = null;
		List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		for (int i = 0; i < checkBoxes.size(); i++) {
			if (checkBoxes.get(i).isSelected()) {
				labelText = checkBoxes.get(i).findElement(By.xpath("parent::label")).getText();
			}
		}
		//System.out.println("Selected: " + labelText);
		
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example")); 
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(labelText); 

		driver.findElement(By.cssSelector("input[id='name']")).sendKeys(labelText);
		driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
		
		String alertText = driver.switchTo().alert().getText();
		//System.out.println(alerText);
		String[] alertTexts = alertText.split(" |,");
		alertText=alertTexts[1].trim();
		//System.out.println(alertText);
		Assert.assertEquals(alertText, labelText);
		
		
	}

}
