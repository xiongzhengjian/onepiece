package com.wistron.dao;

import com.wistron.pojo.Bios;
import com.wistron.pojo.vo.Limit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BiosDao {



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


    @Select("select bios_id,owner,chassis,platform,test_type,start,end,bios_version,image_build_id,test_plan,tester from bios order by bios_id desc")
    public List<Bios> findAll();

    @Update("update bios set owner=#{owner},chassis=#{chassis},platform=#{platform},test_type=#{test_type},start=#{start},end=#{end},bios_version=#{bios_version},image_build_id=#{image_build_id},test_plan=#{test_plan},tester=#{tester}" +
            "where bios_id=#{bios_id}")
    public int edit(Bios bios);

    @Select("select * from bios  order by bios_id desc limit #{offset},#{rows}")
    public List<Bios> limitFindAll(Limit limit);

    @Select("select count(bios_id) as totalrows from bios")
    public int count();
}
