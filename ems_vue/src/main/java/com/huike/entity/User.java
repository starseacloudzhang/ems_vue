package com.huike.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class User {
    private String id;//String 类型api 相当多
    private String username;
    private String password;
    private Date registerTime;

}
