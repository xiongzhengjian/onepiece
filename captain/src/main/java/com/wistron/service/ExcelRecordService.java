package com.wistron.service;


import javax.servlet.ServletOutputStream;
import java.io.InputStream;


public interface ExcelRecordService {


    void exportAllRecord(ServletOutputStream out) throws Exception;

    void importAllRecord(InputStream inputStream) throws Exception;
}
