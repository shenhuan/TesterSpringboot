package com.vue.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Position {
    private Long id;
    private String name;
    private Timestamp createDate;
    public Position(String name) {

        this.name = name;
    }

}
