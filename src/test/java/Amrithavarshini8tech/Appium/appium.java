package Amrithavarshini8tech.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class appium extends BaseSetUp {
	@Test(enabled = false)
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
	@Test(enabled = false)
	public void longPressGesture() throws InterruptedException {
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

	@Test(enabled = false)
	public void scrollGesture_Element() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
	}

	@Test(enabled = false)
	public void scrollGestureToEnd_Coordinates() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		boolean canScroll;
		do {
			canScroll = (boolean) ((JavascriptExecutor) driver).executeScript("mobile:scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 100, "height", 100, "direction", "down", "percent", 3.0));
		} while (canScroll);

	}

	@Test(enabled = false)
	public void swipeGesture() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		WebElement toSwipe = driver.findElement(By.xpath("//(android.widget.ImageView)[1]"));
		Assert.assertEquals(toSwipe.getAttribute("focusable"), "true");
		driver.executeScript("mobile:swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) toSwipe).getId(),
				"direction", "left", "percent", 0.25));
		Assert.assertEquals(toSwipe.getAttribute("focusable"), "false");
	}

	@Test(enabled = false)
	public void dragAndDrop() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement drag = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		driver.executeScript("mobile:dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) drag).getId(), "endX", 618, "endY", 568));
		Thread.sleep(1000);
		Assert.assertEquals((driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText()),
				"Dropped!");
	}

	@Test(enabled = true)
	public void potrait_To_Landscape() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation landscape1 = new DeviceRotation(0, 0, 90);// DeviceRotation-class
		driver.rotate(landscape1);// rotate-method
		driver.findElement(By.xpath(
				"//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout"))
				.click();
		String value = driver.findElement(AppiumBy.className("android.widget.TextView")).getText();
		Assert.assertEquals(value, "WiFi settings");	
		driver.findElement(By.id("android:id/edit")).sendKeys("Wifi");
		driver.findElement(By.id("android:id/button1"));
	}

	@Test(enabled = false)
	public void clipboard() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath(
				"//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout"))
				.click();
		String value = driver.findElement(AppiumBy.className("android.widget.TextView")).getText();
		Assert.assertEquals(value, "WiFi settings");
		driver.setClipboardText("Wifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.findElement(By.id("android:id/button1"));
	}
}
