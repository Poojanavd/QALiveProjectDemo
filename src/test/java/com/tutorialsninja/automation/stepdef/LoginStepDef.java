package com.tutorialsninja.automation.stepdef;

import org.testng.Assert;

import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.ForgotPasswordPage;
import com.tutorialsninja.automation.pages.HeadersPage;
import com.tutorialsninja.automation.pages.LoginPage;
import com.tutorialsninja.automation.pages.MyAccountPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef {

	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

	@When("^I login to the application using Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void i_login_to_the_application_using_username_something_and_password_something(String username,
			String password) {
		LoginPage.doLogin(username, password);
	}

	@Then("^I should see that the User is able to successfully login$")
	public void i_should_see_that_the_user_is_able_to_successfully_login() {
		Assert.assertTrue(Elements.isDisplayed(MyAccountPage.logoutLink));
	}

	@And("^I navigate to Account Login page$")
	public void i_naviage_to_account_login_page() throws Throwable {
		Elements.click(HeadersPage.MyAccount);
		Elements.click(LoginPage.loginLink);
	}

	@Then("^I should see an error message informing the User about invalid credentials$")
	public void i_should_see_an_error_message_informing_the_user_about_invalid_credentials() {
		Elements.VerifyTextEquals(LoginPage.mainWarning, " Warning: No match for E-Mail Address and/or Password.");
	}

	@When("^I reset the forgotten password for \"([^\"]*)\"$")
	public void i_reset_the_forgotten_password_for_something(String email) {
		Elements.click(LoginPage.ForgottenPasswordlink);
		Elements.TypeText(ForgotPasswordPage.emailTxtBox, email);
		Elements.click(ForgotPasswordPage.continueBtn);
	}

	@Then("^I should see a message informing that the password reset details have been sent to the email address$")
	public void i_should_see_a_message_informing_that_the_password_reset_details_have_been_sent_to_the_email_address() {
		Assert.assertTrue(Elements.VerifyTextEquals(LoginPage.resetPasswordSuccessTxt,
				"An email with a confirmation link has been sent your email address."));
	}

}
