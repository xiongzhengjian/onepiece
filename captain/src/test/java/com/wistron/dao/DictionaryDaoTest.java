package com.wistron.dao;

import com.wistron.pojo.Dictionary;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class DictionaryDaoTest extends BaseTest{

    @Autowired
    private DictionaryDao dao;

    @Test
    public void findById() {
        Dictionary dictionary = dao.findById(2);
        System.out.println(dictionary);
    }

    @Test
    public void insert() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findAll() {
    }
}