package com.wistron.service;

import com.wistron.pojo.*;

import java.util.List;


public interface ExcelRecordService {

    public List<Bios> findAllBios();

    public List<Commodity> findAllCommodity();

    public List<Softpaq> findAllSoftpaq();

    public List<Softpaq2> findAllSoftpaq2();

    public List<Wat> findAllWat();

    public List<SoftrollRespin> findAllSoftrollrespin();


    public int insertBioses(List<Bios> list);




    public int insertCommodities(List<Commodity> commodity);




    public int insertSoftpaq(List<Softpaq> softpaq);



    public int insertSoftpaq2(List<Softpaq2> softpaq);



    public int insertWat(List<Wat> list);



    public int insertIsr(List<SoftrollRespin> list);
}
