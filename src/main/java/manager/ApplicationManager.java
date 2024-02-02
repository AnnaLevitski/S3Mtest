package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.safari.SafariDriver;


import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    HelperUser helperUser;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        //wd = new ChromeDriver();
        if (browser.equals(Browser.EDGE) || browser.equals("MicrosoftEdge")) {
            wd = new EdgeDriver();
        } else if (browser.equals(Browser.FIREFOX) || browser.equals("firefox")) {
            wd = new FirefoxDriver();
        } else if (browser.equals(Browser.SAFARI) || browser.equals("safari")) {
            wd = new SafariDriver();
        } else {
            wd = new ChromeDriver();
        }
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
        wd.navigate().to("https://telranedu.web.app/");
        helperUser = new HelperUser(wd);
    }
    public HelperUser getHelperUser() {
        return helperUser;
    }
    public void stop(){
        wd.quit();
    }


}
