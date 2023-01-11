package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class BasePage{

    protected WebDriver m_driver;
    private static final int DEFAULT_TIME_DURATION = 10;
    protected WebDriverWait m_webDriverWait;

    public BasePage(WebDriver driver) {
        m_driver = driver;
        m_webDriverWait = new WebDriverWait(m_driver, Duration.ofSeconds(5));
        PageFactory.initElements(m_driver, this);
    }
    public void sendKeys(WebElement element, String text){
        centerElement(element).sendKeys(text);
    }
    public WebElement centerElement(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) m_driver).executeScript(scrollElementIntoMiddle, element);
        return element;
    }
    public boolean isDisplayed(WebElement element){
        try {
            waitUntil(ExpectedConditions.visibilityOf(element));
            System.out.println("Element var!");
            return true;
        }catch (NoSuchElementException e){
            System.out.println("Element yok!");
            return false;
        }
    }
    public void waitUntil(final ExpectedCondition<?> expectedCondition) {
        waitCondition(DEFAULT_TIME_DURATION).until(expectedCondition);
    }
    private Wait<WebDriver> waitCondition(final int duration){
        return new FluentWait<>(m_driver)
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(duration))
                .ignoring(NoSuchElementException.class, WebDriverException.class);
    }
}
