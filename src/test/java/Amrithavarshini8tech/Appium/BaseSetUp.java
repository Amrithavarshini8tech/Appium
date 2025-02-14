package Amrithavarshini8tech.Appium;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseSetUp {

	public AndroidDriver driver;
	@BeforeClass
	public void startDriver() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("MediumPhone");
		options.setApp("C:\\Users\\amrit\\eclipse-workspace2\\Appium\\src\\test\\java\\Amrithavarshini8tech\\Appium\\ApiDemos-debug.apk");
		driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);				
	}
	@AfterClass
	public void quitDriver() {
		driver.quit();
	}
}
