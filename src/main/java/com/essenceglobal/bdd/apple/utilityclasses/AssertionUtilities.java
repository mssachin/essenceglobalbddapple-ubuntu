package com.essenceglobal.bdd.apple.utilityclasses;

import com.cucumber.listener.Reporter;
import org.junit.Assert;

public class AssertionUtilities {


    public static void assertTrue(boolean condition, String passMessage, String failMessage){

        try {
            Assert.assertTrue(condition);
            Reporter.addStepLog(passMessage);
        }catch (AssertionError ae){
            Reporter.addStepLog(failMessage);
        }
    }

    public static void assertStringEquals(String expected, String actual, String passMessage, String failMessage){
        try{
            Assert.assertEquals(expected, actual);
            Reporter.addStepLog(passMessage);
        }catch (AssertionError ae){
            Reporter.addStepLog(failMessage);
        }
    }
}


