package com.sqs.cloud9A;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import sun.security.krb5.internal.crypto.Des;


public class bookObject {
    WebDriver driver;


    private By OriginLocator = By.name("Origin");
    private By DestinationLocator = By.name("Destination");
    private By SeatLocator = By.name("seat");
    private By ClassLocator = By.name("Flightclass");
    private By BookLocator = By.xpath("/html/body/div/div/div[2]/form/button");

    public bookObject(WebDriver driver) {

        this.driver = driver;
    }


    public void clickBook(WebDriver driver){
        driver.findElement(BookLocator).click();

    }

    public void PopulateBook(String origin, String destination, String seat, String classs){



        driver.findElement(OriginLocator).sendKeys(origin);
        driver.findElement(DestinationLocator).sendKeys(destination);
        driver.findElement(SeatLocator).sendKeys(seat);
        driver.findElement(ClassLocator).sendKeys(classs);



        //Select origin = new Select(driver.findElement(By.name("origin")));
        //origin.selectByVisibleText("London");
        //Select destination = new Select(driver.findElement(By.name("destination")));
        //destination.selectByVisibleText("dubai");
        //Select classs = new Select(driver.findElement(By.name("class")));
        //destination.selectByVisibleText("first");

        clickBook(driver);



    }





}
