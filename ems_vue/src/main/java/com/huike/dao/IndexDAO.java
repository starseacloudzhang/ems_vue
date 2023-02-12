package com.huike.dao;


import com.huike.entity.Index;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndexDAO {
    List<Index> findAll();
    List<Index> findTv();
    List<Index> findWatch();
    void save(Index index);

    void delete(String id);

    Index findOne(String id);

    void update(Index index);
}
