package com.wistron.controller;


import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wistron.utils.RecordExport;

@Controller
public class ExportRecordController {
	
	@RequestMapping("/record/export")
	public void export(HttpSession session,HttpServletResponse response) throws Exception{
	    response.setContentType("application/binary;charset=UTF-8");
	    ServletOutputStream out=response.getOutputStream();
	    String datetime = new SimpleDateFormat("yyMMddHHmm").format(new Date());
	    response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("records_"+datetime+".xlsx", "UTF-8"));
	    RecordExport export = new RecordExport();
	    export.exportAllRecord(out);
		
	}

	@RequestMapping("/record/import")
	public void importExcel() {
		
		System.out.println("import");
		
	}

	
	

}
