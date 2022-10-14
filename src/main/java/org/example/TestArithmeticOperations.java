package calculator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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

		// Test if the plus arithmetic operation works and the result is correct, and it
		// is printed on the display after the equal button is pressed

		driver.findElement(By.id("net.ludeke.calculator:id/digit7")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/plus")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/digit3")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/equal")).click();

		Thread.sleep(5000);

		List<WebElement> offerElements = driver.findElements(By.className("android.widget.EditText"));

		for (int i = 0; i < offerElements.size(); i++) {

			WebElement offerElement = offerElements.get(i);

			String value = offerElement.getText().toString();

			System.out.println("offerElement: {} " + value);

			if (value.trim().equals("10"))

			{

				System.out.println("plus arithmetic operation passed");
			} else {
				System.out.println("plus arithmetic operation failed");
			}

		}

		// Test if the minus arithmetic operation works and the result is correct, and
		// it is printed on the display after the equal button is pressed

		driver.findElement(By.id("net.ludeke.calculator:id/clear")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("net.ludeke.calculator:id/digit9")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/minus")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/digit6")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/equal")).click();

		Thread.sleep(5000);

		List<WebElement> offerElements1 = driver.findElements(By.className("android.widget.EditText"));

		for (int i = 0; i < offerElements1.size(); i++) {

			WebElement offerElement1 = offerElements1.get(i);

			String value = offerElement1.getText().toString();

			System.out.println("offerElement1: {} " + value);

			if (value.trim().equals("3"))

			{

				System.out.println("minus arithmetic operation passed");
			} else {
				System.out.println("minus arithmetic operation failed");
			}

		}

		// Test if the multiply arithmetic operation works and the result is correct,
		// and it is printed on the display after the equal button is pressed

		driver.findElement(By.id("net.ludeke.calculator:id/clear")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("net.ludeke.calculator:id/digit2")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/mul")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/digit4")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/equal")).click();

		Thread.sleep(5000);

		List<WebElement> offerElements2 = driver.findElements(By.className("android.widget.EditText"));

		for (int i = 0; i < offerElements2.size(); i++) {

			WebElement offerElement2 = offerElements2.get(i);

			String value = offerElement2.getText().toString();

			System.out.println("offerElement2: {} " + value);

			if (value.trim().equals("8"))

			{

				System.out.println("multiply arithmetic operation passed");
			} else {
				System.out.println("multiply arithmetic operation failed");
			}

		}

		// Test if the divide arithmetic operation works and the result is correct, and
		// it is printed on the display after the equal button is pressed

		driver.findElement(By.id("net.ludeke.calculator:id/clear")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("net.ludeke.calculator:id/digit9")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/div")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/digit3")).click();

		driver.findElement(By.id("net.ludeke.calculator:id/equal")).click();

		Thread.sleep(5000);

		List<WebElement> offerElements3 = driver.findElements(By.className("android.widget.EditText"));

		for (int i = 0; i < offerElements3.size(); i++) {

			WebElement offerElement3 = offerElements3.get(i);

			String value = offerElement3.getText().toString();

			System.out.println("offerElement3: {} " + value);

			if (value.trim().equals("3"))

			{

				System.out.println("divide arithmetic operation passed");
			} else {
				System.out.println("divide arithmetic operation failed");
			}

		}

	}
}
