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
import com.wistron.dao.CommodityDaoImpl;
import com.wistron.dao.SoftpaqDaoImpl;
import com.wistron.dao.SoftrollRespinDaoImpl;
import com.wistron.dao.WatDaoImpl;
import com.wistron.pojo.Bios;
import com.wistron.pojo.Commodity;
import com.wistron.pojo.Softpaq;
import com.wistron.pojo.SoftrollRespin;
import com.wistron.pojo.Wat;

public class RecordImport {
	
	private List<Bios> originalData = new ArrayList<Bios>();
	
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
	public void importMultiple() throws Exception {
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
		
//		System.out.println(newDataList);
		
		//Insert the data into the database
		BiosDaoImpl dao = new BiosDaoImpl();
		dao.insertBioses(newDataList);
		
		
	}
	
	@Test
	public void importAllRecord() throws Exception {
/*----------------------create the Workbook by input stream--------------------------*/
		//open a file input stream
		InputStream inp = new FileInputStream("record.xlsx");
		Workbook wb = WorkbookFactory.create(inp);
		
		
/*----------------------Bios--------------------------*/
				//get the sheet
				Sheet bios_sheet = wb.getSheet("Bios");
				/*
				 * locate_xxx:find and locate the row with ID equal to 0,because this value represents the location of the new data
				 * default value:10000. it is means no new data
				 * */
				int locate_bios = 10000;
				int rowNum = bios_sheet.getLastRowNum();
				
				
				//find out the location of new data
				for(int index=1;index<=rowNum;index++) {
					Row row = bios_sheet.getRow(index);
					Cell iDcell = row.getCell(0);
					int idValue = (int) iDcell.getNumericCellValue();
					if(idValue==0) {
						locate_bios = index;
						break;
					}
				}		
				System.out.println("bios new data location: "+locate_bios);
				
				if(locate_bios!=10000) {
					//Encapsulate the new data into the list
					List<Bios> new_bios_list = new ArrayList<Bios>();
					for(int i=locate_bios;i<=rowNum;i++) {
						Row locateRow = bios_sheet.getRow(i);
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
						
						new_bios_list.add(new Bios(owner,chassis,platform,test_type,startDate,endDate,bios_version,image_build_id,test_plan,tester));
					}
					
//					System.out.println(newDataList);
					
					//Insert the data into the database
					BiosDaoImpl bios_dao = new BiosDaoImpl();
					bios_dao.insertBioses(new_bios_list);
				}
				
				
				
				
/*----------------------commodity--------------------------*/
				//get the sheet
				Sheet commodity_sheet = wb.getSheet("Commodity");
				/*
				 * locate_xxx:find and locate the row with ID equal to 0,because this value represents the location of the new data
				 * default value:10000. it is means no new data
				 * */
				int locate_commodity = 10000;
				//number of the last row 
				int commodity_rows = commodity_sheet.getLastRowNum();
				
				
				//find out the location of new data
				for(int index=1;index<=commodity_rows;index++) {
					Row row = commodity_sheet.getRow(index);
					Cell iDcell = row.getCell(0);
					int idValue = (int) iDcell.getNumericCellValue();
					if(idValue==0) {
						locate_commodity = index;
						break;
					}
				}		
				System.out.println("commodity new data location: "+locate_commodity);
				
				if(locate_commodity!=10000) {
					//Encapsulate the new data into the list
					List<Commodity> new_commodity_list = new ArrayList<Commodity>();
					
					for(int i=locate_commodity;i<=commodity_rows;i++) {
						Row locateRow = commodity_sheet.getRow(i);
						String  owner = locateRow.getCell(1).getStringCellValue();
						String  chassis = locateRow.getCell(2).getStringCellValue();
						String  platform = locateRow.getCell(3).getStringCellValue();
						
						
						String  type = locateRow.getCell(4).getStringCellValue();
						String  name = locateRow.getCell(5).getStringCellValue();
						String  pn_sn = locateRow.getCell(6).getStringCellValue();
						
						
						
						String  start = locateRow.getCell(7).getStringCellValue();
						String  end = locateRow.getCell(8).getStringCellValue();
						Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(start);
						Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end);
						String  bios_version = locateRow.getCell(9).getStringCellValue();
						String  image_build_id = locateRow.getCell(10).getStringCellValue();
						String  test_plan = locateRow.getCell(11).getStringCellValue();
						String  tester = locateRow.getCell(12).getStringCellValue();
						
						new_commodity_list.add(new Commodity(owner,chassis,platform,type,name,pn_sn,startDate,endDate,bios_version,image_build_id,test_plan,tester));
					}
					
//					System.out.println(newDataList);
					
					//Insert the data into the database
					CommodityDaoImpl commodity_dao = new CommodityDaoImpl();
					commodity_dao.insertCommodities(new_commodity_list);
					
				}
				
				
				
				
/*----------------------Softpaq--------------------------*/
				//get the sheet
				Sheet softpaq_sheet = wb.getSheet("Softpaq");
				/*
				 * locate_xxx:find and locate the row with ID equal to 0,because this value represents the location of the new data
				 * default value:10000. it is means no new data
				 * */
				int locate_softpaq = 10000;
				//number of the last row 
				int softpaq_rows = softpaq_sheet.getLastRowNum();
				
				
				//find out the location of new data
				for(int index=1;index<=softpaq_rows;index++) {
					Row row = softpaq_sheet.getRow(index);
					Cell iDcell = row.getCell(0);
					int idValue = (int) iDcell.getNumericCellValue();
					if(idValue==0) {
						locate_softpaq = index;
						break;
					}
				}		
				System.out.println("softpaq new data location: "+locate_softpaq);
				
