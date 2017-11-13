
package com.liqvid.scripts;

import org.openqa.selenium.By;
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
import com.liqvid.page.AdminHomePage;
import com.liqvid.page.AttendencePage;
import com.liqvid.page.StudentSignInPage;
import com.liqvid.page.TeacherCoursePage;
import com.liqvid.page.TeacherHomePage;
import com.liqvid.page.TeacherProfilePage;
import com.liqvid.page.TeacherResourcesPage;
import com.liqvid.page.TeacherSessionsPage;
import com.liqvid.page.TeacherSignPage;

public class TeacherPageLevelTest extends BaseLib{
	TeacherSignPage teacherSigninPage=null;
	TeacherHomePage teacherHomePage=null;
	TeacherProfilePage teacherProfilePage=null;
	TeacherCoursePage teacherCoursePage=null;
	StudentSignInPage studentSignInPage=null;
	TeacherSessionsPage teacherSessionsPage=null;
	AttendencePage attendencePage=null;
	TeacherResourcesPage teacherResourcesPage=null;
	ActivityPage activityPage=null;
	AdminHomePage adminHomePage=null;
	String sTestData=null;
	String[] sData=null;
	
	int defaultTotalCnt;
	int defaultCompletedCnt;
	int defaultRemainingCnt;
	String defaultLastCourseTaken=null;
	String defaultLastSessionTaken=null;
	
	int actualTotalCnt;
	int actualCompletedCnt;
	int actualRemainingCnt;
	String actualLastCourseTaken=null;
	String actualLastSessionTaken=null;
	
