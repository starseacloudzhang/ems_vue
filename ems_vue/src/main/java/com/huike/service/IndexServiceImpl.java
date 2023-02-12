package com.huike.service;


import com.huike.dao.IndexDAO;

import com.huike.entity.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IndexServiceImpl implements IndexService{

    @Autowired
    private IndexDAO indexDAO;

    @Override
    public void update(Index index) {
        indexDAO.update(index);
    }

    @Override
    public void delete(String id) {
        indexDAO.delete(id);
    }

    @Override
    public void save(Index index) {
        indexDAO.save(index);
    }

    @Override
    public Index findOne(String id) {
        return indexDAO.findOne(id);

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Index> findAll() {
        return indexDAO.findAll();
    }

    @Override
    public List<Index> findTv() {
        return indexDAO.findTv();
    }

    @Override
    public List<Index> findWatch() {
        return indexDAO.findWatch();
    }
}
