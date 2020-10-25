package com.vytrack.step_definitions;

import com.vytrack.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import javafx.scene.Scene;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
/*
hooks name is not reserved.you may name thus class in any name
for example: SuiteSetUpAndTearDown
 */

public class Hooks {

    @Before
    public void setup(Scenario scenario){
        System.out.println(":::: starting automation:::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    //hook before = @BeforeMethod in testNG
    //hook after = @AfterMethod in TestNG
    //it's not a good idea to mix implicit and explicit waits. it can lead to unexpectedly long waits

    @After
    public void tearDown(){


        //close browser, close DB connection, close tunnel ,capture screetshot of the error etc.
        //this is hook after
        // run automatically after every test
        Driver.closeDrive();
        System.out.println(":::(^_^ End of test execution(*_*) :::"+"\nHave a good rest of the day");
    }


    // order =0 define hooks execution order
    @Before(value = "@db",order = 0)
    public void dbSetup(){
        System.out.println("::: connecting to the database::::");
    }

    @After("@db")
    public void dbTeardown(){
        System.out.println("::: Disconnecting from the database:::");
    }
}
