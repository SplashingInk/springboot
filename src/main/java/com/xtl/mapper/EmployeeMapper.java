package com.xtl.mapper;


import com.xtl.bean.Employee;

import java.util.List;

/**
 * @author 31925
 * @Mapper或者@MapperScan将接口扫描装配到容器中
 */
public interface EmployeeMapper {

    /**
     * 查询员工
     * @param id 员工id
     * @return 员工
     */
    public Employee getEmpById(Integer id);

    /**
     * 添加员工
     * @param employee 插入的员工
     */
    public void insertEmp(Employee employee);

    /**
     * 返回所有员工
     * @return 所有的员工列表
     */
    public List<Employee> getAll();

    /**
     * 删除指定员工
     * @param id 员工id
     */
    public void deleteEmpById(Integer id);

    /**
     * 更新员工数据
     * @param employee 修改的员工数据
     */
    public void updateEmp(Employee employee);
}
