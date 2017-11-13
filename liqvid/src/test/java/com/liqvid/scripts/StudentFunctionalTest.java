/***********************************************************************
* @author 			:		Raghukiran MR
* @description		: 		Test scripts of StudentFunctionalTest
* @module			:		Student Module
* @testmethod		:	   	sampleDatabaseTest()
* @testmethod       :       studentHomePage()
* @testmethod		:		uploadPhotoStudentProfile()
* @testmethod		:		verifyInvalidOldPwd()
* @testmethod		:		functionalityofChangePassword()
* @testmethod		:		invalidEmailidPhoneNumber()
* @testmethod		:		errorMessageInProfile()
* @testmethod		:		verifyPreAssessmentNextPrevBtn()
* @testmethod		:		verifyPostAssessmentNextPrevBtn()
* @testmethod       :       verifyPreAssessementError()
* @testmethod       :       verifyPostAssessementError()
* @testmethod       :       changeStudentProfilePwd()
*/
package com.liqvid.scripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.liqvid.library.BaseLib;
import com.liqvid.library.GenericLib;
import com.liqvid.page.DataBasePage;
import com.liqvid.page.StudentCoursePage;
import com.liqvid.page.StudentHomePage;
import com.liqvid.page.StudentProfilePage;
import com.liqvid.page.StudentSignInPage;

