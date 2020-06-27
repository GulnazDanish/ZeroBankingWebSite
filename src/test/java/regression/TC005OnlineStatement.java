package regression;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC005OnlineStatement extends TC001Login{
	
	@Test
	public void verifyOnlineStatement() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("signin_button")).click();
		
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		String expectedTitle = "Zero - Account Summary";
		String firstPageTile ="Zero - Log in";
		String originalTitle = driver.getTitle();
		
		
		if(originalTitle.equals(expectedTitle))
			System.out.println("passed");
		else if(originalTitle.equals(firstPageTile))
			System.out.println("failed, Still on Login Page");
		
		
		
		driver.findElement(By.linkText("Online Statements")).click();
		Select s = new Select(driver.findElement(By.id("os_accountId")));
		s.selectByValue("4");
		 WebDriverWait w =new WebDriverWait(driver,30);
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'2012')]")));

		  driver.findElement(By.xpath("//div[@id='os_2012']//a[contains(text(),'Statement 01')]")).click();
		  driver.quit();

	
	}

}
