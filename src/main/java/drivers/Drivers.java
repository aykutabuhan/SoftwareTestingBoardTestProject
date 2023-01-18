package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import util.URLNavigator;


public class Drivers extends URLNavigator {
    protected WebDriver m_driver;

    @BeforeClass
    public void setUpDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        m_driver = new ChromeDriver();
        m_driver.manage().window().maximize();
    }
    @AfterClass
    public void quitDriver(){
        m_driver.quit();
    }
}
