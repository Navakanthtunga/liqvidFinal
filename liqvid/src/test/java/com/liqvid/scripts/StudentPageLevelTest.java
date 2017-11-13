/***********************************************************************
* @author 			:		Raghukiran MR
* @description		: 		Test scripts of StudentPageLevelTest
* @module			:		Student Module
* @testmethod		:	   	sampleDatabaseTest()
* @testmethod       :       studentLoginPage()
* @testmethod		:		studentHomepage()
* @testmethod		:		studentProfilePage()
* @testmethod		:		studentCourses()
* @testmethod		:		studentResources()
* @testmethod		:		preAssessmentInstruction()
* @testmethod		:		preAssessmentTestPage()
* @testmethod		:		verifyPreAssessmentPagePopup()
* @testmethod       :       postAssessmentInstruction()
* @testmethod       :       PostAssessmentTestPage()
* @testmethod       :       verifyPostAssessmentPagePopup()
* @testmethod       :       Mid1AssessmentInstruction()
* @testmethod       :       Mid1AssessmentTestPage()
* @testmethod       :       verifyMid1AssessmentPagePopup()
* @testmethod       :       Mid2AssessmentInstruction()
* @testmethod       :       Mid2AssessmentTestPage()
* @testmethod       :       verifyMid2AssessmentPagePopup()
*/
package com.liqvid.scripts;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.core.exceptions;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.liqvid.library.ParallelBaseLib;
import com.liqvid.page.StudentCoursePage;
import com.liqvid.page.StudentHomePage;
import com.liqvid.page.StudentProfilePage;
import com.liqvid.page.StudentResourcesPage;
import com.liqvid.page.StudentSignInPage;
import com.liqvid.library.BaseLib;
import com.liqvid.library.GenericLib;

public class StudentPageLevelTest extends BaseLib {
	String sTestData=null;
	String[] sData=null;
	
