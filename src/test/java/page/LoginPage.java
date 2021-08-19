package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement unTB;

	@FindBy(name = "pwd")
	private WebElement pwdTB;

	@FindBy(xpath = "//div[text()='Login ']")
	private WebElement loginBTN;

	@FindBy(xpath = "//span[contains(text(),'invalid')]")
	private WebElement errorMsg;

	public void setUsername(String userName) {
		unTB.sendKeys(userName);

	}

	public void setPassword(String password) {
		pwdTB.sendKeys(password);

	}

	public void clickLogin() {
		loginBTN.click();

	}

	public boolean validateErrorMsgDisplayed(WebDriverWait wait) {
		try {
			wait.until(ExpectedConditions.visibilityOf(errorMsg));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
