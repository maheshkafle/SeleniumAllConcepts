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
		//Css Selector - Tagname.className, Tagname#Id, If class and Id not present also called customized cssselector then , Tagname[attribute='value'] 
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		//To avoid Nosuchelementexception we need to add some wait in our code which is done in line no. 11.
		driver.findElement(By.linkText("Forgot your password?")).click();
		//customized Xpath -  //Tagname[@attribute='value']
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		//If we don't have unique selectors then how to handle using xpath, using index Hint: check using selectorhub in browser
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("john@e.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		//If we don't have unique selectors then how to handle using css-selector, using :nth-child Hint: check using selectorhub in browser
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("John@gmail.com");
	}
}
