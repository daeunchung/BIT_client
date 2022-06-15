import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 1. 접속을 해야할 Server IP (주소) 를 설정 -> Socket
		InetSocketAddress sockAddr = new InetSocketAddress("192.168.0.129", 9000);
		
		// 2. Socket 생성
		Socket socket = new Socket();
		
		// 3. Connection 
		try {
			socket.connect(sockAddr, 10000);  // 10000 == 10초   ( 10초동안 통신안되면 끊어라)
			
			InetAddress inetAddr;
			
			if((inetAddr = socket.getInetAddress()) != null)
			{
				System.out.println("서버 접속 실패");
			}else
			{
				System.out.println("서버 접속 성공");
			}
			
			new ReadThread(socket).start();
			
			while(true) {
				
				// 4. Packet 송수신 send & receive (클라이언트는 소켓이 한개뿐)
				System.out.println("[보낼 메시지] :");
				// 송신(send)
				String str = sc.next();
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				writer.println(str);
				writer.flush();
				
				// 수신(recv)
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				str = reader.readLine();	// 직접 수신
				System.out.println("server로부터 받은 메시지 : " + str);
				
//				new ServerThread(clientSocket, list).start();

			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
