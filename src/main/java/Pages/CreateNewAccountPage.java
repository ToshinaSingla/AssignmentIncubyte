package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import Xpaths.CreateNewAccountPageXpaths;

public class CreateNewAccountPage extends HomePage {

	WebDriver driver;

	public CreateNewAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = CreateNewAccountPageXpaths.PAGETITLE)
	private WebElement pageTitle;

	@FindBys({ @FindBy(xpath = CreateNewAccountPageXpaths.LABELSOFTHEINPUTFIELDS), })
	List<WebElement> labelOfTheInputFields;

	@FindBys({ @FindBy(xpath = CreateNewAccountPageXpaths.WARNINGSONEMPTYINPUTFIELDS), })
	List<WebElement> warningOnEmptyInputFields;

	@FindBy(id = CreateNewAccountPageXpaths.FIRSTNAME)
	private WebElement firstName;

	@FindBy(id = CreateNewAccountPageXpaths.LASTNAME)
	private WebElement lastName;

	@FindBy(id = CreateNewAccountPageXpaths.EMAILADDRESS)
	private WebElement emailAddress;

	@FindBy(id = CreateNewAccountPageXpaths.WARRNINGFOREMAILADDRESS)
	private WebElement warningForEmailAddress;

	@FindBy(id = CreateNewAccountPageXpaths.PASSWORD)
	private WebElement password;

	@FindBy(id = CreateNewAccountPageXpaths.PASSWORDSTRENGTH)
	private WebElement passwordStrength;

	@FindBy(id = CreateNewAccountPageXpaths.CONFIRMPASSWORD)
	private WebElement confirmPassword;

	@FindBy(id = CreateNewAccountPageXpaths.WARNINGFORCONFIRMPASSWORD)
	private WebElement warningForConfirmPassword;

	@FindBy(xpath = CreateNewAccountPageXpaths.CREATEANACCOUNTBUTTON)
	private WebElement createAnAccountButton;
	
	@FindBy(xpath = CreateNewAccountPageXpaths.ERRORALERTINACCOUNTCREATION)
	private WebElement errorAlertInAccountCreation;

	// To get the title of the page
	public String getTitleOfThePage() {
		return getText(pageTitle);
	}

	// To get count of the labels of the input fields
	public int getCountOfTheInputFields() {
		return labelOfTheInputFields.size();
	}

	// To get get count of the warnings for empty input fields
	public int getCountOfTheWarningForEmptyInputFields() {
		return warningOnEmptyInputFields.size();
	}

	// To enter the value in "First Name"
	public void enterFirstName(String fName) {
		enterText(firstName, fName);
	}

	// To enter the value in "Last Name"
	public void enterLastName(String lName) {
		enterText(lastName, lName);
	}

	// To enter the value in "Email Address"
	public void enterEmailId(String emailId) {
		enterText(emailAddress, emailId);
	}

	// To get the warning for an invalid email address
	public String getWarningForEmailId() {
		return getText(warningForEmailAddress);
	}

	// To enter the value in "Password"
	public void enterPassword(String pass) {
		enterText(password, pass);
	}

	// To get the password strength
	public String getPasswordStrength() {
		return getText(passwordStrength);
	}

	// To enter the value in "Confirm Password"
	public void enterConfirmPassword(String pass) {
		enterText(confirmPassword, pass);
	}

	// To get the warning for "Confirm Password"
	public String getWarningForConfirmPassword() {
		return getText(warningForConfirmPassword);
	}

	// To click on the button "Create an Account"
	public void clickButtonCreateAnAccount() {
		click(createAnAccountButton);
	}
	
	//To get error message if account could not be created
	public String getErrorAlertInAccountCreation() {
		return getText(errorAlertInAccountCreation);
	}
}
