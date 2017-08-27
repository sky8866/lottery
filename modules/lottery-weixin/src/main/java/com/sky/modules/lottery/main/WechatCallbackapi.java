package com.sky.modules.lottery.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
 

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken; 
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt; 
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.message.AbstractMessage;
import com.sky.modules.lottery.message.EventMessage;
import com.sky.modules.lottery.message.MessageFactory;
import com.sky.modules.lottery.message.NewsMessage;
import com.sky.modules.lottery.message.TextMessage;
import com.sky.modules.lottery.service.user.MemberManager;
import com.sky.modules.lottery.user.UserInfo;
import com.sky.modules.lottery.utils.weixin.AppContext;
import com.sky.modules.lottery.utils.weixin.SpringInit;
import com.sky.modules.lottery.vo.AccessToken;
  
public class WechatCallbackapi {
 
	
 
	/**
	 * 提供接收和推送给公众平台消息的加解密接口(UTF8编码的字符串).
	 * <ol>
	 * 	<li>第三方回复加密消息给公众平台</li>
	 * 	<li>第三方收到公众平台发送的消息，验证消息的安全性，并对消息进行解密。</li>
	 * </ol>
	 * 说明：异常java.security.InvalidKeyException:illegal Key Size的解决方案
	 * <ol>
	 * 	<li>在官方网站下载JCE无限制权限策略文件（JDK7的下载地址：
	 *      http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html</li>
	 * 	<li>下载后解压，可以看到local_policy.jar和US_export_policy.jar以及readme.txt</li>
	 * 	<li>如果安装了JRE，将两个jar文件放到%JRE_HOME%\lib\security目录下覆盖原来的文件</li>
	 * 	<li>如果安装了JDK，将两个jar文件放到%JDK_HOME%\jre\lib\security目录下覆盖原来文件</li>
	 * </ol>
	 */
	
	private String signature = "94cf3293ce14fae54ab8cade9842409eeecea1db";
	private String timestamp = "1466780620";
	private String nonce = "41201691";
	
	// 用来输出信息
	private PrintWriter out;
	
	// 接收到的 xml (已解密)
	private String requestXml;
	
	/**
	 * 微信确定服务器
	 * @throws IOException 
	 */
	public void decideServer(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 用来输出数据
		this.out = response.getWriter();
		// 获取得到的参数
		  signature = request.getParameter("signature");
		  timestamp = request.getParameter("timestamp");
		  nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		 
		 
		
		// 验证通过后，输出获取到的参数，确定服务器
		if(signature != null && timestamp != null && nonce != null && echostr != null && this.valid(signature, timestamp, nonce)){
		 
			this.out.print(echostr);
		} else {			
			this.out.print("验证失败!");
		}
		this.out.flush();
		this.out.close();
	}
	
