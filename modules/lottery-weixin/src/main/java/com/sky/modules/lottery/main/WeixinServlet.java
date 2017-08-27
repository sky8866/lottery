package com.sky.modules.lottery.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WeixinServlet  extends HttpServlet {
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeixinServlet() {
        super();
    }
    public void destroy() {
     super.destroy();

   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		System.out.println("erefdfeedddddddddwwwssssswwwssssss:");
		WechatCallbackapi api = new WechatCallbackapi();
		// 打印后去到的参数
		api.decideServer(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 本页设置编码， 设置完之后， 委托给 WechatCallbackapi 进行数据的处理
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		System.out.println("ererewrwerwerwrwrrwwrwrwerrwe:");
		WechatCallbackapi api = new WechatCallbackapi();
		api.main(request, response);
	}

}
