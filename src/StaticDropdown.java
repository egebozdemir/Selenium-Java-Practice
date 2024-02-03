import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//dropdown with select tag 
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); //static dropdown: options will not change
		Select dropdown = new Select(staticDropdown); //create object of 'Select' class to access it's methods
		dropdown.selectByIndex(3); //option on the 3rd index is selected (0,1,2,3)
		System.out.println(dropdown.getFirstSelectedOption().getText()); //getFirstSelectedOption(): returns the web element of the selected option, getText --> 'USD'
		dropdown.selectByVisibleText("AED"); //selecting by the text of the option
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR"); //select by the value of the option
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		
		
	}

}
