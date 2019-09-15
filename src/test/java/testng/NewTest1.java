package testng;

import org.testng.annotations.Test;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class NewTest1 {
WebDriver driver;
@BeforeMethod
public void launch(){
  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("http://3.9.177.35/");
  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  String x= driver.getTitle();
  System.out.println(x);
  }
@Test
public void verifytest() {
 
 //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mi a3 mobile");
 driver.findElement(By.xpath("//a[@href='/content/about-us.php']")).click();
 String text = "testing";
java.util.List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text  + "')]"));
 Assert.assertTrue(list.size() > 0, "Text not found!");
 
}
@AfterMethod
public void close(){
  //driver.close();
}
}
