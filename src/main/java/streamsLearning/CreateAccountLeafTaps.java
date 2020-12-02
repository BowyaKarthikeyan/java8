package streamsLearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateAccountLeafTaps {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("https://shop.polymer-project.org/");
//		WebElement str = (WebElement) driver.executeScript("return document.querySelector('shop-app').shadowRoot.querySelector('shop-home').shadowRoot.querySelector('shop-button>a')");
//		((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", str);
//		System.out.println(str.getText());
//		str.click();
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Accounts").click();
		driver.findElementByLinkText("Create Account").click();
		driver.findElementById("annualRevenue").sendKeys("1000000",Keys.TAB);
		Shadow shadow = new Shadow(driver);
		WebElement shadowEle = shadow.findElement(driver.findElementById("annualRevenue"),"#placeholder");
		System.out.println(shadowEle.getText());
	}

}
