package com.wistron.service.impl;

import com.wistron.dao.BiosDao;
import com.wistron.pojo.Bios;
import com.wistron.pojo.vo.Limit;
import com.wistron.service.BiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("biosService")
@Transactional(rollbackFor = Exception.class)
public class BiosServiceImpl implements BiosService {

    @Autowired
    private BiosDao dao;

    @Override
    public int insertBioses(List<Bios> list) {
        int i = dao.insertBioses(list);
        return i;
    }

    @Override
    public List<Bios> findAll() {
        List<Bios> list = dao.findAll();
        return list;
    }

    @Override
    public int edit(Bios bios) {
        int i = dao.edit(bios);
        return i;
    }

    @Override
    public List<Bios> limitFindAll(Limit limit) {
        List<Bios> list = dao.limitFindAll(limit);
        return list;
    }

    @Override
    public int count() {
        int count = dao.count();
        return count;
    }
}
