package com.zerobank.step_definitions;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp(){
        System.out.println("\tthis is coming from BEFORE");

        String browser = ConfigurationReader.getProperty("browser");
        if(!browser.contains("mobile")){
            Driver.getDriver().manage().window().maximize();
        }
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    @Before
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){

            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());
        }

        Driver.closeDriver();
    }
}
