package regression;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class TC003TransferFund extends TC001Login{
	
	@Test
	public void verifyTransferFund() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
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
		driver.findElement(By.linkText("Transfer Funds")).click();
		Select s = new Select(driver.findElement(By.id("tf_fromAccountId")));
		s.selectByValue("2");
		
		Select s2 = new Select(driver.findElement(By.id("tf_toAccountId")));
		s2.selectByValue("3");
		
		driver.findElement(By.id("tf_amount")).sendKeys("200");
		driver.findElement(By.id("tf_description")).sendKeys("Gift");
		driver.findElement(By.id("btn_submit")).click();
		driver.findElement(By.id("btn_submit")).click();
		System.out.println(driver.findElement(By.cssSelector("div[class='alert alert-success']")).getText());
	}

}
