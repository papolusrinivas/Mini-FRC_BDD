package Utilities;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class WaitUtil {
	private WebDriver driver;
 
	
	public WaitUtil(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean WaitForExpectedTextToBePresentUpdate(WebElement element, String expectedText, int timeOutInSeconds)
			throws InterruptedException {
		String text = null;
		for (int i = 0; i <= timeOutInSeconds; i++) {
			try {
				text = element.getText();
				System.out.println("*****************text="+text);
				System.out.println("********expected text="+expectedText);
				if (text.equals(expectedText)) {
					return true;
				} else {
					Thread.sleep(500);
				}
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		return false;
	}
	public void WaitForElementToBePresentUpdate(WebElement element, int timeOutInSeconds)
			throws InterruptedException {
		for (int i = 0; i <= timeOutInSeconds; i++) {
			try {
				if (element.isDisplayed()) {
					break;
				} else {
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
	}
	public void WaitAndClick(WebElement element, int timeOutInSeconds) throws InterruptedException {
		for (int i = 0; i <= timeOutInSeconds; i++) {
			try {
				element.click();
			} catch (Exception e) {
				Thread.sleep(1000);
				// e.printStackTrace();
			}
		}
	}
	public void waitExecutionForGivenTime(int timeOutInSeconds) {
		for (int i = 0; i <= timeOutInSeconds; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
	}
	

    
	

}