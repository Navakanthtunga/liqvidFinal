package com.liqvid.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.liqvid.library.GenericLib;

public class LicensePage {
	WebDriver driver;
	ForgotPasswordPage forgotPasswordPage=null;
	StudentSignInPage studentSignInPage=null;
	String sTestData=null;
	String[] sData=null;
	public LicensePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		// To identify 'English Edge' Logo in the home page
		@FindBy(xpath="//a[@ class='navbar-brand']//img")
		private WebElement eleLogo;
		public WebElement getEleLogo(){
			return eleLogo;
		}
		//To verify 'EnglishEdge Setup' text in registration page
	  	@FindBy(xpath="//div[text()='EnglishEdge Setup']")
	    private WebElement eleEnglishEdgeSetupText;
	    public WebElement getEleEnglishEdgeSetupText()  {
	    	return eleEnglishEdgeSetupText;
	    }	
	    //To verify 'Welcome to EnglishEdge registration process' text in registration page
	    @FindBy(xpath="//h1[text()='Welcome to EnglishEdge registration process']")
	    private WebElement eleRegistrationHeading;
	    public WebElement getEleRegistrationHeading()
	    {
	    	return eleRegistrationHeading;
	    }	
	    //To verify Instructions in registration page
	    @FindBy(xpath="//div[@class='col-sm-8 col-sm-offset-2']/p")
	    private WebElement eleRegistrationInstructions;
	    public WebElement getEleRegistrationInstructions()
	    {
	    	return eleRegistrationInstructions;
	    }
	    //To verify License Key Text in registration page
	    @FindBy(xpath="//big[contains(text(),'License Key')]")
	    private WebElement eleLicenseKeyText;
	    public WebElement getEleLicenseKeyText()
	    {
	    	return eleLicenseKeyText;
	    }			      
		//To verify License Key field in registration page
	    @FindBy(id="license_key")
	    private WebElement eleLicenseKeyField;
	    public WebElement getEleLicenseKeyField()
	    {
	    	return eleLicenseKeyField;
	    }			   
	    //To verify Submit button in registration page
	    @FindBy(xpath="//button[@class='btn btn-s-md btn-primary']")
	   	private WebElement eleSubmitButton;
	    public WebElement getEleSubmitButton()
	    {
		   return eleSubmitButton;
	    }					   			
	    //To verify Customer Support text in registration page
		@FindBy(xpath="//strong[text()='Customer Support']")
		private WebElement eleCustomerSupportText;
		public WebElement getEleCustomerSupportText()
		{
		   return eleCustomerSupportText;
		}
	    //To verify Customer Care Contact details in registration page
		@FindBy(xpath="(//div[@class='footerMail'])[2]")
		private WebElement eleCustomerCareContactDetails;
		public WebElement getEleCustomerCareContactDetails()
		{
			return eleCustomerCareContactDetails;
		}	   
		//To verify  Customer Care Email Id  registration page
		@FindBy(xpath="((//div[@class='footerMail'])[2])//a")
		private WebElement eleCustomerCareEmailId;
		public WebElement getEleCustomerCareEmailId()
		{
			 return eleCustomerCareEmailId;
		}	
		// To verify English edge website link in registration page  
		@FindBy(xpath="((//div[@class='footerMail'])[3])")
		private WebElement eleEnglishEdgeWebsitelink;
		public WebElement getEleEnglishEdgeWebsitelink()
		{
			return eleEnglishEdgeWebsitelink;
		}
		// To verify Copy Right text in registration page  
		@FindBy(id="footer-terms")
		private WebElement eleCopyRightsText;
		public WebElement getEleCopyRightsText()
		{
		    return eleCopyRightsText;
		}	
		// To verify English edge website link at the Footer of registration page  
		@FindBy(xpath="//div[@id='footer-terms']//a")
		private WebElement eleEnglishEdgeWebsitelinkFooter;
		public WebElement getEleEnglishEdgeWebsitelinkFooter()
		{
			return eleEnglishEdgeWebsitelinkFooter;
		}			   
		// To verify 'This value is too short' error message in  registration page  
		@FindBy(xpath=" //li[text()='This value is too short. It should have 6 characters or more.']")
		private WebElement eleErrMsg;
		public WebElement getEleErrMsg()
		{
			return eleErrMsg;
		}	
		// To verify Alert in registration page  
		@FindBy(xpath="//div[@class='alert alert-danger col-sm-8 col-sm-offset-2']")
		private WebElement eleAlert;
		public WebElement getEleAlert()
		{
			return eleAlert;
		}	
		// To verify Close icon of alert  in registration page  
		@FindBy(xpath="//button[@ class='close']")
		private WebElement eleCloseAlert;
		public WebElement getEleCloseAlert()
		{
			return eleCloseAlert;
		}	
		// To verify 'This value is required.' Error message in registration page  
		@FindBy(xpath="//li[text()='This value is required.']")
		private WebElement eleValueReqErrMsg;
		public WebElement getEleValueReqErrMsg()
		{
			return eleValueReqErrMsg;
		}

