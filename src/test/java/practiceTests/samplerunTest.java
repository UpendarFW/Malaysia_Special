package practiceTests;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Object_Repository.Home_Page;

@Listeners(Generic_Utilities.Listners_Implimentation.class)
public class samplerunTest extends BaseClass {

	@Test(retryAnalyzer = Generic_Utilities.RetryAnaliserImplimentation.class)
	public void practiceTest1() {
		Home_Page hp=new Home_Page(driver);
		
		hp.Organization_Link();
		
		
		
		hp.Contacts_Link();
		
		
	}
}
