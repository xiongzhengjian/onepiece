package com.wistron.service;

import com.wistron.pojo.Bios;
import com.wistron.pojo.vo.Limit;

import java.util.List;

public interface BiosService {

    public int insertBioses(List<Bios> list);


    public List<Bios> findAll();


    public int edit(Bios bios);

    public List<Bios> limitFindAll(Limit limit);

    public int count();
}
