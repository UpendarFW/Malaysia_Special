package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriver_Utility {

	public void implicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void Explicit_Wait_ToClickElement(WebDriver driver,String element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
	}
	
	public void MaxiMizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void MiniMizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	public void ResizeWindow(WebDriver driver,int Width,int Height) {
		driver.manage().window().setSize(new Dimension(Width,Height));
	}
	
	public void Re_LocateWindow(WebDriver driver,int X,int Y) {
		driver.manage().window().setPosition(new Point(X, Y));
	}
	
	public void switchWebPage(WebDriver driver,String PAGENAME) {
		Set<String>chi=driver.getWindowHandles();
		Iterator<String>it=chi.iterator();
		while(it.hasNext()) {
			String Child=it.next();
			driver.switchTo().window(Child);
			String title=driver.getTitle();
			if(title.contains(PAGENAME)) {
				break;
			}
		}
	}
	
	public void handleDropdownBy_Index(WebElement element,int INDEXNUMBER) {
		Select s=new Select(element);
		s.selectByIndex(INDEXNUMBER);
	}
	
	public void handleDropdownBy_Value(WebElement element,String VALUE) {
		Select s=new Select(element);
		s.selectByValue(VALUE);
	}
	public void handleDropdownBy_VisibleTXT(WebElement element,String VText) {
		Select s=new Select(element);
		s.selectByVisibleText(VText);;
	}
	
	public void mouseMoveTo_Element(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void mouseMoveTo_ElementandClick(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
	act.moveToElement(element).click().build().perform();
	}
	
	public void mouseMoveTo_Elementand_DoubleClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).doubleClick().build().perform();
		}
	public void mouse_DoubleClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	public void mouse_DoubleClickElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void mouseDrag_Drop(WebDriver driver,WebElement SOURCEelement,WebElement TARGETelement) {
		Actions act=new Actions(driver);
		act.dragAndDrop(SOURCEelement,TARGETelement).perform();;
	}
	
	public void mouseDrag_DropBy(WebDriver driver,WebElement SourceElement,int Xoff,int Yoff) {
		Actions act=new Actions(driver);
		act.dragAndDropBy(SourceElement,Xoff,Yoff).perform();;
	}
	
	public void mouseRightClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	public void mouseRightClick_onElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void mouseMove_andRightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).contextClick().build().perform();
	}
	
	public void alert_Accept(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	
	public void alert_Dismiss(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
	}
	public String alert_Text(WebDriver driver,WebElement element) {
	Alert alt=driver.switchTo().alert();
	String AlertText=alt.getText();
	return AlertText;
	}
	
	public void handleFrame_ByIndex(WebDriver driver,int INDEXNUMBER) {
		driver.switchTo().frame(INDEXNUMBER);
	}
	
	public void handleFrame_ByNameORID(WebDriver driver,String NAMEorID) {
		driver.switchTo().frame(NAMEorID);
	}
	
	public void handleFrame_ByNameORID(WebDriver driver,WebElement FrameElement) {
		driver.switchTo().frame(FrameElement);
	}
	
	public void ParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	public void Frame_DefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public String Take_ScreenShot(WebDriver driver,String Screenshotname) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\Screenshots\\"+Screenshotname+".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}
}
