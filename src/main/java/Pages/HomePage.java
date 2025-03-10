package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Xpaths.HomePageXpaths;
import base.PreDefinedActions;

public class HomePage extends PreDefinedActions {
	WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(factory, this);
    }
    
    @FindBy(xpath = HomePageXpaths.PAGETITLE)
    private WebElement pageTitle;
    
    @FindBy(xpath = HomePageXpaths.CREATEANACCOUNTBUTTON)
    private WebElement createAnAccountHeaderButton;
    
    //To get the title of the page
    public String getTitleOfThePage() {
    	return getText(pageTitle);
    }
    
    //To click on the button Create An Account
    public void clickCreateAnAccountHeaderButton() {
    	click(createAnAccountHeaderButton);
    }
    
}
