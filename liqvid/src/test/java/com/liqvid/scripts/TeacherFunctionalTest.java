package com.liqvid.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.liqvid.library.BaseLib;
import com.liqvid.library.GenericLib;
import com.liqvid.library.ParallelBaseLib;
import com.liqvid.page.ActivityPage;
import com.liqvid.page.AttendencePage;
import com.liqvid.page.StudentSignInPage;
import com.liqvid.page.TeacherCoursePage;
import com.liqvid.page.TeacherHomePage;
import com.liqvid.page.TeacherProfilePage;
import com.liqvid.page.TeacherSessionsPage;
import com.liqvid.page.TeacherSignPage;

public class TeacherFunctionalTest extends BaseLib {
	TeacherSignPage teacherSigninPage=null;
	TeacherHomePage teacherHomePage=null;
	TeacherProfilePage teacherProfilePage=null;
	TeacherCoursePage teacherCoursePage=null;
	StudentSignInPage studentSignInPage=null;
	TeacherSessionsPage teacherSessionsPage=null;
	AttendencePage attendencePage=null;
	ActivityPage activityPage=null;
	String sTestData=null;
	String[] sData=null;
	/* 
	 * @Description:Login as Teacher with valid Credentials. Verify Teacher home page with teacher details is displayed.
	 * @Author:Shradanjali
	 */
	@Parameters("browser")
	@Test(priority=1,enabled=false,description="Login as Teacher with valid Credentials. Verify Teacher home page with teacher details is displayed.")
    public void testTeacherValidLoginVerifyHomePage(String browser) throws Exception
    {
		teacherSigninPage=new TeacherSignPage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		studentSignInPage=new StudentSignInPage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.elementStatus(teacherSigninPage.getEleUserNameTextField(),"UserName Text Field is","enabled");
			studentSignInPage.elementStatus(teacherSigninPage.getElePasswordTextFiled(),"Password Text Field is", "enabled");
			studentSignInPage.Login(sData[1],sData[2]);
			studentSignInPage.elementStatus(teacherHomePage.getEleWelcomeText(),"The Welcome text is", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleCoursesTab(),"Course Tab is", "displayed");
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
    }
	/* 
	 * @Description:Login as Teacher with Invalid Credentials, and verify the error message.
	 * @Author:Shradanjali
	 */
	@Parameters("browser")
	@Test(priority=2,enabled=false,description="Login as Teacher with Invalid Credentials, and verify the error message.")
	public void testTeacherloginInvalid(String browser) throws Exception
	{
		teacherSigninPage=new TeacherSignPage(driver);
		studentSignInPage=new StudentSignInPage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[4],sData[2]);
			studentSignInPage.elementStatus(teacherSigninPage.getEleErrorMsgLogin(),"Incorrect username or password","displayed");
			studentSignInPage.Login(sData[1],sData[4]);
			studentSignInPage.elementStatus(teacherSigninPage.getEleErrorMsgLogin(),"Incorrect username or password","displayed");
			studentSignInPage.Login(sData[3],sData[4]);
			studentSignInPage.elementStatus(teacherSigninPage.getEleErrorMsgLogin(),"Incorrect username or password","displayed");
	   }
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	 * @Description:Login as teacher for the first time.Verify total Sessions, completed and Remaining count
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=3,enabled=false,description="Login as teacher for the first time.Verify total Sessions, completed and Remaining count")
	public void testTeacherHomepageTotalSessionCount(String browser) throws Exception
	{
		teacherSigninPage=new TeacherSignPage(driver);
		studentSignInPage=new StudentSignInPage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			teacherSigninPage.getEleSignInBtn().click();
			studentSignInPage.elementStatus(teacherHomePage.getEleCoursesTab(),"Course Tab is", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleTotalSessionCount()," Total Sessions Count","displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleCompletedSessionCount(),"Completed Session Count", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleRemainingSessionCount(), "Remaining Session Count", "displayed");
			Thread.sleep(3000);
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	 * @Description:Complete 1 session and Verify Session Count
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=4,enabled=false,description="Complete 1 session and Verify Session Count")
	public void testTeacherSessionCountAfterOneSession(String browser) throws Exception
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		studentSignInPage=new StudentSignInPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(6000);
			studentSignInPage.elementStatus(teacherHomePage.getEleCoursesTab(),"Course Tab is", "displayed");
		    Thread.sleep(6000);
		    teacherCoursePage.getEleCourseTab().click();
			Thread.sleep(2000);	
			studentSignInPage.elementStatus(teacherCoursePage.getEleBatchText(),"Batch Text is", "displayed");
			new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);;
			Thread.sleep(2000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			teacherCoursePage.getEleStartCourseButton().click();
			studentSignInPage.elementStatus(teacherCoursePage.getEleAllSessions(),"All sessions  are", "displayed");
		    Thread.sleep(2000);
		    teacherSigninPage.scrolldown();
			Thread.sleep(2000);
			driver.switchTo().frame(0);
			teacherCoursePage.getElePreAssessmentLink().sendKeys(Keys.ENTER);
			studentSignInPage.elementStatus(teacherCoursePage.getEleEnglishEdgeText(),"All Instruction are", "displayed");
			Thread.sleep(2000);
			teacherSigninPage.handleStartTestbutton();
			Thread.sleep(8000);
			studentSignInPage.elementStatus(teacherCoursePage.getEleClass1PreAssessmentText(),"The Pre Assessment text is ", "displayed");
	    }
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	 * @Description:Login as a teacher, start a session, Logout and Login again Verify Last Login, Last Course taken and Last Seesion taken details are updated.
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=5,enabled=false,description="Login as a teacher, start a session, Logout and Login again Verify Last Login, Last Course taken and Last Seesion taken details are updated.")
	public void testTeacherCheckLastLoginLastcourseLastSession(String browser) throws Exception
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		studentSignInPage=new StudentSignInPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(6000);
			studentSignInPage.elementStatus(teacherHomePage.getEleCoursesTab(),"Course Tab is", "displayed");
		    Thread.sleep(6000);
		    teacherCoursePage.getEleCourseTab().click();
		    studentSignInPage.elementStatus(teacherCoursePage.getEleBatchText(),"Batch Text is", "displayed");
			Thread.sleep(2000);	
			new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);;
			Thread.sleep(2000);
		    new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);;
			teacherCoursePage.getEleStartCourseButton().click();
			studentSignInPage.elementStatus(teacherCoursePage.getEleAllSessions(),"All sessions  are", "displayed");
		    Thread.sleep(2000);
		    teacherSigninPage.scrolldown();
			Thread.sleep(2000);
			driver.switchTo().frame(0);
			teacherCoursePage.getEleMyRabbitLink().sendKeys(Keys.ENTER);
			studentSignInPage.elementStatus(teacherCoursePage.getEleIntroductionText(),"Instruction is", "displayed");
			Thread.sleep(2000);
			teacherCoursePage.switchtochildframe();
			teacherCoursePage.NextAndPrevButton();
			teacherCoursePage.switchingparentframe();
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			teacherHomePage.getEleHomeTab().click();
			studentSignInPage.elementStatus(teacherHomePage.getEleCoursesTab(),"Home Tab is", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleLastCourse(),"Last course is", "displayed");
			NXGReports.addStep(teacherHomePage.getEleLastCourse().getText()," ", LogAs.PASSED, null);
			studentSignInPage.elementStatus(teacherHomePage.getEleLastLogin(),"Last login is", "displayed");
			NXGReports.addStep(teacherHomePage.getEleLastLogin().getText()," ", LogAs.PASSED, null);
			studentSignInPage.elementStatus(teacherHomePage.getEleLastSession(),"Last Session is", "displayed");
			NXGReports.addStep(teacherHomePage.getEleLastSession().getText()," ", LogAs.PASSED, null);
			Thread.sleep(5000);
			teacherHomePage.getEleProfileTextDropdown().click();
			Thread.sleep(5000);
			teacherHomePage.getEleLogoutOption().click();
			studentSignInPage.Login(GenericLib.getCongigValue(GenericLib.sConfigFile, "TEACHERLOGINID"),GenericLib.getCongigValue(GenericLib.sConfigFile, "TEACHERPASSWORD"));
			NXGReports.addStep(teacherHomePage.getEleLastCourse().getText(),LogAs.PASSED, null);
			NXGReports.addStep(teacherHomePage.getEleLastLogin().getText(),LogAs.PASSED, null);
			NXGReports.addStep(teacherHomePage.getEleLastSession().getText(),LogAs.PASSED, null);
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	 * @Description:Click on Teacher Profile photo verify it is asking for Upload Picture or n't and Upload a Picture
	 * @Author:Shradanjali
	 */
	@Parameters("browser")
	@Test(priority=6,enabled=false,description="Click on Teacher Profile photo verify it is asking for Upload Picture or n't and Upload a Picture")
	public void testTeacherUploadingProfilePhoto(String browser) throws Exception
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		studentSignInPage=new StudentSignInPage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(6000);
			studentSignInPage.elementStatus(teacherHomePage.getEleTeacherProfilePhoto(),"The Profile photo option is", "displayed");
			teacherHomePage.getEleTeacherProfilePhoto().click();
			Thread.sleep(4000);
			teacherHomePage.getElePhotoPath().sendKeys(GenericLib.sDirPath+"\\jpegimage.jpeg");
			Thread.sleep(4000);
			studentSignInPage.elementStatus(teacherHomePage.getEleSubmitBtn(),"The Submit Button is", "displayed");
			teacherHomePage.getEleSubmitBtn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(teacherHomePage.getEleTeacherProfilePhoto(),"Profile Photo is","displayed");
			teacherHomePage.getEleTeacherProfilePhoto().click();
			teacherHomePage.getEleRemoveImageBtn().click();
			
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	 * @Description:Click on Teacher Profile photo and Click on 'Remove Image'button and verify the image is removed in the homepage
	 * @Author:Shradanjali
	 */
	@Parameters("browser")
	@Test(priority=7,enabled=false,description="Click on Teacher Profile photo and Click on 'Remove Image'button and verify the image is removed in the homepage")
	public void testTeacherFunctionalityOfRemoveImage(String browser) throws Exception
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		studentSignInPage=new StudentSignInPage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(6000);
			studentSignInPage.elementStatus(teacherHomePage.getEleCoursesTab(),"Course Tab is", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleTeacherProfilePhoto(),"The Profile photo option is", "displayed");
			teacherHomePage.getEleTeacherProfilePhoto().click();
			Thread.sleep(6000);
			teacherHomePage.getElePhotoPath().sendKeys(GenericLib.sDirPath+"\\jpegimage.jpeg");
			Thread.sleep(4000);
			studentSignInPage.elementStatus(teacherHomePage.getEleSubmitBtn(),"The Submit Button is", "displayed");
			teacherHomePage.getEleSubmitBtn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(teacherHomePage.getEleTeacherProfilePhoto(),"Profile Photo is","displayed");
			if(teacherHomePage.getEleTeacherProfileimage().getAttribute("src").contains("/learning/themes/notebook/images/logo.png"))
			{
				studentSignInPage.elementStatus(teacherHomePage.getEleTeacherProfileimage(),"The Teacher profile image is", "displayed");
			}
				else
				{
					studentSignInPage.elementStatus(teacherHomePage.getEleTeacherProfileimage(),"The Teacher profile image is ", "not displayed");
				}
			teacherHomePage.getEleTeacherProfilePhoto().click();
			Thread.sleep(4000);
			studentSignInPage.elementStatus(teacherHomePage.getEleRemoveImageBtn(),"The Remove image button is ", "displayed");
			if(teacherHomePage.getEleRemoveImageBtn().isDisplayed())
			{
			    teacherHomePage.getEleRemoveImageBtn().click();
			    if(teacherHomePage.getEleTeacherProfileimage().getAttribute("src").contains("/learning/themes/notebook/images/avatar_default.jpg"))
			    {
			    	studentSignInPage.elementStatus(teacherHomePage.getEleTeacherProfileimage(),"The Teacher profile image is ", "displayed");
			    }
				else
				{
					studentSignInPage.elementStatus(teacherHomePage.getEleTeacherProfileimage(),"The Teacher profile image is ", "not displayed");
				}
			}
			else
			{
				studentSignInPage.elementStatus(teacherHomePage.getEleCancelBtn(),"The cancel button is ", "displayed");
				teacherHomePage.getEleCancelBtn().click();
				studentSignInPage.elementStatus(teacherHomePage.getEleTeacherProfilePhoto(),"The Profile photo option is", "displayed");
			}
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	 * @Description:Edit the Teacher Profile with valid details.Verify the teacher profile details are updated in the teacher home page.
	 * @Author:Shradanjali
	 */
	@Parameters("browser")
	@Test(priority=8,enabled=false,description="Edit the Teacher Profile with valid details.Verify the teacher profile details are updated in the teacher home page.")
	public void testTeacherUpdateProfile(String browser) throws Exception
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		teacherProfilePage=new TeacherProfilePage(driver);
		studentSignInPage=new StudentSignInPage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(6000);
			studentSignInPage.elementStatus(teacherHomePage.getEleCoursesTab(),"Course Tab is", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleProfileTextDropdown(),"The Profile photo dropdown is", "displayed");
			teacherHomePage.getEleProfileTextDropdown().click();
			Thread.sleep(3000);
			studentSignInPage.elementStatus(teacherHomePage.getEleProfileOption(),"The Profile option is", "displayed");
			Thread.sleep(2000);
			teacherHomePage.getEleProfileOption().click();
			Thread.sleep(3000);
			teacherProfilePage.getEleFirstNameTextBox().clear();
			teacherProfilePage.getEleLastNameTextBox().clear();
			teacherProfilePage.getEleEmailIdTextBox().clear();
			teacherProfilePage.getElePhoneTextBox().clear();
			teacherProfilePage.UpdateProfile(sData[5],sData[6],sData[7],sData[8]);
			Thread.sleep(2000);
			studentSignInPage.elementStatus(teacherProfilePage.getEleDateOfBirthTextBox(),"The Date of Birth Textbox is", "displayed");
			if(teacherProfilePage.getEleDateOfBirthTextBox().isDisplayed())
			{
				for(int i=0;i<2;i++)
				{
					studentSignInPage.elementStatus(teacherProfilePage.getEleCalendarIcon(),"The Calender icon is", "displayed");
					teacherProfilePage.getEleCalendarIcon().click();
					Thread.sleep(3000);
					studentSignInPage.elementStatus(teacherProfilePage.getEleDateSelected(),"The date selected is", "displayed");
					teacherProfilePage.getEleDateSelected().click();
				}
			}
			Thread.sleep(3000);
			studentSignInPage.elementStatus(teacherProfilePage.getEleGenderDropDown(),"The Date of Birth Drop Down is", "displayed");
			teacherProfilePage.getEleGenderDropDown().click();
			WebElement mySelectElement = driver.findElement(By.id("gender"));
			Select dropdown= new Select(mySelectElement);
			dropdown.selectByIndex(1);
			Thread.sleep(2000);
			teacherProfilePage.getEleUpdateButton().click();
			Thread.sleep(3000);
			studentSignInPage.elementStatus(teacherProfilePage.getEleUpdateSucessFullMsg(),"Updated Sucessfully message is","displayed");
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	 * @Description:Verify 'This value required'error message,'This value should be a valid email.','This value should be a valid phone number.'
	 * @Author:Shradanjali
	 */
	@Parameters("browser")
	@Test(priority=9,enabled=false,description="Verify 'This value required'error message,'This value should be a valid email.','This value should be a valid phone number.'")
	public void testTeacherinvalidErrorMsg(String browser) throws Exception{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		teacherProfilePage=new TeacherProfilePage(driver);
		studentSignInPage=new StudentSignInPage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(4000);
			studentSignInPage.elementStatus(teacherHomePage.getEleCoursesTab(),"Course Tab is", "displayed");
			teacherHomePage.getEleProfileTextDropdown().click();
			Thread.sleep(3000);
			teacherHomePage.getEleProfileOption().click();
			Thread.sleep(3000);
			teacherProfilePage.getEleFirstNameTextBox().clear();
			teacherProfilePage.getEleLastNameTextBox().clear();
			teacherProfilePage.getEleEmailIdTextBox().clear();
			teacherProfilePage.getElePhoneTextBox().clear();
			Thread.sleep(2000);
			teacherProfilePage.getEleChangePwd().click();
			teacherProfilePage.getEleUpdateButton().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(teacherProfilePage.getEeleValueRequiredErrMsg(),"This value requried error message is displayed is", "displayed");
			teacherProfilePage.getEleEmailIdTextBox().sendKeys(sData[1]);
			teacherProfilePage.getElePhoneTextBox().sendKeys(sData[7]);
			teacherProfilePage.getEleUpdateButton().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(teacherProfilePage.getEleEmailIdErrorMsg(),"The error 'This value should be a valid email.'is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getElePhoneNumberErrorMsg(),"The error 'This value should be a valid phone number.' is", "displayed");
		}catch(AssertionError e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	 * @Description:Verify 'Invalid old  password' error message, 'This value should be same' error message , Change password Functionality.
	 * @Author:Shradanjali
	 */
	@Parameters("browser")
	@Test(priority=10,enabled=false, description="Verify 'Invalid old  password' error message, 'This value should be same' errror message , Change password Functionality.")
	public void testChangePasswordFunctionality(String browser) throws Exception
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		teacherProfilePage=new TeacherProfilePage(driver);
		studentSignInPage=new StudentSignInPage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(4000);
			studentSignInPage.elementStatus(teacherHomePage.getEleCoursesTab(),"Course Tab", "displayed");
			teacherHomePage.getEleProfileTextDropdown().click();
			Thread.sleep(5000);
			teacherHomePage.getEleProfileOption().click();
			Thread.sleep(3000);
			studentSignInPage.elementStatus(teacherProfilePage.getEleChangePwd(),"Change password is", "displayed");
			teacherProfilePage.getEleChangePwd().click();
			Thread.sleep(3000);
			teacherProfilePage.getEleOldPasswordTextBox().sendKeys(sData[3]);
			teacherProfilePage.getEleNewPasswordTextBox().sendKeys(sData[9]);
			teacherProfilePage.getEleConfirmNewPasswordTextBox().sendKeys(sData[9]);
			teacherProfilePage.getEleUpdateButton().click();
			studentSignInPage.elementStatus(teacherProfilePage.getEleInvalidOldPwdErrMsg(),"Invalid old Password Error message ", "displayed");
			Thread.sleep(2000);
			teacherProfilePage.getEleChangePwd().click();
			Thread.sleep(3000);
			teacherProfilePage.getEleNewPasswordTextBox().sendKeys(sData[9]);
			teacherProfilePage.getEleConfirmNewPasswordTextBox().sendKeys(sData[2]);
			teacherProfilePage.getEleUpdateButton().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(teacherProfilePage.getEleValueShouldbeSameMsg(),"The value should be same message is", "displayed");
			teacherProfilePage.getEleConfirmNewPasswordTextBox().clear();
			teacherProfilePage.getEleConfirmNewPasswordTextBox().sendKeys(sData[9]);
			teacherProfilePage.getEleOldPasswordTextBox().sendKeys(sData[2]);
			Thread.sleep(2000);
			teacherProfilePage.getEleUpdateButton().click();
			Thread.sleep(3000);
			studentSignInPage.elementStatus(teacherProfilePage.getEleUpdateSucessFullMsg(),"Updated Sucessfully message is","displayed");
			teacherHomePage.getEleProfileTextDropdown().click();
			studentSignInPage.elementStatus(teacherHomePage.getEleLogoutOption(),"logout link is ", "displayed");
			Thread.sleep(6000);
			teacherHomePage.getEleLogoutOption().click();
			//Clean up code
			studentSignInPage.Login(sData[1],sData[9]);
			Thread.sleep(5000);
			studentSignInPage.elementStatus(teacherHomePage.getEleCoursesTab(),"Course Tab", "displayed");
			teacherHomePage.getEleProfileTextDropdown().click();
			Thread.sleep(5000);
			teacherHomePage.getEleProfileOption().click();
			Thread.sleep(3000);
			teacherProfilePage.getEleChangePwd().click();
			Thread.sleep(3000);
			studentSignInPage.elementStatus(teacherProfilePage.getEleOldPasswordTextBox(),"The old password textbox is ", "displayed");
			teacherProfilePage.getEleOldPasswordTextBox().sendKeys(sData[9]);
			studentSignInPage.elementStatus(teacherProfilePage.getEleNewPasswordTextBox(),"The new password textbox is ", "displayed");
			teacherProfilePage.getEleNewPasswordTextBox().sendKeys(sData[2]);
			studentSignInPage.elementStatus(teacherProfilePage.getEleConfirmNewPasswordTextBox(),"The confirm password textbox is ", "displayed");
			teacherProfilePage.getEleConfirmNewPasswordTextBox().sendKeys(sData[2]);
			teacherProfilePage.getEleUpdateButton().click();
			Thread.sleep(5000);
		}catch(AssertionError e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	 * @Description:Verify 'Greetings and Introduction' 'Activity' link
	 * @Author:Navakanth
	 */
    @Parameters("browser")
    @Test(priority=11,enabled=false,description="Verify 'Greetings and Introduction' 'Activity' link")
	public void testGreetingsAndIntroductionActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getEleAttendenceIcn(), teacherSessionsPage.getEleAttendenceTxt());
	        activityPage.allStudentAttendenceNegative(teacherSessionsPage.getEleAttendenceIcn(), teacherSessionsPage.getEleAttendenceTxt());
  	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getEleConceptLnk(), "'Greetings and Introduction' Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleConceptLnk());
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleActivityLnk());
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        // To verify Groups Count and number of groups present
	        activityPage.createMaximumGroups();
	        Thread.sleep(2000);
	        activityPage.createMinmumGroups();
	        int numberOfGroups=activityPage.getEleGroups().size();
	        if(numberOfGroups==GenericLib.getIntegerNumber(activityPage.getEleGroupCnt())){
	        NXGReports.addStep("Groups count and Number of groups displaying.", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "enabled");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(2000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getElePageProgressIcn(), "Page progress Icon", "displayed");
	        NXGReports.addStep("page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        System.out.println("Page "+activityPage.getElePageNumTxt().getText());
	        }
	        else{
	        NXGReports.addStep("Groups count and Number of groups are not same", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	        }
	       // For Activity 1 of 3
	        activityPage.handleActivity();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 2 of 3
	        activityPage.handleActivity();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 3 of 3
	        activityPage.handleActivity();
		    // Question and Answer page
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Question and Options", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "Question title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleShowAnsBtn(), "'Show Answer' Button", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleShowAnsBtn().click();
	        NXGReports.addStep( "Clicked on 'Show Answer Button'", LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleQuesAndAnswerStn(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getElePageSubtitleTxt(), "'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(4000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getEleActivityLnk());
	        Thread.sleep(2000);
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	 * @Description:Verify 'Family And Friends' 'Activity' link
	 * @Author:Navakanth
	 */  
    @Parameters("browser")
    @Test(priority=12,enabled=false,description="Verify 'Family And Friends' 'Activity' link")
	public void testFamilyAndFriendsActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getEleFamilyAndFriendsAttendenceIcn(), teacherSessionsPage.getEleFamilyAndFriendsAttendenceTxt());
	        activityPage.allStudentAttendenceNegative(teacherSessionsPage.getEleFamilyAndFriendsAttendenceIcn(), teacherSessionsPage.getEleFamilyAndFriendsAttendenceTxt());
	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getEleFamilyAndFriendsConceptlnk(), "Friends and family Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleFamilyAndFriendsConceptlnk());
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleFamilyAndFriendsActivitylnk());
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        studentSignInPage.elementStatus( activityPage.getEleHomeIcn(), "Home Icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleActivityTitleTxt(), "Activity Title", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleGlosaryIcn(), "Glosary icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleTeacherNameTxt(), "Teacher name text", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleProfileImg(), "Profile Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        // To verify Groups Count and number of groups present
	        activityPage.createMaximumGroups();
	        Thread.sleep(2000);
	        activityPage.createMinmumGroups();
	        int numberOfGroups=activityPage.getEleGroups().size();
	        if(numberOfGroups==GenericLib.getIntegerNumber(activityPage.getEleGroupCnt())){
	        NXGReports.addStep("Groups count and Number of groups displaying.", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");

	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "enabled");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(2000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getElePageProgressIcn(), "Page progress Icon", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        System.out.println("Page "+activityPage.getElePageNumTxt().getText());
	        }
	        else{
	        NXGReports.addStep("Groups count and Number of groups are not same", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	        }
	       // For Activity 1 of 3
	        activityPage.handleActivity();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 2 of 3
	        activityPage.handleActivity();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 3 of 3
	        activityPage.handleActivity();
		    // Question and Answer page
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Question and Options", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "Question title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleShowAnsBtn(), "'Show Answer' Button", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleShowAnsBtn().click();
	        NXGReports.addStep( "Clicked on 'Show Answer Button'", LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleQuesAndAnswerStn(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(5000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getEleFamilyAndFriendsActivitylnk());
	        Thread.sleep(2000);
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	 * @Description:Verify 'Acquiring Information' 'Activity' link
	 * @Author:Navakanth
	 */@Parameters("browser")
    @Test(priority=13,enabled=false,description="Verify 'Acquiring Information' 'Activity' link")
	public void testAcquiringInformationActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getEleAcquiringInfoAttendenceIcn(), teacherSessionsPage.getEleAcquiringInfoAttendenceTxt());
	       	activityPage.allStudentAttendenceNegative(teacherSessionsPage.getEleAcquiringInfoAttendenceIcn(), teacherSessionsPage.getEleAcquiringInfoAttendenceTxt());
	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getEleAcquiringInfoConceptlnk(), "'Acquiring Information' Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleAcquiringInfoConceptlnk());
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleAcquiringInfoActivitylnk());
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        }
	        studentSignInPage.elementStatus( activityPage.getEleHomeIcn(), "Home Icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleActivityTitleTxt(), "Activity Title", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleGlosaryIcn(), "Glosary icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleTeacherNameTxt(), "Teacher name text", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleProfileImg(), "Profile Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        // To verify Groups Count and number of groups present
	        activityPage.createMaximumGroups();
	        Thread.sleep(2000);
	        activityPage.createMinmumGroups();
	        int numberOfGroups=activityPage.getEleGroups().size();
	        if(numberOfGroups==GenericLib.getIntegerNumber(activityPage.getEleGroupCnt())){
	        NXGReports.addStep("Groups count and Number of groups displaying.", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "enabled");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(2000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getElePageProgressIcn(), "Page progress Icon", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        System.out.println("Page "+activityPage.getElePageNumTxt().getText());
	        }
	        else{
	        NXGReports.addStep("Groups count and Number of groups are not same", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	        }
	       // For Activity 1 of 3
	        activityPage.handleActivity();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 2 of 3
	        activityPage.handleActivity();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 3 of 3
	        activityPage.handleActivity1();
		    // Question and Answer page
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Question and Options", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "Question title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleShowAnsBtn(), "'Show Answer' Button", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleShowAnsBtn().click();
	        NXGReports.addStep( "Clicked on 'Show Answer Button'", LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleQuesAndAnswerStn(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(5000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getEleAcquiringInfoActivitylnk());
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	 * @Description:Verify 'Being Aware' 'Activity' link
	 * @Author:Navakanth
	 */
	 @Parameters("browser")
    @Test(priority=14,enabled=false,description="Verify 'Being Aware' 'Activity' link")
	public void testBeingAwareActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getEleBeingAwareAttendenceIcn(), teacherSessionsPage.getEleBeingAwareAttendenceTxt());
	        activityPage.allStudentAttendenceNegative(teacherSessionsPage.getEleBeingAwareAttendenceIcn(), teacherSessionsPage.getEleBeingAwareAttendenceTxt());
	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getEleBeingAwareConceptlnk(), "'Being Aware' Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleBeingAwareConceptlnk());
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleBeingAwareActivitylnk());
	        Thread.sleep(2000);
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        }
	        studentSignInPage.elementStatus( activityPage.getEleHomeIcn(), "Home Icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleActivityTitleTxt(), "Activity Title", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleGlosaryIcn(), "Glosary icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleTeacherNameTxt(), "Teacher name text", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleProfileImg(), "Profile Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        // To verify Groups Count and number of groups present
	        activityPage.createMaximumGroups();
	        Thread.sleep(2000);
	        activityPage.createMinmumGroups();
	        int numberOfGroups=activityPage.getEleGroups().size();
	        if(numberOfGroups==GenericLib.getIntegerNumber(activityPage.getEleGroupCnt())){
	        NXGReports.addStep("Groups count and Number of groups displaying.", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "enabled");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(2000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getElePageProgressIcn(), "Page progress Icon", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        System.out.println("Page "+activityPage.getElePageNumTxt().getText());
	        }
	        else{
	        NXGReports.addStep("Groups count and Number of groups are not same", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	        }
	       // For Activity 1 of 3
	        activityPage.handleActivity1();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 2 of 3
	        activityPage.handleActivity();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 3 of 3
	        activityPage.handleActivity();
		    // Question and Answer page
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Question and Options", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "Question title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleShowAnsBtn(), "'Show Answer' Button", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleShowAnsBtn().click();
	        NXGReports.addStep( "Clicked on 'Show Answer Button'", LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleQuesAndAnswerStn(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(5000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getEleBeingAwareActivitylnk());
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	 * @Description:Verify 'General Enquiry' 'Activity' link
	 * @Author:Navakanth
	 */
    @Parameters("browser")
    @Test(priority=15,enabled=false,description="Verify 'General Enquiry' 'Activity' link")
	public void testGeneralEnquiryActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getEleGeneralEnquiryAttendenceIcn(), teacherSessionsPage.getEleGeneralEnquiryAttendenceTxt());
	        activityPage.allStudentAttendenceNegative(teacherSessionsPage.getEleGeneralEnquiryAttendenceIcn(), teacherSessionsPage.getEleGeneralEnquiryAttendenceTxt());
	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getEleGeneralEnquiryConceptlnk(), "'General Enquiry' Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleGeneralEnquiryConceptlnk());
	        Thread.sleep(2000);
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleGeneralEnquiryActivitylnk());
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        studentSignInPage.elementStatus( activityPage.getEleHomeIcn(), "Home Icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleActivityTitleTxt(), "Activity Title", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleGlosaryIcn(), "Glosary icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleTeacherNameTxt(), "Teacher name text", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleProfileImg(), "Profile Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        // To verify Groups Count and number of groups present
	        activityPage.createMaximumGroups();
	        Thread.sleep(2000);
	        activityPage.createMinmumGroups();
	        int numberOfGroups=activityPage.getEleGroups().size();
	        if(numberOfGroups==GenericLib.getIntegerNumber(activityPage.getEleGroupCnt())){
	        NXGReports.addStep("Groups count and Number of groups displaying.", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "enabled");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(2000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getElePageProgressIcn(), "Page progress Icon", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        System.out.println("Page "+activityPage.getElePageNumTxt().getText());
	        }
	        else{
	        NXGReports.addStep("Groups count and Number of groups are not same", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	        }
	       // For Activity 1 of 3
	        activityPage.handleActivity2();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 2 of 3
	        activityPage.handleActivity1();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 3 of 3
	        activityPage.handleActivity2();
		    // Question and Answer page
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Question and Options", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "Question title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleShowAnsBtn(), "'Show Answer' Button", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleShowAnsBtn().click();
	        NXGReports.addStep( "Clicked on 'Show Answer Button'", LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleQuesAndAnswerStn(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(5000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getEleGeneralEnquiryActivitylnk());
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	 * @Description:Verify 'Knowing People' 'Activity' link
	 * @Author:Navakanth
	 */
    @Parameters("browser")
    @Test(priority=16,enabled=false,description="Verify 'Knowing People' 'Activity' link")
	public void testKnowingPeopleActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getEleKnowingPeopleAttendenceIcn(), teacherSessionsPage.getEleKnowingPeopleAttendenceTxt());
	        activityPage.allStudentAttendenceNegative(teacherSessionsPage.getEleKnowingPeopleAttendenceIcn(), teacherSessionsPage.getEleKnowingPeopleAttendenceTxt());
	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getEleKnowingPeopleConceptlnk(), "'Knowing People' Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleKnowingPeopleConceptlnk());
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleKnowingPeopleActivitylnk());
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        studentSignInPage.elementStatus( activityPage.getEleHomeIcn(), "Home Icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleActivityTitleTxt(), "Activity Title", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleGlosaryIcn(), "Glosary icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleTeacherNameTxt(), "Teacher name text", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleProfileImg(), "Profile Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        // To verify Groups Count and number of groups present
	        activityPage.createMaximumGroups();
	        Thread.sleep(2000);
	        activityPage.createMinmumGroups();
	        int numberOfGroups=activityPage.getEleGroups().size();
	        if(numberOfGroups==GenericLib.getIntegerNumber(activityPage.getEleGroupCnt())){
	        NXGReports.addStep("Groups count and Number of groups displaying.", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "enabled");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(2000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getElePageProgressIcn(), "Page progress Icon", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        System.out.println("Page "+activityPage.getElePageNumTxt().getText());
	        }
	        else{
	        NXGReports.addStep("Groups count and Number of groups are not same", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	        }
	       // For Activity 1 of 3
	        activityPage.handleActivity1();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 2 of 3
	        activityPage.handleActivity();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 3 of 3
	        activityPage.handleActivity();
		    // Question and Answer page
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Question and Options", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "Question title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleShowAnsBtn(), "'Show Answer' Button", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleShowAnsBtn().click();
	        NXGReports.addStep( "Clicked on 'Show Answer Button'", LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleQuesAndAnswerStn(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(5000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getEleKnowingPeopleActivitylnk());
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	 * @Description:Verify 'Telling Time' 'Activity' link
	 * @Author:Navakanth
	 */
    @Parameters("browser")
    @Test(priority=17,enabled=false,description="Verify 'Telling Time' 'Activity' link")
	public void testTellingTimeActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getEleTellingTimeAttendenceIcn(), teacherSessionsPage.getEleTellingTimeAttendenceTxt());
	        activityPage.allStudentAttendenceNegative(teacherSessionsPage.getEleTellingTimeAttendenceIcn(), teacherSessionsPage.getEleTellingTimeAttendenceTxt());
	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getEleTellingTimeConceptlnk(), "'Telling Time' Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleTellingTimeConceptlnk());
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleTellingTimeActivitylnk());
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        studentSignInPage.elementStatus( activityPage.getEleHomeIcn(), "Home Icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleActivityTitleTxt(), "Activity Title", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleGlosaryIcn(), "Glosary icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleTeacherNameTxt(), "Teacher name text", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleProfileImg(), "Profile Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        // To verify Groups Count and number of groups present
	        activityPage.createMaximumGroups();
	        Thread.sleep(2000);
	        activityPage.createMinmumGroups();
	        int numberOfGroups=activityPage.getEleGroups().size();
	        if(numberOfGroups==GenericLib.getIntegerNumber(activityPage.getEleGroupCnt())){
	        NXGReports.addStep("Groups count and Number of groups displaying.", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "enabled");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(2000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getElePageProgressIcn(), "Page progress Icon", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        System.out.println("Page "+activityPage.getElePageNumTxt().getText());
	        }
	        else{
	        NXGReports.addStep("Groups count and Number of groups are not same", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	        }
	       // For Activity 1 of 3
	        activityPage.handleActivity1();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 2 of 3
	        activityPage.handleActivity2();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 3 of 3
	        activityPage.handleActivity1();
		    // Question and Answer page
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Question and Options", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions","displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "Question title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleShowAnsBtn(), "'Show Answer' Button", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleShowAnsBtn().click();
	        NXGReports.addStep( "Clicked on 'Show Answer Button'", LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleQuesAndAnswerStn(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(5000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getEleTellingTimeActivitylnk());
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	 * @Description:Verify 'Shopping for Basics' 'Activity' link
	 * @Author:Navakanth
	 */
    @Parameters("browser")
    @Test(priority=18,enabled=false,description="Verify 'Shopping for Basics' 'Activity' link")
	public void testShoppingforBasicsActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getEleShoppingforBasicsAttendenceIcn(), teacherSessionsPage.getEleShoppingforBasicsAttendenceTxt());
	        activityPage.allStudentAttendenceNegative(teacherSessionsPage.getEleShoppingforBasicsAttendenceIcn(), teacherSessionsPage.getEleShoppingforBasicsAttendenceTxt());
	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getEleShoppingforBasicsConceptlnk(), "'Shopping for Basics' Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleShoppingforBasicsConceptlnk());
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleShoppingforBasicsActivitylnk());
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        studentSignInPage.elementStatus( activityPage.getEleHomeIcn(), "Home Icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleActivityTitleTxt(), "Activity Title", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleGlosaryIcn(), "Glosary icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleTeacherNameTxt(), "Teacher name text", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleProfileImg(), "Profile Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        // To verify Groups Count and number of groups present
	        activityPage.createMaximumGroups();
	        Thread.sleep(2000);
	        activityPage.createMinmumGroups();
	        int numberOfGroups=activityPage.getEleGroups().size();
	        if(numberOfGroups==GenericLib.getIntegerNumber(activityPage.getEleGroupCnt())){
	        NXGReports.addStep("Groups count and Number of groups displaying.", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(2000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getElePageProgressIcn(), "Page progress Icon", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        System.out.println("Page "+activityPage.getElePageNumTxt().getText());
	        }
	        else{
	        NXGReports.addStep("Groups count and Number of groups are not same", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	        }
	       // For Activity 1 of 3
	        activityPage.handleActivity1();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 2 of 3
	        activityPage.handleActivity();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 3 of 3
	        activityPage.handleActivity();
		    // Question and Answer page
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Question and Options", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "Question title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleShowAnsBtn(), "'Show Answer' Button", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleShowAnsBtn().click();
	        NXGReports.addStep( "Clicked on 'Show Answer Button'", LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleQuesAndAnswerStn(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(5000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getEleShoppingforBasicsActivitylnk());
	        
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	 * @Description:Verify 'Casual Conversations' 'Activity' link
	 * @Author:Navakanth
	 */
    @Parameters("browser")
    @Test(priority=19,enabled=false,description="Verify 'Casual Conversations' 'Activity' link")
	public void testCasualConversationsActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getEleCasualConversationsAttendenceIcn(), teacherSessionsPage.getEleCasualConversationsAttendenceTxt());
	        activityPage.allStudentAttendenceNegative(teacherSessionsPage.getEleCasualConversationsAttendenceIcn(), teacherSessionsPage.getEleCasualConversationsAttendenceTxt());
	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getEleCasualConversationsConceptlnk(), "'Casual Conversations' Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleCasualConversationsConceptlnk());
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleCasualConversationsActivitylnk());
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        studentSignInPage.elementStatus( activityPage.getEleHomeIcn(), "Home Icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleActivityTitleTxt(), "Activity Title", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleGlosaryIcn(), "Glosary icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleTeacherNameTxt(), "Teacher name text", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleProfileImg(), "Profile Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        // To verify Groups Count and number of groups present
	        activityPage.createMaximumGroups();
	        Thread.sleep(2000);
	        activityPage.createMinmumGroups();
	        int numberOfGroups=activityPage.getEleGroups().size();
	        if(numberOfGroups==GenericLib.getIntegerNumber(activityPage.getEleGroupCnt())){
	        NXGReports.addStep("Groups count and Number of groups displaying.", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "enabled");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(2000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getElePageProgressIcn(), "Page progress Icon", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        System.out.println("Page "+activityPage.getElePageNumTxt().getText());
	        }
	        else{
	        NXGReports.addStep("Groups count and Number of groups are not same", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	        }
	       // For Activity 1 of 3
	        activityPage.handleActivity1();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 2 of 3
	        activityPage.handleActivity();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 3 of 3
	        activityPage.handleActivity();
		    // Question and Answer page
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Question and Options", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "Question title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleShowAnsBtn(), "'Show Answer' Button", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleShowAnsBtn().click();
	        NXGReports.addStep( "Clicked on 'Show Answer Button'", LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleQuesAndAnswerStn(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(5000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getEleCasualConversationsActivitylnk());
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	 * @Description:Verify 'Polite Conversations' 'Activity' link
	 * @Author:Navakanth
	 */
    @Parameters("browser")
    @Test(priority=20,enabled=false,description="Verify 'Polite Conversations' 'Activity' link")
	public void testPoliteConversationsActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getElePoliteConversationsAttendenceIcn(), teacherSessionsPage.getElePoliteConversationsAttendenceTxt());
	        activityPage.allStudentAttendenceNegative(teacherSessionsPage.getElePoliteConversationsAttendenceIcn(), teacherSessionsPage.getElePoliteConversationsAttendenceTxt());
	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getElePoliteConversationsConceptlnk(), "'Polite Conversations' Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getElePoliteConversationsConceptlnk());
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getElePoliteConversationsActivitylnk());
	        Thread.sleep(1000);
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        studentSignInPage.elementStatus( activityPage.getEleHomeIcn(), "Home Icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleActivityTitleTxt(), "Activity Title", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleGlosaryIcn(), "Glosary icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleTeacherNameTxt(), "Teacher name text", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleProfileImg(), "Profile Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        // To verify Groups Count and number of groups present
	        activityPage.createMaximumGroups();
	        Thread.sleep(2000);
	        activityPage.createMinmumGroups();
	        int numberOfGroups=activityPage.getEleGroups().size();
	        if(numberOfGroups==GenericLib.getIntegerNumber(activityPage.getEleGroupCnt())){
	        NXGReports.addStep("Groups count and Number of groups displaying.", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "enabled");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(2000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getElePageProgressIcn(), "Page progress Icon", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        System.out.println("Page "+activityPage.getElePageNumTxt().getText());
	        }
	        else{
	        NXGReports.addStep("Groups count and Number of groups are not same", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	        }
	       // For Activity 1 of 3
	        activityPage.handleActivity();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 2 of 3
	        activityPage.handleActivity1();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 3 of 3
	        activityPage.handleActivity1();
		    // Question and Answer page
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Question and Options", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "Question title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleShowAnsBtn(), "'Show Answer' Button", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleShowAnsBtn().click();
	        NXGReports.addStep( "Clicked on 'Show Answer Button'", LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleQuesAndAnswerStn(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(5000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getElePoliteConversationsActivitylnk());
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	 * @Description:Verify 'Organizing Get-togethers' 'Activity' link
	 * @Author:Navakanth
	 */
    @Parameters("browser")
    @Test(priority=21,enabled=true,description="Verify 'Organizing Get-togethers' 'Activity' link")
	public void testOrganizingGettogethersActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getEleOrganizingGettogethersAttendenceIcn(), teacherSessionsPage.getEleOrganizingGettogethersAttendenceTxt());
	        activityPage.allStudentAttendenceNegative(teacherSessionsPage.getEleOrganizingGettogethersAttendenceIcn(), teacherSessionsPage.getEleOrganizingGettogethersAttendenceTxt());
	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getEleOrganizingGettogethersConceptlnk(), "'Organizing Get-togethers' Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleOrganizingGettogethersConceptlnk());
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(2000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleOrganizingGettogethersActivitylnk());
	        System.out.println("Status-"+activityPage.getEleStartAgainBtn().isDisplayed());
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(2000);
	        }
	        Thread.sleep(1000);
	        studentSignInPage.elementStatus( activityPage.getEleHomeIcn(), "Home Icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleActivityTitleTxt(), "Activity Title", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleGlosaryIcn(), "Glosary icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleTeacherNameTxt(), "Teacher name text", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleProfileImg(), "Profile Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");
	        // For Activity 1 of 4
	        studentSignInPage.elementStatus( activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructionTxt(), "Page Instructions text", "displayed");
	        NXGReports.addStep("Page info :"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        studentSignInPage.elementStatus( activityPage.getEleExerciseInstructionTxt(), "Subtitle of the page in the header part", "displayed");
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			studentSignInPage.elementStatus( activityPage.getEleExcerciseTitleTxt(), "Page instructions is ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleExerciseTxt(), "Excercise Text", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleAudioInstructionTxt(), "Image title text ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleAudioIcn(), "Audio icon", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleAudioControlStn(), "Audio Contorl Bar", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(1000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(1000);
			studentSignInPage.elementStatus( activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleQuestionStn(), "Questions are ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleShowAnsBtn(), "'Show Answer' button", "displayed");
			activityPage.getEleShowAnsBtn().click();
			studentSignInPage.elementStatus( activityPage.getEleAnswerTxt(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        // For Activity 2 of 4
	        studentSignInPage.elementStatus( activityPage.getEleExerciseInstructionTxt(), "Subtitle of the page in the header part", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructionTxt(), "Page Instructions text", "displayed");
	        NXGReports.addStep("Page info "+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        studentSignInPage.elementStatus( activityPage.getEleExerciseInstructionTxt(), "Subtitle of the page in the header part", "displayed");
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			studentSignInPage.elementStatus( activityPage.getEleExcerciseTitleTxt(), "Page instructions is ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleExerciseTxt(), "Excercise Text", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleQuestionStn(), "Questions are ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleShowAnsBtn(), "'Show Answer' button", "displayed");
			activityPage.getEleShowAnsBtn().click();
			studentSignInPage.elementStatus( activityPage.getEleAnswerTxt(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        // For Activity 3 of 4
	        studentSignInPage.elementStatus( activityPage.getEleExerciseInstructionTxt(), "Subtitle of the page in the header part", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructionTxt(), "Page Instructions text", "displayed");
	        NXGReports.addStep("Page info :"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        studentSignInPage.elementStatus( activityPage.getEleExerciseInstructionTxt(), "Subtitle of the page in the header part", "displayed");
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			studentSignInPage.elementStatus( activityPage.getEleExcerciseTitleTxt(), "Page instructions is ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleExerciseTxt(), "Excercise Text", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleQuestionStn(), "Sample Questions are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        // For Activity 4 of 4
	        studentSignInPage.elementStatus( activityPage.getEleExerciseInstructionTxt(), "Subtitle of the page in the header part", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructionTxt(), "Page Instructions text", "displayed");
	        NXGReports.addStep("Page info :"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        studentSignInPage.elementStatus( activityPage.getEleExerciseInstructionTxt(), "Subtitle of the page in the header part", "displayed");
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			studentSignInPage.elementStatus( activityPage.getEleExcerciseTitleTxt(), "Page instructions is ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleExerciseTxt(), "Excercise Text", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleAudioInstructionTxt(), "Image title text ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleAudioIcn(), "Audio icon", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleAudioControlStn(), "Audio Contorl Bar", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleQuestionStn(), "Questions are ", "displayed");
			activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "Question title", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleQuestionStn(), "Questions are ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleShowAnsBtn(), "'Show Answer' button", "displayed");
			activityPage.getEleShowAnsBtn().click();
			studentSignInPage.elementStatus(activityPage.getEleQuesAndAnswerStn(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(5000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getEleOrganizingGettogethersActivitylnk());
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	 * @Description:Verify 'Sharing Experiences' 'Activity' link
	 * @Author:Navakanth
	 */
    @Parameters("browser")
    @Test(priority=22,enabled=false,description="Verify 'Sharing Experiences' 'Activity' link")
	public void testSharingExperiencesActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getEleSharingExperiencesAttendenceIcn(), teacherSessionsPage.getEleSharingExperiencesAttendenceTxt());
	        activityPage.allStudentAttendenceNegative(teacherSessionsPage.getEleSharingExperiencesAttendenceIcn(), teacherSessionsPage.getEleSharingExperiencesAttendenceTxt());
	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getEleSharingExperiencesConceptlnk(), "'Sharing Experiences' Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleSharingExperiencesConceptlnk());
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleSharingExperiencesActivitylnk());
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        studentSignInPage.elementStatus( activityPage.getEleHomeIcn(), "Home Icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleActivityTitleTxt(), "Activity Title", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleGlosaryIcn(), "Glosary icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleTeacherNameTxt(), "Teacher name text", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleProfileImg(), "Profile Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        // To verify Groups Count and number of groups present
	        activityPage.createMaximumGroups();
	        Thread.sleep(2000);
	        activityPage.createMinmumGroups();
	        int numberOfGroups=activityPage.getEleGroups().size();
	        if(numberOfGroups==GenericLib.getIntegerNumber(activityPage.getEleGroupCnt())){
	        NXGReports.addStep("Groups count and Number of groups displaying.", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(2000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getElePageProgressIcn(), "Page progress Icon", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        System.out.println("Page "+activityPage.getElePageNumTxt().getText());
	        }
	        else{
	        NXGReports.addStep("Groups count and Number of groups are not same", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	        }
	       // For Activity 1 of 3
	        activityPage.handleActivity2();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 2 of 3
	        activityPage.handleActivity();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 3 of 3
	        activityPage.handleActivity2();
		    // Question and Answer page
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Question and Options", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "Question title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleShowAnsBtn(), "'Show Answer' Button", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleShowAnsBtn().click();
	        NXGReports.addStep( "Clicked on 'Show Answer Button'", LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleQuesAndAnswerStn(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(5000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getEleSharingExperiencesActivitylnk());
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	 * @Description:Verify 'Where Have You Been?' 'Activity' link
	 * @Author:Navakanth
	 */
    @Parameters("browser")
    @Test(priority=23,enabled=false,description="Verify 'Where Have You Been?' 'Activity' link")
	public void testWhereHaveYouBeenActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getEleWhereHaveYouBeenAttendenceIcn(), teacherSessionsPage.getEleWhereHaveYouBeenAttendenceTxt());
	        activityPage.allStudentAttendenceNegative(teacherSessionsPage.getEleWhereHaveYouBeenAttendenceIcn(), teacherSessionsPage.getEleWhereHaveYouBeenAttendenceTxt());
	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getEleWhereHaveYouBeenConceptlnk(), "'Where Have You Been?' Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleWhereHaveYouBeenConceptlnk());
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleWhereHaveYouBeenActivitylnk());
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        studentSignInPage.elementStatus( activityPage.getEleHomeIcn(), "Home Icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleActivityTitleTxt(), "Activity Title", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleGlosaryIcn(), "Glosary icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleTeacherNameTxt(), "Teacher name text", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleProfileImg(), "Profile Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");
	        // For Activity 1 of 4
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructionTxt(), "Page Instructions text", "displayed");
	        NXGReports.addStep("Page info :"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			studentSignInPage.elementStatus( activityPage.getEleExcerciseTitleTxt(), "Page instructions is ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleActivityVideo(), "Excercise Video", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleExerciseTxt(), "Excercise Text", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleAudioInstructionTxt(), "Image title text ", "displayed");
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleQuestionStn(), "Questions are ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleShowAnsBtn(), "'Show Answer' button", "displayed");
			activityPage.getEleShowAnsBtn().click();
			studentSignInPage.elementStatus( activityPage.getEleAnswerTxt(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        // For Activity 2 of 4
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructionTxt(), "Page Instructions text", "displayed");
	        NXGReports.addStep("Page info :"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			studentSignInPage.elementStatus( activityPage.getEleExcerciseTitleTxt(), "Page instructions is ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleAudioLnk(), "Audio Image ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleExerciseTxt(), "Excercise Text", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleAudioInstructionTxt(), "Image title text ", "displayed");
			//studentSignInPage.elementStatus( activityPage.getEleAudioIcn(), "Audio icon", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleAudioControlStn(), "Audio Contorl Bar", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleQuestionStn(), "Questions are ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleShowAnsBtn(), "'Show Answer' button", "displayed");
			activityPage.getEleShowAnsBtn().click();
			studentSignInPage.elementStatus( activityPage.getEleAnswersTxt(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        // For Activity 3 of 4
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructionTxt(), "Page Instructions text", "displayed");
	        NXGReports.addStep("Page info :"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			studentSignInPage.elementStatus( activityPage.getEleExcerciseTitleTxt(), "Page instructions is ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleExerciseTxt(), "Excercise Text", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleHintsBtn(), "Hints text", "displayed");
			activityPage.getEleHintsBtn().click();
			Thread.sleep(1000);
			studentSignInPage.elementStatus( activityPage.getEleHintTxt(), "Hint", "displayed");
			activityPage.getEleHintsBtn().click();
			Thread.sleep(1000);
			studentSignInPage.elementStatus( activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleQuestionStn(), "Sample Questions are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        // For Activity 4 of 4
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructionTxt(), "Page Instructions text", "displayed");
	        NXGReports.addStep("Page info :"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			studentSignInPage.elementStatus( activityPage.getEleExcerciseTitleTxt(), "Page instructions is ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleBlankImg(), "Excercise Image", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleQuestionStn(), "Questions are ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleCrossWordShowAnsBtn(), "'Show Answer' button", "displayed");
			activityPage.getEleCrossWordShowAnsBtn().click();
			Thread.sleep(1000);
			studentSignInPage.elementStatus( activityPage.getEleFilledImg(), "Image with Answers is ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
			activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleQuestionStn(), "Questions are ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleShowAnsBtn(), "'Show Answer' button", "displayed");
			activityPage.getEleShowAnsBtn().click();
			studentSignInPage.elementStatus(activityPage.getEleQuesAndAnswerStn(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(5000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getEleWhereHaveYouBeenActivitylnk());
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	 * @Description:Verify 'Getting Directions' 'Activity' link
	 * @Author:Navakanth
	 */
    @Parameters("browser")
    @Test(priority=24,enabled=false,description="Verify 'Getting Directions' 'Activity' link")
	public void testGettingDirectionsActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getEleGettingDirectionsAttendenceIcn(), teacherSessionsPage.getEleGettingDirectionsAttendenceTxt());
	        activityPage.allStudentAttendenceNegative(teacherSessionsPage.getEleGettingDirectionsAttendenceIcn(), teacherSessionsPage.getEleGettingDirectionsAttendenceTxt());
	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getEleGettingDirectionsConceptlnk(), "'Getting Directions' Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleGettingDirectionsConceptlnk());
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleGettingDirectionsActivitylnk());
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        studentSignInPage.elementStatus( activityPage.getEleHomeIcn(), "Home Icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleActivityTitleTxt(), "Activity Title", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleGlosaryIcn(), "Glosary icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleTeacherNameTxt(), "Teacher name text", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleProfileImg(), "Profile Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        // To verify Groups Count and number of groups present
	        activityPage.createMaximumGroups();
	        Thread.sleep(2000);
	        activityPage.createMinmumGroups();
	        int numberOfGroups=activityPage.getEleGroups().size();
	        if(numberOfGroups==GenericLib.getIntegerNumber(activityPage.getEleGroupCnt())){
	        NXGReports.addStep("Groups count and Number of groups displaying.", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "enabled");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(2000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getElePageProgressIcn(), "Page progress Icon", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        System.out.println("Page "+activityPage.getElePageNumTxt().getText());
	        }
	        else{
	        NXGReports.addStep("Groups count and Number of groups are not same", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	        }
	       // For Activity 1 of 3
	        activityPage.handleActivity2();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 2 of 3
	        activityPage.handleActivity1();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 3 of 3
	        activityPage.handleActivity();
		    // Question and Answer page
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Question and Options", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "Question title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleShowAnsBtn(), "'Show Answer' Button", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleShowAnsBtn().click();
	        NXGReports.addStep( "Clicked on 'Show Answer Button'", LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleQuesAndAnswerStn(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(5000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getEleGettingDirectionsActivitylnk());
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	 * @Description:Verify 'Seeking Permission' 'Activity' link
	 * @Author:Navakanth
	 */
    @Parameters("browser")
    @Test(priority=25,enabled=false,description="Verify 'Seeking Permission' 'Activity' link")
	public void testSeekingPermissionActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getEleSeekingPermissionAttendenceIcn(), teacherSessionsPage.getEleSeekingPermissionAttendenceTxt());
	        activityPage.allStudentAttendenceNegative(teacherSessionsPage.getEleSeekingPermissionAttendenceIcn(), teacherSessionsPage.getEleSeekingPermissionAttendenceTxt());
	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getEleSeekingPermissionConceptlnk(), "'Seeking Permission' Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleSeekingPermissionConceptlnk());
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleSeekingPermissionActivitylnk());
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        studentSignInPage.elementStatus( activityPage.getEleHomeIcn(), "Home Icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleActivityTitleTxt(), "Activity Title", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleGlosaryIcn(), "Glosary icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleTeacherNameTxt(), "Teacher name text", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleProfileImg(), "Profile Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        // To verify Groups Count and number of groups present
	        activityPage.createMaximumGroups();
	        Thread.sleep(2000);
	        activityPage.createMinmumGroups();
	        int numberOfGroups=activityPage.getEleGroups().size();
	        if(numberOfGroups==GenericLib.getIntegerNumber(activityPage.getEleGroupCnt())){
	        NXGReports.addStep("Groups count and Number of groups displaying.", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "enabled");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(2000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getElePageProgressIcn(), "Page progress Icon", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        System.out.println("Page "+activityPage.getElePageNumTxt().getText());
	        }
	        else{
	        NXGReports.addStep("Groups count and Number of groups are not same", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	        }
	       // For Activity 1 of 3
	        activityPage.handleActivity1();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 2 of 3
	        activityPage.handleActivity();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 3 of 3
	        activityPage.handleActivity();
		    // Question and Answer page
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Question and Options", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "Question title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleShowAnsBtn(), "'Show Answer' Button", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleShowAnsBtn().click();
	        NXGReports.addStep( "Clicked on 'Show Answer Button'", LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleQuesAndAnswerStn(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(),"'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(5000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getEleSeekingPermissionActivitylnk());
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	 * @Description:Verify 'General Knowledge' 'Activity' link
	 * @Author:Navakanth
	 */
    @Parameters("browser")
    @Test(priority=26,enabled=false,description="Verify 'General Knowledge' 'Activity' link")
	public void testGeneralKnowledgeActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getEleGeneralKnowledgeAttendenceIcn(), teacherSessionsPage.getEleGeneralKnowledgeAttendenceTxt());
	        activityPage.allStudentAttendenceNegative(teacherSessionsPage.getEleGeneralKnowledgeAttendenceIcn(), teacherSessionsPage.getEleGeneralKnowledgeAttendenceTxt());
	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getEleGeneralEnquiryConceptlnk(), "'General Knowledge' Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleGeneralEnquiryConceptlnk());
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleGeneralKnowledgeActivitylnk());
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        studentSignInPage.elementStatus( activityPage.getEleHomeIcn(), "Home Icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleActivityTitleTxt(), "Activity Title", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleGlosaryIcn(), "Glosary icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleTeacherNameTxt(), "Teacher name text", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleProfileImg(), "Profile Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");
	        // For Activity 1 of 4
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructionTxt(), "Page Instructions text", "displayed");
	        NXGReports.addStep("Page info :"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			studentSignInPage.elementStatus( activityPage.getEleExcerciseTitleTxt(), "Page instructions is ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleVideo(), "Video", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleAudioInstructionTxt(), "Video title text ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleHintStn(), "Hints button", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleHintTxt(), "Hints text", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        // For Activity 2 of 4
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructionTxt(), "Page Instructions text", "displayed");
	        NXGReports.addStep("Page info :"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			studentSignInPage.elementStatus( activityPage.getEleExcerciseTitleTxt(), "Page instructions is ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleExerciseTxt(), "Excercise Text", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleAudioInstructionTxt(), "Image title text ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleHintsBtn(), "Hints text", "displayed");
			activityPage.getEleHintsBtn().click();
			Thread.sleep(1000);
			studentSignInPage.elementStatus( activityPage.getEleHintTxt(), "Hint ", "displayed");
			activityPage.getEleHintsBtn().click();
			Thread.sleep(1000);
			studentSignInPage.elementStatus( activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleQuestionStn(), "Questions are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        // For Activity 3 of 4
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructionTxt(), "Page Instructions text", "displayed");
	        NXGReports.addStep("Page info :"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        studentSignInPage.elementStatus(activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page instructions is ", "displayed");
			studentSignInPage.elementStatus(activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleAudioInstructionTxt(), "Image title text ", "displayed");
			studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text", "displayed");
			studentSignInPage.elementStatus(activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleQuestionStn(), "Sample Questions are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        // For Activity 4 of 4
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleInstructionTxt(), "Page Instructions text", "displayed");
	        NXGReports.addStep("Page info :"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			studentSignInPage.elementStatus( activityPage.getEleExcerciseTitleTxt(), "Page instructions is ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleExerciseTxt(), "Excercise Text", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleHintsBtn(), "Hints button", "displayed");
			activityPage.getEleHintsBtn().click();
			Thread.sleep(1000);
			studentSignInPage.elementStatus( activityPage.getEleHintTxt(), "Hint message", "displayed");
			activityPage.getEleHintsBtn().click();
			Thread.sleep(1000);
			studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleQuestionStn(), "Questions are ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleShowAnsBtn(), "'Show Answer' button", "displayed");
			activityPage.getEleShowAnsBtn().click();
			studentSignInPage.elementStatus(activityPage.getEleAnswersTxt(), "Answers are ", "displayed");
			activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        studentSignInPage.elementStatus( activityPage.getElePageSubtitleTxt(), "Subtitle of the page in the header part", "displayed");
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "Questions title", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleQuestionStn(), "Questions are ", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleShowAnsBtn(), "'Show Answer' button", "displayed");
			activityPage.getEleShowAnsBtn().click();
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(5000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getEleGeneralKnowledgeActivitylnk());
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	 * @Description:Verify 'Likes and Dislikes' 'Activity' link
	 * @Author:Navakanth
	 */
    @Parameters("browser")
    @Test(priority=27,enabled=false,description="Verify 'Likes and Dislikes' 'Activity' link")
	public void testLikesAndDislikesActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getEleLikesAndDislikesAttendenceIcn(), teacherSessionsPage.getEleLikesAndDislikesAttendenceTxt());
	        activityPage.allStudentAttendenceNegative(teacherSessionsPage.getEleLikesAndDislikesAttendenceIcn(), teacherSessionsPage.getEleLikesAndDislikesAttendenceTxt());
	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getEleLikesAndDislikesConceptlnk(), "'Likes and Dislikes' Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleLikesAndDislikesConceptlnk());
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleLikesAndDislikesActivitylnk());
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        studentSignInPage.elementStatus( activityPage.getEleHomeIcn(), "Home Icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleActivityTitleTxt(), "Activity Title", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleGlosaryIcn(), "Glosary icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleTeacherNameTxt(), "Teacher name text", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleProfileImg(), "Profile Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        // To verify Groups Count and number of groups present
	        activityPage.createMaximumGroups();
	        Thread.sleep(2000);
	        activityPage.createMinmumGroups();
	        int numberOfGroups=activityPage.getEleGroups().size();
	        if(numberOfGroups==GenericLib.getIntegerNumber(activityPage.getEleGroupCnt())){
	        NXGReports.addStep("Groups count and Number of groups displaying.", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");

	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "enabled");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(2000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getElePageProgressIcn(), "Page progress Icon", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        System.out.println("Page "+activityPage.getElePageNumTxt().getText());
	        }
	        else{
	        NXGReports.addStep("Groups count and Number of groups are not same", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	        }
	       // For Activity 1 of 3
	        activityPage.handleActivity1();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 2 of 3
	        activityPage.handleActivity();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 3 of 3
	        activityPage.handleActivity();
		    // Question and Answer page
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Question and Options", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "Question title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleShowAnsBtn(), "'Show Answer' Button", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleShowAnsBtn().click();
	        NXGReports.addStep( "Clicked on 'Show Answer Button'", LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleQuesAndAnswerStn(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(5000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getEleLikesAndDislikesActivitylnk());
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	 * @Description:Verify 'Short-Term Plans' 'Activity' link
	 * @Author:Navakanth
	 */
    @Parameters("browser")
    @Test(priority=28,enabled=false,description="Verify 'Short-Term Plans' 'Activity' link")
	public void testShortTermPlansActivity(String browser) throws Throwable
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		teacherHomePage=new TeacherHomePage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		activityPage=new ActivityPage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(10000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        activityPage.allStudentAttendence(teacherSessionsPage.getEleShortTermPlansAttendenceIcn(), teacherSessionsPage.getEleShortTermPlansAttendenceTxt());
	        activityPage.allStudentAttendenceNegative(teacherSessionsPage.getEleShortTermPlansAttendenceIcn(), teacherSessionsPage.getEleShortTermPlansAttendenceTxt());
	        //To click on Concept link
	        studentSignInPage.elementStatus(teacherSessionsPage.getEleShortTermPlansConceptlnk(), "'Short-Term Plans' Concept Link", "displayed");
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleShortTermPlansConceptlnk());
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(4000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(1000);
	        //TO click on Activity link
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleShortTermPlansActivitylnk());
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        studentSignInPage.elementStatus( activityPage.getEleHomeIcn(), "Home Icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleActivityTitleTxt(), "Activity Title", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleGlosaryIcn(), "Glosary icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleTeacherNameTxt(), "Teacher name text", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleProfileImg(), "Profile Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
	        // To verify Groups Count and number of groups present
	        activityPage.createMaximumGroups();
	        Thread.sleep(2000);
	        activityPage.createMinmumGroups();
	        int numberOfGroups=activityPage.getEleGroups().size();
	        if(numberOfGroups==GenericLib.getIntegerNumber(activityPage.getEleGroupCnt())){
	        NXGReports.addStep("Groups count and Number of groups displaying.", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getEleNextIcn(), "Next icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "displayed");
	        studentSignInPage.elementStatus( activityPage.getElePrevIcn(), "Previous icon", "enabled");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(2000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        studentSignInPage.elementStatus( activityPage.getElePageProgressIcn(), "Page progress Icon", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        System.out.println("Page "+activityPage.getElePageNumTxt().getText());
	        }
	        else{
	        NXGReports.addStep("Groups count and Number of groups are not same", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	        }
	       // For Activity 1 of 3
	        activityPage.handleActivity();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 2 of 3
	        activityPage.handleActivity();
	        NXGReports.addStep( "Activity Info"+activityPage.eleActivityTxt().getText(), LogAs.PASSED, null);
			NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			// For Activity 3 of 3
	        activityPage.handleActivity2();
		    // Question and Answer page
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Question and Options", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionTitleTxt(), "Question title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleShowAnsBtn(), "'Show Answer' Button", "displayed");
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        activityPage.getEleShowAnsBtn().click();
	        NXGReports.addStep( "Clicked on 'Show Answer Button'", LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getEleQuesAndAnswerStn(), "Answers are ", "displayed");
	        activityPage.getEleNextIcn().click();
	        Thread.sleep(1000);
	        NXGReports.addStep( "Clicked on Next icon", LogAs.PASSED, null);
	        NXGReports.addStep( "page number info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.getElePageSubtitleTxt(),"'Summary' Title", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSummaryTxt(), "Summary ", "displayed");
	        Thread.sleep(5000);
	        activityPage.getEleHomeIcn().click();
	        Thread.sleep(5000);
	        activityPage.verifyActivityLinkSecondTime(teacherSessionsPage.getEleShortTermPlansActivitylnk());
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
}
