package com.wistron.dao;

import com.wistron.pojo.Commodity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CommodityDaoTest extends BaseTest {

    @Autowired
    private CommodityDao dao;

    @Test
    public void insertCommodities() {
        List<Commodity> commodities = new ArrayList<Commodity>();
        //"Sunny2","NesslerP","Sunflower","HDD","SEAGATE 1T","924121-001","2019-06-08 14:25:30","2019-06-11 14:25:30","F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear"
        Commodity c1 = new Commodity("Sunny2","NesslerPxx","Sunflower","HDD","SEAGATE 1T","924121-001",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
        Commodity c2 = new Commodity("Sunny2","NesslerPxx","Sunflower","HDD","SEAGATE 1T","924121-001",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
        commodities.add(c1);
        commodities.add(c2);
        dao.insertCommodities(commodities);
    }

    @Test
    public void findAllCommodity() {
    }

    @Test
    public void updateCommodity() {
    }

    @Test
    public void limitFindAll() {
    }

    @Test
    public void count() {
    }
}