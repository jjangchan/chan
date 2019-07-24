package S;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerCenter {
	ServerSocket serverS = null; //서버를 구동 하기위한 소켓
	Socket serverClient = null; // 클라이언트 랑 통신하는 소켓
	ArrayList<WithClient> clientSocket = new ArrayList<>();
	int num = 1;
	ServerCenter(){
		try {
			serverS = new ServerSocket();
			serverS.bind(new InetSocketAddress("10.0.0.57",8888)); //bind -> server 환경설정
			for(;;) {
				System.out.println("서버 대기 중 ~~~");
				serverClient = serverS.accept(); //Ŭ���̾�Ʈ �����
				InetAddress ip = serverClient.getInetAddress();
				System.out.println("클라이언트 입장 .");
				
				WithClient w = new WithClient(serverClient);
				clientSocket.add(w);
				w.setName("client"+num);
				num++;
				w.start();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

				
				
