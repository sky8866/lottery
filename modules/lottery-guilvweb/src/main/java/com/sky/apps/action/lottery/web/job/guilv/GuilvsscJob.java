package com.sky.apps.action.lottery.web.job.guilv;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jvnet.hk2.config.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.lottery.entity.guilv.CqJobGuilv;
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.service.guilv.CqJobGuilvService;
import com.sky.modules.lottery.service.guilv.CqsscGuilvService;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService;

@Component
public class GuilvsscJob {
	
	@Autowired private CqJobGuilvService jobGuilvService;
	@Autowired
	private CqsscLotteryService lotteryService;
	
	@Resource(name = "guilvsscServiceMap")
	private Map<String, QueryComm> orderService;

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

	/**
	 * 定时打印当前用户数到日志.
	 */
	private void execute(String by) {
 

		CqsscLottery lottery=this.lotteryService.findLottery2();
		long qi=lottery.getQi();
	    
		CqJobGuilv jobGuilv=this.jobGuilvService.findGuilvKill("qi", qi);
		if(jobGuilv==null){
			jobGuilv=new CqJobGuilv();
			jobGuilv.setQi(qi);
			this.jobGuilvService.saveGuilvKill(jobGuilv);

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
}
