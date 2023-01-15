package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductDetailPage extends BasePage{

    @FindBy(css = "div[class='swatch-attribute size'] div[class='swatch-attribute-options clearfix'] div")
    private List<WebElement> sizeOfBodies;
    @FindBy(css = "div[class='swatch-attribute color'] div[aria-labelledby='option-label-color-93'] div")
    private List<WebElement> optionOfColors;
    @FindBy(css = "div[class='control'] input[id='qty']")
    private WebElement quantityField;
    @FindBy(css = "button[id='product-addtocart-button']")
    private WebElement addToCartButton;
    @FindBy(css = "div[class='product data items'] div a")
    private WebElement productDetailAndInformation;
    @FindBy(css = "div[class=\"swatch-attribute size\"] span[class=\"swatch-attribute-selected-option\"]")
    private WebElement sizeString;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    public void selectSizeofHoodie(String size){
        m_webDriverWait.until(ExpectedConditions.visibilityOfAllElements(sizeOfBodies));
        m_webDriverWait.until(ExpectedConditions.elementToBeClickable(selectElements(sizeOfBodies, size))).click();
    }
    public void selectColorOfHoodie(){
        selectAndClickAllOfElements(optionOfColors);
    }
    public void entryNewQuantity(String quantity){
        m_webDriverWait.until(ExpectedConditions.visibilityOf(quantityField)).clear();
        sendKeys(quantityField, quantity);
    }
    public void addToCartButton(){
        centerElement(addToCartButton).click();
    }
}
