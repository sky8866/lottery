package com.sky.modules.lottery.user;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sky.modules.lottery.main.WechatCallbackapi;

public class UserInfo {
	
	// 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，
	// 拉取不到其余信息。
	private String subscribe;
	// 用户的标识，对当前公众号唯一
	private String openid;
	// 用户的昵称
	private String nickname;
	// 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	private String sex;
	// 用户所在城市
	private String city;
	// 用户所在国家
	private String country;
	// 用户所在省份
	private String province;
	// 用户的语言，简体中文为zh_CN
	private String language;
	// 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，
	// 0代表640*640正方形头像），用户没有头像时该项为空。
	// 若用户更换头像，原有头像URL将失效。
	private String headimgurl;
	// 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	private String subscribe_time;
	// 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	private String unionid;
	// 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
	private String remark;
	// 用户所在的分组ID
	private String groupid;
	
	public UserInfo(String openid) {
		initVariable(openid);
	}
	
	/**
	 * 获取用户基本信息
	 * @param openid 普通用户的标识
	 * https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
	 * lang 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	 * @return
	 */
	public String  getUserMessage(String openid,String access_token){
		InputStream input = null;
		try {
	 
			
			final String http = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" 
			+ access_token + "&openid=" + openid + "&lang=zh_CN";
		
			URL url = new URL(http);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestProperty("Content-type", "text/html");
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestProperty("contentType", "utf-8");
			// 5秒延时
			conn.setConnectTimeout(5000);
			byte[] buffer = new byte[1024];
			int len = -1;
			input = conn.getInputStream();
			StringBuilder sb = new StringBuilder();
			while ((len = input.read(buffer)) != -1) {
				sb.append(new String(buffer, 0, len, "UTF-8"));
				 
			}
			input.close();
			
			 
		 
			
			
			
			
			final String infojson =  sb.toString()   ;
			
	/*		
			 
			// 使用 Gson 把 json 转换成 Map
			Gson gson = new Gson();
			Type type = new TypeToken<Map<String, String>>(){}.getType();
			Map<String, String> map = gson.fromJson(infojson, type);
			System.out.println("userMAP:"+map.toString());*/
			return infojson;
		} catch (Exception e) {
			
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 获取用户基本信息
	 * @param openid 普通用户的标识
	 * https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
	 * lang 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	 * @return
	 */
	public String  getUserMessage(String openid){
		InputStream input = null;
		try {
			String access_token = WechatCallbackapi.getAccessTokenString();
			
			final String http = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" 
			+ access_token + "&openid=" + openid + "&lang=zh_CN";
		
			URL url = new URL(http);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestProperty("Content-type", "text/html");
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestProperty("contentType", "utf-8");
			// 5秒延时
			conn.setConnectTimeout(5000);
			byte[] buffer = new byte[1024];
			int len = -1;
			input = conn.getInputStream();
			StringBuilder sb = new StringBuilder();
			while ((len = input.read(buffer)) != -1) {
				sb.append(new String(buffer, 0, len, "UTF-8"));
				 
			}
			input.close();
			
			 
		 
			
			
			
			
			final String infojson =  sb.toString()   ;
			
	/*		
			 
			// 使用 Gson 把 json 转换成 Map
			Gson gson = new Gson();
			Type type = new TypeToken<Map<String, String>>(){}.getType();
			Map<String, String> map = gson.fromJson(infojson, type);
			System.out.println("userMAP:"+map.toString());*/
			return infojson;
		} catch (Exception e) {
			
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 初始化变量值
	 * @param openid
	 */
	private void initVariable(String openid) {
		String map = getUserMessage(openid);
		  JSONObject json = JSONObject.fromObject(map);
		
		this.subscribe = json.optString("subscribe");
		this.openid =  json.optString("openid");
		this.nickname =  json.optString("nickname");
		this.sex =  json.optString("sex");
		this.city =  json.optString("city");
		this.country =  json.optString("country");
		this.province =  json.optString("province");
		this.language =  json.optString("language");
		this.headimgurl =  json.optString("headimgurl");
		this.subscribe_time =  json.optString("subscribe_time");
		this.unionid =  json.optString("unionid");
		this.remark =  json.optString("remark");
		this.groupid =  json.optString("groupid");
	}


	public String getSubscribe() {
		return subscribe;
	}


	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}


	public String getOpenid() {
		return openid;
	}


	public void setOpenid(String openid) {
		this.openid = openid;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getHeadimgurl() {
		return headimgurl;
	}


	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}


	public String getSubscribe_time() {
		return subscribe_time;
	}


	public void setSubscribe_time(String subscribe_time) {
		this.subscribe_time = subscribe_time;
	}


	public String getUnionid() {
		return unionid;
	}


	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getGroupid() {
		return groupid;
	}


	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	
	
}
