package poi;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import com.wistron.pojo.Bios;

public class ImportBios {
	
	private List<Bios> newData = new ArrayList<Bios>();
	private List<Bios> originalData = new ArrayList<Bios>();
	private List<Integer> ids = new ArrayList<Integer>();
	
	@Test
	public void importBios() throws Exception {
		
		InputStream inp = new FileInputStream("bios_owner.xlsx");
		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheet("Bios");
		/* 
		 * Gets the last row on the sheet
		 * Note: rows which had content before and were set to empty later might still be counted as rows by Excel and Apache POI, 
		 * so the result of this method will include such rows and thus the returned value might be higher than expected!
		 */
		int rowNum = sheet.getLastRowNum();
		//gets the second row which is the start of data
		Row row1 = sheet.getRow(1);
		
		//gets amount of the data cell in this row 
//		short cellAmount = row1.getLastCellNum();
		//Get the first cell contained in this row
//		Cell cell = row1.getCell(1);
//		Cell cell = row1.getCell(0);
		
//		String cellValue = cell.getStringCellValue();
//		int cellValue = (int) cell.getNumericCellValue();
//		System.out.println("cellValue:  "+cellValue);
		
		//Notice that the data starts on the second row
		for(int i=1;i<=rowNum;i++) {
			Row row = sheet.getRow(i);
			int bios_id = (int) row.getCell(0).getNumericCellValue();
			String  owner = row.getCell(1).getStringCellValue();
			String  chassis = row.getCell(2).getStringCellValue();
			String  platform = row.getCell(3).getStringCellValue();
			String  test_type = row.getCell(4).getStringCellValue();
			String  start = row.getCell(5).getStringCellValue();
			String  end = row.getCell(6).getStringCellValue();
			Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(start);
			Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end);
			
			String  bios_version = row.getCell(7).getStringCellValue();
			String  image_build_id = row.getCell(8).getStringCellValue();
			String  test_plan = row.getCell(9).getStringCellValue();
			String  tester = row.getCell(10).getStringCellValue();
			originalData.add(new Bios(bios_id,owner,chassis,platform,test_type,startDate,endDate,bios_version,image_build_id,test_plan,tester));
				
			
			
			
		}
		
		System.out.println("rowNum:  "+rowNum);
		//System.out.println("lastCellNum:  "+cellAmount);
		//System.out.println("stringCellValue:  "+stringCellValue);
		System.out.println("ids  :  "+ids);
		System.out.println("originalData  :  "+originalData+"\n listSize:"+originalData.size());
	}
	
}
