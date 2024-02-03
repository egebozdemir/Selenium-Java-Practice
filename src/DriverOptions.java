import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverOptions {

	public static void main(String[] args) {
		
		
		//Internally setting the browser behaviour with EdgeOptions/ChromeOptions class
		EdgeOptions options = new EdgeOptions();
		
		//By-passing certificate issues like SSL
		options.setAcceptInsecureCerts(true); 
		
		//Adding extensions
		//options.addExtensions(extension_file_path);
		
		//Setting proxies for the cases that there is a proxy server should be used
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy); //don't pass the proxy string directly here
		
		//Blocking auto pop-ups like geolocation allowance
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		//Setting the download directory 
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		//Instantiate webdriver - ms edge with the driver options we set
		System.setProperty("webriver.edge.driver", "C:/webdriver/msedgedriver.exe");
		WebDriver driver = new EdgeDriver(options); //passing 'options' as arg
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		
		//test if working
		System.out.println(driver.getTitle());
		driver.close();
	}

}
