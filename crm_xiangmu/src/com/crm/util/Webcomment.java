package com.crm.util;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@ServerEndpoint(value ="/newwebsocket/{userId}")
public class Webcomment {
    @Resource
    private Webcomment webcomment;
    
    //��̬������������¼��ǰ������������Ӧ�ð�����Ƴ��̰߳�ȫ�ġ�
    private static int onlineCount = 0;
    //concurrent�����̰߳�ȫSet���������ÿ���ͻ��˶�Ӧ��MyWebSocket������Ҫʵ�ַ�����뵥һ�ͻ���ͨ�ŵĻ�������ʹ��Map����ţ�����Key����Ϊ�û���ʶ
    //private static CopyOnWriteArraySet<Webcomment> webSocketSet = new CopyOnWriteArraySet<Webcomment>();  
    //�̰߳�ȫ��Map  
    private static ConcurrentHashMap<String,Session> webSocketMap = new ConcurrentHashMap<String,Session>();//�������ӵķ���
    @OnOpen
    public void onOpen(Session session,@PathParam("userId")String  userId){
        /*��ȡ��/websocket��ʼ���������ӣ����ڻ�ȡuserId��***=***�Ĳ���
        String uri = session.getRequestURI().toString();*/
    webSocketMap.put(userId, session);
    addOnlineCount(); //��������
    System.out.println(userId+"����������");
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
    public void onClose(Session session){
    Map<String, String> map = session.getPathParameters();
    webSocketMap.remove(map.get("userId")); //��set��ɾ��
    for(String user:webSocketMap.keySet()){
    System.out.println(user);
    }
    subOnlineCount(); //��������
    System.out.println("��һ���ӹرգ���ǰ��������Ϊ" + getOnlineCount());
    }
    
    /**
    * �յ��ͻ�����Ϣ����õķ���
    * @param message �ͻ��˷��͹�������Ϣ
    * @param session ��ѡ�Ĳ���
    */
    @OnMessage
    public void onMessage(String message, Session session) {
    System.out.println("���Կͻ��˵���Ϣ:" + message);
    if("���ѽ��������ң�".equals(message)) {
    	Map<String, String> map = session.getPathParameters();
        String userId = map.get("userId");
        message=userId+"�ѽ��������ң�";
        for(String user:webSocketMap.keySet()){
            try {
                sendMessage(message,webSocketMap.get(user));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    	
    }else {
    //��ȡ�û�ID
    Map<String, String> map = session.getPathParameters();
    String userId = map.get("userId");
    
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
   	String sj = df.format(new Date());
   	String qianming=sj+"~~~"+userId+" : ";
    for(String user:webSocketMap.keySet()){
        try {
            sendMessage(qianming+message,webSocketMap.get(user));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
    }
    
    /**
    * ��������ʱ����
    * @param session
    * @param error
    */
    @OnError
    public void onError(Session session, Throwable error){
    System.out.println("��������");
    error.printStackTrace();
    }
    
    public void sendMessage(String message,Session session) throws IOException{
        if(session.isOpen()){
        session.getAsyncRemote().sendText(message);
        }
        //this.session.getAsyncRemote().sendText(message);
        }
    
    
    
    public static synchronized int getOnlineCount() {
        return onlineCount;
        }
    public static synchronized void addOnlineCount() {
        Webcomment.onlineCount++;
        }
    public static synchronized void subOnlineCount() {
        Webcomment.onlineCount--;
        }
}