	int expectedTotalCnt;
	int expectedCompletedCnt;
	int expectedRemainingCnt;
	String expectedLastCourseTaken=null;
	String expectedSessionTaken=null;
	
	
	/* 
	* @Description:Display of elements in teacher Home Page
	* @Author:Navakanth
	*/
	@Parameters("browser")
	@Test(priority=1,enabled=false, description="Display of elements in teacher Home Page")
	public void testTeacherHomepageElement(String browser) throws Exception
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherHomePage=new TeacherHomePage (driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		studentSignInPage=new StudentSignInPage(driver);
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(4000);
			studentSignInPage.elementStatus(teacherHomePage.getEleLogo(),"The English Edge logo", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleBulidVersion(),"The English Edge bulid version", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleTotalSessionCount(),"The total session count", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleTotalSessionText(),"The total session text", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleCompletedSessionCount(),"The completed session count", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleCompletedText(),"The completed session text", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleRemainingSessionCount(),"The remaining session count", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleRemainingText(),"The remaining session text", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleHomeIcon(),"The home icon", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleHomeTab(),"The home tab", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleCoursesIcon(),"The courses icon", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleCoursesTab(),"The courses tab", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleResoursesIcon(),"The resources icon", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleResourcesTab(),"The resources tab", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleWelcomeText(),"The Welcome text", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleTeacherProfileimage(),"The Student profile image option", "displayed");
			for(WebElement eleProductlist:teacherHomePage.getEleTeacherDetails())
			{
				studentSignInPage.elementStatus(eleProductlist,"The Student details", "displayed");
			}
			studentSignInPage.elementStatus(teacherHomePage.getEleLastLogin(),"Last Login ", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleLastCourse(),"Last Course ", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleLastSession(),"Last Session ", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleProfileDropdown(),"The Profile Dropdown", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleProfileImgInDropdown(),"The Profile Dropdown", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleProfileTextDropdown(),"The Profile text Dropdown", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleCoursesImg(),"Courses Image", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleCourseCount(),"The Courses count", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleCoursesText(),"The Courses text", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleBatchesImg(),"Batches Image", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleSessionCount(),"The Batches count", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleSessionText(),"The Batches text", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleStudentsImg(),"Students Image", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleStudentsCnt(),"Students count", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleStudentsTxt(),"Students text", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleTimeSpent(),"The timespent text in y axis", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleCourse(),"The course text in x axis", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleTimeSpentPerCourse(),"The timespentpercourse text", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleTimeSpentPerCourse(),"The timespentpercourse text", "displayed");
			studentSignInPage.elementStatus(teacherHomePage.getEleGraph(),"The Graph is", "displayed");
			
		}catch(AssertionError e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	* @Description:Display of elements on teacher Profile Page
	* @Author:Navakanth
	*/
	@Parameters("browser")
	@Test(priority=2,enabled=false, description="Display of elements on teacher Profile Page")
	public void testTeacherProfilepageElement(String browser) throws Exception
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherProfilePage=new TeacherProfilePage(driver);
		teacherHomePage=new TeacherHomePage (driver);
		studentSignInPage=new StudentSignInPage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(7000);
			teacherHomePage.getEleProfileTextDropdown().click();
			teacherHomePage.getEleProfileOption().click();
			studentSignInPage.elementStatus(teacherProfilePage.getEleProfileText(),"The Profile text is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleFirstNameText(),"The firstname text is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleFirstNameTextBox(),"The firstname textbox is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleLastNameText(),"The lastname text is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleLastNameTextBox(),"The lastname textbox is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleEmailIdText(),"The Email id text is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleEmailIdTextBox(),"The Emailid textbox is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getElePhoneText(),"The phone text is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getElePhoneTextBox(),"The phone textbox is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleDateOfBirthText(),"The dateofBirth text is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleDateOfBirthTextBox(),"The dateofBirth textbox is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleDateOfBirthTextBox(),"The dateofBirth textbox is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleCalendarIcon(),"The Calander icon is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleGenderText(),"The Gender Text is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleGenderDropDown(),"The Gender dropdown is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getElePlusIcon(),"The plus icon is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleChangePwd(),"The change password link is", "displayed");
			Thread.sleep(3000);
			teacherProfilePage.getEleChangePwd().click();
			studentSignInPage.elementStatus(teacherProfilePage.getEleMinusIcon(),"The minus icon is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleOldPasswordText(),"The old password text is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleOldPasswordTextBox(),"The old password textbox is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleNewPasswordText(),"The new password text is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleNewPasswordTextBox(),"The new password textbox is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleConfirmPasswordText(),"The confirm password text is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleConfirmNewPasswordTextBox(),"Theconfirm password textbox is", "displayed");
			studentSignInPage.elementStatus(teacherProfilePage.getEleUpdateButton(),"Update button is", "displayed");
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	* @Description:Display of elements on teacher Courses page
	* @Author:Navakanth
	*/
	@Parameters("browser")
	@Test(priority=3,enabled=false,description="Display of elements on teacher Courses page")

	public void testTeacherCoursespageElement(String browser) throws Exception
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherCoursePage=new TeacherCoursePage(driver);
		studentSignInPage=new StudentSignInPage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(4000);
			teacherCoursePage.getEleCourseTab().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(teacherCoursePage.getEleCourseText(),"Course text is", "displayed");
			studentSignInPage.elementStatus(teacherCoursePage.getEleInstructionText(),"Course instruction text is", "displayed");
			studentSignInPage.elementStatus(teacherCoursePage.getEleStepText(),"step text is", "displayed");
			studentSignInPage.elementStatus(teacherCoursePage.getEleStep1Circle(),"step circle symbol is", "displayed");
			studentSignInPage.elementStatus(teacherCoursePage.getEleBatchText(),"Batch text is", "displayed");
			studentSignInPage.elementStatus(teacherCoursePage.getEleStep1Circle(),"step circle symbol is", "displayed");
			studentSignInPage.elementStatus(teacherCoursePage.getEleSelectBatchText(),"Select batch text is", "displayed");
			studentSignInPage.elementStatus(teacherCoursePage.getEleSelectcourseText(),"Select course text is", "displayed");
			studentSignInPage.elementStatus(teacherCoursePage.getEleClickcourseText(),"Click course text is", "displayed");
			studentSignInPage.elementStatus(teacherCoursePage.getEleCourseText(),"course text is", "displayed");
		
		}catch(AssertionError e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	* @Description:Display of element in resources page
	* @Author:Navakanth
	*/
	@Parameters("browser")
	@Test(priority=4,enabled=false,description="Display of element in resources page")
	public void testResourcespageElement(String browser) throws Exception
	{
		teacherSigninPage=new TeacherSignPage(driver);
		teacherResourcesPage=new TeacherResourcesPage(driver);
		teacherHomePage=new TeacherHomePage (driver);
		studentSignInPage=new StudentSignInPage(driver);
		sTestData="TeacherLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(4000);
			teacherHomePage.getEleResourcesTab().click();
			NXGReports.addStep(teacherResourcesPage.getEleResourcesText().getText()," ", LogAs.PASSED, null);
			studentSignInPage.elementStatus(teacherResourcesPage.getEleResourcesImage(),"pdf file is","displayed");
			Thread.sleep(2000);
			teacherResourcesPage.getEleTeacherManualTxt().click();
			
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		
	}
	/* 
	* @Description:Verification of Elements in 'Greetings and Introduction' 
	* @Author:Navakanth
	*/
	@Parameters("browser")
    @Test(priority=5,enabled=false,description="Verification of Elements in 'Greetings and Introduction' ")
	public void testGreetingsAndIntroduction(String browser) throws Throwable
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
		adminHomePage=new AdminHomePage(driver);
		try
		{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(5000);
			defaultTotalCnt=GenericLib.getIntegerNumber(teacherHomePage.getEleTotalSessionCount());
			defaultCompletedCnt=GenericLib.getIntegerNumber(teacherHomePage.getEleCompletedSessionCount());
			defaultRemainingCnt=GenericLib.getIntegerNumber(teacherHomePage.getEleRemainingSessionCount());
			defaultLastCourseTaken=teacherHomePage.getEleLastCourseTxt().getText();
			defaultLastSessionTaken=teacherHomePage.getEleLastSessionTxt().getText();
			teacherCoursePage.getEleCourseTab().click();
			Thread.sleep(4000);	
			adminHomePage.selectbyindexvalue(teacherCoursePage.getEleBatchSelected(), 0);
			Thread.sleep(4000);
			adminHomePage.selectbyindexvalue(teacherCoursePage.getEleCourseSelected(), 0);
			expectedLastCourseTaken=adminHomePage.getOptions(teacherCoursePage.getEleCourseSelected());
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        String winHandleBefore = driver.getWindowHandle();
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(2000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(4000);
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleActivityLnk());
	        Thread.sleep(2000);
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        // Home Page
	        int numberOfGroups=activityPage.getEleGroups().size();
	        activityPage.verifySessionHomePageElements();
	        // Page 1 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 2 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleActivityVideo(), "Video","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 3 of 14
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	      //Page 4 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page of 5 of 14 
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 6 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 7 of 14
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        //Page 8 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        // Page 9 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 10 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleAudioIcn(), "Audio icon", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleAudioControlStn(), "Audio Contorl Bar", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 11 of 14
	        activityPage.getEleStartBtn().click();;
	        activityPage.verifyGroupActivityPage();
	      //Page 12 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page 13 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        //Page 14 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        teacherHomePage.getEleHomeTab().click();
	        Thread.sleep(2000);
			actualTotalCnt=GenericLib.getIntegerNumber(teacherHomePage.getEleTotalSessionCount());
			actualCompletedCnt=GenericLib.getIntegerNumber(teacherHomePage.getEleCompletedSessionCount());
			actualRemainingCnt=GenericLib.getIntegerNumber(teacherHomePage.getEleRemainingSessionCount());
			actualLastCourseTaken=teacherHomePage.getEleLastCourseTxt().getText();
			actualLastSessionTaken=teacherHomePage.getEleLastSessionTxt().getText();

			System.out.println(actualTotalCnt);
			System.out.println(actualCompletedCnt);
			System.out.println(actualRemainingCnt);
			System.out.println(actualLastCourseTaken);
			System.out.println(actualLastSessionTaken);
	        
			if(actualTotalCnt-defaultTotalCnt==0){
				System.out.println("Total count is same");
			}
			else{
				System.out.println("Total count is not same");
			}		
			if(actualCompletedCnt-defaultCompletedCnt==1){
				System.out.println("Completed is Same");
			}
			else
			{
				System.out.println("Completed is not same");
			}
			if(defaultRemainingCnt-actualRemainingCnt==1){
				System.out.println("Remaining count is same");
			}
			else{
				System.out.println("Remaining count is not same");
			}			
			
			if(actualLastCourseTaken.equalsIgnoreCase(expectedLastCourseTaken)==true){
				System.out.println("Last course taken is same");
			}
			else{
				System.out.println("Last course taken is not same");
			}	
			
			if(actualLastSessionTaken.equalsIgnoreCase("Greeting and Introduction")==true){
				System.out.println("Last Session taken is same");
			}
			else{
				System.out.println("Last Session taken is not same");
			}
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	* @Description:Verification of Elements in 'Family and Friends'.
	* @Author:Navakanth
	*/
	@Parameters("browser")
	@Test(priority=6,enabled=false,description="Verification of Elements in 'Family and Friends'.")
	public void testFamilyAndfriends(String browser) throws Throwable
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
			Thread.sleep(5000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(2000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(4000);
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleFamilyAndFriendsActivitylnk());
	        Thread.sleep(2000);
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        // Home Page
	        int numberOfGroups=activityPage.getEleGroups().size();
	        activityPage.verifySessionHomePageElements();
	        // Page 1 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 2 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleActivityVideo(), "Video","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 3 of 14
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	      //Page 4 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page of 5 of 14 
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 6 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleAudioControlStn(),"Audio Controller ", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 7 of 14
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        //Page 8 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        // Page 9 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 10 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(activityPage.getEleHintsBtn(), "'Hints' Button","displayed");
			studentSignInPage.elementStatus(activityPage.getEleHintTxt(), "Hint Text ","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 11 of 14
	        activityPage.getEleStartBtn().click();;
	        activityPage.verifyGroupActivityPage();
	      //Page 12 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page 13 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        //Page 14 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	 }
	/* 
	* @Description:Verification of Elements in 'Acquiring Information'.
	* @Author:Navakanth
	*/
	@Parameters("browser")
    @Test(priority=7,enabled=false,description="Verification of Elements in 'Acquiring Information'.")
	public void testAcquiringInformation(String browser) throws Throwable
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
			Thread.sleep(5000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(2000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(4000);
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleAcquiringInfoActivitylnk());
	        Thread.sleep(2000);
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        // Home Page
	        int numberOfGroups=activityPage.getEleGroups().size();
	        activityPage.verifySessionHomePageElements();
	        // Page 1 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 2 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioLnk(), "Audio link ","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 3 of 14
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	      //Page 4 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page of 5 of 14 
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 6 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 7 of 14
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        //Page 8 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        // Page 9 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 10 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleSampleQuestions(), "Sample Questions ", "displayed");
	        //Page 11 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyGroupActivityPage();
	        //Page 12 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page 13 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        //Page 14 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	* @Description:Verification of Elements in 'Being Aware' 
	* @Author:Navakanth
	*/
	@Parameters("browser")
    @Test(priority=8,enabled=false,description="Verification of Elements in 'Being Aware' ")
	public void testBeingAware(String browser) throws Throwable
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
			Thread.sleep(5000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(2000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(4000);
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleBeingAwareActivitylnk());
	        Thread.sleep(2000);
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        // Home Page
	        int numberOfGroups=activityPage.getEleGroups().size();
	        activityPage.verifySessionHomePageElements();
	        // Page 1 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 2 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleVideo(), "Video","displayed");
	        //Page 3 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyGroupActivityPage();
	      //Page 4 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page of 5 of 14 
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 6 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 7 of 14
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        //Page 8 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        // Page 9 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 10 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleAudioIcn(), "Audio icon", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleAudioControlStn(), "Audio Contorl Bar", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 11 of 14
	        activityPage.getEleStartBtn().click();;
	        activityPage.verifyGroupActivityPage();
	        //Page 12 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page 13 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        //Page 14 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}	
	/* 
	* @Description:Verification of Elements in 'General Enquiry'. 
	* @Author:Navakanth
	*/
	@Parameters("browser")
    @Test(priority=9,enabled=false,description="Verification of Elements in 'General Enquiry'. ")
	public void testGeneralEnquiry(String browser) throws Throwable
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
			Thread.sleep(5000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(2000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(4000);
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleGeneralEnquiryActivitylnk());
	        Thread.sleep(2000);
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        // Home Page
	        int numberOfGroups=activityPage.getEleGroups().size();
	        activityPage.verifySessionHomePageElements();
	        // Page 1 of 16
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 2 of 16
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleActivityVideo(), "Video","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Answer Text","displayed");
	        //Page 3 of 16
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        //Page 4 of 16
	        activityPage.verifyNextPage();
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleActivityVideo(), "Video","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Answer Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page of 5 of 16 
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page 6 of 16
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 7 of 16
	        activityPage.verifyNextPage();
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionImg(),"Question image ", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleHintStn(),"Hint text", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleHintTxt(),"Hint Contents", "displayed");
	        //Page 8 of 16
	        activityPage.verifyNextPage();
	        activityPage.verifyGroupActivityPage();
	        //Page 9 of 16
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        // Page 10 of 16
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 11 of 16
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 12 of 16
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        // Page 13 of 16
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 14 of 16
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page 15 of 16
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        //Page 16 of 16
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	* @Description:Verification of Elements in 'Knowing People' 
	* @Author:Navakanth
	*/@Parameters("browser")
    @Test(priority=10,enabled=false,description="Verification of Elements in 'Knowing People' ")
	public void testKnowingPeople(String browser) throws Throwable
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
			Thread.sleep(5000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(2000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(4000);
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleKnowingPeopleActivitylnk());
	        Thread.sleep(2000);
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        // Home Page
	        int numberOfGroups=activityPage.getEleGroups().size();
	        activityPage.verifySessionHomePageElements();
	        // Page 1 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 2 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleVideo(), "Video","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleHintStn(),"Hint text", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleHintTxt(),"Hint Contents", "displayed");
	        //Page 3 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyGroupActivityPage();
	        //Page 4 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page of 5 of 14 
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 6 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(activityPage.getEleHintsBtn(), "Hints Button","displayed");
			studentSignInPage.elementStatus(activityPage.getEleHintTxt(), "Hints Content","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 7 of 14
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        //Page 8 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        // Page 9 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 10 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleAudioIcn(), "Audio icon", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleAudioControlStn(), "Audio Contorl Bar", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 11 of 14
	        activityPage.getEleStartBtn().click();;
	        activityPage.verifyGroupActivityPage();
	        //Page 12 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page 13 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        //Page 14 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	* @Description:Verification of Elements in 'Telling Time' 
	* @Author:Navakanth
	*/
	@Parameters("browser")
    @Test(priority=11,enabled=false,description="Verification of Elements in 'Telling Time' ")
	public void testTellingTime(String browser) throws Throwable
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
			Thread.sleep(5000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(2000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(4000);
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleTellingTimeActivitylnk());
	        Thread.sleep(2000);
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        // Home Page
	        int numberOfGroups=activityPage.getEleGroups().size();
	        activityPage.verifySessionHomePageElements();
	        // Page 1 of 15
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 2 of 15
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleVideo(), "Video","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleHintStn(), "Hints Button","displayed");
			studentSignInPage.elementStatus(activityPage.getEleHintTxt(), "Hints Content","displayed");
	        //Page 3 of 15
	        activityPage.verifyNextPage();
	        activityPage.verifyGroupActivityPage();
	      //Page 4 of 15
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page of 5 of 15 
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 6 of 15
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 7 of 15
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        //Page 8 of 15
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Answer Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        // Page 9 of 15
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        // Page 10 of 15
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 11 of 15
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleHintStn(), "Hints Button","displayed");
			studentSignInPage.elementStatus(activityPage.getEleHintTxt(), "Hints Content","displayed");
	        // Page 12 of 15		        
			activityPage.verifyNextPage();
		    activityPage.verifyGroupActivityPage();
		   //Page 13 of 15
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page 13 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        //Page 14 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	* @Description:Verification of Elements in 'Shopping For Basics' 
	* @Author:Navakanth
	*/
	@Parameters("browser")
    @Test(priority=12,enabled=false,description="Verification of Elements in 'Shopping For Basics' ")
	public void testShoppingForbasics(String browser) throws Throwable
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
			Thread.sleep(5000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(2000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(4000);
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleShoppingforBasicsActivitylnk());
	        Thread.sleep(2000);
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        // Home Page
	        int numberOfGroups=activityPage.getEleGroups().size();
	        activityPage.verifySessionHomePageElements();
	        // Page 1 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 2 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleVideo(), "Video","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleHintsBtn(), "Hints Button","displayed");
			studentSignInPage.elementStatus(activityPage.getEleHintTxt(), "Hints Content","displayed");
	        //Page 3 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyGroupActivityPage();
	      //Page 4 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page of 5 of 14 
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 6 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 7 of 14
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        //Page 8 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        // Page 9 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 10 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleAudioIcn(), "Audio icon", "displayed");
			studentSignInPage.elementStatus( activityPage.getEleAudioControlStn(), "Audio Contorl Bar", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 11 of 14
	        activityPage.getEleStartBtn().click();;
	        activityPage.verifyGroupActivityPage();
	      //Page 12 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page 13 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        //Page 14 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	* @Description:Verification of Elements in 'Casual Conversations' 
	* @Author:Navakanth
	*/
	@Parameters("browser")
    @Test(priority=13,enabled=false,description="Verification of Elements in 'Casual Conversations' ")
	public void testCasualConversation(String browser) throws Throwable
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
			Thread.sleep(5000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(2000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(4000);
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleCasualConversationsActivitylnk());
	        Thread.sleep(2000);
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        // Home Page
	        int numberOfGroups=activityPage.getEleGroups().size();
	        activityPage.verifySessionHomePageElements();
	        // Page 1 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 2 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleVideo(), "Video","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleHintsBtn(), "Hints Button","displayed");
			studentSignInPage.elementStatus(activityPage.getEleHintTxt(), "Hints Content","displayed");
	        //Page 3 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyGroupActivityPage();
	      //Page 4 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page of 5 of 14 
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 6 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleHintsBtn(), "Hints Button","displayed");
	        activityPage.getEleHintsBtn().click();
			studentSignInPage.elementStatus(activityPage.getEleHintTxt(), "Hints Content","displayed");
			activityPage.getEleHintsBtn().click();
	        //Page 7 of 14
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        //Page 8 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        // Page 9 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 10 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 11 of 14
	        activityPage.getEleStartBtn().click();;
	        activityPage.verifyGroupActivityPage();
	      //Page 12 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page 13 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        //Page 14 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	* @Description:Verification of Elements in 'Polite Conversations' 
	* @Author:Navakanth
	*/
	@Parameters("browser")
    @Test(priority=14,enabled=false,description="Verification of Elements in 'Polite Conversations' ")
	public void testPoliteConversation(String browser) throws Throwable
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
			Thread.sleep(5000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(2000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(4000);
	        studentSignInPage.ClickByJs(teacherSessionsPage.getElePoliteConversationsActivitylnk());
	        Thread.sleep(2000);
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        // Home Page
	        int numberOfGroups=activityPage.getEleGroups().size();
	        activityPage.verifySessionHomePageElements();
	        // Page 1 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 2 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseImg(), "Exercise Image","displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        //Page 3 of 14
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        //Page 4 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page of 5 of 14 
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 6 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleHintStn(), "Hints Button","displayed");
			studentSignInPage.elementStatus(activityPage.getEleHintTxt(), "Hints Content","displayed");
	        //Page 7 of 14
			 activityPage.verifyNextPage();
	        activityPage.verifyGroupActivityPage();
	        //Page 8 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        // Page 9 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 10 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleHintStn(), "Hints Button","displayed");
			studentSignInPage.elementStatus(activityPage.getEleHintTxt(), "Hints Content","displayed");
			//Page 11 of 14
			 activityPage.verifyNextPage();
	        activityPage.verifyGroupActivityPage();
	        //Page 12 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page 13 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        //Page 14 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	* @Description:Verification of Elements in 'Sharing Experiences'. 
	* @Author:Navakanth
	*/
	@Parameters("browser")
    @Test(priority=15,enabled=false,description="Verification of Elements in 'Sharing Experiences'. ")
	public void testSharingExperiences(String browser) throws Throwable
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
			Thread.sleep(5000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(2000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(4000);
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleSharingExperiencesActivitylnk());
	        Thread.sleep(2000);
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        // Home Page
	        int numberOfGroups=activityPage.getEleGroups().size();
	        activityPage.verifySessionHomePageElements();
	        // Page 1 of 16
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 2 of 16
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleActivityVideo(), "Video","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Exercise Text","displayed");
	        //Page 3 of 16
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        //Page 4 of 14
	        activityPage.verifyNextPage();
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleActivityVideo(), "Video","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Answer Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page of 5 of 16 
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page 6 of 16
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 7 of 16
	        activityPage.verifyNextPage();
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseImg(),"Question image ", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 8 of 16
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        //Page 9 of 16
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        // Page 10 of 16
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 11 of 16
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 12 of 16
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        // Page 13 of 16
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Answer Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseInstructionTxt(), "Excercise Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Conservations text","displayed");
	        //Page 14 of 16
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page 15 of 16
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        //Page 16 of 16
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	* @Description:Verification of Elements in 'Getting Directions' 
	* @Author:Navakanth
	*/
	@Parameters("browser")
    @Test(priority=16,enabled=false,description="Verification of Elements in 'Getting Directions' ")
	public void testGettingDirections(String browser) throws Throwable

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
			Thread.sleep(5000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(2000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(4000);
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleGettingDirectionsActivitylnk());
	        Thread.sleep(2000);
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        // Home Page
	        int numberOfGroups=activityPage.getEleGroups().size();
	        activityPage.verifySessionHomePageElements();
	        // Page 1 of 15
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 2 of 15
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseImg(), "Exercise Image","displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        //Page 3 of 15
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	      //Page 4 of 15
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseImg(), "Exercise Image","displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Answer Text","displayed");
			//Page of 5 of 15
			activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page of 6 of 15 
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 7 of 15
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleQuestionImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleAudioControlStn(), "Audio Controller ", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleAudioIcn(), "Audio icon ", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleHintStn(), "Hints Button","displayed");
			studentSignInPage.elementStatus(activityPage.getEleHintTxt(), "Hints Content","displayed");
	        //Page 8 of 15
			 activityPage.verifyNextPage();
	        activityPage.verifyGroupActivityPage();
	        //Page 9 of 15
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        // Page 10 of 15
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 11 of 15
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
	        studentSignInPage.elementStatus(activityPage.getEleHintsBtn(), "Hints Button","displayed");
	        activityPage.getEleHintsBtn().click();
			studentSignInPage.elementStatus(activityPage.getEleHintTxt(), "Hints Content","displayed");
			activityPage.getEleHintsBtn().click();
			//Page 12 of 15
			 activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        //Page 13 of 15
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page 14 of 15
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        //Page 15 of 15
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	* @Description:Verification of Elements in 'Seeking Permissions' 
	* @Author:Navakanth
	*/
	@Parameters("browser")
    @Test(priority=17,enabled=false,description="Verification of Elements in 'Seeking Permissions' ")
	public void testSeekingPermisions(String browser) throws Throwable
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
			Thread.sleep(5000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(2000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(4000);
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleSeekingPermissionActivitylnk());
	        Thread.sleep(2000);
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        // Home Page
	        int numberOfGroups=activityPage.getEleGroups().size();
	        activityPage.verifySessionHomePageElements();
	        // Page 1 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 2 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleVideo(), "Video ","displayed");
			// Page 3 of 14 
	        activityPage.verifyNextPage();
	        activityPage.verifyGroupActivityPage();
	        //Page 4 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page of 5 of 14 
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 6 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        //Page 7 of 14
			 activityPage.getEleStartBtn().click();;
	        activityPage.verifyGroupActivityPage();
	        //Page 8 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        // Page 9 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 10 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
	        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleHintsBtn(), "Hints Button","displayed");
	        activityPage.getEleHintsBtn().click();
	        Thread.sleep(1000);
			studentSignInPage.elementStatus(activityPage.getEleHintTxt(), "Hints Content","displayed");
			activityPage.getEleHintsBtn().click();
			//Page 11 of 14
			 activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        //Page 12 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page 13 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        //Page 14 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	* @Description:Verification of Elements in 'Likes And DisLikes' 
	* @Author:Navakanth
	*/
	@Parameters("browser")
    @Test(priority=18,enabled=false,description="Verification of Elements in 'Likes And DisLikes' ")
	public void testLikesAndDisLikes(String browser) throws Throwable

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
			Thread.sleep(5000);
			teacherCoursePage.getEleCourseTab().click();
			NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
			Thread.sleep(4000);	
		    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
			Thread.sleep(4000);
			new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
			Thread.sleep(4000);
	        teacherCoursePage.getEleStartCourseButton().click();
	        Thread.sleep(2000);
	        teacherCoursePage.switchToChildBrowser();
	        Thread.sleep(2000);
	        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
	        driver.switchTo().frame("main");
	        Thread.sleep(4000);
	        studentSignInPage.ClickByJs(teacherSessionsPage.getEleLikesAndDislikesActivitylnk());
	        Thread.sleep(2000);
	        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
	        	activityPage.getEleStartAgainBtn().click();
	        	Thread.sleep(1000);
	        }
	        // Home Page
	        int numberOfGroups=activityPage.getEleGroups().size();
	        activityPage.verifySessionHomePageElements();
	        // Page 1 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 2 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleVideo(), "Video","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleHintStn(), "Hints Button","displayed");
			studentSignInPage.elementStatus(activityPage.getEleHintTxt(), "Hints Content","displayed");
	        //Page 3 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyGroupActivityPage();
	      //Page 4 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page of 5 of 14 
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 6 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleAudioIcn(), "Audio icon ", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioControlStn(), "Audio Controller ","displayed");
	        //Page 7 of 14
	        Thread.sleep(1000);
	        activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        //Page 8 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        // Page 9 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
	        // Page 10 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
	        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
	        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
			activityPage.getEleZoomIcn().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
			activityPage.getEleZoomInImg().click();
			Thread.sleep(2000);
			studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
	        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions","displayed");
			studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Sample Questions ","displayed");
			//Page 11 of 14
			 activityPage.getEleStartBtn().click();
	        activityPage.verifyGroupActivityPage();
	        //Page 12 of 14
	        activityPage.verifyNextPage();
	        activityPage.verifyPeerGradingPageElements(numberOfGroups);
	        //Page 13 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
	        //Page 14 of 14
	        activityPage.verifyNextPage();
	        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		}
		catch(Exception e)
		{
		  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  throw e;
		}
	}
	/* 
	* @Description:Verify the elements in 'Activity' of 'Short Term plans'.
	* @Author:Navakanth
	*/
	@Parameters("browser")
    @Test(priority=19,enabled=false,description="Verification of Elements in 'Short-Term Plans' ")
	public void testShortTermPlans(String browser) throws Throwable

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
				Thread.sleep(5000);
				teacherCoursePage.getEleCourseTab().click();
				NXGReports.addStep("Clicked on Course Link", LogAs.PASSED, null);
				Thread.sleep(4000);	
			    new Select(teacherCoursePage.getEleBatchSelected()).selectByIndex(0);
				Thread.sleep(4000);
				new Select(teacherCoursePage.getEleCourseSelected()).selectByIndex(0);
				Thread.sleep(4000);
		        teacherCoursePage.getEleStartCourseButton().click();
		        Thread.sleep(2000);
		        teacherCoursePage.switchToChildBrowser();
		        Thread.sleep(2000);
		        System.out.println("Frames in Toc : "+driver.findElements(By.tagName("iframe")).size());
		        driver.switchTo().frame("main");
		        Thread.sleep(4000);
		        studentSignInPage.ClickByJs(teacherSessionsPage.getEleShortTermPlansActivitylnk());
		        Thread.sleep(2000);
		        if(activityPage.getEleStartAgainBtn().isDisplayed()==true){
		        	activityPage.getEleStartAgainBtn().click();
		        	Thread.sleep(1000);
		        }
		        // Home Page
		        int numberOfGroups=activityPage.getEleGroups().size();
		        activityPage.verifySessionHomePageElements();
		        // Page 1 of 15
		        activityPage.verifyNextPage();
		        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
		        // Page 2 of 15
		        activityPage.verifyNextPage();
		        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleActivityVideo(), "Video","displayed");
				studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
		        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions","displayed");
				studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Sample Questions ","displayed");
		        //Page 3 of 15
		        activityPage.getEleStartBtn().click();
		        activityPage.verifyGroupActivityPage();
		      //Page 4 of 15
		        activityPage.verifyNextPage();
		        activityPage.verifyPeerGradingPageElements(numberOfGroups);
		        //Page of 5 of 15 
		        activityPage.verifyNextPage();
		        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
		        // Page 6 of 15
		        activityPage.verifyNextPage();
		        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
		        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
		        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
				activityPage.getEleZoomIcn().click();
				Thread.sleep(2000);
				studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
				activityPage.getEleZoomInImg().click();
				Thread.sleep(2000);
				studentSignInPage.elementStatus( activityPage.getEleAudioIcn(), "Audio Icon", "displayed");
				studentSignInPage.elementStatus( activityPage.getEleAudioControlStn(), "Audio Controller ", "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleHintsBtn(), "Hints Button","displayed");
		        activityPage.getEleHintsBtn().click();
		        Thread.sleep(1000);
				studentSignInPage.elementStatus(activityPage.getEleHintTxt(), "Hints Content","displayed");
				activityPage.getEleHintsBtn().click();
		        //Page 7 of 15
				 activityPage.getEleStartBtn().click();
		        activityPage.verifyGroupActivityPage();
		        //Page 8 of 15
		        activityPage.verifyNextPage();
		        activityPage.verifyPeerGradingPageElements(numberOfGroups);
		        // Page 9 of 15
		        activityPage.verifyNextPage();
		        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleInstructorImg(), "Instructor Image", "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleInstructionTxt(), "Activity instructions", "displayed");
		        // Page 10 of 15
		        activityPage.verifyNextPage();
		        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
		        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Excercise Text","displayed");
		        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
				activityPage.getEleZoomIcn().click();
				Thread.sleep(2000);
				studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
				activityPage.getEleZoomInImg().click();
				Thread.sleep(2000);
				studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions","displayed");
				studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Sample Conservations ","displayed");
				//Page 11 of 15
				 activityPage.getEleStartBtn().click();
		        activityPage.verifyGroupActivityPage();
		      //Page 12 of 15
		        activityPage.verifyNextPage();
		        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		        studentSignInPage.elementStatus(activityPage.eleActivityTxt(),"Activity Info : "+activityPage.eleActivityTxt().getText(), "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions", "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleAudioInstructionTxt(),activityPage.getEleAudioInstructionTxt().getText(), "displayed");
		        studentSignInPage.elementStatus( activityPage.getEleExerciseImg(), "Excercise Image", "displayed");
		        studentSignInPage.elementStatus(activityPage.getEleExerciseTxt(), "Answer Text","displayed");
		        studentSignInPage.elementStatus( activityPage.getEleZoomIcn(), "Zoom icon ", "displayed");
				activityPage.getEleZoomIcn().click();
				Thread.sleep(2000);
				studentSignInPage.elementStatus( activityPage.getEleZoomInImg(), "Zoomed image ", "displayed");
				activityPage.getEleZoomInImg().click();
				Thread.sleep(2000);
				studentSignInPage.elementStatus(activityPage.getEleExcerciseTitleTxt(), "Page Instructions","displayed");
				studentSignInPage.elementStatus(activityPage.getEleQuestionStn(), "Sample Conservations ","displayed");
		        //Page 13 of 15
		        activityPage.verifyNextPage();
		        activityPage.verifyPeerGradingPageElements(numberOfGroups);
		        //Page 14 of 15
		        activityPage.verifyNextPage();
		        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
		        //Page 15 of 15
		        activityPage.verifyNextPage();
		        NXGReports.addStep("Page Info"+activityPage.getElePageNumTxt().getText(), LogAs.PASSED, null);
			}
			catch(Exception e)
			{
			  NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			  throw e;
			}
		}
}