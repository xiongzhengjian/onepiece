package com.wistron.service.impl;

import com.wistron.service.ExcelRecordService;
import com.wistron.utils.RecordExport;
import com.wistron.utils.RecordImport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import java.io.InputStream;

@Service("excelRecordService")
@Transactional(rollbackFor = Exception.class)
public class ExcelRecordServiceImpl implements ExcelRecordService {

    @Resource
    private RecordExport export;

    @Resource
    private RecordImport recordImport;

    @Override
    public void exportAllRecord(ServletOutputStream out) throws Exception {
        export.exportAllRecord(out);

    }

    @Override
    public void importAllRecord(InputStream inputStream) throws Exception {
        recordImport.importAllRecord(inputStream);
    }
}
