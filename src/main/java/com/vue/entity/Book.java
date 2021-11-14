package com.vue.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
//@TableName("book")
public class Book implements Serializable {
    @TableId(value = "id",type= IdType.AUTO)
    private Long id;
    private String name;
    private String author;
    private String publish;
    private Integer pages;
    private Double price;
    private Integer bookcaseid;
    private Integer abled;
}
