package com.huike.service;

import com.huike.dao.EmpDAO;
import com.huike.dao.ShopingDAO;
import com.huike.entity.Emp;
import com.huike.entity.Shoping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShopingServiceImpl implements ShopingService {

    @Autowired
    private ShopingDAO shopingDAO;

    @Override
    public Shoping findOne(String id) {
        return shopingDAO.findOne(id);

    }

    @Override
    public void update(Shoping shoping) {
        shopingDAO.update(shoping);
    }

    @Override
    public void delete(String id) {
        shopingDAO.delete(id);
    }

    @Override
    public void save(Shoping shoping) {
        shopingDAO.save(shoping);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Shoping> findAll() {
        return shopingDAO.findAll();
    }
}
