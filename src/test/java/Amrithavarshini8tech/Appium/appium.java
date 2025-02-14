package Amrithavarshini8tech.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class appium extends BaseSetUp {
	@Test
	public void appiumTest_Preference() {
		// LOcators: xpath, id, accessibilityId, className, androidUIAutomator
		// Use accessibilityId & androidUIAutomator with AppiumBy
		// Recommended to use className with AppiumBy
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath(
				"//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout"))
				.click();
		String value = driver.findElement(AppiumBy.className("android.widget.TextView")).getText();
		Assert.assertEquals(value, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("Wifi");
		driver.findElement(By.id("android:id/button1"));
	}

//https://github.com/AppiumTestDistribution/appium-gestures-plugin
//https://appium.github.io/appium.io/docs/en/writing-running-appium/android/android-mobile-gestures/
	@Test
	public void longPress() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
		Thread.sleep(1000);
		// RemoteWebelement is an upper hierarchy, it can accept webelement or mobile
		// element or any
		// immutableMap: key value pair, elementid one key and duration is another key(2
		// key value pairs)
		driver.findElement(
				By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample action\"]"))
				.click();

	}
}
