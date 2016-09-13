package com.midian.webtest.use;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
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
import com.midian.webtest.element.AuctionPublishEle;
import com.midian.webtest.utils.SnapShot;

public class PublishAuction {
	public WebDriver driver;
	String IndexURL = "http://ming.dev.bizcn.com/home/index/index.html";
	String answer = "aa";

	@Test
	//发布自动拍卖
	public void publishAuction() {
		AuctionPublishEle auctionele = new AuctionPublishEle(driver);
		auctionele.mytrade.click();
		auctionele.seList1 = new Select(auctionele.dealallow);
		auctionele.seList1.selectByVisibleText("可交易");
		auctionele.search.click();
		auctionele.tradebox1.click();
		auctionele.seList2 = new Select(auctionele.opreater);
		auctionele.seList2.selectByVisibleText("发布交易");
		auctionele.multi_operater.click();
		// 点击确定后，发布一口价
		waitofimplicitly(10);
		auctionele.accept1.click();
		waitofimplicitly(10);
		auctionele.auctionbtn.click();
		// 全选域名
		waitofimplicitly(10);
		auctionele.checkall.click();
		// 发布信息
		auctionele.seList3 = new Select(auctionele.endtime1);
		auctionele.seList3.selectByVisibleText("5天");
		auctionele.tradeprice1.sendKeys("888");
		auctionele.infotxt1.sendKeys("自动发布拍卖");
		auctionele.nextstepbtn.click();
		waitofimplicitly(10);
		// 点击交易款可提现
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", auctionele.ktxbtn);
		// 找到该页面元素后直接发送一条Click的JavaScript指令
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", auctionele.agreebox);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", auctionele.submit);
		// 输入安全校验答案，点击确定
		waitofimplicitly(10);
		auctionele.answertxt.sendKeys(answer);
		auctionele.confirm.click();
		// 判断是否发布成功
		waitofimplicitly(10);
		Assert.assertEquals(auctionele.tradestatus.getText(), "发布成功！");
		waitmsec(300);
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

	public void waitofimplicitly(Integer waittime) {
		driver.manage().timeouts().implicitlyWait(waittime, TimeUnit.SECONDS);
	}
	//延时等待
	public void waitmsec(Integer msec){
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//截图
	public void snapshut(String picturename) {
		SnapShot snapshot = new SnapShot();
		snapshot.snapshot((TakesScreenshot)driver,picturename+".png");
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