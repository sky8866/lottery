package com.sky.modules.lottery.utils.weixin;



import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppContext  {
	

	
 
	 private static AppContext instance;

	  private AbstractApplicationContext appContext;

	  public synchronized static AppContext getInstance() {
	    if (instance == null) {
	      instance = new AppContext();
	    }
	    return instance;
	  }

	  public AppContext() {
	    this.appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
	  }

	  public AbstractApplicationContext getAppContext() {
	    return appContext;
	  }

}