package UDPex1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPY_client {

	public static void main(String[] args) {
		String src = "img/a.png";
		

		FileInputStream fi = null;
		
		
		BufferedInputStream bfi = null;
		
		
		int n = 0;
	   
		try {
			fi = new FileInputStream(src);
			
			bfi = new BufferedInputStream(fi);
			
			
			int port = 6060;
			InetAddress ip = InetAddress.getByName("10.0.0.57");

			InputStreamReader inr = new InputStreamReader(System.in);// 키보드
			BufferedReader br = new BufferedReader(inr);
			

			Scanner in = new Scanner(System.in);
			String msg = "";
			System.out.println("전송할 내용 입력 : ");
			byte[] buff = new byte[1024];
			byte[] buffer = new byte[1024];
			DatagramSocket ds = new DatagramSocket(6060);
			DatagramPacket dp2 = null;
			DatagramPacket dp3 = null;
			DatagramPacket  dp1 = new DatagramPacket(buffer, buffer.length);
			//사진전송
			while((n=bfi.read(buff)) != -1) {
				dp2 = new DatagramPacket(buff, buff.length,ip,port);
				ds.send(dp2);
				
			}
				
					
			while ((msg = br.readLine()) != null ) {
				// while ((msg = in.nextLine()) != null) {
				
				if (msg.equalsIgnoreCase("x"))// 대소문자 무시하세요
					break;
				byte[] n1 = msg.getBytes();
				// n=입력한 것은? 길이는? ip는? port는?
				dp3 = new DatagramPacket(n1, n1.length, ip, port);
				ds.send(dp3);
				
				ds.receive(dp1);
				byte[] buffermsg = dp1.getData();
				String clientmsg = new String(buffermsg, 0, dp1.getLength());
				System.out.println(clientmsg);
			}
			
				
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
			

		
