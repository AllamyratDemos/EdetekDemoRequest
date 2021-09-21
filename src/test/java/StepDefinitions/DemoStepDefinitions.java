package StepDefinitions;

import Pages.HomePage;
import Utils.BrowserUtils;
import Utils.ConfigurationReader;
import Utils.Driver;
import Utils.Helpers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class DemoStepDefinitions extends HomePage {
    Actions actions=new Actions(Driver.get());

    @Given("user is on Home page")
    public void user_is_on_home_page() throws InterruptedException {
        getHomePage();
        Thread.sleep(1000);
        String actualTitle=Helpers.Title();
        String expectedTitle="EDETEK, the premier provider of digital clinical trial computer systems";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("user clicks on Request a Demo button on Home page")
    public void user_clicks_on_request_a_demo_button_on_home_page() {
        HomePageDemoButton.click();
    }

    @Then("request demo form should be displayed")
    public void request_demo_form_should_be_displayed() {
        String actualTitle=popUpWindowTitle.getText();
        String expectedTitle="REQUEST A DEMO";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Given("user is on request a demo form window")
    public void user_is_on_request_a_demo_form_window() {
        getHomePage();
        HomePageDemoButton.click();
    }

    @When("user fills in all required fields")
    public void user_fills_in_all_required_fields() {
        BrowserUtils.clickWithJS(name);
        name.sendKeys(ConfigurationReader.get("name"));
        BrowserUtils.clickWithJS(email);
        email.sendKeys(ConfigurationReader.get("contactEmail"));
        BrowserUtils.clickWithJS(CompanyName);
        CompanyName.sendKeys(ConfigurationReader.get("companyName"));
        BrowserUtils.clickWithJS(Role);
        Role.sendKeys("role");
    }

    @Then("user should be able to click on A Request a Demo button")
    public void user_should_be_able_to_click_on_a_request_a_demo_button() {
        actions.moveToElement(submitButton).click().perform();
    }

    @Then("system should display successful message")
    public void system_should_display_successful_message() {
       BrowserUtils.waitForVisibility(successMessage,3);
        Assert.assertTrue(successMessage.isDisplayed());
    }

    @When("user clicks on A Request a Demo button")
    public void user_clicks_on_a_request_a_demo_button() {
        BrowserUtils.clickWithJS(submitButton);
    }

    @Then("system should display error message to fill all the required fields")
    public void system_should_display_error_message_to_fill_all_the_required_fields() throws InterruptedException {
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(ErrorEmptyFields);
        String actualMessage=ErrorEmptyFields.getText();
        String expectedMessage="One or more fields have an error. Please check and try again.";
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @When("user fills in only a name field")
    public void user_fills_in_only_a_name_field() {
        BrowserUtils.clickWithJS(name);
        name.sendKeys(ConfigurationReader.get("name"));
    }

    @Then("system should display error message to fill the required fields")
    public void system_should_display_error_message_to_fill_the_required_fields() throws InterruptedException {
        Thread.sleep(2000);
      Assert.assertFalse(errorMessagesList.isEmpty());
    }

    @When("user enters {string} in Contact Phone field")
    public void user_enters_in_contact_phone_field(String phoneNumber) {
       BrowserUtils.clickWithJS(ContactPhone);
       ContactPhone.sendKeys(phoneNumber);
    }

    @Then("system should display error message for input phone number")
    public void system_should_display_error_message_for_input_phone_number() {
        BrowserUtils.waitForVisibility(phoneNumberErrorMessage,3);
      Assert.assertTrue(phoneNumberErrorMessage.isDisplayed());
    }
}




