package com.freecrm.testpages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.pages.TrailPage;



public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
    TrailPage trailLink;
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initalization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		trailLink = new TrailPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void VerifyHomePageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRM", "Home page title not matched");

	}

	@Test(priority = 2)
	public void userNameLabelTest() {
		Assert.assertTrue(homePage.verifyUserNameLabel());

	}

	@Test(priority = 3)
	public void checkClickingOnContactsLinkTest() {
		contactsPage = homePage.clickOnContactsPage();
	}
    
	@Test(priority = 4)
	public void verifyClickingOnTrialLinkTest() {
		trailLink = homePage.clickOnTrailLinkPage();
	}
	
	
      @AfterMethod
      public void tearDown() {
    	  driver.quit();
      }
}
