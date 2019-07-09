package com.wistron.dao;


import com.wistron.pojo.Project;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProjectDao {

    @Select("select distinct chassis from project")
    public List<Project> findChassises();
    public List<Project> findPlatform(String chassis);

}
