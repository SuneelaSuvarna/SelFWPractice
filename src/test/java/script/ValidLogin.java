package script;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.ETTPage;
import page.LoginPage;

public class ValidLogin extends BaseTest {

	@Test(priority = 1)
	public void testValidLogin() throws EncryptedDocumentException, FileNotFoundException, IOException {
//		1.	Enter valid user name

		String un = Excel.getData(XL_PATH, "ValidLogin", 1, 0);
		String pw = Excel.getData(XL_PATH, "ValidLogin", 1, 1);
		String title = Excel.getData(XL_PATH, "ValidLogin", 1, 2);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(un);
//		2.	Enter valid password
		loginPage.setPassword(pw);
//		3.	Click on login
		loginPage.clickLogin();
//		4.	Verify Home Page is Displayed
		ETTPage ettPage = new ETTPage(driver);
		boolean result = ettPage.verifyPageIsDisplayed(wait, title);
		Assert.assertEquals(result, true);
	}

}
