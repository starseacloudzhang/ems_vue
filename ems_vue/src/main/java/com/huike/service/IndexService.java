package com.huike.service;

import com.huike.entity.Index;

import java.util.List;

public interface IndexService {

    List<Index> findAll();

    List<Index> findTv();
    List<Index> findWatch();

    void save(Index index);

    void delete(String id);

    Index findOne(String id);

    void update(Index index);

}
