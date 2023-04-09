package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.PropertyFile_Utility;

public class Login_Page {
	@FindBy(name = "user_name")
	private WebElement usernameedt;
	
	@FindBy(name = "user_password")
	private WebElement passwordedt;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getUsernameedt() {
		return usernameedt;
	}

	public WebElement getPasswordedt() {
		return passwordedt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Logic
	public void login_Application() throws Throwable {
		PropertyFile_Utility fu=new PropertyFile_Utility();
	
		String USERNAME=fu.getDAtaFromPropertyFile("username");
		String PASSWORD=fu.getDAtaFromPropertyFile("password");
		
		usernameedt.sendKeys(USERNAME);
		passwordedt.sendKeys(PASSWORD);
		loginBtn.click();
	}
}

