package com.liqvid.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherSessionsPage {
	WebDriver driver = null;
	public TeacherSessionsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h1[@class='heading']")
	private WebElement eleTOCHeadingTxt;
	public WebElement getEleTOCHeadingTxt(){
		return eleTOCHeadingTxt;
	}
	@FindBy(xpath="//span[Contains(text(),'Greetings')]")
	private WebElement eleSessionLnk;
	public WebElement getEleSessionLnk(){
		return eleSessionLnk;
	}
	@FindBy(xpath="(//div[@class='attendance'])[1]")
	private WebElement eleAttendenceTxt;
	public WebElement getEleAttendenceTxt(){
		return eleAttendenceTxt;
	}
	@FindBy(xpath="(//div[@class='st-att attendanceUser col-sm-2 pddLeft0 pddright0'])[1]")
	private WebElement eleAttendenceIcn;
	public WebElement getEleAttendenceIcn(){
		return eleAttendenceIcn;
	}
	@FindBy(xpath="(//span[text()='Greetings and Introduct...']/../..//following-sibling::a)[1]")
	private WebElement eleConceptLnk;
	public WebElement getEleConceptLnk(){
		return eleConceptLnk;
	}
	@FindBy(xpath="(//span[text()='Greetings and Introduct...']/../..//following-sibling::a)[2]")
	private WebElement eleActivityLnk;
	public WebElement getEleActivityLnk(){
		return eleActivityLnk;
	}

	@FindBy(xpath="//span[text()='Family and Friends']")
	private WebElement eleFamilyAndFriendsTxt;
	public WebElement getEleFamilyAndFriendsTxt(){
		return eleFamilyAndFriendsTxt;
	}
	@FindBy(xpath="//span[text()='Family and Friends']/..//following-sibling::div")
	private WebElement eleFamilyAndFriendsAttendenceIcn;
	public WebElement getEleFamilyAndFriendsAttendenceIcn(){
		return eleFamilyAndFriendsAttendenceIcn;
	}
	@FindBy(xpath="//span[text()='Family and Friends']/..//following-sibling::div//div")
	private WebElement eleFamilyAndFriendsAttendenceTxt;
	public WebElement getEleFamilyAndFriendsAttendenceTxt(){
		return eleFamilyAndFriendsAttendenceTxt;
	}
	@FindBy(xpath="(//span[text()='Family and Friends']/../..//following-sibling::a)[1]")
	private WebElement eleFamilyAndFriendsConceptLnk;
	public WebElement getEleFamilyAndFriendsConceptlnk(){
		return eleFamilyAndFriendsConceptLnk;
	}
	@FindBy(xpath="(//span[text()='Family and Friends']/../..//following-sibling::a)[2]")
	private WebElement eleFamilyAndFriendsActivityLnk;
	public WebElement getEleFamilyAndFriendsActivitylnk(){
		return eleFamilyAndFriendsActivityLnk;
	}

	@FindBy(xpath="//span[text()='Acquiring Information']/..//following-sibling::div")
	private WebElement eleAcquiringInfoAttendenceIcn;
	public WebElement getEleAcquiringInfoAttendenceIcn(){
		return eleAcquiringInfoAttendenceIcn;
	}
	@FindBy(xpath="//span[text()='Acquiring Information']/..//following-sibling::div//div")
	private WebElement eleAcquiringInfoAttendenceTxt;
	public WebElement getEleAcquiringInfoAttendenceTxt(){
		return eleAcquiringInfoAttendenceTxt;
	}
	@FindBy(xpath="(//span[text()='Acquiring Information']/../..//following-sibling::a)[1]")
	private WebElement eleAcquiringInfoConceptLnk;
	public WebElement getEleAcquiringInfoConceptlnk(){
		return eleAcquiringInfoConceptLnk;
	}
	@FindBy(xpath="(//span[text()='Acquiring Information']/../..//following-sibling::a)[2]")
	private WebElement eleAcquiringInfoActivityLnk;
	public WebElement getEleAcquiringInfoActivitylnk(){
		return eleAcquiringInfoActivityLnk;
	}

	@FindBy(xpath="//span[text()='Being Aware']/..//following-sibling::div")
	private WebElement eleBeingAwareAttendenceIcn;
	public WebElement getEleBeingAwareAttendenceIcn(){
		return eleBeingAwareAttendenceIcn;
	}
	@FindBy(xpath="//span[text()='Being Aware']/..//following-sibling::div//div")
	private WebElement eleBeingAwareAttendenceTxt;
	public WebElement getEleBeingAwareAttendenceTxt(){
		return eleBeingAwareAttendenceTxt;
	}
	@FindBy(xpath="(//span[text()='Being Aware']/../..//following-sibling::a)[1]")
	private WebElement eleBeingAwareConceptLnk;
	public WebElement getEleBeingAwareConceptlnk(){
		return eleBeingAwareConceptLnk;
	}
	@FindBy(xpath="(//span[text()='Being Aware']/../..//following-sibling::a)[2]")
	private WebElement eleBeingAwareActivityLnk;
	public WebElement getEleBeingAwareActivitylnk(){
		return eleBeingAwareActivityLnk;
	}
	
	
	@FindBy(xpath="//span[text()='General Enquiry']/..//following-sibling::div")
	private WebElement eleGeneralEnquiryAttendenceIcn;
	public WebElement getEleGeneralEnquiryAttendenceIcn(){
		return eleGeneralEnquiryAttendenceIcn;
	}
	@FindBy(xpath="//span[text()='General Enquiry']/..//following-sibling::div//div")
	private WebElement eleGeneralEnquiryAttendenceTxt;
	public WebElement getEleGeneralEnquiryAttendenceTxt(){
		return eleGeneralEnquiryAttendenceTxt;
	}
	@FindBy(xpath="(//span[text()='General Enquiry']/../..//following-sibling::a)[1]")
	private WebElement eleGeneralEnquiryConceptLnk;
	public WebElement getEleGeneralEnquiryConceptlnk(){
		return eleGeneralEnquiryConceptLnk;
	}
	@FindBy(xpath="(//span[text()='General Enquiry']/../..//following-sibling::a)[2]")
	private WebElement eleGeneralEnquiryActivityLnk;
	public WebElement getEleGeneralEnquiryActivitylnk(){
		return eleGeneralEnquiryActivityLnk;
	}
	
	
	@FindBy(xpath="//span[text()='Knowing People']/..//following-sibling::div")
	private WebElement eleKnowingPeopleAttendenceIcn;
	public WebElement getEleKnowingPeopleAttendenceIcn(){
		return eleKnowingPeopleAttendenceIcn;
	}
	@FindBy(xpath="//span[text()='Knowing People']/..//following-sibling::div//div")
	private WebElement eleKnowingPeopleAttendenceTxt;
	public WebElement getEleKnowingPeopleAttendenceTxt(){
		return eleKnowingPeopleAttendenceTxt;
	}
	@FindBy(xpath="(//span[text()='Knowing People']/../..//following-sibling::a)[1]")
	private WebElement eleKnowingPeopleConceptLnk;
	public WebElement getEleKnowingPeopleConceptlnk(){
		return eleKnowingPeopleConceptLnk;
	}
	@FindBy(xpath="(//span[text()='Knowing People']/../..//following-sibling::a)[2]")
	private WebElement eleKnowingPeopleActivityLnk;
	public WebElement getEleKnowingPeopleActivitylnk(){
		return eleKnowingPeopleActivityLnk;
	}
	
	@FindBy(xpath="//span[text()='Telling Time']/..//following-sibling::div")
	private WebElement eleTellingTimeAttendenceIcn;
	public WebElement getEleTellingTimeAttendenceIcn(){
		return eleTellingTimeAttendenceIcn;
	}
	@FindBy(xpath="//span[text()='Telling Time']/..//following-sibling::div//div")
	private WebElement eleTellingTimeAttendenceTxt;
	public WebElement getEleTellingTimeAttendenceTxt(){
		return eleTellingTimeAttendenceTxt;
	}
	@FindBy(xpath="(//span[text()='Telling Time']/../..//following-sibling::a)[1]")
	private WebElement eleTellingTimeConceptLnk;
	public WebElement getEleTellingTimeConceptlnk(){
		return eleTellingTimeConceptLnk;
	}
	@FindBy(xpath="(//span[text()='Telling Time']/../..//following-sibling::a)[2]")
	private WebElement eleTellingTimeActivityLnk;
	public WebElement getEleTellingTimeActivitylnk(){
		return eleTellingTimeActivityLnk;
	}
	
	@FindBy(xpath="//span[text()='Shopping for Basics']/..//following-sibling::div")
	private WebElement eleShoppingforBasicsAttendenceIcn;
	public WebElement getEleShoppingforBasicsAttendenceIcn(){
		return eleShoppingforBasicsAttendenceIcn;
	}
	@FindBy(xpath="//span[text()='Shopping for Basics']/..//following-sibling::div//div")
	private WebElement eleShoppingforBasicsAttendenceTxt;
	public WebElement getEleShoppingforBasicsAttendenceTxt(){
		return eleShoppingforBasicsAttendenceTxt;
	}
	@FindBy(xpath="(//span[text()='Shopping for Basics']/../..//following-sibling::a)[1]")
	private WebElement eleShoppingforBasicsConceptLnk;
	public WebElement getEleShoppingforBasicsConceptlnk(){
		return eleShoppingforBasicsConceptLnk;
	}
	@FindBy(xpath="(//span[text()='Shopping for Basics']/../..//following-sibling::a)[2]")
	private WebElement eleShoppingforBasicsActivityLnk;
	public WebElement getEleShoppingforBasicsActivitylnk(){
		return eleShoppingforBasicsActivityLnk;
	}
	
	@FindBy(xpath="//span[text()='Casual Conversations']/..//following-sibling::div")
	private WebElement eleCasualConversationsAttendenceIcn;
	public WebElement getEleCasualConversationsAttendenceIcn(){
		return eleCasualConversationsAttendenceIcn;
	}
	@FindBy(xpath="//span[text()='Casual Conversations']/..//following-sibling::div//div")
	private WebElement eleCasualConversationsAttendenceTxt;
	public WebElement getEleCasualConversationsAttendenceTxt(){
		return eleCasualConversationsAttendenceTxt;
	}
	@FindBy(xpath="(//span[text()='Casual Conversations']/../..//following-sibling::a)[1]")
	private WebElement eleCasualConversationsConceptLnk;
	public WebElement getEleCasualConversationsConceptlnk(){
		return eleCasualConversationsConceptLnk;
	}
	@FindBy(xpath="(//span[text()='Casual Conversations']/../..//following-sibling::a)[2]")
	private WebElement eleCasualConversationsActivityLnk;
	public WebElement getEleCasualConversationsActivitylnk(){
		return eleCasualConversationsActivityLnk;
	}
	
	@FindBy(xpath="//span[text()='Polite Conversations']/..//following-sibling::div")
	private WebElement elePoliteConversationsAttendenceIcn;
	public WebElement getElePoliteConversationsAttendenceIcn(){
		return elePoliteConversationsAttendenceIcn;
	}
	@FindBy(xpath="//span[text()='Polite Conversations']/..//following-sibling::div//div")
	private WebElement elePoliteConversationsAttendenceTxt;
	public WebElement getElePoliteConversationsAttendenceTxt(){
		return elePoliteConversationsAttendenceTxt;
	}
	@FindBy(xpath="(//span[text()='Polite Conversations']/../..//following-sibling::a)[1]")
	private WebElement elePoliteConversationsConceptLnk;
	public WebElement getElePoliteConversationsConceptlnk(){
		return elePoliteConversationsConceptLnk;
	}
	@FindBy(xpath="(//span[text()='Polite Conversations']/../..//following-sibling::a)[2]")
	private WebElement elePoliteConversationsActivityLnk;
	public WebElement getElePoliteConversationsActivitylnk(){
		return elePoliteConversationsActivityLnk;
	}
	
	@FindBy(xpath="//span[text()='Organizing Get-together...']/..//following-sibling::div")
	private WebElement eleOrganizingGettogethersAttendenceIcn;
	public WebElement getEleOrganizingGettogethersAttendenceIcn(){
		return eleOrganizingGettogethersAttendenceIcn;
	}
	@FindBy(xpath="//span[text()='Organizing Get-together...']/..//following-sibling::div//div")
	private WebElement eleOrganizingGettogethersAttendenceTxt;
	public WebElement getEleOrganizingGettogethersAttendenceTxt(){
		return eleOrganizingGettogethersAttendenceTxt;
	}
	@FindBy(xpath="(//span[text()='Organizing Get-together...']/../..//following-sibling::a)[1]")
	private WebElement eleOrganizingGettogethersConceptLnk;
	public WebElement getEleOrganizingGettogethersConceptlnk(){
		return eleOrganizingGettogethersConceptLnk;
	}
	@FindBy(xpath="(//span[text()='Organizing Get-together...']/../..//following-sibling::a)[2]")
	private WebElement eleOrganizingGettogethersActivityLnk;
	public WebElement getEleOrganizingGettogethersActivitylnk(){
		return eleOrganizingGettogethersActivityLnk;
	}
	
	
	@FindBy(xpath="//span[text()='Sharing Experiences']/..//following-sibling::div")
	private WebElement eleSharingExperiencesAttendenceIcn;
	public WebElement getEleSharingExperiencesAttendenceIcn(){
		return eleSharingExperiencesAttendenceIcn;
	}
	@FindBy(xpath="//span[text()='Sharing Experiences']/..//following-sibling::div//div")
	private WebElement eleSharingExperiencesAttendenceTxt;
	public WebElement getEleSharingExperiencesAttendenceTxt(){
		return eleSharingExperiencesAttendenceTxt;
	}
	@FindBy(xpath="(//span[text()='Sharing Experiences']/../..//following-sibling::a)[1]")
	private WebElement eleSharingExperiencesConceptLnk;
	public WebElement getEleSharingExperiencesConceptlnk(){
		return eleSharingExperiencesConceptLnk;
	}
	@FindBy(xpath="(//span[text()='Sharing Experiences']/../..//following-sibling::a)[2]")
	private WebElement eleSharingExperiencesActivityLnk;
	public WebElement getEleSharingExperiencesActivitylnk(){
		return eleSharingExperiencesActivityLnk;
	}
	
	@FindBy(xpath="//span[text()='Where Have You Been?']/..//following-sibling::div")
	private WebElement eleWhereHaveYouBeenAttendenceIcn;
	public WebElement getEleWhereHaveYouBeenAttendenceIcn(){
		return eleWhereHaveYouBeenAttendenceIcn;
	}
	@FindBy(xpath="//span[text()='Where Have You Been?']/..//following-sibling::div//div")
	private WebElement eleWhereHaveYouBeenAttendenceTxt;
	public WebElement getEleWhereHaveYouBeenAttendenceTxt(){
		return eleWhereHaveYouBeenAttendenceTxt;
	}
	@FindBy(xpath="(//span[text()='Where Have You Been?']/../..//following-sibling::a)[1]")
	private WebElement eleWhereHaveYouBeenConceptLnk;
	public WebElement getEleWhereHaveYouBeenConceptlnk(){
		return eleWhereHaveYouBeenConceptLnk;
	}
	@FindBy(xpath="(//span[text()='Where Have You Been?']/../..//following-sibling::a)[2]")
	private WebElement eleWhereHaveYouBeenActivityLnk;
	public WebElement getEleWhereHaveYouBeenActivitylnk(){
		return eleWhereHaveYouBeenActivityLnk;
	}
	
	@FindBy(xpath="//span[text()='Getting Directions']/..//following-sibling::div")
	private WebElement eleGettingDirectionsAttendenceIcn;
	public WebElement getEleGettingDirectionsAttendenceIcn(){
		return eleGettingDirectionsAttendenceIcn;
	}
	@FindBy(xpath="//span[text()='Getting Directions']/..//following-sibling::div//div")
	private WebElement eleGettingDirectionsAttendenceTxt;
	public WebElement getEleGettingDirectionsAttendenceTxt(){
		return eleGettingDirectionsAttendenceTxt;
	}
	@FindBy(xpath="(//span[text()='Getting Directions']/../..//following-sibling::a)[1]")
	private WebElement eleGettingDirectionsConceptLnk;
	public WebElement getEleGettingDirectionsConceptlnk(){
		return eleGettingDirectionsConceptLnk;
	}
	@FindBy(xpath="(//span[text()='Getting Directions']/../..//following-sibling::a)[2]")
	private WebElement eleGettingDirectionsActivityLnk;
	public WebElement getEleGettingDirectionsActivitylnk(){
		return eleGettingDirectionsActivityLnk;
	}
	
	@FindBy(xpath="//span[text()='Seeking Permission']/..//following-sibling::div")
	private WebElement eleSeekingPermissionAttendenceIcn;
	public WebElement getEleSeekingPermissionAttendenceIcn(){
		return eleSeekingPermissionAttendenceIcn;
	}
	@FindBy(xpath="//span[text()='Seeking Permission']/..//following-sibling::div//div")
	private WebElement eleSeekingPermissionAttendenceTxt;
	public WebElement getEleSeekingPermissionAttendenceTxt(){
		return eleSeekingPermissionAttendenceTxt;
	}
	@FindBy(xpath="(//span[text()='Seeking Permission']/../..//following-sibling::a)[1]")
	private WebElement eleSeekingPermissionConceptLnk;
	public WebElement getEleSeekingPermissionConceptlnk(){
		return eleSeekingPermissionConceptLnk;
	}
	@FindBy(xpath="(//span[text()='Seeking Permission']/../..//following-sibling::a)[2]")
	private WebElement eleSeekingPermissionActivityLnk;
	public WebElement getEleSeekingPermissionActivitylnk(){
		return eleSeekingPermissionActivityLnk;
	}
	
	@FindBy(xpath="//span[text()='General Knowledge']/..//following-sibling::div")
	private WebElement eleGeneralKnowledgeAttendenceIcn;
	public WebElement getEleGeneralKnowledgeAttendenceIcn(){
		return eleGeneralKnowledgeAttendenceIcn;
	}
	@FindBy(xpath="//span[text()='General Knowledge']/..//following-sibling::div//div")
	private WebElement eleGeneralKnowledgeAttendenceTxt;
	public WebElement getEleGeneralKnowledgeAttendenceTxt(){
		return eleGeneralKnowledgeAttendenceTxt;
	}
	@FindBy(xpath="(//span[text()='General Knowledge']/../..//following-sibling::a)[1]")
	private WebElement eleGeneralKnowledgeConceptLnk;
	public WebElement getEleGeneralKnowledgeConceptlnk(){
		return eleGeneralKnowledgeConceptLnk;
	}
	@FindBy(xpath="(//span[text()='General Knowledge']/../..//following-sibling::a)[2]")
	private WebElement eleGeneralKnowledgeActivityLnk;
	public WebElement getEleGeneralKnowledgeActivitylnk(){
		return eleGeneralKnowledgeActivityLnk;
	}
	
	@FindBy(xpath="//span[text()='Likes and Dislikes']/..//following-sibling::div")
	private WebElement eleLikesAndDislikesAttendenceIcn;
	public WebElement getEleLikesAndDislikesAttendenceIcn(){
		return eleLikesAndDislikesAttendenceIcn;
	}
	@FindBy(xpath="//span[text()='Likes and Dislikes']/..//following-sibling::div//div")
	private WebElement eleLikesAndDislikesAttendenceTxt;
	public WebElement getEleLikesAndDislikesAttendenceTxt(){
		return eleLikesAndDislikesAttendenceTxt;
	}
	@FindBy(xpath="(//span[text()='Likes and Dislikes']/../..//following-sibling::a)[1]")
	private WebElement eleLikesAndDislikesConceptLnk;
	public WebElement getEleLikesAndDislikesConceptlnk(){
		return eleLikesAndDislikesConceptLnk;
	}
	@FindBy(xpath="(//span[text()='Likes and Dislikes']/../..//following-sibling::a)[2]")
	private WebElement eleLikesAndDislikesActivityLnk;
	public WebElement getEleLikesAndDislikesActivitylnk(){
		return eleLikesAndDislikesActivityLnk;
	}
	
	@FindBy(xpath="//span[text()='Short-Term Plans']/..//following-sibling::div")
	private WebElement eleShortTermPlansAttendenceIcn;
	public WebElement getEleShortTermPlansAttendenceIcn(){
		return eleShortTermPlansAttendenceIcn;
	}
	@FindBy(xpath="//span[text()='Short-Term Plans']/..//following-sibling::div//div")
	private WebElement eleShortTermPlansAttendenceTxt;
	public WebElement getEleShortTermPlansAttendenceTxt(){
		return eleShortTermPlansAttendenceTxt;
	}
	@FindBy(xpath="(//span[text()='Short-Term Plans']/../..//following-sibling::a)[1]")
	private WebElement eleShortTermPlansConceptLnk;
	public WebElement getEleShortTermPlansConceptlnk(){
		return eleShortTermPlansConceptLnk;
	}
	@FindBy(xpath="(//span[text()='Short-Term Plans']/../..//following-sibling::a)[2]")
	private WebElement eleShortTermPlansActivityLnk;
	public WebElement getEleShortTermPlansActivitylnk(){
		return eleShortTermPlansActivityLnk;
	}

	
}
