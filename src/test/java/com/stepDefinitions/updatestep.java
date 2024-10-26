package com.stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.globalPageObjects;
import testbase.testbase;
import Utilities.ConfigLoader;

public class updatestep extends testbase {

    private WebDriver driver;
    private globalPageObjects globalPage;

    @Before
    public void setUp() {
        driver = initializeDriver();
        globalPage = new globalPageObjects(driver);
    }

    @Given("I navigate to web application")
    public void i_navigate_to_web_application() {
        driver.get(ConfigLoader.getProperty("url"));
    }

    @Given("I see {string} web element")
    public void i_see_web_element(String locator) {
        String[] locatorParts = locator.split("=");
        String locatorType = locatorParts[0];
        String locatorValue = locatorParts[1];

        boolean isElementPresent = globalPage.isElementPresent(locatorType, locatorValue);
        assertTrue("Web element with " + locatorType + "=" + locatorValue + " is not visible", isElementPresent);
    }

    @When("I enter {string} as {string}")
    public void i_enter_as(String locator, String value) {
        String[] locatorParts = locator.split("=");
        String locatorType = locatorParts[0];
        String locatorValue = locatorParts[1];

        globalPage.enterText(locatorType, locatorValue, value);
    }

    @When("I click on {string}")
    public void i_click_on(String locator) {
        String[] locatorParts = locator.split("=");
        String locatorType = locatorParts[0];
        String locatorValue = locatorParts[1];

        globalPage.clickElement(locatorType, locatorValue);
    }

    @After
    public void tearDown() {
        super.tearDown();
    }
}
