package com.taobao.CommonFunctions;

import com.taobao.CommonFunctions.CommonFunctions;
import org.apache.log4j.Logger;

public class TaoBaoOperations {
    /***
     * 淘宝业务逻辑操作类
     */
    public static Logger Log= Logger.getLogger(TaoBaoOperations.class);
    public CommonFunctions comfun;

    public TaoBaoOperations()
    {
        comfun=new CommonFunctions();
    }

    public void OpenTaoBaoPage(String url) throws InterruptedException {
        /***
         * 打开淘宝的页面
         * @param url:淘宝业页面地址
         */
        comfun.OpenWebPage(url);
    }

    public void QuitTBWindows()
    {
        /**
         * 退出淘宝浏览器
         */
        comfun.QuiteWindows();
    }

    public void TMSearch(String skey) throws Exception
    {
        /**
         * 天猫超市搜索操作
         * @param skey:搜索关键字
         */
        Thread.sleep(3000);
        comfun.clickitem("linktext","天猫超市");
        Thread.sleep(3000);
        //切换到新窗口
        comfun.SwitchWindows();
        Thread.sleep(1000);
        //输入查询的元素
        comfun.inputvalue("id","mq",skey);
        Thread.sleep(1000);
        comfun.clickitem("xpath","//form[@name='searchTop']/fieldset/div/button");
        Thread.sleep(3000);
        comfun.ScrollWindows();
        Thread.sleep(3000);
    }

    public String getTextFromPage(String type,String location)
    {
        /**
         * 获取页面元素内容
         *  @param type:元素定位方法
         * @param location:定位的方法值
         */
        String pcont=comfun.gettext(type,location);
        if(pcont!="")
        {
            return pcont;
        }
        else
        {
            Log.error("获取不到页面元素内容！");
            return "";
        }
    }


}
