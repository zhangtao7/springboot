package com.tommy.springboot.websocket;

import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@ServerEndpoint("/websocket/{nickname}")
@Component
public class MyWebSocket {

	private static CopyOnWriteArraySet<MyWebSocket> webSocketSet=new CopyOnWriteArraySet<MyWebSocket>();

	private Session session;
	
	private String nickname;
	
	
	@OnOpen
	public void onOpen(Session s,@PathParam("nickname") String nickname) {
		this.session=s;
		this.nickname = nickname; 
		webSocketSet.add(this);
		System.out.println("有新连接加入！当前在线人数为" + webSocketSet.size()+">>>"+nickname);  
	    session.getAsyncRemote().sendText("恭喜您成功连接上WebSocket-->当前在线人数为："+webSocketSet.size());  
	}

	@OnClose
	public void onClose() {
		webSocketSet.remove(this);
		System.out.println("有一连接关闭！当前在线人数为" + webSocketSet.size());
	}
	
	
	
	@OnMessage
	public void OnMessage(String message,Session s) {
		System.out.println("来自客户端的消息:" + message); 
		 broadcast(message);
	}

	@OnError  
    public void onError(Session session, Throwable error) {  
        System.out.println("发生错误");  
        error.printStackTrace();  
    }  
	 
	private void broadcast(String message) {
		for(MyWebSocket item:webSocketSet) {
			item.session.getAsyncRemote().sendText(nickname+":"+message);
		}
	}
}
