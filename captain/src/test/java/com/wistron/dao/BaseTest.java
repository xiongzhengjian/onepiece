package com.wistron.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//Configure spring to integrate with Junit so that Junit loads the Spring container at startup
@RunWith(SpringJUnit4ClassRunner.class)
//Tell Junit spring's configuration file
@ContextConfiguration({"classpath:applicationContext.xml"})
public class BaseTest {}
