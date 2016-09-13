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
public class RegisterPage {
    private WebDriver webDriver;
    @FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "登录")
    private WebElement loginbtn;
    @FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "登录")
    private WebElement loginbtn2;
    @FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "登录")
    private WebElement loginbtn3;
    @FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "登录")
    private WebElement loginbtn5;
    @FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "登录")
    private WebElement loginbtn6;

    public WebElement getLoginbtn5() {
		return loginbtn5;
	}

	public void setLoginbtn5(WebElement loginbtn5) {
		this.loginbtn5 = loginbtn5;
	}

	public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }
    
    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement getLoginbtn() {
        return loginbtn;
    }

    public void setLoginbtn(WebElement loginbtn) {
        this.loginbtn = loginbtn;
    }

	public WebElement getLoginbtn2() {
		return loginbtn2;
	}

	public void setLoginbtn2(WebElement loginbtn2) {
		this.loginbtn2 = loginbtn2;
	}

	public WebElement getLoginbtn3() {
		return loginbtn3;
	}

	public void setLoginbtn3(WebElement loginbtn3) {
		this.loginbtn3 = loginbtn3;
	}

	public WebElement getLoginbtn6() {
		return loginbtn6;
	}

	public void setLoginbtn6(WebElement loginbtn6) {
		this.loginbtn6 = loginbtn6;
	}
	
    
}
