package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    WebDriver driver;
    By txtSearch = By.id("search_query_top");
    By btnSearch = By.xpath("//button[@name='submit_search']");
    By lblSearchResult = By.xpath("//span[@class='heading-counter']");
    String addToCartXPath = "//div[@class='product-container']//a[normalize-space(text()) = '{PRODUCT_NAME}']/../../div/a[@title='Add to cart']";

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    // Enter keyword into search box
    public void inputSearchKeyword(String searchWord){
        driver.findElement(txtSearch).sendKeys(searchWord);
    }

    // Click search button
    public void clickSearchButton(){
        driver.findElement(btnSearch).click();
    }

    // Input keyword + click Search
    public void searchKeyword(String searchWord){
        inputSearchKeyword(searchWord);
        clickSearchButton();
    }

    // Get search result
    public String getSearchResult(){
        return driver.findElement(lblSearchResult).getText();
    }

    // Add to cart
    public void addToCartByProductName(String productName){
        String xpath = addToCartXPath.replace("{PRODUCT_NAME}", productName);
        WebElement element = driver.findElement(By.xpath(xpath));

        // Scroll into view
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        // Click add to cart button
        element.click();
    }
}