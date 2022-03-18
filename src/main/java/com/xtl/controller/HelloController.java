package com.xtl.controller;

import com.xtl.bean.Child;
import com.xtl.exception.UserNotExistException;
import com.xtl.repository.ChildRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author 31925
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Resource
    JdbcTemplate jdbcTemplate;
    
    @Resource
    ChildRepository childRepository;

    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return "Hello World!";
    }

    @RequestMapping("success")
    public String success(Map<String,Object> map){
        map.put("job","<h3>人民教师</h3>");
        map.put("animations", Arrays.asList("秦时明月","不良人","灵笼","幻境诺德琳"));
        return "success";
    }

    @RequestMapping("king")
    public void king(String key){
        if("boss".equals(key)){
            throw new UserNotExistException();
        }
    }

    @ResponseBody
    @GetMapping("query")
    public Map<String,Object> map(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * FROM department");
        return list.get(0);
    }

    @ResponseBody
    @GetMapping("child/{id}")
    public Child  getChildById(@PathVariable("id") Integer id){
        Child child = childRepository.getById(id);
        if(child==null){
            throw new UserNotExistException();
        }
        return child;
    }

    @ResponseBody
    @GetMapping("child")
    public Child insertChild(Child child){
        return childRepository.save(child);
    }
}
