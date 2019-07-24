package S;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class WithClient extends Thread {
	
	private InputStream reMsg;
	private OutputStream sendmsg;
	private ArrayList<OutputStream> sendMsg;
	private ArrayList<String> setidT;
	ServerCenter sc;
	Scanner in = new Scanner(System.in);
	Socket myclient;
	String no;
	String taket = "/all";
	String taket2 = " ";
	String taket3 = "]";
	String id;
	int num =0;
	
	WithClient(ServerCenter t,Socket s ){
		this.sc = t;
		this.myclient = s;
		
	}
	
	@Override
	public void run() {
		connet();
		setsc();
		
		sendDate();
		
		
	}
	
	public void notice(String no) {
		try {
			this.no = no;
			sendmsg = myclient.getOutputStream();
			no = "공지사항 / "+no;
			sendmsg.write(no.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void connet() {
		try {
			reMsg = myclient.getInputStream();
			sendmsg = myclient.getOutputStream();
			byte[] rebuf = new byte[100];
			reMsg.read(rebuf); //클라이언트로 부터 메시지를 오기를 대기
			id = new String(rebuf).trim();
			System.out.println(id+"님 :"+"접속");
			sc.setUid(id,myclient,sendmsg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private void sendDate() {
		
			try {
				while(true) {
					    setsc();
						byte[]buf = new byte[100];
						reMsg = myclient.getInputStream();
						reMsg.read(buf);

						String chat = new String(buf);
						if(chat.substring(0,chat.indexOf(taket)+4).equals(taket)) {
							chat = id+"/"+chat.substring(chat.indexOf(taket)+5);
							for(int i=0;i<sendMsg.size();i++) {
								sendMsg.get(i).write(chat.getBytes());
							}
						}else{
							chat = chat.substring(3);
							for(int i=0;i<setidT.size();i++) {
								if(setidT.get(i).substring(setidT.get(i).indexOf(taket3)+1).equals(chat.substring(0,chat.indexOf(taket2)))) {
									chat = id+"님에게 온 메세지 : "+chat.substring(chat.indexOf(taket2)+1);
									sendMsg.get(i).write(chat.getBytes());
								}
							}
						}
//						chat = id+"/"+new String(buf).trim();
						
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}
	
	private void setsc() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					sendMsg = sc.getSocketO();
					setidT = sc.getUid();
				}
				
			}
		}).start();
	}
	
	public void notice2(int num) {
		this.num = num;
		setsc();
		try {
			String imsi = setidT.get(num)+" 님이 입장 하셨습니다.";
			sendmsg = myclient.getOutputStream();
			sendmsg.write(imsi.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}



	
							
			
			
