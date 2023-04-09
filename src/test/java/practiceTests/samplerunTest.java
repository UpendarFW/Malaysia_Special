package practiceTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;

@Listeners(Generic_Utilities.ListnersImplimentation.class)
public class samplerunTest extends BaseClass {

	@Test
	public void practiceTest1() {
		Assert.fail();
		System.out.println("Test Run Sucessful");
	}
}
