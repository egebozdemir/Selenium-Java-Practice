import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/*
 * This test script is created for practising Locators
 * for Selenium with Java. Creating a static method to
 * capture the password from a text extracted from an 
 * element is considered. Method is called inside the main 
 * and saved the returned pw to be used in further steps
 */

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "ege";
		
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //implement the methods which are exposed by WebDriver interface
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //this is used for the case that to wait for an element to show up 
		String password=getPassword(driver); //call getPassword method and store the returned password in the variable that passed into sendKeys method
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("ege");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		//wait at least 1s to change the state of the page (login)
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		//assertion for comparing the expected text with the one extracted from the element ---> if comparison returns 'false', it fails
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();		
		driver.close();
	}
	
	
	public static String getPassword(WebDriver driver) throws InterruptedException { //to get the driver in scope of the method, I'm passing it as an argument
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText(); //push that extracted text into string variable
		//"Please use temporary password 'rahulshettyacademy' to Login."
		String[] passwordArray = passwordText.split("'");
		String password = passwordArray[1].split("'")[0];
		return password;
	}
	

}


