$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("home.feature");
formatter.feature({
  "line": 2,
  "name": "As an user I want to select best itenary based on the fastest and cheapest travel",
  "description": "",
  "id": "as-an-user-i-want-to-select-best-itenary-based-on-the-fastest-and-cheapest-travel",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@web"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Verify Search results page",
  "description": "",
  "id": "as-an-user-i-want-to-select-best-itenary-based-on-the-fastest-and-cheapest-travel;verify-search-results-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User on home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User search with source \"DOH\" and destination \"LHR\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User verify title of the search page",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "User select fastest and cheapest ticket",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeStep.user_on_home_page()"
});
formatter.result({
  "duration": 137158111,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DOH",
      "offset": 25
    },
    {
      "val": "LHR",
      "offset": 47
    }
  ],
  "location": "HomeStep.search_flights(String,String)"
});
formatter.result({
  "duration": 40007631583,
  "error_message": "java.lang.NullPointerException\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:70)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:39)\n\tat com.sun.proxy.$Proxy20.click(Unknown Source)\n\tat Pages.HomePage.searchFightTickets(HomePage.java:59)\n\tat steps.HomeStep.search_flights(HomeStep.java:21)\n\tat ✽.When User search with source \"DOH\" and destination \"LHR\"(home.feature:6)\n",
  "status": "failed"
});
formatter.match({
  "location": "HomeStep.verify_title_of_the_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HomeStep.user_select_faster_cheapest_flight_ticket()"
});
formatter.result({
  "status": "skipped"
});
});