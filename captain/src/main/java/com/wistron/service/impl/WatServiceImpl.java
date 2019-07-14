package com.wistron.service.impl;

import com.wistron.dao.WatDao;
import com.wistron.pojo.Wat;
import com.wistron.pojo.vo.Limit;
import com.wistron.service.WatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("watService")
@Transactional(rollbackFor = Exception.class)
public class WatServiceImpl implements WatService {
    @Autowired
    private WatDao dao;

    @Override
    public int insertMultiple(List<Wat> list) {
        int i = dao.insertMultiple(list);
        return i;
    }

    @Override
    public List<Wat> findAll() {
        List<Wat> list = dao.findAll();
        return list;
    }

    @Override
    public int update(Wat wat) {
        int i = dao.update(wat);
        return i;
    }

    @Override
    public List<Wat> limitFindAll(Limit limit) {
        List<Wat> list = dao.limitFindAll(limit);
        return list;
    }

    @Override
    public int count() {
        int count = dao.count();
        return count;
    }
}
