package com.wistron.utils;

import com.wistron.dao.ExcelRecordDao;
import com.wistron.pojo.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("com.wistron.utils.RecordExport")
public class RecordExport {
	
	@Autowired
	private ExcelRecordDao excelRecordDao;
	
	
	
	
	public void exportAllRecord(ServletOutputStream out) throws Exception {
//	    ExcelRecordDaoImpl  daoImple = new ExcelRecordDaoImpl();
		List<Bios> biosdata = excelRecordDao.findAllBios();
		//create a workbook
		Workbook wb = new XSSFWorkbook();
		//create style of the workbook 
		Map<String, CellStyle> styles = createStyles(wb);
		
/*================== 1.bios ===================  */
		Sheet biosSheet = wb.createSheet("Bios");
		biosSheet.setDisplayGridlines(true);
		biosSheet.setPrintGridlines(false);
		biosSheet.setFitToPage(true);
		biosSheet.setHorizontallyCenter(true);
		PrintSetup printSetup1 = biosSheet.getPrintSetup();
		printSetup1.setLandscape(true);
		//define the header
	    String[] biosHeader = {"BIOS ID","Owner","Chassis","Platform","Test Type","Start","End","BIOS Version","Image Build Id","Test Plan","Tester"};
	   
	    
	    //create header row
	    //the header row: centered text in 48pt font
        Row biosHeaderRow = biosSheet.createRow(0);
        biosHeaderRow.setHeightInPoints(12.75f);
        int biosheaderlength = biosHeader.length;
		for (int i = 0; i < biosheaderlength; i++) {
            Cell cell = biosHeaderRow.createCell(i);
            cell.setCellValue(biosHeader[i]);
            cell.setCellStyle(styles.get("header"));
        }
        //freeze the first row
        biosSheet.createFreezePane(0, 1);
        
        int rownum = 1;
        int biosdatasize=biosdata.size();
        for (int i = 0; i < biosdatasize; i++, rownum++) {
        	Row row = biosSheet.createRow(rownum);
        	Bios bios = biosdata.get(i);
        	//"BIOS ID","Owner","Chassis","Platform","Test Type","Schedule","BIOS Version","Image Build Id","Test Plan","Tester"
        	Cell cellId = row.createCell(0);
        	cellId.setCellValue(bios.getBios_id());
        	
        	Cell cellOwner = row.createCell(1);
        	cellOwner.setCellValue(bios.getOwner());
        	
        	Cell cellChassis = row.createCell(2);
        	cellChassis.setCellValue(bios.getChassis());
        	
        	Cell cellPlatform = row.createCell(3);
        	cellPlatform.setCellValue(bios.getPlatform());
        	
        	Cell cellTestType = row.createCell(4);
        	cellTestType.setCellValue(bios.getTest_type());
        	
        	Cell cellStart = row.createCell(5);
        	cellStart.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(bios.getStart()));
        	
        	Cell cellEnd = row.createCell(6);
        	cellEnd.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(bios.getEnd()));
        	
        	Cell cellBIOSVersion = row.createCell(7);
        	cellBIOSVersion.setCellValue(bios.getBios_version());
        	
        	Cell cellImageBuildId = row.createCell(8);
        	cellImageBuildId.setCellValue(bios.getImage_build_id());
        	
        	Cell cellTestPlan = row.createCell(9);
        	cellTestPlan.setCellValue(bios.getTest_plan());
        	
        	Cell cellTester = row.createCell(10);
        	cellTester.setCellValue(bios.getTester());
        	
        }
        //set column widths, the width is measured in units of 1/256th of a character width
        biosSheet.setColumnWidth(0, 256*6);
        biosSheet.setColumnWidth(1, 256*20);
        biosSheet.setColumnWidth(2, 256*20);
        biosSheet.setColumnWidth(3, 256*30);
        biosSheet.setColumnWidth(4, 256*30);
        biosSheet.setColumnWidth(5, 256*30);
        biosSheet.setColumnWidth(6, 256*20);
        biosSheet.setColumnWidth(7, 256*30);
        biosSheet.setColumnWidth(8, 256*40);
        biosSheet.setColumnWidth(9, 256*20);
        biosSheet.setColumnWidth(10, 256*20);
        biosSheet.setZoom(75); //75% scale
