package com.xtl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName LogTest
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/23 16:38
 */
@Slf4j
@SpringBootTest
public class LogTest {

    @Test
    public void testLog() {
        log.info("server id is {},server name is {}",20,"聚合工程");
    }
}
