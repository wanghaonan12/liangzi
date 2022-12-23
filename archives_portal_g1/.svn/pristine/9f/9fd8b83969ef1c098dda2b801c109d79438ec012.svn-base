package com.pde.pdes.portal.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


/** 
 * 属性读取配置类
 *
 * @author wzheng
 * @version 1.0.0
*/
@Configuration
public class PdeCoreConfig {

    /** 
    * @Fields corePoolSize : 设置核心线程数 
    */
    @Value("${pde.core.PdeDefaultThreadPool.CorePoolSize:30}")
    private int corePoolSize = 30;

    /** 
    * @Fields maxPoolSize : 设置最大线程数
    */
    @Value("${pde.core.PdeDefaultThreadPool.MaxPoolSize:150}")
    private int maxPoolSize = 150;

    /** 
    * @Fields queueCapacity : 设置队列容量
    */
    @Value("${pde.core.PdeDefaultThreadPool.QueueCapacity:100}")
    private int queueCapacity = 100;

    /** 
    * @Fields keepAliveSeconds : 设置线程活跃时间（秒） 
    */
    @Value("${pde.core.PdeDefaultThreadPool.KeepAliveSeconds:60}")
    private int keepAliveSeconds = 60;

    /** 
    * @Fields threadNamePrefix : 线程名前缀
    */
    @Value("${pde.core.PdeDefaultThreadPool.ThreadNamePrefix:pde-thread-}")
    private String threadNamePrefix = "pde-thread-";


    /** 
    * 获取线程池 
    *
    * @return 线程池
    */
    @Bean(name = "PdeDefaultThreadPool")
    public ThreadPoolTaskExecutor getExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(this.corePoolSize);
        taskExecutor.setMaxPoolSize(this.maxPoolSize);
        taskExecutor.setQueueCapacity(this.queueCapacity);
        taskExecutor.setKeepAliveSeconds(this.keepAliveSeconds);
        taskExecutor.setThreadNamePrefix(this.threadNamePrefix);
        // 设置拒绝策略
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        taskExecutor.initialize();
        return taskExecutor;
    }
}
