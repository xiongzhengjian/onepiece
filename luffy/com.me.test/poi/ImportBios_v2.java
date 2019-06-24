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

import com.wistron.dao.BiosDaoImpl;
import com.wistron.pojo.Bios;

public class ImportBios_v2 {
	
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
		System.out.println("originalData  :  "+originalData+"\n listSize:"+originalData.size());
	}
	
	@Test
	public void insertMultiple() throws Exception {
		//open a file input stream
		InputStream inp = new FileInputStream("bios_owner.xlsx");
		//Get the target workbook object from the file input stream
		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheet("Bios");
		//find and locate the row with ID equal to 0
		int locateIndex = 10000;
		int rowNum = sheet.getLastRowNum();
		for(int index=1;index<=rowNum;index++) {
			Row row = sheet.getRow(index);
			Cell iDcell = row.getCell(0);
			int idValue = (int) iDcell.getNumericCellValue();
			if(idValue==0) {
				locateIndex = index;
				break;
			}
		}		
		//System.out.println(locateIndex);
		if(locateIndex==10000) {
			//Invalid submission
			return;
		}
		//Encapsulate the new data into the List
		List<Bios> newDataList = new ArrayList<Bios>();
		for(int i=locateIndex;i<=rowNum;i++) {
			Row locateRow = sheet.getRow(i);
			int bios_id = (int) locateRow.getCell(0).getNumericCellValue();
			String  owner = locateRow.getCell(1).getStringCellValue();
			String  chassis = locateRow.getCell(2).getStringCellValue();
			String  platform = locateRow.getCell(3).getStringCellValue();
			String  test_type = locateRow.getCell(4).getStringCellValue();
			String  start = locateRow.getCell(5).getStringCellValue();
			String  end = locateRow.getCell(6).getStringCellValue();
			Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(start);
			Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end);
			
			String  bios_version = locateRow.getCell(7).getStringCellValue();
			String  image_build_id = locateRow.getCell(8).getStringCellValue();
			String  test_plan = locateRow.getCell(9).getStringCellValue();
			String  tester = locateRow.getCell(10).getStringCellValue();
			
			newDataList.add(new Bios(owner,chassis,platform,test_type,startDate,endDate,bios_version,image_build_id,test_plan,tester));
		}
		
		//System.out.println(newDataList);
		
		//Insert the data into the database
		BiosDaoImpl dao = new BiosDaoImpl();
		dao.insertBioses(newDataList);
		
		
	}
	
	@Test
	public void insertMultipleExcel() throws Exception {
		//open a file input stream
		InputStream inp = new FileInputStream("bios_owner.xlsx");
		//Get the target workbook object from the file input stream
		Workbook wb = WorkbookFactory.create(inp);
		//get all sheets
		Sheet sheet = wb.getSheet("Bios");
		
		
		
	}
	
}
