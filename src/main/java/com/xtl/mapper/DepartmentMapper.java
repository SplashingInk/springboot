package com.xtl.mapper;

import com.xtl.bean.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * @author 31925
 */
public interface DepartmentMapper {

    /**
     * 查询指定部门
     * @param id 部门id
     * @return 查询到的部门
     */
    @Select(value = "select * from department where id=#{id}")
    Department getDeptById(Integer id);

    /**
     * 删除指定部门
     * @param id 部门id
     */
    @Delete("delete from department where id=#{id}")
    void deleteDeptById(Integer id);

    /**
     * 添加部门
     * @param department 要更新的部门信息
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    void insertDept(Department department);

    /**
     * 更新部门
     * @param department 要更新的部门信息
     * @return  操作个数
     */
    @Update("update department set department_name=#{departmentName} where id=#{id}")
    int updateDept(Department department);

    /**
     * 返回所有部门信息
     * @return 返回所有部门信息
     */
    @Select("select * from department")
    List<Department> getAll();
}
