import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		/*Implicit Wait
		 * Advantage: Applied for each and every elements this is why code is readable
		 * Disadvantage: Hide performance issue in our web application so it may not be caught by this wait.
		 * */
		
		/*Explicit Wait
		 * Advantage: No performance issues as wait is applied at only targeted elements
		 * Disadvantage: Wait is applied at only targeted elements this is why we need to write more code
		 * */
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w = new WebDriverWait(driver, 5);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		//Add some wait before getting total products
		Thread.sleep(3000);
		driver.manage().window().maximize();
		String[] itemsNeeded = {"Brocolli","Beetroot", "Cucumber", "Carrot"};
		Additems(driver, itemsNeeded);	
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		//Explicit Wait target to promoCode input field
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//Explicit Wait target to text that gets visible after applying promo Code
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}
	
	public static void Additems(WebDriver driver, String[] itemsNeeded) {
		int countOfFoundItems = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0; i<products.size(); i++) {
			
			String[] productName = products.get(i).getText().split("-");
			//productName[0] = Brocolli
			//productName[1] = 1 Kg
			String formattedProductName = productName[0].trim();
			//convert array to ArrayList for easy search
			//Then check whether name you extracted is present inside ArrayList or not
			List itemNeededList = Arrays.asList(itemsNeeded);
			if(itemNeededList.contains(formattedProductName)){
				countOfFoundItems++;
				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(); //Not adviced as Text changes from ADD TO CART -> ADDED so this is inconsistent locator
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(countOfFoundItems == itemsNeeded.length)
					break;
			}
		}
	}
}

