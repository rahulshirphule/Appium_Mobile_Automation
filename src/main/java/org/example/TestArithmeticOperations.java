package org.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.example.TestDisplay;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

//import io.appium.java_client.AppiumBy.ById;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestArithmeticOperations {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");

		dc.setCapability("appPackage", "net.ludeke.calculator");
		dc.setCapability("appActivity", "com.android.calculator2.Calculator");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver driver = new AndroidDriver(url, dc);
		Thread.sleep(5000);

		driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();

		Thread.sleep(5000);

		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(5000);

		testPlusArithmeticOperation(driver);

		testMinusArithmaticOperation(driver);

		testMultiplyArithmaticOperaton(driver);

		testDevideArithmaticOperation(driver);

		Thread.sleep(3000);

		driver.quit();
	}

	private static void testMultiplyArithmaticOperaton(AndroidDriver driver) throws InterruptedException {

		// Test if the multiply arithmetic operation works and the result is correct,
		// and it is printed on the display after the equal button is pressed

		driver.findElement(By.id("net.ludeke.calculator:id/clear")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("net.ludeke.calculator:id/digit2")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/mul")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/digit4")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/equal")).click();

		Thread.sleep(5000);

		TestDisplay.checkTheEditTextValue(driver,"8","multiply arithmetic operation passed","multiply arithmetic operation failed");

	}

	private static void testMinusArithmaticOperation(AndroidDriver driver) throws InterruptedException {

		// Test if the minus arithmetic operation works and the result is correct, and
		// it is printed on the display after the equal button is pressed

		driver.findElement(By.id("net.ludeke.calculator:id/clear")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("net.ludeke.calculator:id/digit9")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/minus")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/digit6")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/equal")).click();

		Thread.sleep(5000);

		TestDisplay.checkTheEditTextValue(driver,"3","minus arithmetic operation passed","minus arithmetic operation failed");

	}


	private static void testPlusArithmeticOperation(AndroidDriver driver) throws InterruptedException {
		// Test if the plus arithmetic operation works and the result is correct, and it
		// is printed on the display after the equal button is pressed

		driver.findElement(By.id("net.ludeke.calculator:id/digit7")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/plus")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/digit3")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/equal")).click();

		Thread.sleep(5000);

		TestDisplay.checkTheEditTextValue(driver,"10","plus arithmetic operation passed","plus arithmetic operation failed");

	}

	private static void testDevideArithmaticOperation(AndroidDriver driver) throws InterruptedException {

		// Test if the divide arithmetic operation works and the result is correct, and
		// it is printed on the display after the equal button is pressed

		driver.findElement(By.id("net.ludeke.calculator:id/clear")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("net.ludeke.calculator:id/digit9")).click();
		driver.findElement(By.id("net.ludeke.calculator:id/div")).click();
		driver.findElement(By.id("net.ludeke.calculator:id/digit3")).click();
		driver.findElement(By.id("net.ludeke.calculator:id/equal")).click();

		Thread.sleep(5000);

		TestDisplay.checkTheEditTextValue(driver,"3","divide arithmetic operation passed","divide arithmetic operation failed");

	}

}
