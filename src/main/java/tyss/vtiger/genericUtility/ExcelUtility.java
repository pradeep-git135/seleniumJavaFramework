package tyss.vtiger.genericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getExcelData(String sheetName, int rowNum, int colNum) throws Throwable{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\exceldata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
		return data;
	}
	public Object[][] getExcelData(String sheetName) throws Throwable{
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\exceldata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lstrow = sh.getLastRowNum();
		short lstcolumn = sh.getRow(0).getLastCellNum();
		
		 Object[][] data = new Object[lstrow][lstcolumn];
		 
		 for (int i = 0; i < lstrow; i++) {
			for (int j = 0; j < lstcolumn; j++) {
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}
}
