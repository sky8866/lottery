package com.sky.modules.lottery.message;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 链接消息
 * @author nukix
 *
 */
public class LinkMessage extends AbstractMessage{

	// 消息标题
	String Title;
	// 消息描述
	String Description;
	// 消息链接
	String Url;
	
	
	@Override
	public void paserXml(Element element) {
		NodeList ToUserName = element.getElementsByTagName("ToUserName");
		NodeList FromUserName = element.getElementsByTagName("FromUserName");
		NodeList CreateTime = element.getElementsByTagName("CreateTime");
		NodeList MsgType = element.getElementsByTagName("MsgType");
		NodeList Title = element.getElementsByTagName("Title");
		NodeList Description = element.getElementsByTagName("Description");
		NodeList Url = element.getElementsByTagName("Url");
		NodeList MsgId = element.getElementsByTagName("MsgId");
		
		this.ToUserName = ToUserName.item(0).getTextContent();
		this.FromUserName = FromUserName.item(0).getTextContent();
		this.CreateTime = Integer.parseInt(CreateTime.item(0).getTextContent());
		this.MsgType = MsgType.item(0).getTextContent();
		this.Title = Title.item(0).getTextContent();
		this.Description = Description.item(0).getTextContent();
		this.Url = Url.item(0).getTextContent();
		this.MsgId = Long.parseLong(MsgId.item(0).getTextContent());
	}

	@Override
	public String sendMessage(Object... args) {
		// 目前没有此类型的发送信息
		return null;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
	
	
}
