package shadowDom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithShadowDOM {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://shop.polymer-project.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement str = (WebElement) driver.executeScript("return document.querySelector('shop-app').shadowRoot.querySelector('shop-home').shadowRoot.querySelector('shop-button>a')");
		driver.executeScript("return arguments[0].shadowRoot", str);
		System.out.println(str.getText());
		str.click();
	}
}
