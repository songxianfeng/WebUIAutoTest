package com.taobao.TestCases;

import org.testng.annotations.DataProvider;

public class DataProviderMethod {

    //无指定数据名称，默认使用方法名
    @DataProvider
    public static Object[][] NoNameMethod(){
        return new Object[][]{
                {"DataWithNoName1"},
                {"DataWithNoName2"},
                {"DataWithNoName3"}
        };
    }

    //指定名称1
    @DataProvider(name="dataprovider1")
    public static Object[][] dataProvider1(){
        return new Object[][]{
                {"dataprovider1-1"},
                {"dataprovider1-2"}
        };
    }
    //指定名称2
    @DataProvider(name="dataprovider2")
    public static Object[][] dataProvider2(){
        return new Object[][]{
                {"dataprovider2-1"},
                {"dataprovider2-2"}
        };
    }

}
