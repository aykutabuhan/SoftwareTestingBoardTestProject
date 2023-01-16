package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductDetailPage extends BasePage{

    @FindBy(css = "div[aria-labelledby*='option-label-size'] div")
    private List<WebElement> sizeOfBodies;
    @FindBy(css = "div[aria-labelledby*='option-label-color'] div")
    private List<WebElement> optionOfColors;
    @FindBy(css = "div[class='control'] input[id='qty']")
    private WebElement quantityField;
    @FindBy(css = "button[id='product-addtocart-button']")
    private WebElement addToCartButton;
    @FindBy(css = "div[attribute-code='size'] span[class*='swatch-attribute-selected']")
    private WebElement sizeText;
    @FindBy(css = "div[attribute-code='color'] span[class*='swatch-attribute-selected']")
    private WebElement colorText;
    @FindBy(css = "div[data-ui-id='message-success'] div")
    private WebElement addedCartMessageText;
    @FindBy(css = "span[class='counter-number']")
    private WebElement cartCounter;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    public void selectSizeofHoodie(String size){
        m_webDriverWait.until(ExpectedConditions.visibilityOfAllElements(sizeOfBodies));
        m_webDriverWait.until(ExpectedConditions.elementToBeClickable(selectElements(sizeOfBodies, size))).click();
    }
    public String getSize(){
        return getText(sizeText);
    }
    public void selectColorOfHoodie(){
        selectAndClickAllOfElements(optionOfColors);
    }
    public String getColor(){
        return getText(colorText);
    }
    public void entryNewQuantity(String quantity){
        m_webDriverWait.until(ExpectedConditions.visibilityOf(quantityField)).clear();
        sendKeys(quantityField, quantity);
    }
    public String getQTY(){
        return getValue(quantityField);
    }
    public void addToCartButton(){
        centerElement(addToCartButton).click();
    }
    public String getAddedCartMessage(){
        waitUntil(ExpectedConditions.visibilityOf(addedCartMessageText));
        return getText(addedCartMessageText);
    }
    public String getCartCounterNumber(){
        waitUntil(ExpectedConditions.visibilityOf(cartCounter));
        return getText(cartCounter);
    }
}
