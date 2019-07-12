package com.wistron.service.impl;

import com.wistron.dao.SoftpaqDao2;
import com.wistron.pojo.Softpaq2;
import com.wistron.pojo.vo.Limit;
import com.wistron.service.SoftpaqService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("softpaqService2")
@Transactional
public class SoftpaqService2Impl implements SoftpaqService2 {

    @Autowired
    private SoftpaqDao2 dao;

    @Override
    public int insertMultiple(List<Softpaq2> softpaq) {
        int i = dao.insertMultiple(softpaq);
        return i;
    }

    @Override
    public List<Softpaq2> findAll() {
        List<Softpaq2> list = dao.findAll();
        return list;
    }

    @Override
    public int update(Softpaq2 softpaq) {
        int i = dao.update(softpaq);
        return i;
    }

    @Override
    public List<Softpaq2> limitFindAll(Limit limit) {
        List<Softpaq2> list = dao.limitFindAll(limit);
        return list;
    }

    @Override
    public int count() {
        int count = dao.count();
        return count;
    }
}
