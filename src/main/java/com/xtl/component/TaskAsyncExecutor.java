package com.xtl.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author 31925
 */
@Slf4j
@Component
public class TaskAsyncExecutor {

    public static Random random =new Random();

    @Async("taskExecutor")
    public void doTaskFour() throws Exception {
        System.out.println("开始做任务四");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务四，耗时：" + (end - start) + "毫秒");
    }

    @Async("taskExecutor")
    public void doTaskFive() throws Exception {
        System.out.println("开始做任务五");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务五，耗时：" + (end - start) + "毫秒");
    }

    @Async("taskExecutor")
    public Future<String> run() throws Exception {
        long sleep = random.nextInt(10000);
        log.info("开始任务，需耗时：" + sleep + "毫秒");
        Thread.sleep(sleep);
        log.info("完成任务");
        return new AsyncResult<>("test");
    }
}
