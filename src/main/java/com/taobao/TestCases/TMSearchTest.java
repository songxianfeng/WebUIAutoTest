package com.taobao.TestCases;
import org.apache.log4j.Logger;
import org.w3c.dom.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import com.taobao.CommonFunctions.TaoBaoOperations;
import com.taobao.CommonFunctions.DataReader;
import com.taobao.CommonFunctions.DataProvideOper;

import java.awt.*;

public class TMSearchTest extends DataProvideOper{
    public  TaoBaoOperations tbo;
    public  DataReader dr;
    public static Logger Log= Logger.getLogger(TMSearchTest.class);
    @BeforeTest
    public  void SetUp()
    {
        /**
         * 在用例执行之前执行
         */
        System.out.println("测试用例开始执行.....");
        tbo=new TaoBaoOperations();
        dr=new DataReader();
        //设置数据源
        try {
            //初始化数据
            init("TMSearchTest.xml");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "Test_xml_dataprovider")
    public void SearchHongJiuTest(Document params) throws Exception {
        /**
         * 天猫搜索红酒测试
         */
        System.out.println("开始执行测试用例.......");
        tbo.OpenTaoBaoPage(dr.readnodevalue(params, "searchgd", "burl"));
        //搜索红酒
        String searchkey=dr.readnodevalue(params, "searchgd", "skey");
        tbo.TMSearch(searchkey);
        //获取查找的结果
        String searchres=tbo.getTextFromPage("xpath",dr.readnodevalue(params, "searchgd", "rtitle"));

        System.out.println("搜索的结果为："+searchres);
        if(searchres.contains(searchkey))
        {
            Assert.assertEquals(1,1);
            System.out.println("天猫超市搜索："+searchkey+"测试通过--------Passed！");
        }
        else
        {
            Log.error("天猫超市搜索："+searchkey+"测试失败，搜索结果为："+searchres);
            Assert.assertEquals(1,0);
        }


    }

    @AfterTest
    public void TearDown()
    {
        /**
         * 测试用例执行完后操作
         */
        System.out.println("测试用例执行完成后执行.....");
        tbo.QuitTBWindows();
 }
}

