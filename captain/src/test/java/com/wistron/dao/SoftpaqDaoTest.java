package com.wistron.dao;

import com.wistron.pojo.Softpaq;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class SoftpaqDaoTest extends BaseTest {

    @Autowired
    private SoftpaqDao dao;

    @Test
    public void insertMultiple() {
        List<Softpaq> list = new ArrayList<Softpaq>();
        Softpaq s1 = new Softpaq("Tester1","NesslerPxx","Sunflower","SP96602","NVIDIA GeForce Driver for VR1","26.21.14.3039-B-1",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
        Softpaq s2 = new Softpaq("Tester2","NesslerPxx","Sunflower","SP96603","NVIDIA GeForce Driver for VR1","26.21.14.3039-B-1",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
        list.add(s1);
        list.add(s2);
        dao.insertMultiple(list);
    }

    @Test
    public void findAll() {
    }

    @Test
    public void update() {
    }
}