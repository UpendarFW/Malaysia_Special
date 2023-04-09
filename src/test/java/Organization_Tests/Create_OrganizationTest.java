package Organization_Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Object_Repository.CreateNew_OrganizationPage;
import Object_Repository.Home_Page;
import Object_Repository.Organization_Information_Page;
import Object_Repository.Organization_LookupPage;


@Listeners(Generic_Utilities.Listners_Implimentation.class)
public class Create_OrganizationTest extends Generic_Utilities.BaseClass{

	@Test(groups = "SmokeSuite",retryAnalyzer = Generic_Utilities.RetryAnaliserImplimentation.class)
	public void createOrganization() throws Throwable {
		//Step 1:Click on Organizations Link
				Home_Page hp=new Home_Page(driver);
				hp.Organization_Link();
				
				Reporter.log("Click on Organizations Link Sucess",true);
				
				//Step 2:Click on Organization lookup image
				Organization_LookupPage ol=new Organization_LookupPage(driver);
				Thread.sleep(3000);
				ol.Organization_LookupImg();
				Reporter.log("Click on Organization lookup image Sucessful",true);
				
				//Step 3:Enter Organization name Using Excel utility
				Java_Utility ju=new Java_Utility();
				int rand=ju.getRandomNumber();
				
				Excel_Utility eu=new Excel_Utility();
				String ORGNAME=eu.getExcelData("Organizations",1,2)+rand;
				
				CreateNew_OrganizationPage cn=new CreateNew_OrganizationPage(driver);
				cn.OrganizationName_Edt(ORGNAME);
				
				Reporter.log("Enter Organization name Using Excel utility Sucessful",true);

				//Step 4:Validate the Organization
				Organization_Information_Page oi=new Organization_Information_Page(driver);
				String Actual=oi.Organization_Header();
				
				Assert.assertTrue(Actual.contains(ORGNAME));
				Reporter.log("Organization Created Sucessful",true);
	}
	
	@Test
	public void sampleTest() {
		System.out.println("Regional Regression Sample Test");
	}
}
