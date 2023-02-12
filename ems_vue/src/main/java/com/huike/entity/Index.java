package com.huike.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Index  implements Serializable {
    private String id;
    private String pic;
    private String sname;
    private String detail;
    private String price;
    private String oldprice;
    private Integer pid;
    private String bgpic;
    private String rom;
    private String color;
    private String path;


}