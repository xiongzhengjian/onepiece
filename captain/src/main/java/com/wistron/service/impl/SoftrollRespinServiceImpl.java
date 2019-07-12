package com.wistron.service.impl;

import com.wistron.dao.SoftrollRespinDao;
import com.wistron.pojo.SoftrollRespin;
import com.wistron.pojo.vo.Limit;
import com.wistron.service.SoftrollRespinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("softrollRespinService")
@Transactional
public class SoftrollRespinServiceImpl implements SoftrollRespinService {

    @Autowired
    private SoftrollRespinDao dao;


    @Override
    public int insertMultiple(List<SoftrollRespin> list) {
        int i = dao.insertMultiple(list);
        return i;
    }

    @Override
    public List<SoftrollRespin> findAll() {
        List<SoftrollRespin> list = dao.findAll();
        return list;

    }

    @Override
    public int update(SoftrollRespin softrollRespin) {
        int i = dao.update(softrollRespin);
        return i;
    }

    @Override
    public List<SoftrollRespin> limitFindAll(Limit limit) {
        List<SoftrollRespin> list = dao.limitFindAll(limit);
        return list;

    }

    @Override
    public int count() {
        int count = dao.count();
        return count;
    }
}
