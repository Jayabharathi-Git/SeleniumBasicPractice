package seleniumBasicPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnRadioButtons {

	public ChromeDriver setUpDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		return driver;

	}

	public void startApp(ChromeDriver driver) throws InterruptedException {
		driver.get("http://www.leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Are you enjoying the classes?
		driver.findElement(By.xpath("//input[@id='yes']")).click();

		// Find default selected radio button

		findDefSelectedRadio(driver);

		// Select your age group (Only if choice wasn't selected)
		selectAgeGroup(driver);

		driver.close();

	}

	public void selectAgeGroup(ChromeDriver driver) {
		// TODO Auto-generated method stub
		List<WebElement> eleAgeRadio = driver
				.findElements(By.xpath("//label[contains(text(),'age')]/following-sibling::input"));
		String eleAgeDiv = driver.findElement(By.xpath("//label[contains(text(),'age')]/parent::div")).getText();
		String[] splitAgeLimit = getAgeCategoryText(eleAgeDiv);

		for (int i = 0; i < eleAgeRadio.size(); i++) {
			if (eleAgeRadio.get(i).isSelected() && splitAgeLimit[i].equals("21 - 40 years")) {
				System.out.println("Already Selected age group : " + splitAgeLimit[i]);
			} else if (!eleAgeRadio.get(i).isSelected() && splitAgeLimit[i].equals("21 - 40 years")) {
				eleAgeRadio.get(i).click();
			}

		}

	}

	public String[] getAgeCategoryText(String eleAgeDiv) {
		// TODO Auto-generated method stub
		String[] splitNewLineAge = eleAgeDiv.split("[\\r\\n]+");
		String ageRadioOptions = splitNewLineAge[1];

		int indexOfS = ageRadioOptions.indexOf("s");

		int indexOfAbove = ageRadioOptions.indexOf("Above");

		String age1 = ageRadioOptions.substring(0, ageRadioOptions.indexOf("s", 0) + 1);

		String age2 = ageRadioOptions.substring(indexOfS + 2, ageRadioOptions.indexOf("s", indexOfS + 2) + 1);

		String age3 = ageRadioOptions.substring(indexOfAbove);

		String[] splitAgeLimit = { age1, age2, age3 };

		return splitAgeLimit;

	}

	public void findDefSelectedRadio(ChromeDriver driver) {
		// TODO Auto-generated method stub
		String divDef = driver.findElement(By.xpath("//label[contains(text(),'default')]/parent::div")).getText();
		String[] split = getOPtionsText(divDef);

		List<WebElement> eleRadio = driver.findElements(By.name("news"));

		for (int i = 0; i < eleRadio.size(); i++) {
			if (eleRadio.get(i).isSelected())
				System.out.println("Default selected radio button :" + " " + split[i]);

		}

	}

	public String[] getOPtionsText(String divDef) {
		// TODO Auto-generated method stub

		String[] splitNewLine = divDef.split("[\\r\\n]+");
		String options = splitNewLine[1];
		String[] split = options.split(" ");
		return split;

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		LearnRadioButtons radio = new LearnRadioButtons();
		radio.startApp(radio.setUpDriver());
	}

}
