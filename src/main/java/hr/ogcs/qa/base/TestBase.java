package hr.ogcs.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import hr.ogcs.qa.util.TestUtil;
import hr.ogcs.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static WebDriverWait wait;
	public static JavascriptExecutor jse;
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	public static ExtentTest grandChildTest;
	private static Boolean remoteWeb = false;
	public static String root;
	
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/hr/ogcs"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeSuite
	public void beforeSuite() {
		
	    if(TestUtil.isWindows()) {
	    	root = System.getProperty("user.dir");
	    }
	    else {
	    	root = "/builds/qa/eaglesAutomationPOM";
	    }
	    
	    TestUtil.deleteZippedReportDirectory();
		reporter = new ExtentHtmlReporter( root + "/extents/extent.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@AfterSuite
	public void afterSuite() throws IOException {
    	System.out.print("After suite \n");
		extent.flush();
		TestUtil.viewFiles(root + "/extents/");
		TestUtil.pack(root + "/extents/", root + "/zipped_report/report_" + System.currentTimeMillis() + ".zip");
		TestUtil.viewFiles(root + "/zipped_report/");
	}
	
	public static void initialization() throws MalformedURLException{
		if(remoteWeb) {
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			ChromeOptions  chrome_options = new ChromeOptions();
			chrome_options.addArguments("--no-sandbox", "--disable-setuid-sandbox");		
			caps.setBrowserName("chrome");
			caps.setPlatform(Platform.LINUX);
			caps.setCapability(ChromeOptions.CAPABILITY, chrome_options);
			caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

			driver = new RemoteWebDriver(new URL(prop.getProperty("seleniumadress")), caps);
			jse = (JavascriptExecutor) driver; 
			//setting local file detector that server recognize place from whome to load files
			//without it, it can't load files in test
		}
		else {
			String browserName = prop.getProperty("browser");
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");	
				driver = new ChromeDriver(); 
			}
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		wait = new WebDriverWait(driver, 10);
		jse = (JavascriptExecutor) driver; 
		driver = e_driver;
	    driver.manage().window().setSize(new Dimension(1536,864));

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get("https://login.veevavault.com/");
	}
}