//		System.out.println(biosdata);
	    
	    
	    
	    
	    
		
/*================== 2.commodity ===================  */
		Sheet commoditySheet = wb.createSheet("Commodity");				
		commoditySheet.setDisplayGridlines(true);
		commoditySheet.setPrintGridlines(false);
		commoditySheet.setFitToPage(true);
		commoditySheet.setHorizontallyCenter(true);
		PrintSetup printSetup2 = commoditySheet.getPrintSetup();
		printSetup2.setLandscape(true);
		//define the header
	    String[] commodityHeader = {"Commodity ID","Owner","Chassis","Platform","Type","Name","Pn/Sn","Start","End","BIOS Version","Image Build Id","Test Plan","Tester"};
		/**
		 * commodity_id,owner,chassis,platform,type,name,pn_sn,start,end,bios_version,image_build_id,test_plan,tester
		 */
	    
	    //create header row
        Row commodityHeaderRow = commoditySheet.createRow(0);
        commodityHeaderRow.setHeightInPoints(12.75f);
        int commodityHeaderLength = commodityHeader.length;
        for (int i = 0; i < commodityHeaderLength; i++) {
            Cell cell = commodityHeaderRow.createCell(i);
            cell.setCellValue(commodityHeader[i]);
            cell.setCellStyle(styles.get("header"));
        }
        commoditySheet.createFreezePane(0, 1);
        
        
        //get data from database
		List<Commodity> commoditydata = excelRecordDao.findAllCommodity();
        
        int commodityrownum = 1;
        int commoditydatasize=commoditydata.size();
        for (int i = 0; i < commoditydatasize; i++, commodityrownum++) {
        	Row row = commoditySheet.createRow(commodityrownum);
        	Commodity commodity = commoditydata.get(i);
        	Cell cellId = row.createCell(0);
        	cellId.setCellValue(commodity.getCommodity_id());
        	
        	Cell cellOwner = row.createCell(1);
        	cellOwner.setCellValue(commodity.getOwner());
        	
        	Cell cellChassis = row.createCell(2);
        	cellChassis.setCellValue(commodity.getChassis());
        	
        	Cell cellPlatform = row.createCell(3);
        	cellPlatform.setCellValue(commodity.getPlatform());
        	
        	
        	
        	//--------
        	Cell cellType = row.createCell(4);
        	cellType.setCellValue(commodity.getType());
        	
        	Cell cellName = row.createCell(5);
        	cellName.setCellValue(commodity.getName());
        	
        	Cell cellPnSn = row.createCell(6);
        	cellPnSn.setCellValue(commodity.getPn_sn());
        	
        	//--------
        	
        	
        	
        	
        	Cell cellStart = row.createCell(7);
        	cellStart.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(commodity.getStart()));
        	
        	Cell cellEnd = row.createCell(8);
        	cellEnd.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(commodity.getEnd()));
        	
        	Cell cellBIOSVersion = row.createCell(9);
        	cellBIOSVersion.setCellValue(commodity.getBios_version());
        	
        	Cell cellImageBuildId = row.createCell(10);
        	cellImageBuildId.setCellValue(commodity.getImage_build_id());
        	
        	Cell cellTestPlan = row.createCell(11);
        	cellTestPlan.setCellValue(commodity.getTest_plan());
        	
        	Cell cellTester = row.createCell(12);
        	cellTester.setCellValue(commodity.getTester());
        	
        }
        //set column widths, the width is measured in units of 1/256th of a character width
        commoditySheet.setColumnWidth(0, 256*6);
        commoditySheet.setColumnWidth(1, 256*20);
        commoditySheet.setColumnWidth(2, 256*20);
        commoditySheet.setColumnWidth(3, 256*30);
        commoditySheet.setColumnWidth(4, 256*30);
        commoditySheet.setColumnWidth(5, 256*30);
        commoditySheet.setColumnWidth(6, 256*20);
        commoditySheet.setColumnWidth(7, 256*30);
        commoditySheet.setColumnWidth(8, 256*40);
        commoditySheet.setColumnWidth(9, 256*20);
        commoditySheet.setColumnWidth(10, 256*20);
        commoditySheet.setColumnWidth(11, 256*20);
        commoditySheet.setColumnWidth(12, 256*20);
        commoditySheet.setZoom(75); //75% scale
