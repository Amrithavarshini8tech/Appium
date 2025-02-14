package Amrithavarshini8tech.Appium;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseSetUp {

	public AndroidDriver driver;

	@BeforeMethod
	public void startDriver() throws MalformedURLException, URISyntaxException {
		// AppiumCode-> AppiumServer->Device
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("MediumPhone");
		options.setApp(
				"C:\\Users\\amrit\\eclipse-workspace2\\Appium\\src\\test\\java\\Amrithavarshini8tech\\Appium\\ApiDemos-debug.apk");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		// ImplicitWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}
}
