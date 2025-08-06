package stepDefinitions;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterStepDef {

	WebDriver driver;
	String username = "";

	@Given("User navigates to Home Page")
	public void user_navigates_to_home_page() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}

	@Given("Clicks On Register Link")
	public void clicks_on_register_link() {
		WebElement regElement = driver.findElement(By.xpath("//a[text()='Register here']"));
		regElement.click();
	}

	@When("user enters user details")
	public void user_enters_user_details() {
		// Write code here that turns the phrase above into concrete actions
		WebElement fnameElement = driver.findElement(By.id("firstName"));
		WebElement lnameElement = driver.findElement(By.id("lastName"));
		WebElement userEmailElement = driver.findElement(By.id("userEmail"));
		WebElement userMobileElement = driver.findElement(By.id("userMobile"));
		fnameElement.sendKeys("chandra");
		lnameElement.sendKeys("alahari");
		userEmailElement.sendKeys("chandra@chandra.com");
		userMobileElement.sendKeys("1111111111");

		WebElement occElement = driver.findElement(By.xpath("//select[@formcontrolname='occupation']"));
		Select selecOcc = new Select(occElement);
		selecOcc.selectByVisibleText("Engineer");

		WebElement radio = driver.findElement(By.xpath(
				"//label[text()='Gender']/following-sibling::label/input[@type='radio' and @value='" + "Male" + "']"));
		WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		eWait.until(ExpectedConditions.elementToBeClickable(radio));
		radio.click();

	}

	@When("user enters user details with user id {string} password {string} email {string}")
	public void user_enters_user_details_with_user_id_password_email(String userId, String password, String email) {
       username = userId;
		// Write code here that turns the phrase above into concrete actions
		WebElement fnameElement = driver.findElement(By.id("firstName"));
		WebElement lnameElement = driver.findElement(By.id("lastName"));
		WebElement userEmailElement = driver.findElement(By.id("userEmail"));
		WebElement userMobileElement = driver.findElement(By.id("userMobile"));
		fnameElement.sendKeys(userId);
		lnameElement.sendKeys(password);
		userEmailElement.sendKeys(email);
		userMobileElement.sendKeys("1111111111");

		WebElement occElement = driver.findElement(By.xpath("//select[@formcontrolname='occupation']"));
		Select selecOcc = new Select(occElement);
		selecOcc.selectByVisibleText("Engineer");

		WebElement radio = driver.findElement(By.xpath(
				"//label[text()='Gender']/following-sibling::label/input[@type='radio' and @value='" + "Male" + "']"));
		WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		eWait.until(ExpectedConditions.elementToBeClickable(radio));
		Actions actRadio = new Actions(driver);
		actRadio.moveToElement(radio).click().perform();
		//radio.click();
	}

	@When("clicks on Register Button")
	public void clicks_on_register_button() {
		System.out.println("USERNAME IS " + username);
		// Write code here that turns the phrase above into concrete actions
		WebElement registerBtn = driver.findElement(By.id("login"));
		registerBtn.click();
	}

	@Then("user should be registered")
	public void user_should_be_registered() {
		// Write code here that turns the phrase above into concrete actions
		WebElement errorPassword = driver.findElement(By.xpath("//div[text()='*Please check above checkbox']"));
		WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		eWait.until(ExpectedConditions.visibilityOf(errorPassword));

		Assert.assertEquals(errorPassword.getText(), "*Please check above checkbox");

	}

	@Then("Close the browser") // Cucumber Hooks
	public void close_the_browser() throws InterruptedException {
		try {
			// Small wait before quitting to stabilize communication
			Thread.sleep(1000); // or use proper WebDriverWait
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (driver != null) {
			driver.quit();
		}
	}

	@AfterTest // Hooks
	public void tearDown() {

	}

}
