package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;



public class HomePage extends TestBase {

	@FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[2]/span[1]")
	WebElement userNameLabel;

	@FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[2]/span[2]/a")
	WebElement billingSettings;

	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[2]")
	WebElement calender;

	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[3]/span")
	WebElement contacts;

	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[4]/span")
	WebElement companies;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {

		return driver.getTitle();
	}

	public boolean verifyUserNameLabel() {
		return userNameLabel.isDisplayed();
	}

	public TrailPage clickOnTrailLinkPage() {
		billingSettings.click();
		return new TrailPage();
	}

	public ContactsPage clickOnContactsPage() {
		contacts.click();
		return new ContactsPage();

	}

	
}
