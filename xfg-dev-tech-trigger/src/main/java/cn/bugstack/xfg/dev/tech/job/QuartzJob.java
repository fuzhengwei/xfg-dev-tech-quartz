package cn.bugstack.xfg.dev.tech.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 使用 Quartz
 */
@Slf4j
@Component()
public class QuartzJob {

    @Scheduled(cron = "0/3 * * * * ?")
    public void execute01() {
        // 可以在任务中，调用一些业务方法逻辑的实现，如定时扫描超时未支付订单为关单处理，恢复库存
        log.info("执行任务 - Quartz - 01");
    }

    @Scheduled(cron = "0/3 * * * * ?")
    public void execute02() {
        // 可以在任务中，调用一些业务方法逻辑的实现，如定时扫描超时未支付订单为关单处理，恢复库存
        log.info("执行任务 - Quartz - 02");
    }

}
