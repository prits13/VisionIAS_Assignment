package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	WebDriver ldriver;
	public loginPage(WebDriver rDriver)
	{
		ldriver=rDriver;
		PageFactory.initElements(rDriver,this);
	}

	@FindBy(id = "emailid")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "userLogin")
	WebElement loginBtn; 

	@FindBy(xpath = "//div[@class='swal-button__loader']")
	WebElement acceptPopup;

	public void enterEmail(String emailAdd)
	{
		email.sendKeys(emailAdd);
	}
	public void enterPassword(String pwd) 
	{
		password.sendKeys(pwd);	
	}
	public void clickOnLoginButton() 
	{
		loginBtn.click();
	}
	public String extractPopupMessage()
	{
		return acceptPopup.getText();
	}
	public void popup()
	{
		acceptPopup.click();
	}

}