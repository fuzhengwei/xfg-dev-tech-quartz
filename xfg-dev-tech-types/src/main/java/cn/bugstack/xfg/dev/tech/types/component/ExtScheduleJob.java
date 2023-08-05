package cn.bugstack.xfg.dev.tech.types.component;

import lombok.Setter;

@Setter
public abstract class ExtScheduleJob implements Runnable{

    @Override
    public void run() {
        this.doJob();
    }

    protected abstract void doJob();

}
