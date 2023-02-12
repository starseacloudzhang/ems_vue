package com.huike.controller;


import com.huike.entity.Shoping;
import com.huike.service.ShopingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("shoping")
@CrossOrigin
@Slf4j
public class ShopingController {
    @Autowired
    private ShopingService shopingService;

    @GetMapping("findAll")
    public Map<String, Object> findAll() {


        Map<String, Object> map = new HashMap<>();
        try {
            List<Shoping> emplist = shopingService.findAll();
            map.put("records", emplist);
            map.put("state", true);
            map.put("code", 200);
            map.put("msg", "员工信息查询成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("code", 500);
            map.put("msg", "员工信息查询失败!");
        }
        return map;

    }
    @GetMapping("delete")
    public Map<String, Object> delete(String id) {
        log.info("删除员工的id:[{}]",id);
        Map<String, Object> map = new HashMap<>();
        try {
            //删除员工头像
            Shoping emp = shopingService.findOne(id);
            //删除员工信息
            shopingService.delete(id);
            map.put("state",true);
            map.put("code", 200);
            map.put("msg","删除商品信息成功!");
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("code", 500);
            map.put("msg","删除商品信息失败!");
        }
        return map;
    }
    @GetMapping("findOne")
    public Map<String, Object>  findOne(String id){
        log.info("查询员工信息的id: [{}]",id);

        Map<String, Object> map = new HashMap<>();
        try {
            Shoping emplist = shopingService.findOne(id);
            map.put("records", emplist);
            map.put("state", true);
            map.put("code", 200);
            map.put("msg", "商品信息保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("code", 500);
            map.put("msg", "商品信息保存失败!");
        }
        return map;

    }
}
