package com.liqvid.page;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitAudioContext;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.liqvid.library.ParallelBaseLib;

public class StudentSignInPage {
	WebDriver driver = null;
	public static int sStatusCnt=0;
	public StudentSignInPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		// To identify the web element -- Logo
		@FindBy(xpath="//section[@class='main-votex']//img")
		private WebElement eleLogo;
		public WebElement getEleLogo(){
			return eleLogo;
		}
		// To identify the 'Sign in' text
		@FindBy(xpath="//p[@class='student-title']")
		private WebElement eleSignInText;
		public WebElement getEleSignInText(){
		return eleSignInText;
		}
		// To identify instructions text in 'Sign in' page
		@FindBy(xpath="//p[contains(text(),'Please register and login with your username and password.')]")
		private WebElement eleSignInInstrText;
		public WebElement getEleSignInInstrText(){
			return eleSignInInstrText;
		}
		// To identify 'Username' text 
		@FindBy(xpath="//label[contains(text(),'Username ')]")
		private WebElement eleUserNameText;
		public WebElement getEleUserNameText(){
			return eleUserNameText;
		}
		// To identify the web element 'UserName' text field
		@FindBy(id="LoginForm_username")
		private WebElement eleUserNameTextField;
		public WebElement getEleUserNameTextField(){
			return eleUserNameTextField;
		}
		// To identify 'Password' text in 'Sign In' page
		@FindBy(xpath="//label[contains(text(),'Password')]")
		private WebElement elePwdText;
		public WebElement getElePwdText(){
			return elePwdText;
		}
		//To identify the web element 'Password' text field
		@FindBy(id="LoginForm_password")
		private WebElement elePasswordTextFiled;
		public WebElement getElePasswordTextFiled(){
			return elePasswordTextFiled;			
		}
		// To identify Web element 'Sign In' button
		@FindBy(xpath="//input[contains(@type,'submit')]")
		private WebElement  eleSignInBtn;
		public WebElement getEleSignInBtn(){
			return eleSignInBtn;
		}
		// To identify the 'Error Message' displaying at 'UserName' text box
		@FindBy(id="LoginForm_username_em_")
		private WebElement eleUserNameErrMsg;
		public WebElement getEleUserNameErrMsg(){
			return eleUserNameErrMsg;
		}
		//To identify 'Incorrect username or password.' Error message
		@FindBy(id="LoginForm_password_em_")
		private WebElement elePwdErrMsg;
		public WebElement getElePwdErrMsg(){
			return elePwdErrMsg;
		}
		// To identify the web element 'Forgot password' link
		@FindBy(xpath="//small[contains(text(),'Forgot password')]")
		private WebElement eleForgotPwdLink;
		public WebElement getEleForgotPwdLink(){
			return eleForgotPwdLink;
		}
		// To identify instruction text to register
		@FindBy(xpath="//p[contains(text(),'First-time user, register here.')]")
		private WebElement eleRegisterInstrText;
		public WebElement getEleRegisterInstrText(){
			return eleRegisterInstrText;
		}	
		@FindBy(xpath="//h3[text()='English Edge Assessments']")
		private WebElement eleEnglishEdgeText;
		public WebElement getEleEnglishEdgeText(){
			return eleEnglishEdgeText;
		}
		//To identify the Registration Button in Sign In button 
		@FindBy(xpath="//small[contains(text(),'Registration')]")
		private WebElement eleRegisterBtn;
		public WebElement getEleRegisterBtn(){
			return eleRegisterBtn;
		}	
		//To identify No batches were found. Kindly login to Admin Panel and first create batches text
		@FindBy(xpath="//p[@class='page-sub-heading']")
		private WebElement eleBatchesMsg;
		public WebElement getEleBatchesMsg(){
			return eleBatchesMsg;
		}
		//To identify Back button
		@FindBy(xpath="//a[text()='Back']")
		private WebElement eleBackBtn;
		public WebElement getEleBackBtn(){
			return eleBackBtn;
		}
		//To identify the error message for old password in sign in page
		@FindBy(id="LoginForm_password_em_")
		private WebElement eleIncorrectUserPwd;
		public WebElement getEleIncorrectUserPwd(){
			return eleIncorrectUserPwd;
		}
		//To identify 'Liqvid English Edge Pvt. Ltd.' link
		@FindBy(xpath="//div[@id='footer-terms']//a[contains(text(),'Liqvid English Edge Pvt. Ltd.')]")
		private WebElement eleEnglishEdgeWebLink;
		public WebElement getEleEnglishEdgeWebLink(){
			return eleEnglishEdgeWebLink;
		}
		//To identify the Copy Rights 
		@FindBy(id="footer-terms")
		private WebElement eleCopyRights;
		public WebElement getEleCopyRights(){
			return eleCopyRights;
		}
		//To identify the bulid version in sign in page
		@FindBy(id="footer-copyright")
		private WebElement eleCodeVersionDateText;
		public WebElement getEleCodeVersionDateText(){
			return eleCodeVersionDateText;
		}	

