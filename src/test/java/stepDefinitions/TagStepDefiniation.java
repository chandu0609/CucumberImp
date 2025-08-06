package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TagStepDefiniation {

	WebDriver driver;

	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		System.out.println("Browser launched");
	}

	@After
	public void teardown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Browser closed");
		}
	}

	@Given("User navigates to Home Page One")
	public void user_navigates_to_home_page_one() {
		System.out.println("Background executed");
	}

	@Given("user one input")
	public void user_one_input() {
		System.out.println("one input executed");
	}

	@Given("user two input")
	public void user_two_input() {
		System.out.println("one two executed");
	}

	@Given("user three input")
	public void user_three_input() {
		System.out.println("one three executed");
	}

	@Given("user four input")
	public void user_four_input() {
		System.out.println("one four executed");
	}

	@Given("user five input")
	public void user_five_input() {
		System.out.println("one five executed");
	}

	@Given("user six input")
	public void user_six_input() {
		System.out.println("one six executed");
	}
}
