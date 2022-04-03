package Seleniumgrid;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Chrome {

	 public static WebDriver driver;
	
	@Test
	public void Openbrowser() throws IOException, InterruptedException
	{
		String nodeURL = "http://10.0.0.16:38734/wd/hub";
		System.setProperty("webdriver.ie.driver","D:\\Selenium grid\\IEDriverServer.exe");
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setPlatform(Platform.ANY);
        driver = new RemoteWebDriver(new URL(nodeURL), cap);
        
        driver.manage().window().maximize();
		System.out.println("Window maximised");
		String baseUrl = "https://b2bui2.tltid.com/login";
		String expectedTitle = "Login";
		String actualTitle = "";
		driver.get(baseUrl);
		actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		if (actualTitle.contentEquals(expectedTitle))
		{
			System.out.println("Test passed");

		} 
		else 
		{
			System.out.println("Test Failed");

		} 
		System.out.println("driver="+driver);
		WebDriverWait wait =new WebDriverWait(driver,100);
		Thread.sleep(10);
		WebElement Element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		String b = Element.getText();
		System.out.println(b);
		Element.click();
		if(b.contentEquals("Login"))
		{
			System.out.println("Test passed");
		} 
		else 
		{
			System.out.println("Test Failed");
		}
		System.out.println("driver="+driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
		username.click();
		System.out.println("username field clicked");
		username.sendKeys("a.pandian@wintlt.com");
		System.out.println("Username field entered");
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.click();
		System.out.println("password field clicked");
		password.sendKeys("12345S#");
		System.out.println("password field entered");
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
		System.out.println("driver="+driver);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebDriverWait wait2 = new WebDriverWait(driver, 100);
		Thread.sleep(30000);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[2]"))).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("YVR");
     	System.out.println("driver="+driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait21 = new WebDriverWait(driver, 10);
		wait21.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[3]"))).click();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("YYZ");
		driver.close();
		System.out.println("browser closed");

	}

}



