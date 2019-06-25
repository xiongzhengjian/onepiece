package com.wistron.controller;


import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wistron.utils.RecordExport;
import com.wistron.utils.RecordImport;

@Controller
public class ExcelRecordController {
	
	@RequestMapping("/record/export")
	public void exportExcel(HttpSession session,HttpServletResponse response) throws Exception{
	    response.setContentType("application/binary;charset=UTF-8");
	    ServletOutputStream out=response.getOutputStream();
	    String datetime = new SimpleDateFormat("yyMMddHHmm").format(new Date());
	    response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("records_"+datetime+".xlsx", "UTF-8"));
	    RecordExport export = new RecordExport();
	    export.exportAllRecord(out);
		
	}

	@RequestMapping("/record/import")
	public String importExcel(HttpServletRequest request) throws Exception {
		String category = request.getParameter("category");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;   
		MultipartFile file = multipartRequest.getFile("upfile"); 
		
		InputStream inputStream = file.getInputStream();
		RecordImport importExcel = new RecordImport();
		importExcel.importAllRecord(inputStream);
		
		switch(category) {
			case "bios":
				return "redirect:./projectrecord.action";
				
			case "commodity":
				return "redirect:./commodity.action";
				
			case "softpaq":
				return "redirect:./softpaq.action";
				
			case "wat":
				return "redirect:./wat.action";
				
			case "isr":
				return "redirect:./softrollrespin.action";
				
			default:
				return "redirect:./projectrecord.action";
		}
		
		
		
	}

	
	

}
