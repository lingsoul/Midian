package com.midian.webtest.dataprovider;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.midian.webtest.core.LocalWebDriverFactory;
import com.midian.webtest.element.AddCookiesEle;

public class AddCookies {
	public static WebDriver driver;
	public String URL = "http://ming.dev.bizcn.com/home/index/index.html";
	public String user = "10110";
	public String pwd = "123123";
	
  @Test
  //(dataProvider = "GetDataFromXml", dataProviderClass = ExcelDataProvider.class)
	public void addCookies() {
		AddCookiesEle addcookiesele = new AddCookiesEle(driver);
		addcookiesele.loginbtn.click();
		addcookiesele.username.clear();
		addcookiesele.username.sendKeys(user);
		addcookiesele.password.clear();
		addcookiesele.password.sendKeys(pwd);
		addcookiesele.captcha.click();
		waitfortxt(driver, 30,"域名管理");
		driver.close();

		File file = new File("broswer.data");
		try {
			// delete file if exists
			file.delete();
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Cookie ck : driver.manage().getCookies()) {
				bw.write(ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
						+ ck.getExpiry() + ";" + ck.isSecure());
				bw.newLine();
			}
			bw.flush();
			bw.close();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("缓存写入成功！");
			// System.out.println("cookie write to file");
		}

	}
  
//等待waittime秒内未查询到内容，执行失败
	public static void waitfortxt(WebDriver driver,Integer waittime,final String waittxt) {
		WebDriverWait waitlogin = new WebDriverWait(driver, waittime);
		waitlogin.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.linkText(waittxt));
			}
		});
	}
	@BeforeTest
	public void beforeTest(){
		driver = LocalWebDriverFactory.getFireFoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