	StudentSignInPage studentSignInPo=null;
	StudentHomePage studenthomepo=null;
	StudentProfilePage studentprofilepo=null;
	StudentCoursePage studentcoursepo=null;
	StudentResourcesPage Studentresourcespo=null;
	/* 
	 * @Description:To clear the databases of Assessment
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=1,enabled=false,description="To clear the databases of Assessment")
	public void sampleDatabaseTest(String browser){
		studenthomepo=new StudentHomePage(driver);
		try{
			studenthomepo.databaseTest();
		}catch(Exception e)
		{
			throw e;
		}
	}
	/* 
	 * @Description: To Verify the Display Of Elements On Stud0ent login Page
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=2,enabled=true, description="Display Of Elements On Student login Page")
	public void verifyStudentLoginPage(String browser) throws InterruptedException{
		studentSignInPo=new StudentSignInPage(driver);
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			Thread.sleep(2000);
			studentSignInPo.elementStatus(studentSignInPo.getEleLogo(),"The English Edge logo ", "displayed");
			studentSignInPo.elementStatus(studentSignInPo.getEleSignInText(),"The Sign in text ", "displayed");
			studentSignInPo.elementStatus(studentSignInPo.getEleSignInInstrText(),"The Sign in instruction text is", "displayed");
			studentSignInPo.elementStatus(studentSignInPo.getEleUserNameText(),"The Username text is", "displayed");
			studentSignInPo.elementStatus(studentSignInPo.getEleUserNameTextField(),"The Username textfield is", "displayed");
			studentSignInPo.elementStatus(studentSignInPo.getElePwdText(),"The password text is", "displayed");
			studentSignInPo.elementStatus(studentSignInPo.getElePasswordTextFiled(),"The password textfield is", "displayed");
			studentSignInPo.elementStatus(studentSignInPo.getEleSignInBtn(),"The Sign in button is", "displayed");
			studentSignInPo.elementStatus(studentSignInPo.getEleForgotPwdLink(),"The forgot password link is", "displayed");
			studentSignInPo.elementStatus(studentSignInPo.getEleRegisterInstrText(),"The register instruction text is", "displayed");
			studentSignInPo.elementStatus(studentSignInPo.getEleRegisterBtn(),"The register button is", "displayed");
			studentSignInPo.elementStatus(studentSignInPo.getEleCopyRights(),"the copyright version text is", "displayed");
			studentSignInPo.elementStatus(studentSignInPo.getEleCodeVersionDateText(),"the bulid version text is", "displayed");
		}catch(Exception e)
		{
			throw e;
		}
		}
	/* 
	 * @Description: To Verify the Display of elements on Student Home Page
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=3,enabled=true, description="Display of elements on Student Home Page")
	public void verifyStudentHomepage(String browser) throws Exception{
		studentSignInPo=new StudentSignInPage(driver);
		studenthomepo=new StudentHomePage(driver);
		studentprofilepo=new StudentProfilePage(driver);
		sTestData="StudentLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPo.Login(sData[1],sData[2]);
			Thread.sleep(4000);
			studentSignInPo.elementStatus(studenthomepo.getEleLogo(),"The English Edge logo is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleBulidVersion(),"The English Edge bulid version is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleTotalSessionCount(),"The total session count is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleTotalSessionText(),"The total session text is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleCompletedSessionCount(),"The completed session count is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleCompletedText(),"The completed session text is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleLastLogin(),"The LastLogin Text", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleLastCourse(),"The LastCourse Taken Text", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleLastSession(),"The LastSession Taken Text", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleRemainingSessionCount(),"The remaining session count is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleRemainingText(),"The remaining session text is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleHomeIcon(),"The home icon is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleHomeTab(),"The home tab is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleCoursesIcon(),"The courses icon is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleCoursesTab(),"The courses tab is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleResoursesIcon(),"The resources icon is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleResourcesTab(),"The resources tab is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleWelcomeText(),"The Welcome text is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleStudentProfileimage(),"The Student profile image option is", "displayed");
			for(WebElement eleProductlist:studenthomepo.getEleStudentDetails())
			{
				studentSignInPo.elementStatus(eleProductlist,"The Student details is ", "displayed");
			}
			for(WebElement eleProductlist:studenthomepo.getEleLastDetails())
			{
				studentSignInPo.elementStatus(eleProductlist,"The Last Login, Course and Session details is ", "displayed");
			}
			studentSignInPo.elementStatus(studenthomepo.getEleProfileDropdown(),"The Profile Dropdown is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleProfileImgInDropdown(),"The Profile Dropdown is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleProfileTextDropdown(),"The Profile text Dropdown is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleCourseCount(),"The Courses count is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleCoursesText(),"The Courses text is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleSessionCount(),"The session count is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleSessionText(),"The session text is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleTimeSpent(),"The timespent text in y axis", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleCourse(),"The course text in x axis", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleTimeSpentPerCourse(),"The timespentpercourse text is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleTimeSpentPerCourse(),"The timespentpercourse text is", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleGraph(),"The Graph is", "displayed");
			
		}catch(Exception e)
		{
			throw e;
		}
		
	}
	/* 
	 * @Description: To Verify the Display of elements on Student Profile Page
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=4,enabled=true, description="To Verify the Display of elements on Student Profile Page")
	public void verifyStudentProfilePage(String browser) throws Exception{
		studentSignInPo=new StudentSignInPage(driver);
		studenthomepo=new StudentHomePage(driver);
		studentprofilepo=new StudentProfilePage(driver);
		sTestData="StudentLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPo.Login(sData[1],sData[2]);
			Thread.sleep(4000);
			studenthomepo.getEleProfileTextDropdown().click();
			studenthomepo.getEleProfileOption().click();
			studentSignInPo.elementStatus(studentprofilepo.getEleProfileText(),"The Profile text is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleFirstNameText(),"The firstname text is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleFirstNameTextBox(),"The firstname textbox is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleLastNameText(),"The lastname text is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleLastNameTextBox(),"The lastname textbox is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleEmailIdText(),"The Email id text is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleEmailIdTextBox(),"The Emailid textbox is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getElePhoneText(),"The phone text is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getElePhoneTextBox(),"The phone textbox is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleDateOfBirthText(),"The dateofBirth text is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleDateOfBirthTextBox(),"The dateofBirth textbox is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleDateOfBirthTextBox(),"The dateofBirth textbox is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleCalendarIcon(),"The Calander icon is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleGenderText(),"The Gender Text is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleGenderDropDown(),"The Gender dropdown is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getElePlusIcon(),"The plus icon is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleChangePwd(),"The change password link is", "displayed");
			Thread.sleep(3000);
			studentprofilepo.getEleChangePwd().click();
			studentSignInPo.elementStatus(studentprofilepo.getEleMinusIcon(),"The minus icon is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleOldPasswordText(),"The old password text is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleOldPasswordTextBox(),"The old password textbox is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleNewPasswordText(),"The new password text is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleNewPasswordTextBox(),"The new password textbox is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleConfirmPasswordText(),"The confirm password text is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleConfirmNewPasswordTextBox(),"Theconfirm password textbox is", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getEleUpdateButton(),"Update button is", "displayed");
		}catch(Exception e)
		{
			throw e;
		}
	}
	/* 
	 * @Description: To Verify Display of elements on Student Courses page
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=5,enabled=false, description="To Verify Display of elements on Student Courses page")
	public void verifyStudentCoursesPage(String browser) throws Exception{
		studentSignInPo=new StudentSignInPage(driver);
		studenthomepo=new StudentHomePage(driver);
		studentprofilepo=new StudentProfilePage(driver);
		studentcoursepo=new StudentCoursePage(driver);
		sTestData="StudentLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPo.Login(sData[1],sData[2]);
			Thread.sleep(4000);
			studentcoursepo.getEleCourseTab().click();
			Thread.sleep(2000);
			studentSignInPo.elementStatus(studentcoursepo.getEleCourseText(),"Course text is", "displayed");
			studentSignInPo.elementStatus(studentcoursepo.getEleInstructionText(),"Course instruction text is", "displayed");
			studentSignInPo.elementStatus(studentcoursepo.getEleStepText(),"step text is", "displayed");
			studentSignInPo.elementStatus(studentcoursepo.getEleStep1Circle(),"step circle symbol is", "displayed");
			studentSignInPo.elementStatus(studentcoursepo.getEleBatchText(),"Batch text is", "displayed");
			studentSignInPo.elementStatus(studentcoursepo.getEleStep1Circle(),"step circle symbol is", "displayed");
			studentSignInPo.elementStatus(studentcoursepo.getEleSelectBatchText(),"Select batch text is", "displayed");
			studentSignInPo.elementStatus(studentcoursepo.getEleSelectcourseText(),"Select course text is", "displayed");
			studentSignInPo.elementStatus(studentcoursepo.getEleClickcourseText(),"Click course text is", "displayed");
			studentSignInPo.elementStatus(studentcoursepo.getEleCourseText(),"course text is", "displayed");
			Select select=new Select(studentcoursepo.getEleClass());
			select.selectByIndex(0);
			Thread.sleep(4000);
			Select select1=new Select(studentcoursepo.getEleCourseSelected());
			select1.selectByIndex(0);
			Thread.sleep(4000);
			studentcoursepo.getEleStartCourseButton().click();
			Thread.sleep(5000);
			studentcoursepo.switchToLatestPopupWindow();
			studentSignInPo.elementStatus(studentcoursepo.getElePreAssessmentLink(),"The pre assessment link is","displayed");
			studentcoursepo.studentCourseSession();
		}catch(Exception e)
		{
			throw e;
		}
	}
	/* 
	 * @Description: To Verify Display of elements on Student Resources page
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=6,enabled=true, description="To Verify Display of elements on Student Resources page")
	public void verifyStudentResources(String browser) throws Exception{
		studentSignInPo=new StudentSignInPage(driver);
		studenthomepo=new StudentHomePage(driver);
		studentprofilepo=new StudentProfilePage(driver);
		studentcoursepo=new StudentCoursePage(driver);
		Studentresourcespo=new StudentResourcesPage(driver);
		sTestData="StudentLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try{
			
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPo.Login(sData[1],sData[2]);
			Thread.sleep(4000);	
			studentSignInPo.elementStatus(studenthomepo.getEleResourcesTab(), "Resources tab is ", "displayed");
			studenthomepo.getEleResourcesTab().click();
			Thread.sleep(2000);	
			studentSignInPo.elementStatus(Studentresourcespo.getEleResourcesText(), "Resources text is ", "displayed");
			if(Studentresourcespo.getEleResourcesImage().getAttribute("src").contains(""))
			{
				studentSignInPo.elementStatus(Studentresourcespo.getEleResourcesImage(),"The resources image is ", "displayed");
			}
				else{
				
					studentSignInPo.elementStatus(Studentresourcespo.getEleResourcesImage(),"The Student profile image is ", "not displayed");
				}
			studentSignInPo.elementStatus(Studentresourcespo.getEleStudentManualText(), "Student Manual text is ", "displayed");
			Studentresourcespo.getEleStudentManualText().click();
			Thread.sleep(5000);
			Studentresourcespo.testVerifyPDFInURL();
		}catch(Exception e)
		{
			throw e;
		}
	}
	/* 
	 * @Description: To Verify Display of Elements in  Pre Assessment Instructions Page,To Verify Display of Elements in  Pre Assessment Instructions Page,Display of elements in the Popup that is displayed when user clicks on "Next" button without selecting the Options
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=7,enabled=false, description="To Verify Display of Elements in  Pre Assessment Instructions Page,To Verify Display of Elements in  Pre Assessment Instructions Page,Display of elements in the Popup that is displayed when user clicks on 'Next button without selecting the Options'")
	public void preAssessmentInstruction(String browser) throws Exception{
	studentSignInPo=new StudentSignInPage(driver);
	studenthomepo=new StudentHomePage(driver);
	studentprofilepo=new StudentProfilePage(driver);
	studentcoursepo=new StudentCoursePage(driver);
	Studentresourcespo=new StudentResourcesPage(driver);
	sTestData="StudentLogin_01";
	sData=GenericLib.toReadExcelData(sTestData);
	try{
		loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
		studentSignInPo.Login(sData[1],sData[2]);
		Thread.sleep(4000);	
		studentcoursepo.getEleCourseTab().click();
		Thread.sleep(2000);	
		studentSignInPo.elementStatus(studentcoursepo.getEleClass(), "List of Batches is ", "displayed");
		Select select=new Select(studentcoursepo.getEleClass());
		select.selectByIndex(0);
		Thread.sleep(2000);
		studentSignInPo.elementStatus(studentcoursepo.getEleCourseSelected(), "List of Courses is ", "displayed");
		Select select1=new Select(studentcoursepo.getEleCourseSelected());
		Thread.sleep(2000);
		select1.selectByIndex(0);
		studentSignInPo.elementStatus(studentcoursepo.getEleStartCourseButton(), "Start Course is ", "displayed");
		Thread.sleep(2000);
		studentcoursepo.getEleStartCourseButton().click();
		Thread.sleep(2000);
		 studentcoursepo.switchToLatestPopupWindow();
		 Thread.sleep(2000);
		studentcoursepo.getElePreAssessmentLink().click();
		Thread.sleep(2000);
		studentSignInPo.elementStatus(studentcoursepo.getEleEnglishEdgeText(),"The English Edge Assessments","displayed");
		for (WebElement eleStudentInstructionText:studentcoursepo.getEleStudentInstructionText()) {

			Assert.assertTrue(eleStudentInstructionText.isDisplayed(),
					eleStudentInstructionText.getText() + "is displayed in the student instruction text");
			NXGReports.addStep(eleStudentInstructionText.getText() + "is displayed in the student instruction text",
					LogAs.PASSED, null);
		}
		studentSignInPo.elementStatus(studentcoursepo.getEleStartTextButton(),"The Start text button","displayed");
		studentcoursepo.getEleStartTextButton().click();
		Thread.sleep(2000);
		studentSignInPo.elementStatus(studentcoursepo.getEleClass1PreAssessmentText(),"The Pre Assessment text is ", "displayed");
		studentSignInPo.elementStatus(studentcoursepo.getEleAllTheBestText(),"The All the best text is ", "displayed");
		studentSignInPo.elementStatus(studentcoursepo. getEleStartTimeText(),"start time text", "displayed");
		Thread.sleep(2000);
		studentSignInPo.elementStatus(studentcoursepo.getEleEndTimeText(),"end time text is", "displayed");
		studentSignInPo.elementStatus(studentcoursepo.getElePreviousButton(),"previous button is", "enabled");
		studentSignInPo.elementStatus(studentcoursepo.getEleRecentPageNumber(),"page number is", "displayed");
		studentSignInPo.elementStatus(studentcoursepo.getEleNextButton(),"page number is", "displayed");
		Thread.sleep(2000);
		List<WebElement> elemnet = driver.findElements(By.xpath("//div[@class='h3 pull-right m-r-sm']//div[@id='countdown']"));
		for(WebElement eleTimer:elemnet)
		{
			
			studentSignInPo.elementStatus(eleTimer,"The timer value is ", "displayed");	
		}
		Thread.sleep(6000);
		studentcoursepo.assessementPopUp();
	}catch(Exception e)
	{
		throw e;
	}
	}
	/* 
	 * @Description: To Verify Display of Elements in  Post Assessment Instructions Page,To Verify Display of Elements in the Post Assessment from page 1 to 37,Display of elements in the Popup that is displayed when user clicks on Next' button without selecting the Options
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=10,enabled=false, description="To Verify Display of Elements in  Post Assessment Instructions Page,To Verify Display of Elements in the Post Assessment from page 1 to 37,Display of elements in the Popup that is displayed when user clicks on Next' button without selecting the Options")
	public void postAssessmentInstruction(String browser) throws Exception{
	studentSignInPo=new StudentSignInPage(driver);
	studenthomepo=new StudentHomePage(driver);
	studentprofilepo=new StudentProfilePage(driver);
	studentcoursepo=new StudentCoursePage(driver);
	Studentresourcespo=new StudentResourcesPage(driver);
	sTestData="StudentLogin_01";
	sData=GenericLib.toReadExcelData(sTestData);
	try{
		loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
		studentSignInPo.Login(sData[1],sData[2]);
		Thread.sleep(4000);	
		studentcoursepo.getEleCourseTab().click();
		Thread.sleep(2000);	
		studentSignInPo.elementStatus(studentcoursepo.getEleClass(), "List of Batches is ", "displayed");
		Select select=new Select(studentcoursepo.getEleClass());
		select.selectByIndex(0);
		Thread.sleep(2000);
		studentSignInPo.elementStatus(studentcoursepo.getEleCourseSelected(), "List of Courses is ", "displayed");
		Select select1=new Select(studentcoursepo.getEleCourseSelected());
		Thread.sleep(2000);
		select1.selectByIndex(0);
		studentSignInPo.elementStatus(studentcoursepo.getEleStartCourseButton(), "Start Course is ", "displayed");
		Thread.sleep(2000);
		studentcoursepo.getEleStartCourseButton().click();
		Thread.sleep(2000);
		studentcoursepo.switchToLatestPopupWindow();
		 Thread.sleep(2000);
		 studentcoursepo.getEleNextBtn().click();
		 Thread.sleep(2000);
		 studentSignInPo.elementStatus(studentcoursepo.getElePostAssessmentLink(),"The Post Assessment link","displayed");
		studentcoursepo.getElePostAssessmentLink().click();
		Thread.sleep(2000);
		studentSignInPo.elementStatus(studentcoursepo.getEleEnglishEdgeText(),"The English Edge Assessments","displayed");
		for (WebElement eleStudentInstructionText:studentcoursepo.getEleStudentInstructionText()) {

			Assert.assertTrue(eleStudentInstructionText.isDisplayed(),
					eleStudentInstructionText.getText() + "is displayed in the student instruction text");
			NXGReports.addStep(
					eleStudentInstructionText.getText() + "is displayed in the student instruction text",
					LogAs.PASSED, null);
		}
		studentSignInPo.elementStatus(studentcoursepo.getEleStartTextButton(),"The Start text button","displayed");
		studentcoursepo.getEleStartTextButton().click();
		Thread.sleep(2000);
		studentSignInPo.elementStatus(studentcoursepo.getEleClass2PostAssessmentText(),"The Post Assessment text is ", "displayed");
		studentSignInPo.elementStatus(studentcoursepo.getEleAllTheBestText(),"The All the best text is ", "displayed");
		studentSignInPo.elementStatus(studentcoursepo. getEleStartTimeText(),"start time text", "displayed");
		Thread.sleep(2000);
		studentSignInPo.elementStatus(studentcoursepo.getEleEndTimeText(),"end time text is", "displayed");
		studentSignInPo.elementStatus(studentcoursepo.getElePreviousButton(),"previous button is", "enabled");
		studentSignInPo.elementStatus(studentcoursepo.getEleRecentPageNumber(),"page number is", "displayed");
		studentSignInPo.elementStatus(studentcoursepo.getEleNextButton(),"page number is", "displayed");
		Thread.sleep(2000);
		List<WebElement> elemnet = driver.findElements(By.xpath("//div[@class='h3 pull-right m-r-sm']//div[@id='countdown']"));
		for(WebElement eleTimer:elemnet)
		{
			
			studentSignInPo.elementStatus(eleTimer,"The timer value is ", "displayed");	
		}
		Thread.sleep(6000);
		studentcoursepo.assessementPopUp();
	}catch(Exception e)
	{
		throw e;
	}
	}
}
