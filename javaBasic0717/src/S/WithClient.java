package S;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class WithClient extends Thread { // 접속 한 클라이언트랑 통신하기 위한 클래스
	String id = null;
	String chat;
	InputStream reMsg = null;
	OutputStream senMsg = null;
	Scanner in = new Scanner(System.in);
	Socket myclient = null;
	WithClient(Socket s){
		this.myclient = s;
		
	}
	
	@Override
	public void run() {
		streamset();
		sendDate();
		receiveDate();
	}

	private void receiveDate() {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						while(true) {
							
							byte[] rebuf = new byte[100];
							reMsg.read(rebuf);
							String msg = new String(rebuf).trim();
							System.out.println(id+" / "+msg);
						}
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start(); 
	}
	
				
			

	private void sendDate() {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						while(true) {
							chat = in.nextLine();
							senMsg.write(chat.getBytes());
							
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}).start();
				
	}


	private void streamset() {
		try {
			reMsg = myclient.getInputStream(); 
			byte[] rebuf = new byte[100];
		
			reMsg.read(rebuf); //클라이언트로 부터 메시지를 오기를 대기
			id = new String(rebuf);
			id = id.trim();
			
			System.out.println("id :"+id);
			
			String re = id + "!  welcome";
			senMsg = myclient.getOutputStream();
			senMsg.write(re.getBytes());
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
