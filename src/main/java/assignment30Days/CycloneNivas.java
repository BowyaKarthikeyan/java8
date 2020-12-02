package assignment30Days;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CycloneNivas {

	public int loopList(List<WebElement> goodleList) {
		int result = 0;
		for (WebElement list : goodleList) {
			System.out.println(list.getText());
			//checking the site contains zoom.earth
			if (list.getText().contains("zoom.earth")) {
				result = 1;
				//Click on that link zoom.earth
				list.click();
				break;
			} else {
				result = 0;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Go to google.com
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		 //type "cyclone nivar"
		driver.findElementByXPath("//input[@title='Search']").sendKeys("cyclone nivar live tracking map",Keys.ENTER);
//		driver.findElementByXPath("//b[text()=' live tracking']").click();
		
		//Search for results starting with Zoom Earthzoom.earth
		
		//get the pagination list to iterate and get the link zoom.earth
		List<WebElement> pagination = driver.findElementsByXPath("//h1[text()='Page navigation']/following-sibling::table//td");
		for (int i = 1; i < pagination.size()-1; i++) {
			
			//list of cite names under the page
			List<WebElement> goodleList = driver.findElementsByXPath("//div[@class='yuRUbf']//cite");
			int res = new CycloneNivas().loopList(goodleList);
			if (res == 0) {
				driver.findElementByXPath(
						"//h1[text()='Page navigation']/following-sibling::table//td[@class='YyVfkd']/following-sibling::td[1]")
						.click();
			}else {
				break;
			}
		}
		
		//Print the present highlighted pressure
		String highPressure = driver.findElementByXPath("(//article[@class='panel storm-info']//table/tbody/tr[@title='Cyclonic Storm']/td[@class='pressure'])[1]").getText();
		System.out.println("Present Highlighted Pressure : " + highPressure);
		
		//Print the present highlighted wind
		String wind = driver.findElementByXPath("(//article[@class='panel storm-info']//table/tbody/tr[@title='Cyclonic Storm']/td[@class='wind'])[1]").getText();
		System.out.println("Present Highlighted Wind : " + wind);
		
		//Print the present highlighted type
		String type = driver.findElementByXPath("(//article[@class='panel storm-info']//table/tbody/tr[@title='Cyclonic Storm']/td[@class='type'])/span[1]").getText();
		System.out.println("Present Highlighted Wind : " + type);
		
		//Find the forecasted time that it hits land
		String time = driver.findElementByXPath("(//article[@class='panel storm-info']//table/tbody/tr[@title='Severe Cyclonic Storm']/td[@class='time'])[1]").getText();
		System.out.println("Forcast time Hit on Earth : " + time);
	}

}
