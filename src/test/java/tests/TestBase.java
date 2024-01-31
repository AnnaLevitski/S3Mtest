package tests;

import manager.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase {
    static ApplicationManager app = new ApplicationManager(System.getProperty("browser", String.valueOf(Browser.CHROME)));

    @BeforeSuite(alwaysRun = true)
    public void setApp(){
        app.init();
    }
    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        app.stop();
    }
}


