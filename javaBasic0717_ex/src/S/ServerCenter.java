package S;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;


public class ServerCenter {
	private ServerSocket serverS = null;
	private OutputStream senMsg = null;
	private Socket server = null;
	private Scanner in = new Scanner(System.in);
	private ArrayList<OutputStream> socketO = new ArrayList<>();
	private ArrayList<WithClient> listC = new ArrayList<>();
	private ArrayList<String> uid = new ArrayList<>();
	int num=-1;
	public void setUid(String id,Socket us, OutputStream senMsg) {
		this.senMsg = senMsg;
		uid.add(us+id);
		socketO.add(senMsg);
	}

	private String not;
	
	

	public ArrayList<OutputStream> getSocketO() {
		return socketO;
	}

	public ArrayList<String> getUid() {
		return uid;
	}

	ServerCenter(){
		try {
			serverS = new ServerSocket();
			serverS.bind(new InetSocketAddress("10.0.0.57",8888));
			notice();
			while(true) {
				
				System.out.println("client 접속 대기!");
				server = serverS.accept();
				InetAddress ip = server.getInetAddress();
				
				System.out.println("client 접속함");
				logchk();
			
				WithClient w = new WithClient(this,server);
				listC.add(w);
				w.start();			
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
					
		

	public void logchk() {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					String re = "welcome";
					senMsg = server.getOutputStream();
					senMsg.write(re.getBytes());
					
					num++;
				
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
			}
		}).start();
	}
	
	public void notice() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					not = in.nextLine();
					for(int i=0; i<listC.size();i++) {
					listC.get(i).notice(not);
					}
					
				}
						
				
			}
		} ).start();
	}
	
	
		
	
					
					
}


	
	

