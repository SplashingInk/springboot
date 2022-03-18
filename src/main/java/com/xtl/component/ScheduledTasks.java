package com.xtl.component;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 31925
 */
public class ScheduledTasks {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
    @Scheduled(fixedRate = 20000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + DATE_FORMAT.format(new Date()));
    }
}
