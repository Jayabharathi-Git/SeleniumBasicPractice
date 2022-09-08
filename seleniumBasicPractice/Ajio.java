package seleniumBasicPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public ChromeDriver setUpDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		return driver;
	}
	
	public void startApp(ChromeDriver driver) throws InterruptedException {
		
		//Launch the URL
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//In the search box, type as "bags" and press enter
		driver.findElement(By.name("searchVal")).sendKeys("bags"+ "\n");
		//To the left  of the screen under " Gender" click the "Men"
		driver.findElement(By.xpath("//input[@id='Men']/following-sibling::label")).click();
		// Under "Category" click "Fashion Bags"
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='Men - Fashion Bags']/following-sibling::label")).click();
		//Print the count of the items Found
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//div[@class='length']")).getText());
		//Get the list of brand of the products displayed in the page and print the list
		List<WebElement> eleBrands = driver.findElements(By.xpath("//div[@class='brand']"));
		System.out.println("Brand of the products displayed in the page are---- ");
		for(WebElement e:eleBrands)
			System.out.println(e.getText());
		//Get the list of names of the bags and print
		List<WebElement> eleBagNames = driver.findElements(By.xpath("//div[@class='nameCls']"));
		System.out.println("Names of the bags in the page are-----");
		for(WebElement e:eleBagNames)
			System.out.println(e.getText());
		
		driver.close();
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Ajio aj=new Ajio();
		aj.startApp(aj.setUpDriver());
	}

}
