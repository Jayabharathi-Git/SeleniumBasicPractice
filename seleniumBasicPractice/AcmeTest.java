package seleniumBasicPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeTest {
	
	public ChromeDriver setUpDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		return driver;

	}

	public void startApp(ChromeDriver driver) {
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//enter email
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		//enter password
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		//click login
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//get title and print
		System.out.println("Page Title : "+driver.getTitle());
		//click logout
		driver.findElement(By.linkText("Log Out")).click();
		
		driver.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AcmeTest test = new AcmeTest();
		test.startApp(test.setUpDriver());

	}

}
