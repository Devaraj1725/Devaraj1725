package testScripts;

import org.testng.annotations.Test;

import pomScripts.Leave;
import pomScripts.LoginPage;
import utility.BaseTest;

public class LeaveApprove extends BaseTest {

	@Test
	public void leave() {

		LoginPage log = new LoginPage(driver);
		test("leave approv", "devaraj", "functional", "windows");
		Leave lev = new Leave(driver);
		log.UserName("Admin");
		log.Password("admin123");
		
		log.ClickLongin();
		test.info("logged in");
		lev.leave();
		test.info("cliked on leave button");
		lev.Approve();
		test.info("leave approvde");
	}

}
