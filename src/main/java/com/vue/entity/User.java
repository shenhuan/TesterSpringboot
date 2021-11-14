package com.vue.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class User implements Serializable {
    private int id;
    private String uid;
    private String username;
    private String password;
    private Long createtime;
}
