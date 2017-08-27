package com.sky.modules.lottery.hc.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 生成ticket类
 * @author Allen
 *
 */
public class DimensionalCodeManager {

	private static Logger log = LoggerFactory.getLogger(WeChatUtil.class);
 
    /// 临时二维码地址(一周)                                                                                                         "\" method=\"" + strMethod
    private static String TEMP_JSON_DATA = "{\"expire_seconds\": 604800, \"action_name\": \"QR_SCENE\", \"action_info\": {{\"scene\": {{\"scene_id\":1}}}}}";
    /// 永久二维码地址
  //  private static String PERMANENT_URL = "{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {{\"scene\": {{\"scene_str\": \""+scene_str+"\"}}}}}";
    /// 获取二维码URL
    private static String GET_CODE_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket={0}";
   
    public static Ticket getTicket(String openid) {
 
    	 String permanent = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \""+openid+"\"}}}";
    	Ticket ticket = null;
	    // 发起GET请求获取凭证
	    JSONObject jsonObject = WeChatUtil.httpRequest(WeChatUtil.url,"POST",permanent);
	  
	    if (null != jsonObject) {
	    	
	    	ticket = new Ticket();
	    	ticket.setTicket(jsonObject.getString("ticket"));
	    }else {
	    	ticket = null;
	        log.error("获取ticket失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
		}
	    return ticket;
	  }
    
    
    
    /**
	 * 生成场景str的id
	 * @return String
	 */ 
	public static String getId() {
		int id = 0;
		id += 1;
		String idStr=id+"";
		return idStr;
	}
    
    
    /**
	 * 获取当前时间 yyyyMMddHHmmss
	 * @return String
	 */ 
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}
	
	
	
	
	 /** 
     * 解析微信xml消息 
     * @param strXml 
     * @return 
	 * @throws IOException 
     */  
    public static void getMsgEntity(HttpServletRequest request,HttpServletResponse response) throws IOException{  
    	//处理接收消息    
        ServletInputStream in = request.getInputStream();  
        //将POST流转换为XStream对象  
        XStream xs = new XStream(new DomDriver());  
        //将指定节点下的xml节点数据映射为对象  
        xs.alias("xml", ErWeiMaEvent.class);  
        //将流转换为字符串  
        StringBuilder xmlMsg = new StringBuilder();  
        byte[] b = new byte[4096];  
        for (int n; (n = in.read(b)) != -1;) {  
            xmlMsg.append(new String(b, 0, n, "UTF-8"));  
        }  
        //将xml内容转换为InputMessage对象  
        ErWeiMaEvent inputMsg = (ErWeiMaEvent) xs.fromXML(xmlMsg.toString());  
        // 取得消息类型  
//        String msgType = inputMsg.getMsgType();  
        //根据消息类型获取对应的消息内容  
//        if (msgType.equals(MsgType.Text.toString())) {  
            //文本消息  
            System.out.println("开发者微信号：" + inputMsg.getToUserName());  
            System.out.println("发送方帐号：" + inputMsg.getFromUserName());  
            System.out.println("消息创建时间：" + inputMsg.getCreateTime());  
            System.out.println("类型：" + inputMsg.getMsgType());  
            System.out.println("消息：" + inputMsg.getEvent());  
            System.out.println("场景Id：" + inputMsg.getEventKey());  
            System.out.println("ticket：" + inputMsg.getTicket());  
//        }  
    }  
	
	
	public final static String erWeiMaXML = "<xml>"+
			"<ToUserName><![CDATA[%1$s]]></ToUserName>"+
			"<FromUserName><![CDATA[%2$s]]></FromUserName>"+
			"<CreateTime>%3$s</CreateTime>"+
			"<MsgType><![CDATA[%4$s]]></MsgType>"+
			"<Event><![CDATA[%5$s]]></Event>"+
			"<EventKey><![CDATA[%6$s]]></EventKey>"+
			"<Ticket><![CDATA[%7$s]]></Ticket>"+
			"</xml>"; 
}
