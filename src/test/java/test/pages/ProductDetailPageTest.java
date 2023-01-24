package test.pages;

import drivers.Drivers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.ProductDetailPage;
import util.URLNavigator;

public class ProductDetailPageTest extends Drivers {
    private static ProductDetailPage m_productDetailPage;
    private static final String SIZE = "L";
    private static final String COLOR = "Lavender";
    private static final String QTY = "3";
    private static final String MESSAGE = "You added Marco Lightweight Active Hoodie to your shopping cart.";
    private static final String CART_COUNTER = "0";

    @BeforeClass
    public void start(){
        m_productDetailPage = new ProductDetailPage(getDriver());
        m_productDetailPage.navigateTo(URLNavigator.goToProductDetailPage());
    }
    @Test
    public void productSelectTest(){
        m_productDetailPage.selectSizeofHoodie(SIZE);
        Assert.assertEquals(m_productDetailPage.getSize(), SIZE, "Not the chosen true size!");
        m_productDetailPage.selectColorOfHoodie();
        Assert.assertEquals(m_productDetailPage.getColor(), COLOR, "Not the chosen true color!");
        m_productDetailPage.entryNewQuantity(QTY);
        Assert.assertEquals(m_productDetailPage.getQTY(), QTY, "Not the chosen true QTY!");
    }
    @Test
    public void clickableToAddToCartButton() {
        m_productDetailPage.addToCartButton();
        Assert.assertEquals(m_productDetailPage.getAddedCartMessage(), MESSAGE, "Not the added cart!");
        Assert.assertNotEquals(m_productDetailPage.getCartCounterNumber(),CART_COUNTER,
                "Not the added cart!");
    }
}
