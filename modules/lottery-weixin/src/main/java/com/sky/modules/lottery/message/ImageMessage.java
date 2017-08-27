package com.sky.modules.lottery.message;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 图片消息
 * @author nukix
 *
 */
public class ImageMessage extends AbstractMessage{

	// 图片链接
	String PicUrl;
	// 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	String MediaId;
	

	@Override
	public void paserXml(Element element) {
		NodeList ToUserName = element.getElementsByTagName("ToUserName");
		NodeList FromUserName = element.getElementsByTagName("FromUserName");
		NodeList CreateTime = element.getElementsByTagName("CreateTime");
		NodeList MsgType = element.getElementsByTagName("MsgType");
		NodeList PicUrl = element.getElementsByTagName("PicUrl");
		NodeList MediaId = element.getElementsByTagName("MediaId");
		NodeList MsgId = element.getElementsByTagName("MsgId");
		
		this.ToUserName = ToUserName.item(0).getTextContent();
		this.FromUserName = FromUserName.item(0).getTextContent();
		this.CreateTime = Integer.parseInt(CreateTime.item(0).getTextContent());
		this.MsgType = MsgType.item(0).getTextContent();
		this.PicUrl = PicUrl.item(0).getTextContent();
		this.MediaId = MediaId.item(0).getTextContent();
		this.MsgId = Long.parseLong(MsgId.item(0).getTextContent());
	}

	@Override
	public String sendMessage(Object... args) {
		final String format = "<xml>"
				+ "<ToUserName><![CDATA[%1$s]]></ToUserName>"
				+ "<FromUserName><![CDATA[%2$s]]></FromUserName>"
				+ "<CreateTime>%3$s</CreateTime>"
				+ "<MsgType><![CDATA[%4$s]]></MsgType>"
				+ "<Image><MediaId><![CDATA[%5$s]]></MediaId></Image>"
				+ "</xml>";
		
		if(args == null || args.length != 5){
			throw new IllegalArgumentException("发送图片消息失败, 参数必须有5个!");
		}
		return String.format(format, args[0], args[1], args[2], args[3], args[4]);
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
