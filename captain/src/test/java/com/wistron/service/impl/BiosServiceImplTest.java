package com.wistron.service.impl;

import com.wistron.dao.BaseTest;
import com.wistron.pojo.Bios;
import com.wistron.service.BiosService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

public class BiosServiceImplTest extends BaseTest {

    @Autowired
    private BiosService service;

    @Test
    public void insertBioses() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void edit() {
        Bios bios = new Bios(1,"Nicolas","LincsB","Bios pre-test",new Date(),new Date(),
                "F.10","serverTest","CDT","Bear4");
        int edit = service.edit(bios);
    }

    @Test
    public void limitFindAll() {
    }

    @Test
    public void count() {
    }
}