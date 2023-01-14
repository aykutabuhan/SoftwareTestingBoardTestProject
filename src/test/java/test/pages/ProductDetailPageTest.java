package test.pages;

import drivers.Drivers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.ProductDetailPage;
import util.PropertyUtil;

public class ProductDetailPageTest extends Drivers {
    private static ProductDetailPage m_productDetailPage;
    private static final String SIZE = "XL"; // XS - S - M - L - XL
    private static final String QTY = "3";
    private static final String baseURL = PropertyUtil.getProperty("HoodieProductDetailURL",
            "config.properties");
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
    public void selectHoodieSize(){
        m_productDetailPage.selectSizeofHoodie(SIZE);
    }
    @Test
    public void selectHoodieColor(){
        m_productDetailPage.selectColorOfHoodie();
    }
    @Test
    public void quantityOfHoodie(){
        m_productDetailPage.entryNewQuantity(QTY);
    }
    @Test
    public void clickableToAddToCartButton(){
        m_productDetailPage.addToCartButton();
    }
}
