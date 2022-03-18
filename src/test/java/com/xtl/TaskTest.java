package com.xtl;

import com.xtl.component.Task;
import com.xtl.component.TaskAsyncExecutor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@org.springframework.boot.test.context.SpringBootTest
public class TaskTest {
    @Resource
    private Task task;

    @Resource
    private TaskAsyncExecutor taskAsyncExecutor;

    @Test
    public void test() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> taskOne = task.doTaskOne();
        Future<String> taskTwo = task.doTaskTwo();
        Future<String> taskThree = task.doTaskThree();
        while (!(taskOne.isDone() & taskTwo.isDone() & taskThree.isDone())) {
            System.out.println("任务正在执行中。。。。");
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

    @Test
    public void testTwo()throws Exception{
        taskAsyncExecutor.doTaskFour();
        taskAsyncExecutor.doTaskFive();
        Thread.currentThread().join();
    }

    @Test
    public void testThree() throws Exception {
        Future<String> futureResult = taskAsyncExecutor.run();
        String result = futureResult.get(10, TimeUnit.SECONDS);
        System.out.println(result);
    }

}
