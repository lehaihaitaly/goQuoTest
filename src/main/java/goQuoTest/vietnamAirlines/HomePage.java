package goQuoTest.vietnamAirlines;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Base {

	@FindBy(id = "loaive_r")
	WebElement returnTicket;

	@FindBy(id = "departCity")
	WebElement departCity;

	@FindBy(xpath = "//*[@code='HAN']")
	WebElement hanoiAirport;

	@FindBy(id = "adult")
	WebElement adult;

	@FindBy(id = "child")
	WebElement child;

	@FindBy(id = "cmdsearch")
	WebElement search;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void selectReturnTicket() {
		returnTicket.click();
	}

	public void selectDepartCity() {
		departCity.click();
	}

	public void selectHanoiAirport() {
		hanoiAirport.click();
	}

	public void selectHoChiMinhAirport() {
		WebElement rememberMe = driver.findElement(By.className("sanbayres"));
		List<WebElement> listElements = rememberMe.findElements(By.tagName("b"));
		for (WebElement e : listElements) {
			if (e.getText().contains("Hồ Chí Minh")) {
				Actions actions = new Actions(driver);
				actions.doubleClick(e).perform();
			}
		}
	}

	public void selectCheckInDate(String day) {
		WebElement checkIn = driver.findElement(By.id("flights-checkin"));
		Actions actions = new Actions(driver);
		actions.doubleClick(checkIn).perform();
		WebElement thang3 = driver.findElement(By.className("ui-datepicker-group-first"));
		List<WebElement> March = thang3.findElements(By.className("ui-datepicker-day"));
		System.out.print(March.size());
		for (WebElement e : March) {
			if (e.getText().contains(day)) {
				Actions a = new Actions(driver);
				a.doubleClick(e).perform();
			}
		}
	}

	public void selectCheckOutDate(String day) {
		WebElement checkOut = driver.findElement(By.id("flights-checkout"));
		Actions actions3 = new Actions(driver);
		actions3.doubleClick(checkOut).perform();
		WebElement thang4 = driver.findElement(By.className("ui-datepicker-group-middle"));
		List<WebElement> April = thang4.findElements(By.className("ui-datepicker-day"));
		for (WebElement e : April) {
			if (e.getText().contains(day)) {
				Actions b = new Actions(driver);
				b.doubleClick(e).perform();
				break;
			}
		}
	}

	public void selectNumberOfAdults(int a) {
		adult.click();
		Select select = new Select(driver.findElement(By.id("adult")));
		select.selectByIndex(a - 1);
	}

	public void selectNumberOfChildren(int a) {
		child.click();
		Select select = new Select(driver.findElement(By.id("child")));
		select.selectByIndex(a);
	}

	public void search() {
		search.click();
	}
}
