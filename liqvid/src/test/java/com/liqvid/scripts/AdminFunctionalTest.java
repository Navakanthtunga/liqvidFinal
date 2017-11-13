package com.liqvid.scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.liqvid.library.BaseLib;
import com.liqvid.library.GenericLib;
import com.liqvid.library.ParallelBaseLib;
import com.liqvid.page.AdminBatchReportPage;
import com.liqvid.page.AdminHomePage;
import com.liqvid.page.AdminProfilePage;
import com.liqvid.page.AdminRegConfirmPage;
import com.liqvid.page.AdminSignupPage;
import com.liqvid.page.CreateBatchPage;
import com.liqvid.page.DataBasePage;
import com.liqvid.page.ForgotPasswordPage;
import com.liqvid.page.LicensePage;
import com.liqvid.page.ResourcesPage;
import com.liqvid.page.StudentRegistrationPage;
import com.liqvid.page.StudentSignInPage;
import com.liqvid.page.StudentUploadPage;
import com.liqvid.page.SuccessfulRegisterationPage;
import com.liqvid.page.TeacherRegistrationPage;

	public class AdminFunctionalTest extends BaseLib{
	StudentSignInPage studentSignInPage=null;
	AdminHomePage adminHomePage=null;
	CreateBatchPage createBatchPage=null;
	AdminBatchReportPage adminBatchReportPage=null;
	StudentUploadPage studentUploadPage=null;
	ResourcesPage resourcesPage=null;
	TeacherRegistrationPage teacherRegistrationPage=null;
	StudentRegistrationPage studentRegisterationPage=null;
	SuccessfulRegisterationPage successfulRegisterationPage=null;
	AdminProfilePage adminProfilePage=null;
	LicensePage licensePage=null;
	AdminSignupPage adminSignupPage=null;
	AdminRegConfirmPage adminRegConfimPage=null;
	ForgotPasswordPage forgotPasswordPage=null;
	String sTestData=null;
	String[] sData=null;
	/* 
	 * @Description:Verify the registration process by entering License Key,Verify the error messages in Admin Signup Page, Verify the error messages in Admin Signup Page, Verify Admin Signup process
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=5,enabled=false,description="Verify the registartion process by entering License Key,Verify the error messages in Admin Signup Page, Verify the error messages in Admin Signup Page, Verify Admin Signup process")
	public void testAdminRegistration(String browser) throws Throwable
	{	
		licensePage=new LicensePage(driver);
		studentSignInPage=new StudentSignInPage(driver);
		adminSignupPage=new AdminSignupPage(driver);
		adminRegConfimPage=new AdminRegConfirmPage(driver);
		adminHomePage=new AdminHomePage(driver);
		sTestData="AdminRegistration_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try {
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			Thread.sleep(5000);
			// To verify the elements in License Page
			studentSignInPage.elementStatus(licensePage.getEleLogo(),"English Edge logo ","displayed");
			studentSignInPage.elementStatus(licensePage.getEleEnglishEdgeSetupText(),"English Edge Setup Text ","displayed");
			studentSignInPage.elementStatus(licensePage.getEleRegistrationHeading(),"Welcome to EnglishEdge registration process' text ","displayed");
			studentSignInPage.elementStatus(licensePage.getEleRegistrationInstructions(),"Instructions in registration page ","displayed");
			studentSignInPage.elementStatus(licensePage.getEleLicenseKeyText(),"License Key Text","displayed");
			studentSignInPage.elementStatus(licensePage.getEleLicenseKeyField(),"License Key field ","displayed");
			studentSignInPage.elementStatus(licensePage.getEleSubmitButton(),"Submit button ","displayed");
			studentSignInPage.elementStatus(licensePage.getEleCustomerSupportText(),"Customer Support text ","displayed");
			studentSignInPage.elementStatus(licensePage.getEleCustomerCareContactDetails(),"Customer Care Contact details ","displayed");
			studentSignInPage.elementStatus(licensePage.getEleCustomerCareEmailId(),"Customer Care Email Id ","displayed");
			studentSignInPage.elementStatus(licensePage.getEleEnglishEdgeWebsitelink(),"English edge website link ","displayed");
			studentSignInPage.elementStatus(licensePage.getEleEnglishEdgeWebsitelinkFooter(),"English edge website link at the Footer ","displayed");
			Thread.sleep(20000);
			// To verify 'This value is required.' error message
			licensePage.getEleSubmitButton().click();
			// To verify 'This value is too short. It should have 6 characters or more.' error message
			licensePage.getEleLicenseKeyField().sendKeys(sData[1]);
			Thread.sleep(4000);
			licensePage.getEleSubmitButton().click();
			Thread.sleep(1000);
			studentSignInPage.elementStatus(licensePage.getEleErrMsg(),"This value is too short error message ","displayed");
			// To verify the alert when an Invalid license key is passed
			licensePage.getEleLicenseKeyField().sendKeys(sData[2]); 
			Thread.sleep(5000);
			licensePage.getEleSubmitButton().click();
			Thread.sleep(4000);
			studentSignInPage.elementStatus(licensePage.getEleAlert(),"Alert","displayed");
			studentSignInPage.elementStatus(licensePage.getEleCloseAlert(),"Close icon of alert","displayed");
			Thread.sleep(5000);
			// To close the alert
			licensePage.getEleCloseAlert().click();
			// To pass valid license key
			licensePage.getEleLicenseKeyField().sendKeys(sData[3]); 
			Thread.sleep(20000);
			licensePage.getEleSubmitButton().click();
			Thread.sleep(15000);
			//Admin SignUp 
			studentSignInPage.elementStatus(adminSignupPage.getEleSignUpText(),"Sign-Up page should be ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleEnglishEdgeSetupText(),"'English Edge' Setup Text ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleEnglishEdgeLogo(),"English Edge Logo ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleSignUpText(),"'Sign-up' text ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleCenterNameText(),"Center Name text ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleCenterField(),"Center Name Field","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleCenterAddressText(),"Center Address text ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleCenterAddressField(),"Center Address Field ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleCountryText(),"Country  text ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleCountryDropDown(),"DropDown ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleStateText(),"'State' text ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleStateDropDown(),"'State' dropdown ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleCityText(),"'City' text ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleCityDropDown(),"City Dropdown ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getElePincodeText(),"'PinCode' text ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getElePincodeField(),"'PinCode' Field ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleAdminNameText(),"'Administrator Name' text ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleAdminNameField(),"'Administrator Name' Field ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleEmailIDText(),"'Email ID' text ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleEmailIdField(),"'Email ID' Field","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleEmailIdInstruction(),"'(Admin login credentials will be sent to this Email ID.)' Instruction ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleMobileNumText(),"'Mobile Number' text ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleMobileNumField(),"'Mobile Number' Field ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleMobileNumInstruction(),"'(Admin login credentials will be sent to this Mobile Number.)' Instruction ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleContactNumText(),"Contact Number text ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleContactNumField(),"Contact Number Field ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleContactNumInstruction(),"'(Enter landline number with STD code.)' Instruction  ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleCustomerSupportText(),"Customer Support text ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleCustomerCareContactDetails(),"Customer Care Contact details ","displayed");
			studentSignInPage.ScrollToViewElement(adminSignupPage.getEleEnglishEdgeWebsitelinkFooter());
			studentSignInPage.elementStatus(adminSignupPage.getEleCustomerCareEmailId(),"Customer Care Email Id ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleEnglishEdgeWebsitelink(),"English edge website link ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleCopyRightsText(),"CopyRights ","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleEnglishEdgeWebsitelinkFooter(),"English edge Website link in Copyrights","displayed");
			studentSignInPage.elementStatus(adminSignupPage.getEleSubmitButt(),"Submit button ","displayed");
			adminSignupPage.getEleSubmitButt().click();
			Thread.sleep(2000);
			// To verify 'This value is required.' Error message
			studentSignInPage.elementStatus(adminSignupPage.getEleValueReqErrMsg(),"'This value is required.' Error message ","displayed");
			//To verify error messages
			studentSignInPage.ScrollToViewElement(adminSignupPage.getEleCenterField());
			adminSignupPage.getEleCenterField().sendKeys(sData[4]);
			studentSignInPage.elementStatus(adminSignupPage.getAlphaOrAlphanumericErrMsg(),"'Value should be alpha/alphanumeric' Error message","displayed");
			adminSignupPage.getElePincodeField().sendKeys(sData[5]);
			studentSignInPage.elementStatus(adminSignupPage.getEleInValidPincodeErrMsg(),"'This value should be digits.' Error message","displayed");
			adminSignupPage.getEleEmailIdField().sendKeys(sData[6]);
			studentSignInPage.elementStatus(adminSignupPage.getEleInValidEmailErrMsg(),"'This value should be a valid email.' Error message","displayed");
			adminSignupPage.getEleMobileNumField().sendKeys(sData[7]);
			adminSignupPage.getEleContactNumField().sendKeys(sData[8]);
			studentSignInPage.elementStatus(adminSignupPage.getEleInValidPhoneNumErrMsg(),"'This value should be a valid phone number.' Error message","displayed");
			adminSignupPage.getEleCenterField().clear();
			adminSignupPage.getElePincodeField().clear();
			adminSignupPage.getEleEmailIdField().clear();
			adminSignupPage.getEleMobileNumField().clear();
			adminSignupPage.getEleContactNumField().clear();
			adminSignupPage.getEleCenterField().sendKeys(sData[9]);
			adminSignupPage.getEleCenterAddressField().sendKeys(sData[10]);
			Thread.sleep(10000);
			adminHomePage.selectbyvisibletext(adminSignupPage.getEleCountryDropDown(),"India");
			Thread.sleep(8000);
			adminHomePage.selectbyvisibletext(adminSignupPage.getEleStateDropDown(),"KARNATAKA");
			Thread.sleep(8000);
			adminHomePage.selectbyvisibletext(adminSignupPage.getEleCityDropDown(),"BANGALORE URBAN DISTRICT");
			Thread.sleep(5000);
			adminSignupPage.getElePincodeField().sendKeys(sData[11]);
			adminSignupPage.getEleAdminNameField().sendKeys(sData[12]);
			adminSignupPage.getEleEmailIdField().sendKeys(sData[13]);
			adminSignupPage.getEleMobileNumField().sendKeys(sData[14]);
			adminSignupPage.getEleContactNumField().sendKeys(sData[15]);
			Thread.sleep(30000);
			adminSignupPage.getEleSubmitButt().click();
			Thread.sleep(5000);
			studentSignInPage.elementStatus(adminRegConfimPage.getEleRegEmailId(),"To identify Email ID","displayed");
		    String expectedId = adminRegConfimPage.getEleRegEmailId().getText();
		    if(sData[13].equalsIgnoreCase(expectedId)==true)
		    {
		    	studentSignInPage.elementStatus(adminRegConfimPage.getEleRegEmailId(),"Email ID is","displayed");	
		    }
		    else
		    {
		    	studentSignInPage.elementStatus(adminSignupPage.getEleInValidEmailErrMsg(),"Invalid Email ID is","displayed");	 
		    }
		    String expectedPhoneno = adminRegConfimPage.getEleRegMobileNum().getText();
		    if(sData[14].equalsIgnoreCase(expectedPhoneno)==true)
		    {
		    	studentSignInPage.elementStatus(adminRegConfimPage.getEleRegMobileNum(),"Mobile Number is","displayed");	
		    }
		    else
		    {
		    	studentSignInPage.elementStatus(adminSignupPage.getEleInValidPhoneNumErrMsg(),"Invalid phone no is","displayed");	 	
		    }
		    adminRegConfimPage.getEleNextButt();
		    loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"GMAILURL"));
    		licensePage.LoginGmail();
			Thread.sleep(5000);
		} 
		catch(Exception e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
		/* 
	 * @Description:Verify 'click here' link functionality and resend admin credential
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=6,enabled=false,description="verify 'click here' link functionality and resend admin credential")
	public void testForgetPassword(String browser) throws Exception
	{
		licensePage=new LicensePage(driver);
		studentSignInPage=new StudentSignInPage(driver);
		adminSignupPage=new AdminSignupPage(driver);
		adminRegConfimPage=new AdminRegConfirmPage(driver);
		forgotPasswordPage=new ForgotPasswordPage(driver);
		adminHomePage=new AdminHomePage(driver);
		sTestData="AdminRegistration_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"REGESTARTIONCONFIRMATION"));
			studentSignInPage.elementStatus(adminSignupPage.getEleEnglishEdgeSetupText(),"'English Edge' Setup Text ","displayed");
			studentSignInPage.elementStatus(adminRegConfimPage.getEleLogo(),"English edge logo is","displayed");
		    System.out.println(adminRegConfimPage.getEleListConfirmationInstr().getText());
		    Thread.sleep(10000);
		    adminRegConfimPage.getEleClickhereLink().click();
		    Thread.sleep(5000);
		    adminRegConfimPage.getEleCloseIcon().click();
		    Thread.sleep(5000);
		    adminRegConfimPage.getEleClickhereLink().click();
		    Thread.sleep(5000);
		    studentSignInPage.elementStatus(adminRegConfimPage.getEleResetPage(),"Reset page is","displayed");
		    studentSignInPage.elementStatus(adminRegConfimPage.getElePageTitle()," page title is","displayed");
		    studentSignInPage.elementStatus(adminRegConfimPage.getEleStep1Text()," step 1 is","displayed");
		    studentSignInPage.elementStatus(adminRegConfimPage.getEleStep1Instr()," step 1 instruction is","displayed");
		    studentSignInPage.elementStatus(adminRegConfimPage.getEleCustomerCareEmailId(),"customercare mailid is","displayed");
		    studentSignInPage.elementStatus(adminRegConfimPage.getEleStep2Text(),"step 2 is","displayed");
		    Thread.sleep(5000);
		    adminRegConfimPage.getEleClickHereResendPwd().click();
		    
		    /*loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"GMAILURL"));
		    licensePage.LoginGmail();
		    Thread.sleep(10000);*/
		    //loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"REGESTARTIONCONFIRMATION"));
		    
		    studentSignInPage.elementStatus(adminRegConfimPage.getEleAlert(),"credential has send to email/mobile meassage is","displayed");
		    Thread.sleep(5000);
		    adminRegConfimPage.getEleClickhereLink().click();
		    Thread.sleep(5000);
		    adminRegConfimPage.getEleClickHereUpdateEmailIDorPwd().click();
		    Thread.sleep(10000);
		    studentSignInPage.elementStatus(adminRegConfimPage.getEleResetMobileorEmailPage(),"Reset Email/Mobile page is","displayed");
		    studentSignInPage.elementStatus(adminRegConfimPage.getEleEmailText()," email text is","displayed");
		    adminRegConfimPage.getEleResetEmailField().clear();
		    adminRegConfimPage.getEleResetEmailField().sendKeys(sData[13]);
		    studentSignInPage.elementStatus(adminRegConfimPage.getEleMobiletext(),"phone number text is","displayed");
		    adminRegConfimPage.getEleResetMobileField().clear();
		    adminRegConfimPage.getEleResetMobileField().sendKeys(sData[14]);
		    Thread.sleep(5000);
		    adminRegConfimPage.getEleCloseButton().click();
		    Thread.sleep(5000);
		    adminRegConfimPage.getEleClickhereLink().click();
		    Thread.sleep(5000);
		    adminRegConfimPage.getEleClickHereUpdateEmailIDorPwd().click();
		    Thread.sleep(5000);
		    adminRegConfimPage.getEleResetEmailField().clear();
		    adminRegConfimPage.getEleResetEmailField().sendKeys(sData[13]);
		    Thread.sleep(5000);
		    adminRegConfimPage.getEleResetMobileField().clear();
		    adminRegConfimPage.getEleResetMobileField().sendKeys(sData[14]);
		    Thread.sleep(10000);
		    adminRegConfimPage.getEleSubmitButton().click();
		    Thread.sleep(10000);
		    adminRegConfimPage.getEleNextButt().click();
		}
		catch(Exception e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	 * @Description:Verify the error when user launches the application from different mac-address
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=1,enabled=false,description="Verify the error when user launches the application from different mac-address")
	public void testLaunchAppFromDifferentmacAddress(String browser) throws Throwable
	{   
		studentSignInPage=new StudentSignInPage(driver);
		databasePage=new DataBasePage(driver);
		sTestData="AdminLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		String defaultmacValue;
		String newmacvalue;
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "DataBaseURL"));
			Thread.sleep(2000);
			databasePage.databaseLogin(sData[3],sData[4]);
			Thread.sleep(2000);
			databasePage.getMacAddress();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(databasePage.getEleCenterMacFld(),"Mac Address in center Settings table ", "displayed");
			defaultmacValue=databasePage.getEleCenterMacFld().getAttribute("value");
			newmacvalue=defaultmacValue+"123";
			databasePage.getEleCenterMacFld().clear();
			databasePage.getEleCenterMacFld().sendKeys(newmacvalue);
			databasePage.getEleYesBtn().click();
			databasePage.databaseLogout();
			Thread.sleep(2000);
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			NXGReports.addStep("Application is redirected to "+driver.getCurrentUrl(), LogAs.PASSED,null);
			studentSignInPage.elementStatus(studentSignInPage.getEleInvalidMacErrMsg(),"'OOPS!'Unauthorized Access ", "displayed");
			Thread.sleep(2000);
			// clean up code  
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "DataBaseURL"));
			Thread.sleep(2000);
			databasePage.getEleUserNameTxtFld().clear();
			databasePage.databaseLogin(sData[3],sData[4]);
			Thread.sleep(2000);
			databasePage.getMacAddress();
			Thread.sleep(2000);
			databasePage.getEleCenterMacFld().clear();
			databasePage.getEleCenterMacFld().sendKeys(defaultmacValue);
			databasePage.getEleYesBtn().click();
			databasePage.databaseLogout();
		}
		catch(Exception e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}		
	}
	/* 
	 * @Description:Verify the error when user launches the application without Internet connection. 
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=2,enabled=false,description="Verify the error when user launches the application without internet connection. ")
	public void testLaunchAppWithoutInternet(String browser) throws Throwable
	{   
		studentSignInPage=new StudentSignInPage(driver);
		databasePage=new DataBasePage(driver);
		try
		{
			String stop[]={"cmd.exe","/c","ipconfig/release"};
	    	String start[]={"cmd.exe","/c","ipconfig/renew"};
	    	Runtime.getRuntime().exec(stop);
	    	Thread.sleep(10000);
	    	loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			Thread.sleep(6000);
			studentSignInPage.Login(sData[1],sData[2]);
	    	Runtime.getRuntime().exec(start);
	    	Thread.sleep(10000);
		}
		catch(Exception e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}		
	}
	/* 
	 * @Description:Verify whether Registration page is displaying when user launches the application when server is stopped
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=3,enabled=false,description="Verify whether Registration page is displaying when user launches the application when server is stopped")
	public void testLaunchAppWithoutServer(String browser) throws IOException  	{   
		studentSignInPage=new StudentSignInPage(driver);
		licensePage=new LicensePage(driver);
		try
		{
			String start[]={"cmd.exe","/c","ipconfig/renew"};
			Runtime.getRuntime().exec(start);
	    	Thread.sleep(10000);
	    	
//			Runtime.getRuntime().exec(GenericLib.appDir+"\\Server2Go.exe");
//			Thread.sleep(60000);
//			Runtime.getRuntime().exec("taskkill /F /IM httpd.exe");
//			Runtime.getRuntime().exec("taskkill /F /IM mysqld.exe");
//			Runtime.getRuntime().exec("taskkill /F /IM UwAmp.exe");
//			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
		}
		catch(Exception e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			//throw e;
		}		
	}
	/* 
	 * @Description:Relaunching the Server
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=4,enabled=false,description="Relaunching the Server")
	public void testReLaunchServer(String browser) throws Throwable
	{   
		studentSignInPage=new StudentSignInPage(driver);
		licensePage=new LicensePage(driver);
		try
		{
			Runtime.getRuntime().exec(GenericLib.appDir+"\\EnglishEdge.exe");
			Thread.sleep(50000);
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.elementStatus(licensePage.getEleLicenseKeyField(),"License Key field ","displayed");	
		}
		catch(Exception e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}	
	}
	/* 
	 * @Description: Create a new teacher for one batch, verify  new credentials and count of teachers  in Admin home page.
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=15,enabled=false,description="Create a new teacher for one batch, verify  new credentials and count of teachers  in Admin home page")
	public void testTeacherRegistration(String browser) throws Throwable
	{
		studentSignInPage=new StudentSignInPage(driver);
		adminHomePage=new AdminHomePage(driver);
		teacherRegistrationPage=new TeacherRegistrationPage(driver);
		studentRegisterationPage= new StudentRegistrationPage(driver);
		successfulRegisterationPage= new SuccessfulRegisterationPage(driver);
		String defaultTeacherTxt=null;
		String actualTeacherTxt=null;
		try {
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			Thread.sleep(15000);
			sData=GenericLib.toReadExcelData("AdminLogin_01");
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(8000);
			studentSignInPage.elementStatus(adminHomePage.getEleTeachersCount(),"Teachers count","displayed");
			defaultTeacherTxt=adminHomePage.getEleTeachersCount().getText();
			int defaultTeacherCnt=adminHomePage.convertToInteger(defaultTeacherTxt);
			NXGReports.addStep("Teacher Count Before creating a new teacher in Admin Home page is "+ defaultTeacherCnt, LogAs.PASSED, null);
			adminHomePage.getEleSignOutText().click();
			Thread.sleep(4000);
			studentSignInPage.getEleRegisterBtn().click();
			Thread.sleep(5000);	
			studentSignInPage.elementStatus(studentSignInPage.getEleRegistartionConfirmationTxt(),"'Registration Confirmation' text","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleRegistartionPopupTxt(),"'Please select user role you need to register for:' text","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleTeacherRadioBtn(),"Teachers radio button ","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleStudentRadioBtn(),"student radio button","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleLoginLnk(),"'Back to login' Link'","displayed");
			studentSignInPage.getEleTeacherRadioBtn().click();
			studentSignInPage.elementStatus(teacherRegistrationPage.getEleTeacherTab(),"'Teacher' Tab ","displayed");
			sData=GenericLib.toReadExcelData("TeacherRegistration_01");
			teacherRegistrationPage.getEleFirstName().sendKeys(sData[1]);
			teacherRegistrationPage.getElelastName().sendKeys(sData[2]);
			teacherRegistrationPage.getEleEmailId().sendKeys(sData[3]);
			teacherRegistrationPage.getEleMobileNum().sendKeys(sData[4]);
			Thread.sleep(2000);
			teacherRegistrationPage.getEleDobField().click();
			teacherRegistrationPage.SelectDateOfBirth(1992,sData[6],13);
			adminHomePage.selectbyvisibletext(teacherRegistrationPage.getEleGenderSelect(),sData[8]);
			teacherRegistrationPage.getElePassword().sendKeys(sData[9]);
			teacherRegistrationPage.getEleConfirmPassword().sendKeys(sData[10]);
			adminHomePage.selectbyindexvalue(teacherRegistrationPage.getEleClassSelectDropdown1(), 1);
			Thread.sleep(2000);
			adminHomePage.selectbyindexvalue(teacherRegistrationPage.getEleSectionSelectDropdown1(), 1);
			teacherRegistrationPage.getEleSignUpButt().click();
			Thread.sleep(2000);
			NXGReports.addStep("New Teacher is created ", LogAs.PASSED, null);
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleSucessfullyRegisteredMsg(),"'You have successfully registered !!!' ","displayed");
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleRegLoginId(),"New teacher 'Login Id' ","displayed");
			System.out.println(successfulRegisterationPage.getEleRegLoginId().getText());
			String regLoginID=successfulRegisterationPage.getEleRegLoginId().getText();
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleRegPassword(),"New teacher 'Password' ","displayed");
			System.out.println(successfulRegisterationPage.getEleRegPassword().getText());
			String regPassword=successfulRegisterationPage.getEleRegPassword().getText();
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleClickHereText(),"'Click Here to Login' text ","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleEnglishEdgeWebLink(),"'English Edge Website Link' ","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleCopyRights(),"'CopyRights' ","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleCodeVersionDateText(),"'Code''Version' 'Date' ","displayed");
			Thread.sleep(5000);
			GenericLib.toWriteExcelData("TeacherLogin_01",GenericLib.getSubstring(regLoginID, 11),GenericLib.getSubstring(regPassword, 11));
			successfulRegisterationPage.getEleClickHereLink().click();
			Thread.sleep(5000);
			sData=GenericLib.toReadExcelData("AdminLogin_01");
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(8000);
			studentSignInPage.elementStatus(adminHomePage.getEleTeachersCount(),"Teachers count","displayed");
			actualTeacherTxt=adminHomePage.getEleTeachersCount().getText();
			int actualteacherCnt=adminHomePage.convertToInteger(actualTeacherTxt);
			if(actualteacherCnt-defaultTeacherCnt==1){
				NXGReports.addStep("Teacher Count after creating new teacher in Admin Home page is "+ actualteacherCnt, LogAs.PASSED, null);
			}
			else{
				NXGReports.addStep("Teacher Count is not updated correctly in Admin Home page, The count is "+actualteacherCnt, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}	
		} catch(Exception e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	 * @Description: Verify all the error messages in the teacher registration page
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=16,enabled=false,description="Verify all the error messages in the teacher registration page")
	public void testTeacherRegistrationErrorMessages(String browser) throws Throwable
	{
		studentSignInPage=new StudentSignInPage(driver);
		adminHomePage=new AdminHomePage(driver);
		teacherRegistrationPage=new TeacherRegistrationPage(driver);
		studentRegisterationPage= new StudentRegistrationPage(driver);
		successfulRegisterationPage= new SuccessfulRegisterationPage(driver);
		sTestData="TeacherRegistration_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try {
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			Thread.sleep(5000);	
			studentSignInPage.getEleRegisterBtn().click();
			Thread.sleep(2000);	
			studentSignInPage.getEleTeacherRadioBtn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(teacherRegistrationPage.getEleTeacherTab(),"'Teacher' Tab ","displayed");
			Thread.sleep(2000);
			// To verify 'This value is required.' Error message
			teacherRegistrationPage.getEleSignUpButt().click();
			studentSignInPage.elementStatus(teacherRegistrationPage.getEleValueReqErrMsg(),"'This value is required.' Error message ","displayed");
			// To verify 'Value should be alpha/alphanumeric'
			teacherRegistrationPage.getEleFirstName().sendKeys(sData[11]);
			teacherRegistrationPage.getElelastName().sendKeys(sData[12]);
			teacherRegistrationPage.getEleSignUpButt().click();
			Thread.sleep(1000);
			studentSignInPage.elementStatus(teacherRegistrationPage.getAlphaOrAlphanumericErrMsg(),"'Value should be alpha/alphanumeric' Error message ","displayed");
			teacherRegistrationPage.getEleFirstName().clear();
			teacherRegistrationPage.getElelastName().clear();
			// To verify 'This value should be a valid email.' error message 
			teacherRegistrationPage.getEleEmailId().sendKeys(sData[13]);
			Thread.sleep(1000);
			teacherRegistrationPage.getEleSignUpButt().click();
			studentSignInPage.elementStatus(teacherRegistrationPage.getEleInValidEmailErrMsg(),"'This value should be a valid email.' Error message ","displayed");
			Thread.sleep(2000);
			teacherRegistrationPage.getEleEmailId().clear();
			// To verify 'Mobile number should not be 0' error message
			teacherRegistrationPage.getEleMobileNum().sendKeys(sData[14]);
			teacherRegistrationPage.getEleSignUpButt().click();
			studentSignInPage.elementStatus(teacherRegistrationPage.getEleInValidPhoneNumErrMsg2(),"'Mobile number should not be 0' error message ","displayed");
			Thread.sleep(2000);
			// To verify 'This value should be a valid phone number.' error message
			teacherRegistrationPage.getEleMobileNum().clear();
			teacherRegistrationPage.getEleMobileNum().sendKeys(sData[15]);
			teacherRegistrationPage.getEleSignUpButt().click();
			studentSignInPage.elementStatus(teacherRegistrationPage.getEleInValidPhoneNumErrMsg1(),"'This value should be a valid phone number.' error message ","displayed");
			Thread.sleep(2000);
			// To verify 'This value is too short. It should have 6 characters or more.' error message
			teacherRegistrationPage.getElePassword().sendKeys(sData[16]);
			teacherRegistrationPage.getEleConfirmPassword().sendKeys(sData[16]);
			teacherRegistrationPage.getEleSignUpButt().click();
			studentSignInPage.elementStatus(teacherRegistrationPage.getEleValueIsShortErrorMsg(),"'This value is too short. It should have 6 characters or more.' error message ","displayed");
			Thread.sleep(2000);
			// To verify 'This value should be the same.' error message
			teacherRegistrationPage.getElePassword().clear();
			teacherRegistrationPage.getEleConfirmPassword().clear();
			teacherRegistrationPage.getElePassword().sendKeys(sData[17]);
			teacherRegistrationPage.getEleConfirmPassword().sendKeys(sData[16]);
			teacherRegistrationPage.getEleSignUpButt().click();
			studentSignInPage.elementStatus(teacherRegistrationPage.getEleValueShouldSameErrorMsg(),"'This value should be the same.' error message ","displayed");
			Thread.sleep(2000);
			// To verify 'This value should be alphanumeric.' error message
			teacherRegistrationPage.getElePassword().clear();
			teacherRegistrationPage.getEleConfirmPassword().clear();
			teacherRegistrationPage.getElePassword().sendKeys(sData[18]);
			teacherRegistrationPage.getEleConfirmPassword().sendKeys(sData[18]);
			teacherRegistrationPage.getEleSignUpButt().click();
			studentSignInPage.elementStatus(teacherRegistrationPage.getEleAlphaNumericErrMsg(),"'This value should be alphanumeric.' error message ","displayed");
		} catch(Exception e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	 * @Description: Verify Teacher registration with valid details for multiple batches
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=17,enabled=false,description="Verify Teacher registration with valid details for multiple batches")
	public void testTeacherRegistrationForMulitpleBatches(String browser) throws Throwable
	{
		studentSignInPage=new StudentSignInPage(driver);
		adminHomePage=new AdminHomePage(driver);
		teacherRegistrationPage=new TeacherRegistrationPage(driver);
		studentRegisterationPage= new StudentRegistrationPage(driver);
		successfulRegisterationPage= new SuccessfulRegisterationPage(driver);
		sTestData="TeacherRegistration_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try {
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			Thread.sleep(5000);	
			studentSignInPage.getEleRegisterBtn().click();
			Thread.sleep(2000);
			studentSignInPage.getEleTeacherRadioBtn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(teacherRegistrationPage.getEleTeacherTab(),"'Teacher' Tab ","displayed");
			Thread.sleep(2000);		
			studentSignInPage.elementStatus(teacherRegistrationPage.getEleAddButt(),"Add button ","displayed");
			for(int i=0;i<=3;i++){
			teacherRegistrationPage.getEleAddButt().click();
			}
			// To verify 'This value is required.' Error message
			teacherRegistrationPage.getEleSignUpButt().click();
			studentSignInPage.elementStatus(teacherRegistrationPage.getEleValueReqErrMsg(),"'This value is required.' Error message ","displayed");
			Thread.sleep(2000);
			studentSignInPage.elementStatus(teacherRegistrationPage.getEleRemoveButton(),"Remove button ","displayed");
			for(int i=0;i<=3;i++){
			teacherRegistrationPage.getEleRemoveButton().click();
			}
			// Teacher registration with valid details for multiple sections, classes.
			teacherRegistrationPage.getEleFirstName().sendKeys(sData[1]);
			teacherRegistrationPage.getElelastName().sendKeys(sData[2]);
			teacherRegistrationPage.getEleEmailId().sendKeys(sData[3]);
			teacherRegistrationPage.getEleMobileNum().sendKeys(sData[4]);
			teacherRegistrationPage.getEleDobField().click();
			teacherRegistrationPage.SelectDateOfBirth(1992,sData[6],13);
			adminHomePage.selectbyvisibletext(teacherRegistrationPage.getEleGenderSelect(), sData[8]);
			teacherRegistrationPage.getElePassword().sendKeys(sData[9]);
			teacherRegistrationPage.getEleConfirmPassword().sendKeys(sData[10]);
			adminHomePage.selectbyindexvalue(teacherRegistrationPage.getEleClassSelectDropdown1(), 1);
			Thread.sleep(2000);
			adminHomePage.selectbyindexvalue(teacherRegistrationPage.getEleSectionSelectDropdown1(), 1);
			for(int i=1;i<=2;i++){
				teacherRegistrationPage.getEleAddButt().click();
				}
			adminHomePage.selectbyindexvalue(teacherRegistrationPage.getEleClassSelectDropdown2(), 1);
			Thread.sleep(2000);
			adminHomePage.selectbyindexvalue(teacherRegistrationPage.getEleSectionSelectDropdown2(), 1);
			Thread.sleep(2000);
			adminHomePage.selectbyindexvalue(teacherRegistrationPage.getEleClassSelectDropdown3(), 1);
			Thread.sleep(2000);
			adminHomePage.selectbyindexvalue(teacherRegistrationPage.getEleSectionSelectDropdown3(), 1);
			teacherRegistrationPage.getEleSignUpButt().click();
			Thread.sleep(2000);
			NXGReports.addStep("New Teacher is created ", LogAs.PASSED, null);
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleSucessfullyRegisteredMsg(),"'You have successfully registered !!!' ","displayed");
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleRegLoginId(),"New teacher 'Login Id' ","displayed");
			System.out.println(successfulRegisterationPage.getEleRegLoginId().getText());
			String regLoginID=successfulRegisterationPage.getEleRegLoginId().getText();
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleRegPassword(),"New teacher 'Password' ","displayed");
			System.out.println(successfulRegisterationPage.getEleRegPassword().getText());
			String regPassword=successfulRegisterationPage.getEleRegPassword().getText();
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleClickHereText(),"'Click Here to Login' text ","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleEnglishEdgeWebLink(),"'English Edge Website Link' ","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleCopyRights(),"'CopyRights' ","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleCodeVersionDateText(),"'Code''Version' 'Date' ","displayed");
			GenericLib.toWriteExcelData("TeacherLogin_02",GenericLib.getSubstring(regLoginID,11),GenericLib.getSubstring(regPassword,11));
			successfulRegisterationPage.getEleClickHereLink().click();
		} catch(Exception e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	 * @Description: Create a new Student with MobileNumber, verify  new credentials and count of Student  in Admin home page
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=18,enabled=false,description="Create a new Student with MobileNumber, Verify new credentials and count of Student  in Admin home page")
	public void testStudentRegistrationWithMobileNumber(String browser) throws Throwable{	
		studentSignInPage=new StudentSignInPage(driver);
		adminHomePage=new AdminHomePage(driver);
		teacherRegistrationPage=new TeacherRegistrationPage(driver);
		studentRegisterationPage= new StudentRegistrationPage(driver);
		successfulRegisterationPage= new SuccessfulRegisterationPage(driver);
		sTestData="AdminLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		String defaultStudentTxt=null;
		String actualStudentTxt=null;
		try {
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			Thread.sleep(5000);	
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(8000);
			// To get the Student count in Admin home page.
			studentSignInPage.elementStatus(adminHomePage.getEleStudentsCount(),"Student count","displayed");
			defaultStudentTxt=adminHomePage.getEleTeachersCount().getText();
			int defaultStudentCnt=adminHomePage.convertToInteger(defaultStudentTxt);
			NXGReports.addStep("Student Count Before creating a new Student in Admin Home page is "+ defaultStudentCnt, LogAs.PASSED, null);
			adminHomePage.getEleSignOutText().click();
			Thread.sleep(4000);
			studentSignInPage.getEleRegisterBtn().click();
			Thread.sleep(2000);	
			studentSignInPage.getEleStudentRadioBtn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(studentRegisterationPage.getEleStudentTab(),"'Student' Tab   ","displayed");
			studentRegisterationPage.getEleStudentTab().click();
			sData=GenericLib.toReadExcelData("StudentRegistration_01");
			studentRegisterationPage.getEleFirstName().sendKeys(sData[1]);
			studentRegisterationPage.getElelastName().sendKeys(sData[2]);
			studentRegisterationPage.getEleEmailId().sendKeys(sData[3]);
			studentRegisterationPage.getEleMobileNum().sendKeys(sData[4]);
			Thread.sleep(2000);
			studentRegisterationPage.getEleDobField().click();
			teacherRegistrationPage.SelectDateOfBirth(1992,sData[6],13);
			adminHomePage.selectbyvisibletext(studentRegisterationPage.getEleGenderSelect(),sData[8]);
			studentRegisterationPage.getElePassword().sendKeys(sData[9]);
			studentRegisterationPage.getEleConfirmPassword().sendKeys(sData[10]);
			adminHomePage.selectbyindexvalue(studentRegisterationPage.getEleClassSelectDropdown(), 1);
			Thread.sleep(5000);
			adminHomePage.selectbyindexvalue(studentRegisterationPage.getEleSectionSelectDropdown(), 1);
			Thread.sleep(5000);
			studentRegisterationPage.getEleSignUpButt().click();
			Thread.sleep(5000);
			// To verify Registration confirmation
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleSucessfullyRegisteredMsg(),"'You have successfully registered !!!' ","displayed");
			System.out.println("one"+successfulRegisterationPage.getEleSucessfullyRegisteredMsg().isDisplayed());
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleRegLoginId(),"'Login Id' ","displayed");
			System.out.println(successfulRegisterationPage.getEleRegLoginId().isDisplayed());
			System.out.println(successfulRegisterationPage.getEleRegLoginId().getText());
			String regLoginID=successfulRegisterationPage.getEleRegLoginId().getText();
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleRegPassword(),"'Password' ","displayed");
			System.out.println(successfulRegisterationPage.getEleRegPassword().isDisplayed());
			System.out.println(successfulRegisterationPage.getEleRegPassword().getText());
			String regPassword=successfulRegisterationPage.getEleRegPassword().getText();
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleClickHereText(),"'Click Here to Login' text ","displayed");
			System.out.println(successfulRegisterationPage.getEleClickHereText().isDisplayed());
			studentSignInPage.elementStatus(studentSignInPage.getEleEnglishEdgeWebLink(),"'English Edge Website Link' ","displayed");
			System.out.println(studentSignInPage.getEleEnglishEdgeWebLink().isDisplayed());
			studentSignInPage.elementStatus(studentSignInPage.getEleCopyRights(),"'CopyRights' ","displayed");
			System.out.println(studentSignInPage.getEleCopyRights().isDisplayed());
			studentSignInPage.elementStatus(studentSignInPage.getEleCodeVersionDateText(),"'Code''Version' 'Date'","displayed");
			System.out.println(studentSignInPage.getEleCodeVersionDateText().isDisplayed());
			GenericLib.toWriteExcelData("StudentLogin_01",GenericLib.getSubstring(regLoginID, 11),GenericLib.getSubstring(regPassword, 11));
			successfulRegisterationPage.getEleClickHereLink().click();
			Thread.sleep(10000);
			sData=GenericLib.toReadExcelData("AdminLogin_01");
			// To verify the Student count in Admin home page
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(8000);
			studentSignInPage.elementStatus(adminHomePage.getEleStudentsCount(),"Student  count","displayed");
			System.out.println(adminHomePage.getEleStudentsCount().isDisplayed());
			actualStudentTxt=adminHomePage.getEleStudentsCount().getText();
			int actualStudentCnt=adminHomePage.convertToInteger(actualStudentTxt);
			if(actualStudentCnt-defaultStudentCnt==1){
				NXGReports.addStep("Student Count after creating new Student in Admin Home page is "+ actualStudentCnt, LogAs.PASSED, null);
			}
			else{
				NXGReports.addStep("Student Count is not updated correctly in Admin Home page, The count is "+actualStudentCnt, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		} catch(Exception e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}	
	/* 
	 * @Description: Verify students registration without valid mobile number and valid details, and login with the credentials
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=19,enabled=false,description="Verify students registration without mobile number and valid details, and login with the credentials")
	public void testStudentRegistrationWithoutMobileNumber(String browser) throws Throwable{	
		studentSignInPage=new StudentSignInPage(driver);
		adminHomePage=new AdminHomePage(driver);
		teacherRegistrationPage=new TeacherRegistrationPage(driver);
		studentRegisterationPage= new StudentRegistrationPage(driver);
		successfulRegisterationPage= new SuccessfulRegisterationPage(driver);
		sTestData="AdminLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		String defaultStudentTxt=null;
		String actualStudentTxt=null;
		try {
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			Thread.sleep(5000);	
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(8000);
			// To get the Student count in Admin home page.
			studentSignInPage.elementStatus(adminHomePage.getEleStudentsCount(),"Student count","displayed");
			defaultStudentTxt=adminHomePage.getEleTeachersCount().getText();
			int defaultStudentCnt=adminHomePage.convertToInteger(defaultStudentTxt);
			NXGReports.addStep("Student Count Before creating a new Student in Admin Home page is "+ defaultStudentCnt, LogAs.PASSED, null);
			adminHomePage.getEleSignOutText().click();
			Thread.sleep(4000);
			studentSignInPage.getEleRegisterBtn().click();
			Thread.sleep(2000);
			Thread.sleep(2000);	
			studentSignInPage.getEleStudentRadioBtn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(studentRegisterationPage.getEleStudentTab(),"'Student' Tab   ","displayed");
			studentRegisterationPage.getEleStudentTab().click();
			sData=GenericLib.toReadExcelData("StudentRegistration_01");
			studentRegisterationPage.getEleFirstName().sendKeys(sData[1]);
			studentRegisterationPage.getElelastName().sendKeys(sData[2]);
			studentRegisterationPage.getEleEmailId().sendKeys(sData[3]);
			Thread.sleep(2000);
			studentRegisterationPage.getEleDobField().click();
			teacherRegistrationPage.SelectDateOfBirth(1992,sData[6],13);
			adminHomePage.selectbyvisibletext(studentRegisterationPage.getEleGenderSelect(),sData[8]);
			studentRegisterationPage.getElePassword().sendKeys(sData[9]);
			studentRegisterationPage.getEleConfirmPassword().sendKeys(sData[10]);
			adminHomePage.selectbyindexvalue(studentRegisterationPage.getEleClassSelectDropdown(), 1);
			Thread.sleep(5000);
			adminHomePage.selectbyindexvalue(studentRegisterationPage.getEleSectionSelectDropdown(), 1);
			Thread.sleep(5000);
			studentRegisterationPage.getEleSignUpButt().click();
			Thread.sleep(5000);
			// To verify Registration confirmation 
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleSucessfullyRegisteredMsg(),"'You have successfully registered !!!' ","displayed");
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleRegLoginId(),"'Login Id' ","displayed");
			System.out.println(successfulRegisterationPage.getEleRegLoginId().getText());
			String regLoginID=successfulRegisterationPage.getEleRegLoginId().getText();
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleRegPassword(),"'Password' ","displayed");
			System.out.println(successfulRegisterationPage.getEleRegPassword().getText());
			String regPassword=successfulRegisterationPage.getEleRegPassword().getText();
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleClickHereText(),"'Click Here to Login' text ","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleEnglishEdgeWebLink(),"'English Edge Website Link' ","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleCopyRights(),"'CopyRights' ","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleCodeVersionDateText(),"'Code''Version' 'Date' ","displayed");
			Thread.sleep(5000);
			GenericLib.toWriteExcelData("StudentLogin_02",GenericLib.getSubstring(regLoginID, 11),GenericLib.getSubstring(regPassword, 11));
			successfulRegisterationPage.getEleClickHereLink().click();
			Thread.sleep(15000);
			/*
			// To verify the Student count in Admin home page
			 sData=GenericLib.toReadExcelData("AdminLogin_01");
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(8000);
			studentSignInPage.elementStatus(adminHomePage.getEleStudentsCount(),"Student  count","displayed");
			actualStudentTxt=adminHomePage.getEleStudentsCount().getText();
			int actualStudentCnt=adminHomePage.convertToInteger(actualStudentTxt);
			if(actualStudentCnt-defaultStudentCnt==1){
				NXGReports.addStep("Student Count after creating new Student in Admin Home page is "+ actualStudentCnt, LogAs.PASSED, null);
			}
			else{
				NXGReports.addStep("Student Count is not updated correctly in Admin Home page, The count is "+actualStudentCnt, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}*/
		} catch(Exception e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		}
	/* 
	 * @Description: To verify all the error messages in Student Registration page
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=20,enabled=false,description="To verify all the error messages in Student Registeration page")
	public void testStudentRegistrationErrorMessages(String browser) throws Throwable{	
		studentSignInPage=new StudentSignInPage(driver);
		adminHomePage=new AdminHomePage(driver);
		teacherRegistrationPage=new TeacherRegistrationPage(driver);
		studentRegisterationPage= new StudentRegistrationPage(driver);
		successfulRegisterationPage= new SuccessfulRegisterationPage(driver);
		sTestData="StudentRegistration_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try {
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			Thread.sleep(5000);	
			studentSignInPage.getEleRegisterBtn().click();
			Thread.sleep(2000);	
			studentSignInPage.getEleStudentRadioBtn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(studentRegisterationPage.getEleStudentTab(),"'Student' Tab ","displayed");
			studentRegisterationPage.getEleStudentTab().click();
			Thread.sleep(1000);
			// To Verify 'This value is required.' error message 
			studentRegisterationPage.getEleSignUpButt().click();
			studentSignInPage.elementStatus(studentRegisterationPage.getEleValueReqErrMsg(),"'This value is required.' error message ","displayed");
			// To verify 'Value should be alpha/alphanumeric' error message
			studentRegisterationPage.getEleFirstName().sendKeys(sData[11]);
			studentRegisterationPage.getElelastName().sendKeys(sData[12]);
			studentRegisterationPage.getEleSignUpButt().click();
			studentSignInPage.elementStatus(studentRegisterationPage.getAlphaOrAlphanumericErrMsg(),"'Value should be alpha/alphanumeric' error message ","displayed");
			studentRegisterationPage.getEleFirstName().clear();
			studentRegisterationPage.getElelastName().clear();
			// To verify 'This value should be a valid email.' error message
			studentRegisterationPage.getEleEmailId().sendKeys(sData[13]);
			studentRegisterationPage.getEleSignUpButt().click();
			studentSignInPage.elementStatus(studentRegisterationPage.getEleInValidEmailErrMsg(),"'This value should be a valid email.' error message ","displayed");
			studentRegisterationPage.getEleEmailId().clear();
			// To verify 'Mobile number should not be 0' error message
			studentRegisterationPage.getEleMobileNum().sendKeys(sData[14]);
			studentRegisterationPage.getEleSignUpButt().click();
			studentSignInPage.elementStatus(studentRegisterationPage.getEleInValidPhoneNumErrMsg2(),"'Mobile number should not be 0' error message ","displayed");
			Thread.sleep(2000);
			// To verify 'This value should be a valid phone number.' error message
			studentRegisterationPage.getEleMobileNum().clear();
			studentRegisterationPage.getEleMobileNum().sendKeys(sData[15]);
			studentRegisterationPage.getEleSignUpButt().click();
			studentSignInPage.elementStatus(studentRegisterationPage.getEleInValidPhoneNumErrMsg1(),"'This value should be a valid phone number.' error message ","displayed");
			Thread.sleep(2000);
			studentRegisterationPage.getEleMobileNum().clear();
			// To verify 'This value is too short. It should have 6 characters or more.' error message
			studentRegisterationPage.getElePassword().sendKeys(sData[16]);
			studentRegisterationPage.getEleConfirmPassword().sendKeys(sData[16]);
			studentRegisterationPage.getEleSignUpButt().click();
			studentSignInPage.elementStatus(studentRegisterationPage.getEleValueIsShortErrorMsg(),"'This value is too short. It should have 6 characters or more.' error message ","displayed");
			Thread.sleep(2000);
			// To verify 'This value should be the same.' error message
			studentRegisterationPage.getElePassword().clear();
			studentRegisterationPage.getEleConfirmPassword().clear();
			studentRegisterationPage.getElePassword().sendKeys(sData[17]);
			studentRegisterationPage.getEleConfirmPassword().sendKeys(sData[16]);
			studentRegisterationPage.getEleSignUpButt().click();
			studentSignInPage.elementStatus(studentRegisterationPage.getEleValueShouldSameErrorMsg(),"'This value should be the same.' error message ","displayed");
			Thread.sleep(2000);
			// To verify 'This value should be alphanumeric.' error message
			studentRegisterationPage.getElePassword().clear();
			studentRegisterationPage.getEleConfirmPassword().clear();
			studentRegisterationPage.getElePassword().sendKeys(sData[18]);
			studentRegisterationPage.getEleConfirmPassword().sendKeys(sData[18]);
			studentRegisterationPage.getEleSignUpButt().click();
			studentSignInPage.elementStatus(studentRegisterationPage.getEleAlphaNumericErrMsg(),"'This value should be alphanumeric.' error message ","displayed");
		} catch(Exception e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		}
	/* 
	 * @Description: Verify Forgot Password functionality with valid and invalid registered details and login to gmail and check the credential
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=21,enabled=false,description="Verify Forgot Password functionality with valid and invalid registered details and login to gmail and check the credential")
	public void verifyCredentialsFromGmail(String browser) throws Exception
	{   
		studentSignInPage=new StudentSignInPage(driver);
		forgotPasswordPage=new ForgotPasswordPage(driver);
		adminHomePage=new AdminHomePage(driver);
		sTestData="AdminRegistration_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			Thread.sleep(2000);
			studentSignInPage.getEleForgotPwdLink().click();
			Thread.sleep(4000);
			studentSignInPage.elementStatus(studentSignInPage.getEleAdminForgotPasswordInstrTxt(),"To retrieve Admin password please instruction text", "displayed");
			studentSignInPage.elementStatus(forgotPasswordPage.getEleClickHereLink(),"'Click Here' Link ","displayed");
			studentSignInPage.elementStatus(forgotPasswordPage.getEleBackButton(), "'Back' button", "displayed");
			forgotPasswordPage.getEleBackButton().click();
			studentSignInPage.getEleForgotPwdLink().click();
			Thread.sleep(4000);
			studentSignInPage.getEleClickHereLnk().click();
			Thread.sleep(6000);
			studentSignInPage.elementStatus(studentSignInPage.getEleAdminPasswordResetTxt(),"Welcome to Admin password reset console text", "displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleLoginIDTxtFld(),"Login Id Field in Forgot password field","displayed");
			studentSignInPage.getEleSubmitBtn().click();
			studentSignInPage.elementStatus(studentUploadPage.getEleValueReqErrMsg(),"This value is required.","displayed");
			Thread.sleep(1000);
			studentSignInPage.getEleLoginIDTxtFld().sendKeys(sData[17]);
			studentSignInPage.getEleSubmitBtn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(forgotPasswordPage.getEleInvalidMailIdErrorMsg(),"Incorrect Login ID. Please provide the correct Login ID.", "displayed");
			Thread.sleep(2000);
			studentSignInPage.getEleLoginIDTxtFld().sendKeys(sData[13]);
			studentSignInPage.getEleSubmitBtn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(studentSignInPage.getEleConfirmationText()," Credentials has been sent to your registered Email/Mobile text","displayed");
			forgotPasswordPage.getEleBackButton().click();
			/*loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"GMAILURL"));
    		licensePage.LoginGmail();
			Thread.sleep(5000); 
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"APPLICATIONURL"));
			Thread.sleep(5000); 
			studentSignInPage.Login(GenericLib.getCongigValue(GenericLib.sConfigFile, "CURRENTUSERNAME"),GenericLib.getCongigValue(GenericLib.sConfigFile, "CURRENTPASSWORD"));
			Thread.sleep(10000);
			studentSignInPage.elementStatus(adminHomePage.getEleHomeText(),"Home text ","displayed");*/
		}
		catch(Exception e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		}
	/* 
	 * @Description: Verify all the error messages in the 'Admin profile' page, Verify change password functionality with valid data and login with new password and After Changing Password try to Login with old password.
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=10,enabled=false,description="Verify all the error messages in the 'Admin profile' page, Verify change password functionality with valid data and login with new password and After Changing Password try to Login with old password.")
	public void testEditProfileFunctionality(String browser) throws Throwable{	
		studentSignInPage=new StudentSignInPage(driver);
		adminHomePage=new AdminHomePage(driver);
		adminProfilePage=new AdminProfilePage(driver);
		teacherRegistrationPage=new TeacherRegistrationPage(driver);
		sTestData="AdminLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try {
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			Thread.sleep(4000);
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(8000);
			adminHomePage.getEleDropDownIcn().click();
			Thread.sleep(2000);
			adminHomePage.getEleProfileOption().click();
			Thread.sleep(4000);
			// To Verify 'This value is required.' error message
			adminProfilePage.getEleFirstNameTxtFld().clear();
			adminProfilePage.getEleLastNameTxtFld().clear();
			adminProfilePage.getEleEmailIdTxtFld().clear();
			adminProfilePage.getElePhoneTextBox().clear();
			adminHomePage.selectbyindexvalue(adminProfilePage.getEleSelGender(), 0);
			adminProfilePage.getEleChangePasswordButton().click();
			adminProfilePage.getUpdateButton().click();
			studentSignInPage.elementStatus(adminProfilePage.getEleValueReqErrMsg(), "'The Value is required.' error message", "displayed");
			sData=GenericLib.toReadExcelData("AdminProfile_01");
			// To verify 'This value should be a valid email.'error message
			adminProfilePage.getEleEmailIdTxtFld().sendKeys(sData[1]);
			Thread.sleep(2000);
			studentSignInPage.ScrollToViewElement(adminProfilePage.getUpdateButton());
			adminProfilePage.getUpdateButton().click();
			studentSignInPage.elementStatus(adminProfilePage.getEleMailIdErrMsg(), "'This value should be a valid email.' error message", "displayed");
			// To verify 'This value should be a valid phone number.'error message
			adminProfilePage.getElePhoneTextBox().sendKeys(sData[2]);
			adminProfilePage.getUpdateButton().click();
			studentSignInPage.elementStatus(adminProfilePage.getElePhoneNumErrMsg(), "'This value should be a valid phone number.' error message", "displayed");
			// To verify 'Invalid Password' error message
			adminProfilePage.getEleOldPwdTextBox().sendKeys(sData[3]);
			adminProfilePage.getUpdateButton().click();
			studentSignInPage.elementStatus(adminProfilePage.getEleOldPwdErrMsg(), "'Invalid Password' error message", "displayed");
			// To verify 'This value is too short. It should have 6 characters or more.' error message
			adminProfilePage.getEleNewPwdTextBox().sendKeys(sData[4]);
			adminProfilePage.getEleConNewPwdTextBox().sendKeys(sData[4]);
			adminProfilePage.getUpdateButton().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(adminProfilePage.getEleValueShortErrMsg(), "'This value is too short. It should have 6 characters or more.' error message", "displayed");
			// To verify 'This value should be the same.' error message
			adminProfilePage.getEleNewPwdTextBox().sendKeys(sData[5]);
			adminProfilePage.getEleConNewPwdTextBox().sendKeys(sData[6]);
			adminProfilePage.getUpdateButton().click();
			studentSignInPage.elementStatus(adminProfilePage.getEleValueShortErrMsg(), "'This value should be the same.' error message", "displayed");		
			adminProfilePage.getEleFirstNameTxtFld().clear();
			adminProfilePage.getEleFirstNameTxtFld().sendKeys(sData[7]);
			adminProfilePage.getEleLastNameTxtFld().clear();
			adminProfilePage.getEleLastNameTxtFld().sendKeys(sData[8]);
			adminProfilePage.getEleEmailIdTxtFld().clear();
			adminProfilePage.getEleEmailIdTxtFld().sendKeys(sData[9]);
			adminProfilePage.getElePhoneTextBox().clear();
			adminProfilePage.getElePhoneTextBox().sendKeys(sData[10]);
			//adminProfilePage.getEleCalenderIcon().click();
			//teacherRegistrationPage.SelectDateOfBirth(1995, "Jun",13);
			adminHomePage.selectbyvisibletext(adminProfilePage.getEleSelGender(),sData[11]);
			// To change password
			adminProfilePage.getEleOldPwdTextBox().clear();
			sData=GenericLib.toReadExcelData("AdminLogin_01");
			adminProfilePage.getEleOldPwdTextBox().sendKeys(sData[2]);
			adminProfilePage.getEleNewPwdTextBox().clear();
			sData=GenericLib.toReadExcelData("AdminProfile_01");
			adminProfilePage.getEleNewPwdTextBox().sendKeys(sData[12]);
			adminProfilePage.getEleConNewPwdTextBox().clear();
			adminProfilePage.getEleConNewPwdTextBox().sendKeys(sData[12]);
			adminProfilePage.getUpdateButton().click();
			Thread.sleep(30000);
			// To verify 'Updated Successfully' Message
			studentSignInPage.elementStatus(adminProfilePage.getEleUpdatedSuccessfullyMsg(), "'Updated Successfully' Confirmation message", "displayed");
			// To 'Sign Out' 
			adminHomePage.getEleDropDownIcn().click();
			Thread.sleep(1000);
			adminHomePage.getEleSignOutOption().click();
			Thread.sleep(5000);
			// To login with old credentials
			sData=GenericLib.toReadExcelData("AdminLogin_01");
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(5000);
			studentSignInPage.elementStatus(studentSignInPage.getEleIncorrectUserPwd(), "'Incorrect username or password.' error message", "displayed");		
			Thread.sleep(2000);
			// Clean up code
			studentSignInPage.getEleUserNameTextField().clear();
			studentSignInPage.getElePasswordTextFiled().clear();
			studentSignInPage.getEleUserNameTextField().sendKeys(sData[1]);
			sData=GenericLib.toReadExcelData("AdminProfile_01");
			studentSignInPage.getElePasswordTextFiled().sendKeys(sData[12]);
			Thread.sleep(2000);
			studentSignInPage.getEleSignInBtn().click();
			Thread.sleep(10000);
			adminHomePage.getEleDropDownIcn().click();
			Thread.sleep(2000);
			adminHomePage.getEleProfileOption().click();
			Thread.sleep(8000);
			adminProfilePage.getEleChangePasswordButton().click();
			Thread.sleep(2000);
			adminProfilePage.getEleOldPwdTextBox().sendKeys(sData[12]);
			sData=GenericLib.toReadExcelData("AdminLogin_01");
			adminProfilePage.getEleNewPwdTextBox().sendKeys(sData[2]);
			adminProfilePage.getEleConNewPwdTextBox().sendKeys(sData[2]);
			Thread.sleep(1000);
			adminProfilePage.getUpdateButton().click();
			Thread.sleep(30000);
			studentSignInPage.elementStatus(adminProfilePage.getEleUpdatedSuccessfullyMsg(), "'Updated Successfully' Confirmation message", "displayed");
		}
		catch(Exception e)
	{
		NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
	}
}
	/* 
	 * @Description: Create a batch and verify no of batches created in the 'Home' Page
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=7,enabled=false,description="Create a batch and verify no of batches created in the 'Home' Page")
	public void testCreateBatch(String browser) throws Throwable{	
		studentSignInPage=new StudentSignInPage(driver);
		adminHomePage=new AdminHomePage(driver);
		createBatchPage=new CreateBatchPage(driver);
		sTestData="AdminLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		int batchescreated=0;
		int totalbatches=0;
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			Thread.sleep(2000);
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(12000);
			String oldbatches=adminHomePage.getEleBatchesCount().getText();
			int oldbatchescount = Integer.parseInt(oldbatches); 
			System.out.println(adminHomePage.getEleBatchesCount().getText());
			studentSignInPage.elementStatus(adminHomePage.getEleCreateBatchText(),"Create batch text ","displayed");		
			adminHomePage.getEleCreateBatchText().click();
			Thread.sleep(6000);
			// To create single batches
			adminHomePage.selectbyindexvalue(createBatchPage.getEleClassDropDown1(), 0);
			adminHomePage.selectbyvisibletext(createBatchPage.getEleSectionFromDropDown1(), "1");
			adminHomePage.selectbyvisibletext(createBatchPage.getEleSectionToDropDown1(), "1");
			createBatchPage.getEleStartDateFld().get(0).click();
			Thread.sleep(2000);
			createBatchPage.getEleTodayDate().click();
			createBatchPage.getEleEndDateFld().get(0).click();
			Thread.sleep(2000);
			createBatchPage.getEleNextIcn().click();
			createBatchPage.getEleEndDateTxt().click();
			createBatchPage.getEleCreateButton().click();
			Thread.sleep(2000);
			// To verify the Confirmation table
			studentSignInPage.elementStatus(createBatchPage.getEleBatchConfirmTable(),"Batch Table ","displayed");
			Thread.sleep(2000);
			// To verify Batch status
			if(createBatchPage.getEleBatchExistsText().size()>=1){
				batchescreated=0;
				totalbatches=oldbatchescount+batchescreated;
				NXGReports.addStep("Batch Already Exists for given sections.", LogAs.PASSED, null);
			}
			if(createBatchPage.getEleBatchCreatedText().size()>=1){
				batchescreated=createBatchPage.getEleBatchCreatedText().size();
				totalbatches=oldbatchescount+batchescreated;
				NXGReports.addStep("New batch is created  for given sections.", LogAs.PASSED, null);
			}
			// To verify count of Updated batches 
			adminHomePage.getEleHomeText().click();
			Thread.sleep(2000);
			String newbatches=adminHomePage.getEleBatchesCount().getText();
			int newbatchescount = Integer.parseInt(newbatches); 
			if(totalbatches==newbatchescount){
				NXGReports.addStep("After creating new batches, batches count is updating in Admin home page", LogAs.PASSED, null);
			}
		} catch(Exception e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	 * @Description: Create multiple batches by using 'Add' button and verify no of batches created in the 'Home' Page, Verify the batch creation report by selecting duplicate 'class', 'Section from' and 'section to'.
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=8,enabled=false,description="Create mulitple batches by using 'Add' button and verify no of batches created in the 'Home' Page, Verify the batch creation report by selecting duplicate 'class', 'Section from' and 'section to'.")
	public void testCreateMulitpleBatches(String browser) throws Throwable{	
		studentSignInPage=new StudentSignInPage(driver);
		adminHomePage=new AdminHomePage(driver);
		createBatchPage=new CreateBatchPage(driver);
		sTestData="AdminLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		int batchescreated=0;
		int totalbatches=0;
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			Thread.sleep(2000);
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(12000);
			String oldbatches=adminHomePage.getEleBatchesCount().getText();
			int oldbatchescount = Integer.parseInt(oldbatches); 
			System.out.println(adminHomePage.getEleBatchesCount().getText());
			studentSignInPage.elementStatus(adminHomePage.getEleCreateBatchText(),"Create batch text ","displayed");		
			adminHomePage.getEleCreateBatchText().click();
			Thread.sleep(6000);
			// To create multiple batches
			createBatchPage.multipleBatches(2);
			Thread.sleep(2000);
			// To verify the Confirmation table
			studentSignInPage.elementStatus(createBatchPage.getEleBatchConfirmTable(),"Batch Table ","displayed");
			Thread.sleep(2000);
			// To verify Batch status
			if(createBatchPage.getEleBatchExistsText().size()>=1){
				batchescreated=0;
				totalbatches=oldbatchescount+batchescreated;
				NXGReports.addStep("Batch Already Exists for given sections.", LogAs.PASSED, null);
			}
			if(createBatchPage.getEleBatchCreatedText().size()>=1){
				batchescreated=createBatchPage.getEleBatchCreatedText().size();
				totalbatches=oldbatchescount+batchescreated;
				NXGReports.addStep("New batch is created  for given sections.", LogAs.PASSED, null);
			}
			// To verify count of Updated batches 
			adminHomePage.getEleHomeText().click();
			Thread.sleep(2000);
			String newbatches=adminHomePage.getEleBatchesCount().getText();
			int newbatchescount = Integer.parseInt(newbatches); 
			if(totalbatches==newbatchescount){
				NXGReports.addStep("After creating new batches, batches count is updating in Admin home page", LogAs.PASSED, null);
			}
		} catch(Exception e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	 * @Description: Verify batch creation by selecting invalid section
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=9,enabled=false,description="Verify batch creation by selecting invalid section")
	public void testCreateBatchAlert(String browser) throws Throwable{	
		studentSignInPage=new StudentSignInPage(driver);
		adminHomePage=new AdminHomePage(driver);
		createBatchPage=new CreateBatchPage(driver);
		sTestData="AdminLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			Thread.sleep(6000);
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(12000);
			System.out.println(adminHomePage.getEleBatchesCount().getText());
			studentSignInPage.elementStatus(adminHomePage.getEleCreateBatchText(),"Create batch text ","displayed");		
			adminHomePage.getEleCreateBatchText().click();
			Thread.sleep(6000);
			// To create single batches
			adminHomePage.selectbyindexvalue(createBatchPage.getEleClassDropDown1(), 0);
			adminHomePage.selectbyvisibletext(createBatchPage.getEleSectionFromDropDown1(), "15");
			adminHomePage.selectbyvisibletext(createBatchPage.getEleSectionToDropDown1(), "1");
			createBatchPage.getEleCreateButton().click();	
			Thread.sleep(2000);
			System.out.println(driver.switchTo().alert().getText());
			NXGReports.addStep("Message in the Alert "+driver.switchTo().alert().getText(), LogAs.PASSED, null);
			driver.switchTo().alert().accept();
		}
		catch(Exception e)
	{
		NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
	}
	}
	/* 
	 * @Description: Verify the Document in Resources
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=11,enabled=false,description="Verify the Document in Resources")
	public void testResourceDocument(String browser) throws Exception
	{
	studentSignInPage=new StudentSignInPage(driver);
	adminHomePage=new AdminHomePage(driver);
	resourcesPage=new ResourcesPage(driver);
	sTestData="AdminLogin_01";
	sData=GenericLib.toReadExcelData(sTestData);
	try
	{
		loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
		Thread.sleep(2000);
		studentSignInPage.Login(sData[1],sData[2]);
		Thread.sleep(10000);
		adminHomePage.getEleResourcesIcon().click();
		Thread.sleep(10000);
		resourcesPage.getEleTechnicalManualButton().click();
	}
	catch(Exception e)
	{
		NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
	}
}
	/* 
	 * @Description: Verify change Profile image functionality with valid  file types.
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=12,enabled=true,description="Verify change Profile image functionality with valid  file types")
	public void testUploadValidProfileImage(String browser) throws Exception
	{
	studentSignInPage=new StudentSignInPage(driver);
	adminHomePage=new AdminHomePage(driver);
	sTestData="AdminLogin_01";
	sData=GenericLib.toReadExcelData(sTestData);
	try
	{
		loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
		Thread.sleep(2000);
		studentSignInPage.Login(sData[1],sData[2]);
		Thread.sleep(10000);
		adminHomePage.getEleEditLink().sendKeys(GenericLib.sDirPath+"\\jpegimage.jpeg");
		Thread.sleep(10000);
		adminHomePage.getEleEditLink().sendKeys(GenericLib.sDirPath+"\\pngimage.png");
	}
	catch(Exception e)
	{
		NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
		}
	}
	/* 
	 * @Description: Verify change Profile image functionality with invalid  file types
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=13,enabled=true,description="Verify change Profile image functionality with invalid  file types")
	public void testUploadInvalidProfileImage(String browser) throws Exception
	{
	studentSignInPage=new StudentSignInPage(driver);
	adminHomePage=new AdminHomePage(driver);
	sTestData="AdminLogin_01";
	sData=GenericLib.toReadExcelData(sTestData);
	try
	{
		loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
		Thread.sleep(2000);
		studentSignInPage.Login(sData[1],sData[2]);
		Thread.sleep(10000);
		adminHomePage.getEleEditLink().sendKeys(GenericLib.sDirPath+"\\testdata.docx");
		Thread.sleep(10000);
		adminHomePage.getEleEditLink().sendKeys(GenericLib.sDirPath+"\\testdata.txt");
	}
	catch(Exception e)
	{
		NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
		}
	}
	/* 
	 * @Description: Verify student data upload using Excel file
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=14,enabled=false,description="Verify Student Bulk upload using valid file, Verify Student Bulk upload using invalid filetypes")
	public void testStudenBulktUpload(String browser) throws Exception
	{
		studentSignInPage=new StudentSignInPage(driver);
		adminHomePage=new AdminHomePage(driver);
		studentUploadPage=new StudentUploadPage(driver);
		sTestData="AdminLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(8000);
			adminHomePage.getEleStudentUploadIcon().click();
			Thread.sleep(2000);
			adminHomePage.selectbyindexvalue(studentUploadPage.getEleClassDropdown(),1);
			Thread.sleep(1000);
			adminHomePage.selectbyindexvalue(studentUploadPage.getEleSectionDropdown(),2);
			Thread.sleep(2000);
			studentUploadPage.getEleUploadButton().sendKeys(GenericLib.rDirPath+"\\testdata\\Bulk_Student_Upload.xls");
			studentUploadPage.getEleSubmitBtn().click();
			Thread.sleep(4000);
			NXGReports.addStep(studentUploadPage.getEleErrMsgInAlert().getText()+"is displayed", LogAs.PASSED, null);
			studentUploadPage.getEleAlertCloseIcn().click();
			Thread.sleep(2000);
	}
	catch(Exception e)
	{
		NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;	
		}
	}
	}
	