package com.sky.modules.lottery.message;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 语音消息
 * @author nukix
 *
 */
public class VoiceMessage extends AbstractMessage{

	// 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
	String MediaId;
	// 语音格式，如amr，speex等
	String Format;
	// 请注意，开通语音识别后，用户每次发送语音给公众号时，
	// 微信会在推送的语音消息XML数据包中，增加一个Recongnition字段
	// 语音识别结果，UTF8编码
	String Recognition;

	@Override
	public void paserXml(Element element) {
		NodeList ToUserName = element.getElementsByTagName("ToUserName");
		NodeList FromUserName = element.getElementsByTagName("FromUserName");
		NodeList CreateTime = element.getElementsByTagName("CreateTime");
		NodeList MsgType = element.getElementsByTagName("MsgType");
		NodeList MediaId = element.getElementsByTagName("MediaId");
		NodeList Format = element.getElementsByTagName("Format");
		NodeList Recognition = element.getElementsByTagName("Recognition");
		NodeList MsgId = element.getElementsByTagName("MsgId");
		
		
		this.ToUserName = ToUserName.item(0).getTextContent();
		this.FromUserName = FromUserName.item(0).getTextContent();
		this.CreateTime = Integer.parseInt(CreateTime.item(0).getTextContent());
		this.MsgType = MsgType.item(0).getTextContent();
		this.MediaId = MediaId.item(0).getTextContent();
		this.Format = Format.item(0).getTextContent();
		// 没有开通语音识别， 可能没有该字段
		if (Recognition != null) {
			this.Recognition = Recognition.item(0).getTextContent();
		}
		this.MsgId = Long.parseLong(MsgId.item(0).getTextContent());
	}

	@Override
	public String sendMessage(Object... args) {
		String format = "<xml><ToUserName><![CDATA[%1$s]]></ToUserName><FromUserName><![CDATA[%2$s]]></FromUserName><CreateTime>%3$s</CreateTime><MsgType><![CDATA[%4$s]]></MsgType><Voice><MediaId><![CDATA[%5$s]]></MediaId></Voice></xml>";
		if(args == null || args.length != 5){
			throw new IllegalArgumentException("发送语音消息失败, 参数必须有5个!");
		}
		return String.format(format, args[0], args[1], args[2], args[3], args[4]);
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}
}
