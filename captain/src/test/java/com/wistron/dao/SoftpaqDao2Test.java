package com.wistron.dao;

import com.wistron.pojo.Softpaq2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class SoftpaqDao2Test extends BaseTest {

    @Autowired
    private SoftpaqDao2 dao;

    @Test
    public void insertMultiple() {
        List<Softpaq2> list = new ArrayList<Softpaq2>();
        Softpaq2 s1 = new Softpaq2("Elva",new Date(),new Date(),"SP960669","Intel Management Engine Interface (MEI) Driver","1904.12.0.1208 - A - 16","Dyson - HP ENVY 795-0xxx Desktop","PASS","PASS","PASS",1,"Only test in CFL project(Luton not support)");
        Softpaq2 s2 = new Softpaq2("Elva",new Date(),new Date(),"SP960669","Intel Management Engine Interface (MEI) Driver","1904.12.0.1208 - A - 16","DysonP - HP Pavilion Gaming 790-0xxx Desktop","PASS","PASS","PASS",2,"Only test in CFL project(Luton not support)");
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

    @Test
    public void limitFindAll() {
    }

    @Test
    public void count() {
    }
}