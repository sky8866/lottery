package com.sky.modules.lottery.hc.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WeChatUtil {

	private static Logger log = LoggerFactory.getLogger(WeChatUtil.class);
	//获取ticket
    public final static String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+WeChatUtil.getToken();
	
    
    /**
	 * 获取token
	 * @return
	 */
	public static String getToken(){
		Token token = WeChatUtil.getToken("APPID", "APPSECRET");
		return token.getAccessToken();
	}
    
    /**
	   * 获取接口访问凭证
	   * 
	   * @param appid 凭证
	   * @param appsecret 密钥
	   * @return
	   */
	public static Token getToken(String appid, String appsecret) {
	    Token token = null;
	    String requestUrl = WeChatConfig.token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
	    // 发起GET请求获取凭证
	    JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
	    if (null != jsonObject) {
	      try {
	        token = new Token();
	        token.setAccessToken(jsonObject.getString("access_token"));
	        token.setExpiresIn(jsonObject.getInt("expires_in"));
	      } catch (JSONException e) {
	        token = null;
	        // 获取token失败
	        log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
	      }
	    }
	    return token;
	  }
	
	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr 提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

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
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			log.error("Weixin server connection timed out.");
		} catch (Exception e) {
			log.error("https request error:{}", e);
		}
		return jsonObject;
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
	 * 取出一个指定长度大小的随机正整数.
	 * 
	 * @param length
	 *            int 设定所取出随机数的长度。length小于11
	 * @return int 返回生成的随机数。
	 */
	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}
	
	/**
	 * 时间戳
	 */
	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}
	
	
	
	/**
	 * 微信公众号支付
	 * 获取预支付id
	 * @param request
	 * @param openid
	 * @param totalTradeCode
	 * @param totalPrice
	 * @param notify_url
	 * @return
	 */
	public String getPrepayId(HttpServletRequest request,String openid,String user_id,String product_name,String totalPrice,String notify_url){
		//生成随机字符串
		String currTime = WeChatPayUtil.getCurrTime();
		String strTime = currTime.substring(8, currTime.length());
		String strRandom = WeChatPayUtil.buildRandom(8) + "";
		String strReq = currTime + strRandom;

		//随机字符串
		String nonce_str = strReq;

		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("appid", WeChatConfig.APP_ID);
		treeMap.put("mch_id", WeChatConfig.PARTNERId);
		treeMap.put("nonce_str", nonce_str);	//随机字符串(用于生成签名)
		/**/
		
		if (product_name!=null && !product_name.equals("")) {
			if (product_name.equals("泡单词会员3个月")) {
				treeMap.put("body", "泡单词会员3个月");
				treeMap.put("attach", "3"+user_id);        //user_id 和   产品名称 
			}else if(product_name.equals("泡单词会员6个月")){
				treeMap.put("body", "泡单词会员6个月");
				treeMap.put("attach", "2"+user_id);        //user_id 和   产品名称 
			}else {
				treeMap.put("body", "泡单词会员12个月");
				treeMap.put("attach", "1"+user_id);        //user_id 和   产品名称 
			}
		}
		
		treeMap.put("out_trade_no", strReq);    //订单号  时间+8位随机数
		treeMap.put("total_fee", totalPrice);	//支付金额
		/**/
		treeMap.put("spbill_create_ip", request.getRemoteAddr());	//用户ip
		treeMap.put("trade_type", "JSAPI");	//页面调用接口形式
		treeMap.put("notify_url", notify_url);	//接收微信支付异步通知回调地址
		treeMap.put("openid", openid);	//openid
		 
		StringBuilder sb = new StringBuilder();
		for (String key : treeMap.keySet()) {
			sb.append(key).append("=").append(treeMap.get(key)).append("&");
		}
		sb.append("key=" + WeChatConfig.PARTNERKEY);
		String sign = MD5Util.MD5Encode(sb.toString(), "utf-8").toUpperCase();
		treeMap.put("sign", sign);
		StringBuilder xml = new StringBuilder();
		xml.append("<xml>\n");
		for (Map.Entry<String, String> entry : treeMap.entrySet()) {
			if ("body".equals(entry.getKey()) || "sign".equals(entry.getKey())) {
				xml.append("<" + entry.getKey() + "><![CDATA[").append(entry.getValue()).append("]]></" + entry.getKey() + ">\n");
			} else {
				xml.append("<" + entry.getKey() + ">").append(entry.getValue()).append("</" + entry.getKey() + ">\n");
			}
		}
		xml.append("</xml>");


		System.out.println("==>xml:"+xml.toString());


		// 创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		// HttpClient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		HttpPost httpPost = new HttpPost(WeChatConfig.UNIFIED_ORDER_URL);
		StringEntity entity;
		try {
			entity = new StringEntity(xml.toString(), "utf-8");
			httpPost.setEntity(entity);
			HttpResponse httpResponse;
			// post请求
			httpResponse = closeableHttpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			if (httpEntity != null) {
				System.out.println("###httpEntity:"+httpEntity);
				// 打印响应内容
				String result = EntityUtils.toString(httpEntity, "UTF-8");
				System.out.println("###result:"+result);
				// 过滤
				result = result.replaceAll("<![CDATA[|]]>", "");
				String prepay_id = Jsoup.parse(result).select("prepay_id").html();
				if (prepay_id != null&&!prepay_id.isEmpty()){
					System.out.println("###prepay_id："+prepay_id);
					return prepay_id;
				}
			}
			// 释放资源
			closeableHttpClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * ios微信app支付
	 * 获取预支付id
	 * @param request
	 * @param openid
	 * @param totalTradeCode
	 * @param totalPrice
	 * @param notify_url
	 * @return
	 */
	public String getPrepayIdOfIOS(HttpServletRequest request,String user_id,String product_id,String product_price,String notify_url){
		//生成随机字符串
		String currTime = WeChatPayUtil.getCurrTime();
		String strTime = currTime.substring(8, currTime.length());
		String strRandom = WeChatPayUtil.buildRandom(8) + "";
		String strReq = currTime + strRandom;

		//随机字符串
		String nonce_str = strReq;

		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("appid", WeChatConfig.APP_ID_APP);//对应app的appid,不是公众号的
		treeMap.put("mch_id", WeChatConfig.PARTNERId_OLD);//商户号
		treeMap.put("nonce_str", nonce_str);	//随机字符串(用于生成签名)
		/**/
		
		if (product_id!=null && !product_id.equals("")) {
			if (product_id.equals("1")) {
				treeMap.put("body", "泡单词会员3个月");
				treeMap.put("attach", "1"+user_id);        //user_id 和   产品类型
				treeMap.put("total_fee", "9000");	     //支付金额
//				treeMap.put("total_fee", "1");	     //支付金额
			}else if(product_id.equals("2")){
				treeMap.put("body", "泡单词会员6个月");
				treeMap.put("attach", "2"+user_id);     
				treeMap.put("total_fee", "15000");	     //支付金额
			}else {
				treeMap.put("body", "泡单词会员12个月");
				treeMap.put("attach", "3"+user_id);       
				treeMap.put("total_fee", "24000");	     //支付金额
			}
		}
		
		treeMap.put("out_trade_no", strReq);   //订单号  时间+8位随机数
		/**/
		//request.getRemoteAddr()  获取本地ip
		treeMap.put("spbill_create_ip", "127.0.0.1");	//用户终端实际ip
		treeMap.put("trade_type", "APP");	    //APP
		treeMap.put("notify_url", notify_url);	//接收微信支付异步通知回调地址
		 
		StringBuilder sb = new StringBuilder();
		for (String key : treeMap.keySet()) {
			sb.append(key).append("=").append(treeMap.get(key)).append("&");
		}
		sb.append("key=" + WeChatConfig.PARTNERKEY_OLD);//生成签名
		String sign = MD5Util.MD5Encode(sb.toString(), "utf-8").toUpperCase();
		
		treeMap.put("sign", sign);
		StringBuilder xml = new StringBuilder();
		xml.append("<xml>\n");
		for (Map.Entry<String, String> entry : treeMap.entrySet()) {
			if ("body".equals(entry.getKey()) || "sign".equals(entry.getKey())) {
				xml.append("<" + entry.getKey() + "><![CDATA[").append(entry.getValue()).append("]]></" + entry.getKey() + ">\n");
			} else {
				xml.append("<" + entry.getKey() + ">").append(entry.getValue()).append("</" + entry.getKey() + ">\n");
			}
		}
		xml.append("</xml>");


		System.out.println("==>xml:"+xml.toString());


		// 创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		// HttpClient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		HttpPost httpPost = new HttpPost(WeChatConfig.UNIFIED_ORDER_URL);//微信支付统一接口(POST) 
		StringEntity entity;
		try {
			entity = new StringEntity(xml.toString(), "utf-8");
			httpPost.setEntity(entity);
			HttpResponse httpResponse;
			// post请求
			httpResponse = closeableHttpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			if (httpEntity != null) {
				System.out.println("===>httpEntity:"+httpEntity);
				// 打印响应内容
				String result = EntityUtils.toString(httpEntity, "UTF-8");
				System.out.println("===>result:"+result);
				// 过滤
				result = result.replaceAll("<![CDATA[|]]>", "");
				String prepay_id = Jsoup.parse(result).select("prepay_id").html();
				if (prepay_id != null&&!prepay_id.isEmpty()){
					System.out.println("====>prepay_id："+prepay_id);
					return prepay_id;
				}
			}
			// 释放资源
			closeableHttpClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/**
	 * 解析json数据
	 * @param url
	 * @param httpMethod
	 * @return
	 */
	public static String getJson(String url,String httpMethod){
		// 创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		//httpclient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		try {
			HttpResponse httpResponse;
			//判断请求方式
			if(httpMethod.equals("get")){
				HttpGet httpGet = new HttpGet(url);
				httpResponse = closeableHttpClient.execute(httpGet);
			}else if(httpMethod.equals("post")){
				HttpPost httpPost = new HttpPost(url);
				httpResponse = closeableHttpClient.execute(httpPost);
			}else{
				return null;
			}
			
			HttpEntity httpEntity = httpResponse.getEntity();
			if (httpEntity != null) {
				String result = EntityUtils.toString(httpEntity, "UTF-8");
				return result;
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				closeableHttpClient.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	
	
	/**
	 * 签名
	 * @param signParams
	 * @return
	 * @throws Exception
	 */
	public static String createSHA1Sign(SortedMap<String, String> signParams) throws Exception {
		StringBuffer sb = new StringBuffer();
		Set es = signParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			sb.append(k + "=" + v + "&");
			//要采用URLENCODER的原始值！
		}
		String params = sb.substring(0, sb.lastIndexOf("&"));
//		System.out.println("sha1之前:" + params);
//		System.out.println("SHA1签名为："+getSha1(params));
		return getSha1(params);
	}
	
	/**
	 * md5签名
	 * @param buffer
	 * @return
	 */
	public final static String getMessageDigest(byte[] buffer) {
 	   char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
 	   try {
 	      MessageDigest mdTemp = MessageDigest.getInstance("MD5");
 	      mdTemp.update(buffer);
 	      byte[] md = mdTemp.digest();
 	      int j = md.length;
 	      char str[] = new char[j * 2];
 	      int k = 0;
 	      for (int i = 0; i < j; i++) {
 	         byte byte0 = md[i];
 	         str[k++] = hexDigits[byte0 >>> 4 & 0xf];
 	         str[k++] = hexDigits[byte0 & 0xf];
 	      }
 	      return new String(str);
 	   } catch (Exception e) {
 	      return null;
 	   }
 	}
	
	
	//Sha1签名
	public static String getSha1(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };

		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes("GBK"));

			byte[] md = mdTemp.digest();
			int j = md.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	/** 
	* 解析出url请求的路径，包括页面 
	* @param strURL url地址 
	* @return url路径 
	*/ 
	public static String UrlPage(String strURL) { 
		String strPage=null; 
		String[] arrSplit=null; 
		strURL=strURL.trim().toLowerCase(); 
		arrSplit=strURL.split("[?]"); 
		if(strURL.length()>0){ 
			if(arrSplit.length>1){ 
				if(arrSplit[0]!=null) { 
					strPage=arrSplit[0]; 
				} 
			} 
		} 
		return strPage; 
	} 
	
	/** 
	* 去掉url中的路径，留下请求参数部分 
	* @param strURL url地址 
	* @return url请求参数部分 
	*/ 
	private static String TruncateUrlPage(String strURL) { 
		String strAllParam=null; 
		String[] arrSplit=null; 
		strURL=strURL.trim().toLowerCase(); 
		arrSplit=strURL.split("[?]"); 
		if(strURL.length()>1){ 
			if(arrSplit.length>1){ 
				if(arrSplit[1]!=null) { 
					strAllParam=arrSplit[1]; 
				} 
			} 
		} 
		return strAllParam; 
	} 
	
	
	/** 
	* 解析出url参数中的键值对 
	* 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中 
	* @param URL url地址 
	* @return url请求参数部分 
	*/ 
	public static Map<String, String> URLRequest(String URL){ 
		Map<String, String> mapRequest = new HashMap<String, String>(); 
		String[] arrSplit=null; 
		String strUrlParam=TruncateUrlPage(URL); 
		if(strUrlParam==null) { 
			return mapRequest; 
		} 
		//每个键值为一组 
		arrSplit=strUrlParam.split("[&]"); 
		for(String strSplit:arrSplit){ 
			String[] arrSplitEqual=null; 
			arrSplitEqual= strSplit.split("[=]"); 
			//解析出键值 
			if(arrSplitEqual.length>1) { 
				//正确解析 
				mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]); 
			}else{ 
				if(arrSplitEqual[0]!="") { 
					//只有参数没有值，不加入 
					mapRequest.put(arrSplitEqual[0], ""); 
				} 
			} 
		} 
		return mapRequest; 
	} 

	/**
	 * 验证签名
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String signature, String timestamp, String nonce) {
		String[] arr = new String[] { WeChatConfig.TOKEN, timestamp, nonce };
		// 将token、timestamp、nonce三个参数进行字典序排序
		Arrays.sort(arr);
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}
		MessageDigest md = null;
		String tmpStr = null;

		try {
			md = MessageDigest.getInstance("SHA-1");
			// 将三个参数字符串拼接成一个字符串进行sha1加密
			byte[] digest = md.digest(content.toString().getBytes());
			tmpStr = byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		content = null;
		// 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
		return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
	}
	
	/**
	 * 将字节数组转换为十六进制字符串
	 * 
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}

	/**
	 * 将字节转换为十六进制字符串
	 * 
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];

		String s = new String(tempArr);
		return s;
	}
	
	/**
	 * 判断编码类型
	 * @param str
	 * @return
	 */
	 public static String getEncoding(String str) {    
         String encode = "GB2312";    
        try {    
            if (str.equals(new String(str.getBytes(encode), encode))) {    
                 String s = encode;    
                return s;    
             }    
         } catch (Exception exception) {    
         }    
         encode = "ISO-8859-1";    
        try {    
            if (str.equals(new String(str.getBytes(encode), encode))) {    
                 String s1 = encode;    
                return s1;    
             }    
         } catch (Exception exception1) {    
         }    
         encode = "UTF-8";    
        try {    
            if (str.equals(new String(str.getBytes(encode), encode))) {    
                 String s2 = encode;    
                return s2;    
             }    
         } catch (Exception exception2) {    
         }    
         encode = "GBK";    
        try {    
            if (str.equals(new String(str.getBytes(encode), encode))) {    
                 String s3 = encode;    
                return s3;    
             }    
         } catch (Exception exception3) {    
         }    
        return "";    
     }    

}

