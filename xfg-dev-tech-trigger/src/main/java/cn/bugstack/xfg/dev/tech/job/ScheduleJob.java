package cn.bugstack.xfg.dev.tech.job;

import cn.bugstack.xfg.dev.tech.types.component.ExtScheduleJob;
import cn.bugstack.xfg.dev.tech.types.component.ExtScheduleJobConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 自己做组件实现
 */
@Slf4j
@Component()
@ExtScheduleJobConfig(state = true, jobName = "测试任务", cronExpression = "0/3 * * * * ?")
public class ScheduleJob extends ExtScheduleJob {

    @Override
    protected void doJob() {
        // 可以在任务中，调用一些业务方法逻辑的实现，如定时扫描超时未支付订单为关单处理，恢复库存
        log.info("执行任务 - Schedule - 01");
    }

}
