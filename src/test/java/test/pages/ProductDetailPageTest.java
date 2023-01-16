package test.pages;

import drivers.Drivers;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.ProductDetailPage;
import util.FixedVariateUtil;
import util.PropertyUtil;

public class ProductDetailPageTest extends Drivers {
    private static ProductDetailPage m_productDetailPage;
    private static final String SIZE = FixedVariateUtil.getFixedVariate("productSize",
                                                                            "fixedVariate.properties");
    private static final String COLOR = "Lavender";
    private static final String QTY = FixedVariateUtil.getFixedVariate("productQuantity",
                                                                            "fixedVariate.properties");
    private static final String baseURL = PropertyUtil.getProperty("HoodieProductDetailURL",
            "config.properties");
    private static final String MESSAGE = "You added Marco Lightweight Active Hoodie to your shopping cart.";
    private static final String CART_COUNTER = "0";
    @BeforeClass
    public void start(){
        setUpDriver(baseURL);
        m_productDetailPage = new ProductDetailPage(m_driver);
    }
    @AfterClass
    public void finish(){
        quitDriver();
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
