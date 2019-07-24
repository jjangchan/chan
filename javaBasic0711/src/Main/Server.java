package Main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;

import totalD.memberDAO;
import totalD.memberDTO;

public class Server {
	memberDAO dao = memberDAO.getInstence();
	private String id;
	private String pwd;
	private ArrayList<memberDTO> mb;
	String staket ="/";
	Scanner in = new Scanner(System.in);
	
	public Server() {
		byte[] buffer = new byte[1024];
		
		try {
			DatagramSocket ds = new DatagramSocket(6060);
			DatagramPacket dp;
			
			while(true) {
				dp = new DatagramPacket(buffer, buffer.length);
				ds.receive(dp);
				
				InetAddress ip = dp.getAddress();
				
				String cip = ip.getHostAddress();
				int port = dp.getPort();
				System.out.println(cip +"["+port+"] 님의 로그인 요청");
				
				
				byte[] buffermsg = dp.getData();
				String clientmsg = new String(buffermsg,0,dp.getLength());
				id = clientmsg.substring(0,clientmsg.indexOf(staket));
				pwd = clientmsg.substring(clientmsg.indexOf(staket)+1);
				
//				InputStreamReader inr = new InputStreamReader();
//				BufferedReader br = new BufferedReader(inr);
//				
				ip = InetAddress.getByName(cip);
				if(dao.getList(id) !=null) {
					mb = dao.getList(id);
					for(int i=0; i<mb.size();i++) {
						if(mb.get(i).getPwd().equals(pwd)) {
							id = mb.get(i).getName()+"님 회원님 / "+id+"는 로그인 됐습니다.";
							byte[] n = id.getBytes();
							dp = new DatagramPacket(n, n.length,ip,port);
							ds.send(dp);
							System.out.println("ok");
							
						}else {
							id = "비밀번호가 일치 하지 않습니다.";
							byte[] n = id.getBytes();
							dp = new DatagramPacket(n, n.length,ip,port);
							ds.send(dp);
							System.out.println("ok");
						}
						
					}
				}else {
					id ="'"+ id+"'"+"는 없는 아이디 입니다.";
					byte[] n = id.getBytes();
					dp = new DatagramPacket(n, n.length,ip,port);
					ds.send(dp);
					System.out.println("ok");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}







					



				
				
				
				
