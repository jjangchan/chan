package lotto_game;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import TatalD.MemberDAO;
import TatalD.MemberDTO;

public class Server {
	ServerSocket serverSS = null;
	Socket server = null;
	MemberDAO dao = MemberDAO.getInstence();
	ArrayList<MemberDTO> dto = new ArrayList<>();
	String id;
	
	Server(){
		try {
			serverSS = new ServerSocket();
			serverSS.bind(new InetSocketAddress("127.0.0.1",8888));
			InetAddress ip = serverSS.getInetAddress();
			System.out.println(ip);
			
			while(true) {
				System.out.println("서버 대기중");
				server = serverSS.accept();
				System.out.println("클라이언트 통신 완료");
				SendClient sc =new SendClient(server);
				sc.start();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void lottochk() {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				
			}
		}).start();
		
	}
	
	
}
