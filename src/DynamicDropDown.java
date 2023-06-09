import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {
		//Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		driver.manage().window().maximize();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		System.out.println(driver.findElement(By.xpath("//a[@value='BLR']")).getText());
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//a[@value='MAA']")).click(); //This will fail because two values will be there for same xpath so couldn't select it
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); //->This may not be most perfect way to locate element because it returns two webElements with given xpath
		System.out.println(driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).getText());
		//In order to Narrow down the scope to find the webelement we use parent-child relationship	locator to identify objects uniquely
		//Syntax ->parent-xpath child-xpath
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
//		driver.findElement(By.name("ctl00$mainContent$view_date1")).click();
//		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

//		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
//		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled()); //->isEnabled returned true though this field is disabled.
		//Alternate way to figure out if field is disabled or not
		System.out.println("Before click on Two way radio button ->"+driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println("After click on Two way radio button ->"+ driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("Div1 is enabled");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
}
