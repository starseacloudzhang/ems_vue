package com.huike.controller;



import com.huike.entity.Index;

import com.huike.service.IndexService;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("index")
@CrossOrigin
@Slf4j
public class IndexController {

    @Autowired
    private IndexService indexService;

    @Value("${photo.dir}")
    private String realPath;

    //    //修改员工信息
    @PostMapping("update")
    public Map<String, Object> update(Index index, MultipartFile photo) throws IOException {
        log.info("员工信息: [{}]", index.toString());

        Map<String, Object> map = new HashMap<>();
        try {
            if(photo!=null&&photo.getSize()!=0){
                log.info("头像信息: [{}]", photo.getOriginalFilename());
                //头像保存
                String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(photo.getOriginalFilename());
                photo.transferTo(new File(realPath, newFileName));
                //设置头像地址
                index.setPath(newFileName);
            }
            //保存员工信息
            indexService.update(index);
            map.put("state", true);
            map.put("code", 200);
            map.put("msg", "员工信息保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("code", 500);
            map.put("msg", "员工信息保存失败!");
        }
        return map;
    }

    @PostMapping("save")
    public Map<String, Object> save(Index index, MultipartFile photo) throws IOException {
        log.info("员工信息: [{}]", index.toString());
        log.info("头像信息: [{}]", photo.getOriginalFilename());
        Map<String, Object> map = new HashMap<>();
        try {
//            //头像保存
            String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(photo.getOriginalFilename());
            photo.transferTo(new File(realPath, newFileName));
//            //设置头像地址
            index.setPath(newFileName);
            //保存员工信息
            indexService.save(index);
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



    //根据id查询员工信息实现
    @GetMapping("findOne")
    public Map<String, Object>  findOne(String id){

        //log.info("查询员工信息的pid: [{}]",pid);

        Map<String, Object> map = new HashMap<>();
        try {
            Index emplist = indexService.findOne(id);
            map.put("records", emplist);
            map.put("state", true);
            map.put("code", 200);
            map.put("msg", "员工信息保存成功!");

        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("code", 500);
            map.put("msg", "员工信息保存失败!");
        }
        return map;

    }


    //获取员工列表的方法
    @GetMapping("findAll")
    public  Map<String, Object> findAll() {


        Map<String, Object> map = new HashMap<>();
        try {
            List<Index> emplist = indexService.findAll();
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

    @GetMapping("findTv")
    public  Map<String, Object> findTv() {


        Map<String, Object> map = new HashMap<>();
        try {
            List<Index> emplist = indexService.findTv();
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

    @GetMapping("findWatch")
    public  Map<String, Object> findWatch() {


        Map<String, Object> map = new HashMap<>();
        try {
            List<Index> emplist = indexService.findWatch();
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


}