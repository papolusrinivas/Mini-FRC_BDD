package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import testbase.testbase;

public class globalPageObjects extends testbase  {
	
	private WebDriver driver;


	public globalPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 public boolean isElementPresent(String locatorType, String locatorValue) {
	        try {
	            getElement(locatorType, locatorValue).isDisplayed();
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public void enterText(String locatorType, String locatorValue, String textToEnter) {
	        WebElement element = getElement(locatorType, locatorValue);
	        element.clear();
	        element.sendKeys(textToEnter);
	    }

	    public void clickElement(String locatorType, String locatorValue) {
	        WebElement element = getElement(locatorType, locatorValue);
	        element.click();
	    }

	    private WebElement getElement(String locatorType, String locatorValue) {
	        By by = null;
	        switch (locatorType.toLowerCase()) {
	            case "name":
	                by = By.name(locatorValue);
	                break;
	            case "id":
	                by = By.id(locatorValue);
	                break;
	            case "xpath":
	                by = By.xpath(locatorValue);
	                break;
	            case "css":
	                by = By.cssSelector(locatorValue);
	                break;
	            case "vt":  // Visible Text
	                by = By.xpath("//*[contains(text(),'" + locatorValue + "')]");
	                break;
	            default:
	                throw new IllegalArgumentException("Locator type " + locatorType + " not supported");
	        }
	        return driver.findElement(by);
	    }

}
