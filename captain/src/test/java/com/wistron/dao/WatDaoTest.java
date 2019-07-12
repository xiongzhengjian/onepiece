package com.wistron.dao;

import com.wistron.pojo.Wat;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class WatDaoTest extends BaseTest {

    @Autowired
    private WatDao dao;

    @Test
    public void insertMultiple() {
        List<Wat> list = new ArrayList<Wat>();
        Wat data1 = new Wat("Tester1_Java","Nessler","Sunflower","Headset 4002","94256-5151",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
        Wat data2 = new Wat("Tester2_Java","NesslerPxx","Sunflower","Headset 4002","94256-5151",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
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