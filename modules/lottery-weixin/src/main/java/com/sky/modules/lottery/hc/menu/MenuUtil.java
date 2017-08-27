package com.sky.modules.lottery.hc.menu;

import org.apache.http.HttpResponse;  
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.entity.StringEntity;  
import org.apache.http.impl.client.DefaultHttpClient;  
import org.apache.http.util.EntityUtils;  
import org.json.JSONObject;

import com.sky.modules.lottery.hc.http.utils.HttpClientConnectionManager;
  
public class MenuUtil {  
  
    public static String APPID,APPSECRET;  
      
    //http客户端    
    public static DefaultHttpClient httpclient;  
      
    static {    
        httpclient = new DefaultHttpClient();    
        httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端  
               
        APPID = "wxc651acc48ddf59c0";	//AppID(应用ID)
        APPSECRET = "09db79ae998ca59f5c8de601af8d0b00";	//AppSecret(应用密钥)
    }    
      
    /** 
     * 创建菜单  
     */  
    public static String createMenu(String params, String accessToken) throws Exception {    
        HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken);    
        httpost.setEntity(new StringEntity(params, "UTF-8"));    
        HttpResponse response = httpclient.execute(httpost);    
        String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");    
        JSONObject demoJson = new JSONObject(jsonStr);  
        return demoJson.getString("errmsg");  
    }    
    /** 
     * 获取accessToken  
     */  
    public static String getAccessToken(String appid, String secret) throws Exception {    
        HttpGet get = HttpClientConnectionManager.getGetMethod("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secret);    
        HttpResponse response = httpclient.execute(get);    
        String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");  
        JSONObject demoJson = new JSONObject(jsonStr);  
        return demoJson.getString("access_token");  
    }    
    /** 
     * 查询菜单 
     */  
    public static String getMenuInfo(String accessToken) throws Exception {    
        HttpGet get = HttpClientConnectionManager.getGetMethod("https://api.weixin.qq.com/cgi-bin/menu/get?access_token=" + accessToken);    
        HttpResponse response = httpclient.execute(get);    
        String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");    
        return jsonStr;    
    }    
      
    /**  
     * 删除菜单  
     */    
    public static String deleteMenuInfo(String accessToken) throws Exception {    
        HttpGet get = HttpClientConnectionManager.getGetMethod("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=" + accessToken);    
        HttpResponse response = httpclient.execute(get);    
        String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");    
        JSONObject demoJson = new JSONObject(jsonStr);  
        return demoJson.getString("errmsg");    
    }    
      
   /* 
    * 测试 
    */  
    public static void main(String[] args) {  
    	
        StringBuffer sb = new StringBuffer();  
        sb.append("{");  
        sb.append(" \"button\":[");  
        sb.append("     {");  
        sb.append("         \"name\":\"泡单词\",");             //URL 连接  
        sb.append("         \"sub_button\":[");  
        sb.append("             {");  
        sb.append("                 \"type\":\"view\",");  
        sb.append("                 \"name\":\"泡单词官网\",");  
        sb.append("                 \"url\":\"http://www.paoword.com\"");    //连接地址  
        sb.append("             },");  
        sb.append("             {");  
        sb.append("                 \"type\":\"view\",");  
        sb.append("                 \"name\":\"club\",");  
        sb.append("                 \"url\":\"http://club.paoword.com\"");  
        sb.append("             },");  
        sb.append("             {");  
        sb.append("                 \"type\":\"view\",");  
        sb.append("                 \"name\":\"网页授权（弹）\",");                                                      //http://120.24.63.23/wx_api 
        sb.append("                 \"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9f755a335b215cdb&redirect_uri=http%3a%2f%2fwww.paoword.com%2fjsp%2fpay%2fregister.jsp&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect\"");    //连接地址      //对于已关注公众号的用户，如果用户从公众号的会话或者自定义菜单进入本公众号的网页授权页，即使是scope为snsapi_userinfo，也是静默授权，用户无感知						
        sb.append("             },");  
        sb.append("             {");  
        sb.append("                 \"type\":\"view\",");  
        sb.append("                 \"name\":\"网页授权（不弹）\",");  
        sb.append("                 \"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9f755a335b215cdb&redirect_uri=http%3a%2f%2fwww.paoword.com%2fjsp%2fpay%2fgogo.html&response_type=code&scope=snsapi_base&state=123#wechat_redirect\"");    //连接地址									  
        sb.append("             },");  
        sb.append("             {");  
        sb.append("                 \"type\":\"view\",");  
        sb.append("                 \"name\":\"QQ\",");  
        sb.append("                 \"url\":\"https://open.weixin.qq.com\"");     
        sb.append("             }");  
        sb.append("         ]");  
        sb.append("     },"); 
        
        sb.append("     {");  
        sb.append("         \"name\":\"发送\",");    
        sb.append("         \"sub_button\":[");  
        sb.append("             {");  
        sb.append("                 \"type\":\"location_select\",");  
        sb.append("                 \"name\":\"发送位置\",");  
        sb.append("                 \"key\":\"rselfmenu_2_0\"");  
        sb.append("             },");  
        sb.append("             {");  
        sb.append("                 \"type\":\"click\",");  
        sb.append("                 \"name\":\"今日歌曲\",");  
        sb.append("                 \"key\":\"V1001_TODAY_MUSIC\"");  
        sb.append("             },");  
        sb.append("             {");  
        sb.append("                 \"type\":\"click\",");  
        sb.append("                 \"name\":\"歌手简介\",");  
        sb.append("                 \"key\":\"V1001_TODAY_SINGER\"");    //连接地址      //对于已关注公众号的用户，如果用户从公众号的会话或者自定义菜单进入本公众号的网页授权页，即使是scope为snsapi_userinfo，也是静默授权，用户无感知						
        sb.append("             },"); 
        sb.append("             {");  
        sb.append("                 \"type\":\"view\",");  
        sb.append("                 \"name\":\"视频\",");  
        sb.append("                 \"url\":\"http://v.qq.com\"");    //连接地址      //对于已关注公众号的用户，如果用户从公众号的会话或者自定义菜单进入本公众号的网页授权页，即使是scope为snsapi_userinfo，也是静默授权，用户无感知						
        sb.append("             },");  
        sb.append("             {");  
        sb.append("                 \"type\":\"view\",");  
        sb.append("                 \"name\":\"购买商品\",");                                                                               //club.paoword.com                                               
        sb.append("                 \"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9f755a335b215cdb&redirect_uri=http%3a%2f%2fclub.paoword.com%2fjsp%2fpay%2fregister.jsp&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect\""); 					
        sb.append("             }"); 
        sb.append("         ]");  
        sb.append("     },");  
        
        sb.append("     {");  
        sb.append("         \"name\":\"扫码或发图\",");  
        sb.append("         \"sub_button\":[");  
        sb.append("             {");  
        sb.append("                 \"type\":\"scancode_waitmsg\",");  
        sb.append("                 \"name\":\"扫码带提示\",");  
        sb.append("                 \"key\":\"rselfmenu_0_0\"");  
        sb.append("             },");  
        sb.append("             {");  
        sb.append("                 \"type\":\"scancode_push\",");  
        sb.append("                 \"name\":\"扫码推事件\",");  
        sb.append("                 \"key\":\"rselfmenu_0_1\"");  
        sb.append("             },");  
        sb.append("             {");  
        sb.append("                 \"type\":\"pic_sysphoto\",");  
        sb.append("                 \"name\":\"系统拍照发图\",");  
        sb.append("                 \"key\":\"rselfmenu_1_0\"");  
        sb.append("             },"); 
        sb.append("             {");  
        sb.append("                 \"type\":\"pic_photo_or_album\",");  
        sb.append("                 \"name\":\"拍照或者相册发图\",");  
        sb.append("                 \"key\":\"rselfmenu_1_1\"");  
        sb.append("             },");
        sb.append("             {");  
        sb.append("                 \"type\":\"pic_weixin\",");  
        sb.append("                 \"name\":\"微信相册发图\",");  
        sb.append("                 \"key\":\"rselfmenu_1_2\"");  
        sb.append("             }");
        sb.append("         ]");  
        sb.append("     }");  
        sb.append(" ]");  
        sb.append("}");  
          
        try {  
            // 获取accessToken -参数appid，secret    
            String accessToken = getAccessToken(APPID, APPSECRET);    
            String res="12343241";  
            res = createMenu(sb.toString(), accessToken);    
            System.out.println(res);    
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
    }  
  
}  
