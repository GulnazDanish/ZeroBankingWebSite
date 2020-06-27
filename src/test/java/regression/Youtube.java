package regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Youtube {

    @Test(dataProvider="credit")
public void youtube(String search) throws InterruptedException {


// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://www.youtube.com/");
driver.findElement(By.xpath("//input[@id='search']")).sendKeys(search);
driver.findElement(By.xpath("//yt-icon[@class='style-scope ytd-searchbox']")).click();

Thread.sleep(9000);

driver.quit();

}

    @DataProvider(name="credit")
   
    public Object[] passdata(){
   
    Object[] data= new Object[3];
   
    data[0]="appium testing";
    data[1]="selenium testing";
    data[2]="mobile testing";
          
       return data;
    }
   
   
   
   
   
}