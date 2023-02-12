package com.huike.dao;



import com.huike.entity.Shoping;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopingDAO {
    List<Shoping> findAll();
    void save(Shoping shoping);

    void delete(String id);

    Shoping findOne(String id);

    void update(Shoping shoping);
}
