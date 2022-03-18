package com.xtl.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author 31925
 * @PropertySource
 *      加载指定位置的配置文件，只能加载properties文件
 */
@Component
@PropertySource(value = {"classpath:properties/teacher.properties"})
@ConfigurationProperties(prefix = "teacher")
public class Teacher {
    private String firstName;
    private Integer age;
    private Character sex;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
