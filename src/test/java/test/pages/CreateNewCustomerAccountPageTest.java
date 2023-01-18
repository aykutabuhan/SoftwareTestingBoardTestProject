package test.pages;

import listeners.Listeners;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.CreateNewCustomerAccountPage;
import util.URLNavigator;


public final class CreateNewCustomerAccountPageTest extends Listeners{

    private static CreateNewCustomerAccountPage m_createNewCustomerAccountPage;
    private static final String FIRST_NAME = "ExampleName";
    private static final String LAST_NAME = "ExampleLastName";
    private static final String EMAIL = RandomStringUtils.random(10, true, false)
                                                                                        .concat("@gmail.com");
    private static final String PASSWORD = "ExAmpLE123098-^%'&";
    private static final String MESSAGE = "Thank you for registering with Fake Online Clothing Store.";


    @BeforeClass
    public void start(){
        m_createNewCustomerAccountPage = new CreateNewCustomerAccountPage(ms_webDriver);
        m_createNewCustomerAccountPage.navigateTo(URLNavigator.goToCreateNewAccountPage());
    }

    @Test
    public void fillPersonalInformationTest(){
        m_createNewCustomerAccountPage.fillFirstNameSpace(FIRST_NAME);
        Assert.assertEquals(m_createNewCustomerAccountPage.getFirstName(), FIRST_NAME,
                "Name is not correct!");
        m_createNewCustomerAccountPage.fillLastNameSpace(LAST_NAME);
        Assert.assertEquals(m_createNewCustomerAccountPage.getLastName(), LAST_NAME,
                "LastName is not correct!");
        m_createNewCustomerAccountPage.clickSignUpRadioButton();
        Assert.assertTrue(m_createNewCustomerAccountPage.isSelectedRadioButton(),
                "Radio Button is not selected!");
    }
    @Test
    public void fillSignInInformationTest(){
        m_createNewCustomerAccountPage.fillEmailSpace(EMAIL);
        Assert.assertEquals(m_createNewCustomerAccountPage.getEmail(), EMAIL,"E-mail is not correct!");
        m_createNewCustomerAccountPage.fillPasswordSpace(PASSWORD);
        Assert.assertEquals(m_createNewCustomerAccountPage.getPassword(), PASSWORD,
                "Password is not correct!");
        m_createNewCustomerAccountPage.fillConfirmPasswordSpace(PASSWORD);
        Assert.assertEquals(m_createNewCustomerAccountPage.getConfirmPassword(), PASSWORD,
                "Confirm Password is not correct!");
    }
    @Test
    public void clickCreateAnAccountTest(){
        m_createNewCustomerAccountPage.clickableCreateAnAccountButton();
        Assert.assertEquals(m_createNewCustomerAccountPage.getVerificationMessage(), MESSAGE,
                "New account creation failed");
    }
}
