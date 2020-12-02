package shadowDom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithCSS {
	public static WebElement getShadowRoot(ChromeDriver driver,WebElement rootElement) {
		WebElement ele = (WebElement) driver.executeScript("return arguments[0].shadowRoot", rootElement);
		return ele;
	}
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://shop.polymer-project.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement root = driver.findElementByCssSelector("shop-app");
		WebElement shadowHost = getShadowRoot(driver, root);
		WebElement shadowRoot = shadowHost.findElement(By.cssSelector("shop-home"));
		WebElement shadowRoot1 = getShadowRoot(driver, shadowRoot);
		WebElement element = shadowRoot1.findElement(By.cssSelector("shop-button>a"));
		System.out.println(element.getText());
		
	}

}
