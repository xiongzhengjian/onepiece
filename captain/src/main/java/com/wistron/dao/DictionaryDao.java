package com.wistron.dao;

import com.wistron.pojo.Dictionary;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DictionaryDao {

    @Select("select * from dictionary where dictionary_id = #{id} ")
    public Dictionary findById(Integer id);

    @Insert("insert into dictionary (dictionary_id,message,code) values (#{dictionary_id},#{message},#{code})")
    public int insert(Dictionary dic);

    @Update("update dictionary set message = #{message}, code = #{code} where dictionary_id=#{dictionary_id}")
    public int update(Dictionary dic);

    @Delete("delete from dictionary where dictionary_id = #{dictionary_id}")
    public int delete(int id);

    @Select("select * from dictionary")
    public List<Dictionary> findAll();

}
