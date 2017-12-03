package com.pijingzhanji.scheduling.schedule;

import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.StandardServletEnvironment;

/**
 * @author : 披荆斩棘
 * @date : 2017/7/1
 */
@Component
public class DemoTask {

    @Autowired
    private StandardServletEnvironment environment;

    @Scheduled( cron = "0 0/30 * * * *" )
    @SchedulerLock( name = "DemoTask.demo" )
    public void demo () {
        System.err.println( "environment = " + environment );
    }


}


