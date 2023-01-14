package test.pages;

import drivers.Drivers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.ProductListPage;
import util.PropertyUtil;

public class ProductListPageTest extends Drivers {

    private ProductListPage m_productListPage;
    private final String NUMBER = "36";
    private final int INDEX_NO = 0;
    private final String PRODUCTS_SIZE = "S";
    private final int COLOR_NO = 1;
    private final String SORT_PRODUCTS = "Price";
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
    public void clickAllOfShoppingOptionsMenu(){
        m_productListPage.clickShoppingOptionsButtons();
    }
    @Test
    public void showNumberOfProductListOnPage(){
        m_productListPage.showNumberOfProductsOnThePage(NUMBER);
    }
    @Test
    public void sortByProducts(){
        m_productListPage.productListing(SORT_PRODUCTS);
    }
    @Test
    public void clickToFirstProduct(){
        m_productListPage.clickToProduct(INDEX_NO);
    }
    @Test
    public void selectSizeAndColor(){
        m_productListPage.clickToProductSize(PRODUCTS_SIZE);
        m_productListPage.clickToProductsColor(COLOR_NO);
    }
    @Test
    public void clickAddToCart(){
        m_productListPage.clickAddToCartButton();
    }
}
