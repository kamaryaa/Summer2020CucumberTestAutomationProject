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

    @When("user logs in")
    public void user_logs_in() throws InterruptedException {
     loginPage.login();
     Thread.sleep(3000);
    }

    @Then("user should see dashboard page")
    public void user_should_see_dashboard_page() throws InterruptedException {
        String expected ="Dashboard";
        String actual = driver.findElement(By.className("oro-subtitle")).getText().trim();// give some spaces

        Assert.assertEquals("Title is not correct",expected,actual);
        System.out.println("I see dashboard page!");
        Thread.sleep(3000);
        Driver.closeDrive();

    }


}
