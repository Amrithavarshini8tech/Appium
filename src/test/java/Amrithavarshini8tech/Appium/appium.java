package Amrithavarshini8tech.Appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class appium extends BaseSetUp {
@Test
public void appiumTest_Preference()  {
	
	driver.findElement(AppiumBy.accessibilityId("Preference")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
	driver.findElement(By.id("android:id/checkbox")).click();
	driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
	driver.findElement(By.id("android:id/edit")).sendKeys("Wifi");
	driver.findElement(By.id("android:id/button1"));
}
}
