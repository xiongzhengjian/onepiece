package com.wistron.dao;

import com.wistron.pojo.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ExcelRecordDaoTest extends BaseTest {

    @Autowired
    private ExcelRecordDao dao;

    @Test
    public void findAllBios() {
        List<Bios> allBios = dao.findAllBios();
        for (Bios bios : allBios) {
            System.out.println(bios);
        }
    }

    @Test
    public void findAllCommodity() {
        List<Commodity> commodities = dao.findAllCommodity();
        for (Commodity commodity : commodities) {
            System.out.println(commodity);
        }
    }

    @Test
    public void findAllSoftpaq() {
        List<Softpaq> softpaqs = dao.findAllSoftpaq();
        for (Softpaq softpaq : softpaqs) {
            System.out.println(softpaq);
        }
    }

    @Test
    public void findAllSoftpaq2() {
        List<Softpaq2> softpaq2s = dao.findAllSoftpaq2();
        for (Softpaq2 softpaq2 : softpaq2s) {
            System.out.println(softpaq2);
        }
    }

    @Test
    public void findAllWat() {
        List<Wat> wats = dao.findAllWat();
        for (Wat wat : wats) {
            System.out.println(wat);
        }
    }

    @Test
    public void findAllSoftrollrespin() {
        List<SoftrollRespin> softrollRespins = dao.findAllSoftrollrespin();
        for (SoftrollRespin softrollRespin : softrollRespins) {
            System.out.println(softrollRespin);
        }
    }

    @Test
    public void insertBioses() {
        Bios bios = new Bios("Bear","Nelson","Kensington","Weekly Test",new Date(),new Date(), "B.24","18WW2SVT6AF#SABA","CDT-BIOS-Checklist_v4.6_pre-test","LittleBear");
        List<Bios> list = new ArrayList<Bios>();
        list.add(bios);
        dao.insertBioses(list);
    }

    @Test
    public void insertCommodities() {
    }

    @Test
    public void insertSoftpaq() {
    }

    @Test
    public void insertSoftpaq2() {
    }

    @Test
    public void insertWat() {
    }

    @Test
    public void insertIsr() {
    }
}