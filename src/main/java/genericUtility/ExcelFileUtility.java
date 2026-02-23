package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	public String toReadDataFromExcel(String sheetname,int Rownum,int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis =new FileInputStream("./src\\test\\resources\\practice.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(sheetname).getRow(Rownum).getCell(cell).getStringCellValue();
	wb.close();
	return data;
	
}
	public int togetLastRownum(String Sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("./src\\test\\resources\\practice.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount=wb.getSheet(Sheetname).getLastRowNum();
		return rowcount;
		
	}
}
