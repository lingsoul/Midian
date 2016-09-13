package com.midian.webtest.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AuctionPublishEle {
	public WebDriver driver;
	public Select seList1; // 域名状态下拉框
	public Select seList2; // 批量操作下拉框
	public Select seList3; // 交易结束时间下拉框
	@FindBy(how = How.PARTIAL_LINK_TEXT,partialLinkText = "我的域名")
	public WebElement mytrade;
	/*状态下拉框选择为可交易*/
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[3]/div[2]/div/form/ul/li[3]/div/select")
	public WebElement dealallow;
	/*搜索按钮*/
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[3]/div[2]/div/form/ul/li[10]/div/input[2]")
	public WebElement search;
	/*第二个域名勾选框*/
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[3]/div[2]/div/form/div/div[2]/table/tbody/tr[2]/td[1]/label/i")
	public WebElement tradebox1;
	/*发布交易下拉框*/
	@FindBy(how = How.NAME,name = "opreater")
	public WebElement opreater;
	/*批量操作按钮*/
	@FindBy(how = How.ID,id = "multi_operater")
	public WebElement multi_operater;
	/*确定进行交易*/
	@FindBy(how = How.XPATH,xpath = "//*[@class='elastic-footer center']/input[1]")
	public WebElement accept1;
	/*发布拍卖按钮*/
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div/a[2]")
	public WebElement auctionbtn;
	/*域名全选框*/
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[3]/div[2]/div/form/table/thead/tr/th[1]/label/i")
	public WebElement checkall;
	/*交易结束时间下拉框*/
	@FindBy(how = How.XPATH,xpath = "//*[@class='table js-checkbox-con']/tbody/tr[1]/td[3]/select")
	public WebElement endtime1;
	/*起拍价*/
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[3]/div[2]/div/form/table/tbody/tr/td[4]/span/input")
	public WebElement tradeprice1;
	/*简介*/
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[3]/div[2]/div/form/table/tbody/tr/td[5]/input")
	public WebElement infotxt1;
	/*下一步按钮*/
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[3]/div[2]/div/div/input")
	public WebElement nextstepbtn;
	/*可提现单选按钮*/
	@FindBy(how = How.XPATH,xpath = "//*[@class='tb-txt']/tbody/tr[2]/td[1]/*/i")
	public WebElement ktxbtn;
	/*勾选同意协议*/
	@FindBy(how = How.XPATH,xpath = "//form[@class='sell-price-add']/table/tbody/tr[4]/td/label/i")
	public WebElement agreebox;
	/*提交*/
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[3]/div[2]/div[1]/form/table/tbody/tr[5]/td/input")
	public WebElement submit;
	/*安全问题答案输入框*/
	@FindBy(how = How.XPATH,xpath = "/html/body/div[2]/form/div[2]/li[2]/div/input")
	public WebElement answertxt;
	/*安全问题确认按钮*/
	@FindBy(how = How.XPATH,xpath = "/html/body/div[2]/form/div[2]/li[3]/div/input")
	public WebElement confirm;
	/*交易状态*/
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[3]/div[2]/div[2]/div/table/tbody/tr/td[3]/span")
	public WebElement tradestatus;
	
	public AuctionPublishEle (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
