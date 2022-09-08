package seleniumBasicPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewfacebookAccount {
	
	public ChromeDriver setUpDriver() {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		//WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		return driver;

	}
	
	public void startApp(ChromeDriver driver) throws InterruptedException {
		
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Click on Create New Account button
		driver.findElement(By.linkText("Create New Account")).click();
		//Enter first name
		driver.findElement(By.name("firstname")).sendKeys("Sindhya");
		//Enter the last name
		driver.findElement(By.name("lastname")).sendKeys("Baskar");
		//Enter the mobile number
		driver.findElement(By.name("reg_email__")).sendKeys("9845326778");
		//Enterthe password
		
		driver.findElement(By.id("password_step_input")).sendKeys("testP@ssword123!");
		
		Thread.sleep(3000);
		//Handle all the three drop downs - DOB
		WebElement eleDay = driver.findElement(By.id("day"));
		WebElement eleMonth = driver.findElement(By.id("month"));
		WebElement eleYear = driver.findElement(By.id("year"));
		
		Select selDay=new Select(eleDay);
		Select selMonth=new Select(eleMonth);
		Select selYear=new Select(eleYear);
		
		selDay.selectByVisibleText("9");
		selMonth.selectByVisibleText("Jun");
		selYear.selectByVisibleText("1994");
		
		// Select the radio button "Female"
		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();
		
		driver.close();
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		CreateNewfacebookAccount newAcc=new CreateNewfacebookAccount();
		newAcc.startApp(newAcc.setUpDriver());
	}

}
