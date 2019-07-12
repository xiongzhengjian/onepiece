package com.wistron.service;

import com.wistron.pojo.Softpaq2;
import com.wistron.pojo.vo.Limit;

import java.util.List;

public interface SoftpaqService2 {

    public int insertMultiple(List<Softpaq2> softpaq);

    public List<Softpaq2> findAll();


    public int update(Softpaq2 softpaq);

    public List<Softpaq2> limitFindAll(Limit limit);

    public int count();
}
