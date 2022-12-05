package StepDefination;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObject.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepDef {

	public WebDriver driver;
	public loginPage loginPg;

	@Given("User Launch browser")
	public void user_launch_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		loginPg = new loginPage(driver);
	}

	@When("User opens url {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	@And("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) {
		loginPg.enterEmail(emailadd);
		loginPg.enterPassword(password);
	}

	@And("Click on login")
	public void click_on_login() {
		loginPg.clickOnLoginButton();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle=driver.getTitle();
		if (actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);//pass
		}else {
			Assert.assertTrue(false);//fail
		}
		driver.manage().window().minimize();
		driver.close();
	}


	@And("Verify popup message should be {string}")
	public void verify_popup_message_should_be(String popmsg) throws Throwable  {
		Thread.sleep(500);
		Alert alert=driver.switchTo().alert();
		String altmsg =alert.getText();
		if (popmsg.equals(altmsg))
		{
			Assert.assertTrue(true);//pass

		}else {
			Assert.assertTrue(false);//fail
		}

	}

	@Then("Accept popup")
	public void accept_popup() 
	{

		loginPg.popup();
		driver.manage().window().minimize();
		driver.close();


	}

}
