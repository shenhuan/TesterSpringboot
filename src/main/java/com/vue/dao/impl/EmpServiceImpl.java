package com.vue.dao.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vue.dao.EmpService;
import com.vue.dao.mapper.EmpMapper;
import com.vue.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {
    @Autowired
    private EmpMapper empMapper ;
    //获取emp列表
    @Override
    public Page<Emp> getEmpListByPage(Page page) {
        Page<Emp> userPage = empMapper.getEmpListByPage(page);
        return userPage;
    }
    //获取politics列表
    public List<PoliticsStatus> getPListByPage() {
        List<PoliticsStatus> userPage = empMapper.getPListByPage();
        return userPage;
    }

    //获取民族 nations 列表
    public List<Nation> getNations() {
        List<Nation> userPage = empMapper.getNations();
        return userPage;
    }

    public List<Position> getPositions() {
        List<Position> userPage = empMapper.getPositions();
        return userPage;
    }

    public List<JobLevel> getJobLevels() {
        List<JobLevel> userPage = empMapper.getJobLevels();
        return userPage;
    }

    public List<Department> getDepartments() {
        List<Department> userPage = empMapper.getDepartments();
        return userPage;
    }

    public int updateEmp(Emp employee) {
        int result = empMapper.updateEmp(employee);
        return result;
    }

    public int insertEmp(Emp employee) {
        int result = empMapper.insertEmp(employee);
        return result;
    }

    public boolean deleteEmp(String ids) {
        String[] split = ids.split(",");
        boolean result = empMapper.deleteEmp(split) == split.length;
        return result;
    }

    public int addEmps(List<Emp> emps) {
        return empMapper.addEmps(emps);
    }
}
