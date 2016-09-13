/**
 * Copyright @ 2016jkzl. All rights reserved
 */
package com.midian.webtest.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author peter.Chen
 * @version 1.0
 *          <p>
 *          operation
 *          date                        operator         content
 *          2016/9/6 20:30             peter.Chen       new
 * @Description:
 * @date 2016/9/6 20:30
 */
public class LocalWebDriverFactory {
    private static final String FIRE_FOX_KEY = "webdriver.firefox.bin";
    private static final String FIRE_FOX_PATH = "D:\\软件\\火狐浏览器\\firefox.exe";

    private static final String CHROME_KEY = "webdriver.chrome.bin";
    private static final String CHROME_PATH = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";

    public static WebDriver getFireFoxDriver() {
        System.setProperty(FIRE_FOX_KEY, FIRE_FOX_PATH);
        WebDriver instance = new FirefoxDriver();
        return instance;
    }

    public static WebDriver getChromeDriver() {
        System.setProperty(CHROME_KEY, CHROME_PATH);
        WebDriver instance = new ChromeDriver();
        if (CHROME_PATH == null || CHROME_PATH == "" || CHROME_PATH.equals("")) {
            return instance;
        }
        return instance;
    }
}
