package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;

	@BeforeSuite
	public void setUp() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
	}

	@AfterSuite
	public void tearDown() {
		if(driver!=null) {
			driver.close();
			driver.quit();
		}

	}
}
