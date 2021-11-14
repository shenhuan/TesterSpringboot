package com.vue.entity;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class JobLevel {
    private Long id;
    private String name;
    private String titleLevel;
    private Timestamp createDate;

    public JobLevel() {

    }

    public JobLevel(String name) {

        this.name = name;
    }
}
