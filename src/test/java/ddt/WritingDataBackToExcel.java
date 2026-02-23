package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataBackToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("C:\\Users\\gpras\\OneDrive\\Desktop\\practice.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		Row r = sh.getRow(1);
		Cell c = r.createCell(2);
		c.setCellType(CellType.STRING);
		c.setCellValue("pass");
		FileOutputStream fos=new FileOutputStream("C:\\Users\\gpras\\OneDrive\\Desktop\\practice.xlsx");
		wb.write(fos);
		wb.close();		

	}

}
