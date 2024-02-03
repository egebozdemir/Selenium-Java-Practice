import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CourseAssignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//task: print the 'MIDDLE' text inside the nested iframes
		
		System.setProperty("webriver.chrome.driver", "C:/webdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();
		
		//outer layer of frames
		System.out.println("frameset count: " + driver.findElements(By.tagName("frameset")).size());
		System.out.println("frame count: " + driver.findElements(By.tagName("frame")).size());
		
		//first we need to crawl into the first frame inside (TOP) frameset
		driver.switchTo().frame("frame-top");
		//check if we can find all frames inside this frame
		System.out.println("second-level frame count: " + driver.findElements(By.tagName("frame")).size());
		//now we can access the middle frame by 2nd index
		driver.switchTo().frame(1);
		//grab the text content inside the frame 
		System.out.println("final grabbed text: " + driver.findElement(By.cssSelector("div[id='content']")).getText());
		
		

	}

}
