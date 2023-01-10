package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pomScripts.LoginPage;
import utility.BaseTest;

public class Login extends BaseTest {
	@Test
	public void login() throws IOException, InterruptedException {

		LoginPage log = new LoginPage(driver);
		test("login", "devaraj", "functional", "windows");
		log.UserName("Admin");
		test.info("enterde user name");
		log.Password("admin123");
		test.info("entred password");
		log.ClickLongin();
		test.info("home page displayed");
		String com = driver.getTitle();
		Assert.assertEquals(com, "OrangeHRM");

	}

}
