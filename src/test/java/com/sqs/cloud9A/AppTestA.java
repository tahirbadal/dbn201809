package com.sqs.cloud9A;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTestA
{
    /**
     * Rigorous Test :-)
     */
    static WebDriver driver;
    private String registrationSuccessful = "Registration Successful";
    private By bodyTextLocator = By.tagName("body");
    private String cloud9RegisterHeader = "Register Header";

    @Before
    public void testSetup()
    {
        System.out.println("In testSetup");
        
    }

    @BeforeClass
    public static void browserSetup() throws InterruptedException {
        //System.setProperty("ChromeDriver", "C:\\Drivers\\chromedriver");
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        String baseUrl = "http://10.9.10.39:81/sqlite/Main/login.html";
        String expectedTitle = "Cloud9 Airlines";
        driver.get(baseUrl);
        String actualTitle = driver.getTitle();
        System.out.println("Actual title is: " +actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
        Thread.sleep(5000);
    }

    @Test
    public void shouldRegisterNewCustomer()
    {
        driver.findElement(By.linkText("Register")).click();
        registrationObject registrationPage;
        registrationPage = new registrationObject(driver);
        registrationPage.populateRegistration("T","B", "TB2@gmail.com", "xxx");
    }

    @Test
    public void shouldLoginCustomer()
    {
        loginObject loginPage;
        loginPage = new loginObject(driver);
        loginPage.populateLogin("TB2@gmail.com", "xxx");
    }

    @Test
    public void shouldBookFlight()
    {
        shouldLoginCustomer();
        driver.findElement(By.linkText("Book Flight")).click();
        bookObject bookpage;
        bookpage = new bookObject(driver);
        bookpage.PopulateBook("Chicago","Dubai", "23a", "First");
    }

    @Test
    public void shouldEditSeat() throws InterruptedException {

        loginObject loginPage;
        loginPage = new loginObject(driver);
        loginPage.populateLogin("TB2@gmail.com", "xxx");

        String flightID = "297";
        String newSeatNumber = "23a";
        itineraryObject itineraryPage;
        itineraryPage = new itineraryObject(driver);
        String editURL = itineraryPage.scanBookingsAndFindFlightID(flightID);
        System.out.println("editURL is: " + editURL);

        if (editURL.equals("notfound")) {
            System.out.println("flightID: " + flightID + " not found");
        } else {
            driver.get(editURL);
            // TODO create new object for editFlight class
            // TODO call the update method

            editObject editPage;
            editPage = new editObject(driver);
            editPage.editBooking(driver, newSeatNumber);
        }
    }

    }