package com.huike.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Shoping implements Serializable {
    private String id;
    private String pic;
    private String sname;
    private String price;
}
