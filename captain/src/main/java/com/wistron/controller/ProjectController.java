package com.wistron.controller;

import com.wistron.pojo.Project;
import com.wistron.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/chassis")
    public String findChassises(){
        List<Project> list =  projectService.findChassises();
        System.out.println(list);
        System.out.println("integrete success");
        return "/WEB-INF/view/index.jsp";
    }
}
