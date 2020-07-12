package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class='close' and contains(@id,'web')]")
    private WebElement closePopUpButton;

    @FindBy(id = "T7-from")
    private WebElement sourceInput;

    @FindBy(id = "T7-to")
    private WebElement destinationInput;

    @FindBy(xpath = "//*[@value=1 and @type='radio' and @name='bookingType']")
    private WebElement oneWayBooking;

    @FindBy(css = "button#T7-search")
    private WebElement searchButton;

    @FindBy(css = ".time-total")
    private List<WebElement> travelDuration;

    @FindBy(xpath = "//span[@class='NotLowestPrice' or @class='amountN']/span")
    private List<WebElement> priceOfTicket;

    @FindBy(xpath = "//*[starts-with(@id,'outbound') and starts-with(@class,'or-f-details')]")
    private List<WebElement> detailsOfEachTicket;

    @FindBy(css =  ".lowestPriceFareFamily span")
    private WebElement lowestFareTicketAfterSelected;

    public void searchFightTickets(String source, String destination) {
        try {
            Thread.sleep(40000);
        } catch(Exception e){
            e.printStackTrace();
        }

        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", oneWayBooking);
        }catch(Exception e){
            oneWayBooking.click();
        }


        sourceInput.sendKeys(source);
        sourceInput.sendKeys(Keys.TAB);
        destinationInput.sendKeys(destination);
        destinationInput.sendKeys(Keys.TAB);
        destinationInput.sendKeys(Keys.ENTER);
       // searchButton.click();
        try {
            Thread.sleep(3000);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getTitleOfThePage(){
        return driver.getTitle();
    }


    public ArrayList<Integer> getDurationOfTravel(){
        String timeOfTravel;
        ArrayList<String> listofTimes=new ArrayList<String>();
        ArrayList<Integer> listofTimesValue=new ArrayList<Integer>();
        for(int i=0; i< travelDuration.size(); i++) {
           timeOfTravel = travelDuration.get(i).getText();

            listofTimes.add(timeOfTravel);
            listofTimesValue.add(Integer.parseInt(listofTimes
                    .get(i)
                    .replaceAll("\\h.*", "")
                    .replace("h","")));
        }
        return listofTimesValue;
     }

    public ArrayList<Integer>  getPriceOfAllTickets(){
        String priceOfAllTickets;
        ArrayList<String> price=new ArrayList<String>();
        ArrayList<Integer> priceValue=new ArrayList<Integer>();
        for(int i=0; i< priceOfTicket.size(); i++) {
            priceOfAllTickets = priceOfTicket.get(i).getText();

            price.add(priceOfAllTickets);
            priceValue.add(Integer.parseInt(price.get(i)));
        }
        return priceValue;
    }

    public int getSmallest(ArrayList<Integer> arrayList){

        Collections.sort(arrayList);
        int element=arrayList.get(0);
        return element;
    }

    public void selectFasterDestinationAndLowestPrice(int fasterDestination, int lowestPrice){
        driver
                .findElement(By
                        .xpath("//*[starts-with(@id,'outbound') and starts-with(@class,'or-f-details')]/self::div/div/div/a/span/*[@class='ttl-time']/span[contains(text(),'"+fasterDestination+"')]/ancestor::*[starts-with(@id,'outbound') and starts-with(@class,'or-f-details')]/self::div/div/div/div/a/span/span/span[contains(text(),'"+lowestPrice+"')]"))
                .click();
    }

    public String getlowestFarePrice(){
        return lowestFareTicketAfterSelected.getText();
    }
}
