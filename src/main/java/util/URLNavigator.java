package util;

public class URLNavigator{

    private static final String CREATE_ACCOUNT_URL = "/customer/account/create/";
    private static final String PRODUCT_LIST_URL = "/men/tops-men/hoodies-and-sweatshirts-men.html";
    private static final String PRODUCT_DETAIL_URL = "/marco-lightweight-active-hoodie.html";
    public static String goToCreateNewAccountPage(){
        return PropertyUtil.getProperty("BaseURL", "config.properties")
                .concat(CREATE_ACCOUNT_URL);
    }
    public static String goToProductListPage(){
        return PropertyUtil.getProperty("BaseURL", "config.properties")
                .concat(PRODUCT_LIST_URL);
    }
    public static String goToProductDetailPage(){
        return PropertyUtil.getProperty("BaseURL", "config.properties")
                .concat(PRODUCT_DETAIL_URL);
    }
}
