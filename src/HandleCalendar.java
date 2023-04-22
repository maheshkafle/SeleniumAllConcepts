import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCalendar {

	static String url ="https://www.path2usa.com/travel-companion";
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get(url);	
		driver.manage().window().maximize();
	
		// Scroll the Page	
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		js.executeScript("window.scrollBy(0,800)");
	
		// Click on the Date field	
		Thread.sleep(3000);	
		driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).click();	
		WebElement month = driver.findElement(By.xpath("//div[@class='flatpickr-current-month']"));
	
		//WIP: Got stuck in this line 
		while(!month.getText().equalsIgnoreCase("August")){
		    driver.findElement(By.cssSelector("span[class='flatpickr-next-month']")).click();	
		    Thread.sleep(200);
		}
	
		int count= driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).size();
		for(int i=0;i<count;i++){	
		     String text=driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();
		     if(text.equalsIgnoreCase("26")){
			     // driver.findElements(By.cssSelector("td[class*='day']")).get(i).click();
			     driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
				 System.out.println(text);
				 break;	
		     }	
		}
		System.out.println(driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).getAttribute("value"));
	}
}