import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks2 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		//Instantiate webdriver - ms edge
		System.setProperty("webriver.edge.driver", "C:/webdriver/msedgedriver.exe");
		WebDriver driver = new EdgeDriver(); 
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Create a SoftAssert class object
		SoftAssert sa = new SoftAssert();
		
		//---------------------------------------
		//TASK: FIND ALL THE LINKS WITH BROKEN URL		
		//----------------------------------------
		
		//Step 1- Store all the link elements
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		//Step 2- Iterate over the links and check if url is broken
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(url + " : " + respCode);
			//Step 3- Soft assertion to catch broken links and continue checking
			sa.assertTrue(respCode<400, "The link with text '" + link.getText() + "' is broken with status code '" + respCode + "' --> ");
		}
		
		//Failures stored will stop the script execution now
		sa.assertAll(); 
		
		driver.close();
	}

}
