package actions;


import java.awt.AWTException;

import ui.ExpediaHomePage;

public class ExpediaFlightsActions extends ExpediaReusableActions{
	public void launchExpedia() {
		launchApplication();
	}
	
	public void clickFlights() {
		click(ExpediaHomePage.FLIGHT_TAB);
	}
	public void clickOneWay() {
		click(ExpediaHomePage.ONEWAY);
	}
	public void enterSource() throws AWTException {
		click("//button[@aria-label='Leaving from']");
		//enterText(ExpediaHomePage.LEAVING_FROM, expediaTest.getData("testData", "TC_Search_One_way_flight", "Source") );
		enterText(ExpediaHomePage.LEAVING_FROM,expediaTest.getData("Source"));
	}
	public void enterDestination() throws AWTException {
		click("//button[@aria-label='Going to']");
		enterText(ExpediaHomePage.GOING_TO, "Delhi");
	}
	public void enterDepartureDate() {
		selectDate("12/15/2020");
	}
	public void clickSearch() {
		click(ExpediaHomePage.SEARCH_BUTTON);
	}
	public void enterSourceP(String source) throws AWTException {
		click("//button[@aria-label='Leaving from']");
		//enterText(ExpediaHomePage.LEAVING_FROM, expediaTest.getData("testData", "TC_Search_One_way_flight", "Source") );
		enterText(ExpediaHomePage.LEAVING_FROM,source);
	}
	public void enterDestinationP(String destination) throws AWTException {
		click("//button[@aria-label='Going to']");
		enterText(ExpediaHomePage.GOING_TO, destination);
	}
	public void enterDepartureDateP(String departureDate) {
		selectDate(departureDate);
	}
	
	
	
	

}
