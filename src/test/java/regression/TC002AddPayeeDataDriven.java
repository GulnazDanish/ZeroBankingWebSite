package regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.ExcelReader;

public class TC002AddPayeeDataDriven {
	WebDriver driver;

	@Test(dataProvider = "payeeDetails")
	public void verifyAddPayee(String payeeName, String payeeAdd, String payeeAcc, String payeeDetails) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);

		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		String expectedTitle = "Zero - Account Summary";
		String firstPageTile = "Zero - Log in";
		String originalTitle = driver.getTitle();

		Assert.assertEquals(originalTitle, expectedTitle);

		driver.findElement(By.linkText("Pay Bills")).click();
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add New Payee")));
		driver.findElement(By.linkText("Add New Payee")).click();
		driver.findElement(By.id("np_new_payee_name")).sendKeys(payeeName);
		driver.findElement(By.id("np_new_payee_address")).sendKeys(payeeAdd);
		driver.findElement(By.id("np_new_payee_account")).sendKeys(payeeAcc);
		driver.findElement(By.id("np_new_payee_details")).sendKeys(payeeDetails);
		driver.findElement(By.id("add_new_payee")).click();

		System.out.println(driver.findElement(By.id("alert_content")).getText());

		// driver.findElement(By.linkText("username")).click();
		driver.manage().window().maximize();
		// driver.quit();*/

	}

	@DataProvider(name = "payeeDetails")
	public Object[][] passdata() {
		// create 2D array name data with 3 rows and 2 column
		Object[][] data = new Object[3][4];

		ExcelReader config = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\testdataAddPayee.xlsx");

		int rows = config.getRowCount(0); // Sheet #

		System.out.println(rows);

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < 4; j++) {

				data[i][j] = config.getData(0, i, j);

			}

		}

		return data;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