				if(locate_softpaq!=10000) {
					//Encapsulate the new data into the list
					List<Softpaq> new_softpaq_list = new ArrayList<Softpaq>();
					
					for(int i=locate_softpaq;i<=softpaq_rows;i++) {
						Row locateRow = softpaq_sheet.getRow(i);
						String  owner = locateRow.getCell(1).getStringCellValue();
						String  chassis = locateRow.getCell(2).getStringCellValue();
						String  platform = locateRow.getCell(3).getStringCellValue();
						
						
						String  sp_number = locateRow.getCell(4).getStringCellValue();
						String  softpaq_title = locateRow.getCell(5).getStringCellValue();
						String  version = locateRow.getCell(6).getStringCellValue();
						
						
						
						String  start = locateRow.getCell(7).getStringCellValue();
						String  end = locateRow.getCell(8).getStringCellValue();
						Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(start);
						Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end);
						String  bios_version = locateRow.getCell(9).getStringCellValue();
						String  image_build_id = locateRow.getCell(10).getStringCellValue();
						String  test_plan = locateRow.getCell(11).getStringCellValue();
						String  tester = locateRow.getCell(12).getStringCellValue();
						
						new_softpaq_list.add(new Softpaq(owner,chassis,platform,sp_number,softpaq_title,version,startDate,endDate,bios_version,image_build_id,test_plan,tester));
					}
					
//					System.out.println(newDataList);
					
					//Insert the data into the database
					SoftpaqDaoImpl softpaq_dao = new SoftpaqDaoImpl();
					softpaq_dao.insertMultiple(new_softpaq_list);
				}
				
				
				
