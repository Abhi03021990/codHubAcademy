package actions;

import java.time.Month;

import frameworkUtils.CoreUtils;
import frameworkUtils.WaitHandler;
import ui.SavaariCarRentalPage;

public class SavaariCarRentalActions extends CoreUtils{
	public void enterValues(String xpath , String value) {
		typeText(xpath, value);
	    wait = new WaitHandler();
	    wait.waitForElementToBeloaded(SavaariCarRentalPage.DROPDOWN_ITEMS);
	    pressDownArrow(xpath);
	    pressEnter(xpath);
	}
	public void enterFrom(String fromCity) {
		enterValues(SavaariCarRentalPage.FROM_CITY, fromCity);
	}
	public void enterTo(String toCity) {
		enterValues(SavaariCarRentalPage.TO_CITY, toCity);
	}
	
	public void selectDate(String dateMMDDYYYY) {//12/12/2020 or 12-12-2020
		String year = dateMMDDYYYY.split("-|/")[2];
		String month = dateMMDDYYYY.split("-|/")[0];
		String day = dateMMDDYYYY.split("-|/")[1];
		click("(//label[text()='PICK UP']/parent::div/div//input)[1]");
		try {
			while (!(getElement("//span[contains(@class,'ui-datepicker-year')]").getText().equals(year))) {
				click("//a[@class='ui-datepicker-next ui-corner-all']");
				
			}
			while (!(getElement("//span[contains(@class,'ui-datepicker-month')]").getText().toUpperCase().equals(Month.of(Integer.parseInt(month)).toString()))) {
				click("//a[@class='ui-datepicker-next ui-corner-all']");
				
			}
			Thread.sleep(2000);
			click("//a[text()='"+day+"']");
			Thread.sleep(2000);
			pressTab("(//label[text()='PICK UP']/parent::div/div//input)[1]");
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void selecPickupTime(String time) {
		selectByVisibleText(SavaariCarRentalPage.PICKUP_TIME, time);
	}
	public void selectCar() {
		click(SavaariCarRentalPage.SELECT_CAR);
	}

}
