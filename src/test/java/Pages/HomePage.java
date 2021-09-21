package Pages;

import Utils.ConfigurationReader;
import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    Actions actions=new Actions(Driver.get());

    public HomePage(){
        PageFactory.initElements(Driver.get(),this);}

    @FindBy(xpath = "//div[@id=\"menu_nav\"]//a[text()='REQUEST A DEMO']")
    public WebElement HomePageDemoButton;

    @FindBy(id = "pum_popup_title_1782")
    public WebElement popUpWindowTitle;

    @FindBy(xpath = "(//input[@name='your-name'])[2]")
    public WebElement name;

    @FindBy(xpath = "(//input[@name='your-email'])[2]")
    public WebElement email;

    @FindBy(xpath = "(//input[@name='company-name'])[2]")
    public WebElement CompanyName;

    @FindBy(xpath = "(//input[@name='role'])[2]")
    public WebElement Role;

    @FindBy(xpath = "(//input[@name='your-tel'])[2]")
    public WebElement ContactPhone;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement submitButton;

    @FindBy(xpath = "//*[text()='Thank you for your message. It has been sent.']")
    public WebElement successMessage;

    @FindBy(xpath = "(//*[text()='The field is required.'])[2]")
    public WebElement FieldErrorMessage;

    @FindBy(xpath = "(//*[text()='One or more fields have an error. Please check and try again.'])[2]")
    public WebElement ErrorEmptyFields;

    @FindBy(xpath = "//li[text()='The field is required.']")
    public List<WebElement> errorMessagesList;

    @FindBy(xpath = "//span[text()='The telephone number is invalid.']")
    public WebElement phoneNumberErrorMessage;


    public void getHomePage(){
        Driver.get().get(ConfigurationReader.get("url"));
    }

}



