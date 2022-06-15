package handler;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import server.ChatServerObject;

public class ServerHandlerObject {	// no thread 오직 하나만 관리

	private List<ChatServerObject> serverList; 
	public JFrame listFrame;	
	
	public ServerHandlerObject() {
		
		serverList = new ArrayList<ChatServerObject>();
		listFrame = new JFrame();
		ChatServerObject oneChatRoom;
		
		int size = serverList.size();
		for(int i=0; i<size; i++)
		{
			listFrame.add(new JButton());
			oneChatRoom = serverList.get(i);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new ServerHandlerObject();
	}

}
