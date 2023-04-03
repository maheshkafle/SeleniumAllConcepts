import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
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
		//If there is a transition between one state to other in webpage, then some elements may not load completely, in such case we use Thread.sleep
		Thread.sleep(1000);
		//customized Xpath -  //Tagname[@attribute='value']
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		//If we don't have unique selectors then how to handle using xpath, using index Hint: check using selectorhub in browser
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("john@e.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		//If we don't have unique selectors then how to handle using css-selector, using :nth-child Hint: check using selectorhub in browser
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("John@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("981234512");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector(".infoMsg")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		//When the attribute value is dynamic which keeps changing everytime then we use regex in locators too
		//Example showing to create cssSelector locator using regex
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		//Example showing to create xpath locator using regex
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
		
		
	}
}
