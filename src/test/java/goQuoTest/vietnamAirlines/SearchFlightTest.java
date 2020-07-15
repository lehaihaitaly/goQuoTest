package goQuoTest.vietnamAirlines;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import goQuoTest.vietnamAirlines.Base;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchFlightTest extends Base {
	HomePage homePage;
	WebDriverWait wait;

	@BeforeClass
	public void run() {
		setUp();
		homePage = new HomePage();
		wait = new WebDriverWait(driver, 1000);
	}

	@Test
	public void test() throws InterruptedException {
		homePage.selectReturnTicket();

		homePage.selectDepartCity();
		homePage.selectHanoiAirport();
		homePage.selectHoChiMinhAirport();
		homePage.selectCheckInDate("31");

		homePage.selectNumberOfAdults(3);
		homePage.selectNumberOfChildren(1);
		homePage.search();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Đang tìm kiếm kết quả tốt nhất')]")));
		boolean lowestPrice = driver.getPageSource().contains("Giá rẻ nhất");
		assertTrue(lowestPrice);
		boolean payment = driver.getPageSource().contains("Chọn mua");
		assertTrue(payment);
	}

	@AfterClass
	public void closeBrowsers() {
//		tearDown();
	}
}
