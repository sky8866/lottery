package com.sky.modules.lottery.hc.utils;

public class WeChatConfig {

	/**
	 * 服务号相关信息:暂时拿的订阅号的id和secret
	 */
//	public static String APP_ID = "wx601ecf7a8ad12bfb";	//AppID(应用ID)
//	public static String APP_SECRET = "b2597d4f82f5087a3c308ec6c72621d7";	//AppSecret(应用密钥)
	
	//服务号的appid和secret
	public static String APP_ID = "wx9ba5c28ba947a4ef";	//AppID(服务号appID)
	public static String APP_SECRET = "abac5273c65d93fc33ab2c2d34035e2e";	//AppSecret(应用密钥)
	
	public static String APP_ID_APP = "wx18b5416f0d6074c0";//对应app的appId
	public static String APP_SECRET_APP = "2a61a320002ce53cf215b15f3985f128";//对应app的密钥
	
	public static String TOKEN = "xsw";	//服务号的配置token(令牌)
	public final static String PAOWORD_URL = "http://120.24.63.23/wx_api";
	
	public static String PARTNERId_OLD = "1317655201";
	public static String PARTNERKEY_OLD = "NMEPAOWORD1nmepaoword2NMEpaoword";	//PartnerKey(商户密钥)
	public static String PARTNERId = "1334910301";	//PartnerId(商户号)
	public static String PARTNERKEY = "newmindeducationpaodanci12345678";	//PartnerKey(商户密钥)
	
	public final static String SIGN_TYPE = "MD5";//签名加密方式

	// 获取token
	public final static String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APP_ID+"&secret="+APP_SECRET;
	
	public final static String PAOWORDURL = "http://www.paoword.com/";
	
	public final static String PAOWORD_CLUB_URL="http://club.paoword.com:8080/";
	
	//支付回调通知
	public final static String notify_url = "http://www.paoword.com/wechatPay/payNotice";
	
	/**
	 * 微信基础接口地址
	 */
	//获取token接口(GET)
	public final static String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	//oauth2授权接口(GET)
	public final static String OAUTH2_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	//刷新access_token接口（GET）
	public final static String REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	// 菜单创建接口（POST）
	public final static String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	// 菜单查询（GET）
	public final static String MENU_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	// 菜单删除（GET）
	public final static String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	/**
	 * 微信支付接口地址
	 */
	//微信支付统一接口(POST)  
	public final static String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	//微信退款接口(POST)
	public final static String REFUND_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund";
	//订单查询接口(POST)
	public final static String CHECK_ORDER_URL = "https://api.mch.weixin.qq.com/pay/orderquery";
	//关闭订单接口(POST)
	public final static String CLOSE_ORDER_URL = "https://api.mch.weixin.qq.com/pay/closeorder";
	//退款查询接口(POST)
	public final static String CHECK_REFUND_URL = "https://api.mch.weixin.qq.com/pay/refundquery";
	//对账单接口(POST)
	public final static String DOWNLOAD_BILL_URL = "https://api.mch.weixin.qq.com/pay/downloadbill";
	//短链接转换接口(POST)
	public final static String SHORT_URL = "https://api.mch.weixin.qq.com/tools/shorturl";
	//接口调用上报接口(POST)
	public final static String REPORT_URL = "https://api.mch.weixin.qq.com/payitil/report";

}
