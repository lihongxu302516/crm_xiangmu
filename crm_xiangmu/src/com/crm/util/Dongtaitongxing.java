package com.crm.util;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;



@ServerEndpoint(value = "/dongtaitongxing/{userId}")
public class Dongtaitongxing {
	@Resource
	private Dongtaitongxing webcomment;
	

	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;
	// concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
	// private static CopyOnWriteArraySet<Webcomment> webSocketSet = new
	// CopyOnWriteArraySet<Webcomment>();
	// 线程安全的Map
	private static ConcurrentHashMap<String, Session> webSocketMap = new ConcurrentHashMap<String, Session>();// 建立连接的方法
	private String userId;
	@OnOpen
	public void onOpen(Session session, @PathParam("userId") String userId) {
		/*
		 * 获取从/websocket开始的整条链接，用于获取userId？***=***的参数 String uri =
		 * session.getRequestURI().toString();
		 */
		webSocketMap.put(userId, session);
		addOnlineCount(); // 在线数加
		System.out.println(userId + "进入");
		this.userId=userId;
		/*
		 * Gson gson=new Gson(); String json = gson.toJson("进入聊天室");
		 * sendMessage(userId,);
		 */
		System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose(Session session) {
		Map<String, String> map = session.getPathParameters();
		webSocketMap.remove(map.get("userId")); // 从set中删除
		for (String user : webSocketMap.keySet()) {
			System.out.println(user);
		}
		subOnlineCount(); // 在线数减
		System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
	}

	/**
	 * 收到客户端消息后调用的方法
	 * 
	 * @param message 客户端发送过来的消息
	 * @param session 可选的参数
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("来自客户端的消息:" + message);
		String[] split = message.split("&");
		System.out.println(split.length);
		System.out.println(split[0]);
		System.out.println(split[1]);
		System.out.println(split[2]);
		/*
		 * String sendUserno = message.split("[|]")[1]; String sendMessage =
		 * message.split("[|]")[0];
		 */
		//String now = getNowTime();
		try {
			if (webSocketMap.get(split[0].trim()) != null) {
				System.out.println("在线");
				message=this.userId+"&"+split[1];
				//((Dongtaitongxing) webSocketMap.get("小红")).sendMessage(message,webSocketMap.get("小红"));
				sendMessage(message,webSocketMap.get(split[0]));
			} else {
				
				System.out.println("当前用户不在线");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发生错误时调用
	 * 
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("发生错误");
		error.printStackTrace();
	}

	public void sendMessage(String message, Session session) throws IOException {
		if (session.isOpen()) {
			session.getAsyncRemote().sendText(message);
		}
		// this.session.getAsyncRemote().sendText(message);
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		Dongtaitongxing.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		Dongtaitongxing.onlineCount--;
	}
}