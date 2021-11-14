package com.vue.entity;

import lombok.Data;

@Data
public class PoliticsStatus {
    private Long id;
    private String name;

    public PoliticsStatus(String name) {

        this.name = name;
    }

    public PoliticsStatus() {

    }
}
