package com.sky.apps.action.lottery.web.job.guilv;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
 
@Component
public class GuilvJob {
	   @Resource(name = "guilvServiceMap")
	    private Map<String,QueryComm> orderService;
		public void executeByJdk() {
			execute("jdk timer job");
		}

		public void executeBySpringCronByJava() {
			execute("spring cron job by java");
		}

		// 被Spring的Quartz MethodInvokingJobDetailFactoryBean反射执行
		public void executeByQuartzLocalJob() {
			execute("quartz local job");
		}

		// 被Spring的Scheduler namespace 反射构造成ScheduledMethodRunnable
		public void executeBySpringCronByXml() {
			execute("spring cron job by xml");
		}

		// 被Spring的Scheduler namespace 反射构造成ScheduledMethodRunnable
		public void executeBySpringTimerByXml() {
			execute("spring timer job by xml");
		}

		
		private void execute(String by) { 
			for (String key : orderService.keySet()) {
				final QueryComm orderQuery = orderService.get(key);
				 
				new Thread(new Runnable() {
					public void run() {
						try {

							if (orderQuery != null) {
								orderQuery.job();
							}
						} catch (Exception e) {

						}
					}
				},key).start();
	            
			}
			
			
	     
	    }
}
