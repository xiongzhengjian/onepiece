package com.wistron.dao;

import com.wistron.pojo.SoftrollRespin;
import com.wistron.pojo.vo.Limit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SoftrollRespinDao {

    @Insert({"<script>" +
            "insert into softrollrespin (softrollrespin_id,owner,chassis,platform,test_function,start,end,bios_version,image_build_id,test_plan,tester)" +
            "values" +
            "<foreach collection='list' item='dao' index='index' separator=','>" +
            "(#{dao.softrollrespin_id},#{dao.owner},#{dao.chassis},#{dao.platform},#{dao.test_function},#{dao.start},#{dao.end},#{dao.bios_version},#{dao.image_build_id},#{dao.test_plan},#{dao.tester})" +
            "</foreach>" +
            "</script>"})
    @Options(useGeneratedKeys=true)
    public int insertMultiple(List<SoftrollRespin> list);




    @Select("select * from softrollrespin  order by softrollrespin_id desc")
    public List<SoftrollRespin> findAll();

    @Update("update softrollrespin set " +
            "owner=#{owner}, chassis=#{chassis},platform=#{platform},test_function=#{test_function},  start=#{start},end=#{end},bios_version=#{bios_version}, image_build_id=#{image_build_id},test_plan=#{test_plan}, tester=#{tester} " +
                "where" +
            "softrollrespin_id=#{softrollrespin_id}")
    public int update(SoftrollRespin dao);


    @Select("select * from softrollrespin order by softrollrespin_id desc limit #{offset},#{rows}")
    public List<SoftrollRespin> limitFindAll(Limit limit);

    @Select("select count(softrollrespin_id) as totalrows from softrollrespin")
    public int count();



}
