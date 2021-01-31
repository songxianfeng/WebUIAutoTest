package com.taobao.TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;

public class DataProDemo1 {

    @DataProvider(name = "test1")
    public static Object[][] primeNumbers() {
        return new Object[][] { { 2, true ,"hi"}, { 6, false ,"test"}, { 19, true ,"good"},
                { 22, false ,"aha"}, { 23, true ,"loo"} };
    }

    //参数必须要一致
    @Test(dataProvider = "test1")
    public void testPrimeNumberChecker(Integer inputNumber,
                                       Boolean expectedResult, String test) {
        if(expectedResult) {
            System.out.println(inputNumber + " " + expectedResult + " " + test);
        }
        else
        {
            System.out.println("The expectResult is false!");
        }


    }

}
