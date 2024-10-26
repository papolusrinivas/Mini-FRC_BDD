package com.stepDefinitions;
import javax.swing.text.Utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import Utilities.ConfigLoader;
import Utilities.WaitUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testbase.testbase;


public class FRCsteploginDef extends testbase {
	
	Utilities utilities = new Utilities();
     WaitUtil waitUtil;
	
	@Given("User is alredy login page")
	public void user_is_alredy_login_page() {	
		
		initializeDriver(); // Initialize the driver using TestBase method
		
		waitUtil = new WaitUtil(driver);
	}
	@When("title of login page is freecrm")
	public void title_of_login_page_is_freecrm() {
		String title=driver.getTitle();
		Assert.assertEquals("Cogmento CRM", title);
		System.out.println("Login title::::::::::::::"+title);
	    
	}
	@Then("User enter username")
	public void user_enter_username() {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(ConfigLoader.getProperty("username"));
	   
	}
	@Then("user enter password")
	public void user_enter_password() {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(ConfigLoader.getProperty("password"));
	   
	}
	@Then("user enter click on login button")
	public void user_enter_click_on_login_button() {
		driver.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
	   
	}
	@Then("user is home page")
	public void user_is_home_page() throws Throwable {
		String title =driver.getTitle();
		System.out.println("Home page title ::"+title);
		Assert.assertEquals("Cogmento CRM", title);
		// Attempt to close the 'close icon' element
		waitUtil.waitExecutionForGivenTime(2);
		WebElement icon=driver.findElement(By.xpath("//*[@class='close icon']"));
		waitUtil.WaitAndClick(icon, 10);
		
		}
	@When("user click on usericon")
	public void user_click_on_usericon() {
		driver.findElement(By.xpath("//*[@class='users icon']")).click();
	   
	}
	@Then("click on add button")
	public void click_on_add_button() throws Throwable {
//		WebElement ys=driver.findElement(By.xpath("(//*[@class='plus inverted icon'])[2]"));
//		waitUtil.WaitAndClick(ys, 20);
		waitUtil.waitExecutionForGivenTime(1);
		driver.findElement(By.xpath("(//*[@class='plus inverted icon'])[2]")).click();
	}
	@Then("enter First name")
	public void enter_first_name() {
		driver.findElement(By.xpath("//*[@name='first_name']")).sendKeys("vasu");
	}
	@Then("select status dropdown")
	public void select_status_dropdown() throws Throwable {
		driver.findElement(By.xpath("//div[@name='status']//*[@class='dropdown icon']")).click();
		//Thread.sleep(3000);
	WebElement el=	driver.findElement(By.xpath("//span[normalize-space()='New']"));
	waitUtil.WaitAndClick(el, 10);

		}
	@Then("Click on donot call")
	public void click_on_donot_call() throws Throwable {
		waitUtil.waitExecutionForGivenTime(1);
   WebElement doNotCallCheckbox = driver.findElement(By.xpath("//*[@name='do_not_call']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", doNotCallCheckbox);
    }
	@Then("enter last name")
	public void enter_last_name() {
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("papolu");
	   
	}
	@Then("select phone dropdown")
	public void select_phone_dropdown() {
		driver.findElement(By.xpath("//div[@name='hint']//i[@class='dropdown icon']")).click();
		
		driver.findElement(By.xpath("//div[@name='hint']//input[@type='text']")).sendKeys("India");
		waitUtil.waitExecutionForGivenTime(1);
		driver.findElement(By.xpath("//div[@class='visible menu transition']//span[@class='text'][normalize-space()='India']")).click();
	}
	@Then("Phone numbnber")
	public void phone_numbnber() {
		driver.findElement(By.xpath("//input[@placeholder='Number']")).sendKeys("9033333");
	   
	}
	@Then("click on save button")
	public void click_on_save_button() {
	   driver.findElement(By.xpath("//i[@class='save icon']")).click();
	}
	@Then("user is profile page")
	public void user_is_profile_page() {
		driver.close();
	    
	}





}
