package com.liqvid.installation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.liqvid.library.BaseLib;
import com.liqvid.library.GenericLib;
public class LiqvidInstallation extends BaseLib
{
	WebDriver driver;
	public static String sEnglishEdgeInstallerFile = GenericLib.sDirPath+"\\resources\\install.exe";
	public static String sLiquidInstallerFile = GenericLib.sDirPath+"\\resources\\LiqvidInstallation.exe";	
	/* 
	 * @Description: Installation of EnglishEdge.exe
	 * @Author: RaghuKiran MR
	 */
    @Test(priority=1,enabled=false, description="Installation of EnglishEdge.exe")
    public void testLiqvidInstallation() throws Exception
    {
		try
		{
			Runtime.getRuntime().exec(sEnglishEdgeInstallerFile);
			Thread.sleep(8000);
			Runtime.getRuntime().exec(sLiquidInstallerFile);
			Thread.sleep(600000);
	    } 
		catch (Exception ex) 
		{
			ex.printStackTrace();
	    }
		
	}
    @Test(priority=2,enabled=false,description="Updation of Application URL based on the PC")
    public void testUpdateApplicationURL() throws Exception{
		try{
			String applicationUrl="http://"+GenericLib.getIP()+":4001/learning/index.php";
			String registrationConfirmationUrl="http://"+GenericLib.getIP()+":4001/registration/registration_completed.php";
			String dataBaseUrl="http://"+GenericLib.getIP()+":4001/admin/index.php";
			GenericLib.setCongigValue(GenericLib.sConfigFile,"APPLICATIONURL",applicationUrl);
			GenericLib.setCongigValue(GenericLib.sConfigFile,"REGESTARTIONCONFIRMATION",registrationConfirmationUrl);
			GenericLib.setCongigValue(GenericLib.sConfigFile,"DataBaseURL",dataBaseUrl);
		}
		catch(Exception e)
		{
			throw e;
		}
}
    /* 
	 * @Description: 
	 * @Author: RaghuKiran MR
	 */
    @Test(enabled=false, description="Delete the existing files, Launch the server and verification of files")
    public void testCheckForAutoupdation() throws Exception
    {
		try
		{
			File docx = new File("C:\\Users\\Administrator\\Documents\\LAN1-2-V2\\www\\sample.docx");
			File pptx = new File("C:\\Users\\Administrator\\Documents\\LAN1-2-V2\\www\\sample.pptx");
			File txt = new File("C:\\Users\\Administrator\\Documents\\LAN1-2-V2\\www\\sample.txt");
			File xlsx = new File("C:\\Users\\Administrator\\Documents\\LAN1-2-V2\\www\\sample.xlsx");
			File zip = new File("C:\\Users\\Administrator\\Documents\\LAN1-2-V2\\www\\sample.zip");
			docx.delete();
			pptx.delete();
			txt.delete();
			xlsx.delete();
			zip.delete();
			if(docx.exists()==true){
				System.out.println("Hurray file present");
			}
			else
				System.out.println("file sucessfully removed");
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
	    }
	}
    @Test
    public void testInternetConnectivity() throws IOException, InterruptedException{
    	
    	
    }
}
