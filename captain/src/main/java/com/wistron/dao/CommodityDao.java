package com.wistron.dao;

import com.wistron.pojo.Commodity;
import com.wistron.pojo.vo.Limit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CommodityDao {



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


    @Select("select * from  commodity order by commodity_id desc")
    public List<Commodity> findAllCommodity();


    @Update("update commodity set " +
            "owner=#{owner},chassis=#{chassis},platform=#{platform},type=#{type},name=#{name}, pn_sn=#{pn_sn},start=#{start},end=#{end},bios_version=#{bios_version},image_build_id=#{image_build_id}, test_plan=#{test_plan},tester=#{tester} " +
            "where " +
            "commodity_id=#{commodity_id}")
    public int updateCommodity(Commodity commodity);

    @Select("select * from commodity order by commodity_id desc limit #{offset},#{rows}")
    public List<Commodity> limitFindAll(Limit limit);

    @Select("select count(commodity_id) as totalrows from commodity")
    public int count();


}
