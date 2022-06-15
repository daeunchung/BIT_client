package dto;
import java.util.*;
import java.io.*;

//public enum Info {
//	JOIN, EXIT, SEND
//}

public class InfoDTO implements Serializable{
	
	
	public InfoDTO() {

	}
	
	public InfoDTO(String nickName, Info command) {
		this.nickName = nickName;
		this.command = command;
	}

	public InfoDTO(String nickName, String message, Info command) {
		super();
		this.nickName = nickName;
		this.message = message;
		this.command = command;
	}
	
	private String nickName;
	private String message;
	private Info command;
	
	public String getNickName(){
		return nickName;
	}
	public Info getCommand(){
		return command;
	}
	public String getMessage(){
		return message;
	}
	public void setNickName(String nickName){
		this.nickName= nickName;
	}
	public void setCommand(Info command){
		this.command= command;
	}
	public void setMessage(String message){
		this.message= message; 
	}
}