package tyss.vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getExcelData(String sheetName, int rowNum, int colNum) throws Throwable{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\exceldata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
		return data;
	}
}
