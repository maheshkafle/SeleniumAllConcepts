import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Implicitwait -> wait max for 5 sec but if text is found after 2 sec continue with program flow, doesn't wait further
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		//Css Selector - Tagname.className, Tagname#Id, If class and Id not present then, Tagname[attribute='value']
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		//To avoid Nosuchelementexception we need to add some wait in our code which is done in line no. 11.
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
	}

}
