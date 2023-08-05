package cn.bugstack.xfg.dev.tech.config;

import cn.bugstack.xfg.dev.tech.types.component.ExtScheduleJob;
import cn.bugstack.xfg.dev.tech.types.component.ExtScheduleJobConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.Collection;
import java.util.Map;

/**
 * 使用 Spring scheduling 扩展任务调度
 */
@Slf4j
@Configuration
@EnableScheduling
public class JobRegistrarAutoConfig implements SchedulingConfigurer {

    private final ApplicationContext applicationContext;

    public JobRegistrarAutoConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        Map<String, ExtScheduleJob> jobBeanMap = applicationContext.getBeansOfType(ExtScheduleJob.class);
        Collection<ExtScheduleJob> jobBeans = jobBeanMap.values();
        for (ExtScheduleJob job : jobBeans) {
            ExtScheduleJobConfig extScheduleJobConfig = AnnotationUtils.findAnnotation(job.getClass(), ExtScheduleJobConfig.class);
            if (extScheduleJobConfig == null || !extScheduleJobConfig.state()) continue;

            log.info("启动任务 {} {}", extScheduleJobConfig.jobName(), extScheduleJobConfig.cronExpression());
            taskRegistrar.addCronTask(job, extScheduleJobConfig.cronExpression());
        }
    }

}
