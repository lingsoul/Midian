package com.midian.webtest.use;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.midian.webtest.core.LocalWebDriverFactory;
import com.midian.webtest.dataprovider.UseCookiesLogin;
import com.midian.webtest.element.TradeRegEle;

public class TradeRegister {
	public static WebDriver driver;
	String IndexURL = "http://ming.dev.bizcn.com/home/index/index.html";
	String trade = "autoregtest023.com";

	// @Test(dataProvider = "GetDataFromXml", dataProviderClass =
	// ExcelDataProvider.class)
	@Test
	public void tradeRegister() {
		TradeRegEle traderegele = new TradeRegEle(driver);
		traderegele.regbtn.click();
		traderegele.tradeinput.sendKeys(trade);
		traderegele.combtn.click();
		traderegele.vipbtn.click();
		traderegele.checkbtn.click();
		waitforxpath(driver, 30, "/html/body/div[1]/div[2]/div[2]/form/table/tbody/tr/td[5]/input");
		Reporter.log("查询域名成功，进入注册页面-----------<br />");
		traderegele.selectall.click();
		traderegele.batchbtn.click();
		waitforxpath(driver, 10, "/html/body/div[1]/div[2]/div/div[1]/form/div[1]/div/label/i");
		traderegele.acceptbtn.click();
		traderegele.submitbtn.click();
		waitforxpath(driver, 30, "/html/body/div[1]/div[2]/div/div[2]/form/div/span");
		Assert.assertEquals(traderegele.reginfo.getText(), "注册成功");
		Reporter.log("域名" + trade + "注册成功！-----------<br />");

		driver.quit();
	}

	// 等待waittime秒内未查询到内容，执行失败
	public void waitfortxt(WebDriver driver, Integer waittime, final String waittxt) {
		WebDriverWait waitlogin = new WebDriverWait(driver, waittime);
		waitlogin.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.linkText(waittxt));
			}
		});
	}

	// 等待waittime内未定位到xpath元素，执行失败
	public void waitforxpath(WebDriver driver, Integer waittime, final String locationxpath) {
		WebDriverWait waitlogin = new WebDriverWait(driver, waittime);
		waitlogin.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.xpath(locationxpath));
			}
		});
	}

	public void waitofimplicitly(Integer waittime) {
		driver.manage().timeouts().implicitlyWait(waittime, TimeUnit.SECONDS);
	}

	@BeforeTest
	public void beforeTest() {
		driver = LocalWebDriverFactory.getFireFoxDriver();
		driver.manage().window().maximize();
		driver.get(IndexURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 读入用户登录缓存信息
		UseCookiesLogin cookieslogin = new UseCookiesLogin(driver);
		cookieslogin.useCookiesLogin();
		driver.navigate().refresh();
	}
}
