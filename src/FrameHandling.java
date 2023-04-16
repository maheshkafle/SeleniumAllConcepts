import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameHandling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaflemah\\OneDrive - Lisec Holding GmbH\\Documents\\Projects\\Udemy\\Introduction\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		//1st way to handle frame .frame(WebElement)
		//driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		
		//2nd way to handle frame .frame(index)
		//Step 1 Get no. of frames in webpage
		System.out.println(driver.findElements(By.tagName("frame")).size());
		//Step 2. then give appropriate index to which you want to switch to. 
		//Note: By default frame starts from index zero(0).
		driver.switchTo().frame(0);
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		//Make sure to switchTo defaultContent once you are done with all of your frame actions
		driver.switchTo().defaultContent();


	}

}
