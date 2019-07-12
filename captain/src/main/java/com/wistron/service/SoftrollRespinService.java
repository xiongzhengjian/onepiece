package com.wistron.service;

import com.wistron.pojo.SoftrollRespin;
import com.wistron.pojo.vo.Limit;

import java.util.List;

public interface SoftrollRespinService {

    public int insertMultiple(List<SoftrollRespin> list);


    public List<SoftrollRespin> findAll();


    public int update(SoftrollRespin dao);


    public List<SoftrollRespin> limitFindAll(Limit limit);

    public int count();
}
