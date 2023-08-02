package steps;

import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import runner.ChromeTestRunner;


public class HomeStep extends ChromeTestRunner {

    public HomePage homePage;
    @Given("^User on home page$")
    public void user_on_home_page() {
    homePage = new HomePage(driver);
    }

    @When("^User search with source \"(.*)\" and destination \"(.*)\"$")
    public void search_flights(String source, String destination) {
        homePage.searchFightTickets(source, destination);
    }

    @And("^User verify title of the search page$")
    public void verify_title_of_the_page() throws InterruptedException {
        Assert.assertTrue(homePage.getTitleOfThePage()
                .equals("Choose a flight"));
        Thread.sleep(20000);
        System.out.println(homePage.getDurationOfTravel());
        System.out.println(homePage.getPriceOfAllTickets());
        System.out.println("get smallest integer" + homePage.getSmallest(homePage.getDurationOfTravel()));
        System.out.println("get smallest integer" + homePage.getSmallest(homePage.getPriceOfAllTickets()));
    }

    @Then("^User select fastest and cheapest ticket$")
    public void user_select_faster_cheapest_flight_ticket(){
        homePage.selectFasterDestinationAndLowestPrice(homePage.getSmallest(homePage.getDurationOfTravel()),
                homePage.getSmallest(homePage.getPriceOfAllTickets()));
        System.out.println(homePage.getlowestFarePrice().trim());
        Integer lowestPrice = Integer.parseInt(homePage.getlowestFarePrice().trim());
        Assert.assertTrue(lowestPrice.equals(homePage.getSmallest(homePage.getPriceOfAllTickets())));
        System.out.println("Success");
    }
}
