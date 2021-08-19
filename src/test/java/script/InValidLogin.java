package script;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class InValidLogin extends BaseTest {

	@Test(priority = 2)
	public void testInValidLogin() throws EncryptedDocumentException, FileNotFoundException, IOException {

		String un = Excel.getData(XL_PATH, "InValidLogin", 1, 0);
		String pwd = Excel.getData(XL_PATH, "InValidLogin", 1, 1);
		String msg = Excel.getData(XL_PATH, "InValidLogin", 1, 2);
		// Enter wrong username
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(un);
		// Enter wrong password
		loginPage.setPassword(pwd);
		// Click on login btn
		loginPage.clickLogin();
		// Verify error msg
		boolean result = loginPage.validateErrorMsgDisplayed(wait);
		Assert.assertEquals(result, true, msg);

	}

}
