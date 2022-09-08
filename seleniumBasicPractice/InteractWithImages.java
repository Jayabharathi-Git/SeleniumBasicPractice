package seleniumBasicPractice;

import java.io.IOException;
import java.time.Duration;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithImages {

	public ChromeDriver setUpDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		return driver;

	}

	public void startApp(ChromeDriver driver) throws InterruptedException, IOException {
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on this image to go home page
		driver.findElement(By.xpath("//label[contains(text(),'home')]/following-sibling::img")).click();

		driver.navigate().back();

		// Am I Broken Image?

		WebElement eleImg = driver.findElement(By.xpath("//label[contains(text(),'Broken')]/following-sibling::img"));
		eleImg.getAttribute("src");

		HttpClient client = HttpClientBuilder.create().build();

		HttpGet request = new HttpGet(eleImg.getAttribute("src"));

		HttpResponse response = client.execute(request);

		if (response.getStatusLine().getStatusCode() != 200) {
			System.out.println(eleImg.getAttribute("outerHTML") + " is broken.");

		}
		
		//Click me using Keyboard or Mouse
		
		driver.findElement(By.xpath("//label[contains(text(),'Mouse')]/following-sibling::img")).click();
		
		driver.navigate().back();
		
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		InteractWithImages imgs= new InteractWithImages();
		imgs.startApp(imgs.setUpDriver());
	}

}
