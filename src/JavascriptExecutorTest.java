import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class JavascriptExecutorTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 500)");	
		Thread.sleep(3000);
	    js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
	    
	    List<WebElement> data = driver.findElements(By.cssSelector("div[class='tableFixHead'] td:nth-child(4)"));
	    int actualSum=0;
	    for(int i=0; i<data.size(); i++) {
	    	String parseText = driver.findElements(By.cssSelector("div[class='tableFixHead'] td:nth-child(4)")).get(i).getText();
	    	actualSum = actualSum + Integer.parseInt(parseText);
	    }
	    System.out.println(actualSum);
	    int expectedValue = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
	    Assert.assertEquals(actualSum, expectedValue);
	}
}
