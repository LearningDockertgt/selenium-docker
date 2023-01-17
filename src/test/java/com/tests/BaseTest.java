package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        // BROWSER => chrome / firefox
        // HUB_HOST => localhost / 10.0.1.3 / hostname
        String Node = "http://localhost:4444";
        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
       // caps.setBrowserName("chrome");
        caps.setBrowserName("chrome");
        driver = new RemoteWebDriver(new URL(Node), caps);
        /* The execution happens on the Selenium Grid with the address mentioned earlier */
       /* String host = "localhost";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        }else{
            dc = DesiredCapabilities.chrome();
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String testName = ctx.getCurrentXmlTest().getName();

        String completeUrl = "http://" + host + ":4444/wd/hub";
        dc.setCapability("name", testName);
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);*/
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }



}
