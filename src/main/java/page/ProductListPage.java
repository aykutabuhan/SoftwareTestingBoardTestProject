package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductListPage extends BasePage{

    @FindBy(css = "strong[class*='product '] a")
    private List<WebElement> listOfProducts;
    @FindBy(css = "div[class='reviews-actions'] a")
    private WebElement productClickedMessage;
    @FindBy(css = "div[aria-label='Size'] div")
    private List<WebElement> listOfProductsSize;
    @FindBy(css = "div[aria-label='Color'] div")
    private List<WebElement> listOfProductColor;
    @FindBy(css = "div[class*='toolbar-sorter'] select[id='sorter']")
    private WebElement sortByButton;
    @FindBy(css = "select[id='sorter'] option")
    private List<WebElement> listOfSortBy;
    @FindBy(css = "button[title='Add to Cart']")
    private WebElement addToCartButton;
    @FindBy(css = "div[class*='message-success'] div")
    private WebElement verificationMessage;
    @FindBy(css = "span[class*='counter']")
    private WebElement cartCounter;

    private static final String HTML_FIELD = "class";
    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public void clickToProduct(int number) {
        m_webDriverWait.until(ExpectedConditions.visibilityOfAllElements(listOfProducts));
        clickElementListWithIndexNo(listOfProducts, number);
    }
    public String clickedMessageText(){
        return getText(productClickedMessage);
    }
    public void clickToProductSize(String size){
        m_webDriverWait.until(ExpectedConditions.visibilityOfAllElements(listOfProductsSize));
        m_webDriverWait.until(ExpectedConditions.elementToBeClickable(selectElements(listOfProductsSize, size)))
                                                                                            .click();
    }
    public boolean isSelectedSize(String HTML_VALUE){
        return getAttributeText(listOfProductsSize, HTML_FIELD, HTML_VALUE);
    }
    public void clickToProductsColor(int colorNo){
        m_webDriverWait.until(ExpectedConditions.visibilityOfAllElements(listOfProductColor));
        clickElementListWithIndexNo(listOfProductColor, colorNo);
    }
    public boolean isSelectedColor(String HTML_VALUE){
        return getAttributeText(listOfProductColor, HTML_FIELD, HTML_VALUE);
    }
    public void clickAddToCartButton(){
        m_webDriverWait.until(ExpectedConditions.visibilityOf(centerElement(addToCartButton))).click();
    }
    public String getVerificationMessage(){
        waitUntil(ExpectedConditions.visibilityOf(verificationMessage));
        return getText(verificationMessage);
    }
    public String getCartCount(){
        waitUntil(ExpectedConditions.visibilityOf(cartCounter));
        return getText(cartCounter);
    }
    public void productListing(String listFilter){
        m_webDriverWait.until(ExpectedConditions.elementToBeClickable(centerElement(sortByButton))).click();
        m_webDriverWait.until(ExpectedConditions.elementToBeClickable(selectElements(listOfSortBy, listFilter)))
                                                                                            .click();
    }
    public String getSortText(String  listFilter){
        waitUntil(ExpectedConditions.visibilityOf(sortByButton));
        return getText(listOfSortBy, listFilter);
    }
}
