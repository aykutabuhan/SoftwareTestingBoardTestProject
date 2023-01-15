package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductListPage extends BasePage{
    @FindBy(css = "div [class='filter-options'] div[class='filter-options-item'] ")
    private List<WebElement> listOfShoppingOptions;
    @FindBy(css = "strong[class='product name product-item-name'] a")
    private List<WebElement> listOfProducts;
    @FindBy(css = "div[class='swatch-attribute size'] div[class='swatch-attribute-options clearfix'] div")
    private List<WebElement> listOfProductsSize;
    @FindBy(css = "div[aria-label='Color'] div")
    private List<WebElement> listOfProductColor;
    @FindBy(css = "div[class='toolbar-sorter sorter'] select[id='sorter']")
    private WebElement sortByButton;
    @FindBy(css = "div[class='toolbar-sorter sorter'] select[id='sorter'] option")
    private List<WebElement> listOfSortBy;
    @FindBy(css = "button[title='Add to Cart']")
    private WebElement addToCartButton;
    @FindBy(css = "body > div:nth-child(5) > main:nth-child(4) > div:nth-child(4) > div:nth-child(1) > div:nth-child(5) > div:nth-child(4) > div:nth-child(2) > select:nth-child(1)")
    private WebElement showProductPerPageButton;
    @FindBy(css = "div[class='toolbar toolbar-products'] div[class='field limiter'] div[class='control'] select[id='limiter'] option")
    private List<WebElement> listOfShowPerPage;
    public ProductListPage(WebDriver driver) {
        super(driver);
    }
    public void clickShoppingOptionsButtons(){
        m_webDriverWait.until(ExpectedConditions.visibilityOfAllElements(listOfShoppingOptions));
        selectAndClickAllOfElements(listOfShoppingOptions);
    }
    public void clickToProduct(int number) {
        m_webDriverWait.until(ExpectedConditions.visibilityOfAllElements(listOfProducts));
        clickElementListWithIndexNo(listOfProducts, number);
        m_driver.navigate().back();
    }
    public void clickToProductSize(String size){
        m_webDriverWait.until(ExpectedConditions.visibilityOfAllElements(listOfProductsSize));
        m_webDriverWait.until(ExpectedConditions.elementToBeClickable(selectElements(listOfProductsSize, size)))
                                                                                            .click();
    }
    public void clickToProductsColor(int colorNo){
        m_webDriverWait.until(ExpectedConditions.visibilityOfAllElements(listOfProductColor));
        clickElementListWithIndexNo(listOfProductColor, colorNo);
    }
    public void clickAddToCartButton(){
        centerElement(addToCartButton).click();
    }
    public void productListing(String listFilter){
        m_webDriverWait.until(ExpectedConditions.elementToBeClickable(centerElement(sortByButton))).click();
        m_webDriverWait.until(ExpectedConditions.elementToBeClickable(selectElements(listOfSortBy, listFilter)))
                                                                                            .click();
    }
    public void showNumberOfProductsOnThePage(String number){
        m_webDriverWait.until(ExpectedConditions.elementToBeClickable(centerElement(showProductPerPageButton)))
                                                                                            .click();
        m_webDriverWait.until(ExpectedConditions.elementToBeClickable(selectElements(listOfShowPerPage, number)))
                                                                                            .click();
    }
}
