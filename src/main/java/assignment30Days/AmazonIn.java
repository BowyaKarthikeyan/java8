package assignment30Days;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonIn {

	public static void main(String[] args) throws InterruptedException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement searchIn = driver.findElementById("searchDropdownBox");
		Select search = new Select(searchIn);
		searchIn.click();
		search.selectByVisibleText("Furniture");
		driver.findElementById("twotabsearchtextbox").sendKeys("chairs for computer table", Keys.ENTER);
		Thread.sleep(5000);
		List<WebElement> priceOfChairs = driver
				.findElements(By.xpath("//span[@data-a-color='price']//span[@class = 'a-offscreen']"));
		Map<Integer, String> priceChairs = new HashMap<>();
		List<Integer> priceAmount = new ArrayList<Integer>();
		for (WebElement getPrice : priceOfChairs) {
			String text = getPrice.getAttribute("innerText").replaceAll("[^0-9]", "");
			priceAmount.add(Integer.parseInt(text));
			priceChairs.put(Integer.parseInt(text), getPrice.getAttribute("innerText"));//.replace("₹", ""));
		}
//		Collections.sort(priceAmount);
//		List<Integer> sortedList = priceAmount.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//		Integer price = sortedList.get(0);
		TreeMap<Integer, String> sortedMapList = priceChairs.entrySet().stream().sorted(Map.Entry.comparingByKey())
		  .collect(Collectors.toMap(
				    Map.Entry::getKey, 
				    Map.Entry::getValue, 
				    (key, Value) -> key, TreeMap::new));
	    
//		new DecimalFormat("#,###,###").format(1000000);
		String highestPrice = driver
				
				.findElementByXPath(
						"//span[@data-a-color='price']//span[contains(text(),'" + sortedMapList.get(sortedMapList.lastKey()) + "')]")
				.getAttribute("innerText");
		System.out.println("The Highest Price of Chairs : " + highestPrice);
		WebElement stars = driver.findElementByXPath("//span[contains(text(),'" + highestPrice +"')]/preceding::div[@class='a-row a-size-small'][1]//i[2]");
//		Actions builder = new Actions(driver);
//		builder.moveToElement(stars).perform();
		driver.executeScript("arguments[0].click()", stars);
		String sizeBase = driver.findElementByXPath("//span[contains(text(),'" + highestPrice +"')]/preceding::div[@class='a-row a-size-small'][1]/span[2]//span").getText();
		System.out.println(sizeBase);
		String rating = driver.findElementByXPath("//span[contains(text(),'" + highestPrice +"')]/preceding::div[@class='a-row a-size-small'][1]/span[1]").getAttribute("aria-label");
		System.out.println(rating);
		String ratingPerc = driver.findElementByXPath("(//span[contains(text(),'" + rating.replaceAll(" stars", "") + "')])[2]/following::table//td[3]//a").getText();
		System.out.println(ratingPerc);
		System.out.println((Integer.parseInt(sizeBase)*Integer.parseInt(ratingPerc.replace("%", "")))/100);
	}

}