//		System.out.println(commoditydata);
	    
	    
/*================== 3.Softpaq2 ===================  */
		Sheet softpaqSheet = wb.createSheet("Softpaq");
		softpaqSheet.setDisplayGridlines(true);
		softpaqSheet.setPrintGridlines(false);
		softpaqSheet.setFitToPage(true);
		softpaqSheet.setHorizontallyCenter(true);
		PrintSetup printSetup3 = softpaqSheet.getPrintSetup();
		printSetup3.setLandscape(true);
		String[] softpaqHeader = {"Softpaq ID","Owner","Start","End","SP Number","Softpaq Title","Version","Platform","SPTest tool","Installation","Function","Products Sequence","Mark"};
		/**
		 * softpaq_id,owner,chassis,platform,   sp_number,softpaq_title,version,   start,end,bios_version,image_build_id,test_plan,tester
		 */
		 //create header row
        Row softpaqHeaderRow = softpaqSheet.createRow(0);
        softpaqHeaderRow.setHeightInPoints(12.75f);
        int softpaqHeaderLength = softpaqHeader.length;
        for (int i = 0; i < softpaqHeaderLength; i++) {
            Cell cell = softpaqHeaderRow.createCell(i);
            cell.setCellValue(softpaqHeader[i]);
            cell.setCellStyle(styles.get("header"));
        }
        softpaqSheet.createFreezePane(0, 1);
        
        
        
      //get data from database
		List<Softpaq2> softpaqdata = excelRecordDao.findAllSoftpaq2();
        
        int softpaqrownum = 1;
        int softpaqdatasize=softpaqdata.size();
        for (int i = 0; i < softpaqdatasize; i++, softpaqrownum++) {
        	Row row = softpaqSheet.createRow(softpaqrownum);
        	Softpaq2 softpaq = softpaqdata.get(i);
        	Cell cellId = row.createCell(0);
        	cellId.setCellValue(softpaq.getSoftpaq_id());
        	
        	Cell cellOwner = row.createCell(1);
        	cellOwner.setCellValue(softpaq.getOwner());
        	
        	Cell cellStart = row.createCell(2);
        	cellStart.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(softpaq.getStart()));
        	
        	Cell cellEnd = row.createCell(3);
        	cellEnd.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(softpaq.getEnd()));
        	
        	Cell cell_sp_number = row.createCell(4);
        	cell_sp_number.setCellValue(softpaq.getSp_number());
        	
        	Cell cell_softpaq_title = row.createCell(5);
        	cell_softpaq_title.setCellValue(softpaq.getSoftpaq_title());
        	
        	Cell cell_Version = row.createCell(6);
        	cell_Version.setCellValue(softpaq.getVersion());
        	
        	Cell cellPlatform = row.createCell(7);
        	cellPlatform.setCellValue(softpaq.getPlatform());
        	
        	
        	Cell cell_sptest_tool_status = row.createCell(8);
        	cell_sptest_tool_status.setCellValue(softpaq.getSptest_tool_status());
        	
        	Cell cell_installation_status = row.createCell(9);
        	cell_installation_status.setCellValue(softpaq.getInstallation_status());
        	
        	Cell cell_function_status = row.createCell(10);
        	cell_function_status.setCellValue(softpaq.getFunction_status());
        	
        	Cell cell_Products_sequence = row.createCell(11);
        	cell_Products_sequence.setCellValue(softpaq.getProducts_sequence());
        	
        	Cell cell_Mark = row.createCell(12);
        	cell_Mark.setCellValue(softpaq.getMark());
        }
        //set column widths, the width is measured in units of 1/256th of a character width
        softpaqSheet.setColumnWidth(0, 256*6);
        softpaqSheet.setColumnWidth(1, 256*20);
        softpaqSheet.setColumnWidth(2, 256*20);
        softpaqSheet.setColumnWidth(3, 256*30);
        softpaqSheet.setColumnWidth(4, 256*30);
        softpaqSheet.setColumnWidth(5, 256*30);
        softpaqSheet.setColumnWidth(6, 256*20);
        softpaqSheet.setColumnWidth(7, 256*30);
        softpaqSheet.setColumnWidth(8, 256*40);
        softpaqSheet.setColumnWidth(9, 256*20);
        softpaqSheet.setColumnWidth(10, 256*20);
        softpaqSheet.setColumnWidth(11, 256*20);
        softpaqSheet.setColumnWidth(12, 256*20);
        softpaqSheet.setZoom(75); //75% scale
