package com.tutorialsninja.automation.stepdef;

import org.testng.Assert;

import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.SearchPage;
import com.tutorialsninja.automation.pages.SearchResultsPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SearchStepDef {
	
	SearchPage  searchPage = new SearchPage();
	SearchResultsPage searchResultsPage = new SearchResultsPage();
	

	 @When("^I search for a product \"([^\"]*)\"$")
	    public void i_search_for_a_product_something(String product) {
		 Elements.TypeText(SearchPage.searchTxtBox, product);
		 Elements.click(SearchPage.searchBtn);
	        
	    }

	    @Then("^I should see the product in the search results address$")
	    public void i_should_see_the_product_in_the_search_results_address() {
	        Assert.assertTrue(Elements.isDisplayed(SearchResultsPage.Samsung_SyncMaster_941BW_SearchResult));
	    }
	    
	    @Then("^I should see the page displaying the message \"([^\"]*)\"$")
	    public void i_should_see_the_page_displaying_the_message_something(String invalidProductTxt){
	        Assert.assertTrue(Elements.VerifyTextEquals(SearchResultsPage.invalidProduct, invalidProductTxt));
	    }
}
