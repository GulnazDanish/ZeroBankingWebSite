package regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC001LoginDataDriven {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
	}

	@Test(dataProvider = "credential")
	public void verifyLogin(String username, String password) {
		// TODO Auto-generated method stub

		driver.findElement(By.id("signin_button")).click();

		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		String expectedTitle = "Zero - Account Summary";
		String firstPageTile = "Zero - Log in";
		String originalTitle = driver.getTitle();
		//Assert.assertTrue(false);
		Assert.assertEquals(originalTitle, expectedTitle);

		driver.manage().window().maximize();

	}
	
	@DataProvider(name="credential")
	public Object[][] passdata(){
	//create 2D array name data with 3 rows and 2 column
	Object[][] data = new Object[3][2];
	//we have input data 	
	data[0][0]="username";
	data[0][1]="password";
	
	data[1][0]="Tye";
	data[1][1]="tutorial";	
	
	data[2][0]="Naresh";
	data[2][1]="tutorial";
	return data;
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
