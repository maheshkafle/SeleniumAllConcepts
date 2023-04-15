import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class HandlingCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		//Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		System.out.println("isSeleted: "+ driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());
		//Hint: Incase of Assert.assert stmt. if test fails, then only program execution fails else nothing happens
		Assert.assertFalse(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected()); //assertFalse expects False inside it, and if so result is true else false
		driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).click();
		Thread.sleep(2000);
		System.out.println("isSeleted: "+ driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());
		//Hint: Incase of Assert.assert stmt. if test fails, then only program execution fails else nothing happens
		Assert.assertTrue(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	}

}
