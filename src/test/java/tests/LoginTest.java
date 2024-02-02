package tests;

import com.sun.net.httpserver.Authenticator;
//import manager.Retry;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Parameters({"name","browser"})
    @BeforeSuite
    public void bt(@Optional("text stub")String name, @Optional("text stub")String browser){
        System.out.println("Suite name "+name);
        System.out.println("Suite browser "+browser);
    }

    @Parameters("name")
    @Test(retryAnalyzer = Retry.class)
    public void login_test(){

        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm();
        app.getHelperUser().loginSubmit();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }


}


