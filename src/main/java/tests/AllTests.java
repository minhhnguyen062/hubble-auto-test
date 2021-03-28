package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomescreenPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.WomenPage;

public class AllTests {
    WebDriver driver;
    LoginPage objLoginPage;
    HomescreenPage objHomescreenPage;
    MyAccountPage objMyAccountPage;
    WomenPage objWomenPage;

    @BeforeTest
    public void setup(ITestContext context) {

        System.setProperty("webdriver.chrome.driver", "../chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
        context.setAttribute("driver", driver);
    }

    @Test(priority = 0)
    public void test_Login_My_Wishlist_Button_Appear(ITestContext context) {
        // Create Homescreen object
        objHomescreenPage = new HomescreenPage((WebDriver) context.getAttribute("driver"));

        // Tap on Sign In
        objHomescreenPage.clickSignIn();

        // Go to Login Screen
        objLoginPage = new LoginPage((WebDriver) context.getAttribute("driver"));

        // Login to account
        objLoginPage.loginAccount("gr4vest0ne@gmail.com", "123456789");

        // Go to My Account screen
        objMyAccountPage = new MyAccountPage((WebDriver) context.getAttribute("driver"));

        // Check if My Wishlist button is available
        Assert.assertTrue(objMyAccountPage.isMyWishlistButtonVisible(), "My Wishlist button is unavailable");

    }

    @Test(priority = 1)
    public void test_Search_Textbox(ITestContext context) {
        // go to women page
        objHomescreenPage = new HomescreenPage((WebDriver) context.getAttribute("driver"));
        objHomescreenPage.clickWomenTab();

        // go to Women page
        objWomenPage = new WomenPage((WebDriver) context.getAttribute("driver"));

        // check if Women banner is displayed
        Assert.assertTrue(objWomenPage.isWomenBannerAppeared(), "Women banner is not available");

        // Search "dress" on search box
        objWomenPage.searchKeyword("dress");

        // Verify the search has been done
        Assert.assertTrue(objWomenPage.getSearchResult().contains("results have been found"), "Search Result is not available");
    }

    @Test(priority = 2)
    public void test_Buy_Product(ITestContext context) {
        test_Search_Textbox(context);

        // click add to cart the product with Product Name
        objWomenPage = new WomenPage((WebDriver) context.getAttribute("driver"));
        objWomenPage.addToCartByProductName("Printed Summer Dress");
    }

    @AfterMethod
    public void returnToHomescreen(ITestContext context){
        driver = (WebDriver) context.getAttribute("driver");
        driver.get("http://automationpractice.com/");
    }

    @AfterTest
    public void teardown(ITestContext context) {
        driver = (WebDriver) context.getAttribute("driver");
        driver.close();
    }
}
