import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {

		//Invoking browser
		//Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\chromedriver_win32\\chromedriver.exe");
		//Two ways to define driver objects
		//1 driver object here has access to all methods of ChromeDriver
		 ChromeDriver driver1 = new ChromeDriver();

		//2 driver	 object has access to the methods of ChromeDriver which are defined in WebDriver Interface
		WebDriver driver2 = new ChromeDriver();

		//Firefox Launch
		//geckoDriver
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\geckodriver-v0.32.2-win32\\geckodriver.exe");
		WebDriver driver3 = new FirefoxDriver();

		//Microsoft Edge Launch
		//EdgeDriver
		System.setProperty("webdriver.edge.driver", "C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver4 = new EdgeDriver();

		driver4.get("https://rahulshettyacademy.com/loginpagePractise");
		System.out.println(driver2.getTitle());
		driver2.findElement(By.className("blinkingText")).click();
		//Difference between close and quit method is that close method closes the window which got originally opened
		//but quit methods closes all the browser windows
		driver2.close();
		//driver2.quit();
	}

}
