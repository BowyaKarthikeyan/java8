package streamsLearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice {

	public static void main(String[] args) throws InterruptedException {
//		String str = "Welcome to Chennai";
//		int count=0;
//		int length = str.length();
//		for (int i = 0; i < length; i++) {
//			if(str.charAt(i) == 'e') {
//				count = count+1;
//			}
//		}
//	System.out.println(count);

		String str = "welcome to chennai";

		int varcount = 0;
		char[] charArray = str.toCharArray();
		Character.isLetter(charArray[1]);
		int lenthofarray = charArray.length;
		System.out.println(lenthofarray);
		for (int i = 0; i <= lenthofarray; i++) {
			if (charArray[i] == 'e') {
				varcount = varcount + 1;
			}
		}

	}
}