package com.xtl.controller;


import com.xtl.bean.Department;
import com.xtl.bean.Employee;
import com.xtl.mapper.DepartmentMapper;
import com.xtl.mapper.EmployeeMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 31925
 */
@Controller
@Api(tags = "员工管理")
public class EmployeeController {
    @Resource
    DepartmentMapper departmentMapper;
    @Resource
    EmployeeMapper employeeMapper;

    /**
     * 查询所有员工返回列表页面
     */
    @ApiOperation(value = "获取员工列表", notes = "获取所有员工信息")
    @GetMapping("/emps")
    public String  list(Model model){
        List<Employee> employees =employeeMapper.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    /**
     * 来到员工添加页面
     */
    @ApiOperation(value = "前往员工列表", notes = "获取所有员工信息")
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门，在页面显示
        List<Department> departments = departmentMapper.getAll();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    /**
     * 员工添加
     * SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
     */
    @ApiOperation(value = "添加员工", notes = "添加员工")
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面
        System.out.println("保存的员工信息："+employee);
        //保存员工
        employeeMapper.insertEmp(employee);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/emps";
    }

    /**
     * 来到修改页面，查出当前员工，在页面回显
     */
    @ApiOperation(value = "前往修改员工列表", notes = "前往修改员工信息")
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeMapper.getEmpById(id);
        model.addAttribute("emp",employee);
        //页面要显示所有的部门列表
        List<Department> departments =departmentMapper.getAll();
        model.addAttribute("depts",departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "emp/add";
    }

    @ApiOperation(value = "修改员工列表", notes = "修改员工信息")
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工数据："+employee);
        employeeMapper.updateEmp(employee);
        return "redirect:/emps";
    }



    @ApiOperation(value = "删除员工", notes = "删除员工")
    @ApiImplicitParam(name = "id", value = "员工ID", required = true, dataType = "Integer")
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeMapper.deleteEmpById(id);
        return "redirect:/emps";
    }
}
