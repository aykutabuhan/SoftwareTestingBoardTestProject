package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class BasePage{

    protected WebDriver m_driver;
    private static final int DEFAULT_TIME_DURATION = 10;
    protected WebDriverWait m_webDriverWait;

    public BasePage(WebDriver driver) {
        m_driver = driver;
        m_webDriverWait = new WebDriverWait(m_driver, Duration.ofSeconds(DEFAULT_TIME_DURATION));
        PageFactory.initElements(m_driver, this);
    }
    public void sendKeys(WebElement element, String text){
        centerElement(element).sendKeys(text);
    }
    public String getValue(WebElement element){
        return centerElement(element).getAttribute("value");
    }
    public String getText(WebElement element){
        return element.getText();
    }
    public String getText(List<WebElement> elements, String text){
        return selectElements(elements, text).getText();
    }
    public boolean getAttributeText(List<WebElement> elements, String htmlField, String htmlValue){
        for (WebElement element : elements)
            if (element.getAttribute(htmlField).equalsIgnoreCase(htmlValue))
                return true;
        return false;
    }
    public WebElement selectElements(List<WebElement> elements, String text){
        for (WebElement select : elements)
            if (select.getText().equalsIgnoreCase(text))
                return centerElement(select);
        return null;
    }
    public WebElement selectElements(List<WebElement> elements, int number){
        return centerElement(elements.get(number));
    }
    public void clickAllOfElements(List<WebElement> elements){
        for (WebElement element : elements)
            m_webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void clickElementListWithIndexNo(List<WebElement> elements, int indexNo){
        m_webDriverWait.until(ExpectedConditions.elementToBeClickable(centerElement(elements.get(indexNo)))).click();
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
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
    public void waitUntil(final ExpectedCondition<?> expectedCondition) {
        waitCondition(DEFAULT_TIME_DURATION).until(expectedCondition);
    }
    public void waitUntil(final ExpectedCondition<?> expectedCondition, int duration){
        waitCondition(duration).until(expectedCondition);
    }
    private Wait<WebDriver> waitCondition(final int duration){
        return new FluentWait<>(m_driver)
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(duration))
                .ignoring(NoSuchElementException.class, WebDriverException.class);
    }
    public void clearField(WebElement element){
        m_webDriverWait.until(ExpectedConditions.visibilityOf(element)).clear();
    }
    public void navigateTo(String url){
        m_driver.get(url);
    }
}
