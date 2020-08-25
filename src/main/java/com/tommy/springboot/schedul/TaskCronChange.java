package com.tommy.springboot.schedul;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;


/**
 * 动态更改cron
 * @author etaoazh
 *
 */
//@Component
//@EnableScheduling
public class TaskCronChange implements SchedulingConfigurer{
	 public static String cron;
	 
	 public TaskCronChange() {
	        //默认情况是：每5秒执行一次.
	        cron = "0/5 * * * * *";
	        new Thread(new Runnable() {
	           // 开启新线程模拟外部更改了任务执行周期.
	           @Override
	           public void run() {
	              try {
	                  // 让线程睡眠 15秒.
	                  Thread.sleep(15000);
	              } catch (InterruptedException e) {
	                  e.printStackTrace();
	              }
	               //修改为：每10秒执行一次.
	              cron = "0/10 * * * * *";
	               System.err.println("cron change to:"+cron);
	           }

	       }).start();;

	    }


	 
	 
	 
	 
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
	       Runnable task = new Runnable() {
	           @Override
	           public void run() {
	              //任务逻辑代码部分.
	              System.out.println("TaskCronChange task is running ... "+ new Date());
	           }
	       };
		
		Trigger trigger=new Trigger() {
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				CronTrigger co=new CronTrigger(cron);
				Date nextExec=co.nextExecutionTime(triggerContext);
				return nextExec;
			}
		};
		taskRegistrar.addTriggerTask(task, trigger);
	}

	
	public static void main(String [] args) {
		
	}
}
