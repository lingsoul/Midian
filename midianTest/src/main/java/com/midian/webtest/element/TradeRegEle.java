package com.midian.webtest.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TradeRegEle {
	public WebDriver driver;
	
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[1]/div[2]/div/div/ul/li[3]/a")
	public WebElement regbtn;
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[1]/div[2]/div/div/ul/li[3]/bf")
	public WebElement test;
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[2]/div[1]/div/div/form/div[1]/div/textarea")
	public WebElement tradeinput;
	@FindBy(how = How.XPATH,
			xpath = "/html/body/div[1]/div[2]/div[1]/div/div/form/div[2]/div[2]/div/div/dl[1]/dd[3]/label/i")
	public WebElement combtn;
	@FindBy(how = How.XPATH,
			xpath = "/html/body/div[1]/div[2]/div[1]/div/div/form/div[2]/div[2]/div/div/dl[3]/dd[10]/label/i")
	public WebElement xyzbtn;
	@FindBy(how = How.XPATH,
			xpath = "/html/body/div[1]/div[2]/div[1]/div/div/form/div[2]/div[2]/div/div/dl[1]/dd[2]/label/i")
	public WebElement vipbtn;
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[2]/div[1]/div/div/form/div[1]/input")
	public WebElement checkbtn;
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[2]/div[2]/form/table/thead/tr/th[1]/label/i")
	public WebElement selectall;
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[2]/div[2]/div[2]/div/input")
	public WebElement batchbtn;
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[2]/div/div[1]/form/div[1]/div/label/i")
	public WebElement acceptbtn;
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[2]/div/div[2]/div/input")
	public WebElement submitbtn;
	@FindBy(how = How.XPATH,xpath = "/html/body/div[1]/div[2]/div/div[2]/form/table/tbody/tr/td[4]/span")
	public WebElement reginfo;
	@FindBy(how = How.XPATH,xpath = "/html")
	public WebElement newtag;
	
	
	public TradeRegEle (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
