package com.tutorialsninja.automation.stepdef;

import org.testng.Assert;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.AccountSuccessPage;
import com.tutorialsninja.automation.pages.HeadersPage;
import com.tutorialsninja.automation.pages.RegisterPage;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterStepDef {
	
	HeadersPage headersPage = new HeadersPage();
	RegisterPage registerPage = new RegisterPage();
	AccountSuccessPage accountSuccessPage = new AccountSuccessPage();

	@Given("^I launch the application$")
	public void i_launch_the_application() {
		Base.driver.get(Base.reader.getUrl());
	}

	@When("^I provide all the below valid details$")
	public void i_provide_all_the_below_valid_details(DataTable dataTable) {
		RegisterPage.enterAllRegistrationDetails(dataTable);
		
	}

	@Then("^I should see that the User Account has successfully created$")
	public void i_should_see_that_the_user_account_has_successfully_created() {
		Assert.assertTrue(Elements.isDisplayed(AccountSuccessPage.successBreadCrumbLink));
	}

	@And("^I navigate to Account Registration page$")
	public void i_navigate_to_account_registration_page() {
		Elements.click(headersPage.MyAccount);
		Elements.click(headersPage.RegisterLink);
	}

	@And("^I select the Privacy Policy$")
	public void i_select_the_privacy_policy() {
		Elements.click(RegisterPage.privacyPolicyChkBox);
	}

	@And("^I click on Continue button$")
	public void i_click_on_continue_button() {
		Elements.click(RegisterPage.continueBtn);
	}
}
