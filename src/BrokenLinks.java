import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		//Instantiate webdriver - ms edge
		System.setProperty("webriver.edge.driver", "C:/webdriver/msedgedriver.exe");
		WebDriver driver = new EdgeDriver(); 
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Broken URL:
		//Step 1 - Get all URLs tied up to the links using Selenium
		//Step 2 - Call URLs and get the status code using Java methods
		//Step 3 - If status code > 400 then the URL is broken
		
		//Step 1:
		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		//Step 2:
		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode = conn.getResponseCode();
		System.out.println(respCode);
		
		//Step 3: 
		String result = ((respCode>=400) ? ("The url is broken: " + url) : ("The url is working: " + url));
		System.out.println(result);
		
		
		
	
		driver.close();
		
	
	}

}
