package com.liqvid.scripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;

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
import com.liqvid.page.AdminBatchReportPage;
import com.liqvid.page.AdminHomePage;
import com.liqvid.page.AdminProfilePage;
import com.liqvid.page.CreateBatchPage;
import com.liqvid.page.ForgotPasswordPage;
import com.liqvid.page.LicensePage;
import com.liqvid.page.ResourcesPage;
import com.liqvid.page.StudentRegistrationPage;
import com.liqvid.page.StudentSignInPage;
import com.liqvid.page.StudentUploadPage;
import com.liqvid.page.TeacherRegistrationPage;

public class AdminPagelevelTest extends BaseLib{
	StudentSignInPage studentSignInPage=null;
	AdminHomePage adminHomePage=null;
	CreateBatchPage createbatchpo=null;
	AdminBatchReportPage adminbatchreportpo=null;
	StudentUploadPage studentUploadPage=null;
	ResourcesPage resourcespo=null;
	TeacherRegistrationPage teacherregistrationpo=null;
	StudentRegistrationPage studentregisterationpo=null;
	AdminProfilePage adminprofilepagepo=null;
	ForgotPasswordPage forgotpasswordpo=null;
	LicensePage licensepo=null;
	String sTestData=null;
	String[] sData=null;
	/* 
	 * @Description:To verify Admin login with valid username and invalid Password, invalid username and valid Password,invalid username and invalid Password,valid credentials and Verify the elements in Admin home page
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=1,enabled=false,description="To verify Admin login with valid username and invalid Password, invalid username and valid Password,invalid username and invalid Password,valid credentials and Verify the elements in Admin home page")
	public void testVerifyAdminHomePageElements(String browser) throws Throwable{	
		studentSignInPage=new StudentSignInPage(driver);
		adminHomePage=new AdminHomePage(driver);
		studentSignInPage=new StudentSignInPage(driver);
		sTestData="AdminLogin_01";
		sData=GenericLib.toReadExcelData(sTestData);
		try {
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
			Thread.sleep(3000);
			// verify 'Username cannot be blank.','Password cannot be blank.' Error messages
			studentSignInPage.getEleSignInBtn().click();
			studentSignInPage.elementStatus(studentSignInPage.getElePwdErrMsg(),"'Password cannot be blank.' Error Message ","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleUserNameErrMsg(),"'Username cannot be blank.' Error Message ","displayed");
			// Verify Admin login with invalid username and valid Password
			studentSignInPage.Login(sData[5],sData[2]);
			studentSignInPage.elementStatus(studentSignInPage.getElePwdErrMsg(),"'Incorrect username or password.' Error Message ","displayed");
			studentSignInPage.getEleUserNameTextField().clear();
			studentSignInPage.getElePasswordTextFiled().clear();
			// Verify Admin login with valid username and invalid Password
			studentSignInPage.getEleUserNameTextField().clear();
			studentSignInPage.getElePasswordTextFiled().clear();
			studentSignInPage.Login(sData[1],sData[6]);
			studentSignInPage.elementStatus(studentSignInPage.getElePwdErrMsg(),"'Incorrect username or password.' Error Message ","displayed");
			// Verify Admin login with invalid username and invalid Password
			studentSignInPage.getEleUserNameTextField().clear();
			studentSignInPage.getElePasswordTextFiled().clear();
			studentSignInPage.Login(sData[5],sData[6]);
			studentSignInPage.elementStatus(studentSignInPage.getElePwdErrMsg(),"'Incorrect username or password.' Error Message ","displayed");
			// Verify Admin login with valid credentials
			studentSignInPage.getEleUserNameTextField().clear();
			studentSignInPage.getElePasswordTextFiled().clear();
			Thread.sleep(2000);
			studentSignInPage.Login(sData[1],sData[2]);
			Thread.sleep(4000);
			studentSignInPage.elementStatus(adminHomePage.getEleEnglishEdgeLogo(),"English Edge logo in Admin Home ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleVersionCode(),"Version Code in Home Page ","displayed");
			NXGReports.addStep("Version Code is "+adminHomePage.getEleVersionCode().getText(),LogAs.PASSED, null);
			studentSignInPage.elementStatus(adminHomePage.getEleHomeIcon()," Home icon ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleHomeText(),"Home text ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleLicenseUpdateIcon(),"License Update icon ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleLicenseUpdateText(),"License Update text ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleCreateBatchIcon(),"Create batch icon ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleCreateBatchText(),"Create batch text ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleBatchReportIcon(),"Batch report icon ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleBatchReportText(),"Batch report text ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleStudentUploadIcon(),"Student upload icon ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleStudentUploadText(),"Student upload text ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleNotificationsIcn(),"Notifications icon ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleNotificationsTxt(),"Notifications text ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleResourcesIcon(),"Resources icon ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleResourcesText(),"Resources text ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleSignOutIcon(),"Sign out icon ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleSignOutText(),"Sign out text ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleWelcomeUserNameText(),"Welcome! user name text ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleNameTxt(),"User Name Text in Admin Home page ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleCenterNameTxt(),"Center Name in Admin Home page ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleEmailIdTxt(),"Email Id Text ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleMobileNumTxt(),"Mobile Number Text ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleLastLoginDate(),"Last Login Date text ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleLastSyncDate(),"Last Sync text ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleLicenseExpiryDate(),"License Expiry text ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleAccUrl(),"Access Url ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleCourseSection(),"Course Section ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleBatchSection(),"Batch Section ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleTeacherSection(),"Teacher Section ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleStudentSection(),"Student Section ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleCoursesCount(),"Course Count ","displayed");
			NXGReports.addStep("Total Number of courses :"+adminHomePage.getEleCoursesCount().getText(),LogAs.PASSED, null);
			studentSignInPage.elementStatus(adminHomePage.getEleBatchesCount(),"Batch Count ","displayed");
			NXGReports.addStep("Total Number of Batches :"+adminHomePage.getEleBatchesCount().getText(),LogAs.PASSED, null);
			studentSignInPage.elementStatus(adminHomePage.getEleTeachersCount(),"Teacher Count ","displayed");
			NXGReports.addStep("Total Number of Teachers :"+adminHomePage.getEleTeachersCount().getText(),LogAs.PASSED, null);
			studentSignInPage.elementStatus(adminHomePage.getEleStudentsCount(),"Student Count ","displayed");
			NXGReports.addStep("Total Number of Students :"+adminHomePage.getEleStudentsCount().getText(),LogAs.PASSED, null);
			studentSignInPage.elementStatus(adminHomePage.getEleChart(),"Chart in Admin Home page ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleParagraph1Text(),"Paragraph1 in  Admin Home page ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleParagraph2Text(),"Paragraph2 in Admin Home page ","displayed");
			studentSignInPage.elementStatus(studentSignInPage.getEleCopyRights(),"Copy Rights and 'Liqvid English Edge Pvt. Ltd.' ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleAdminNameInDropdown(),"Admin Name in Drop down of Home page ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleDropDownIcn(),"Dropdown icon in Home page  ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleNotificationicon(),"Notification icon in  Home page ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleNotificationCount(),"Notification count in Home page  ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleProfileImage(),"Profile Image in Home page ","displayed");
			studentSignInPage.elementStatus(adminHomePage.getEleHeaderProfileImage(),"Profile Image in header part of Home page ","displayed");
		} catch(Exception e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* 
	 * @Description: Display of Elements after selecting Class drop down, after selecting section from drop down, after selecting section to drop down
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=2,enabled=false,description="Display of Elements after selecting Class drop down, after selecting section from drop down, after selecting section to drop down")
	public void testVerifyCreateBatchPageElements(String browser) throws Throwable{	
	studentSignInPage=new StudentSignInPage(driver);
	adminHomePage=new AdminHomePage(driver);
	createbatchpo=new CreateBatchPage(driver);
	sTestData="AdminLogin_01";
	sData=GenericLib.toReadExcelData(sTestData);
	try {
		loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
		Thread.sleep(2000);
		studentSignInPage.Login(sData[1],sData[2]);
		Thread.sleep(12000);
		studentSignInPage.elementStatus(adminHomePage.getEleCreateBatchText(),"Create batch text ","displayed");
		adminHomePage.getEleCreateBatchText().click();
		Thread.sleep(4000);
		studentSignInPage.elementStatus(createbatchpo.getEleCreateBatchTitle(),"Create Batch text in Create page ","displayed");
		studentSignInPage.elementStatus(createbatchpo.getEleClassSection(),"'Class' Section in Create page ","displayed");
		studentSignInPage.elementStatus(createbatchpo.getEleSectionFrom(),"'Section from' Section in Create page ","displayed");
		studentSignInPage.elementStatus(createbatchpo.getEleSectionTo(),"'Section To'Section in Create page ","displayed");
		// Verify the elements in 'class' Drop Down
		for(int i=0;i<=adminHomePage.getsize(createbatchpo.getEleClassDropDown1())-1;i++){
		adminHomePage.selectbyindexvalue(createbatchpo.getEleClassDropDown1(), i);
		Select select=new Select(createbatchpo.getEleClassDropDown1());
		String dropdownElements=select.getOptions().get(i).getText();
		NXGReports.addStep("Options in 'Class' dropdown : "+dropdownElements,LogAs.PASSED, null);
		}
		// Verify the elements in 'section from' Drop Down 
		for(int i=0;i<=adminHomePage.getsize(createbatchpo.getEleSectionFromDropDown1())-1;i++){
		adminHomePage.selectbyindexvalue(createbatchpo.getEleSectionFromDropDown1(), i);
		Select select=new Select(createbatchpo.getEleSectionFromDropDown1());
		String dropdownElements=select.getOptions().get(i).getText();
		NXGReports.addStep("Options in 'Section from' dropdown : "+dropdownElements,LogAs.PASSED, null);
		}	
		// Verify the elements in 'section to' Drop Down 
		for(int i=0;i<=adminHomePage.getsize(createbatchpo.getEleSectionToDropDown1())-1;i++){
		adminHomePage.selectbyindexvalue(createbatchpo.getEleSectionToDropDown1(), i);
		Select select=new Select(createbatchpo.getEleSectionToDropDown1());
		String dropdownElements=select.getOptions().get(i).getText();
		NXGReports.addStep("Options in 'Section To' dropdown : "+dropdownElements,LogAs.PASSED, null);
		}	
		studentSignInPage.elementStatus(createbatchpo.getEleAddButton(),"'Add' button  in Create page ","displayed");
		studentSignInPage.elementStatus(createbatchpo.getEleCreateButton(),"Create Button in Create page ","displayed");
		Thread.sleep(3000);
	} catch(Exception e)
	{
		NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
	}
}
	/* 
	 * @Description: Display of Elements in 'CreateBatch' after clicking on 'add' button, Display of Elements in 'CreateBatch' page after clicking on 'remove' button
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=3,enabled=false,description="Display of Elements in 'CreateBatch' after clicking on 'add' button, Display of Elements in 'CreateBatch' page after clicking on 'remove' button")
	public void testVerifyBatchSections(String browser) throws Throwable{
	studentSignInPage=new StudentSignInPage(driver);
	adminHomePage=new AdminHomePage(driver);
	createbatchpo=new CreateBatchPage(driver);
	sTestData="AdminLogin_01";
	sData=GenericLib.toReadExcelData(sTestData);
	int classSectionCount=1;
	try {
		loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
		Thread.sleep(2000);
		studentSignInPage.Login(sData[1],sData[2]);
		Thread.sleep(10000);
		studentSignInPage.elementStatus(adminHomePage.getEleCreateBatchText(),"Create batch text ","displayed");
		adminHomePage.getEleCreateBatchText().click();
		Thread.sleep(2000);
		studentSignInPage.elementStatus(createbatchpo.getEleAddButton(),"'Add' button  in Create page ","displayed");
		// To verify the functionality of 'Add' button
		for(int i=0;i<=5;i++){
			createbatchpo.getEleAddButton().click();
			classSectionCount=classSectionCount+1;
			Thread.sleep(1000);
		}		
		studentSignInPage.elementStatus(createbatchpo.getEleRemoveButton(),"Remove Button  in Create page ","displayed");
		Thread.sleep(4000);
		// To verify the functionality of 'Remove' button
		for(int i=0;i<=5;i++){
			createbatchpo.getEleRemoveButton().click();
			classSectionCount=classSectionCount-1;		
			Thread.sleep(2000);
		}		
		Thread.sleep(2000);
		//Verify the No of class,Section from and Section dropdowns. 
		if(classSectionCount==createbatchpo.getEleCountofClassSections().size()){
			NXGReports.addStep("'Add' and 'Remove' buttons are working properly.", LogAs.PASSED, null);
		}
		else{
			NXGReports.addStep("'Add' and 'Remove'  buttons are not working properly.", LogAs.FAILED, null);
		}
	} catch(Exception e)
	{
		NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
	}
}
	/* 
	 * @Description: Display of Elements in 'Batch Report' Page without selecting any options
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=4,enabled=true,description="Display of Elements in 'Batch Report' Page without selecting any options, Verify the Batch Report by selecting 'Class', 'Section' and 'Type'.")
	public void testVerifyElementsBatchReportPage(String browser) throws Throwable{		
	studentSignInPage=new StudentSignInPage(driver);
	adminHomePage=new AdminHomePage(driver);
	adminbatchreportpo =new AdminBatchReportPage(driver);
	sTestData="AdminLogin_01";
	sData=GenericLib.toReadExcelData(sTestData);
	try {
		loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
		Thread.sleep(2000);
		studentSignInPage.Login(sData[1],sData[2]);
		Thread.sleep(20000);
		studentSignInPage.elementStatus(adminHomePage.getEleBatchReportText(),"'Batch Report' text ","displayed");
		adminHomePage.getEleBatchReportText().click();
		Thread.sleep(4000);
		studentSignInPage.elementStatus(adminbatchreportpo.getEleBatchReportTxt(),"'Batch Report' title ","displayed");
		studentSignInPage.elementStatus(adminbatchreportpo.getEleClassSelectDropdown(),"Class Dropdown in 'Batch Report'","displayed");
		studentSignInPage.elementStatus(adminbatchreportpo.getEleSectionSelectDropdown(),"Section Dropdown in 'Batch Report'","displayed");
		studentSignInPage.elementStatus(adminbatchreportpo.getEleUsertypeSelectDropdown(),"User Type Dropdown in 'Batch Report'","displayed");
		studentSignInPage.elementStatus(adminbatchreportpo.getEleSubmitButton(),"Submit button  in 'Batch Report'","displayed");
		// To verify Error message 'This value is required.'
		adminbatchreportpo.getEleSubmitButton().click();
		studentSignInPage.elementStatus(adminbatchreportpo.getEleSubmitButton(),"Submit button  in 'Batch Report'","displayed");
		for(WebElement valuerequirederrormessage:adminbatchreportpo.getEleValueRequiredErrMsg())
		{
			studentSignInPage.elementStatus(valuerequirederrormessage,"Error message 'This value is required.'", "displayed");
		}	
		Thread.sleep(4000);
		// To Select class, Section and user type
		adminHomePage.selectbyindexvalue(adminbatchreportpo.getEleClassSelectDropdown(), 1);
		adminHomePage.selectbyvisibletext(adminbatchreportpo.getEleSectionSelectDropdown(), "1");
		adminHomePage.selectbyvisibletext(adminbatchreportpo.getEleUsertypeSelectDropdown(), "Student");
		Thread.sleep(2000);
		//System.out.println(adminbatchreportpo.getEleErrmsgForIncorrectDetails());
		adminbatchreportpo.getEleSubmitButton().click();
		Thread.sleep(2000);
		if(adminbatchreportpo.getEleBatchReportTable().isDisplayed()==true){
		//Verifying the Batch report table
		studentSignInPage.elementStatus(adminbatchreportpo.getEleBatchReportTable(),"Batch report table in 'Batch Report'","displayed");
		// Verifying the details based on selection
		studentSignInPage.elementStatus(adminbatchreportpo.getEleNametext(),"'Name' text in 'Batch Report'","displayed");
		studentSignInPage.elementStatus(adminbatchreportpo.getEleLoginIDtext(),"'Login ID' in 'Batch Report'","displayed");	
		studentSignInPage.elementStatus(adminbatchreportpo.getElePasswordText(),"'Password'  in 'Batch Report'","displayed");
		studentSignInPage.elementStatus(adminbatchreportpo.getEleFirstRowName(),"First row name in 'Batch Report'","displayed");
		studentSignInPage.elementStatus(adminbatchreportpo.getEleFirstRowLoginId(),"First row login id in 'Batch Report'","displayed");
		studentSignInPage.elementStatus(adminbatchreportpo.getEleFirstRowPassword(),"First row password in 'Batch Report'","displayed");
		studentSignInPage.elementStatus(adminbatchreportpo.getEleSecondRowName(),"Second row name in 'Batch Report'","displayed");
		studentSignInPage.elementStatus(adminbatchreportpo.getEleSecondRowLoginId(),"Second row login id in 'Batch Report'","displayed");
		studentSignInPage.elementStatus(adminbatchreportpo.getEleSecondRowPassword(),"Second row password in 'Batch Report'","displayed");
		Thread.sleep(2000);
		System.out.println(adminbatchreportpo.getEleErrmsgForIncorrectDetails().getText());
		}
	}
	catch(Exception e)
	{
		NXGReports.addStep("There are no users for given inputs.Try Again", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
	}
}
	/* 
	 * @Description: Display of Elements in 'Student Upload' Page
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=5,enabled=false,description="Display of Elements in 'Student Upload' Page")
	public void testVerifyElementsStudentUpload(String browser) throws Throwable{	
	studentSignInPage=new StudentSignInPage(driver);
	adminHomePage=new AdminHomePage(driver);
	studentUploadPage=new StudentUploadPage(driver);
	sTestData="AdminLogin_01";
	sData=GenericLib.toReadExcelData(sTestData);
	try {
		loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
		Thread.sleep(2000);
		studentSignInPage.Login(sData[1],sData[2]);
		Thread.sleep(20000);
		studentSignInPage.elementStatus(adminHomePage.getEleStudentUploadText(),"'Student Bulk upload' text ","displayed");
		adminHomePage.getEleStudentUploadText().click();
		Thread.sleep(2000);
		studentSignInPage.elementStatus(studentUploadPage.getEleStudentBulkUploadTitle(),"'Student Bulk Upload' Title ","displayed");
		studentSignInPage.elementStatus(studentUploadPage.getEleClassDropdown(),"Select Class Dropdown in 'Student Upload' Page ","displayed");
		studentSignInPage.elementStatus(studentUploadPage.getEleUploadButton(),"Upload Button in 'Student Upload' Page ","displayed");
		studentSignInPage.elementStatus(studentUploadPage.getEleSampleUploadFile(),"Sample dat Upload File link in 'Student Upload' Page ","displayed");
		studentSignInPage.elementStatus(studentUploadPage.getEleSubmitBtn(),"Submit button in 'Student Upload' Page ","displayed");
		studentUploadPage.getEleSubmitBtn().click();
		studentSignInPage.elementStatus(studentUploadPage.getEleValueReqErrMsg(),"Value required Error Message in 'Student Upload' Page ","displayed");
		studentUploadPage.getEleSampleUploadFile().click();
		Thread.sleep(2000);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		adminHomePage.selectbyindexvalue(studentUploadPage.getEleClassDropdown(),1);
		Thread.sleep(1000);
		adminHomePage.selectbyindexvalue(studentUploadPage.getEleSectionDropdown(),2);
		Thread.sleep(2000);
		studentUploadPage.getEleUploadButton().sendKeys(GenericLib.rDirPath+"\\testdata\\testdata.txt");
		studentUploadPage.getEleSubmitBtn().click();
		Thread.sleep(4000);
		NXGReports.addStep(studentUploadPage.getEleErrMsgInAlert().getText()+"is displayed", LogAs.PASSED, null);
		studentUploadPage.getEleAlertCloseIcn().click();
	Thread.sleep(2000);
	} catch(Exception e)
	{
		NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
	}
	}
	/* 
	 * @Description: Display of Elements in 'Resources' Page
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=6,enabled=false,description="Display of Elements in 'Resources' Page")
	public void testVerifyElementsResources(String browser) throws Throwable{	
	studentSignInPage=new StudentSignInPage(driver);
	adminHomePage=new AdminHomePage(driver);
	resourcespo=new ResourcesPage(driver);
	sTestData="AdminLogin_01";
	sData=GenericLib.toReadExcelData(sTestData);
	try {
		loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
		Thread.sleep(2000);
		studentSignInPage.Login(sData[1],sData[2]);
		Thread.sleep(20000);
		studentSignInPage.elementStatus(adminHomePage.getEleResourcesText(),"'Batch Report' text ","displayed");
		adminHomePage.getEleResourcesText().click();
		Thread.sleep(4000);
		studentSignInPage.elementStatus(resourcespo.getEleResourcesTitle(),"'Resources' Title ","displayed");
		studentSignInPage.elementStatus(resourcespo.getEleTechnicalManualButton(),"'Technical Manual' Button ","displayed");
		studentSignInPage.elementStatus(resourcespo.getEleHelpManualImage(),"Help Manual Image ","displayed");
	} catch(Exception e)
	{
		NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
	}
	}
	/* 
	 * @Description: Display of elements in Teachers Registration page
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=7,enabled=true,description="Display of elements in Teachers Registration page")
	public void testVerifyTeachersregistration(String browser) throws Throwable{	
	studentSignInPage=new StudentSignInPage(driver);
	adminHomePage=new AdminHomePage(driver);
	teacherregistrationpo=new TeacherRegistrationPage(driver);
	sTestData="AdminLogin_01";
	sData=GenericLib.toReadExcelData(sTestData);
	try {
		loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
		studentSignInPage.getEleRegisterBtn().click();
		Thread.sleep(2000);
		studentSignInPage.getEleTeacherRadioBtn().click();
		Thread.sleep(2000);	
		studentSignInPage.elementStatus(teacherregistrationpo.getEleTeacherTab(),"'Teacher' Tab ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleRegisterInstructionText(),"'First-time user, register here.' instruction  ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleFirstNametext(),"'First Name' text ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleLastNameText(),"'Last Name' text ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleEmailIdText(),"'EmailId' text ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleMobileNumText(),"'Mobile Number' text ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleDobText(),"'Date Of Birth' text ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleGenderText(),"'Gender' text ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getElePasswordText(),"'Password' text ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleConfirmPasswordText(),"'Confirm Password' text ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleSelectClassText(),"'Select Class' text ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleSelectSectionText(),"'Select Section' text ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getNoteText(),"'Note ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleCopyRightsText(),"CopyRights ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getCodeVersionDateText(),"Code Version Date text ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleWebLink(),"'Liqvid English Edge Pvt. Ltd.' Link ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleFirstName(),"'First Name' text Field ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getElelastName(),"'Last Name' text Field ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleEmailId(),"'EmailId' text ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleMobileNum(),"'Mobile Number' text Field ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleDobField(),"'Date Of Birth' text Field ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleGenderSelect(),"'Gender Select' text Field ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getElePassword(),"'Password' text Field ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleConfirmPassword(),"'Confirm Password' text Field ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleClassSelectDropdown1(),"'Class Select' Dropdown text Field ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleSectionSelectDropdown1(),"'Section Select' Dropdown text Field ","displayed");
		studentSignInPage.elementStatus(teacherregistrationpo.getEleBackLink(),"'Back' link ","displayed");
		teacherregistrationpo.getEleBackLink().click();
		Thread.sleep(5000);
	} catch(Exception e)
	{
		NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
	}
	}
	/* 
	 * @Description: Display of elements in Student Registration page
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=9,enabled=true,description="Display of elements in Student Registration page")
	public void testVerifyStudentregistration(String browser) throws Throwable{	
	studentSignInPage=new StudentSignInPage(driver);
	adminHomePage=new AdminHomePage(driver);
	studentregisterationpo= new StudentRegistrationPage(driver);
	sTestData="AdminLogin_01";
	sData=GenericLib.toReadExcelData(sTestData);
	try {
		loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
		studentSignInPage.getEleRegisterBtn().click();
		Thread.sleep(2000);
		studentSignInPage.getEleStudentRadioBtn().click();
		Thread.sleep(2000);	
		studentSignInPage.elementStatus(studentregisterationpo.getEleStudentTab(),"'Student' Tab   ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleFirstNametext(),"'First Name' text ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleLastNameText(),"'Last Name' text ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleEmailIdText(),"'EmailId' text ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleMobileNumText(),"'Mobile Number' text ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleDobText(),"'Date Of Birth' text ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleGenderText(),"'Gender' text ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getElePasswordText(),"'Password' text ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleConfirmPasswordText(),"'Confirm Password' text ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleSelectClassText(),"'Select Class' text ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleSelectSectionText(),"'Select Section' text ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getNoteText(),"'Note ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleCopyRightsText(),"CopyRights ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getCodeVersionDateText(),"Code Version Date text ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleWebLink(),"'Liqvid English Edge Pvt. Ltd.' Link ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleFirstName(),"'First Name' text Field ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getElelastName(),"'Last Name' text Field ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleEmailId(),"'EmailId' text ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleMobileNum(),"'Mobile Number' text Field ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleDobField(),"'Date Of Birth' text Field ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleGenderSelect(),"'Gender Select' text Field ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getElePassword(),"'Password' text Field ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleConfirmPassword(),"'Confirm Password' text Field ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleClassSelectDropdown(),"'Class Select' Dropdown text Field ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleSectionSelectDropdown(),"'Section Select' Dropdown text Field ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleSignUpButt(),"'SignUp' Button ","displayed");
		studentregisterationpo.getEleSignUpButt().click();
		Thread.sleep(1000);
		studentSignInPage.elementStatus(studentregisterationpo.getEleValueReqErrMsg(),"'This value is required.' error message ","displayed");
		studentSignInPage.elementStatus(studentregisterationpo.getEleBackLink(),"'Back' link ","displayed");
		studentregisterationpo.getEleBackLink().click();
		Thread.sleep(5000);
	} catch(Exception e)
	{
		NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
	}
	}
	/* 
	 * @Description: Display of elements in 'Profile' Page after clicking on 'Change password'
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=10,enabled=false,description="Display of elements in 'Profile' Page after clicking on 'Change password'")
	public void testVerifyAdminProfilePageElements(String browser) throws Throwable{	
	studentSignInPage=new StudentSignInPage(driver);
	adminHomePage=new AdminHomePage(driver);
	adminprofilepagepo=new AdminProfilePage(driver);
	sTestData="AdminLogin_01";
	sData=GenericLib.toReadExcelData(sTestData);
	try {
		loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
		Thread.sleep(2000);
		studentSignInPage.Login(sData[1],sData[2]);
		Thread.sleep(5000);
		adminHomePage.getEleHomeText().click();
		Thread.sleep(3000);
		adminHomePage.getEleDropDownIcn().click();
		Thread.sleep(3000);
		studentSignInPage.elementStatus(adminHomePage.getEleProfileOption(),"'Profile' option in Dropdown ","displayed");
		studentSignInPage.elementStatus(adminHomePage.getEleSignOutOption(),"'SignOut' option in Dropdown ","displayed");
		adminHomePage.getEleProfileOption().click();
		Thread.sleep(3000);
		studentSignInPage.elementStatus(adminprofilepagepo.getEleProfileTxt(),"'Profile' text ","displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getEleFirstNameTxt(),"'First Name' text ","displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getEleLastNameTxt(), "'Last name' text", "displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getEleEmailIdTxt(),"'Email ID' text ","displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getElePhoneTxt(), "'Phone' text", "displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getEleDobText(), "'Date Of Birth' text", "displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getGenderText(),"'Gender' text ","displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getElePlusIcon(),"'Plus' Icon in 'change password' button ","displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getEleChangePasswordButton(), "'Phone' text", "displayed");
		adminprofilepagepo.getEleChangePasswordButton().click();
		studentSignInPage.elementStatus(adminprofilepagepo.getEleMinusIcon(),"'Minus' Icon in 'change password' button ","displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getEleOldPwdText(), "'Old Password' text", "displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getEleNewPwdText(),"'New Password' text ","displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getEleConNewPwdText(), "'Confirm New Password' text", "displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getEleFirstNameTxtFld(),"'First Name' text field","displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getEleLastNameTxtFld(), "'Last name' text field", "displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getEleEmailIdTxtFld(),"'Email ID' field ","displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getElePhoneTextBox(), "'Phone' field", "displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getEleDobTextbox(), "'Date Of Birth' field", "displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getEleSelGender(),"'Gender' field ","displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getEleChangePasswordButton(), "'Phone' field", "displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getEleOldPwdTextBox(), "'Old Password' field", "displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getEleNewPwdTextBox(),"'New Password' field ","displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getEleConNewPwdTextBox(), "'Confirm New Password' field", "displayed");
		studentSignInPage.elementStatus(adminprofilepagepo.getUpdateButton(), "'Update' button", "displayed");
	} catch(Exception e)
	{
		NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
	}
	}
	/* 
	 * @Description: Verify the elements in Forgot Password page
	 * @Author:Navakanth
	 */
	@Parameters("browser")
	@Test(priority=11,enabled=false,description="Verify the elements in Forgot Password page")
	public void testVerifyGraph(String browser) throws Throwable{	
	studentSignInPage=new StudentSignInPage(driver);
	adminHomePage=new AdminHomePage(driver);
	sTestData="AdminLogin_01";
	sData=GenericLib.toReadExcelData(sTestData);
	try {
		loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "APPLICATIONURL"));
		studentSignInPage.Login(sData[1],sData[2]);
		Thread.sleep(5000);
		WebElement Teacher=driver.findElement(By.xpath("//span[text()='Teacher :']"));
		System.out.println(Teacher.getText());
		WebElement graph=driver.findElement(By.xpath("//div[@class='canvasjs-chart-tooltip']//span"));
		studentSignInPage.ScrollToViewElement(graph);
		System.out.println(graph.getText());
	} catch(Exception e)
	{
		NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
	}
	}
	
}
