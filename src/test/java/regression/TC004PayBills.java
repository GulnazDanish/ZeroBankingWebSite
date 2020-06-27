package regression;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC004PayBills extends TC001Login{

	@Test
	public void verifyPayBills() {
		// TODO Auto-generated method stub
		
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
			driver.findElement(By.linkText("Pay Bills")).click();
			Select s = new Select(driver.findElement(By.id("sp_payee")));
			s.selectByValue("bofa");
			
			Select s2 = new Select(driver.findElement(By.id("sp_account")));
			s2.selectByValue("3");
			
			driver.findElement(By.id("sp_amount")).sendKeys("200");
			driver.findElement(By.id("sp_date")).click();
			String currentDay = String.valueOf(java.time.LocalDateTime.now().getDayOfMonth());
			System.out.println(driver.findElements(By.cssSelector("td[data-month='4']")).size());
			for(int i= 0; i<driver.findElements(By.cssSelector("td[data-month='4']")).size();i++) {
				String text = driver.findElements(By.cssSelector("td[data-month='4']")).get(i).getText();
				if(text.equalsIgnoreCase(currentDay)) {
					driver.findElements(By.cssSelector("td[data-month='4']")).get(i).click();
				}
			}
			
			driver.findElement(By.id("sp_description")).sendKeys("utility");
			driver.findElement(By.id("pay_saved_payees")).click();
			System.out.println(driver.findElement(By.id("alert_content")).getText());
			driver.quit();
		}

	}


