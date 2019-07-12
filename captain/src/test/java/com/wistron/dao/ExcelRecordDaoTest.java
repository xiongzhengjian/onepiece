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
        List<Commodity> commodities = new ArrayList<Commodity>();
        //"Sunny2","NesslerP","Sunflower","HDD","SEAGATE 1T","924121-001","2019-06-08 14:25:30","2019-06-11 14:25:30","F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear"
        Commodity c1 = new Commodity("Sunny2","NesslerPxx","Sunflower","HDD","SEAGATE 1T","924121-001",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
        Commodity c2 = new Commodity("Sunny2","NesslerPxx","Sunflower","HDD","SEAGATE 1T","924121-001",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
        commodities.add(c1);
        commodities.add(c2);
        dao.insertCommodities(commodities);
    }

    @Test
    public void insertSoftpaq() {

        List<Softpaq> list = new ArrayList<Softpaq>();
        Softpaq s1 = new Softpaq("Tester1","NesslerPxx","Sunflower","SP96602","NVIDIA GeForce Driver for VR1","26.21.14.3039-B-1",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
        Softpaq s2 = new Softpaq("Tester2","NesslerPxx","Sunflower","SP96603","NVIDIA GeForce Driver for VR1","26.21.14.3039-B-1",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
        list.add(s1);
        list.add(s2);
        dao.insertSoftpaq(list);

    }

    @Test
    public void insertSoftpaq2() {
        List<Softpaq2> list = new ArrayList<Softpaq2>();
        Softpaq2 s1 = new Softpaq2("Elva",new Date(),new Date(),"SP960669","Intel Management Engine Interface (MEI) Driver","1904.12.0.1208 - A - 16","Dyson - HP ENVY 795-0xxx Desktop","PASS","PASS","PASS",1,"Only test in CFL project(Luton not support)");
        Softpaq2 s2 = new Softpaq2("Elva",new Date(),new Date(),"SP960669","Intel Management Engine Interface (MEI) Driver","1904.12.0.1208 - A - 16","DysonP - HP Pavilion Gaming 790-0xxx Desktop","PASS","PASS","PASS",2,"Only test in CFL project(Luton not support)");
        list.add(s1);
        list.add(s2);
        dao.insertSoftpaq2(list);
    }

    @Test
    public void insertWat() {
        List<Wat> list = new ArrayList<Wat>();
        Wat data1 = new Wat("Tester1_Java","Nessler","Sunflower","Headset 4002","94256-5151",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
        Wat data2 = new Wat("Tester2_Java","NesslerPxx","Sunflower","Headset 4002","94256-5151",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
        list.add(data1);
        list.add(data2);
        dao.insertWat(list);
    }

    @Test
    public void insertIsr() {
        List<SoftrollRespin> list = new ArrayList<SoftrollRespin>();
        SoftrollRespin data1 = new SoftrollRespin("Tester1_Java","Nessler","Sunflower","FIT",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
        SoftrollRespin data2 = new SoftrollRespin("Tester1_Java","Nessler","Sunflower","WAT",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
        list.add(data1);
        list.add(data2);
        dao.insertIsr(list);
    }
}