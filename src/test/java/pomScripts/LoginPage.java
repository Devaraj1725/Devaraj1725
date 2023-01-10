package pomScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends SuperConstructors {
	
	@FindBy (xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy (xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void UserName (String un) {
		username.sendKeys(un);
	}
	
	public void Password(String pass) {
		password.sendKeys(pass);
	}
	public void ClickLongin() {
		loginButton.click();
	}

	

}
