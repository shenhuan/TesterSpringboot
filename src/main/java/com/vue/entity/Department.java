package com.vue.entity;

import lombok.Data;

@Data
public class Department {
    private Long id;
    private String name;
    private Long parentId;
    private String depPath;
    private boolean enabled;
    private boolean isParent;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }
}
