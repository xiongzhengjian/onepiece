package com.wistron.service.impl;

import com.wistron.dao.ExcelRecordDao;
import com.wistron.pojo.*;
import com.wistron.service.ExcelRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("excelRecordService")
@Transactional(rollbackFor = Exception.class)
public class ExcelRecordServiceImpl implements ExcelRecordService {

    @Autowired
    private ExcelRecordDao dao;


    @Override
    public List<Bios> findAllBios() {
        List<Bios> list = dao.findAllBios();
        return list;
    }

    @Override
    public List<Commodity> findAllCommodity() {
        List<Commodity> list = dao.findAllCommodity();
        return list;
    }

    @Override
    public List<Softpaq> findAllSoftpaq() {
        List<Softpaq> list = dao.findAllSoftpaq();
        return list;
    }

    @Override
    public List<Softpaq2> findAllSoftpaq2() {
        List<Softpaq2> list = dao.findAllSoftpaq2();
        return list;
    }

    @Override
    public List<Wat> findAllWat() {
        List<Wat> list = dao.findAllWat();
        return list;
    }

    @Override
    public List<SoftrollRespin> findAllSoftrollrespin() {
        List<SoftrollRespin> list = dao.findAllSoftrollrespin();
        return list;
    }

    @Override
    public int insertBioses(List<Bios> list) {
        int i = dao.insertBioses(list);
        return i;
    }

    @Override
    public int insertCommodities(List<Commodity> commodity) {
        int i = dao.insertCommodities(commodity);
        return i;
    }

    @Override
    public int insertSoftpaq(List<Softpaq> softpaq) {
        int i = dao.insertSoftpaq(softpaq);
        return i;
    }

    @Override
    public int insertSoftpaq2(List<Softpaq2> softpaq) {
        int i = dao.insertSoftpaq2(softpaq);
        return i;
    }

    @Override
    public int insertWat(List<Wat> list) {
        int i = dao.insertWat(list);
        return i;
    }

    @Override
    public int insertIsr(List<SoftrollRespin> list) {
        int i = dao.insertIsr(list);
        return i;
    }
}
