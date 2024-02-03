import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * This test script is created for practising Locators
 * for Selenium with Java. Positive, negative and reset
 * password flows for login functionality is considered
 */


public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		//test data
		String username = new String("ege");
		String email = new String("ege@gmail.com");
		String phone = new String("905324567890");
		String password_correct = new String("rahulshettyacademy");
		String password_false = new String("pass123");
		String success_msg = new String ("You are successfully logged in.");
		Boolean forgotPassword = false; //flag to switch to forgot password flow
		
		//global definitions
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //global synchronisation management -> 'wait for 2seconds if smthg is not shown up' 
		
		//negative flow
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(username); //find the element with it's ID locator, send/type "ege" to it. 
		driver.findElement(By.name("inputPassword")).sendKeys(password_false); //find the element with it's NAME locator, send/type "pass123" to it. 
		driver.findElement(By.className("signInBtn")).click(); //find the element with it's CLASS locator, click to it. 
		if (driver.findElement(By.cssSelector("p.error")).isDisplayed()) { //find the element with it's CSS SELECTOR: "tagname.classname" or "tagname#id, check if it's displayed.
			System.out.println("FAILED!\n" + "err_msg: " + driver.findElement(By.cssSelector("p.error")).getText());
			forgotPassword=true;
		}
		else {
			System.out.println("SUCCESS!\n" + success_msg);
		}
		
		//reset password flow
		if (forgotPassword) {
			driver.findElement(By.linkText("Forgot your password?")).click();
			Thread.sleep(1000); //wait for 1000ms (1s) for the ui to be stabilised. Url is not changing but the form is appeared after sliding so clicking is not received as the form is not yet loaded/stabilised fully 
			driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(username); //find the element with it's XPATH SELECTOR: "//tagname[@attribute='value']", send/type "ege" to it. 
			driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("wrong@email.com");
			driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
			driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys(email);
			driver.findElement(By.xpath("//form/input[3]")).sendKeys(phone); //writing XPath different way: access "//parent/child[index]"
			driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
			
			if (driver.findElement(By.cssSelector("p.infoMsg")).isDisplayed()) {
				System.out.println(driver.findElement(By.cssSelector("form p")).getText());
				driver.findElement(By.className("go-to-login-btn")).click();
				Thread.sleep(1000); //wait for 1s for the page to be stabilised (for clicking)
				//positive flow
				driver.findElement(By.id("inputUsername")).sendKeys(username);
				driver.findElement(By.name("inputPassword")).sendKeys(password_correct);
				driver.findElement(By.id("chkboxTwo")).click();
				driver.findElement(By.className("signInBtn")).click();
				if (driver.findElement(By.className("logout-btn")).isDisplayed() && driver.findElement(By.xpath("//div/h2")).getText().split(" |,")[1].equals(username)) {
					System.out.println("SUCCESS!\n" + success_msg);
				}
				else {
					System.out.println("FAILED!\nUnknown error ocured. Please try again later...");
				}
			}
			else {
				System.out.println("FAILED!\n" + "err_msg: " + driver.findElement(By.cssSelector("p.error")).getText());
			}
		}
		
		
		//close current window
		driver.close();
		
		
		
	}

}


