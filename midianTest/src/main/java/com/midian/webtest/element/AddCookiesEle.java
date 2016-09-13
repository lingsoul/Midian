/**
 * Copyright @ 2016jkzl. All rights reserved
 */
package com.midian.webtest.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author peter.Chen
 * @version 1.0
 *          <p>
 *          operation
 *          date                        operator         content
 *          2016/9/8 15:47             peter.Chen       new
 * @Description:
 * @date 2016/9/8 15:47
 */
public class AddCookiesEle {

    public WebDriver driver;
    @FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "登录")
    public WebElement loginbtn;
    @FindBy(how = How.NAME,name = "mobile_or_email")
    public WebElement username;
    @FindBy(how = How.NAME,name = "password")
    public WebElement password;
    @FindBy(how = How.NAME,name = "captcha")
    public WebElement captcha;
    @FindBy(how = How.LINK_TEXT,linkText = "域名管理")
    public WebElement ymgl;

	public AddCookiesEle(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    	
    
}
