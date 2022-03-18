package com.xtl.component;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author 31925
 */
@Component
public class Task {
    public static Random random =new Random();

    @Async
    public Future<String> doTaskOne() throws Exception {
        System.out.println("开始做任务⼀");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务⼀，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务⼀完成");
    }

    @Async
    public Future<String>  doTaskTwo() throws Exception {
        System.out.println("开始做任务⼆");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务⼆，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务二完成");
    }

    @Async
    public Future<String>  doTaskThree() throws Exception {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务三完成");
    }
}
