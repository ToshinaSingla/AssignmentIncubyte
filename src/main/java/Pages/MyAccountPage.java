package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Xpaths.MyAccountPageXpaths;

public class MyAccountPage extends CreateNewAccountPage {
	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = MyAccountPageXpaths.PAGETITLE)
    private WebElement pageTitle;
    
    @FindBy(xpath = MyAccountPageXpaths.ACCOUNTCREATIONCONFIRMATION)
    private WebElement accountCreationConfirmation;
    
    //To get the title of the page
    public String getTitleOfThePage() {
    	return getText(pageTitle);
    }
    
    //To get the confirmation o the account creation
    public String getConfirmationOfAccountCreation() {
    	return getText(accountCreationConfirmation);
    }
}
