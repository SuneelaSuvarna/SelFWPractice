package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static String getData(String path, String sheetName,int row, int col)
			throws EncryptedDocumentException, FileNotFoundException, IOException {

		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		String value = wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();

		return value;
	}

}
