package com.sky.modules.lottery.hc.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import com.sky.modules.lottery.hc.http.utils.HttpClientConnectionManager;


public class Test {
	
 public static String appId = "wx601ecf7a8ad12bfb";
 	public static String appSecret="b2597d4f82f5087a3c308ec6c72621d7";
	
	public static void main(String[] args) throws Exception  {
		//test2
		
	Ticket ticket = DimensionalCodeManager.getTicket("1234");
	System.out.println("ticket:"+ticket.getTicket());
	/*
		//修改appID，secret
	     String tokenUrl="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ticket.getTicket();
	     StringBuffer buffer = new StringBuffer();
			try {
			ticket:gQGM8DoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL2tqcVR6Y2ptUElGRlRLcEpkaGJOAAIEEb_SVwMEAAAAAA==

				// 创建SSLContext对象，并使用我们指定的信任管理器初始化
				TrustManager[] tm = { new MyX509TrustManager() };
				SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
				sslContext.init(null, tm, new java.security.SecureRandom());
				// 从上述SSLContext对象中得到SSLSocketFactory对象
				SSLSocketFactory ssf = sslContext.getSocketFactory();

				URL url = new URL(tokenUrl);
				HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
				httpUrlConn.setSSLSocketFactory(ssf);

				httpUrlConn.setDoOutput(true);
				httpUrlConn.setDoInput(true);
				httpUrlConn.setUseCaches(false);
				// 设置请求方式（GET/POST）
				httpUrlConn.setRequestMethod("GET");
 
					httpUrlConn.connect();

			

				// 将返回的输入流转换成字符串
				InputStream inputStream = httpUrlConn.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

				String str = null;
				while ((str = bufferedReader.readLine()) != null) {
					buffer.append(str);
				}
				bufferedReader.close();
				inputStreamReader.close();
				// 释放资源
				inputStream.close();
				inputStream = null;
				httpUrlConn.disconnect();
				
				System.out.println("www:"+buffer.toString());
			} catch (ConnectException ce) {
				
			} catch (Exception e) {
				
			}*/
	}
}
