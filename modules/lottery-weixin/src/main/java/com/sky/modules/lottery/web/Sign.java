package com.sky.modules.lottery.web;

import java.util.UUID;
import java.util.Map;
import java.util.HashMap;
import java.util.Formatter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;  
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sky.modules.lottery.main.WechatCallbackapi;

public class Sign {
    public static void main(String[] args) {
    	String jsapi_ticket = "kgt8ON7yVITDhtdwci0qeVDsNVBwXsNLarD_oCqqS3xTITcJ6LrMLIRok3-wWQwWl5a53lwGeNWZ5lqOt_65xA";
        // 注意 URL 一定要动态获取，不能 hardcode
        String url = "http://www.o2pmall.com/invite.jsp";
        Map<String, String> ret = sign(jsapi_ticket, url);
        for (Map.Entry entry : ret.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
	}
    
    /**
     * 获取 jsapi_ticket
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     * 
     * 成功：
     * errcode: 0
     * errmsg: ok
     * ticket
     * expires_in: 7200
     * 
     */
    public static Map<String, String> getJsapiTicket() throws FileNotFoundException, IOException, ClassNotFoundException{
    	String access_token = WechatCallbackapi.getAccessTokenString();
    	// 获取 jsapi_ticket 的 url
    	final String jsapi_ticket_http = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" 
    			+ access_token + "&type=jsapi";
    	
    	// 获取网页内容
    	String json = WebMessage.downloads(jsapi_ticket_http);
    	
    	// 使用 gson 把 json 转成 Map
    	Gson gson = new Gson();
    	Type type = new TypeToken<Map<String, String>>(){}.getType();
    	return gson.fromJson(json, type);
    }
    
    /**
     * 获取网页完整 url
     * @param request
     * @return
     */
    public static String getUrl(HttpServletRequest request) {
    	String path = request.getContextPath();
    	// 获取参数
		String args = request.getQueryString();
		// 获取端口
		int port = request.getServerPort();
		// 把协议跟域名组合
		String basePath = request.getScheme() + "://" 
				+ request.getServerName();
		// 如果是80端口，默认隐藏端口
		if (port != 80){
			basePath += ":" + port;
		}
		
		// 把项目路径及项目文件组合一起
		basePath += path + request.getServletPath();
		
		basePath = "http://www.paoword.com/publicUserInvite.do";
		
		// 如果参数不为空， 显示出来
		if (args != null) {
			basePath += "?" + args;
		}
		return basePath;
    }
    
    
    public static String getUrl1(HttpServletRequest request) {
    	String path = request.getContextPath();
    	// 获取参数
		String args = request.getQueryString();
		// 获取端口
		int port = request.getServerPort();
		// 把协议跟域名组合
		String basePath = request.getScheme() + "://" 
				+ request.getServerName();
		// 如果是80端口，默认隐藏端口
		if (port != 80){
			basePath += ":" + port;
		}
		
		// 把项目路径及项目文件组合一起
		basePath += path + request.getServletPath();
		
		basePath = "http://www.paoword.com/memory.jsp";
		
		// 如果参数不为空， 显示出来
		if (args != null) {
			basePath += "?" + args;
		}
		return basePath;
    }

    
    public static String getUrl2(HttpServletRequest request) {
    	String path = request.getContextPath();
    	// 获取参数
		String args = request.getQueryString();
		// 获取端口
		int port = request.getServerPort();
		// 把协议跟域名组合
		String basePath = request.getScheme() + "://" 
				+ request.getServerName();
		// 如果是80端口，默认隐藏端口
		if (port != 80){
			basePath += ":" + port;
		}
		
		// 把项目路径及项目文件组合一起
		basePath += path + request.getServletPath();
		
		basePath = "http://www.paoword.com/publicUserNoviceGuidelines.do";
		
		// 如果参数不为空， 显示出来
		if (args != null) {
			basePath += "?" + args;
		}
		return basePath;
    }
    /**
     * 获取JS-SDK签名
     * @param jsapi_ticket
     * @param url
     * @return Map<String, String>
     * url 当前页的网址
     * jsapi_ticket 获取到的jsapi_ticket
     * nonceStr 生成签名的随机串
     * timestamp 生成签名的时间戳
     * signature 签名
     */
    public static Map<String, String> sign(String jsapi_ticket, String url) {
        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                  "&noncestr=" + nonce_str +
                  "&timestamp=" + timestamp +
                  "&url=" + url;
//        System.out.println(string1);

        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);

        return ret;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}
