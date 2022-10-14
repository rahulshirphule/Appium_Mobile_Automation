package org.example;

import java.net.MalformedURLException;

import java.net.URL;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import static io.appium.java_client.touch.offset.ElementOption.element;

import io.appium.java_client.TouchAction;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.*;

public class TestDisplay {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
		dc.setCapability("appWaitForLaunch", false);
		dc.setCapability("appPackage", "net.ludeke.calculator");
		dc.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		try {

			URL url = new URL("http://127.0.0.1:4723/wd/hub");

			AndroidDriver driver = new AndroidDriver(url, dc);
			
			Thread.sleep(5000);

			driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();

			Thread.sleep(5000);

			driver.findElement(By.id("android:id/button1")).click();
			Thread.sleep(5000);

			testDigitPressed(driver); // test if the digit pressed

			Thread.sleep(2000);

			testClearButton(driver); // test if the clear button clear the field

			testNumericAndArithmeticButtonPressed(driver); // test if the Arithmetic button pressed

			Thread.sleep(2000);

			testClearButton(driver); // test if the clear button clear the field

			Thread.sleep(2000);

			testDecimalNumber(driver); // test if the decimal numbers are shown

			Thread.sleep(2000);

			testClearButton(driver); // test if the clear button clear the field

			Thread.sleep(5000);

			driver.quit();

		} catch (MalformedURLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (InterruptedException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	private static void testDigitPressed(AndroidDriver driver) {

		driver.findElement(By.id("net.ludeke.calculator:id/digit1")).click();
		driver.findElement(By.id("net.ludeke.calculator:id/digit2")).click();
		driver.findElement(By.id("net.ludeke.calculator:id/digit3")).click();

		checkTheEditTextValue(driver, "123", "Digits Test Passed","Digits Test Failed");

	}

	private static void testNumericAndArithmeticButtonPressed(AndroidDriver driver) {

		driver.findElement(By.id("net.ludeke.calculator:id/digit1")).click();
		driver.findElement(By.id("net.ludeke.calculator:id/digit2")).click();
		driver.findElement(By.id("net.ludeke.calculator:id/plus")).click();
		driver.findElement(By.id("net.ludeke.calculator:id/digit3")).click();

		checkTheEditTextValue(driver, "12plus3", "Arithmatic Test Passed","Arithmatic Test Failed");

	}

	private static void testClearButton(AndroidDriver driver) {

		WebElement element = driver.findElement(By.id("net.ludeke.calculator:id/del"));

		TouchAction action = new TouchAction(driver)
				.longPress(longPressOptions().withElement(element(element)).withDuration(Duration.ofMillis(2000)))
				.release().perform();

		checkTheEditTextValue(driver, "", "Clear display Test Passed","Clear display Test Failed");

	}

	private static void testDecimalNumber(AndroidDriver driver) throws InterruptedException {

		driver.findElement(By.id("net.ludeke.calculator:id/digit1")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/digit2")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/digit3")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/dot")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/digit4")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/digit2")).click();

		// Thread.sleep(2000);

		checkTheEditTextValue(driver, "123point42", "Decimal Test Passed","Decimal Test Failed");

	}

	public static void checkTheEditTextValue(AndroidDriver driver, String expectedValue, String successTestMsg,String failMsg) {

		List<WebElement> webElements =

				driver.findElements(By.className("android.widget.EditText"));

		for (int i = 0; i < webElements.size(); i++) {

			WebElement webElement = webElements.get(i);
			String value = webElement.getText().toString();

			if (value.trim().equals(expectedValue))
			{
				System.out.println(successTestMsg);
			} else {
				System.out.println(failMsg);
			}

		}

	}
}
