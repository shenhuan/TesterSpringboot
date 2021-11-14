package com.vue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vue.dao.impl.EmpServiceImpl;
import com.vue.entity.*;
import com.vue.result.ResponseData;
import com.vue.utils.pageParams.PageResult;
import com.vue.utils.poi.PoiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpServiceImpl empServiceImpl;



    PageResult pageResult = new PageResult();
    @RequestMapping(value = "/getEmpsList")
    @ResponseBody
    public ResponseData getEmpList(Integer pageNum, Integer pageSize){
        //创建Page对象
        Page<Emp> empPage = new Page<Emp>(pageNum, pageSize);
        //构建条件
        IPage<Emp> iPage = empServiceImpl.getEmpListByPage(empPage);
        pageResult.setList(iPage.getRecords());
        pageResult.setTotal(iPage.getTotal());
        pageResult.setPageSize(iPage.getSize());
        pageResult.setPageNum(iPage.getPages());
        return ResponseData.success(pageResult);
    }

    //获取配置信息
    @RequestMapping(value = "/getBasicData")
    @ResponseBody
    public ResponseData getBasicData(){
        Map<String,Object> map = new HashMap<String, Object>();
        List<PoliticsStatus> pList =empServiceImpl.getPListByPage();
        List<Nation> nList = empServiceImpl.getNations();
        List<Position> posList = empServiceImpl.getPositions();
        List<JobLevel> jobLevels = empServiceImpl.getJobLevels();
        List<Department> deps = empServiceImpl.getDepartments();
        map.put("politics",pList);
        map.put("nations",nList);
        map.put("positions",posList);
        map.put("joblevels",jobLevels);
        map.put("deps",deps);
        return ResponseData.success(map);
    }

    //获取配置信息
    @RequestMapping(value = "/updateEmp",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData updateEmp(@RequestBody Emp employee){

        if (employee != null){
            if(employee.getId() != null){
                System.out.println("修改员工信息====》"+employee);
                int update=empServiceImpl.updateEmp(employee);
                if(update == 0){
                    return ResponseData.error("修改失败");
                }
                return ResponseData.success();
            }else{
                //添加用户信息
                System.out.println("添加用户信息====》"+employee);
                int update=empServiceImpl.insertEmp(employee);
                if(update == 0){
                    return ResponseData.error("修改失败");
                }
                return ResponseData.success();
            }

        }
        return ResponseData.error("数据更新/添加失败");
    }

    //单个删除
    @RequestMapping(value = "/deleteEmp",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData deleteEmp(String id){
        System.out.println("id===>"+id);
        boolean delete = empServiceImpl.deleteEmp(id);
        if(delete == false){
            return ResponseData.error("员工"+id+"删除失败");
        }
        return ResponseData.success();
    }

    @RequestMapping(value = "/importEmp",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData importEmp(MultipartFile file){
        System.out.println("importEmp====>"+file);
        List<Emp> emps = PoiUtils.importEmp2List(file,
                empServiceImpl.getNations(),
                empServiceImpl.getPListByPage(),
                empServiceImpl.getDepartments(),
                empServiceImpl.getPositions(),
                empServiceImpl.getJobLevels());
        if(empServiceImpl.addEmps(emps) == emps.size()){
            return ResponseData.success("导入成功！");
        }
        return ResponseData.error("导入失败");
    }

}
