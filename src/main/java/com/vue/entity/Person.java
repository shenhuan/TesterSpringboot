package com.vue.entity;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;
@Component
@Data
@ConfigurationProperties(prefix = "person")
@Validated//数据校验
public class Person {
//    @Email(message="格式错误")
    private String name;

    private Integer age;

    private List<String> list;

    private Map<String, String> map;
}
