package seleniumBasicPractice;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnLinks {

	public ChromeDriver setUpDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		return driver;

	}

	public void startApp(ChromeDriver driver) throws InterruptedException, ClientProtocolException, IOException {
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// go to home
		driver.findElement(By.linkText("Go to Home Page")).click();
		String expectedTitle = "TestLeaf - Selenium Playground";
		if (driver.getTitle().contains(expectedTitle))
			System.out.println("In home page");
		
		driver.navigate().back();
		
		// find where am supposed to do without clicking
		String link = driver.findElement(By.partialLinkText("clicking")).getAttribute("href");
		System.out.println("Supposed to go to " + link);

		// verify am I broken
		WebElement eleLink = driver.findElement(By.partialLinkText("broken"));
		HttpClient client = HttpClientBuilder.create().build();

		HttpGet request = new HttpGet(eleLink.getAttribute("href"));

		HttpResponse response = client.execute(request);

		if (response.getStatusLine().getStatusCode() != 200) {
			System.out.println(eleLink.getAttribute("outerHTML") + " is broken.");

		}

		// number of links in page

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links in page " + links.size());

		// Go to Home Page (Interact with same link name)
		List<WebElement> sameLinkNameList = driver.findElements(By.linkText("Go to Home Page"));
		System.out.println("Links with same link name as 'Go to Home Page' are :"+sameLinkNameList.size());
		for(WebElement ele:sameLinkNameList) {
			ele.click();
			driver.navigate().back();
		}
		
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException, ClientProtocolException, IOException {

		LearnLinks links = new LearnLinks();
		links.startApp(links.setUpDriver());

	}

}
