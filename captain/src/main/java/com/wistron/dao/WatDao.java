package com.wistron.dao;

import com.wistron.pojo.Wat;
import com.wistron.pojo.vo.Limit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface WatDao {

    @Insert("insert into wat (wat_id,owner,chassis,platform,device_name,PN_SN,start,end,bios_version,image_build_id,test_plan,tester) " +
                "values" +
            "(#{dao.wat_id},#{dao.owner},#{dao.chassis},#{dao.platform},#{dao.device_name},#{dao.pn_sn},#{dao.start},#{dao.end},#{dao.bios_version},#{dao.image_build_id},#{dao.test_plan},#{dao.tester})")
    public int insertMultiple(List<Wat> list);

    @Select("select * from wat  order by wat_id desc")
    public List<Wat> findAll();

    @Update("update wat set " +
            "owner=#{owner},chassis=#{chassis},platform=#{platform}, device_name=#{device_name},pn_sn=#{pn_sn},start=#{start},end=#{end},bios_version=#{bios_version},image_build_id=#{image_build_id},test_plan=#{test_plan},tester=#{tester} " +
            "where wat_id=#{wat_id}")
    public int update(Wat wat);

    @Select("select * from wat order by wat_id desc limit #{offset},#{rows}")
    public List<Wat> limitFindAll(Limit limit);

    @Select("select count(wat_id) as totalrows from wat")
    public int count();



}
