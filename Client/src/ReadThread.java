import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread{

	Socket socket;

	public ReadThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			while(true) {
				// 수신(recv)
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String str;
					str = reader.readLine();
				System.out.println("server로부터 받은 메시지 : " + str);
				
				Thread.sleep(300);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	// 직접 수신
	}
	
	
}
