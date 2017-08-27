package com.sky.modules.lottery.message;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 文本消息
 * @author nukix
 *
 */
public class TextMessage extends AbstractMessage {

	// 文本消息内容
	String Content;

	@Override
	public void paserXml(Element element) {
		NodeList ToUserName = element.getElementsByTagName("ToUserName");
		NodeList FromUserName = element.getElementsByTagName("FromUserName");
		NodeList CreateTime = element.getElementsByTagName("CreateTime");
		NodeList MsgType = element.getElementsByTagName("MsgType");
		NodeList Content = element.getElementsByTagName("Content");
		NodeList MsgId = element.getElementsByTagName("MsgId");
		
		this.ToUserName = ToUserName.item(0).getTextContent();
		this.FromUserName = FromUserName.item(0).getTextContent();
		this.CreateTime = Integer.parseInt(CreateTime.item(0).getTextContent());
		this.MsgType = MsgType.item(0).getTextContent();
		this.Content = Content.item(0).getTextContent();
		this.MsgId = Long.parseLong(MsgId.item(0).getTextContent());
	}

	/**
	 * 文本消息:
	 * @param ToUserName	必须		接收方帐号（收到的OpenID）
	 * @param FromUserName	必须		开发者微信号
	 * @param CreateTime	必须		消息创建时间 （整型）
	 * @param MsgType		必须		text
	 * @param Content		必须		回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
	 */
	@Override
	public String sendMessage(Object ... args) {
		String format = "<xml><ToUserName><![CDATA[%1$s]]></ToUserName><FromUserName><![CDATA[%2$s]]></FromUserName><CreateTime>%3$s</CreateTime><MsgType><![CDATA[%4$s]]></MsgType><Content><![CDATA[%5$s]]></Content></xml>";
		if(args == null || args.length != 5){
			throw new IllegalArgumentException("发送文本消息失败, 参数必须有5个!");
		}
		return String.format(format, args[0], args[1], args[2], args[3], args[4]);
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	
}
