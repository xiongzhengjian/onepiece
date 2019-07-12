package com.wistron.service;

import com.wistron.pojo.Commodity;
import com.wistron.pojo.vo.Limit;

import java.util.List;

public interface CommodityService {

    public int insertCommodities(List<Commodity> commodity);


    public List<Commodity> findAllCommodity();



    public int updateCommodity(Commodity commodity);

    public List<Commodity> limitFindAll(Limit limit);

    public int count();
}
