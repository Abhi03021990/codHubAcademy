package stepDefenitions;

import actions.SavaariCarRentalActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SavaariCarrentalStepDefinition extends SavaariCarRentalActions{
	@Given("user is on the savaari home page")
	public void user_is_on_the_savaari_home_page() {
	    launchApplication();
	}

	@When("user enters from , to ,  enters pickup date and time")
	public void user_enters_from_to_enters_pickup_date_and_time() {
	    enterFrom("Kolkata");   
	    enterTo("Khurda");
	    selectDate("10-02-2021");
	    selecPickupTime("7:00 PM ");
	}

	@When("user clicks on the select car")
	public void user_clicks_on_the_select_car() {
	   selectCar();
	}

	@Then("search results based on the entered details should be displayed")
	public void search_results_based_on_the_entered_details_should_be_displayed() {
	    
	}

}
