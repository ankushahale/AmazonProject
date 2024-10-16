package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {

	public static String fetchDataFromExcelSheet(String sheet,int row,int cell) throws IOException 
	{
						
		FileInputStream file = new FileInputStream("C:\\Users\\useer1\\eclipse-workspace\\ProjectExcelData.xlsx");
		
		String data = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		
		return data;
	}
}
