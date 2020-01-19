package com.tutorialsninja.automation.runner;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"classpath:FeatureFiles"},
		glue={"classpath:com.tutorialsninja.automation.stepdef"},
		plugin={"html:target/cucumber_html_report",
				"rerun:target/rerun.txt"}
		//tags={"@Login","@Four"}
)
@ExtendedCucumberOptions(
		toPDF = true,
		detailedAggregatedReport = true,
		overviewReport = true,
		coverageReport = true,
		outputFolder = "target"
		)
public class TestRunner {

}
