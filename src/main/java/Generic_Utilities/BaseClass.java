package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Object_Repository.Home_Page;
import Object_Repository.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public PropertyFile_Utility fu=new PropertyFile_Utility();
	public Excel_Utility eu=new Excel_Utility();
	public Java_Utility ju=new Java_Utility();
	public Webdriver_Utility wu=new Webdriver_Utility();
	
	public static WebDriver sDriver;
	
	@BeforeSuite
	public void before_Suite() {
		System.out.println("DB Connection Sucessful");
	}
	
	@BeforeTest
	public void before_Test() {
		System.out.println("Before Test Sucessful");
	}
	
	@BeforeClass
	public void launch_Browser() throws Throwable {
		String BROWSER=fu.getDAtaFromPropertyFile("browser");
		
		if(BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println(BROWSER+"---->"+"Launched Sucessfully");
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(BROWSER+"---->"+"Launched Sucessfully");
		}
		
		else if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(BROWSER+"---->"+"Launched Sucessfully");
		}
		else {
			System.out.println("INVALID DRIVER");
		}
		
		String URL=fu.getDAtaFromPropertyFile("url");
		
		wu.MaxiMizeWindow(driver);
		driver.get(URL);
		wu.implicitlyWait(driver);
		
		sDriver=driver;
		
	}
	
	@BeforeMethod
	public void login_Application() throws Throwable {
		Login_Page lp=new Login_Page(driver);
		lp.login_Application();
		
		System.out.println("LOGIN SUCESSFUL");
	}
	
	@AfterMethod
	public void logout_Application() {
		
		Home_Page hp=new Home_Page(driver);
		hp.Signout_Application(driver);
		System.out.println("LOGIN SUCESSFUL");
	}
	@AfterClass
	public void close_Driver() {
		driver.quit();
		System.out.println("DRIVER CLOSED SUCESSFULLY");
	}
	
	@AfterTest
	public void after_Test() {
		System.out.println("After Test");
	}
	
	@AfterSuite
	public void after_Suite() {
		
		System.out.println("After Suite");
	}
}
