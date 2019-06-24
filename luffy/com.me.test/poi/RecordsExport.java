package poi;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import com.wistron.dao.BiosDaoImpl;
import com.wistron.pojo.Bios;
import com.wistron.pojo.vo.BiosVo;

public class RecordsExport {
	
	private BiosDaoImpl biosDao;
	private List<Bios> origindata;
	List<BiosVo> data;
	//private String[] titles = {"BIOS ID","Owner","Chassis","Platform","Test Type","Start","End","BIOS Version","Image Build Id","Test Plan","Tester"};
	private String[] titles = {"BIOS ID","Chassis","Platform","Test Type","Schedule","BIOS Version","Image Build Id","Test Plan","Tester"};
	
	@Before
	public void initFactory() throws Exception {		
		biosDao = new BiosDaoImpl();
		origindata = biosDao.findAll();
		data = new ArrayList<BiosVo>();
		int size = origindata.size();
		for(int i=0;i<size;i++) {
			Bios bios = origindata.get(i);
			//Set the value of Schedule based on the Start date and End date
			Date start = bios.getStart();
			Date end = bios.getEnd();
			String strStart = new SimpleDateFormat("yyyy/MM/dd").format(start);
			String strEnd = new SimpleDateFormat("yyyy/MM/dd").format(end);
			String schedule = strStart + " - " + strEnd;
			BiosVo biosVo = new BiosVo(bios.getBios_id(),bios.getChassis(),bios.getPlatform(),bios.getTest_type(),schedule,bios.getBios_version(),bios.getImage_build_id(),bios.getTest_plan(),bios.getTester());
			data.add(biosVo);
		}
		
	}	
	
	@Test
	public void biosExport() throws Exception{
		//High level representation of a Excel workbook. 
		//This is the first object most users will construct whether they are reading or writing a workbook. 
		//It is also the top level object for creating new sheets/etc.
		Workbook wb = new XSSFWorkbook();
		Map<String, CellStyle> styles = createStyles(wb);
		
		
		Sheet sheet = wb.createSheet("Bios");
		//turn off gridlines
		sheet.setDisplayGridlines(false);
		sheet.setPrintGridlines(false);
		sheet.setFitToPage(true);
		sheet.setHorizontallyCenter(true);
		PrintSetup printSetup = sheet.getPrintSetup();
		printSetup.setLandscape(true);
		
		
		//the header row: centered text in 48pt font
        Row headerRow = sheet.createRow(0);
        headerRow.setHeightInPoints(12.75f);
        for (int i = 0; i < titles.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(styles.get("header"));
        }
		
        //freeze the first row
        sheet.createFreezePane(0, 1);
        
        int rownum = 1;
        for (int i = 0; i < data.size(); i++, rownum++) {
        	Row row = sheet.createRow(rownum);
        	BiosVo biosvo = data.get(i);
        	//"BIOS ID","Chassis","Platform","Test Type","Schedule","BIOS Version","Image Build Id","Test Plan","Tester"
        	Cell cellId = row.createCell(0);
        	cellId.setCellValue(biosvo.getBios_id());
        	
        	Cell cellChassis = row.createCell(1);
        	cellChassis.setCellValue(biosvo.getChassis());
        	
        	Cell cellPlatform = row.createCell(2);
        	cellPlatform.setCellValue(biosvo.getPlatform());
        	
        	Cell cellTestType = row.createCell(3);
        	cellTestType.setCellValue(biosvo.getTest_type());
        	
        	Cell cellSchedule = row.createCell(4);
        	cellSchedule.setCellValue(biosvo.getSchedule());
        	
        	Cell cellBIOSVersion = row.createCell(5);
        	cellBIOSVersion.setCellValue(biosvo.getBios_version());
        	
        	Cell cellImageBuildId = row.createCell(6);
        	cellImageBuildId.setCellValue(biosvo.getImage_build_id());
        	
        	Cell cellTestPlan = row.createCell(7);
        	cellTestPlan.setCellValue(biosvo.getTest_plan());
        	
        	Cell cellTester = row.createCell(8);
        	cellTester.setCellValue(biosvo.getTester());
        	
        }
        //set column widths, the width is measured in units of 1/256th of a character width
        sheet.setColumnWidth(0, 256*6);
        sheet.setColumnWidth(1, 256*20);
        sheet.setColumnWidth(2, 256*20);
        sheet.setColumnWidth(3, 256*30);
        sheet.setColumnWidth(4, 256*40);
        sheet.setColumnWidth(5, 256*20);
        sheet.setColumnWidth(6, 256*30);
        sheet.setColumnWidth(7, 256*40);
        sheet.setColumnWidth(8, 256*20);
        sheet.setZoom(75); //75% scale
        
        // Write the output to a file
        String file = "bios.xlsx";
        FileOutputStream out = new FileOutputStream(file);
        wb.write(out);
        out.close();
        
        wb.close();
		
		System.out.println(data);
	}
	
	
	
	
	private  Map<String, CellStyle> createStyles(Workbook wb){
		//define a collection of styles
		Map<String, CellStyle> styles = new HashMap<>();
		DataFormat df = wb.createDataFormat();
		
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
	
	
	private static CellStyle createBorderedStyle(Workbook wb,CellStyle style){
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
	
	private String getSchedule(Bios bios) {
		//Set the value of Schedule based on the Start date and End date
		Date start = bios.getStart();
		Date end = bios.getEnd();
		String strStart = new SimpleDateFormat("yyyy/MM/dd").format(start);
		String strEnd = new SimpleDateFormat("yyyy/MM/dd").format(end);
		String schedule = strStart + " - " + strEnd;
		return schedule;
	}
}