//		System.out.println(softpaqdata);
	    
		
/*================== 4.Wat ===================  */
		Sheet watSheet = wb.createSheet("Wat");
		watSheet.setDisplayGridlines(true);
		watSheet.setPrintGridlines(false);
		watSheet.setFitToPage(true);
		watSheet.setHorizontallyCenter(true);
		PrintSetup printSetup4 = watSheet.getPrintSetup();
		printSetup4.setLandscape(true);
		String[] watHeader = {"Wat ID","Owner","Chassis","Platform",  "Device Name","PN/SN",  "Start","End","BIOS Version","Image Build Id","Test Plan","Tester"};
		/**
		 * wat_id,owner,chassis,platform,   device_name,pn_sn,   start,end,bios_version,image_build_id,test_plan,tester
		 */
		 //create header row
        Row watHeaderRow = watSheet.createRow(0);
        watHeaderRow.setHeightInPoints(12.75f);
        int watHeaderLength = watHeader.length;
        for (int i = 0; i < watHeaderLength; i++) {
            Cell cell = watHeaderRow.createCell(i);
            cell.setCellValue(watHeader[i]);
            cell.setCellStyle(styles.get("header"));
        }
        watSheet.createFreezePane(0, 1);
        
      //get data from database
		List<Wat> watdata = excelRecordDao.findAllWat();
        
        int watrownum = 1;
        int watdatasize=watdata.size();
        for (int i = 0; i < watdatasize; i++, watrownum++) {
        	Row row = watSheet.createRow(watrownum);
        	Wat wat = watdata.get(i);
        	Cell cellId = row.createCell(0);
        	cellId.setCellValue(wat.getWat_id());
        	
        	Cell cellOwner = row.createCell(1);
        	cellOwner.setCellValue(wat.getOwner());
        	
        	Cell cellChassis = row.createCell(2);
        	cellChassis.setCellValue(wat.getChassis());
        	
        	Cell cellPlatform = row.createCell(3);
        	cellPlatform.setCellValue(wat.getPlatform());
        	
        	
        	
        	//--------
        	Cell cell_device_name = row.createCell(4);
        	cell_device_name.setCellValue(wat.getDevice_name());
        	
        	Cell cell_pn_sn = row.createCell(5);
        	cell_pn_sn.setCellValue(wat.getPn_sn());
        	
        	//--------
        	
        	
        	
        	
        	Cell cellStart = row.createCell(6);
        	cellStart.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(wat.getStart()));
        	
        	Cell cellEnd = row.createCell(7);
        	cellEnd.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(wat.getEnd()));
        	
        	Cell cellBIOSVersion = row.createCell(8);
        	cellBIOSVersion.setCellValue(wat.getBios_version());
        	
        	Cell cellImageBuildId = row.createCell(9);
        	cellImageBuildId.setCellValue(wat.getImage_build_id());
        	
        	Cell cellTestPlan = row.createCell(10);
        	cellTestPlan.setCellValue(wat.getTest_plan());
        	
        	Cell cellTester = row.createCell(11);
        	cellTester.setCellValue(wat.getTester());
        	
        }
        //set column widths, the width is measured in units of 1/256th of a character width
        watSheet.setColumnWidth(0, 256*6);
        watSheet.setColumnWidth(1, 256*20);
        watSheet.setColumnWidth(2, 256*20);
        watSheet.setColumnWidth(3, 256*30);
        watSheet.setColumnWidth(4, 256*30);
        watSheet.setColumnWidth(5, 256*30);
        watSheet.setColumnWidth(6, 256*20);
        watSheet.setColumnWidth(7, 256*30);
        watSheet.setColumnWidth(8, 256*40);
        watSheet.setColumnWidth(9, 256*20);
        watSheet.setColumnWidth(10, 256*20);
        watSheet.setColumnWidth(11, 256*20);
        watSheet.setZoom(75); //75% scale
