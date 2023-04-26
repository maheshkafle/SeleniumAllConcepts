import java.io.File;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class TakesScreenshotDemo {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		File ts=(File) ((TakesScreenshot)driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE); 
		FileUtils.copyFile(ts, new File("C:\\Users\\kaflemah\\eclipse.png"));
		
	}
}
