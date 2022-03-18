package com.xtl.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 31925
 * 使用JPA注解配置映射关系
 * @Entity 告诉JPA这是一个实体类（和数据表映射的类）
 * @Table 来指定和哪个数据表对应;如果省略默认表名就是child
 * @JsonIgnoreProperties  解决序列化错误
 */
@Entity
@Table(name = "child")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Child implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name" ,length = 50)
    private String name;
    @Column
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
