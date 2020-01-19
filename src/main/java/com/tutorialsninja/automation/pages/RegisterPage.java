package com.tutorialsninja.automation.pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

import cucumber.api.DataTable;

public class RegisterPage {

	public RegisterPage() {
		PageFactory.initElements(Base.driver, this);
	}

	@FindBy(id = "input-firstname")
	public static WebElement firstNameTxtBox;

	@FindBy(id = "input-lastname")
	public static WebElement lastNameTxtBox;

	@FindBy(id = "input-email")
	public static WebElement emailTxtBox;

	@FindBy(id = "input-telephone")
	public static WebElement telephoneTxtBox;

	@FindBy(id = "input-password")
	public static WebElement passwordTxtBox;

	@FindBy(id = "input-confirm")
	public static WebElement confirmPasswordTxtBox;
	
	@FindBy(xpath="//input[@type='checkbox']")
	public static WebElement privacyPolicyChkBox;
	
	@FindBy(xpath="//input[@value='Continue']")
	public static WebElement continueBtn;

	public static void enterAllRegistrationDetails(DataTable dataTable) {
		Map<String, String> map = dataTable.asMap(String.class,String.class);
		Elements.TypeText(RegisterPage.firstNameTxtBox, map.get("FirstName"));
		Elements.TypeText(RegisterPage.lastNameTxtBox, map.get("LastName"));
		Elements.TypeText(RegisterPage.emailTxtBox, System.currentTimeMillis()+map.get("Email"));
		Elements.TypeText(RegisterPage.telephoneTxtBox,map.get("Telephone"));
		Elements.TypeText(RegisterPage.passwordTxtBox,map.get("Password"));
		Elements.TypeText(RegisterPage.confirmPasswordTxtBox,map.get("Password"));
	}
}
