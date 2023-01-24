package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class Drivers{
   // protected WebDriver m_driver;
    protected ThreadLocal<WebDriver> m_driver = new ThreadLocal<>();

    @BeforeClass
    public void startDriver() throws MalformedURLException {
       // System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
       // m_driver = new ChromeDriver();
        setDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new ChromeOptions()));
        m_driver.get().manage().window().maximize();
    }
    @AfterClass
    public void exitDriver(){
        m_driver.get().quit();
    }

    public WebDriver getDriver(){
        return m_driver.get();
    }
    public void setDriver(RemoteWebDriver driver){
        m_driver.set(driver);
    }
}
