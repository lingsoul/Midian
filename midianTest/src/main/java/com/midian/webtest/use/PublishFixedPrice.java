package com.midian.webtest.use;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.midian.webtest.core.LocalWebDriverFactory;
import com.midian.webtest.dataprovider.UseCookiesLogin;
import com.midian.webtest.element.FixedPricePublishEle;

public class PublishFixedPrice {
	public WebDriver driver;
	String IndexURL = "http://ming.dev.bizcn.com/home/index/index.html";
	String answer = "aa";

	@Test
	//(dataProvider = "getUrlInfoArray", dataProviderClass = DataProviderConf.class)
	public void publishFixedPrice() {
		FixedPricePublishEle fixedfriceele = new FixedPricePublishEle(driver);
		fixedfriceele.mytrade.click();
		fixedfriceele.seList1 = new Select(fixedfriceele.dealallow);
		fixedfriceele.seList1.selectByVisibleText("可交易");
		fixedfriceele.search.click();
		waitfortxt(driver, 3, "续费");
		fixedfriceele.tradebox1.click();
		fixedfriceele.seList2 = new Select(fixedfriceele.opreater);
		fixedfriceele.seList2.selectByVisibleText("发布交易");
		fixedfriceele.multi_operater.click();
		// 点击确定后，发布一口价
		waitofimplicitly(10);
		fixedfriceele.accept1.click();
		waitofimplicitly(10);
		fixedfriceele.FixedPricebtn.click();
		// 全选域名
		waitofimplicitly(10);
		fixedfriceele.checkall.click();
		// 发布信息：5天、价格为666、简介为“自动发布一口价”
		fixedfriceele.seList3 = new Select(fixedfriceele.endtime1);
		fixedfriceele.seList3.selectByVisibleText("5天");
		fixedfriceele.tradeprice1.sendKeys("666");
		fixedfriceele.infotxt1.sendKeys("自动发布一口价");
		fixedfriceele.nextstepbtn.click();
		waitofimplicitly(10);
		// 点击交易款可提现
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", fixedfriceele.ktxbtn);
		// 找到该页面元素后直接发送一条Click的JavaScript指令
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", fixedfriceele.agreebox);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", fixedfriceele.submit);
		// 输入安全校验答案，点击确定
		waitofimplicitly(10);
		fixedfriceele.answertxt.sendKeys(answer);
		fixedfriceele.confirm.click();
		// 判断是否发布成功
		waitofimplicitly(10);
		Assert.assertEquals(fixedfriceele.tradestatus.getText(), "发布成功！");
		
		//driver.quit();
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
