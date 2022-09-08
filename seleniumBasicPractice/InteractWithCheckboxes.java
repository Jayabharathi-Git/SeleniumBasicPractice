package seleniumBasicPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithCheckboxes {

	public ChromeDriver setUpDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		return driver;

	}

	public void startApp(ChromeDriver driver) {
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Select the languages that you know?

		// System.out.println(driver.findElement(By.xpath("//label[contains(text(),'languages')]/parent::div")).getText());

		List<WebElement> langCheckboxes = driver
				.findElements(By.xpath("//label[contains(text(),'languages')]/following-sibling::input"));
		for (int i = 0; i < langCheckboxes.size(); i++) {
			if (i == 0 || i == 2)
				langCheckboxes.get(i).click();
		}

		// Confirm Selenium is checked
		if (driver.findElement(By.xpath("//label[contains(text(),'Selenium')]/following-sibling::input"))
				.isSelected() != false)
			System.out.println("Selenium is selected");

		// DeSelect only checked
		List<WebElement> eleToDeselect = driver
				.findElements(By.xpath("//label[contains(text(),'DeSelect')]/following-sibling::input"));
		for (int i = 0; i < eleToDeselect.size(); i++) {
			if (eleToDeselect.get(i).isSelected())
				eleToDeselect.get(i).click();

		}
		
		//Select all below checkboxes
		
		List<WebElement> eleAll = driver.findElements(By.xpath("//label[contains(text(),'all')]/following-sibling::input"));
		for(WebElement e:eleAll)
			e.click();
		
		driver.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InteractWithCheckboxes chckBox = new InteractWithCheckboxes();
		chckBox.startApp(chckBox.setUpDriver());

	}

}