//		System.out.println(watdata);
		
		
/*================== 5.image softroll&respin ===================  */
		Sheet imageSoftrollRespinSheet = wb.createSheet("ImageSoftrollRespinSheet");
		imageSoftrollRespinSheet.setDisplayGridlines(true);
		imageSoftrollRespinSheet.setPrintGridlines(false);
		imageSoftrollRespinSheet.setFitToPage(true);
		imageSoftrollRespinSheet.setHorizontallyCenter(true);
		PrintSetup printSetup5 = imageSoftrollRespinSheet.getPrintSetup();
		printSetup5.setLandscape(true);
		String[] imageSoftrollRespinHeader = {"Softrollrespin ID","Owner","Chassis","Platform","Test Function","Start","End","BIOS Version","Image Build Id","Test Plan","Tester"};
		/**
		 * softrollrespin_id,owner,chassis,platform,   test_function,   start,end,bios_version,image_build_id,test_plan,tester
		 */
		 //create header row
        Row imageSoftrollRespinHeaderRow = imageSoftrollRespinSheet.createRow(0);
        imageSoftrollRespinHeaderRow.setHeightInPoints(12.75f);
        
        int imageLength = imageSoftrollRespinHeader.length;
        for (int i = 0; i < imageLength; i++) {
            Cell cell = imageSoftrollRespinHeaderRow.createCell(i);
            cell.setCellValue(imageSoftrollRespinHeader[i]);
            cell.setCellStyle(styles.get("header"));
        }
        imageSoftrollRespinSheet.createFreezePane(0, 1);
		
        
        //get data from database
		List<SoftrollRespin> softrollrespindata = excelRecordDao.findAllSoftrollrespin();
        
       
        int size5=softrollrespindata.size();
        for (int i = 0; i < size5; i++) {
        	//i+1:The data starts in the second row
        	Row row = imageSoftrollRespinSheet.createRow(i+1);
        	SoftrollRespin sr = softrollrespindata.get(i);
        	Cell cellId = row.createCell(0);
        	cellId.setCellValue(sr.getSoftrollrespin_id());
        	
        	Cell cellOwner = row.createCell(1);
        	cellOwner.setCellValue(sr.getOwner());
        	
        	Cell cellChassis = row.createCell(2);
        	cellChassis.setCellValue(sr.getChassis());
        	
        	Cell cellPlatform = row.createCell(3);
        	cellPlatform.setCellValue(sr.getPlatform());
        	
        	
        	
        	//--------
        	Cell cell_test_function = row.createCell(4);
        	cell_test_function.setCellValue(sr.getTest_function());
        	
        	
        	//--------
        	
        	
        	
        	
        	Cell cellStart = row.createCell(5);
        	cellStart.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(sr.getStart()));
        	
        	Cell cellEnd = row.createCell(6);
        	cellEnd.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(sr.getEnd()));
        	
        	Cell cellBIOSVersion = row.createCell(7);
        	cellBIOSVersion.setCellValue(sr.getBios_version());
        	
        	Cell cellImageBuildId = row.createCell(8);
        	cellImageBuildId.setCellValue(sr.getImage_build_id());
        	
        	Cell cellTestPlan = row.createCell(9);
        	cellTestPlan.setCellValue(sr.getTest_plan());
        	
        	Cell cellTester = row.createCell(10);
        	cellTester.setCellValue(sr.getTester());
        	
        }
        //set column widths, the width is measured in units of 1/256th of a character width
        imageSoftrollRespinSheet.setColumnWidth(0, 256*6);
        imageSoftrollRespinSheet.setColumnWidth(1, 256*20);
        imageSoftrollRespinSheet.setColumnWidth(2, 256*20);
        imageSoftrollRespinSheet.setColumnWidth(3, 256*30);
        imageSoftrollRespinSheet.setColumnWidth(4, 256*30);
        imageSoftrollRespinSheet.setColumnWidth(5, 256*30);
        imageSoftrollRespinSheet.setColumnWidth(6, 256*20);
        imageSoftrollRespinSheet.setColumnWidth(7, 256*30);
        imageSoftrollRespinSheet.setColumnWidth(8, 256*40);
        imageSoftrollRespinSheet.setColumnWidth(9, 256*20);
        imageSoftrollRespinSheet.setColumnWidth(10, 256*20);
        imageSoftrollRespinSheet.setZoom(75); //75% scale
//		System.out.println(softrollrespindata);
        
        
        
/* =============== Write the output to a file======================== */
//        String file = "record2.xlsx";
//        FileOutputStream out = new FileOutputStream(file);
        out.flush();
        wb.write(out);
        out.close();        
        wb.close();
		
		
	}
	
	
	
	
	private  Map<String, CellStyle> createStyles(Workbook wb){
		//define a collection of styles
		Map<String, CellStyle> styles = new HashMap<>();
		//DataFormat df = wb.createDataFormat();
		
		//CellStyle style;
		
		
		
		/* ------ set the header style ------- */
		//0.create cell style
		CellStyle style = wb.createCellStyle();
		//1.font
		Font headerFont = wb.createFont();
		headerFont.setBold(true);		
		//2.border
		style = createBorderedStyle(wb,style);
		//3.set the type of horizontal alignment for the cell
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setFont(headerFont);
		styles.put("header", style);
		
		return styles;
	}
	
	
	private  CellStyle createBorderedStyle(Workbook wb,CellStyle style){
		//The enumeration value indicating the line style of a border in a cell
        BorderStyle thin = BorderStyle.THIN;
        //IndexedColors:A deprecated indexing scheme for colours that is still required for some records, and for backwards compatibility with OLE2 formats. 
        short black = IndexedColors.BLACK.getIndex();
        
        //CellStyle style = wb.createCellStyle();
        
        //set border  width
        style.setBorderRight(thin);
        style.setBorderLeft(thin);
        style.setBorderTop(thin);
        style.setBorderBottom(thin); 
        
        //set border color
        style.setRightBorderColor(black);
        style.setBottomBorderColor(black);
        style.setLeftBorderColor(black);
        style.setTopBorderColor(black);
        return style;
    }
	
	
}
