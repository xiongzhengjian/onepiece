package com.wistron.dao;

import com.wistron.pojo.Softpaq2;
import com.wistron.pojo.vo.Limit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SoftpaqDao2 {

    @Insert({"<script>" +
            "insert into softpaq2 (softpaq_id,owner,start,end,sp_number,softpaq_title,version,platform,sptest_tool_status,installation_status,function_status,products_sequence,mark)" +
            "values" +
            "<foreach collection='list' item='softpaq' index='index' separator=','>" +
            "(#{softpaq.softpaq_id},#{softpaq.owner},#{softpaq.start},#{softpaq.end},#{softpaq.sp_number},#{softpaq.softpaq_title},#{softpaq.version},#{softpaq.platform},#{softpaq.sptest_tool_status},#{softpaq.installation_status},#{softpaq.function_status},#{softpaq.products_sequence},#{softpaq.mark})" +
            "</foreach>" +
            "</script>"})
    @Options(useGeneratedKeys=true)
    public int insertMultiple(List<Softpaq2> softpaq);


//    @Insert({"<script>" +
//            "insert into softpaq2 (softpaq_id,owner,start,end,sp_number,softpaq_title,version,platform,sptest_tool_status,installation_status,function_status,products_sequence,mark)" +
//            "values" +
//            "<foreach collection='list' item='softpaq' index='index' separator=','>" +
//            "(#{softpaq.softpaq_id},#{softpaq.owner},#{softpaq.start},#{softpaq.end},#{softpaq.sp_number},#{softpaq.softpaq_title},#{softpaq.version},#{softpaq.platform},#{softpaq.sptest_tool_status},#{softpaq.installation_status},#{softpaq.function_status},#{softpaq.products_sequence},#{softpaq.mark})" +
//            "</foreach>" +
//            "</script>"})
//    @Options(useGeneratedKeys=true)
//    public int insertSoftpaq2(List<Softpaq2> softpaq);


    @Select("select * from softpaq2 order by softpaq_id desc")
    public List<Softpaq2> findAll();

    @Update("update softpaq2 set owner=#{owner},start=#{start},end=#{end},sp_number=#{sp_number},softpaq_title=#{softpaq_title},version=#{version},platform=#{platform},sptest_tool_status=#{sptest_tool_status},installation_status=#{installation_status},function_status=#{function_status},products_sequence=#{products_sequence},mark=#{mark}" +
            "where" +
            "softpaq_id=#{softpaq_id}")
    public int update(Softpaq2 softpaq);

    @Select("select * from softpaq2  order by softpaq_id desc limit #{offset},#{rows}")
    public List<Softpaq2> limitFindAll(Limit limit);

    @Select("select count(softpaq_id) as totalrows from softpaq2")
    public int count();


}
