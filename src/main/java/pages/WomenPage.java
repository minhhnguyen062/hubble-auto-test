package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomenPage extends BasePage{
    WebDriver driver;
    By bannerWomen = By.xpath("//div[contains(@style, '3-category_default.jpg')]");

    public WomenPage(WebDriver driver){
        super(driver);
        this.driver = super.driver;
    }

    // Check Women banner appears
    public boolean isWomenBannerAppeared(){
        return driver.findElement(bannerWomen).isDisplayed();
    }
}
