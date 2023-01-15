package test.pages;

import drivers.Drivers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.ProductListPage;
import util.FixedVariateUtil;
import util.PropertyUtil;

public class ProductListPageTest extends Drivers {

    private ProductListPage m_productListPage;
    private final String NUMBER =  FixedVariateUtil.getFixedVariate("productNumberForShowOnThePage",
            "fixedVariate.properties");
    private final int INDEX_NO = Integer.parseInt(FixedVariateUtil.getFixedVariate("productListNumber",
            "fixedVariate.properties"));
    private final String PRODUCTS_SIZE = FixedVariateUtil.getFixedVariate("productSize",
            "fixedVariate.properties");
    private final int COLOR_NO = Integer.parseInt(FixedVariateUtil.getFixedVariate(
            "productColorNumber", "fixedVariate.properties"));
    private final String SORT_PRODUCTS = FixedVariateUtil.getFixedVariate("productSort",
            "fixedVariate.properties");
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
