package com.vue.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Dog {
    private String name;
    private Integer age;
}

