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
	
	@FindBy(linkText="Register")
	public static WebElement registerBreadCrumb;
	
	@FindBy(css="input[id='Register']+div")
	public static WebElement firstNameTxtWarning;
	
	@FindBy(css="input[id='input-lastname']+div")
	public static WebElement lastNameTxtWarning;
	
	@FindBy(css="input[id='input-email']+div")
	public static WebElement emailTxtWarning;
	
	@FindBy(css="input[id='input-telephone']+div")
	public static WebElement telephoneTxtWarning;
	
	@FindBy(css="input[id='input-password']+div")
	public static WebElement passwordTxtWarning;
	
	@FindBy(css= "div[class*='alert-danger']")
	public static WebElement mainTxtWarning;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	public static WebElement yesRadioBtn;

	public static void enterAllRegistrationDetails(DataTable dataTable,String detailsType) {
		Map<String, String> map = dataTable.asMap(String.class,String.class);
		Elements.TypeText(RegisterPage.firstNameTxtBox, map.get("FirstName"));
		Elements.TypeText(RegisterPage.lastNameTxtBox, map.get("LastName"));
		Elements.TypeText(RegisterPage.telephoneTxtBox,map.get("Telephone"));
		Elements.TypeText(RegisterPage.passwordTxtBox,map.get("Password"));
		Elements.TypeText(RegisterPage.confirmPasswordTxtBox,map.get("Password"));
		if(detailsType.equalsIgnoreCase("duplicate"))
			Elements.TypeText(RegisterPage.emailTxtBox,map.get("Email"));
		else
			Elements.TypeText(RegisterPage.emailTxtBox,System.currentTimeMillis()+map.get("Email"));
	}
}
