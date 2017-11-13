/***********************************************************************
 * @author 			:		RaghuKiran MR
 * @description		: 		Base library with reusable methods that can be used across porjects.
 * @method			:		setup()
 * @method			:		tearDown()
 * @method			:		loadURL()
 * @method 			:		elementStatus()
 * @method          :       visibilityOfElementWait()
 * @method			: 		xpath()
 * @method			: 		databaseTest()
 * @method			: 		LoginGmail()
 */

package com.liqvid.library;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.liqvid.page.DataBasePage;
import com.liqvid.page.ForgotPasswordPage;
import com.liqvid.page.StudentSignInPage;


public class BaseLib {
	public static WebDriver driver;
	public static int sStatusCnt=0;
	WebDriverWait wait=null;
	public DataBasePage databasePage=null;
	ForgotPasswordPage forgotPasswordPage=null;
	StudentSignInPage studentSignInPage=null;
	String sTestData=null;
	String[] sData=null;

	
	/* 
	 * @Description:Setup the baselib for the browser.
	 * @Author:RaghuKiran MR   
	 */
	@BeforeMethod
	public void setUp(){
		try{
		if(GenericLib.getCongigValue(GenericLib.sConfigFile, "BROWSER").equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver",GenericLib.sDirPath+"\\resources\\chromedriver30.exe");
			driver = new ChromeDriver();
		}else if(GenericLib.getCongigValue(GenericLib.sConfigFile, "BROWSER").equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver",GenericLib.sDirPath+"\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		NXGReports.setWebDriver(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void loadURL(String sUrl) throws InterruptedException
	{
		try{
			driver.get(sUrl);
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Thread.sleep(2000);
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


