/***********************************************************************
 * @author 			:		RaghuKiran MR
 * @description		: 		Base library with reusable methods that can be used across porjects.
 * @method			:		setup()
 * @method			:		tearDown()
 * @method			:		loadURL()
 * @method 			:		elementStatus()
 * @method          :       visibilityOfElementWait()
 */

package com.liqvid.library;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.liqvid.page.DataBasePage;
import com.liqvid.page.ForgotPasswordPage;
import com.liqvid.page.StudentSignInPage;


public class ParallelBaseLib {
	public WebDriver driver;
	public static int sStatusCnt=0;
	WebDriverWait wait=null;
	public DataBasePage databasepo;
	public DataBasePage databasePage=null;
	ForgotPasswordPage forgotPasswordPage=null;
	StudentSignInPage studentSignInPage=null;
	String sTestData=null;
	String[] sData=null;

	 @Parameters("browser")
	@BeforeMethod
	public void setup(String browser){
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",GenericLib.sDirPath+"\\resources\\geckodriver.exe");
			  driver = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("ie")) { 
			 
		 
			System.setProperty("webdriver.ie.driver", GenericLib.sDirPath+"\\resources\\IEDriverServer.exe");
		 
			  driver = new InternetExplorerDriver();
		 
		  } else if (browser.equalsIgnoreCase("chrome")) { 
				 
				 
			  System.setProperty("webdriver.chrome.driver",GenericLib.sDirPath+"\\resources\\chromedriver1.exe");
			 
				driver = new ChromeDriver();
			 
			  }
		NXGReports.setWebDriver(driver);
		
	}
	 public void loadURL(String sUrl)
		{
			try{
				driver.get(sUrl);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}catch(AssertionError e){
				NXGReports.addStep("Failed to load URL.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				throw e;
			}	
		}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}