public class StudentFunctionalTest extends BaseLib {
	StudentSignInPage studentSignInPo=null;
	StudentHomePage studenthomepo=null;
	StudentProfilePage studentprofilepo=null;
	StudentCoursePage studentcoursepo=null;
	DataBasePage databasepo=null;
	String sTestData;
	String[] sData=null;
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
	 * @Description:Login with valid credentials and verify the elements in the home page.
	 * @Author:RaghuKiran
	 * 
	 */
	@Parameters("browser")
	@Test(priority=2,enabled=true, description="Login with valid credentials and verify the elements in the home page")
	public void verifyStudentHomePage(String browser) throws Exception{
		studentSignInPo=new StudentSignInPage(driver);
		studenthomepo=new StudentHomePage(driver);
		sTestData="StudentLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPo.Login(sData[1],sData[2]);
			Thread.sleep(5000);
			studentSignInPo.elementStatus(studenthomepo.getEleWelcomeText(),"The welcome text", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleHomeTab(),"The Home tab","displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleCoursesTab(),"The Cources tab","displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleResourcesTab(),"The Resources tab","displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleLogo(),"The English Edge logo","displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleBulidVersion(),"The bulid version","displayed");
			Thread.sleep(2000);
			studentSignInPo.elementStatus(studenthomepo.getEleProfileTextDropdown(),"The Profile text","displayed");
			studenthomepo.getEleProfileTextDropdown().click();
			studentSignInPo.elementStatus(studenthomepo.getEleProfileOption(),"The Profile option","displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleLogoutOption(),"The Logout option","displayed");
			Thread.sleep(2000);
			studenthomepo.getEleLogoutOption().click();
			Thread.sleep(2000);
			studentSignInPo.elementStatus(studentSignInPo.getEleSignInText(),"The Sign in text","displayed");
		}catch(Exception e)
			{
				throw e;
			}
	}
	/* 
	 * @Description:Uploading Photo on Student Profile image and verify the image is removed in the homepage
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=3,enabled=true, description="Uploading Photo on Student Profile image,verify the image is removed in the homepage")
	public void verifyUploadPhotoStudentProfile(String browser) throws Exception{
		studentSignInPo=new StudentSignInPage(driver);
		studenthomepo=new StudentHomePage(driver);
		sTestData="StudentLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPo.Login(sData[1],sData[2]);
			Thread.sleep(6000);
			studentSignInPo.elementStatus(studenthomepo.getEleStudentProfilePhoto(),"The Profile photo option", "displayed");
			studenthomepo.getEleStudentProfilePhoto().click();
			Thread.sleep(4000);
			studenthomepo.getElePhotoPath().sendKeys(GenericLib.imagepath);
			Thread.sleep(4000);
			studentSignInPo.elementStatus(studenthomepo.getEleSubmitBtn(),"The Submit Button", "displayed");
			studenthomepo.getEleSubmitBtn().click();
			Thread.sleep(2000);
			studentSignInPo.elementStatus(studenthomepo.getEleEditBtn(),"The Edit Button", "displayed");
			Thread.sleep(4000);
			if(studenthomepo.getEleStudentProfileimage().getAttribute("src").contains("/learning/themes/notebook/images/logo.png"))
			{
				studentSignInPo.elementStatus(studenthomepo.getEleStudentProfileimage(),"The Student profile image is not", "displayed");
			}
				else{
					studentSignInPo.elementStatus(studenthomepo.getEleStudentProfileimage(),"The Student profile image is ", "not displayed");
				}
			//verify the image is removed in the homepage
			studenthomepo.getEleStudentProfilePhoto().click();
			Thread.sleep(4000);
			studentSignInPo.elementStatus(studenthomepo.getEleCancelBtn(),"The Cancel button ", "displayed");
			studentSignInPo.elementStatus(studenthomepo.getEleRemoveImageBtn(),"The Remove image button ", "displayed");
			if(studenthomepo.getEleRemoveImageBtn().isDisplayed()){
			studenthomepo.getEleRemoveImageBtn().click();
			if(studenthomepo.getEleStudentProfileimage().getAttribute("src").contains("/learning/themes/notebook/images/avatar_default.jpg"))
			{
				studentSignInPo.elementStatus(studenthomepo.getEleStudentProfileimage(),"The Student profile image is ", "displayed");
			}
				else{
					studentSignInPo.elementStatus(studenthomepo.getEleStudentProfileimage(),"The Student profile image is ", "not displayed");
				}
			}
			else{
				studentSignInPo.elementStatus(studenthomepo.getEleCancelBtn(),"The cancel button is ", "displayed");
				studenthomepo.getEleCancelBtn().click();
				studentSignInPo.elementStatus(studenthomepo.getEleStudentProfilePhoto(),"The Profile photo option", "displayed");
			}
		}catch(Exception e)
		{
			throw e;
		}
	}
	/* 
	 * @Description:Verify the functionality of 'Change Password' link after entering the values in  Old Password, New Password and confirm Password fields,After Changing Password try to Login with old password,Verify change password functionality of the student with valid data and login with new password .
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=12,enabled=true, description="Verify the functionality of 'Change Password' link after entering the values in  Old Password, New Password and confirm Password fields,After Changing Password try to Login with old password,Verify change password functionality of the student with valid data and login with new password .")
	public void verifyChangePasswordStudentProfile(String browser) throws Exception{
		studentSignInPo=new StudentSignInPage(driver);
		studenthomepo=new StudentHomePage(driver);
		studentprofilepo=new StudentProfilePage(driver);
		sTestData="StudentLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPo.Login(sData[1],sData[2]);
			Thread.sleep(3000);
			studenthomepo.getEleProfileTextDropdown().click();
			Thread.sleep(3000);
			studenthomepo.getEleProfileOption().click();
			Thread.sleep(3000);
			studentSignInPo.elementStatus(studentprofilepo.getEleChangePwd(),"The Change password link", "displayed");
			studentprofilepo.getEleChangePwd().click();
			Thread.sleep(3000);
			studentSignInPo.elementStatus(studentprofilepo.getEleOldPasswordTextBox(),"The old password textfiled", "displayed");
			studentprofilepo.getEleOldPasswordTextBox().sendKeys(sData[2]);
			studentSignInPo.elementStatus(studentprofilepo.getEleNewPasswordTextBox(),"The new password textfiled", "displayed");
			studentprofilepo.getEleNewPasswordTextBox().sendKeys(sData[4]);
			studentSignInPo.elementStatus(studentprofilepo.getEleConfirmNewPasswordTextBox(),"The confirm new password textfiled", "displayed");
			studentprofilepo.getEleConfirmNewPasswordTextBox().sendKeys(sData[4]);
			studentSignInPo.elementStatus(studentprofilepo.getEleUpdateButton(),"The update button", "displayed");
			studentprofilepo.getEleUpdateButton().click();
			studentSignInPo.elementStatus(studentprofilepo.getEleProfileErrorMessage(),"'Updated Successfully' message", "displayed");
			Thread.sleep(3000);
			studenthomepo.getEleProfileTextDropdown().click();
			Thread.sleep(4000);
			studenthomepo.getEleLogoutOption().click();
			//After Changing Password try to Login with old password Scenario
			Thread.sleep(3000);
			studentSignInPo.Login(sData[1],sData[2]);
			studentSignInPo.elementStatus(studentSignInPo.getEleIncorrectUserPwd(),"The error message 'Incorrect username or password.' ", "displayed");
			Thread.sleep(5000);
			studentSignInPo.Login(sData[1],sData[4]);
			studentSignInPo.elementStatus(studenthomepo.getEleWelcomeText(),"welcome message", "displayed");
			//clean up code 
			Thread.sleep(3000);
			studenthomepo.getEleProfileTextDropdown().click();
			Thread.sleep(4000);
			studenthomepo.getEleProfileOption().click();
			Thread.sleep(3000);
			studentprofilepo.getEleChangePwd().click();
			Thread.sleep(3000);
			studentprofilepo.getEleOldPasswordTextBox().sendKeys(sData[4]);
			studentprofilepo.getEleNewPasswordTextBox().sendKeys(sData[2]);
			studentprofilepo.getEleConfirmNewPasswordTextBox().sendKeys(sData[2]);
			studentprofilepo.getEleUpdateButton().click();
			Thread.sleep(4000);
			}catch(Exception e)
		{
				throw e;
		}
	}
	/* 
	 * @Description:Verify change password functionality of the student with Invalid old password and Valid New password and Confirm Password.
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=4,enabled=true, description="Verify change password functionality of the student with Invalid old password and Valid New password and Confirm Password.")
	public void verifyInvalidOldPwd(String browser) throws Exception{
		studentSignInPo=new StudentSignInPage(driver);
		studenthomepo=new StudentHomePage(driver);
		studentprofilepo=new StudentProfilePage(driver);
		sTestData="StudentLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPo.Login(sData[1],sData[2]);
			Thread.sleep(3000);
			studenthomepo.getEleProfileTextDropdown().click();
			Thread.sleep(3000);
			studenthomepo.getEleProfileOption().click();
			Thread.sleep(3000);
			studentprofilepo.getEleChangePwd().click();
			Thread.sleep(3000);
			studentSignInPo.scrolldown();
			studentprofilepo.getEleUpdateButton().click();
			studentSignInPo.elementStatus(studentprofilepo.getEeleValueRequiredErrMsg(),"The error message 'This value is required.'", "displayed");
			studentprofilepo.getEleOldPasswordTextBox().sendKeys(sData[3]);
			studentprofilepo.getEleNewPasswordTextBox().sendKeys(sData[4]);
			studentprofilepo.getEleConfirmNewPasswordTextBox().sendKeys(sData[5]);
			studentprofilepo.getEleUpdateButton().click();
			studentSignInPo.elementStatus(studentprofilepo.getEleInvalidOldPwdErrMsg(),"The error message 'Invalid Old password'", "displayed");
			
		}catch(Exception e)
		{
			throw e;
		}
		
		
	}
	/* 
	 * @Description:Verify the functionality of 'Change Password' link after entering the values in  Old Password, New Password and confirm Password fields
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=5,enabled=true, description="Verify the functionality of 'Change Password' link after entering the values in  Old Password, New Password and confirm Password fields")
	public void functionalityofChangePassword(String browser) throws Exception{
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
			Thread.sleep(4000);
			studenthomepo.getEleProfileOption().click();
			Thread.sleep(4000);
			studentprofilepo.getEleChangePwd().click();
			studentSignInPo.scrolldown();
			studentprofilepo.getEleOldPasswordTextBox().sendKeys(sData[3]);
			studentprofilepo.getEleNewPasswordTextBox().sendKeys(sData[4]);
			studentprofilepo.getEleConfirmNewPasswordTextBox().sendKeys(sData[5]);
			studentprofilepo.getEleChangePwd().click();
			studentprofilepo.getEleChangePwd().click();
			studentprofilepo.getEleUpdateButton().click();
			studentSignInPo.elementStatus(studentprofilepo.getEeleValueRequiredErrMsg(),"No value is present in the old password,new password and confirm password text field'", "displayed");
		}catch(AssertionError e)
		{
			throw e;
		}
		
	}
	/* 
	 * @Description:Verify the error messages that displayed when Invalid 'Email Id',Invalid 'Phone number' is entered
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=6,enabled=true, description=" Verify the error messages that displayed when Invalid 'Email Id',Invalid 'Phone number' is entered")
	public void verifyInvalidEmailidPhoneNumber(String browser) throws Exception{
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
			Thread.sleep(4000);
			studenthomepo.getEleProfileOption().click();
			Thread.sleep(4000);
			studentprofilepo.getEleEmailIdTextBox().clear();
			studentprofilepo.getElePhoneTextBox().clear();
			studentprofilepo.getEleEmailIdTextBox().sendKeys(sData[6]);
			studentprofilepo.getElePhoneTextBox().sendKeys(sData[6]);
			studentprofilepo.getEleUpdateButton().click();
			studentSignInPo.elementStatus(studentprofilepo.getEleEmailIdErrorMsg(),"The error 'This value should be a valid email.'", "displayed");
			studentSignInPo.elementStatus(studentprofilepo.getElePhoneNumberErrorMsg(),"The error 'This value should be a valid phone number.'", "displayed");
			
		}catch(AssertionError e)
		{
			throw e;
		}
	}
	/* 
	 * @Description:Verify the error messages in the profile page
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=7,enabled=true, description="Verify the error messages in the profile page")
	public void verifyErrorMessageInProfile(String browser) throws Exception{
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
			Thread.sleep(3000);
			studenthomepo.getEleProfileOption().click();
			Thread.sleep(3000);
			studentprofilepo.getEleChangePwd().click();
			studentSignInPo.scrolldown();
			studentprofilepo.getEleNewPasswordTextBox().sendKeys(sData[6]);
			studentprofilepo.getEleConfirmNewPasswordTextBox().sendKeys(sData[6]);
			studentprofilepo.getEleUpdateButton().click();
			//Verify This value is too short. It should have 6 characters or more error message is displayed.
			Thread.sleep(3000);
			studentSignInPo.elementStatus(studentprofilepo.getEleValueIsShortErrorMsg(),"This value is too short. It should have 6 characters or more.", "displayed");
			//Verify This value should be the same error message is displayed.
			Thread.sleep(3000);
			studentprofilepo.getEleConfirmNewPasswordTextBox().clear();
			studentprofilepo.getEleConfirmNewPasswordTextBox().sendKeys(sData[4]);
			studentprofilepo.getEleUpdateButton().click();
			studentSignInPo.elementStatus(studentprofilepo.getEleValueShouldSameErrorMsg(),"This value should be the same", "displayed");
			//verify this This value is required. error message is displayed 
			studentprofilepo.getEleFirstNameTextBox().clear();
			studentprofilepo.getEleLastNameTextBox().clear();
			studentprofilepo.getEleEmailIdTextBox().clear();
			studentprofilepo.getElePhoneTextBox().clear();
			Thread.sleep(2000);
			studentprofilepo.getEleChangePwd().click();
			Thread.sleep(2000);
			studentprofilepo.getEleUpdateButton().click();
			Thread.sleep(2000);
			studentSignInPo.elementStatus(studentprofilepo.getEeleValueRequiredErrMsg(),"This value requried error message is displayed", "displayed");
			
		}catch(AssertionError e)
		{
			throw e;
		}
		
	}
	/* 
	 * @Description:Verify whether all the questions can be answered by clicking on 'Next' button,Verify  the functionality of 'prev' button,Verify the functionality of "Finish" button,Verify the functionality of Back button
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=8,enabled=false, description="Verify whether all the questions can be answered by clicking on 'Next' button,Verify  the functionality of 'prev' button,Verify the functionality of 'Finish' button,Verify the functionality of Back button")
	public void verifyPreAssessmentNextPrevBackBtn(String browser) throws Exception{
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
			Select select=new Select(studentcoursepo.getEleClass());
			select.selectByIndex(0);
			Thread.sleep(2000);
			Select select1=new Select(studentcoursepo.getEleCourseSelected());
			select1.selectByIndex(0);
			Thread.sleep(5000);
			studentcoursepo.getEleStartCourseButton().click();
			Thread.sleep(5000);
			 studentcoursepo.switchToLatestPopupWindow();
			 Thread.sleep(5000);
			studentcoursepo.getElePreAssessmentLink().click();
			Thread.sleep(5000);
			studentSignInPo.handleStartTestbutton();
			 Thread.sleep(8000);
			 studentSignInPo.elementStatus(studentcoursepo.getEleClass1PreAssessmentText(),"The Pre Assessment text is ", "displayed");
			 studentcoursepo.verifyNextPrevbutton();
			 studentSignInPo.elementStatus(studentcoursepo.getEleFinishText(),"finished text is displayed", "displayed");
			 studentSignInPo.elementStatus(studentcoursepo.getEleFinishbutton(),"finished button is displayed", "displayed");
			 studentSignInPo.elementStatus(studentcoursepo.getEleFinishInstruction(),"finished instruction is displayed", "displayed");
			 studentcoursepo.getEleFinishbutton().click();
			 studentSignInPo.elementStatus(studentcoursepo.getEleScoreText(),"Score text is displayed", "displayed");
			 studentSignInPo.elementStatus(studentcoursepo.getEleBackButton(),"Back button is displayed", "displayed");
			 Thread.sleep(4000);
			 studentcoursepo.getEleBackButton().click();
			 Assert.assertTrue(studentcoursepo.getElePreAssessmentLink().isDisplayed(), "The preassessment link is not displayed");
			 NXGReports.addStep("the preassessment link is displayed", LogAs.PASSED, null);
		}catch(AssertionError e)
		{
			throw e;
		}
	}
	/* 
	 * @Description:Verify whether all the questions can be answered by clicking on 'Next' button,Verify  the functionality of 'prev' button,Verify the functionality of "Finish" button,Verify the functionality of Back button
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=9,enabled=false, description="Verify whether all the questions can be answered by clicking on 'Next' button,Verify  the functionality of 'prev' button,Verify the functionality of 'Finish' button,Verify the functionality of Back button")
	public void verifyPostAssessmentNextPrevBtn(String browser) throws Exception{
		studentSignInPo=new StudentSignInPage(driver);
		studenthomepo=new StudentHomePage(driver);
		studentprofilepo=new StudentProfilePage(driver);
		studentcoursepo=new StudentCoursePage(driver);
		sTestData="StudentLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPo.Login(sData[1],sData[2]);
			Thread.sleep(6000);
			studentcoursepo.getEleCourseTab().click();
			Thread.sleep(4000);	
			Select select=new Select(studentcoursepo.getEleClass());
			select.selectByIndex(0);
			Thread.sleep(4000);
			Select select1=new Select(studentcoursepo.getEleCourseSelected());
			select1.selectByIndex(0);
			Thread.sleep(5000);
			studentcoursepo.getEleStartCourseButton().click();
			Thread.sleep(5000);
			 studentcoursepo.switchToLatestPopupWindow();
			 Thread.sleep(5000);
			 studentcoursepo.getEleNextBtn().click();
			 Thread.sleep(5000);
			studentcoursepo.getElePostAssessmentLink().click();
			Thread.sleep(2000);
			studentSignInPo.handleStartTestbutton();
			Thread.sleep(8000);
			 studentcoursepo.verifyNextPrevbutton();
			 studentSignInPo.elementStatus(studentcoursepo.getEleFinishText(),"finished text is displayed", "displayed");
			 studentSignInPo.elementStatus(studentcoursepo.getEleFinishbutton(),"finished button is displayed", "displayed");
			 studentSignInPo.elementStatus(studentcoursepo.getEleFinishInstruction(),"finished instruction is displayed", "displayed");
			 studentcoursepo.getEleFinishbutton().click();
			 studentSignInPo.elementStatus(studentcoursepo.getEleScoreText(),"Score text is displayed", "displayed");
			 studentSignInPo.elementStatus(studentcoursepo.getEleBackButton(),"Back button is displayed", "displayed");
			 Thread.sleep(4000);
			 studentcoursepo.getEleBackButton().click();
			 Assert.assertTrue(studentcoursepo.getElePreAssessmentLink().isDisplayed(), "The preassessment link is not displayed");
			 NXGReports.addStep("the preassessment link is displayed", LogAs.PASSED, null);
		}catch(AssertionError e)
		{
			throw e;
		}
	}
	/* 
	 * @Description:Verify the Message that appears when user click the start test button for the second button
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=10,enabled=false, description="Verify the Message that appears when user click the start test button for the second button")
	public void verifyPreAssessementError(String browser) throws Exception{
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
			Thread.sleep(4000);	
			Select select=new Select(studentcoursepo.getEleClass());
			select.selectByIndex(0);
			Thread.sleep(4000);
			Select select1=new Select(studentcoursepo.getEleCourseSelected());
			select1.selectByIndex(0);
			Thread.sleep(4000);
			studentcoursepo.getEleStartCourseButton().click();
			Thread.sleep(2000);
			 studentcoursepo.switchToLatestPopupWindow();
			 Thread.sleep(2000);
			studentcoursepo.getElePreAssessmentLink().click();
			Thread.sleep(2000);
			studentSignInPo.handleStartTestbutton();
			Thread.sleep(4000);
			 for(WebElement eleErrorMessage:studentcoursepo.getEleInstruction())
			{
				 Assert.assertTrue(eleErrorMessage.isDisplayed(),
							eleErrorMessage.getText() + " error message is not displayed in the preassesment message");
					NXGReports.addStep(
							eleErrorMessage.getText() + "error message is displayed in the preassesment message",
							LogAs.PASSED, null);
			}
			 Thread.sleep(4000);
		}catch(AssertionError e)
		{

			throw e;
		}
	}
	/* 
	 * @Description:Verify the Message that appears when user click the start test button for the second button
	 * @Author:RaghuKiran
	 */
	@Parameters("browser")
	@Test(priority=11,enabled=false, description="Verify the Message that appears when user click the start test button for the second button")
	public void verifyPostAssessementError(String browser) throws Exception{
		studentSignInPo=new StudentSignInPage(driver);
		studenthomepo=new StudentHomePage(driver);
		studentprofilepo=new StudentProfilePage(driver);
		studentcoursepo=new StudentCoursePage(driver);
		sTestData="StudentLogin_01";
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			studentSignInPo.Login(sData[1],sData[2]);
			Thread.sleep(4000);
			studentcoursepo.getEleCourseTab().click();
			Thread.sleep(4000);	
			Select select=new Select(studentcoursepo.getEleClass());
			select.selectByIndex(0);
			Thread.sleep(4000);
			Select select1=new Select(studentcoursepo.getEleCourseSelected());
			select1.selectByIndex(0);
			Thread.sleep(4000);
			studentcoursepo.getEleStartCourseButton().click();
			Thread.sleep(5000);
			 studentcoursepo.switchToLatestPopupWindow();
			 Thread.sleep(5000);
			 studentcoursepo.getEleNextBtn().click();
			 Thread.sleep(5000);
			studentcoursepo.getElePostAssessmentLink().click();
			Thread.sleep(2000);
			studentSignInPo.handleStartTestbutton();
			Thread.sleep(4000);
			 for(WebElement eleErrorMessage:studentcoursepo.getEleInstruction())
			{
					Assert.assertTrue(eleErrorMessage.isDisplayed(),
							eleErrorMessage.getText() + " error message is not displayed in the postassesment message");
					NXGReports.addStep(
							eleErrorMessage.getText() + "error message is displayed in the postassesment message",
							LogAs.PASSED, null);
			}
		}catch(AssertionError e)
		{
			throw e;
		}
	}
}
