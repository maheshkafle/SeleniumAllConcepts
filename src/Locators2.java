import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String name = "rahul";
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		//When the attribute value is dynamic which keeps changing everytime then we use regex in locators too
		//Example showing to create cssSelector locator using regex
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		//Example showing to create xpath locator using regex
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
		Thread.sleep(2000);
		//Below is an example of writing cssSelector from parent to child div
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		System.out.println(driver.findElement(By.tagName("p")).getText());
		//xpath has special way to detect webElement with text() function also. Also if we know that webElement is unique 
		// then we can use * inplace of tagName e.g //*[text()='Log Out']
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
		
	}

}
