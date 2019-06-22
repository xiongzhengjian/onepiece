package poi;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

public class ImportBios {
	
	@Test
	public void importBios() throws Exception {
		
		InputStream inp = new FileInputStream("bios.xlsx");
		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheet("Bios");
		int lastRowNum = sheet.getLastRowNum();
		Row row0 = sheet.getRow(0);
		short lastCellNum = row0.getLastCellNum();
		Cell cell = row0.getCell(2);
		String stringCellValue = cell.getStringCellValue();
		//int rowNum = row2.getRowNum();
		
//		for(int i=0;i<lastRowNum;i++) {
//			Row row = sheet.getRow(i);
//			Cell cell = row.getCell(2);
//			
//			
//		}
		
		System.out.println(lastRowNum);
		System.out.println(lastCellNum);
		System.out.println(stringCellValue);
	}
	
}
