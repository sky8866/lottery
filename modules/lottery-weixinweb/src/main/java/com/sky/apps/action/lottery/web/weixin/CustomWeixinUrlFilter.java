package com.sky.apps.action.lottery.web.weixin;
  
import org.weixin4j.spi.IMessageHandler; 
import org.weixin4j.util.TokenUtil; 

import java.io.IOException;  
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.weixin4j.Configuration;
 
public class CustomWeixinUrlFilter  implements Filter {
	 private static IMessageHandler messageHandler = null;
	    private static String defaultHandler = "org.weixin4j.spi.DefaultMessageHandler";
	    @Override
	    public void init(FilterConfig config) throws ServletException {
	        if (Configuration.isDebug()) {
	            System.out.println("WeixinUrlFilter启动成功!");
	        }
	    }

	    @Override
	    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	        HttpServletRequest request = (HttpServletRequest) req;
	        HttpServletResponse response = (HttpServletResponse) res;
	        //微信服务器将发送GET请求到填写的URL上,这里需要判定是否为GET请求

	        boolean isGet = request.getMethod().toLowerCase().equals("get");
	        if (Configuration.isDebug()) {
	            System.out.println("获得微信请求:" + request.getMethod() + " 方式");
	            System.out.println("微信请求URL:" + request.getServletPath());
	        }
	        if (isGet) {
	        	System.out.println("qqqqqqqqqqqqqqqqqqqqqqq");
	            //成为开发者验证
	            doGet(request, response);
	        } else {
	           
	        }
	    }

	    //提交信息后，微信服务器将发送GET请求到填写的URL上
	    private void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        String signature = request.getParameter("signature");// 微信加密签名
	        String timestamp = request.getParameter("timestamp");// 时间戳
	        String nonce = request.getParameter("nonce");       // 随机数
	        String echostr = request.getParameter("echostr");   //
       
	        String path = request.getServletPath();
	       
	        String token = "weixin4zthlcx6";
	        //确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
            System.out.println("wwwwwww");
	        if (TokenUtil.checkSignature(token, signature, timestamp, nonce)) {
	            response.getWriter().write(echostr);
	        }
	    }

	    //当普通微信用户向公众账号发消息时，微信服务器将POST消息的XML数据包到开发者填写的URL上
	    //用户在关注与取消关注公众号时，微信会把这个事件推送到开发者填写的URL
	    //用户每次发送语音给公众号时，微信会在推送的语音消息XML数据包中，增加一个Recongnition字段
	    private void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        
	    }
 

	    @Override
	    public void destroy() {
	    }

}
