package tests;

import com.sun.net.httpserver.Authenticator;
//import manager.Retry;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Parameters({"name"})
    @BeforeSuite
    public void bt(@Optional("text stub")String name){
        System.out.println("Suite name "+name);
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


