package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateNewCustomerAccountPage extends BasePage{
    @FindBy(css = "input[id='firstname']")
    private WebElement firstNameSpace;
    @FindBy(css = "input[id='lastname']")
    private WebElement lastNameSpace;
    @FindBy(css = "input[id='is_subscribed']")
    private WebElement signUpForNewsletterRadioButton;
    @FindBy(css = "input[id='email_address']")
    private WebElement emailSpace;
    @FindBy(css = "input[id='password']")
    private WebElement passwordSpace;
    @FindBy(css = "input[id='password-confirmation']")
    private WebElement confirmPasswordSpace;
    @FindBy(css = "button[class='action submit primary']")
    private WebElement createAnAccountButton;


    public CreateNewCustomerAccountPage(WebDriver driver) {
        super(driver);
    }
    public void fillFirstNameSpace(String firstName){
        sendKeys(m_webDriverWait.until(ExpectedConditions.visibilityOf(firstNameSpace)), firstName);
    }
    public void fillLastNameSpace(String lastName){
        sendKeys(m_webDriverWait.until(ExpectedConditions.visibilityOf(lastNameSpace)), lastName);
    }
    public void clickSignUpRadioButton(){
        m_webDriverWait.until(ExpectedConditions.elementToBeClickable(
                centerElement(signUpForNewsletterRadioButton))).click();
    }
    public void fillEmailSpace(String email){
        sendKeys(m_webDriverWait.until(ExpectedConditions.visibilityOf(emailSpace)), email);
    }
    public void fillPasswordSpace(String password){
        sendKeys(m_webDriverWait.until(ExpectedConditions.visibilityOf(passwordSpace)), password);
    }
    public void fillConfirmPasswordSpace(String passwordAgain){
        sendKeys(m_webDriverWait.until(ExpectedConditions.visibilityOf(confirmPasswordSpace)), passwordAgain);
    }
    public void clickableCreateAnAccountButton(){
        m_webDriverWait.until(ExpectedConditions.elementToBeClickable(createAnAccountButton)).click();
    }
}
