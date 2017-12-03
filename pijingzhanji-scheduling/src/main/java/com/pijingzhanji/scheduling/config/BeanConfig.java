package com.pijingzhanji.scheduling.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jedis.JedisLockProvider;
import net.javacrumbs.shedlock.spring.ScheduledLockConfiguration;
import net.javacrumbs.shedlock.spring.ScheduledLockConfigurationBuilder;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.context.support.StandardServletEnvironment;
import redis.clients.jedis.JedisPool;

import java.time.Duration;

/**
 * @author : 披荆斩棘
 * @date : 2017/6/22
 */
@Configuration
public class BeanConfig implements EnvironmentAware, ApplicationContextAware {

    private StandardServletEnvironment standardServletEnvironment;
    private ApplicationContext         applicationContext;

    /**
     * 配置锁
     *
     * @param jedisPool
     * @return
     */
    @Bean
    public LockProvider lockProvider ( JedisPool jedisPool ) {
        return new JedisLockProvider( jedisPool , "pijingzhanji-scheduling" );
    }


    /**
     * 计划任务分布式锁配置,保证在多个实例下,任务只在一台机器上运行.
     *
     * @param lockProvider
     * @return
     */
    @Bean
    public ScheduledLockConfiguration taskScheduler ( LockProvider lockProvider ) {
        return ScheduledLockConfigurationBuilder
                .withLockProvider( lockProvider )
                .withPoolSize( 30 )
                .withDefaultLockAtMostFor( Duration.ofMinutes( 30 ) )
                .build();
    }


    @Override
    public void setApplicationContext ( ApplicationContext applicationContext ) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setEnvironment ( Environment environment ) {
        this.standardServletEnvironment = ( StandardServletEnvironment ) environment;
    }


}
