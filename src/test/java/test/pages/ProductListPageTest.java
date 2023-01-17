package test.pages;

import drivers.Drivers;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.ProductListPage;
import util.PropertyUtil;

public class ProductListPageTest extends Drivers {

    private ProductListPage m_productListPage;
    private static final int PRODUCT_LIST_NUMBER = 0;
    private static final String PRODUCTS_SIZE = "L";
    private static final int COLOR_NO = 1;
    private static final String SORT_PRODUCTS = "Price";
    private static final String MESSAGE = "You added Oslo Trek Hoodie to your shopping cart.";
    private static final String CLICKED_MESSAGE = "Be the first to review this product";
    private static final String HTML_SIZE_MESSAGE = "swatch-option text selected";
    private static final String HTML_COLOR_MESSAGE = "swatch-option color selected";
    private static final String CART_COUNTER = "0";
    private static final String baseURL = PropertyUtil.getProperty("HoodieProductListURL",
            "config.properties");
    @BeforeClass
    public void start(){
        setUpDriver(baseURL);
        m_productListPage = new ProductListPage(m_driver);
    }
    @AfterClass
    public void finish(){
        quitDriver();
    }

    @Test
    public void sortTheProductTest(){
        m_productListPage.productListing(SORT_PRODUCTS);
        Assert.assertEquals(m_productListPage.getSortText(SORT_PRODUCTS), SORT_PRODUCTS, "Incorrect filter!");
    }
    @Test
    public void addToProductInTheCart(){
        m_productListPage.clickToProductSize(PRODUCTS_SIZE);
        Assert.assertTrue(m_productListPage.isSelectedSize(HTML_SIZE_MESSAGE), "Not selected correct size!");
        m_productListPage.clickToProductsColor(COLOR_NO);
        Assert.assertTrue(m_productListPage.isSelectedColor(HTML_COLOR_MESSAGE), "Not selected correct color!");
        m_productListPage.clickAddToCartButton();
        Assert.assertEquals(m_productListPage.getVerificationMessage(), MESSAGE, "Not the added cart!");
        Assert.assertNotEquals(m_productListPage.getCartCount(), CART_COUNTER, "Not the added cart!");
    }
    @Test
    public void clickFirstProduct(){
        m_productListPage.clickToProduct(PRODUCT_LIST_NUMBER);
        Assert.assertEquals(m_productListPage.clickedMessageText(), CLICKED_MESSAGE, "Product is not " +
                                                                                                    "clickable!");
    }
}
