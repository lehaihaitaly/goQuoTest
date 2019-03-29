package goQuoTest.vietnamAirlines;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver driver;
	public static String baseUrl = "https://vietnamairslines.com/?gclid=EAIaIQobChMIt_qrxKTo4AIVSaSWCh1anwfNEAAYAiAAEgKLUPD_BwE";

	public void setUp() {
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();

	}

	public void tearDown() {
		driver.close();
	}
}