package com.vue.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vue.dao.EmpService;
import com.vue.dao.PoliticsStatusService;
import com.vue.dao.mapper.EmpMapper;
import com.vue.dao.mapper.PoliticsStatusMapper;
import com.vue.entity.Emp;
import com.vue.entity.PoliticsStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoliticsServiceImpl extends ServiceImpl<PoliticsStatusMapper, PoliticsStatus> implements PoliticsStatusService {
    @Autowired
    private PoliticsStatusMapper politicsStatusMapper ;
}
