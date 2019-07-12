package com.wistron.service;

import com.wistron.pojo.Wat;
import com.wistron.pojo.vo.Limit;

import java.util.List;

public interface WatService {

    public int insertMultiple(List<Wat> list);

    public List<Wat> findAll();


    public int update(Wat wat);

    public List<Wat> limitFindAll(Limit limit);

    public int count();
}
