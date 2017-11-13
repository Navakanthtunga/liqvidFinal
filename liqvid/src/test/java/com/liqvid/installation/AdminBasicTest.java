package com.liqvid.installation;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.liqvid.library.BaseLib;
import com.liqvid.library.GenericLib;
import com.liqvid.page.AdminHomePage;
import com.liqvid.page.CreateBatchPage;
import com.liqvid.page.LicensePage;
import com.liqvid.page.StudentRegistrationPage;
import com.liqvid.page.StudentSignInPage;
import com.liqvid.page.SuccessfulRegisterationPage;
import com.liqvid.page.TeacherRegistrationPage;

public class AdminBasicTest extends BaseLib {
	StudentSignInPage studentSignInPage=null;
	 AdminHomePage adminHomePage=null;
	 CreateBatchPage createBatchPage=null;
	 String sTestData=null;
	 String[] sData=null;
	TeacherRegistrationPage teacherRegistrationPage=null;
	StudentRegistrationPage studentRegisterationPage=null;
	SuccessfulRegisterationPage successfulRegisterationPage=null;
	LicensePage licensePage=null;
    /* 
	 * @Description: 
	 * @Author: Navakanth
	 */
	@Parameters("browser")
	@Test(priority=1,enabled=false,description="Before Creating batches, click on registration button and verify the message.")
	public void verifyRegistrationFunctionality(String browser) throws Exception
	{   
		studentSignInPage=new StudentSignInPage(driver);
    	try	{
    			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
    			Thread.sleep(5000);
    			studentSignInPage.getEleRegisterBtn().click();
    			Thread.sleep(2000);
    			studentSignInPage.elementStatus(studentSignInPage.getEleBatchesMsg(),"No batches were found. Kindly login to Admin Panel and first create batches.","displayed");
    			studentSignInPage.elementStatus(studentSignInPage.getEleBackBtn(),"Back Button","displayed");
    			studentSignInPage.getEleBackBtn().click();
    			Thread.sleep(2000);
    		} 
	catch (Exception e) 
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
	@Test(priority=3,enabled=true,description="Create a new teacher for one batch, verify  new credentials and count of teachers  in Admin home page")
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
	 * @Description: Create a new Student with MobileNumber, verify  new credentials and count of Student  in Admin home page
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=4,enabled=true,description="Create a new Student with MobileNumber, Verify new credentials and count of Student  in Admin home page")
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
			Thread.sleep(5000);	
			studentSignInPage.getEleStudentRadioBtn().click();
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
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleRegLoginId(),"'Login Id' ","displayed");
			System.out.println(successfulRegisterationPage.getEleRegLoginId().getText());
			String regLoginID=successfulRegisterationPage.getEleRegLoginId().getText();
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleRegPassword(),"'Password' ","displayed");
			System.out.println(successfulRegisterationPage.getEleRegPassword().getText());
			String regPassword=successfulRegisterationPage.getEleRegPassword().getText();
			studentSignInPage.elementStatus(successfulRegisterationPage.getEleClickHereText(),"'Click Here to Login' text ","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleEnglishEdgeWebLink(),"'English Edge Website Link' ","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleCopyRights(),"'CopyRights' ","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleCodeVersionDateText(),"'Code''Version' 'Date'","displayed");
			Thread.sleep(5000);
			GenericLib.toWriteExcelData("StudentLogin_01",GenericLib.getSubstring(regLoginID, 11),GenericLib.getSubstring(regPassword, 11));
			successfulRegisterationPage.getEleClickHereLink().click();
			Thread.sleep(10000);
			sData=GenericLib.toReadExcelData("AdminLogin_01");
			// To verify the Student count in Admin home page
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
			}
		} catch(Exception e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}	
}