package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

public class LoginPage {
	
	public LoginPage() {
		PageFactory.initElements(Base.driver, this);
	}

	@FindBy(linkText = "Login")
	public static WebElement loginLink;
	
	@FindBy(id="input-email")
	public static WebElement emailTxtBox;
	
	@FindBy(id="input-password")
	public static WebElement passwordTxtBox;
	
	@FindBy(css="input[value='Login']")
	public static WebElement loginBtn;
	
	@FindBy(css="div[class*='alert-danger']")
	public static WebElement mainWarning;
	
	@FindBy(linkText="Forgotten Password")
	public static WebElement ForgottenPasswordlink;
	
	@FindBy(css = "div[class*='alert-success']")
	public static WebElement resetPasswordSuccessTxt;
	
	public static void doLogin(String username,String password) {
		Elements.TypeText(LoginPage.emailTxtBox, username);
        Elements.TypeText(LoginPage.passwordTxtBox, password);
        Elements.click(LoginPage.loginBtn);
	}
}
