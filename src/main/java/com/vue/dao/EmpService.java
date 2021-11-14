package com.vue.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vue.entity.Emp;
import org.springframework.stereotype.Service;

@Service
public interface EmpService extends IService<Emp> {
    Page<Emp> getEmpListByPage(Page<Emp> page);
}
