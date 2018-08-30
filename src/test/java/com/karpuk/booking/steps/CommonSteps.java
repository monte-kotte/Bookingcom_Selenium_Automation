package com.karpuk.booking.steps;

import com.karpuk.booking.components.GuestsInformationForm;
import com.karpuk.booking.components.Header;
import com.karpuk.booking.driver.DriverSingleton;
import com.karpuk.booking.pages.MainAccommodationPage;
import com.karpuk.booking.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class CommonSteps {

    private WebDriver driver;

    public CommonSteps() {
    }

    public void initDriver() {
        driver = DriverSingleton.getDriver();
    }

    public void closeDriver() {
        DriverSingleton.closeDriver();
    }

    public MainAccommodationPage openMainPage() {
        MainAccommodationPage mainPage = new MainAccommodationPage(driver);
        mainPage.openPage();
        return mainPage;
    }

    public void selectRegion(String regionName) {
        MainAccommodationPage mainPage = new MainAccommodationPage(driver);
        mainPage.selectRegion(regionName);
    }

    public void selectCheckInDate(LocalDate checkInDate) {
        MainAccommodationPage mainPage = new MainAccommodationPage(driver);
        mainPage.selectCheckInDate(checkInDate);
    }

    public void selectCheckOutDate(LocalDate checkOutDate) {
        MainAccommodationPage mainPage = new MainAccommodationPage(driver);
        mainPage.selectCheckOutDate(checkOutDate);
    }

    public void selectGuestsInformation(int numberOfRooms, int numberOfAdults, int numberOfChildren) {
        GuestsInformationForm guestsForm = new GuestsInformationForm(driver);
        guestsForm.openGuestForm();
        guestsForm.selectGuestsInformation(numberOfRooms, numberOfAdults, numberOfChildren);
    }

    public void selectNumberOfChildren(int numberOfChildren){
        GuestsInformationForm guestsForm = new GuestsInformationForm(driver);
        guestsForm.openGuestForm();
        guestsForm.selectChildren(numberOfChildren);
    }

    public void clickSearchButton() {
        MainAccommodationPage mainPage = new MainAccommodationPage(driver);
        mainPage.clickSearchButton();
    }

    public int getNumberOfSearchResults() {
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        return resultsPage.getNumberOfResults();
    }

    public void selectAvailability() {
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        resultsPage.selectAvailabilityCheckbox();
    }

    public boolean selectStarRating(int starRating) {
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        return resultsPage.selectStarRating(starRating);
    }

    public boolean selectBudget(int budgetGroupNumber) {
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        return resultsPage.selectBudgetGroup(budgetGroupNumber);
    }

    public void selectFreeCancellation(){
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        resultsPage.selectFreeCancellation();
    }

    public boolean setCurrency(String currencyName) {
        Header header = new Header(driver);
        return header.selectCurrency(currencyName);
    }

    public boolean setLanguage(String language) {
        Header header = new Header(driver);
        return header.selectLanguage(language);
    }

}
