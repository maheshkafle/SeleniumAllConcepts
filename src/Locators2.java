import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		
        //Chrome Browser
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		//Firefox Browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\geckodriver-v0.32.2-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//MsEdge Browser
//		System.setProperty("webdriver.edge.driver", "C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\edgedriver_win64\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String password = GetPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String name = "rahul";
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		//When the attribute value is dynamic which keeps changing everytime then we use regex in locators too
		//Example showing to create cssSelector locator using regex
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
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
	
	public static String GetPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		String[] passwordArray = passwordText.split("'");
		//After split - Please use temporary password rahulshettyacademy' to Login.
		//0th Index - Please use temporary password
		//1th Index - rahulshettyacademy' to Login.
//		String[] passwordArray2 = passwordArray[1].split("'");
//		System.err.println(passwordArray2[0]);
		String password = passwordArray[1].split("'")[0];
		return password;
	}

}
