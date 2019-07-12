package com.wistron.dao;

import com.wistron.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExcelRecordDao {

    @Select("select bios_id,owner,chassis,platform,test_type,start,end,bios_version,image_build_id,test_plan,tester from bios")
    public List<Bios> findAllBios();

    @Select("select * from  commodity")
    public List<Commodity> findAllCommodity();

    @Select("select * from softpaq")
    public List<Softpaq> findAllSoftpaq();

    @Select("select * from softpaq2")
    public List<Softpaq2> findAllSoftpaq2();

    @Select("select * from wat")
    public List<Wat> findAllWat();

    @Select("select * from softrollrespin")
    public List<SoftrollRespin> findAllSoftrollrespin();

    @Insert({"<script>" +
            "insert into bios " +
            "(bios_id,owner,chassis,platform,test_type,start,end,bios_version,image_build_id,test_plan,tester)" +
            "values" +
            "<foreach collection='list' item='bios' index='index' separator=','>" +
                "(#{bios.bios_id},#{bios.owner},#{bios.chassis},#{bios.platform},#{bios.test_type},#{bios.start},#{bios.end},#{bios.bios_version},#{bios.image_build_id},#{bios.test_plan},#{bios.tester})" +
            "</foreach>" +
            "</script>"})
    @Options(useGeneratedKeys=true, keyProperty="bios_id", keyColumn="bios_id")
    public int insertBioses(List<Bios> list);



    @Insert({"<script>" +
                "insert into commodity " +
                "(commodity_id,owner,chassis,platform,type,name,pn_sn,start,end,bios_version,image_build_id,test_plan,tester)" +
                    "values" +
                "<foreach collection='list' item='commodity' index='index' separator=','>" +
                    "(#{commodity.commodity_id},#{commodity.owner},#{commodity.chassis},#{commodity.platform},#{commodity.type},#{commodity.name},#{commodity.pn_sn},#{commodity.start},#{commodity.end},#{commodity.bios_version},#{commodity.image_build_id},#{commodity.test_plan},#{commodity.tester})"+
                "</foreach>" +
            "</script>"})
    @Options(useGeneratedKeys=true, keyProperty="commodity_id", keyColumn="commodity_id")
    public int insertCommodities(List<Commodity> commodity);



    @Insert({"<script>" +
            "insert into softpaq (softpaq_id,owner,chassis,platform,sp_number,softpaq_title,version,start,end,bios_version,image_build_id,test_plan,tester)" +
                "values" +
            "<foreach collection='list' item='softpaq' index='index' separator=','>" +
                "(#{softpaq.softpaq_id},#{softpaq.owner},#{softpaq.chassis},#{softpaq.platform},#{softpaq.sp_number},#{softpaq.softpaq_title},#{softpaq.version},#{softpaq.start},#{softpaq.end},#{softpaq.bios_version},#{softpaq.image_build_id},#{softpaq.test_plan},#{softpaq.tester})" +
            "</foreach>" +
            "</script>"})
    @Options(useGeneratedKeys=true)
    public int insertSoftpaq(List<Softpaq> softpaq);


    @Insert({"<script>" +
                "insert into softpaq2 (softpaq_id,owner,start,end,sp_number,softpaq_title,version,platform,sptest_tool_status,installation_status,function_status,products_sequence,mark)" +
                    "values" +
                "<foreach collection='list' item='softpaq' index='index' separator=','>" +
                    "(#{softpaq.softpaq_id},#{softpaq.owner},#{softpaq.start},#{softpaq.end},#{softpaq.sp_number},#{softpaq.softpaq_title},#{softpaq.version},#{softpaq.platform},#{softpaq.sptest_tool_status},#{softpaq.installation_status},#{softpaq.function_status},#{softpaq.products_sequence},#{softpaq.mark})" +
                "</foreach>" +
            "</script>"})
    @Options(useGeneratedKeys=true)
    public int insertSoftpaq2(List<Softpaq2> softpaq);


    @Insert({"<script>" +
            "insert into wat (wat_id,owner,chassis,platform,device_name,PN_SN,start,end,bios_version,image_build_id,test_plan,tester)" +
            "values" +
            "<foreach collection='list' item='dao' index='index' separator=','>" +
                "(#{dao.wat_id},#{dao.owner},#{dao.chassis},#{dao.platform},#{dao.device_name},#{dao.pn_sn},#{dao.start},#{dao.end},#{dao.bios_version},#{dao.image_build_id},#{dao.test_plan},#{dao.tester})" +
            "</foreach>" +
        "</script>"})
    @Options(useGeneratedKeys=true)
    public int insertWat(List<Wat> list);


    @Insert({"<script>" +
        "insert into softrollrespin (softrollrespin_id,owner,chassis,platform,test_function,start,end,bios_version,image_build_id,test_plan,tester)" +
        "values" +
        "<foreach collection='list' item='dao' index='index' separator=','>" +
             "(#{dao.softrollrespin_id},#{dao.owner},#{dao.chassis},#{dao.platform},#{dao.test_function},#{dao.start},#{dao.end},#{dao.bios_version},#{dao.image_build_id},#{dao.test_plan},#{dao.tester})" +
        "</foreach>" +
        "</script>"})
    @Options(useGeneratedKeys=true)
    public int insertIsr(List<SoftrollRespin> list);
}