	/**
	 * main主要负责获取接收到的数据，如 get 中的参数， post中的xml
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 用来输出数据
		this.out = response.getWriter();
		
		// 读取收到的xml
		InputStream is = request.getInputStream();
		byte []buffer = new byte[1024];
		int len = -1;
		StringBuilder sb = new StringBuilder();
		while((len = is.read(buffer)) != -1){
			sb.append(new String(buffer, 0 ,len));
		}
		// 获取 get 中获取到的参数
				  signature = request.getParameter("signature");
				  timestamp = request.getParameter("timestamp");
				  nonce = request.getParameter("nonce");
			 
		      String xml = sb.toString();
      
	 
		
			
			 
				// 进行解密操作
				requestXml =  xml;
				
				// 如果数据有效， 委托给deal()处理数据
				deal();
			 
		
		this.out.flush();
		this.out.close();
	}
	
//	public static void main(String[] args) {
//		WechatCallbackapi api = new WechatCallbackapi();
//		api.requestXml = "<xml><ToUserName><![CDATA[to]]></ToUserName><FromUserName><![CDATA[from]]></FromUserName><CreateTime>1000</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[subscribe]]></Event><Latitude>10</Latitude><Longitude>01</Longitude><Precision>01</Precision><MsgId>1000</MsgId></xml>";
////		String mingwen = 
////		api.requestXml = api.decode(mingwen)
//		api.requestXml = "<xml><Encrypt><![CDATA[dTrgX9UbOQ/bzdP2Fm2MpD4PsaFOdXkSCpmPw/0r7rvfbfDYAFKFxjHzzQ0N9xStbvCwTUGTjw/MGRYTR5RwzizZiavFPgPXZbjgnaDjVeFJY+QSY+KElLq7bgWNrLzPmM907hevTfabwzw8GjdmOpj1dH0dExLYmK3j07qy9jNPXxKjpWxNT/adpshSHcKOuw2joZiQRxPxT2TwqQ5sRgAfaZ2DYzP+fgJCVsbhdpfJkt1Z1Hw8fXTEEaCIRcwYgeu0Cwh2zNVVH6iXOlaCo8dImWZYI4IpB+RR4e0/2ShqBYgaRdsl/MphezRJUAqeGc8bJDBa+oCh3IyqqggMRfRyeBJSRJJZpUVkSdsgk1aO9w8lvyRTdc1EnbmAJv1CnBnPfpG2PcSEZ5aryIArJILabFpLDA7BTq89LXwWYnZGFyK2UvBaVk9A4JarNlsJ5b7e3qHR6JleCMnRZKTVdw==]]></Encrypt><MsgSignature><![CDATA[3c069c7d62040348deaca3e13d4bf94dab8213c5]]></MsgSignature><TimeStamp>1444125026</TimeStamp><Nonce><![CDATA[1408619926]]></Nonce></xml>";
//		api.requestXml = api.decode(api.requestXml);
//		System.out.println(api.requestXml);
//		api.deal(null);
//	}
	
	private void deal(){
		Calendar calendar = Calendar.getInstance();
		long nowTime = calendar.getTimeInMillis();
		
		MessageFactory factory = new MessageFactory();
		
		// 使用工厂创建对应的消息类
		AbstractMessage message = null;
		
		try{
			message = factory.createMessage(this.requestXml);
			 
			
			
			if (message == null) {
				throw new RuntimeException("工厂没有进行相对应的初始化!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
 	 
		
		// 获取 MsgType 的值，判断是什么消息， 进行相对应的操作
		String type = message.getMsgType();
		 
		if (type.equals("text")) {
			
		} else if (type.equals("image")) {
			
		} else if (type.equals("voice")) {
			
		} else if (type.equals("video") || type.equals("shortvideo")) {
			
		} else if (type.equals("location")) {
			
		} else if (type.equals("link")) {
			
		} else if (type.equals("event")) {
			EventMessage event = (EventMessage) message;
			
			if (event.getEvent().equals("subscribe")) {
				// 订阅
				NewsMessage textMessage = new NewsMessage(); 
				String eveentKeyString=event.getEventKey();
				 
				 
				// 获取用户信息
		 	UserInfo user = new UserInfo(event.getFromUserName());
				
				//头像信息：
				 String userPictureUrl=user.getHeadimgurl();
				//昵称信息：
			 	String userName=user.getNickname();
			 	String userOpenId=user.getOpenid(); 
			 	String unionid=user.getUnionid(); 
			 	String remark=user.getRemark();
			 	String groupid=user.getGroupid();
					
			 MemberManager  userService = (MemberManager)SpringInit.getApplicationContext().getBean("memberManager");
               
			 
				 userService.addUserGuanZhu(userOpenId, userPictureUrl, userName,unionid,remark,groupid,eveentKeyString);
			    
			
				 Object []args = new String[]{ event.getFromUserName(), event.getToUserName(),
							nowTime + "", "news", "4",
							"烨轩云规律软件--通过收集历史开奖数据，进行大数据算法的分析得出规律仓库，然后再经过数据模型建模，最终得出规律结果",
							"本软件通过收集历史开奖数据，进行大数据算法的分析得出规律仓库，然后再经过数据模型建模，最终得出规律结果。这些结果有，“本期排除”，“历史全对”，“权限搜索”等功能。",
							"https://mmbiz.qlogo.cn/mmbiz_jpg/UZYaUgo8jGH2AibcyticwiaRMrh2wg2bmebP94vCHwJ16jflUpgnrHp1lnp6bqjASsk6icoqR86X64hcI5ZjMRG1hw/0?wx_fmt=jpeg",
							"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9ba5c28ba947a4ef&redirect_uri=http://www.yaogama.com/system/guilv/sum_error&response_type=code&scope=snsapi_base&state=123#wechat_redirect",
							"“本期排除”是通过几百万条规律中分析而得出最有可能在当期会断的规律。",
							"本期排除是通过几百万条规律分析而得出最有可能在当期会断的规律。",
							"https://mmbiz.qlogo.cn/mmbiz/UZYaUgo8jGFmj4tIyj4I7m6rFRv6JUZN8rZQGanoexCGJcWGXj2UGI8VbLyL0zStbskqibesuEJ0f1RLF7yibP8Q/0?wx_fmt=png",
							"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9ba5c28ba947a4ef&redirect_uri=http://www.yaogama.com/system/guilv/sum_error&response_type=code&scope=snsapi_base&state=123#wechat_redirect",
							"“历史全对”，此功能是在特定的多个位置上，在历史的开奖记录中，都会出现特定的几个数字",
							"此功能是在特定的多个位置上，在历史的开奖记录中，都会出现特定的几个数字",
							"https://mmbiz.qlogo.cn/mmbiz/UZYaUgo8jGFmj4tIyj4I7m6rFRv6JUZN453oVDIEbHH2WqaWuppR2RiaBPbdtpB1Xu0ViatxiaEFibxVNdfv6HLwrA/0?wx_fmt=png",
							"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9ba5c28ba947a4ef&redirect_uri=http://www.yaogama.com/system/guilv/limit2&response_type=code&scope=snsapi_base&state=123#wechat_redirect",
							"“权限规”，表示已经错好多期了，达到历史权限近两期可以考虑参考出现的范围数。",
							"权限规表示已经错好多期了，达到历史权限近两期可以考虑参考出现的范围数。",
							"https://mmbiz.qlogo.cn/mmbiz/UZYaUgo8jGFmj4tIyj4I7m6rFRv6JUZNs69uicTzMUE11icUUE9Uh8Byicusy5ZkicbIM1ribcHX6ancECp5UJJzeicw/0?wx_fmt=png",
							"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9ba5c28ba947a4ef&redirect_uri=http://www.yaogama.com/system/guilv/limit&response_type=code&scope=snsapi_base&state=123#wechat_redirect" };
					 
				// 加密
				String xml = textMessage.sendMessage(args);
				
			 
				// 打印 xml
				this.out.print(xml);
			} else if (event.getEvent().equals("unsubscribe")) {
				// 取消订阅， 取消订阅之后，用户接收不到信息
				 
			} else if (event.getEvent().equalsIgnoreCase("click")) {
				// 点击事件
				if (event.getEventKey().equals("V1001_Phone")) {
					// 联系客服
					TextMessage textMessage = new TextMessage();
					Object []args = new String[]{ event.getFromUserName(), event.getToUserName(),
							nowTime + "", "news", "1","testTitle","testDescription","","" };
					 
					// 加密
					String xml = textMessage.sendMessage(args);
					
					// 打印 xml
					this.out.print(xml);
				}
				
			}
			
		}
		
	}
	
	
	// 验证是否有效
	public boolean valid(String signature, String timestamp, String nonce){
		try {
			if (checkSignature(signature, timestamp, nonce)) {
				
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * 写文件
	 * @param message
	 * @throws IOException
	 */
	public static void writeFile(String message) throws IOException{
		File file = new File("c://debug.txt");
		FileOutputStream fos = new FileOutputStream(file);
		
		byte[] buffer = message.getBytes();
		fos.write(buffer, 0, buffer.length);
		fos.flush();
		fos.close();
	}
	
	
	
