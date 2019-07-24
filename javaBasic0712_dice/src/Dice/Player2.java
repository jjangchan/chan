package Dice;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Player2 {
	Player2(){
		int port = 6060;
		
		try {
			InetAddress ip = InetAddress.getByName("10.0.0.42");
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			
			String msg = "";
			System.out.println("입력값");
			byte[] buff = new byte[256];
			
			DatagramSocket ds = new DatagramSocket(port);
			DatagramPacket dp;
			
			
			
			while((msg = br.readLine()) != null) {
				byte[] n = msg.getBytes();
				dp = new DatagramPacket(n,n.length,ip,port);
				ds.send(dp);
				
				dp = new DatagramPacket(buff, buff.length);
				ds.receive(dp);
				byte[] buffermsg = dp.getData();
				String clientmsg = new String(buffermsg, 0, dp.getLength());
				System.out.println(clientmsg);
				
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
