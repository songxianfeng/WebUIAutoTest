package com.taobao.TestCases;

import com.taobao.CommonFunctions.DataProvideOper;
import com.taobao.CommonFunctions.DataReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.*;

public class DataProviderTest  extends DataProvideOper {
    public DataReader dr;
    @BeforeTest
    public void SetUp()
    {
        dr=new DataReader();
        try {
            //初始化数据
            init("DataProvidertest.xml");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test(dataProvider = "Test_xml_dataprovider")
    public void PrintXmlData(Document params)
    {
        System.out.println("讲师："+dr.readnodevalue(params,"node1","name"));
        System.out.println("课程："+dr.readnodevalue(params,"node1","class"));
        System.out.println("URL:"+dr.readnodevalue(params,"node1","URL"));

    }

}
