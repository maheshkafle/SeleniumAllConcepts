import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSlCheck {

	public static void main(String[] args) {
		//Chrome Web Browser
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		/*For Firefox Web Browser
		 * 
			FirefoxOptions options1 = new FirefoxOptions() ;
			options1.setAcceptInsecureCerts(true);
		*/
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		//Set Download directory
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "C:\\\\Users\\\\kaflemah\\\\OneDrive - Lisec Holding GmbH\\\\Documents\\\\Projects\\\\Udemy\\\\Introduction\\\\Drivers\\\\chromedriver_win32\\\\");
		options.setExperimentalOption("prefs", prefs);
		
		driver.get("https://expired.badssl.com/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		System.out.println(driver.getTitle());
	}
}
