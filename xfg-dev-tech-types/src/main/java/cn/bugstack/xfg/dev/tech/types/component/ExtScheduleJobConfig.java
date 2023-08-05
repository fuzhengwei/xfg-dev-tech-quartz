package cn.bugstack.xfg.dev.tech.types.component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtScheduleJobConfig {

    /**
     * 开关，true/false
     */
    boolean state() default true;

    /**
     * 任务名称
     */
    String jobName() default "缺省的";

    /**
     * cron 表达式
     */
    String cronExpression() default "0/1 * * * * ?";

}
