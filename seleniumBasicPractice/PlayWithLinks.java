package seleniumBasicPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlayWithLinks {

	public ChromeDriver setUpDriver() {
		// driver setup
		WebDriverManager.chromedriver().setup();
		// launch browser
		ChromeDriver driver = new ChromeDriver();
		return driver;

	}

	public void startApp(ChromeDriver driver) {
		// go to url
		driver.get("http://www.leafground.com/pages/Link.html");
		// maximize
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Get all the links
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		// Click on the first link
		allLinks.get(0).click();
		// Print the title
		System.out.println(driver.getTitle());
		// Navigate back on the browser
		driver.navigate().back();
		// Get all the links again
		List<WebElement> newLinks = driver.findElements(By.tagName("a"));
		// Print the count of the links (size)
		System.out.println("Link count " + newLinks.size());

		// print the href value (getAttribute) of the second link
		System.out.println(newLinks.get(1).getAttribute("href"));

		driver.close();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PlayWithLinks links = new PlayWithLinks();
		links.startApp(links.setUpDriver());

	}

}
