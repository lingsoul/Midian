/**
 * Copyright @ 2016jkzl. All rights reserved
 */
package com.midian.webtest.use;

import com.midian.webtest.core.LocalWebDriverFactory;
import com.midian.webtest.dataprovider.ExcelDataProvider;
import com.midian.webtest.dataprovider.UrlInfo;
import com.midian.webtest.element.RegisterPage;
import com.midian.webtest.utils.BeanUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * @author peter.Chen
 * @version 1.0
 *          <p>
 *          operation
 *          date                        operator         content
 *          2016/9/6 21:12             peter.Chen       new
 * @Description:
 * @date 2016/9/6 21:12
 */
public class Register {
    private static String filePath = "D:\\midiantest\\";

    /**
     * 提供参数型数据处理
     * @return
     */
    @DataProvider(name = "getUrlInfoArray")
    public static Object[][] getUrlInfoArray() {
        int beginRowNum = 2;
        int endRowNum = 3;
        int beginColNum = 1;
        int endColNum = 3;
        return ExcelDataProvider.getData(filePath, "DataProvider.xls", "testC", beginRowNum, endRowNum, beginColNum,
                endColNum);
    }

    /**
     * 提供对象型数据处理
     * @return
     */
    @DataProvider(name = "getUrlInfoArrayObject")
    public static Iterator<Object[]> getUrlInfoArrayObject() {
        int beginRowNum = 2;
        int endRowNum = 3;
        int beginColNum = 1;
        int endColNum = 3;
        Object[][] array = ExcelDataProvider.getData(filePath, "DataProvider.xls", "testC", beginRowNum, endRowNum,
                beginColNum, endColNum);
        Iterator<Object[]> iterator = BeanUtils.arrayToIterator(array, UrlInfo.class);
        return iterator;
    }

    @Test(dataProvider = "getUrlInfoArray", dataProviderClass = Register.class)
    //@Test(threadPoolSize = 3, invocationCount = 6, timeOut = 3000)
    public void addCookies(String URL, String username, String password) {
        WebDriver driver = LocalWebDriverFactory.getFireFoxDriver();
        RegisterPage registerPage = new RegisterPage(driver);
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 点击右上角的登陆链接
        registerPage.getLoginbtn().click();
        // 清空帐号文本框
        driver.findElement(By.name("mobile_or_email")).clear();
        // 输入账号、密码,单击验证码输入框
        driver.findElement(By.name("mobile_or_email")).sendKeys(username);
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("captcha")).click();
    }

 /*   @Test(dataProvider = "getUrlInfoArrayObject",
    		threadPoolSize = 3, invocationCount = 6, timeOut = 3000)
    public void addCookies2(UrlInfo urlInfo) {
        WebDriver driver = LocalWebDriverFactory.getFireFoxDriver();
        RegisterPage registerPage = new RegisterPage(driver);
        driver.manage().window().maximize();
        driver.get(urlInfo.getUrl());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 点击右上角的登陆链接
        registerPage.getLoginbtn().click();
        // 清空帐号文本框
        driver.findElement(By.name("mobile_or_email")).clear();
        // 输入账号、密码,单击验证码输入框
        driver.findElement(By.name("mobile_or_email")).sendKeys(urlInfo.getUserName());
        driver.findElement(By.name("password")).sendKeys(urlInfo.getPassword());
        driver.findElement(By.name("captcha")).click();

    }*/

}
