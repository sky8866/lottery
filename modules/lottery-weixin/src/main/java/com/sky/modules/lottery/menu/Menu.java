package com.sky.modules.lottery.menu;

/**
 * 菜单项
 * 注：
 * 1、自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。
 * 2、一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替。
 * 3、创建自定义菜单后，由于微信客户端缓存，需要24小时微信客户端才会展现出来。
	     测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。
	     
 * 1、click：点击推事件
 * 用户点击click类型按钮后，微信服务器会通过消息接口推送消息类型为event的结构给开发者（参考消息接口指南），并且带上按钮中开发者填写的key值，开发者可以通过自定义的key值与用户进行交互；
 * 2、view：跳转URL
 * 用户点击view类型按钮后，微信客户端将会打开开发者在按钮中填写的网页URL，可与网页授权获取用户基本信息接口结合，获得用户基本信息。
 * 3、scancode_push：扫码推事件
 * 用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后显示扫描结果（如果是URL，将进入URL），且会将扫码的结果传给开发者，开发者可以下发消息。
 * 4、scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框
 * 用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后，将扫码的结果传给开发者，同时收起扫一扫工具，然后弹出“消息接收中”提示框，随后可能会收到开发者下发的消息。
 * 5、pic_sysphoto：弹出系统拍照发图
 * 用户点击按钮后，微信客户端将调起系统相机，完成拍照操作后，会将拍摄的相片发送给开发者，并推送事件给开发者，同时收起系统相机，随后可能会收到开发者下发的消息。
 * 6、pic_photo_or_album：弹出拍照或者相册发图
 * 用户点击按钮后，微信客户端将弹出选择器供用户选择“拍照”或者“从手机相册选择”。用户选择后即走其他两种流程。
 * 7、pic_weixin：弹出微信相册发图器
 * 用户点击按钮后，微信客户端将调起微信相册，完成选择操作后，将选择的相片发送给开发者的服务器，并推送事件给开发者，同时收起相册，随后可能会收到开发者下发的消息。
 * 8、location_select：弹出地理位置选择器
 * 用户点击按钮后，微信客户端将调起地理位置选择工具，完成选择操作后，将选择的地理位置发送给开发者的服务器，同时收起位置选择工具，随后可能会收到开发者下发的消息。
 * 9、media_id：下发消息（除文本消息）
 * 用户点击media_id类型按钮后，微信服务器会将开发者填写的永久素材id对应的素材下发给用户，永久素材类型可以是图片、音频、视频、图文消息。请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
 * 10、view_limited：跳转图文消息URL
 * 用户点击view_limited类型按钮后，微信客户端将打开开发者在按钮中填写的永久素材id对应的图文消息URL，永久素材类型只支持图文消息。请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
 * 
 * 参数			是否必须								说明
 * button		是									一级菜单数组，个数应为1~3个
 * sub_button	否									二级菜单数组，个数应为1~5个
 * type			是									菜单的响应动作类型
 * name			是									菜单标题，不超过16个字节，子菜单不超过40个字节
 * key			click等点击类型必须					菜单KEY值，用于消息接口推送，不超过128字节
 * url			view类型必须							网页链接，用户点击菜单可打开链接，不超过256字节
 * media_id		media_id类型和view_limited类型必须	调用新增永久素材接口返回的合法media_id
 * 
 * @author nukix
 */
public class Menu {
/* 	
 * {
 		"button":[
 			{
 			 
 			"name":"七星规",
 			"sub_button":[
 			
 			{
 					"type":"view",
 					"name":"推送码",
 					"url":"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9ba5c28ba947a4ef&redirect_uri=http://www.yaogama.com/system/yexuan/qxc/plan&response_type=code&scope=snsapi_base&state=123#wechat_redirect"
 				},
		 
 		{
 					"type":"view",
 					"name":"极限",
 					"url":"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9ba5c28ba947a4ef&redirect_uri=http://www.yaogama.com/system/yexuan/limit&response_type=code&scope=snsapi_base&state=123#wechat_redirect"
 				}  
 				,	 {
 					"type":"view",
 					"name":"历史全对",
 					"url":"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9ba5c28ba947a4ef&redirect_uri=http://www.yaogama.com/system/yexuan/limit2&response_type=code&scope=snsapi_base&state=123#wechat_redirect"
 				},	 
 			    {
 					"type":"view",
 					"name":"本期排除",
 					"url":"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9ba5c28ba947a4ef&redirect_uri=http://www.yaogama.com/system/yexuan/sum_error&response_type=code&scope=snsapi_base&state=123#wechat_redirect"
 				}			 
 				 	  
 			]
 		},
 		{
 			 
 			"name":"高频规",
 			"sub_button":[
 			 {
 					"type":"view",
 					"name":"排列5排除",
 					"url":"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9ba5c28ba947a4ef&redirect_uri=http://www.yaogama.com/system/yexuan/pl5/sum_error&response_type=code&scope=snsapi_base&state=123#wechat_redirect"
 				},{
 					"type":"view",
 					"name":"重庆排除",
 					"url":"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9ba5c28ba947a4ef&redirect_uri=http://www.yaogama.com/system/yexuan/cq/sum_error&response_type=code&scope=snsapi_base&state=123#wechat_redirect"
 				},{
 					"type":"view",
 					"name":"重庆计划",
 					"url":"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9ba5c28ba947a4ef&redirect_uri=http://www.yaogama.com/system/yexuan/ssc/plan&response_type=code&scope=snsapi_base&state=123#wechat_redirect"
 				},{
 					"type":"view",
 					"name":"排列5计划",
 					"url":"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9ba5c28ba947a4ef&redirect_uri=http://www.yaogama.com/system/yexuan/pl5/plan&response_type=code&scope=snsapi_base&state=123#wechat_redirect"
 				}
 				      
 				
 			]
 		},
 		{
 			"name":"我的",
 			"sub_button":[
 			 {
 					"type":"view",
 					"name":"个人中心",
 					"url":"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9ba5c28ba947a4ef&redirect_uri=http://www.yaogama.com/system/user/ticket&response_type=code&scope=snsapi_base&state=123#wechat_redirect"
 				},
 				  {
 					"type":"view",
 					"name":"新手指南",
 					"url":"http://www.yaogama.com/help/index.html"
 				},
 				 	
 				{
 				"type":"view",
 				"name":"关于我们",
 					"url":"http://www.yaogama.com/system/about"
 				},
 				 	
 				{
 				"type":"view",
 				"name":"加入会员",
 					"url":"https://weidian.com/s/1195040998?wfr=c&ifr=shopdetail"
 				}
 			]
 		}]
 	}*/
}
