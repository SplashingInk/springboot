package com.xtl;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import com.xtl.bean.Person;
import com.xtl.bean.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@org.springframework.boot.test.context.SpringBootTest
public class SpringBootTest {

    @Autowired
    Person person;
    @Autowired
    Teacher teacher;
    @Autowired
    ApplicationContext applicationContext;
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testPerson(){
        System.out.println(person);
    }

    @Test
    public void testTeacher(){
        System.out.println(teacher);
    }

    @Test
    public void testHelloService(){
        System.out.println(applicationContext.containsBean("helloService"));
    }

    @Test
    public void testHelloService2(){
        System.out.println(applicationContext.containsBean("sayHello"));
    }

    @Test
    public void testLog(){
        logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");
    }
}
