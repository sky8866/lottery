package com.sky.modules.lottery.message;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class MessageFactory extends AbstractMessageFactory{

	@Override
	public AbstractMessage createMessage(String xml) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		StringReader reader = new StringReader(xml);
		InputSource source = new InputSource(reader);
		Document document = db.parse(source);
		Element root = document.getDocumentElement();
		// 先获取 MsgType 根据 MsgType 的值分配对应的对象
		NodeList MsgType = root.getElementsByTagName("MsgType");
		String type = MsgType.item(0).getTextContent();
		AbstractMessage instance = null;
		
		// 什么类型就获取什么实例
		if(type.equals("text")){
			// 文本消息
			instance = new TextMessage();
		} else if (type.equals("image")) {
			// 图片消息
			instance = new ImageMessage();
		} else if (type.equals("voice")) {
			// 语音消息
			instance = new VoiceMessage();
		} else if (type.equals("video") || type.equals("shortvideo")) {
			// 视频消息和小视频消息
			instance = new VideoMessage();
		} else if (type.equals("location")) {
			// 地理位置消息
			instance = new LocationMessage();
		} else if (type.equals("link")) {
			// 链接消息
			instance = new LinkMessage();
		} else if (type.equals("event")) {
			// 事件消息
			instance = new EventMessage();
		} else {
			instance = null;
		}
		instance.paserXml(root);
		return instance;
	}

}
