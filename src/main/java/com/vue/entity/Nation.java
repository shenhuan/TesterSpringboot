package com.vue.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("nation")
public class Nation {
    private Long id;
    private String name;
    public Nation(String name) {
        this.name = name;
    }
}
