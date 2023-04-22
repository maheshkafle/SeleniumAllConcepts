
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		
		//Chrome-Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		Set<String> windows = driver.getWindowHandles(); //[parentId, childId, subChildId]
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
		System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText().split(" ")[4].trim());
		String emailId = driver.findElement(By.cssSelector("p.im-para.red")).getText().split(" ")[4].trim();
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(emailId);
	}
}
