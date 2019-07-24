package C;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Withserver {
	String id=null;
	String chat=null;
	InputStream reMsg = null;
	OutputStream senMsg = null;
	Socket myclient = null;
	Scanner in = new Scanner(System.in);
	
	Withserver(Socket s){
		this.myclient = s;
		streamset();
		sendData();
		receiveData();
	}

	private void streamset() {
		try {
			
			reMsg = myclient.getInputStream();
			byte[]buff = new byte[100];
			reMsg.read(buff);
			String r = new String(buff);
			r.trim();
			System.out.println(r);
			
			System.out.println("id 입력 해주세요.");
			id = in.nextLine();
			senMsg = myclient.getOutputStream();
			senMsg.write(id.getBytes());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void sendData() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while(true) {
						chat = in.nextLine();
						byte[]buff = new byte[100];
						senMsg.write(chat.getBytes());
						
					}
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
		
	}
	
	private void receiveData() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while(true) {
						byte[]buff = new byte[100];
						reMsg.read(buff);
						String remsg = new String(buff).trim();
						System.out.println(remsg);
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
	}
}
				
