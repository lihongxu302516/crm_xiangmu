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
	

	// ��̬������������¼��ǰ������������Ӧ�ð�����Ƴ��̰߳�ȫ�ġ�
	private static int onlineCount = 0;
	// concurrent�����̰߳�ȫSet���������ÿ���ͻ��˶�Ӧ��MyWebSocket������Ҫʵ�ַ�����뵥һ�ͻ���ͨ�ŵĻ�������ʹ��Map����ţ�����Key����Ϊ�û���ʶ
	// private static CopyOnWriteArraySet<Webcomment> webSocketSet = new
	// CopyOnWriteArraySet<Webcomment>();
	// �̰߳�ȫ��Map
	private static ConcurrentHashMap<String, Session> webSocketMap = new ConcurrentHashMap<String, Session>();// �������ӵķ���
	private String userId;
	@OnOpen
	public void onOpen(Session session, @PathParam("userId") String userId) {
		/*
		 * ��ȡ��/websocket��ʼ���������ӣ����ڻ�ȡuserId��***=***�Ĳ��� String uri =
		 * session.getRequestURI().toString();
		 */
		webSocketMap.put(userId, session);
		addOnlineCount(); // ��������
		System.out.println(userId + "����");
		this.userId=userId;
		/*
		 * Gson gson=new Gson(); String json = gson.toJson("����������");
		 * sendMessage(userId,);
		 */
		System.out.println("�������Ӽ��룡��ǰ��������Ϊ" + getOnlineCount());
	}

	/**
	 * ���ӹرյ��õķ���
	 */
	@OnClose
	public void onClose(Session session) {
		Map<String, String> map = session.getPathParameters();
		webSocketMap.remove(map.get("userId")); // ��set��ɾ��
		for (String user : webSocketMap.keySet()) {
			System.out.println(user);
		}
		subOnlineCount(); // ��������
		System.out.println("��һ���ӹرգ���ǰ��������Ϊ" + getOnlineCount());
	}

	/**
	 * �յ��ͻ�����Ϣ����õķ���
	 * 
	 * @param message �ͻ��˷��͹�������Ϣ
	 * @param session ��ѡ�Ĳ���
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("���Կͻ��˵���Ϣ:" + message);
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
				System.out.println("����");
				message=this.userId+"&"+split[1];
				//((Dongtaitongxing) webSocketMap.get("С��")).sendMessage(message,webSocketMap.get("С��"));
				sendMessage(message,webSocketMap.get(split[0]));
			} else {
				
				System.out.println("��ǰ�û�������");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��������ʱ����
	 * 
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("��������");
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