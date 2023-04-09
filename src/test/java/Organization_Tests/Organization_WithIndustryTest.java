package Organization_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Object_Repository.CreateNew_OrganizationPage;
import Object_Repository.Home_Page;
import Object_Repository.Organization_Information_Page;
import Object_Repository.Organization_LookupPage;

public class Organization_WithIndustryTest extends BaseClass{

	
	@Test
	public void createOrganizationWith_Industry() throws Throwable {
		Home_Page hp=new Home_Page(driver);
		hp.Organization_Link();
		
		Organization_LookupPage ol=new Organization_LookupPage(driver);
		ol.Organization_LookupImg();
		
		CreateNew_OrganizationPage cno=new CreateNew_OrganizationPage(driver);
		
		//Excel data fetching
		Excel_Utility eu=new Excel_Utility();
		Java_Utility ju=new Java_Utility();
		int rand=ju.getRandomNumber();
		
		
		String ORGNAME=eu.getExcelData("Organizations",4,2)+rand;
				
	    String INDUSTRY=eu.getExcelData("Organizations",4,3);
		
	    Thread.sleep(3000);
	    
		cno.OrganizationName_IndustryDrop(ORGNAME,INDUSTRY);
		
		Organization_Information_Page oi=new Organization_Information_Page(driver);
		
		String Actual=oi.Organization_Header();
		
		Assert.assertTrue(Actual.contains(ORGNAME));
		System.out.println("organization created with industry");
		
		
		
	}
}
