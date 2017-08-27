package com.sky.modules.lottery.message;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 地理位置消息
 * @author nukix
 *
 */
public class LocationMessage extends AbstractMessage{

	// 地理位置维度
	String Location_X;
	// 地理位置经度
	String Location_Y;
	// 地图缩放大小
	String Scale;
	// 地理位置信息
	String Label;
	
	@Override
	public void paserXml(Element element) {
		NodeList ToUserName = element.getElementsByTagName("ToUserName");
		NodeList FromUserName = element.getElementsByTagName("FromUserName");
		NodeList CreateTime = element.getElementsByTagName("CreateTime");
		NodeList MsgType = element.getElementsByTagName("MsgType");
		NodeList Location_X = element.getElementsByTagName("Location_X");
		NodeList Location_Y = element.getElementsByTagName("Location_Y");
		NodeList Scale = element.getElementsByTagName("Scale");
		NodeList Label = element.getElementsByTagName("Label");
		NodeList MsgId = element.getElementsByTagName("MsgId");
		
		this.ToUserName = ToUserName.item(0).getTextContent();
		this.FromUserName = FromUserName.item(0).getTextContent();
		this.CreateTime = Integer.parseInt(CreateTime.item(0).getTextContent());
		this.MsgType = MsgType.item(0).getTextContent();
		this.Location_X = Location_X.item(0).getTextContent();
		this.Location_Y = Location_Y.item(0).getTextContent();
		this.Scale = Scale.item(0).getTextContent();
		this.Label = Label.item(0).getTextContent();
		this.MsgId = Long.parseLong(MsgId.item(0).getTextContent());
	}

	@Override
	public String sendMessage(Object... args) {
		// 目前没有此类型的发送信息
		return null;
	}

	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}
	

}
