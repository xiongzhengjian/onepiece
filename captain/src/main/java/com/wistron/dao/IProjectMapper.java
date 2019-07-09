package com.wistron.dao;

import org.apache.tools.ant.Project;

import java.util.List;

public interface IProjectMapper {

    public List<Project> findChassises();
    public List<Project> findPlatform(String chassis);

}
