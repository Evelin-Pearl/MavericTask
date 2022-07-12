package com.maveric.AppiumProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class TestCase2_KhanAcademyApp {

	public static void main(String[] args) throws Exception {

//			1.Launch khan app

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("browserstack.user", "evelinpearl_9VpnKq");
		dc.setCapability("browserstack.key", "qfS7pjPgviXUtw2UnpTz");
		dc.setCapability("app", "bs://ee4401e84207f0371a7156f412194e6f087dd315");

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

//			4.Click on World history

		String className = "World history";
		String uiSelector = "new UiSelector().textMatches(\"" + className + "\")";
		String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector
				+ ");";
		ad.findElementByAndroidUIAutomator(command).click();

//			5.Click on the 600 - 1450 Regional and interregional interactions 

		String name = "600 - 1450 Regional and interregional interactions ";
		ad.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ name + "\").instance(0))");
		ad.findElement(By.xpath("//*[@text='600 - 1450 Regional and interregional interactions ']")).click();

//			6.Bookmark the session

		ad.findElement(By.xpath("(//*[@content-desc=\"Add Bookmark\"])[1]")).click();
		if(ad.findElement(By.xpath("//*[@text='GOT IT']")).isDisplayed()) {
			ad.findElement(By.xpath("//*[@text='GOT IT']")).click();
		}
		String session = ad
				.findElement(By.xpath("//*[@text=\"Unit: 600 - 1450 Regional and interregional interactions \"]"))
				.getText();

//			7.Click on bookmark page and validate if the session is bookmarked
		ad.findElement(By.xpath("//*[@content-desc=\"Bookmarks tab\"]")).click();
		String bookmarkSession = ad.findElement(By.xpath("//*[@text='600 - 1450 Regional and interregional interactions ']")).getText();
		if (session.contains(bookmarkSession)) {
			System.out.println("Session is added to bookmark page.");
		}
	}
}
