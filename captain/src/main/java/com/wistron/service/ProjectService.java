package com.wistron.service;

import com.wistron.pojo.Project;

import java.util.List;


public interface ProjectService {

    public List<Project> findChassises();
    public List<Project> findPlatform(String chassis);
}
