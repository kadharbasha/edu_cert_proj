package testng;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AboutPageTestCase {
WebDriver driver;
@BeforeMethod
public void launch(){
  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("http://35.176.161.136");
  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  String x= driver.getTitle();
  System.out.println(x);
  }
@Test
public void verifytest() {
	
 driver.findElement(By.xpath("//a[@href='/content/about-us.php']")).click();
 String bodyText = driver.findElement(By.xpath("//p[@id='PID-ab2-pg']")).getText();
 Assert.assertTrue(bodyText.contains("Kadhar Basha"), "Text not found!");
}
@AfterMethod
public void close(){
  driver.close();
}
}
