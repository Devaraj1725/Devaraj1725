package pomScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Leave extends SuperConstructors{
	
	@FindBy(xpath="//span[.='Leave']")
	private WebElement leaveBtn;
	
	@FindBy(xpath="(//div[.='Aaliyah  Haq']/..//button[@class='oxd-button oxd-button--medium oxd-button--label-success oxd-table-cell-action-space'])[1]")
	private WebElement ApproveBtn;

	public Leave(WebDriver driver) {
		super(driver);
	}
	
	public void leave() {
		leaveBtn.click();
	}
public void Approve() {
	ApproveBtn.click();


}
}
