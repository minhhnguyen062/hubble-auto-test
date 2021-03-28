package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    WebDriver driver;
    By btnMyWishlist = By.xpath("//a[@title='My wishlists']");

    public MyAccountPage(WebDriver driver){

        this.driver = driver;
    }

    //Check My Wishlist button appears
    public boolean isMyWishlistButtonVisible() {
        return driver.findElement(btnMyWishlist).isDisplayed();
    }

}