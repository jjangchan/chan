package Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerCenter {
	private ServerSocket server = null;
	private ArrayList<ServerSocket> serverT = new ArrayList<>();
	private ArrayList<String> sT = new ArrayList<>();
	private Socket socket = null;
	
	public ArrayList<ServerSocket> getServerT() {
		return serverT;
	}

	public ArrayList<String> getsT() {
		return sT;
	}

	public ServerCenter(){
		try {
			server = new ServerSocket();
			server.bind(new InetSocketAddress("10.0.0.51",8888));
			
			ServerSocket server1 = new ServerSocket();
			server1.bind(new InetSocketAddress("10.0.0.51",8881));
			serverT.add(server1);
			sT.add(server1+"*신성이엔지");
			
			ServerSocket server2 = new ServerSocket();
			server2.bind(new InetSocketAddress("10.0.0.51",8882));
			serverT.add(server2);
			sT.add(server2+"*모나미");
			
			ServerSocket server3 = new ServerSocket();
			server3.bind(new InetSocketAddress("10.0.0.51",8883));
			serverT.add(server3);
			sT.add(server3+"*삼성전자");
			
			ServerSocket server4 = new ServerSocket();
			server4.bind(new InetSocketAddress("10.0.0.51",8884));
			serverT.add(server4);
			sT.add(server4+"*셀트리온");
			
			ServerSocket server5 = new ServerSocket();
			server5.bind(new InetSocketAddress("10.0.0.51",8885));
			serverT.add(server5);
			sT.add(server5+"*SK하이닉스");
			
			net();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void net() {
		while(true) {
			try {
				System.out.println("서버 대기중");
				socket = server.accept();
				System.out.println("클라이언트 입장");
				SendClient sc = new SendClient(socket,this);
				sc.start();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
