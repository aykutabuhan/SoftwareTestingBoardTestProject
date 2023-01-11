package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Drivers{

    protected WebDriver m_driver;
    private static final String BASE_URL = "https://magento.softwaretestingboard.com/customer/account/create/";
    public void navigateTo(String url){
        m_driver.get(url);
    }
    @BeforeClass
    public void setUpDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        m_driver = new ChromeDriver();
        navigateTo(BASE_URL);
        m_driver.manage().window().maximize();
    }

    @AfterClass
    public void quitDriver(){
        m_driver.quit();
    }
}
