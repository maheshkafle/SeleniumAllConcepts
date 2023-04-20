import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebPageLinksCount {

	public static void main(String[] args) {
		//HCL Tech Interview Questions
		//1. Write code to print total count of links in webpage
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. Get all the links in footer section of webPage
		//   Limit driver to footer section by creating footerDriver
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//3. Get all the links in first column inside footer section
		WebElement columndriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		int totalLinks = columndriver.findElements(By.tagName("a")).size();
		
		//3. click on each link in column and check if pages are opening
		for(int i=1; i< totalLinks; i++) {
			columndriver.findElements(By.tagName("a")).get(i).click();
		}
		
	}
}
