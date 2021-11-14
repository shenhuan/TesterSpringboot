package com.vue.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vue.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpMapper extends BaseMapper<Emp> {

    Page<Emp> getEmpListByPage(Page<Emp> page);

    List<PoliticsStatus> getPListByPage();

    List<Nation> getNations();

    List<Position> getPositions();

    List<JobLevel> getJobLevels();

    List<Department> getDepartments();

    int updateEmp(@Param("emp")Emp employee);

    int insertEmp(@Param("emp")Emp employee);

    int deleteEmp(@Param("ids")String[] ids);

    int addEmps(@Param("emps")List<Emp> emps);
}