	/**
	 * 加密
	 * @param replyMsg 需要加密的内容
	 * @return 加密后的字符串
	 */
	public String encrypt(String replyMsg){
		try {
			WXBizMsgCrypt pc = new WXBizMsgCrypt(Constant.TOKEN, 
					Constant.encodingAesKey, Constant.appId);
			String mingwen = pc.encryptMsg(replyMsg, this.timestamp, this.nonce);
			return mingwen;
		} catch (AesException e) {
			e.printStackTrace();
			return "加密失败!";
		}
	}
	
	/**
	 * 解密
	 * @param mingwen 需要解密的内容
	 * @return	解密的结果
	 */
	public String decode(String mingwen){
		try{
			WXBizMsgCrypt pc = new WXBizMsgCrypt(Constant.TOKEN,
					Constant.encodingAesKey, Constant.appId);
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(mingwen);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);
			
			Element root = document.getDocumentElement();
			NodeList nodeList1 = root.getElementsByTagName("Encrypt");
			NodeList nodeList2 = root.getElementsByTagName("MsgSignature");
			
			String encrypt = nodeList1.item(0).getTextContent();
//			String msgSignature = nodeList2.item(0).getTextContent();
			String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
			String fromXML = String.format(format, encrypt);
			// 由于这里没有给出msgSignature， 所以采取先加密，再解密
			String result = pc.decryptMsg(getMsgSignature(encrypt), this.timestamp, 
					this.nonce, fromXML);
			return result;
		} catch (Exception e){
			e.printStackTrace();
			return "解密失败!"+e.getMessage();
		}
	}
	
	/**
	 * 获取解密的第二个属性
	 * @param encrypt
	 * @return
	 */
	private String getMsgSignature (String encrypt) {
		String []tmpArr = new String[] { Constant.TOKEN, this.timestamp, this.nonce ,encrypt };
		// 对数组进行排序
		Arrays.sort(tmpArr);
		// 把数组转成字符串
		StringBuilder sb = new StringBuilder();
		for (String tmp : tmpArr) {
			sb.append(tmp);
		}
		String tmpStr = sb.toString();
		// 对数据进行sha1加密
		tmpStr = SHA1(tmpStr);
		return tmpStr;
	}
	
	// 检测签名
	private boolean checkSignature(String signature, String timestamp,
			String nonce) throws Exception{
		if(Constant.TOKEN == null){
			throw new Exception("TOKEN is not defined!");
		}
		this.signature = signature;
		this.timestamp = timestamp;
		this.nonce = nonce;
		
		String []tmpArr = new String[] { Constant.TOKEN, this.timestamp, this.nonce };
		// 对数组进行排序
		Arrays.sort(tmpArr);
		// 把数组转成字符串
		StringBuilder sb = new StringBuilder();
		for (String tmp : tmpArr) {
			sb.append(tmp);
		}
		String tmpStr = sb.toString();
		
		// 对数据进行sha1加密
		tmpStr = SHA1(tmpStr);
		 
		if (tmpStr.equals(signature)) {
			 
			return true;
		} else {
			return false;
		}
	}
	
	// SHA1 加密
	public String SHA1(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
	
	/**
	 * 获取微信的access_token, access_token有效时间为2小时(每天最多调用2000次)
	 * @return
	 * 成功: {"access_token":"ACCESS_TOKEN","expires_in":7200}
	 * 失败: {"errcode":40013,"errmsg":"invalid appid"}
	 * 运行异常: null
	 */
	public static Map<String, String> getAccessToken(){
		InputStream input = null;
		try {
			final String http = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
					+ Constant.appId + "&secret=" + Constant.AppSecret;
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
				sb.append(new String(buffer, 0, len));
			}
			input.close();
			 
			final String accessTokenjson = sb.toString();
			// 使用 Gson 把 json 转换成 Map
			Gson gson = new Gson();
			Type type = new TypeToken<Map<String, String>>(){}.getType();
			Map<String, String> map = gson.fromJson(accessTokenjson, type);
			return map;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String accesstoken;
	
	/**
	 * 返回 accessToken 字符串
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static String getAccessTokenString() throws FileNotFoundException, IOException, ClassNotFoundException{
		File ser = new File("AccessToken.ser");
		
		Map<String, String> map = WechatCallbackapi.getAccessToken();
		 
		accesstoken = map.get("access_token");
	/* if (ser.exists()) {
			
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(ser));
			 
			AccessToken accessToken = (AccessToken) ois.readObject();
		 
			ois.close();
			Calendar calendar = Calendar.getInstance();
			// 使用当前时间戳减去保存数据时的时间戳，算出剩下的时间
			if ((calendar.getTimeInMillis() - accessToken.getTime()) > 420*1000) {
				// 当超过了420秒之后，更新数据
				Map<String, String> map = WechatCallbackapi.getAccessToken();
				accesstoken = map.get("access_token");
				accessToken.setTime(calendar.getTimeInMillis());
				accessToken.setAccessToken(accesstoken);
				
				ObjectOutputStream oos = new ObjectOutputStream(
						new FileOutputStream(ser));
				oos.writeObject(accessToken);
				oos.flush();
				oos.close();
			} else {
				// 时间有效，直接使用该值
				accesstoken = accessToken.getAccessToken();
			}
		} else { 
			
			// 首次使用，进行初始化
			Map<String, String> map = WechatCallbackapi.getAccessToken();
			 
			accesstoken = map.get("access_token");
			Calendar calendar = Calendar.getInstance();
			AccessToken accessToken = new AccessToken(accesstoken, calendar.getTimeInMillis());
			
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(ser));
			oos.writeObject(accessToken);
			oos.flush();
			oos.close();
	 	}*/
		
		 
		return accesstoken;
	}
	
	/**
	 * 获取微信服务器IP地址
	 * @param access_token
	 * @return
	 * 成功: "ip_list":["127.0.0.1","127.0.0.1"] 即?需要转成List<String>
	 * 失败: {"errcode":40013,"errmsg":"invalid appid"} 即?需要转成String
	 * 运行异常: null
	 */
	public static Map<String, ?> getIpAddrList(String access_token){
		InputStream input = null;
		try{
			String ip_http = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=" + access_token;
	        URL url = new URL(ip_http);
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
				sb.append(new String(buffer, 0, len));
			}
			final String ip_list_json = sb.toString();
			Gson gson = new Gson();
			if (ip_list_json.indexOf("ip_list") != -1) {
				// 获取成功
				Type type = new TypeToken<Map<String, List<String>>>(){}.getType();
				Map<String, List<String>> map = gson.fromJson(ip_list_json, type);
				return map;
			} else {
				// 获取失败
				Type type = new TypeToken<Map<String, String>>(){}.getType();
				Map<String, String> map = gson.fromJson(ip_list_json, type);
				return map;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	
}
