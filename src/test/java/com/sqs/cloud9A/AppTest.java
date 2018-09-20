package com.sqs.cloud9A;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest 
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

        driver.findElement(By.xpath("/html/body/div/form/center/a")).click();
        driver.findElement(By.name("firstname")).sendKeys("Tahir");
        driver.findElement(By.name("lastname")).sendKeys("Badass");
        driver.findElement(By.name("email")).sendKeys("TB1@gmail.com");
        driver.findElement(By.name("password")).sendKeys("xxx");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();

        String bodyText= driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(registrationSuccessful));

    }

    @Test
    public void shouldLoginCustomer()
    {
        driver.findElement(By.xpath("/html/body/center/a")).click();
        driver.findElement(By.name("email")).sendKeys("TB@gmail.com");
        driver.findElement(By.name("password")).sendKeys("xxx");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();

    }

   /* @After
    public void tearDown()
    {
        driver.close();
    }
*/
}
