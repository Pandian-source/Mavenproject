package Hotel;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hotel_class 
{
	public WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Pandiyan\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testHotelLogin() throws Exception 
	{ 
		driver.manage().window().maximize();
		driver.get("https://b2bui2.tltid.com/login");
		driver.findElement(By.xpath("//input[@value='']")).click();
		driver.findElement(By.xpath("//input[@value='']")).sendKeys("a.pandian@wintlt.com");
		driver.findElement(By.xpath("(//input[@value=''])[2]")).click();
		driver.findElement(By.xpath("(//input[@value=''])[2]")).sendKeys("12345S#");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(.,'Hotels')]")).click();
	}
	@Test
	public void testSearchForm() throws Exception 
	{
		driver.findElement(By.xpath("(//input[@name=''])[5]")).click();
		driver.findElement(By.xpath("(//input[@name=''])[5]")).sendKeys("mrst");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		driver.findElement(By.xpath("//fieldset[@id='__BVID__517']/div/div/div[3]/ul/li/span")).click();
		driver.findElement(By.xpath("(//input[@name=''])[6]")).clear();
		driver.findElement(By.xpath("(//input[@name=''])[6]")).sendKeys("singapore");
		driver.findElement(By.xpath("(//div[@type='button'])[310]")).click();
		driver.findElement(By.xpath("(//div[@type='button'])[313]")).click();
		driver.findElement(By.xpath("//fieldset[@id='__BVID__2474']/div/div/div[3]/ul/li[2]/span")).click();
		driver.findElement(By.xpath("(//input[@name=''])[7]")).clear();
		driver.findElement(By.xpath("(//input[@name=''])[7]")).sendKeys("india");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		driver.findElement(By.linkText("Hotel Details")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
	}


	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}}
