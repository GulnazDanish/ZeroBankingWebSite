package regression;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002AddPayee extends TC001Login {

	@Test
	public void verifyAddPayee() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
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
		driver.findElement(By.id("np_new_payee_name")).sendKeys("CIBC");
		driver.findElement(By.id("np_new_payee_address")).sendKeys("abc");
		driver.findElement(By.id("np_new_payee_account")).sendKeys("XYZ");
		driver.findElement(By.id("np_new_payee_details")).sendKeys("123");
		driver.findElement(By.id("add_new_payee")).click();

		System.out.println(driver.findElement(By.id("alert_content")).getText());

		// driver.findElement(By.linkText("username")).click();
		driver.manage().window().maximize();
		// driver.quit();*/

	}

}
