package com.wistron.service.impl;

import com.wistron.dao.CommodityDao;
import com.wistron.pojo.Commodity;
import com.wistron.pojo.vo.Limit;
import com.wistron.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("commodityService")
@Transactional(rollbackFor = Exception.class)
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao dao;

    @Override
    public int insertCommodities(List<Commodity> commodity) {
        int i = dao.insertCommodities(commodity);
        return i;
    }

    @Override
    public List<Commodity> findAllCommodity() {
        List<Commodity> list = dao.findAllCommodity();
        return list;
    }

    @Override
    public int updateCommodity(Commodity commodity) {
        int i = dao.updateCommodity(commodity);
        return i;
    }

    @Override
    public List<Commodity> limitFindAll(Limit limit) {
        List<Commodity> list = dao.limitFindAll(limit);
        return list;
    }

    @Override
    public int count() {
        int count = dao.count();
        return count;
    }
}
