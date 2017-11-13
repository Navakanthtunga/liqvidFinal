package com.liqvid.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherResourcesPage {
	WebDriver driver = null;
	public TeacherResourcesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//to identify 'Resource' text in the resource page
	@FindBy(xpath="//div[text()='Resources']")
	private WebElement eleResourcesText;
	public WebElement getEleResourcesText(){
		return eleResourcesText;
	}
	// to identify Image in the resource page
	@FindBy(xpath="//div[@class='col-sm-12 resourceTab text-center']//div//div//a//img")
	private WebElement eleResourcesImage;
	public WebElement getEleResourcesImage(){
		return eleResourcesImage;
	}
	// to identify 'Teacher Manual' Text in the resource page
	@FindBy(xpath="//div[@class='btn btn-blue assTab']")
	private WebElement eleTeacherManualTxt;
	public WebElement getEleTeacherManualTxt(){
		return eleTeacherManualTxt;
	}
	
}
