package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomescreenPage extends BasePage{
    WebDriver driver;
    By btnSignIn = By.xpath("//a[@href='http://automationpractice.com/index.php?controller=my-account' and @class='login']");
    By tabWomen = By.xpath("//a[@title='Women']");

    public HomescreenPage(WebDriver driver){
        super(driver);
        this.driver = super.driver;
    }

    //Sign in
    public void clickSignIn() {
        driver.findElement(btnSignIn).click();
    }

    //Click Women tab
    public void clickWomenTab() {
        driver.findElement(tabWomen).click();
    }

}