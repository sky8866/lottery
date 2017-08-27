package com.sky.modules.lottery.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sky.modules.lottery.main.Constant;
 

public class WebMessage {
	
	/**
	 * 获取网页上的内容
	 * @param http 网址
	 * @return
	 */
	public static String downloads(String http) throws IOException{
		URL url = new URL(http);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setRequestProperty("Content-type", "text/html");
		conn.setRequestProperty("Accept-Charset", "utf-8");
		conn.setRequestProperty("contentType", "utf-8");
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("GET"); 
		conn.setConnectTimeout(5000);
		conn.connect();
		String line = null;
		InputStream input = conn.getInputStream();
		int len = -1;
		byte[] buffer = new byte[1024];
//		BufferedReader inputbuffer = new BufferedReader(
//				new InputStreamReader(input, "GBK"));
		
		StringBuilder sb = new StringBuilder();
		while ((len = input.read(buffer)) != -1) {
			sb.append(new String(buffer, 0, len, "utf-8"));
		}
		input.close();
		conn.disconnect();
		return sb.toString();
	}
	
	private String chageCode(String source, String previousCode, String nextCode) throws UnsupportedEncodingException {
		byte[] buffer = source.getBytes(previousCode);
		return new String(buffer, 0, buffer.length, nextCode);
	}
	
	/**
	 * 获取网页授权的 access_token, 
	 * 注意: 这里的 access_token 跟 WechatCallbackapi.java 中的 access_token 不相同!
	 * 详情查看： http://mp.weixin.qq.com/wiki/17/c0f37d5704f0b64713d5d2c37b468d75.html
	 * @param code 微信跳转到页面，会发送 code 跟 state 到页面
	 * @return
	 * 成功： 
	 * access_token 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 * expires_in access_token接口调用凭证超时时间，单位（秒）
	 * refresh_token 用户刷新access_token
	 * openid 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
	 * scope 用户授权的作用域，使用逗号（,）分隔
	 * unionid 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	 * 失败：
	 * errcode
	 * errmsg
	 */
	public Map<String, String> getAccessToken(String code) {
		// 获取 access_token 的url
		final String access_token_http = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
				+ Constant.appId + "&secret="+Constant.AppSecret + "&code=" + code + "&grant_type=authorization_code";
		
		try{
			String json = WebMessage.downloads(access_token_http);
			// 使用 Gson 把json 转换成 Map
			Gson gson = new Gson();
			Type type = new TypeToken<Map<String, String>>(){}.getType();	
			return gson.fromJson(json, type);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		WebMessage web = new WebMessage();
		String code = "031dd0ebc1ad97bee6ba178b84dfe41n";
		Map<String, String> tokenMap = web.getAccessToken(code);
		if (tokenMap == null) {
			System.out.println("null");
		}
		
		
		System.out.println(tokenMap.get("access_token"));
		System.out.println(tokenMap.get("openid"));
	}
	
	/**
	 * 刷新access_token(如果需要)
	 * @param refresh_token 通过access_token获取到的refresh_token参数
	 * @return
	 * 成功：
	 * access_token	网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 * expires_in	access_token接口调用凭证超时时间，单位（秒）
	 * refresh_token	用户刷新access_token
	 * openid	用户唯一标识
	 * scope	用户授权的作用域，使用逗号（,）分隔
	 * 失败：
	 * errcode
	 * errmsg
	 */
	public Map<String, String> refreshToken(String refresh_token){
		final String refresh_token_http = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="
				+ Constant.appId + "&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
		try{
			String json = WebMessage.downloads(refresh_token_http);
			// 使用 Gson 把json 转换成 Map
			Gson gson = new Gson();
			Type type = new TypeToken<Map<String, String>>(){}.getType();	
			return gson.fromJson(json, type);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取用户信息(授权作用域为 snsapi_userinfo 才能使用)
	 * @param access_token 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 * @param user_openid  用户的唯一标识
	 * @param lang 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	 * @return
	 * 成功：
	 * openid 用户的唯一标识
	 * nickname 用户昵称
	 * sex 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	 * province 用户个人资料填写的省份
	 * city 普通用户个人资料填写的城市
	 * country 国家，如中国为CN
	 * headimgurl 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效
	 * privilege(数组) 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
	 * unionid 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	 * 失败：
	 * errcode
	 * errmsg
	 */
	public Map<String, ?> userInfo(String access_token, String user_openid){
		final String userinfo_http = "https://api.weixin.qq.com/sns/userinfo?access_token="
				+ access_token + "&openid="+ user_openid + "&lang=zh_CN";
		try{
			String json = WebMessage.downloads(userinfo_http);
			// 使用 Gson 把json 转换成 Map
			Gson gson = new Gson();
			Type type = new TypeToken<Map<String, ?>>(){}.getType();	
			return gson.fromJson(json, type);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 检验授权凭证（access_token）是否有效
	 * @param access_token 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 * @param user_openid 用户的唯一标识
	 * @return
	 * 成功：
	 * { "errcode":0,"errmsg":"ok"}
	 * 失败：
	 * { "errcode":40003,"errmsg":"invalid openid"}
	 */
	public Map<String, String> isValid(String access_token, String user_openid) {
		final String vaild_http = "https://api.weixin.qq.com/sns/auth?access_token="
				+ access_token + "&openid=" + user_openid;
		try{
			String json = WebMessage.downloads(vaild_http);
			// 使用 Gson 把json 转换成 Map
			Gson gson = new Gson();
			Type type = new TypeToken<Map<String, String>>(){}.getType();	
			return gson.fromJson(json, type);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
		
		
}
