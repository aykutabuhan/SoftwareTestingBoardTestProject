package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Drivers{

    protected WebDriver m_driver;
    public void navigateTo(String url){
        m_driver.get(url);
    }
    public void setUpDriver(String baseURL){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        m_driver = new ChromeDriver();
        navigateTo(baseURL);
        m_driver.manage().window().maximize();
    }
    public void quitDriver(){
        m_driver.quit();
    }
}
