package Xpaths;

public class CreateNewAccountPageXpaths {
	public static final String PAGETITLE = "//h1[@class='page-title']";

	public static final String LABELSOFTHEINPUTFIELDS = "//main//label[@class='label']";
	public static final String WARNINGSONEMPTYINPUTFIELDS = "//div[text()='This is a required field.']";

	public static final String FIRSTNAME = "firstname";
	public static final String LASTNAME = "lastname";

	public static final String EMAILADDRESS = "email_address";
	public static final String WARRNINGFOREMAILADDRESS = "email_address-error";
	
	public static final String PASSWORD = "password";
	public static final String PASSWORDSTRENGTH = "password-strength-meter-container";
	
	public static final String CONFIRMPASSWORD = "password-confirmation";
	public static final String WARNINGFORCONFIRMPASSWORD = "password-confirmation-error";
	
	public static final String CREATEANACCOUNTBUTTON = "//form[@id='form-validate']//button";
	
	public static final String ERRORALERTINACCOUNTCREATION= "//div[@role='alert']/div/div";

}
