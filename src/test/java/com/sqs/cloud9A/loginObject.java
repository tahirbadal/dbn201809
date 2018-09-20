package com.sqs.cloud9A;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginObject {
    WebDriver driver;


    private By emailLocator = By.name("email");
    private By passwordLocator = By.name("password");
    private By loginButtonLocator = By.xpath("/html/body/div/form/button");
    private By bodyTextLocator = By.tagName("body");
    private By homepageLocator = By.xpath("/html/body/center[3]/a");

    private String cloud9RegisterHeader = "Cloud9 - Register";
    private String registrationSuccessful = "Registration Successful";

    public loginObject(WebDriver driver) {

        this.driver = driver;
    }

    public void clickLogin(WebDriver driver){

        //System.out.println("Click Login Button");
        driver.findElement(loginButtonLocator).click();
    }

    public void clickHome(WebDriver driver){
        driver.findElement(homepageLocator).click();
    }


    public void populateLogin(String emailAddress, String password){
        driver.findElement(emailLocator).sendKeys(emailAddress);

        driver.findElement(passwordLocator).sendKeys(password);
        clickLogin(driver);
        clickHome(driver);
    }
}

