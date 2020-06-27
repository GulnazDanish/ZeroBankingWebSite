package regression;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TC001LoginExtentReports {

	public WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		report = new ExtentReports("C:\\BusyQAWorkspace\\ZeroBankingWebSite\\src\\test\\resources\\ExtentReports\\Report.html");
		driver.get("http://zero.webappsecurity.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
	}

	@Test
	public void verifyLogin() {
		// TODO Auto-generated method stub
		test = report.startTest("Login Test");
		driver.findElement(By.id("signin_button")).click();
		test.log(LogStatus.INFO, "Clicked on SignIn");

		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		String expectedTitle = "Zero - Account Summary";
	//	String firstPageTile = "Zero - Log in";
		String originalTitle = driver.getTitle();
		//Assert.assertTrue(false);
		Assert.assertEquals(originalTitle, expectedTitle);

		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		report.endTest(test);
		report.flush();

	}

}
