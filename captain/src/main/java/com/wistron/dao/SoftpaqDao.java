package com.wistron.dao;

import com.wistron.pojo.Softpaq;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SoftpaqDao {

    @Select("insert into softpaq  (softpaq_id,owner,chassis,platform,sp_number,softpaq_title,version,start,end,bios_version,image_build_id,test_plan,tester)" +
            "values" +
            "(#{softpaq.softpaq_id},#{softpaq.owner},#{softpaq.chassis},#{softpaq.platform},#{softpaq.sp_number},#{softpaq.softpaq_title},#{softpaq.version},#{softpaq.start},#{softpaq.end},#{softpaq.bios_version},#{softpaq.image_build_id},#{softpaq.test_plan},#{softpaq.tester})")
    public int insertMultiple(List<Softpaq> softpaq);


    @Select("select * from softpaq order by softpaq_id desc")
    public List<Softpaq> findAll();

    @Update("update softpaq set owner=#{owner},chassis=#{chassis},platform=#{platform},sp_number=#{sp_number},softpaq_title=#{softpaq_title},version=#{version},start=#{start},end=#{end},bios_version=#{bios_version},image_build_id=#{image_build_id},test_plan=#{test_plan},tester=#{tester}" +
            "where" +
            "softpaq_id=#{softpaq_id}")
    public int update(Softpaq softpaq);


}
