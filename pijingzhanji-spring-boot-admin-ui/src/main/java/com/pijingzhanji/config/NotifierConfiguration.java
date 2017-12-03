package com.pijingzhanji.config;

import de.codecentric.boot.admin.notify.Notifier;
import de.codecentric.boot.admin.notify.RemindingNotifier;
import de.codecentric.boot.admin.notify.filter.FilteringNotifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

/**
 * 如果监控的服务down后,则会发送邮件提醒
 *
 * @author : 披荆斩棘
 * @date : 2017/7/2
 */
@Configuration
@EnableScheduling
public class NotifierConfiguration {

    @Autowired
    private Notifier delegate;

    @Bean
    public FilteringNotifier filteringNotifier () {
        return new FilteringNotifier( delegate );
    }

    @Bean
    @Primary
    public RemindingNotifier remindingNotifier () {
        RemindingNotifier notifier = new RemindingNotifier( filteringNotifier() );
        // 提醒将每1小时发送一次。
        notifier.setReminderPeriod( TimeUnit.HOURS.toMillis( 1 ) );
        return notifier;
    }

    @Scheduled( fixedRate = 1_000_000L )
    public void remind () {
        remindingNotifier().sendReminders();
    }
}
