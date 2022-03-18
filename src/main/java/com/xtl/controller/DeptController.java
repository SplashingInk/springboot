package com.xtl.controller;


import com.xtl.bean.Department;
import com.xtl.mapper.DepartmentMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 31925
 */
@RestController
public class DeptController {

    @Resource
    DepartmentMapper departmentMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @PutMapping("/dept")
    public int updateDept(Department department){
        int i = departmentMapper.updateDept(department);
        if(i>0){
            System.out.println("更新操作成功，更新的数据是："+department);
        }
        return i;
    }

    @DeleteMapping("/dept/{id}")
    public void deleteDept(@PathVariable("id") Integer id){
        departmentMapper.deleteDeptById(id);
    }
}
