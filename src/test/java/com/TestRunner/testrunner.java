package com.TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "C:\\Users\\hp\\eclipse-workspace\\Mini-FRC_BDD\\src\\test\\resources\\Features\\updatefrc.feature",
  glue = {"com.stepDefinitions"},
  plugin  = {"pretty", "html:target/cucumber-reports.html",
		  "junit:target/Junit-reports/JunitTestReport.xml",
		

			"rerun:target/rerun.txt"},
  monochrome = true,
  dryRun = false
)

public class testrunner {

}
