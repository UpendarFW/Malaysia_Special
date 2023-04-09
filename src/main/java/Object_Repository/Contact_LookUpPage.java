package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_LookUpPage {

	@FindBy()
	private WebElement contactlookupimg;
	
	public Contact_LookUpPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
}
