package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinitions {

    WebDriver driver;
    LoginPage loginPage = new LoginPage();

    @Given("user is on the landing")
    public void user_is_on_the_landing() {
        Driver.getDriver().get("https://qa1.vytrack.com");

    }
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("http://qa1.vytrack.com");
    }

    @When("user logs in")
    public void user_logs_in() throws InterruptedException {
     loginPage.login();
     Thread.sleep(3000);
    }

    @Then("user should see dashboard page")
    public void user_should_see_dashboard_page() throws InterruptedException {
        String expected ="Dashboard";
        String actual = loginPage.getPageSubTitleText().trim();// give some spaces

        Assert.assertEquals("Title is not correct",expected,actual);
        System.out.println("I see dashboard page!");
        Thread.sleep(3000);
        Driver.closeDrive();

    }

    // when user login as a "driver"
    @When("user logs in as a {string}")
    public void user_logs_in_as_a(String string) {
       loginPage.login(string);

    }

    //when user logs in with "storemanager85" username and "wrong" password
    @When("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {
        loginPage.login(string,string2);
    }



    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
