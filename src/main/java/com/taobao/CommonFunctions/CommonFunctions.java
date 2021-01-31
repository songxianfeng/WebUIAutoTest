package com.taobao.CommonFunctions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

public class CommonFunctions {
    /**
     * 页面级操作
     * @author :SXF
     * @date:2019-11-17
     */
    public static Logger Log= Logger.getLogger(CommonFunctions.class);
    static public WebDriver driver;

    public CommonFunctions()
    {
        /*
         * 构造函数，打开浏览器
         * param url:要打开的网页地址
         */
        String driverPath=System.getProperty("user.dir")+"/src/main/resources/driver/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",driverPath);
        // 创建一个 FireFox 的浏览器实例
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public  void OpenWebPage(String url) throws InterruptedException {
        /**
         * 打开指定的URL
         * @param url :要打开的页面地址
          */
        driver.get(url);
        Thread.sleep(3000);
    }

    public  void QuiteWindows()
    {
        /**
         * 退出浏览器
         */
        driver.quit();
    }
    public WebElement getElement(String type, String location)
    {
        /**
         * 获取页面元素
         * @param type:元素定位方法
         * @param location:定位的方法值
         */
        WebElement elem=null;
        if(type.equals("xpath"))
        {
            elem=driver.findElement(By.xpath(location));
        }
        if(type.equals("name"))
        {
            elem=driver.findElement(By.name(location));
        }
        if(type.equals("id"))
        {
            elem=driver.findElement(By.id(location));
        }
        if(type.equals("classname"))
        {
            elem=driver.findElement(By.className(location));
        }
        if(type.equals("css"))
        {
            elem=driver.findElement(By.cssSelector(location));
        }
        if (type.equals("linktext"))
        {
            elem=driver.findElement(By.linkText(location));
        }
        if(elem==null)
        {
            Log.error("您定位的元素找不到！定位方式："+type+",定位位置："+location);
            return null;
        }
        else {
            return elem;
        }
    }

    public String gettext(String type,String location)
    {
        /**
         * 获取对应元素的内容
         * @param type:元素定位方法
         * @param location:定位的方法值
         */
        WebElement elem=this.getElement(type,location);
        if(elem==null)
        {
            Log.error("元素定位不到，获取不到元素内容！");
            return "";
        }
        else
        {
            return elem.getText();
        }
    }

    public void clickitem(String type,String location)
    {
        /**
         * 单击页面对应的元素
         * @param type:元素定位方法
         * @param location:定位的方法值
         */
        WebElement elem=this.getElement(type,location);
        if (elem==null)
        {
            Log.error("元素定位不到，无法单击！");
        }
        else {
            elem.click();
        }
    }

    public void clearvalue(String type,String location)
    {
        /**
         * 清除输出框的内容
         * @param type:元素定位方法
         * @param location:定位的方法值
         */
        WebElement elem=this.getElement(type,location);
        if (elem==null)
        {
            Log.error("元素定位不到，无法清除内容！");
        }
        else {
            elem.clear();
        }
    }

    public void inputvalue(String type,String location,String text)
    {
        /**
         * 向输入框输入指定的内容
         * @param type:元素定位方法
         * @param location:定位的方法值
         * @param text:要输入的内容
         */
        WebElement elem=this.getElement(type,location);
        if(elem==null)
        {
            Log.error("元素定位不到，不法输入内容！");
        }
        else {
            elem.sendKeys(text);
        }
    }

    public void SwitchWindows() throws InterruptedException {
        /***
         * 将句柄切换到新的窗口
         */
        //切换到新窗口
        Set<String> handls=driver.getWindowHandles();
        String[] ghandls=handls.toArray(new String[0]);
        driver.switchTo().window(ghandls[ghandls.length-1]);
        Thread.sleep(1000);
    }

    public void ScrollWindows() throws InterruptedException {
        /**
         * 滚动窗口
         */
        ((JavascriptExecutor)driver).executeScript("scrollTo(0,2000)");
        Thread.sleep(3000);
    }



}
