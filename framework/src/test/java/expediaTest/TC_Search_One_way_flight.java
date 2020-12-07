package expediaTest;

import java.awt.AWTException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import actions.ExpediaFlightsActions;
import frameworkUtils.FrameworkParameters;

public class TC_Search_One_way_flight extends TestBase{
	ExpediaFlightsActions expediaFlights;
	
	@BeforeTest
	public void setup() {
		
		expediaFlights = new ExpediaFlightsActions();
		launchApplication();
		
	}
	
	@Test
	public void testSearchFlightOneWay() throws AWTException {
		expediaFlights.clickFlights();
		expediaFlights.clickOneWay();
		expediaFlights.enterSource();
		expediaFlights.enterDestination();
		expediaFlights.enterDepartureDate();
		expediaFlights.clickSearch();
		
		
	}

}
