package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;

public class SearchPage {
	
	public SearchPage() {
		PageFactory.initElements(Base.driver,this);
	}

	@FindBy(css="[name='search']")
	public static WebElement searchTxtBox;
	
	@FindBy(css=".fa.fa-search")
	public static WebElement searchBtn;
}