		//To identify instruction text to Forgot password
		@FindBy(xpath="//p[contains(text(),'To retrieve Admin password please')]")
		WebElement eleAdminForgotPasswordInstrTxt;
		public WebElement getEleAdminForgotPasswordInstrTxt(){
			return eleAdminForgotPasswordInstrTxt;
		}	
		//To identify Click Here link
		@FindBy(xpath="//u[contains(text(),'Click Here')]")
		WebElement eleClickHereLnk;
		public WebElement getEleClickHereLnk(){
			return eleClickHereLnk;
		}
		//To identify Admin Reset password text
		@FindBy(xpath="//h1[contains(text(),'Welcome to Admin password reset console')]")
		WebElement eleAdminPasswordResetTxt;
		public WebElement getEleAdminPasswordResetTxt(){
			return eleAdminPasswordResetTxt;
		}	
		//To identify LoginId textfield for reset admin password
		@FindBy(xpath="//input[@id='center_code']")
		WebElement eleLoginIDTxtFld;
		public WebElement getEleLoginIDTxtFld(){
			return eleLoginIDTxtFld;
		}
		//To identify Submit button
		@FindBy(xpath="//form[@id='adminPassForm']//button[contains(text(),'Submit')]")
		WebElement eleSubmitBtn;
		public WebElement getEleSubmitBtn(){
			return eleSubmitBtn;
		}	
		//To identify Confirmation message for admin reset password
		@FindBy(xpath="//div[@class='alert alert-success']")
		WebElement eleConfirmationText;
		public WebElement getEleConfirmationText(){
			return eleConfirmationText;
		}
		//To identify error message on in valid admin emailID
		@FindBy(xpath="//li[contains(text(),'This value should be a valid email.')]")
		WebElement eleErrorText;
		public WebElement getEleErrorText(){
			return eleErrorText;
		}	
		//To identify the 'Error message' displaying at 'Password' text box
		@FindBy(id="LoginForm_password_em_")
		private WebElement elePwdErrorMessage;
		public WebElement getElePwdErrorMessage(){
			return elePwdErrorMessage;
		}
		//To identify the 'Error message' displaying for invalid mac address
		@FindBy(xpath="//span[text()='OOPS!']")
		private WebElement eleInvalidMacErrMsg;
		public WebElement getEleInvalidMacErrMsg(){
			return eleInvalidMacErrMsg;
		}
		@FindBy(xpath="//input[@type='radio'][@value='teacher']")
		private WebElement eleTeacherRadioBtn;
		public WebElement getEleTeacherRadioBtn(){
			return eleTeacherRadioBtn;
		}
		@FindBy(xpath="//input[@type='radio'][@value='student']")
		private WebElement eleStudentRadioBtn;
		public WebElement getEleStudentRadioBtn(){
			return eleStudentRadioBtn;
		}
		@FindBy(xpath="//a[text()='Back to Login']")
		private WebElement eleLoginLnk;
		public WebElement getEleLoginLnk(){
			return eleLoginLnk;
		}
		@FindBy(xpath="//h4[text()='Registration Confirmation']")
		private WebElement eleRegistartionConfirmationTxt;
		public WebElement getEleRegistartionConfirmationTxt(){
			return eleRegistartionConfirmationTxt;
		}
		@FindBy(xpath="//p[text()='Please select user role you need to register for:']")
		private WebElement eleRegistartionPopupTxt;
		public WebElement getEleRegistartionPopupTxt(){
			return eleRegistartionPopupTxt;
		}
		public void elementStatus(WebElement element, String elementName, String checkType) 
		{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		switch(checkType)
			{
				case "displayed":
					try 
				    {
				        element.isDisplayed();
				        NXGReports.addStep(elementName+ " is displayed", LogAs.PASSED, null);
				    } 
				    catch (Exception e) 
				    {
				    	ParallelBaseLib.sStatusCnt++;
				    	NXGReports.addStep(elementName+ " is not displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				    }
					break;
				case "enabled":
					try 
				    {
				        element.isEnabled();
				        NXGReports.addStep(elementName+ " is enabled", LogAs.PASSED, null);
				    } 
				    catch (Exception e) 
				    {
				    	ParallelBaseLib.sStatusCnt++;
				    	NXGReports.addStep(elementName+ " is not enabled", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				    }
					break;
				case "selected":
					try 
					{
						element.isSelected();
					    NXGReports.addStep(elementName+ " is selected", LogAs.PASSED, null);  
					} 
					catch (Exception e) 
					{
					   	ParallelBaseLib.sStatusCnt++;
					   	NXGReports.addStep(elementName+ " is not selected", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					break;
				}
		}
		public void Login(String username,String password) throws Exception{
				Thread.sleep(2000);
				elementStatus(getEleUserNameTextField(), "The Username text field","displayed");
				getEleUserNameTextField().sendKeys(username);
				elementStatus(getElePasswordTextFiled(), "The Password text field","displayed");
				getElePasswordTextFiled().sendKeys(password);
				Thread.sleep(2000);
				elementStatus(getEleSignInBtn(), "The Sign in button","displayed");
				getEleSignInBtn().click();
		}
		public void handleStartTestbutton() throws InterruptedException{
			StudentCoursePage studentcoursepo=new StudentCoursePage(driver);
			
			try{
				Thread.sleep(4000);
				studentcoursepo.getEleStartTextButton().click();
			}catch(Exception e){
				List<WebElement> objects = driver.findElements(By.xpath("//div[@id='contentAssessment']//object"));
				String objectId = objects.get(0).getAttribute("id");
				WebElement objectTag = driver.findElement(By.id(objectId));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				String text = (String) js.executeScript("return (((document.getElementById('" + objectId + "')).contentDocument).getElementsByClassName('btn btn-s-md btn-default btn-rounded')[0]).getAttribute('href')", objectTag).toString();
				System.out.println(text);
				driver.get(text);
			}
			catch(Error e){
				Assert.fail();
			}
		}
		
		public void scrolldown(){
			try{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
			}catch(Exception e){
				NXGReports.addStep("The page is not scrolldown", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}
		public void ScrollToViewElement(WebElement element){
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		}
		public void moveToElement(WebElement element){
            JavascriptExecutor js = (JavascriptExecutor) driver;
    	    String strJavaScript = "var element = arguments[0];"
    	            + "var mouseEventObj = document.createEvent('MouseEvents');"
    	            + "mouseEventObj.initEvent( 'mouseover', true, true );"
    	            + "element.dispatchEvent(mouseEventObj);";
    	    js.executeScript(strJavaScript, element); 
		}
		public void ClickByJs(WebElement element){
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();", element);

		}
	}
