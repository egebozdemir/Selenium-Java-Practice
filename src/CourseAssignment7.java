import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class CourseAssignment7 {

	public static void main(String[] args) {	
		
		/*
		* Assignment Tasks:
		* Print the total number of rows of the Courses table
		* Print the total number of columns of the Courses table
		* Print the second row content of the Courses table
		*/
		
		//Instantiate webdriver - ms edge
		System.setProperty("webriver.edge.driver", "C:/webdriver/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		//Task-1: print rowCount
		List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr"));
		System.out.println("Total number of rows in the table: " + rows.size());
		
		//Task-2: print columnCount
		List<WebElement> columns = driver.findElements(By.cssSelector(".table-display tr:nth-child(1) th"));
		System.out.println("Total number of columns in the table: " + columns.size());
	
		//Task-3: print secondRowContent
		String content = driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText();
		System.out.println("Content of the second row in the table: " + content);
	
		driver.close();
	}

}
