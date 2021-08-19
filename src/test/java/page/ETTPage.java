package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ETTPage {

	public ETTPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyPageIsDisplayed(WebDriverWait wait, String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyPageIsDisplayed(WebDriver driver, String eTitle) {
		String aTitle = driver.getTitle();
		return aTitle.equals(eTitle);
	}

}
