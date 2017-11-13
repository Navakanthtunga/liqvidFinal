package com.liqvid.page;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;

public class StudentResourcesPage {
	WebDriver driver = null;
	PDFTextStripper pdfStripper = null;
    COSDocument cosDoc = null;
	public StudentResourcesPage(WebDriver driver)
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
	// to identify 'Student Manual' Text in the resource page
	@FindBy(xpath="//div[text()='Student Manual']")
	private WebElement eleStudentManualText;
	public WebElement getEleStudentManualText(){
		return eleStudentManualText;
	}
	
	
	public void testVerifyPDFInURL() throws Exception
    
    {
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        URL url = new URL(driver.getCurrentUrl());
        BufferedInputStream fileToParse = new BufferedInputStream(url.openStream());
        
        PDFParser parser = new PDFParser(fileToParse);
        parser.parse();
        cosDoc = parser.getDocument();
        pdfStripper = new PDFTextStripper();
        pdfStripper.setStartPage(1);
        pdfStripper.setEndPage(5);
        
        String output=new PDFTextStripper().getText(parser.getPDDocument());
         NXGReports.addStep(output, LogAs.PASSED, null);
          parser.getPDDocument().close();
    
    }

}
