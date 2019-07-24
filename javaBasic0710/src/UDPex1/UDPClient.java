package UDPex1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {

	public static void main(String[] args) {
		try {
			int port = 6060;
			InetAddress ip = InetAddress.getByName("10.0.0.57");
			
			InputStreamReader inr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(inr);
//			Scanner in = new Scanner(System.in);
			
			String msg="";
			System.out.println("전송할 내용 입력 : ");
			DatagramSocket ds = new DatagramSocket();
			DatagramPacket dp = null;
			
			while((msg = br.readLine())!=null) { //키보드로 입력한 값을 읽어온다,버퍼 리딩을 통하여 
//		    while((msg = in.nextLine())!=null) {
		    	if(msg.equalsIgnoreCase("x")) break;
				byte[] n = msg.getBytes();
				dp = new DatagramPacket(n, n.length, ip, port);
				ds.send(dp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