		/* 
		 * @Description:Login to the gmail and get the password of the admin module.
		 * @Author:RaghuKiran MR
		 */
		public void LoginGmail() throws Exception
		{
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			forgotPasswordPage=new ForgotPasswordPage(driver);
		    studentSignInPage=new StudentSignInPage(driver);
		    sTestData="AdminRegistration_01";
			sData=GenericLib.toReadExcelData(sTestData);
			try
		    {
		    	forgotPasswordPage.getEleEmailIdField().sendKeys(sData[13]);
				Thread.sleep(2000);
				forgotPasswordPage.getEleNextButton().click();
				Thread.sleep(2000);
				forgotPasswordPage.getElePasswordField().sendKeys(sData[16]);
				Thread.sleep(2000);
				forgotPasswordPage.getEleSigninButton().click();
				Thread.sleep(5000);
				forgotPasswordPage.getEleMailSubjectLnk().click();
				Thread.sleep(10000);
		        String USERNAME= forgotPasswordPage.getEleUsername().getText();
				Thread.sleep(10000); 
				String CURRENTUSERNAME=USERNAME.substring(10);
				//GenericLib.setCongigValue(GenericLib.sConfigFile,"CURRENTUSERNAME",CURRENTUSERNAME);
				String PASSWORD= forgotPasswordPage.getElePassword().getText();
				Thread.sleep(10000); 
				String CURRENTPASSWORD=PASSWORD.substring(9);
				GenericLib.toWriteExcelData("AdminLogin_01", CURRENTUSERNAME, CURRENTPASSWORD);
				//GenericLib.setCongigValue(GenericLib.sConfigFile,"CURRENTPASSWORD",CURRENTPASSWORD);
		    }
		    catch(Exception e)
		    {
		    	forgotPasswordPage.getEleNewEmailIdFld().sendKeys(sData[13]);
				Thread.sleep(2000);
				forgotPasswordPage.getEleMailNxtBtn().click();
				Thread.sleep(2000);
				forgotPasswordPage.getEleNewPwdFld().sendKeys(sData[16]);
				Thread.sleep(2000);
				forgotPasswordPage.getElePwdNxtBtn().click();
				Thread.sleep(8000);
				forgotPasswordPage.getEleMailSubjectLnk().click();
				Thread.sleep(5000);
		        String USERNAME= forgotPasswordPage.getEleUsername().getText();
		  		Thread.sleep(2000); 
				System.out.println(USERNAME);
				String CURRENTUSERNAME=USERNAME.substring(10);
				//GenericLib.setCongigValue(GenericLib.sConfigFile,"CURRENTUSERNAME",CURRENTUSERNAME);
				String PASSWORD= forgotPasswordPage.getElePassword().getText();
				Thread.sleep(5000); 
				String CURRENTPASSWORD=PASSWORD.substring(9);
				//GenericLib.setCongigValue(GenericLib.sConfigFile,"CURRENTPASSWORD",CURRENTPASSWORD);
				GenericLib.toWriteExcelData("AdminLogin_01", CURRENTUSERNAME, CURRENTPASSWORD);
				/*driver.navigate().back();
				forgotPasswordPage.getEleAllMailsChBx().click();
				Thread.sleep(3000);
				forgotPasswordPage.getEleDeleteIcn().click();*/
		    }
				
		}		
}
