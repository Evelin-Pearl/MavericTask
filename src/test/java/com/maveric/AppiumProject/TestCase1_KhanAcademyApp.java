package com.maveric.AppiumProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class TestCase1_KhanAcademyApp {

	public static void main(String[] args) throws MalformedURLException {

//			TC 1 : Navigate to the Pageantry in the Palace – Bamum Kingdom, Cameroon page
//			1.Launch khan app

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("browserstack.user", "evelinpearl_W8HaTF");
		dc.setCapability("browserstack.key", "4Bof6Kf5AHpozpdiUQGp");
		dc.setCapability("app", "bs://b38af9ae26743195397ce050a25ca45818d43ac1");

		// device
		dc.setCapability("device", "Google Pixel 3");
		dc.setCapability("os_version", "9.0");

		// build
		dc.setCapability("project", "UI Automator");
		dc.setCapability("build", "browserstack-build-1");
		dc.setCapability("name", "UI Automator");

		AndroidDriver ad = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), dc);
		ad.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ad.findElement(By.xpath("//android.widget.TextView[@text='Dismiss']")).click();

//			2.Sign in 

		ad.findElement(By.xpath("//*[@text='Sign in']")).click();
		ad.findElement(By.xpath("//*[@text='Sign in']")).click();
		ad.findElement(By.xpath("//*[@content-desc='Enter an e-mail address or username']"))
				.sendKeys("evelinpearl@gmail.com");
		ad.findElement(By.xpath("//*[@content-desc='Password']")).sendKeys("Qwerty1!");
		ad.findElement(By.xpath("(//*[@text='Sign in'])[2]")).click();

//			3.Click on search and click on Arts and humanities

		ad.findElement(By.xpath("//android.widget.Button[@content-desc=\"Search tab\"]")).click();
		ad.findElement(By.xpath("//*[@text='Arts and humanities']")).click();

//			4.Scroll to Art of Africa and click on it 

		String add = "Art of Africa";
		ad.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ add + "\").instance(0))");
		ad.findElement(By.xpath("//*[@text='Art of Africa']")).click();

//			5.Scroll to Central Africa and click on it 	        

		String africa = "Central Africa";
		ad.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ africa + "\").instance(0))");
		ad.findElement(By.xpath("//*[@text='Central Africa']")).click();

//	        6.Click on Pageantry in the Palace – Bamum Kingdom, Cameroon

		ad.findElement(By.xpath("//*[@text='Pageantry in the Palace – Bamum Kingdom, Cameroon']")).click();
		ad.quit();
	}
}
