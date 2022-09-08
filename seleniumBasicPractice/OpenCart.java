package seleniumBasicPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCart {
	
	public ChromeDriver setUpDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		return driver;

	}

	public void startApp(ChromeDriver driver) {
		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//enter username
		driver.findElement(By.id("input-username")).sendKeys("DrStrange");
		//enter firstname
		driver.findElement(By.id("input-firstname")).sendKeys("Stephen");
		//enter lastname
		driver.findElement(By.id("input-lastname")).sendKeys("Strange");
		//select country
		WebElement eleCountry = driver.findElement(By.id("input-country"));
		Select selCountry=new Select(eleCountry);
		selCountry.selectByIndex(12);
		
		driver.close();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OpenCart cart=new OpenCart();
		cart.startApp(cart.setUpDriver());
		
		

	}

}