/*----------------------Wat--------------------------*/
				//get the sheet
				Sheet wat_sheet = wb.getSheet("Wat");
				/*
				 * locate_xxx:find and locate the row with ID equal to 0,because this value represents the location of the new data
				 * default value:10000. it is means no new data
				 * */
				int locate_wat = 10000;
				//number of the last row 
				int wat_rows = wat_sheet.getLastRowNum();
				
				
				//find out the location of new data
				for(int index=1;index<=wat_rows;index++) {
					Row row = wat_sheet.getRow(index);
					Cell iDcell = row.getCell(0);
					int idValue = (int) iDcell.getNumericCellValue();
					if(idValue==0) {
						locate_wat = index;
						break;
					}
				}		
				System.out.println("Wat new data location: "+locate_wat);
				
				if(locate_wat!=10000) {
					//Encapsulate the new data into the list
					List<Wat> new_wat_list = new ArrayList<Wat>();
					
					for(int i=locate_wat;i<=wat_rows;i++) {
						Row locateRow = wat_sheet.getRow(i);
						String  owner = locateRow.getCell(1).getStringCellValue();
						String  chassis = locateRow.getCell(2).getStringCellValue();
						String  platform = locateRow.getCell(3).getStringCellValue();
						
						
						String  device_name = locateRow.getCell(4).getStringCellValue();
						String  pn_sn = locateRow.getCell(5).getStringCellValue();
						
						
						String  start = locateRow.getCell(6).getStringCellValue();
						String  end = locateRow.getCell(7).getStringCellValue();
						Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(start);
						Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end);
						String  bios_version = locateRow.getCell(8).getStringCellValue();
						String  image_build_id = locateRow.getCell(9).getStringCellValue();
						String  test_plan = locateRow.getCell(10).getStringCellValue();
						String  tester = locateRow.getCell(11).getStringCellValue();
						
						new_wat_list.add(new Wat(owner,chassis,platform,device_name,pn_sn,startDate,endDate,bios_version,image_build_id,test_plan,tester));
					}
					
					System.out.println(new_wat_list);
					
					//Insert the data into the database
					WatDaoImpl wat_dao = new WatDaoImpl();
					wat_dao.insertMultiple(new_wat_list);
				}
				
				
				
				
				
/*----------------------Image Softroll&Respin--------------------------*/
				//get the sheet
				Sheet isr_sheet = wb.getSheet("ImageSoftrollRespinSheet");
				/*
				 * locate_xxx:find and locate the row with ID equal to 0,because this value represents the location of the new data
				 * default value:10000. it is means no new data
				 * */
				int locate_isr = 10000;
				//number of the last row 
				int isr_rows = isr_sheet.getLastRowNum();
				
				
				//find out the location of new data
				for(int index=1;index<=isr_rows;index++) {
					Row row = isr_sheet.getRow(index);
					Cell iDcell = row.getCell(0);
					int idValue = (int) iDcell.getNumericCellValue();
					if(idValue==0) {
						locate_isr = index;
						break;
					}
				}		
				System.out.println("isr new data location: "+locate_isr);
				
				
				if(locate_isr!=10000) {
					//Encapsulate the new data into the list
					List<SoftrollRespin> new_isr_list = new ArrayList<SoftrollRespin>();
					
					for(int i=locate_isr;i<=isr_rows;i++) {
						Row locateRow = isr_sheet.getRow(i);
						String  owner = locateRow.getCell(1).getStringCellValue();
						String  chassis = locateRow.getCell(2).getStringCellValue();
						String  platform = locateRow.getCell(3).getStringCellValue();
						
						
						String  test_function = locateRow.getCell(4).getStringCellValue();
						
						
						
						String  start = locateRow.getCell(5).getStringCellValue();
						String  end = locateRow.getCell(6).getStringCellValue();
						Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(start);
						Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end);
						String  bios_version = locateRow.getCell(7).getStringCellValue();
						String  image_build_id = locateRow.getCell(8).getStringCellValue();
						String  test_plan = locateRow.getCell(9).getStringCellValue();
						String  tester = locateRow.getCell(10).getStringCellValue();
						
						new_isr_list.add(new SoftrollRespin(owner,chassis,platform,test_function,startDate,endDate,bios_version,image_build_id,test_plan,tester));
					}
					
//					System.out.println(new_isr_list);
					
					//Insert the data into the database
					SoftrollRespinDaoImpl isr_dao = new SoftrollRespinDaoImpl();
					isr_dao.insertMultiple(new_isr_list);
				}
				
					inp.close();			        
			        wb.close();
		
	}
	
}
