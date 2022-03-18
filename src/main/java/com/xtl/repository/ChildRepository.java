package com.xtl.repository;

import com.xtl.bean.Child;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 31925
 * 继承JpaRepository来完成对数据库的操作
 */
public interface ChildRepository extends JpaRepository<Child,Integer> {
}
