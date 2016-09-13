package com.midian.webtest.use;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.midian.webtest.core.LocalWebDriverFactory;
import com.midian.webtest.dataprovider.ExcelDataProvider;
import com.midian.webtest.dataprovider.UseCookiesLogin;
import com.midian.webtest.element.AuctionPublishEle;
import com.midian.webtest.element.FixedPricePublishEle;
import com.midian.webtest.utils.SnapShot;

public class PublishAucFix {
	public WebDriver driver;
	String IndexURL = "http://ming.dev.bizcn.com/home/index/index.html";
	String answer = "aa";
	Select seList1; // 域名状态下拉框
	Select seList2; // 批量操作下拉框
	Select seList3; // 交易结束时间下拉框
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
        return ExcelDataProvider.getData(filePath, "DataProvider.xls", "testC", 
        		beginRowNum, endRowNum, beginColNum,endColNum);
    }
    
	@Test
	//自动发布一口价
	public void publishFixedPrice() {
		FixedPricePublishEle fixedfriceele = new FixedPricePublishEle(driver);
		fixedfriceele.mytrade.click();
		seList1 = new Select(fixedfriceele.dealallow);
		seList1.selectByVisibleText("可交易");
		fixedfriceele.search.click();
		waitfortxt(driver, 3, "续费");
		fixedfriceele.tradebox1.click();
		seList2 = new Select(fixedfriceele.opreater);
		seList2.selectByVisibleText("发布交易");
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
		seList3 = new Select(fixedfriceele.endtime1);
		seList3.selectByVisibleText("5天");
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
		waitmsec(300);
		snapshut("发布一口价结果");
		//driver.quit();
	}
	
	@Test(dependsOnMethods = "publishFixedPrice")
	//发布自动拍卖
	public void publishAuction() {
		AuctionPublishEle auctionele = new AuctionPublishEle(driver);
		driver.get(IndexURL);
		auctionele.mytrade.click();
		seList1 = new Select(auctionele.dealallow);
		seList1.selectByVisibleText("可交易");
		auctionele.search.click();
		auctionele.tradebox1.click();
		seList2 = new Select(auctionele.opreater);
		seList2.selectByVisibleText("发布交易");
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
		seList3 = new Select(auctionele.endtime1);
		seList3.selectByVisibleText("5天");
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
		snapshut("发布拍卖结果");
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
		SnapShot snapshut = new SnapShot();
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		String time=format.format(date);
		snapshut.snapshot((TakesScreenshot)driver,picturename+time+".png");
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