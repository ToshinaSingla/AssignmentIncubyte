package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import Pages.MyAccountPage;
import base.PreDefinedActions;
import constants.ExpectedUITexts;
import constants.Values;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class StepDefinitions {
	WebDriver driver = PreDefinedActions.start();
	MyAccountPage myAccountPage = new MyAccountPage(driver);

	@When("user opens the App")
	public void user_opens_the_app() {
		PreDefinedActions.openURL(Values.APPURL);
	}

	@And("user is on Home Page")
	public void user_is_on_home_page() {
		// User will check the label of the page
		Assert.assertEquals(ExpectedUITexts.HOMEPAGETITLE, myAccountPage.getTitleOfThePage());
	}

	@And("user clicks on the header button Create an Account")
	public void user_clicks_on_the_header_button_create_an_account() {
		myAccountPage.clickCreateAnAccountHeaderButton();
	}

	@Then("user is on the page Create an Account")
	public void user_is_on_the_page_create_an_account() {
		// User will check the label of the page
		Assert.assertEquals(ExpectedUITexts.CREATENEWACCOUNTPAGETITLE, myAccountPage.getTitleOfThePage());
	}

	@When("user clicks on the button Create an Account")
	public void user_clicks_on_the_button_create_an_account() {
		myAccountPage.clickButtonCreateAnAccount();
	}

	@Then("user compares the count of warnings with the count of mandatory fields")
	public void user_compares_the_count_of_warnings_with_the_count_of_mandatory_fields() {
		Assert.assertEquals(myAccountPage.getCountOfTheInputFields(),
				myAccountPage.getCountOfTheWarningForEmptyInputFields());
	}

	@When("user enters the first name")
	public void user_enters_the_first_name() {
		myAccountPage.enterFirstName(Values.FIRSTNAME);
	}

	@When("user enters the last name")
	public void user_enters_the_last_name() {
		myAccountPage.enterLastName(Values.LASTNAME);
	}

	@When("user enters an invalid email address")
	public void user_enters_an_invalid_email_address() {
		myAccountPage.enterEmailId(Values.INVALIDEMAILID);
	}

	@Then("user reads the warning for the invalid email address")
	public void user_reads_the_warning_for_the_invalid_email_address() {
		Assert.assertEquals(myAccountPage.getWarningForEmailId(), ExpectedUITexts.INVALIDEMAILADDRESSWARNING);
	}

	@When("user enters a valid email address")
	public void user_enters_a_valid_email_address() {
		myAccountPage.enterEmailId(Values.VALIDEMAILID);
	}

	@Then("user is unable to find the warning for the email address")
	public void user_is_unable_to_find_the_warning_for_the_email_address() {
		boolean warningFound = true;
		try {
			myAccountPage.getWarningForEmailId();
			warningFound = true;
		} catch (Exception e) {
			warningFound = false;
		}
		Assert.assertFalse(warningFound);
	}

	@When("user enters few characters only as the password")
	public void user_enters_few_characters_only_as_the_password() {
		myAccountPage.enterPassword(Values.WEAKPASSWORD);
	}

	@Then("user checks the password strength for weak")
	public void user_checks_the_password_strength_for_weak() {
		Assert.assertEquals(myAccountPage.getPasswordStrength(), ExpectedUITexts.WEAKPASSWORDSTRENGTHMETER);
	}

	@When("user enters only special characters only as the password")
	public void user_enters_only_special_characters_only_as_the_password() {
		myAccountPage.enterPassword(Values.SPECIALCHARPASSWORD);
	}

	@When("user enters three out of four classes of characters in password")
	public void user_enters_three_out_of_four_classes_of_characters_in_password() {
		myAccountPage.enterPassword(Values.MEDIUMPASSWORD);
	}

	@Then("user checks the password strength for medium")
	public void user_checks_the_password_strength_for_medium() {
		Assert.assertEquals(myAccountPage.getPasswordStrength(), ExpectedUITexts.MEDIUMPASSWORDSTRENGTHMETER);
	}

	@When("user enters a valid password")
	public void user_enters_a_valid_password() {
		myAccountPage.enterPassword(Values.STRONGPASSWORD);
	}

	@Then("user checks the password strength for strong")
	public void user_checks_the_password_strength_for_strong() {
		Assert.assertEquals(myAccountPage.getPasswordStrength(), ExpectedUITexts.STRONGPASSWORDSTRENGTHMETER);
	}

	@When("user enters mismatched password in the text box confirm password")
	public void user_enters_mismatched_password_in_the_text_box_confirm_password() {
		myAccountPage.enterConfirmPassword(Values.MISMATCHEDCONFIRMPASSWORD);
	}

	@Then("user reads the warning for the mismatched password")
	public void user_reads_the_warning_for_the_mismatched_password() {
		Assert.assertEquals(myAccountPage.getWarningForConfirmPassword(), ExpectedUITexts.MISMATCHEDPASSWORDWARNING);
	}

	@And("user enters correct password in the text box confirm password")
	public void user_enters_correct_password_in_the_text_box_confirm_password() {
		myAccountPage.enterConfirmPassword(Values.MATCHEDCONFIRMPASSWORD);
	}

	@Then("user gets navigated to the page my account")
	public void user_gets_navigated_to_the_page_my_account() {
		// User will check the label of the page
		Assert.assertEquals(ExpectedUITexts.MYACCOUNTPAGETITLE, myAccountPage.getTitleOfThePage());
	}

	@Then("user checks the confirmation of account creation")
	public void user_checks_the_confirmation_of_account_creation() {
		// user will check if the account is created and page is switched to "My
		// Account" page or not
		Assert.assertEquals(ExpectedUITexts.ACCOUNTCREATIONCONFIRMATION,
				myAccountPage.getConfirmationOfAccountCreation(), myAccountPage.getErrorAlertInAccountCreation());
	}

	// To quit browser after each scenario
	@After
	public void quitDriver() {
		System.out.println("Closing browser...!!");
		if (driver != null) {
			driver.quit();
		}
	}
}
