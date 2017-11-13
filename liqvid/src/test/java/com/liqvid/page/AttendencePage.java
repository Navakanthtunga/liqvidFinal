package com.liqvid.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.liqvid.library.BaseLib;

public class AttendencePage {
	WebDriver driver = null;
	StudentSignInPage studentSignInPage=null;
	public AttendencePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h1[@class='heading displayInlineBlock']")
	private WebElement eleAttendenceTxt;
	public WebElement getEleAttendenceTxt(){
		return eleAttendenceTxt;
	}
	@FindBy(id="totalStudents")
	private WebElement eleTotalStudentsCnt;
	public WebElement getEleTotalStudentsCnt(){
		return eleTotalStudentsCnt;
	}
	@FindBy(xpath="//div[text()='Total No. of Students']")
	private WebElement eleTotalStudentsTxt;
	public WebElement getEleTotalStudentsTxt(){
		return eleTotalStudentsTxt;
	}
	@FindBy(id="absentStudents")
	private WebElement eleAbsentStudentCnt;
	public WebElement getEleAbsentStudentCnt(){
		return eleAbsentStudentCnt;
	}
	@FindBy(xpath="//div[text()='No. of Students Absent']")
	private WebElement eleNumberOfStudentsABTxt;
	public WebElement getEleNumberOfStudentsABTxt(){
		return eleNumberOfStudentsABTxt;
	}
	@FindBy(xpath="//p[@class='attendanceheadinPara']")
	private WebElement eleAttendenceInstructionTxt;
	public WebElement getEleAttendenceInstructionTxt(){
		return eleAttendenceInstructionTxt;
	}
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement eleSubmitBtn;
	public WebElement getEleSubmitBtn(){
		return eleSubmitBtn;
	}
	@FindBy(xpath="//p[contains(text(),'All students are present in the class.')]")
	private WebElement eleAllStudentsPresentMsg;
	public WebElement getEleAllStudentsPresentMsg(){
		return eleAllStudentsPresentMsg;
	}//button[@class='close closeCustom']
	@FindBy(id="att-submit")
	private WebElement eleContinueBtn;
	public WebElement getEleContinueBtn(){
		return eleContinueBtn;
	}
	@FindBy(xpath="//button[@class='close closeCustom']")
	private WebElement eleCloseIcn;
	public WebElement getEleCloseIcn(){
		return eleCloseIcn;
	}
	@FindBy(xpath="//p[@class='text-center st-absent-text st-absent-text att-abs att-abs-some att-abs-all']")
	private WebElement eleRemoveStudentInstructionTxt;
	public WebElement getEleRemoveStudentInstructionTxt(){
		return eleRemoveStudentInstructionTxt;
	}
	@FindBy(xpath="//p[contains(text(),'All students are absent in the class.')]")
	private WebElement eleAllStudentAbsentMsg;
	public WebElement getEleAllStudentAbsentMsg(){
		return eleAllStudentAbsentMsg;
	}

	public void allStudentPresent() throws Throwable{
		int abCnt= 0;
		List<WebElement> students=driver.findElements(By.xpath("//li[contains(@id,'st_')]"));
		for(int i=1;i<=students.size();i++){
			WebElement element=driver.findElement(By.xpath("//li[contains(@id,'st_')]["+i+"]"));
			element.click();
			abCnt=abCnt+1;
			Thread.sleep(1000);
					if(abCnt==1){
						NXGReports.addStep("Count is increasing by +1", LogAs.PASSED, null);
						
					}
					else{
						NXGReports.addStep("Count is not increasing by +1", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						
					}
						
						if(driver.findElement(By.xpath("//li[contains(@id,'st_')]["+i+"]//i[@class='fa fa-user fa-user-times']")).isDisplayed()==true){
							NXGReports.addStep("Absent icon is displayed", LogAs.PASSED, null);
						}
						else
							NXGReports.addStep("Absent icon is not displayed", LogAs.PASSED, null);
			element.click();
			abCnt=abCnt-1;
					if(abCnt==0){
						NXGReports.addStep("Count is decreasing by +1", LogAs.PASSED, null);
					}
					else{
						NXGReports.addStep("Count is not decreasing by +1", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					
						if(driver.findElement(By.xpath("//li[contains(@id,'st_')]["+i+"]//i[@class='fa fa-user']")).isDisplayed()==true){
							NXGReports.addStep("Present icon is displayed", LogAs.PASSED, null);
						}
						else
							NXGReports.addStep("Present icon is not displayed", LogAs.PASSED, null);
		}
	}
	public void allStudentAbsent() throws Throwable{

		List<WebElement> students=driver.findElements(By.xpath("//li[contains(@id,'st_')]"));
		for(int i=1;i<=students.size();i++){
			WebElement element=driver.findElement(By.xpath("//li[contains(@id,'st_')]["+i+"]"));
			element.click();
			Thread.sleep(1000);
		}
	}
	public void verifyStudentPresence(int absCnt){
		List<WebElement> studentsInAttendenceConfirmationPage=driver.findElements(By.xpath("//li[contains(@id,'st_')]//a//i"));
		
		if (absCnt==studentsInAttendenceConfirmationPage.size()) {
			NXGReports.addStep("All the students are appeared in Student attendence confirmation page", LogAs.PASSED, null);
		}
		else{
			NXGReports.addStep("All the students are not appeared in Student attendence confirmation page", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
	public void removeStudent() throws Throwable  {
		List<WebElement> students=driver.findElements(By.xpath("//li[contains(@id,'st_')]//a//i"));
		for(int i=students.size();i>=1;i--){
			WebElement element=driver.findElement(By.xpath("(//li[contains(@id,'st_')]//a//i)["+i+"]"));
			element.click();
			Thread.sleep(1000);
		}
		
	}
}
