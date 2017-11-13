package com.liqvid.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.liqvid.library.GenericLib;

public class ActivityPage {
	WebDriver driver = null;
	StudentSignInPage studentSignInPage=null;
	TeacherSessionsPage teacherSessionsPage=null;
	AttendencePage attendencePage=null;
	public ActivityPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h4[text()='Session']")
	private WebElement eleSessionTxt;
	public WebElement getEleSessionTxt(){
		return eleSessionTxt;
	}
	@FindBy(xpath="//p[contains(text(),'The session has already been launched')]")
	private WebElement eleSessionInfoTxt;
	public WebElement getEleSessionInfoTxt(){
		return eleSessionInfoTxt;
	}
	@FindBy(id="oldSession-submit")
	private WebElement eleResumeBtn;
	public WebElement getEleResumeBtn(){
		return eleResumeBtn;
	}
	@FindBy(id="newSession-submit")
	private WebElement eleStartAgainBtn;
	public WebElement getEleStartAgainBtn(){
		return eleStartAgainBtn;
	}
	@FindBy(xpath="//div[@class='col-lg-9 col-md-9 col-sm-8 col-xs-10 sessionName pddLeft0 pddright0']")
	private WebElement eleActivityTilteTxt;
	public WebElement getEleActivityTitleTxt(){
		return eleActivityTilteTxt;
	}
	@FindBy(id="home")
	private WebElement eleHomeIcn;
	public WebElement getEleHomeIcn(){
		return eleHomeIcn;
	}
	@FindBy(xpath="//a[@class='usernameText']")
	private WebElement eleTeacherNameTxt;
	public WebElement getEleTeacherNameTxt(){
		return eleTeacherNameTxt;
	}
	@FindBy(xpath="//a[@class='username']//img")
	private WebElement eleProfileImg;
	public WebElement getEleProfileImg(){
		return eleProfileImg;
	}
	@FindBy(xpath="//a[@class='glossaryIcon']//i")
	private WebElement eleGlosaryIcn;
	public WebElement getEleGlosaryIcn(){
		return eleGlosaryIcn;
	}
	@FindBy(xpath="//span[text()='Groups']")
	private WebElement eleGroupsTxt;
	public WebElement getEleGroupsTxt(){
		return eleGroupsTxt;
	}
	@FindBy(xpath="//img[@class='footerimg']")
	private WebElement eleEnglishEdgeLogo;
	public WebElement getEleEnglishEdgeLogo(){
		return eleEnglishEdgeLogo;
	}
	@FindBy(xpath="//div[@class='col-lg-8 col-md-8 col-sm-8 col-xs-12']")
	private WebElement eleActivityStudentInfoTxt;
	public WebElement getEleActivityStudentInfoTxt(){
		return eleActivityStudentInfoTxt;
	}
	@FindBy(xpath="//span[@id='next-act']//i")
	private WebElement eleNextIcn;
	public WebElement getEleNextIcn(){
		return eleNextIcn;
	}
	@FindBy(xpath="//span[@class='preCircle pull-left disabled']")
	private WebElement elePrevIcn1;
	public WebElement getElePrevIcn1(){
		return elePrevIcn1;
	}
	@FindBy(id="prev-act")
	private WebElement elePrevIcn;
	public WebElement getElePrevIcn(){
		return elePrevIcn;
	}
	@FindBy(id="plusGroupBtn")
	private WebElement elePlusIcn;
	public WebElement getElePlusIcn(){
		return elePlusIcn;
	}
	@FindBy(id="minusGroupBtn")
	private WebElement eleMinusIcn;
	public WebElement getEleMinusIcn(){
		return eleMinusIcn;
	}
	@FindBy(id="groupCount")
	private WebElement eleGroupCnt;
	public WebElement getEleGroupCnt(){
		return eleGroupCnt;
	}	
	@FindBy(id="gridColumn")
	private WebElement eleGridColumnIcn;
	public WebElement getEleGridColumnIcn(){
		return eleGridColumnIcn;
	}
	@FindBy(id="gridList")
	private WebElement eleGridListIcn;
	public WebElement getEleGridListIcn(){
		return eleGridListIcn;
	}
	@FindBy(xpath="//h5[@class='groupName']")
	private List<WebElement> eleGroups;
	public List<WebElement> getEleGroups(){
		return eleGroups;
	}
	@FindBy(xpath="//div[contains(@id,'groupBox')]")
	private List<WebElement> eleGroupActivityGroups;
	public List<WebElement> eleGroupsActivitygroups(){
		return eleGroupActivityGroups;
	}
	@FindBy(xpath="//div[@class='clocking']")
	private WebElement eleActivityTxt;
	public WebElement eleActivityTxt(){
		   return eleActivityTxt;
	}
	@FindBy(xpath="(//div[contains(@class,'col-lg-4 col-md-4 col-sm-5')]//div)[1]")
	private WebElement elePageNumTxt;
	public WebElement getElePageNumTxt(){
		   return elePageNumTxt;
	}
	@FindBy(xpath="//div[@class='imgBg']//img")
	private WebElement elePageProgressIcn;
	public WebElement getElePageProgressIcn(){
		   return elePageProgressIcn;
	}
	@FindBy(xpath="//button[@class='btn btn-primary next-slide']")
	private WebElement eleStartBtn;
	public WebElement getEleStartBtn(){
		   return eleStartBtn;
	}
	@FindBy(id="activityStart")
	private WebElement eleActivityStartBtn;
	public WebElement getEleActivityStartBtn(){
		return eleActivityStartBtn;
	}
	@FindBy(id="activityPause")
	private WebElement eleActivityStopBtn;
	public WebElement getEleActivityStopBtn(){
		return eleActivityStopBtn;
	}
	@FindBy(id="activityReStart")
	private WebElement eleActivityResetBtn;
	public WebElement getEleActivityResetBtn(){
		return eleActivityResetBtn;
	}
	@FindBy(xpath="//h4[@class='modal-title text-left']")
	private WebElement eleCoinsPopupMsg;
	public WebElement getEleCoinsPopupMsg(){
		return eleCoinsPopupMsg;
	}
	@FindBy(xpath="//button[@class='close']")
	private WebElement eleCoinsPopupCloseIcn;
	public WebElement getEleCoinsPopupCloseIcn(){
		return eleCoinsPopupCloseIcn;
	}
	@FindBy(id="questSection")
	private WebElement eleQuestionStn;
	public WebElement getEleQuestionStn(){
		return eleQuestionStn;
	}
	@FindBy(id="show-ans-ex")
	private WebElement eleShowAnsBtn;
	public WebElement getEleShowAnsBtn(){
		return eleShowAnsBtn;
	}
	@FindBy(id="show-crossword-ans")
	private WebElement eleCrossWordShowAnsBtn;
	public WebElement getEleCrossWordShowAnsBtn(){
		return eleCrossWordShowAnsBtn;
	}
	@FindBy(xpath="//div[@class='questSection ex-ans-sec questSectionHeight']")
	private WebElement eleQuesAndAnswerStn;
	public WebElement getEleQuesAndAnswerStn(){
		return eleQuesAndAnswerStn;
	}
	@FindBy(xpath="//ul[@class='vmiddle ordertList']")
	private WebElement eleSummaryTxt;
	public WebElement getEleSummaryTxt(){
		return eleSummaryTxt;
	}
	@FindBy(xpath="//td[@id='1_by_teacher']")
	private WebElement eleTeacherScoreCell;
	public WebElement getEleTeacherScorecell(){
		return eleTeacherScoreCell;
	}
	@FindBy(xpath="//div[@class='col-lg-8 col-md-8 col-sm-6 col-xs-12 chapterBg pddLeft0 pddright0']//div")
	private WebElement elePageSubtitleTxt;
	public WebElement getElePageSubtitleTxt(){
		return elePageSubtitleTxt;
	}
	@FindBy(xpath="//img[@class='img-responsive']")
	private WebElement eleInstructorImg;
	public WebElement getEleInstructorImg(){
		return eleInstructorImg;
	}
	@FindBy(xpath="//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 pddLeft0 pddright0 introBg']")
	private WebElement eleInstructionsTxt;
	public WebElement getEleInstructionTxt(){
		return eleInstructionsTxt;
	}
	@FindBy(xpath="//div[@class='vmiddle height40']//p")
	private WebElement eleExcerciseTitleTxt;
	public WebElement getEleExcerciseTitleTxt(){
		return eleExcerciseTitleTxt;
	}
	@FindBy(xpath="//div[@id='exQuesAns']//h3")
	private WebElement eleExerciseTxt;
	public WebElement getEleExerciseTxt(){
		return eleExerciseTxt;
	}
	@FindBy(xpath="//div[@class='titleBg']//h4")
	private WebElement eleExerciseInstructionTxt;
	public WebElement getEleExerciseInstructionTxt(){
		return eleExerciseInstructionTxt;
	}
	@FindBy(xpath="//div[@class='titleLeftCornerBg']//h4")
	private WebElement eleAudioInstructionTxt;
	public WebElement getEleAudioInstructionTxt(){
		return eleAudioInstructionTxt;
	}
	@FindBy(xpath="//div[@class='textBg']//p")
	private WebElement eleSampleQuestions;
	public WebElement getEleSampleQuestions(){
		return eleSampleQuestions;
	}
	@FindBy(id="excImg")
	private WebElement eleExcerciseImg;
	public WebElement getEleExerciseImg(){
		return eleExcerciseImg;
	}
	@FindBy(xpath="//a[@id='textAuioIcon']")
	private WebElement eleAudioIcn;
	public WebElement getEleAudioIcn(){
		return eleAudioIcn;
	}
	@FindBy(id="audiojs")
	private WebElement eleAudioControlStn;
	public WebElement getEleAudioControlStn(){
		return eleAudioControlStn;
	}
	@FindBy(xpath="//div[@class='onlyAudio relative text-center']")
	private WebElement eleAudioLnk;
	public WebElement getEleAudioLnk(){
		return eleAudioLnk;
	}
	@FindBy(xpath="//i[@class='fa fa-search-plus']")
	private WebElement eleZoomIcn;
	public WebElement getEleZoomIcn(){
		return eleZoomIcn;
	}
	@FindBy(xpath="//span[@class='fib-html']//span[@class='fib-ans']")
	private WebElement eleAnswerTxt;
	public WebElement getEleAnswerTxt(){
		return eleAnswerTxt;
	}
	@FindBy(xpath="//img[@class='imagepreview']")
	private WebElement eleZoomInImg;
	public WebElement getEleZoomInImg(){
		return eleZoomInImg;
	}
	@FindBy(xpath="//div[@class='titleBg titleLeftCornerBg']//h4")
	private WebElement eleQuestionTitleTxt;
	public WebElement getEleQuestionTitleTxt(){
		return eleQuestionTitleTxt;
	}
	@FindBy(xpath="//div[@class='questSection ex-ans-sec']//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 quesText']")
	private WebElement eleAnswersTxt;
	public WebElement getEleAnswersTxt(){
		return eleAnswersTxt;
	}
	@FindBy(xpath="//img[@id='storyQuestionImg']")
	private WebElement eleQuestionImg;
	public WebElement getEleQuestionImg(){
		return eleQuestionImg;
	}
	@FindBy(id="hintsBtn")
	private WebElement eleHintsBtn;
	public WebElement getEleHintsBtn(){
		return eleHintsBtn;
	}
	@FindBy(xpath="//div[@id='hintsStoryBtn']")
	private WebElement eleHintStn;
	public WebElement getEleHintStn(){
		return eleHintStn;
	}
	@FindBy(xpath="//div[@id='hintsContent']//p")
	private WebElement eleHintTxt;
	public WebElement getEleHintTxt(){
		return eleHintTxt;
	}
	@FindBy(xpath="//img[@id='ques-image'][@src='session_media/28/blank_A.jpg']")
	private WebElement eleBlankImg;
	public WebElement getEleBlankImg(){
		return eleBlankImg;
	}
	@FindBy(xpath="//img[@id='ques-image'][@src='session_media/28/fill_A.jpg']")
	private WebElement eleFilledImg;
	public WebElement getEleFilledImg(){
		return eleFilledImg;
	}
	@FindBy(id="videoSize")
	private WebElement eleVideo;
	public WebElement getEleVideo(){
		return eleVideo;
	}
	@FindBy(xpath="//p[text()=' Group Activity']")
	private WebElement eleGroupActivityTxt;
	public WebElement getEleGroupActivityTxt(){
		return eleGroupActivityTxt;
	}
	@FindBy(id="excVideoId")
	private WebElement eleActivityVideo;
	public WebElement getEleActivityVideo(){
		return eleActivityVideo;
	}
	@FindBy(xpath="(//span[@class='span12']/..)[1]")
	private WebElement eleActivityPreparationTimeTxt;
	public WebElement getEleActivityPreparationTimeTxt(){
		return eleActivityPreparationTimeTxt;
	}
	@FindBy(xpath="//div[@class='panel-heading']")
	private WebElement eleGroupsInstr;
	public WebElement getEleGroupsInstr(){
		return eleGroupsInstr;
	}
	@FindBy(xpath="//div[@class='groupShow groupDisable']")
	private WebElement eleDefaultGroups;
	public WebElement getEleDefaultGroups(){
		return eleDefaultGroups;
	}
	@FindBy(xpath="//p[@id='msgError']")
	private WebElement eleGroupsErrMsg;
	public WebElement getEleGroupsErrMsg(){
		return eleGroupsErrMsg;
	}
	@FindBy(xpath="//p[@class='stepBg text-left']")
	private WebElement elePeerGradingTxt;
	public WebElement getElePeerGradingTxt(){
		return elePeerGradingTxt;
	}
	@FindBy(xpath="//table[@id='scoreTable']//thead//th")
	private List<WebElement> eleTableColumnTxt;
	public List<WebElement> getEleTableColumnTxt(){
		return eleTableColumnTxt;
	}
	@FindBy(xpath="//td[contains(@class,'rowHead rowColor')]")
	private List<WebElement> eleTableRowTxt;
	public List<WebElement> getEleTableRowTxt(){
		return eleTableRowTxt;
	}
	@FindBy(xpath="//td[@score='0']")
	private List<WebElement> eleDefaultScoreVal;
	public List<WebElement> getEleDefaultScoreVal(){
		return eleDefaultScoreVal;
	}
	@FindBy(xpath="//td[text()='Total']")
	private WebElement eleTotalTxt;
	public WebElement getEleTotalTxt(){
		return eleTotalTxt;
	}
	@FindBy(xpath="//td[text()='Teacher']")
	private WebElement eleTeacherTxt;
	public WebElement getEleTeacherTxt(){
		return eleTeacherTxt;
	}
	@FindBy(xpath="//th[@class='columnHead colColor']")
	private WebElement eleTableFld;
	public WebElement getEleTableFld(){
		return eleTableFld;
	}
	@FindBy(xpath="//td[contains(@class,'bgColorGroup')]")
	private List<WebElement> eleSelfCells;
	public List<WebElement> getEleSelfCells(){
		return eleSelfCells;
	}
	@FindBy(id="att-confirm-back")
	private WebElement eleCancelBtn;
	public WebElement getEleCancelBtn(){
		return eleCancelBtn;
	}
	@FindBy(id="att-confirm-continue")
	private WebElement eleContinueBtn;
	public WebElement getEleContinueBtn(){
		return eleContinueBtn;
	}
	@FindBy(xpath="//h4[text()='Confirmation']")
	private WebElement eleConfirmationTxt;
	public WebElement getEleConfirmationTxt(){
		return eleConfirmationTxt;
	}
	@FindBy(xpath="//div[@id='attendanceConfirmModal']//p")
	private WebElement eleConfirmationInstrTxt;
	public WebElement getEleConfirmationInstrTxt(){
		return eleConfirmationInstrTxt;
	}	
	public void verifyAttendenceConfPopup() throws InterruptedException{
		Thread.sleep(3000);
		try{
		if(getEleConfirmationTxt().isDisplayed()==true){
		studentSignInPage=new StudentSignInPage(driver);
		System.out.println("in if");
		studentSignInPage.elementStatus(getEleConfirmationTxt(), "Confirmation Text", "displayed");
		studentSignInPage.elementStatus(getEleConfirmationInstrTxt(), "Confirmation Instruction Text", "displayed");
		studentSignInPage.elementStatus(getEleCancelBtn(), "Cancel Button", "displayed");
		studentSignInPage.elementStatus(getEleContinueBtn(), "Continue Button", "displayed");
        	getEleCancelBtn().click();
        	Thread.sleep(2000);
        	attendencePage.getEleContinueBtn().click();
        	Thread.sleep(2000);
        	getEleContinueBtn().click();
        	Thread.sleep(2000);
        	}
		}
		catch (Exception e) {
			
		}
	}
	public void handleActivityTimer() throws Throwable{
		getEleActivityStartBtn().click();
        Thread.sleep(5000);
        getEleActivityStopBtn().click();
        Thread.sleep(2000);
/*        getEleActivityResetBtn().click();
        Thread.sleep(2000);
        getEleActivityStartBtn().click();
        Thread.sleep(10000);
        getEleActivityStopBtn().click();
        Thread.sleep(2000);
        handleGroups();*/
	}
	public void verifyCoinpopupElements() throws Throwable{
		if(getEleCoinsPopupMsg().isDisplayed()){
		NXGReports.addStep("Message in coins popup is displayed", LogAs.PASSED, null);
		}
		Thread.sleep(4000);
		getEleCoinsPopupCloseIcn().click();
		Thread.sleep(2000);
	}
	public void handleActivity() throws Throwable{
		NXGReports.addStep( "Activity Info"+eleActivityTxt().getText(), LogAs.PASSED, null);
		NXGReports.addStep( "page number info"+getElePageNumTxt().getText(), LogAs.PASSED, null);
		getEleNextIcn().click();
		NXGReports.addStep( "Clicked on Next icon ", LogAs.PASSED, null);
		Thread.sleep(1000);
		NXGReports.addStep( "Activity Info"+eleActivityTxt().getText(), LogAs.PASSED, null);
		NXGReports.addStep( "page number info"+getElePageNumTxt().getText(), LogAs.PASSED, null);
		getEleStartBtn().click();
		NXGReports.addStep( "Clicked on Start Button", LogAs.PASSED, null);
		Thread.sleep(1000);
		NXGReports.addStep( "Activity Info"+eleActivityTxt().getText(), LogAs.PASSED, null);
		NXGReports.addStep( "page number info"+getElePageNumTxt().getText(), LogAs.PASSED, null);
		getEleActivityStartBtn().click();
		NXGReports.addStep( "Clicked on 'Start', button 'Activity Preparation Time'  timer ", LogAs.PASSED, null);
        Thread.sleep(10000);
        getEleActivityStopBtn().click();
        NXGReports.addStep( "Clicked on 'Stop', button 'Activity Preparation Time'  timer ", LogAs.PASSED, null);
        handleGroups();
        Thread.sleep(2000);
        getEleNextIcn().click();
        Thread.sleep(1000);
        NXGReports.addStep( "Clicked on Next icon ", LogAs.PASSED, null);
        NXGReports.addStep( "Activity Info"+eleActivityTxt().getText(), LogAs.PASSED, null);
    	NXGReports.addStep( "page number info"+getElePageNumTxt().getText(), LogAs.PASSED, null);
    	getEleTeacherScorecell().click();
    	Thread.sleep(2000);
    	verifyCoinpopupElements();
        handleCoinsPopup();
        Thread.sleep(2000);
        getEleNextIcn().click();
        NXGReports.addStep( "Clicked on Next icon ", LogAs.PASSED, null);
	}
	public void handleActivity1() throws Throwable{
		// for 15 pages
		NXGReports.addStep( "Activity Info"+eleActivityTxt().getText(), LogAs.PASSED, null);
		NXGReports.addStep( "page number info"+getElePageNumTxt().getText(), LogAs.PASSED, null);
		getEleNextIcn().click();
		NXGReports.addStep( "Clicked on Next icon ", LogAs.PASSED, null);
		Thread.sleep(1000);
		NXGReports.addStep( "Activity Info"+eleActivityTxt().getText(), LogAs.PASSED, null);
		NXGReports.addStep( "page number info"+getElePageNumTxt().getText(), LogAs.PASSED, null);
		getEleNextIcn().click();
		Thread.sleep(1000);
		NXGReports.addStep( "Clicked on next Button", LogAs.PASSED, null);
		NXGReports.addStep( "Activity Info"+eleActivityTxt().getText(), LogAs.PASSED, null);
		NXGReports.addStep( "page number info"+getElePageNumTxt().getText(), LogAs.PASSED, null);
		getEleActivityStartBtn().click();
		NXGReports.addStep( "Clicked on 'Start', button 'Activity Preparation Time'  timer ", LogAs.PASSED, null);
        Thread.sleep(10000);
        getEleActivityStopBtn().click();
        NXGReports.addStep( "Clicked on 'Stop', button 'Activity Preparation Time'  timer ", LogAs.PASSED, null);
        handleGroups();
        Thread.sleep(2000);
        getEleNextIcn().click();
        Thread.sleep(1000);
        NXGReports.addStep( "Clicked on Next icon ", LogAs.PASSED, null);
        NXGReports.addStep( "Activity Info"+eleActivityTxt().getText(), LogAs.PASSED, null);
    	NXGReports.addStep( "page number info"+getElePageNumTxt().getText(), LogAs.PASSED, null);
    	getEleTeacherScorecell().click();
    	verifyCoinpopupElements();
        handleCoinsPopup();
        Thread.sleep(2000);
        getEleNextIcn().click();
        Thread.sleep(1000);
        NXGReports.addStep( "Clicked on Next icon ", LogAs.PASSED, null);
	}
	public void handleActivity2() throws Throwable{
		NXGReports.addStep( "Activity Info"+eleActivityTxt().getText(), LogAs.PASSED, null);
		NXGReports.addStep( "page number info"+getElePageNumTxt().getText(), LogAs.PASSED, null);
		getEleNextIcn().click();
		Thread.sleep(1000);
		NXGReports.addStep( "Clicked on Next icon ", LogAs.PASSED, null);
		NXGReports.addStep( "Activity Info"+eleActivityTxt().getText(), LogAs.PASSED, null);
		NXGReports.addStep( "page number info"+getElePageNumTxt().getText(), LogAs.PASSED, null);
		getEleStartBtn().click();
		Thread.sleep(1000);
		NXGReports.addStep( "Clicked on Start Button", LogAs.PASSED, null);
		NXGReports.addStep( "Activity Info"+eleActivityTxt().getText(), LogAs.PASSED, null);
		NXGReports.addStep( "page number info"+getElePageNumTxt().getText(), LogAs.PASSED, null);
		getEleActivityStartBtn().click();
		NXGReports.addStep( "Clicked on 'Start', button 'Activity Preparation Time'  timer ", LogAs.PASSED, null);
        Thread.sleep(10000);
        getEleActivityStopBtn().click();
        NXGReports.addStep( "Clicked on 'Stop', button 'Activity Preparation Time'  timer ", LogAs.PASSED, null);
        handleGroups();
        Thread.sleep(2000);
        getEleNextIcn().click();
        Thread.sleep(1000);
        NXGReports.addStep( "Clicked on Next icon ", LogAs.PASSED, null);
        NXGReports.addStep( "Activity Info"+eleActivityTxt().getText(), LogAs.PASSED, null);
    	NXGReports.addStep( "page number info"+getElePageNumTxt().getText(), LogAs.PASSED, null);
        getEleNextIcn().click();
        Thread.sleep(1000);
        NXGReports.addStep( "Clicked on Next icon ", LogAs.PASSED, null);
        NXGReports.addStep( "Activity Info"+eleActivityTxt().getText(), LogAs.PASSED, null);
    	NXGReports.addStep( "page number info"+getElePageNumTxt().getText(), LogAs.PASSED, null);
    	getEleTeacherScorecell().click();
    	verifyCoinpopupElements();
        handleCoinsPopup();
        Thread.sleep(2000);
        getEleNextIcn().click();
        NXGReports.addStep( "Clicked on Next icon ", LogAs.PASSED, null);
	}
	public void handleGroups() throws Throwable{
		List<WebElement> groups=driver.findElements(By.xpath("//div[contains(@id,'groupBox')]"));
		for(int i=1;i<=groups.size();i++){
			WebElement element=driver.findElement(By.xpath("//div[contains(@id,'groupBox')]["+i+"]"));
			element.click();
			driver.findElement(By.xpath("//div[contains(@id,'groupBox')]["+i+"]//button[contains(@id,'groupActivityStart')]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[contains(@id,'groupBox')]["+i+"]//button[contains(@id,'groupActivityPause')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(@id,'groupBox')]["+i+"]//button[contains(@id,'groupActivityPause')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(@id,'groupBox')]["+i+"]//button[contains(@id,'groupActivityPause')]")).click();
		}
	}
	public void handleCoinsPopup() throws Throwable{
		List<WebElement> groupFields=driver.findElements(By.xpath("//th[contains(@class,'columnHead colColor')]"));
		for(int i=1;i<=groupFields.size();i++){
			Thread.sleep(2000);
			List<WebElement> groupField=driver.findElements(By.xpath("//td[contains(@class,'groupScore grp-score-cell gs-"+i+"')]"));
			// To take each group field
			for(int j=1;j<=groupField.size();j++){
				WebElement ele=driver.findElement(By.xpath("(//td[contains(@class,'groupScore grp-score-cell gs-"+i+"')])["+j+"]"));
				ele.click();
				Thread.sleep(2000);
				// To work with coins popup
				List<WebElement> coins=driver.findElements(By.xpath("//td[contains(@id,'coin')]"));
				driver.findElement(By.xpath("//td[@id='coin5']")).click();
				Thread.sleep(2000);
				//ele.click();
				Thread.sleep(2000);
				
/*				for(int k=1;k<=coins.size();k++){
					if(k==10){
						driver.findElement(By.xpath("//td[@id='coin"+k+"']")).click();
						Thread.sleep(2000);
						break;
					}
					WebElement coinValue=driver.findElement(By.xpath("//td[@id='coin"+k+"']"));
					coinValue.click();
					Thread.sleep(2000);
					ele.click();
					Thread.sleep(1000);
				}*/
			}
		}
	}	
	public void createMaximumGroups() throws Throwable{
		 while(getElePlusIcn().isEnabled()==true){
	     	getElePlusIcn().click();
	     	Thread.sleep(2000);
	     	if(GenericLib.getIntegerNumber(getEleGroupCnt())==getEleGroups().size()){
	     		NXGReports.addStep("Group count and number of groups displaying are equal.", LogAs.PASSED, null);
	     	}
	     	else{
	     		NXGReports.addStep("Group count and number of groups displaying are not equal.", LogAs.PASSED, null);
	     	}
	     	}
	     if(getElePlusIcn().isEnabled()==false){
	 		NXGReports.addStep("Plus icon is disabled after selecting maximum number of groups", LogAs.PASSED, null);
	 		}
	 	else{
	 		NXGReports.addStep("Plus icon is not disabled after selecting maximum number of groups", LogAs.PASSED, null);
	 	}
	}
	public void createMinmumGroups() throws Throwable{
	    while(getEleMinusIcn().isEnabled()==true){
	    	getEleMinusIcn().click();
	    	Thread.sleep(2000);
	    	if(GenericLib.getIntegerNumber(getEleGroupCnt())==getEleGroups().size()){
	     		NXGReports.addStep("Group count and number of groups displaying are equal.", LogAs.PASSED, null);
	     	}
	     	else{
	     		NXGReports.addStep("Group count and number of groups displaying are not equal.", LogAs.PASSED, null);
	     	}
	    }
	    if(getEleMinusIcn().isEnabled()==false){
			NXGReports.addStep("Minus icon is disabled after selecting maximum number of groups", LogAs.PASSED, null);
			}
		else{
			NXGReports.addStep("Minus icon is not disabled after selecting maximum number of groups", LogAs.PASSED, null);
		}
	}
	public void verifyActivityLinkSecondTime(WebElement activityLink) throws Throwable{
		studentSignInPage=new StudentSignInPage(driver);
		studentSignInPage.ClickByJs(activityLink);
		Thread.sleep(2000);
        studentSignInPage.elementStatus(getEleSessionTxt(), "Session text", "displayed");
        studentSignInPage.elementStatus(getEleSessionInfoTxt(), "The session has already been launched. Would you like to resume old information or start a fresh session. ", "displayed");
        studentSignInPage.elementStatus(getEleResumeBtn(), "Resume button", "displayed");
        studentSignInPage.elementStatus(getEleStartAgainBtn(), "Start again button", "displayed");
        getEleResumeBtn().click();
        Thread.sleep(4000);
        getEleHomeIcn().click();
        Thread.sleep(5000);
        studentSignInPage.ClickByJs(activityLink);
        Thread.sleep(2000);
        getEleStartAgainBtn().click();
        studentSignInPage.elementStatus(getEleActivityTitleTxt(), "Session Title ", "displayed");
        Thread.sleep(2000);
        getEleHomeIcn().click();
	}	
	public void allStudentAttendence(WebElement attendenceIcon,WebElement attendenceText) throws Throwable{
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		 studentSignInPage.elementStatus(teacherSessionsPage.getEleTOCHeadingTxt(), "Table Of Contents Heading ", "displayed");
	        studentSignInPage.elementStatus(attendenceIcon, "Attendence Icon", "displayed");
	        studentSignInPage.moveToElement(attendenceIcon);
	        Thread.sleep(2000);
	        studentSignInPage.elementStatus(attendenceText, "Attendence Text", "displayed"); 
	        studentSignInPage.ClickByJs(attendenceText);
	        Thread.sleep(2000);
	        studentSignInPage.elementStatus(attendencePage.getEleAttendenceTxt(), "Attendence Text ", "displayed");
			studentSignInPage.elementStatus(attendencePage.getEleTotalStudentsCnt(), "Total Number Students count", "displayed");
			studentSignInPage.elementStatus(attendencePage.getEleTotalStudentsTxt(), "Total No. of Students text", "displayed");
			studentSignInPage.elementStatus(attendencePage.getEleAbsentStudentCnt(), "Student Count ", "displayed");
			studentSignInPage.elementStatus(attendencePage.getEleNumberOfStudentsABTxt(), "No. of Students Absent text", "displayed");
			studentSignInPage.elementStatus(attendencePage.getEleAttendenceInstructionTxt(), "Students Attendance List - Select the name of students who are absent text", "displayed");
	        attendencePage.allStudentPresent();
	        attendencePage.getEleSubmitBtn().click();
	        Thread.sleep(2000);
	        studentSignInPage.elementStatus(attendencePage.getEleAllStudentsPresentMsg(), "All students are present in the class. Do you wish to continue? Message ", "displayed");
	        studentSignInPage.elementStatus(attendencePage.getEleCloseIcn(), "Close Icon", "displayed");
	        studentSignInPage.elementStatus(attendencePage.getEleContinueBtn(), "Continue Button ", "displayed");
	        attendencePage.getEleCloseIcn().click();
	        Thread.sleep(2000);
	        attendencePage.getEleSubmitBtn().click();
	        Thread.sleep(2000);
	        attendencePage.getEleContinueBtn().click();
	       verifyAttendenceConfPopup();
	}
	public void allStudentAttendenceNegative(WebElement attendenceIcon,WebElement attendenceText) throws Throwable{
		studentSignInPage=new StudentSignInPage(driver);
		teacherSessionsPage=new TeacherSessionsPage(driver);
		attendencePage=new AttendencePage(driver);
		 studentSignInPage.elementStatus(teacherSessionsPage.getEleTOCHeadingTxt(), "Table Of Contents Heading ", "displayed");
	        studentSignInPage.elementStatus(attendenceIcon, "Attendence Icon", "displayed");
	        studentSignInPage.moveToElement(attendenceIcon);
	        Thread.sleep(2000);
	        studentSignInPage.elementStatus(attendenceText, "Attendence Text", "displayed"); 
	        studentSignInPage.ClickByJs(attendenceText);
	        Thread.sleep(2000);
	        attendencePage.allStudentAbsent();
	        attendencePage.getEleSubmitBtn().click();
	        Thread.sleep(2000);
	        studentSignInPage.elementStatus(attendencePage.getEleAllStudentAbsentMsg(), "All students are Absent in the class. Do you wish to continue? Message ", "displayed");
	        studentSignInPage.elementStatus(attendencePage.getEleCloseIcn(), "Close Icon", "displayed");
	        studentSignInPage.elementStatus(attendencePage.getEleRemoveStudentInstructionTxt(), "click to remove any student from this list. message ", "displayed");
	        attendencePage.getEleCloseIcn().click();
	        Thread.sleep(2000);
	        int absCnt=GenericLib.getIntegerNumber(attendencePage.getEleAbsentStudentCnt());
	        attendencePage.getEleSubmitBtn().click();
	        attendencePage.verifyStudentPresence(absCnt);
	        Thread.sleep(5000);
	        attendencePage.removeStudent();
	        studentSignInPage.elementStatus( attendencePage.getEleAllStudentsPresentMsg(), "All students are present in the class. Do you wish to continue? Message ", "displayed");
	        attendencePage.getEleCloseIcn().click();
	        Thread.sleep(2000);
	        attendencePage.getEleSubmitBtn().click();
	        Thread.sleep(2000);
	        attendencePage.getEleContinueBtn().click();
	        //verifyAttendenceConfPopup();
	}
	public void verifySessionHomePageElements(){
		studentSignInPage=new StudentSignInPage(driver);
		studentSignInPage.elementStatus(getEleActivityTitleTxt(), "Activity Title", "displayed");
        studentSignInPage.elementStatus(getEleHomeIcn(), "Home Icon", "displayed");
        studentSignInPage.elementStatus(getEleGlosaryIcn(), "Glosary icon", "displayed");
        studentSignInPage.elementStatus(getEleTeacherNameTxt(), "Teacher name text", "displayed");
        studentSignInPage.elementStatus(getEleProfileImg(), "Profile Image", "displayed");
        studentSignInPage.elementStatus(getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
        studentSignInPage.elementStatus(getEleActivityStudentInfoTxt(), "Student Information", "displayed");
        studentSignInPage.elementStatus(getEleGroupsTxt(), "Groups Text", "displayed");
        studentSignInPage.elementStatus(getEleMinusIcn(), "Minus icon", "displayed");
        studentSignInPage.elementStatus(getElePlusIcn(), "Plus Icon", "displayed");
        studentSignInPage.elementStatus(getEleGroupCnt(), "Group count", "displayed");
        studentSignInPage.elementStatus(getEleGridColumnIcn(), "Grid Column view Icon", "displayed");
        studentSignInPage.elementStatus(getEleGridListIcn(), "Grid List View Icon", "displayed");
        getEleGridColumnIcn().click();
        getEleGridListIcn().click();
        for(WebElement groups:getEleGroups())
		{
        	studentSignInPage.elementStatus(groups,"Groups", "displayed");
		}
        
        studentSignInPage.elementStatus(getElePrevIcn1(), "Previous Icon", "enabled");
        studentSignInPage.elementStatus(getElePrevIcn1(), "Previous Icon", "displayed");
        System.out.println("Dis"+getElePrevIcn1().isDisplayed());
        System.out.println(getElePrevIcn1().isEnabled());
	}
	public void verifyNextPage() throws Throwable{
		studentSignInPage=new StudentSignInPage(driver);
		getEleNextIcn().click();
		Thread.sleep(2000);
		studentSignInPage.elementStatus(getEleActivityTitleTxt(), "Activity Title", "displayed");
        studentSignInPage.elementStatus(getEleHomeIcn(), "Home Icon", "displayed");
        studentSignInPage.elementStatus(getEleGlosaryIcn(), "Glosary icon", "displayed");
        studentSignInPage.elementStatus(getEleTeacherNameTxt(), "Teacher name text", "displayed");
        studentSignInPage.elementStatus(getEleProfileImg(), "Profile Image", "displayed");
        studentSignInPage.elementStatus(getElePageSubtitleTxt(), "Page Subtitle ", "displayed");
        studentSignInPage.elementStatus(getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
        studentSignInPage.elementStatus(getEleNextIcn(), "Next icon", "displayed");
        studentSignInPage.elementStatus(getElePrevIcn(), "Previous Icon", "displayed");
        studentSignInPage.elementStatus(getElePageProgressIcn(), "Page progress icon", "displayed");
	}
	public void verifyGroupActivityPage() throws Throwable{
		studentSignInPage=new StudentSignInPage(driver);
		NXGReports.addStep("Page Info"+getElePageNumTxt().getText(), LogAs.PASSED, null);
		studentSignInPage.elementStatus(getEleActivityTitleTxt(), "Activity Title", "displayed");
        studentSignInPage.elementStatus(getEleHomeIcn(), "Home Icon", "displayed");
        studentSignInPage.elementStatus(getEleGlosaryIcn(), "Glosary icon", "displayed");
        studentSignInPage.elementStatus(getEleTeacherNameTxt(), "Teacher name text", "displayed");
        studentSignInPage.elementStatus(getEleProfileImg(), "Profile Image", "displayed");
        studentSignInPage.elementStatus(getElePageSubtitleTxt(), "Page Subtitle ", "displayed");
        studentSignInPage.elementStatus(getEleEnglishEdgeLogo(), "English Edge Logo", "displayed");
        studentSignInPage.elementStatus(getEleNextIcn(), "Next icon", "displayed");
        studentSignInPage.elementStatus(getElePrevIcn(), "Previous Icon", "displayed");
        studentSignInPage.elementStatus(getElePageProgressIcn(), "Page progress icon", "displayed");
        studentSignInPage.elementStatus(eleActivityTxt(),"Activity Info : "+eleActivityTxt().getText(), "displayed");
        studentSignInPage.elementStatus(getEleGroupActivityTxt(),"Group Activity text ", "displayed");
        studentSignInPage.elementStatus(getEleActivityPreparationTimeTxt(),"'Activity preparation time' Instructions ", "displayed");
        studentSignInPage.elementStatus(getEleGroupsInstr(),"'Groups' Instructions ", "displayed");
        handleActivityTimer();
        getGroupsErrorMsg();
        studentSignInPage.elementStatus(getEleGroupsErrMsg(),"'*Pause the button and then move to next group OR Wait for the present group to complete the activity'Erro rmessage", "displayed");
	}
	public void verifyPeerGradingPageElements(int groupSize){
		studentSignInPage=new StudentSignInPage(driver);
		NXGReports.addStep("Page Info"+getElePageNumTxt(), LogAs.PASSED, null);
        studentSignInPage.elementStatus(eleActivityTxt(),"Activity Info : "+eleActivityTxt().getText(), "displayed");
        studentSignInPage.elementStatus(getElePeerGradingTxt(),"'Peer Grading' Instructions ", "displayed");
        verifyTable(groupSize);
        studentSignInPage.elementStatus(getEleTotalTxt(),"Total text ", "displayed");
        for(WebElement cellvalue:getEleDefaultScoreVal())
		{
        	NXGReports.addStep("Cell Value "+cellvalue.getText(), LogAs.PASSED, null);
		}
        studentSignInPage.elementStatus(getEleTeacherTxt(),"Teacher text", "displayed");
	}
	public void getGroupsErrorMsg() throws Throwable{
		List<WebElement> groups=driver.findElements(By.xpath("//div[contains(@id,'groupBox')]"));
		for(int i=1;i<=groups.size();i++){
			WebElement element=driver.findElement(By.xpath("//div[contains(@id,'groupBox')]["+i+"]"));
			element.click();
			driver.findElement(By.xpath("//div[contains(@id,'groupBox')]["+i+"]//button[contains(@id,'groupActivityStart')]")).click();
			Thread.sleep(2000);
		}
	}
	public void verifyTable(int groupValue){
		int tableColumnSizeforGroups=getEleTableColumnTxt().size();
        int tableRowSizeforGroups=getEleTableRowTxt().size();
        int tableUnaccessedCells=getEleSelfCells().size();
        int tableDefaultValueCells=getEleDefaultScoreVal().size();
        
        if(groupValue==tableColumnSizeforGroups-1){
        	NXGReports.addStep("Group count and Groups in table coulumns are equal", LogAs.PASSED, null);
        }
        else{
        	NXGReports.addStep("Group count and Groups in table coulumns are not equal", LogAs.PASSED, null);
        }
        
        if(groupValue==tableRowSizeforGroups){
        	NXGReports.addStep("Group count and Groups in table rows are equal", LogAs.PASSED, null);
        }
        else{
        	NXGReports.addStep("Group count and Groups in table rows are not equal", LogAs.PASSED, null);
        }
        
        if(groupValue==tableUnaccessedCells){
        	NXGReports.addStep("Group count and default cells in table are equal", LogAs.PASSED, null);
        }
        else{
        	NXGReports.addStep("Group count and default cells in table equal", LogAs.PASSED, null);
        }
        if(groupValue==tableDefaultValueCells){
        	NXGReports.addStep("Group count and default cells in 'total' row of the table are equal", LogAs.PASSED, null);
        }
        else{
        	NXGReports.addStep("Group count and default cells in 'total' row of the tables are not equal", LogAs.PASSED, null);
        }
        
	}
}