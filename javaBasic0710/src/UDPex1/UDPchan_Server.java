package UDPex1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPchan_Server {

	public static void main(String[] args) {
		String target = "img/b.jpg";
		int cnt =0;
		int n = 0;
		try {
			
			FileOutputStream fo = new FileOutputStream(target);
			BufferedOutputStream bfo = new BufferedOutputStream(fo);
		
			
			byte[] buffer = new byte[1024];
			
			
			DatagramSocket ds = new DatagramSocket(6060);  //server
			DatagramPacket dp; //데이터그램 그릇(256byte)
			
			while(true) {
				
				dp = new DatagramPacket(buffer, buffer.length);
				ds.receive(dp); //그릇인지
				
//				InetAddress ip = dp.getAddress();
//				String cip = ip.getHostAddress();
//				
//				int port = dp.getPort();
//				System.out.println(cip+"["+port+"] 님메세지");
					
//				byte[] buffermsg = dp.getData();
				byte[] buff = dp.getData();
//					
//				String clientmsg = new String(buffermsg,0,dp.getLength());
//				System.out.println(clientmsg);
				
				//사진 받기
				System.out.println(dp);
			  
				bfo.write(buff,0,buff.length);
				bfo.flush();
				
					
					
					
					//문자 답장
//					if(clientmsg != null) {
//						InputStreamReader inr = new InputStreamReader(System.in);
//						BufferedReader br = new BufferedReader(inr);
//						ip = InetAddress.getByName(cip);
//						String msg = "";
//						System.out.println("전송할 내용 : ");
//						while((msg = br.readLine()) != null) {
//							
//							if(msg.equalsIgnoreCase("x"))break;
//							byte[] n = msg.getBytes();
//							dp = new DatagramPacket(n, n.length, ip, port);
//							ds.send(dp);
//							
//							break;
//						}
//					}
					
			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
}


				
				
				
				
				
				
					
					
					
