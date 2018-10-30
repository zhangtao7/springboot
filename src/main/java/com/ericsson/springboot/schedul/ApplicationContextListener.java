package com.ericsson.springboot.schedul;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


@WebListener
public class ApplicationContextListener implements ServletContextListener{

	private Scheduler scheduler = null;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
				scheduler = StdSchedulerFactory.getDefaultScheduler();
		        scheduler.start();
		        System.out.println("scheduler.start");
		        System.out.println(scheduler.getSchedulerName());
	        
		        //具体任务.
	           JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("job1","group1").build();
	           //触发时间点. (每5秒执行1次.)
	           SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
	           Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1").startNow().withSchedule(simpleScheduleBuilder).build();
	           // 交由Scheduler安排触发
	           scheduler.scheduleJob(jobDetail,trigger);
		}catch(Exception e) {
			
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		 try {
	           scheduler.shutdown();
	       } catch (Exception e) {
	           e.printStackTrace();
	       }//关闭定时任务调度器.
	}

}
