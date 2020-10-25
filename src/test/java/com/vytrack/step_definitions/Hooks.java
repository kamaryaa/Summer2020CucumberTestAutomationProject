package com.vytrack.step_definitions;

import com.vytrack.utils.Driver;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void tearDown(){

        //this is hook after
        // run automatically after every test
        Driver.closeDrive();
        System.out.println(":::(^_^ End of test execution(*_*) :::"+"\nHave a good rest of the day");
    }
}
