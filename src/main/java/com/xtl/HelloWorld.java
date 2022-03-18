package com.xtl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 31925
 * @SpringBootApplication
 *      SpringBoot主程序
 * @ImportResource
 *      加载spring的配置文件
 */
@MapperScan(value = "com.xtl.mapper")
@ImportResource(locations = "classpath:config/spring.xml")
@SpringBootApplication
@EnableScheduling
public class HelloWorld {
    public static void main(String[] args) {
        SpringApplication.run(HelloWorld.class,args);
    }

    @EnableAsync
    @Configuration
    static class TaskPoolConfig {
        @Bean("taskExecutor")
        public Executor taskExecutor() {
            ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
            executor.setPoolSize(20);
            executor.setThreadNamePrefix("taskExecutor-");
            executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
            executor.setWaitForTasksToCompleteOnShutdown(true);
            executor.setAwaitTerminationSeconds(60);
            return executor;
        }
    }
}
