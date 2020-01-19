package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;

public class SearchResultsPage {
	public SearchResultsPage() {
		PageFactory.initElements(Base.driver,this);
	}

	@FindBy(linkText="Samsung SyncMaster 941BW")
	public static WebElement Samsung_SyncMaster_941BW_SearchResult;
	
	@FindBy(xpath="//h2[text()='Search']/following-sibling::p")
	public static WebElement invalidProduct;
}
