package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegForm() {
        click(By.cssSelector("a[href='/login']"));
    }
    public void fillLoginRegForm(){
        findAndType(By.name("email"), "mara@gmail.com");
        findAndType(By.name("password"), "Mmar123456$");
    }
    public void loginSubmit(){
        click(By.xpath("//button[text()='Login']"));
    }
    public boolean isLogged() {
        return isElPressent(By.xpath("//button[text()='Sign Out']"));
    }

}

