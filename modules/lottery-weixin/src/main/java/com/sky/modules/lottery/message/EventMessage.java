package com.sky.modules.lottery.message;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 
 * @author nukix
 *
 */
public class EventMessage extends AbstractMessage{
	/**
	 * 注：
	 * 关注/取消关注事件只有Event
	 * 用户未关注时，进行关注后的事件推送， 有Event, EventKey, Ticket
	 * 用户以关注时的事件推送，有Event, EventKey, Ticket
	 * 上报地理位置,有Event, Latitude, Longitude, Precision
	 * 自定义菜单事件，有Event, EventKey
	 * 菜单跳转链接时的事件推送
	 */
	
	
	/**
	 * 事件类型，subscribe(订阅)、unsubscribe(取消订阅),
	 * SCAN(已关注扫描二维码),LOCATION(用户同意上报地理位置),
	 * LOCATION(上报地理位置),CLICK(自定义菜单事件),
	 * VIEW(点击菜单跳转链接)
	 */
	String Event;
	
	/**
	 * 未关注时，事件KEY值，qrscene_为前缀，后面为二维码的参数值
	 * 已关注时，事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
	 * 自定义菜单事件，事件KEY值，与自定义菜单接口中KEY值对应
	 * 点击菜单跳转链接时事件，事件KEY值，设置的跳转URL
	 */
	String EventKey;
	
	// 二维码的ticket，可用来换取二维码图片
	String Ticket;
	
	// 地理位置纬度
	String Latitude;
	
	// 地理位置经度
	String Longitude;
	
	// 地理位置精度
	String Precision;
	
	@Override
	public void paserXml(Element element) {
		NodeList ToUserName = element.getElementsByTagName("ToUserName");
		NodeList FromUserName = element.getElementsByTagName("FromUserName");
		NodeList CreateTime = element.getElementsByTagName("CreateTime");
		NodeList MsgType = element.getElementsByTagName("MsgType");
		NodeList Event = element.getElementsByTagName("Event");
		NodeList EventKey = element.getElementsByTagName("EventKey");
		NodeList Ticket = element.getElementsByTagName("Ticket");
		NodeList Latitude = element.getElementsByTagName("Latitude");
		NodeList Longitude = element.getElementsByTagName("Longitude");
		NodeList Precision = element.getElementsByTagName("Precision");
		
		this.ToUserName = ToUserName.item(0).getTextContent();
		this.FromUserName = FromUserName.item(0).getTextContent();
		this.CreateTime = Integer.parseInt(CreateTime.item(0).getTextContent());
		this.MsgType = MsgType.item(0).getTextContent();
		this.Event = Event.item(0).getTextContent();
		
		if (EventKey != null && EventKey.item(0) != null) {
			this.EventKey = EventKey.item(0).getTextContent();
		}
		
		if (Ticket != null && Ticket.item(0) != null) {
			this.Ticket = Ticket.item(0).getTextContent();
		}
		
		if (Latitude != null && Latitude.item(0) != null) {
			this.Latitude = Latitude.item(0).getTextContent();	
		}
		
		if (Longitude != null && Longitude.item(0) != null) {
			this.Longitude = Longitude.item(0).getTextContent();
		}

		if (Precision != null && Precision.item(0) != null) {
			this.Precision = Precision.item(0).getTextContent();
		}
		
		
	}

	@Override
	public String sendMessage(Object... args) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}
	
	
}
