package com.wistron.dao;

import com.wistron.pojo.SoftrollRespin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class SoftrollRespinDaoTest extends BaseTest {

    @Autowired
    private SoftrollRespinDao dao;

    @Test
    public void insertMultiple() {
        List<SoftrollRespin> list = new ArrayList<SoftrollRespin>();
        SoftrollRespin data1 = new SoftrollRespin("Tester1_Java","Nessler","Sunflower","FIT",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
        SoftrollRespin data2 = new SoftrollRespin("Tester1_Java","Nessler","Sunflower","WAT",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
        list.add(data1);
        list.add(data2);
        dao.insertMultiple(list);
    }

    @Test
    public void findAll() {
    }

    @Test
    public void update() {
    }

    @Test
    public void limitFindAll() {
    }

    @Test
    public void count() {
    }
}