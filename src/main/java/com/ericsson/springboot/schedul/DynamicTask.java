package com.ericsson.springboot.schedul;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class DynamicTask {

	@Autowired
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;

	private ScheduledFuture<?> future;

	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		return new ThreadPoolTaskScheduler();
	}

	@RequestMapping("/startCron")
	public String startCron() {
		future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger("0/5 * * * * *"));
		System.out.println("DynamicTask.startCron()");
		return "startCron";
	}

	@RequestMapping("/stopCron")
	public String stopCron() {
		if (future != null) {
			future.cancel(true);
		}
		System.out.println("DynamicTask.stopCron()");
		return "stopCron";
	}

	@RequestMapping("/changeCron10")
	public String startCron10() {
		stopCron();// 先停止，在开启.
		future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger("*/10 * * * * *"));
		System.out.println("DynamicTask.startCron10()");
		return "changeCron10";
	}

	private String cronStr = "*/5 * * * * *";
	
	@RequestMapping("/startCron1")
    public String startCron1(){
        System.out.println("startCron1 >>>>");
        cronStr = "*/10 * * * * *";
        threadPoolTaskScheduler.schedule(new MyRunnable(), new Trigger(){
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext){
                return new CronTrigger(cronStr).nextExecutionTime(triggerContext);
            }

        });

        System.out.println("startCron1 <<<<");

        return "startCron1";
	
	}
	
	
	
	private class MyRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println("DynamicTask.MyRunnable.run()，" + new Date());

		}

	}
}
