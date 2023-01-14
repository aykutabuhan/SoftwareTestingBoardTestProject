package test.pages;

import drivers.Drivers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.CreateNewCustomerAccountPage;
import util.PropertyUtil;

public final class CreateNewCustomerAccountPageTest extends Drivers {

    private static CreateNewCustomerAccountPage m_createNewCustomerAccountPage;
    private static final String baseURL = PropertyUtil.getProperty("CreateAccountURL",
                                                                                "config.properties");
    private static final String FIRST_NAME = "ExampleName";
    private static final String LAST_NAME = "ExampleLastName";
    private static final String EMAIL = "example1234@gmail.com";
    private static final String PASSWORD = "ExAmpLE123098-^%'&";

    @BeforeClass
    public void start(){
        setUpDriver(baseURL);
        m_createNewCustomerAccountPage = new CreateNewCustomerAccountPage(m_driver);
    }
    @AfterClass
    public void finish(){
        quitDriver();
    }
    @Test
    public void fillFirstNameTest(){
        m_createNewCustomerAccountPage.fillFirstNameSpace(FIRST_NAME);
    }
    @Test
    public void fillLastNameTest(){
        m_createNewCustomerAccountPage.fillLastNameSpace(LAST_NAME);
    }
    @Test
    public void clickSingUpRadioButton(){
        m_createNewCustomerAccountPage.clickSignUpRadioButton();
    }
    @Test
    public void fillEmail(){
        m_createNewCustomerAccountPage.fillEmailSpace(EMAIL);
    }
    @Test
    public void fillPassword(){
        m_createNewCustomerAccountPage.fillPasswordSpace(PASSWORD);
    }
    @Test
    public void fillConfirmPassword(){
        m_createNewCustomerAccountPage.fillConfirmPasswordSpace(PASSWORD);
    }
    @Test
    public void clickCreateAnAccount() {
        m_createNewCustomerAccountPage.clickableCreateAnAccountButton();
    }
}
