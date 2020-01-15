package Stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Loginsteps {
	WebDriver driver = null;

	@Given("^I am on \"([^\"]*)\"$")
	public void i_am_on(String arg1) throws Throwable {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\da4\\Documents\\MacroFiles\\chromedriver76\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);
		driver.get("http://practice.automationtes.in");
		System.out.println("Super");

	}

	@When("^I click on MyAccount$")
	public void i_click_on_MyAccount() throws Throwable {
		driver.findElement(By.xpath("//a[text()='My Account']")).click();

	}

	@When("^I Entered Valid username and password$")
	public void i_Entered_Valid_username_and_password() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("dhanapalinfocse@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Dhana-07");

	}

	@When("^I clicked on Login Button$")
	public void i_clicked_on_Login_Button() throws Throwable {
		driver.findElement(By.name("login")).click();
	}

	@Then("^User should successfully login into the application$")
	public void user_should_successfully_login_into_the_application() throws Throwable {
		WebElement name = driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']//strong"));
		String expectedname = name.getAttribute("innerText");
		if(expectedname.equals("dhanapalinfocse "))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("Failure");
		}
	}


}
