package stepDefenitions;

import java.awt.AWTException;

import actions.ExpediaFlightsActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExpediaFlightsStepDefenition extends ExpediaFlightsActions{
	@Given("user is on expedia home page")
	public void user_is_on_expedia_home_page() {
	    launchApplication();
	}

	@When("user clicks on flights tab")
	public void user_clicks_on_flights_tab() {
	    clickFlights();
	}

	@When("user clicks on oneway")
	public void user_clicks_on_oneway() {
	    clickOneWay();
	}

	@When("enter source , destination and departure date")
	public void enter_source_destination_and_departure_date() throws AWTException {
	    enterSource();
	    enterDestination();
	   // enterDepartureDate();
	}

	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
	    clickSearch();
	}

	@Then("the corresponding seartch results should be displayed")
	public void the_corresponding_seartch_results_should_be_displayed() {
	    
	}
	@When("enter <source> , <destination> and <departure date>")
	public void enter_source_destination_and_departure_date(String source , String destination , String departureDate) throws AWTException {
	    enterSourceP(source);
	    enterDestinationP(destination);
	    enterDepartureDateP(departureDate);
	}




}
