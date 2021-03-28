package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By txtLoginEmail = By.id("email");
    By txtLoginPassword = By.id("passwd");
    By btnSignIn = By.id("SubmitLogin");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Enter login email
    public void inputEmail(String strEmail) {
        driver.findElement(txtLoginEmail).sendKeys(strEmail);
    }

    //Enter login password
    public void inputPassword(String strPwd){
        driver.findElement(txtLoginPassword).sendKeys(strPwd);
    }

    //Click Sign In
    public void clickSignInBtn(){
        driver.findElement(btnSignIn).click();
    }

    //Log in
    public void loginAccount(String strEmail, String strPwd){
        inputEmail(strEmail);
        inputPassword(strPwd);
        clickSignInBtn();
    }
}
