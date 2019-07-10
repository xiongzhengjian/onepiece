package com.wistron.service.impl;

import com.wistron.dao.ProjectDao;
import com.wistron.pojo.Project;
import com.wistron.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public List<Project> findChassises() {
        List<Project> list =  projectDao.findChassises();
        return list;
    }

    @Override
    public List<Project> findPlatform(String chassis) {
        List<Project> list =  projectDao.findPlatform(chassis);
        return list;
    }
}
