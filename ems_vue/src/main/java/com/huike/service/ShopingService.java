package com.huike.service;

import com.huike.entity.Shoping;

import java.util.List;

public interface ShopingService {
    List<Shoping> findAll();
    void save(Shoping shoping);

    void delete(String id);

    Shoping findOne(String id);

    void update(Shoping shoping);
}
