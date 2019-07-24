package UDPex1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPserver {

	public static void main(String[] args) {
		try {
			byte[] buffer = new byte[256];
			
			DatagramSocket ds = new DatagramSocket(6060);  //server
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length);//�����ͱ׷� �׸�(256byte)
			
			while(true) {
				ds.receive(dp); //�׸�����
				
				InetAddress ip = dp.getAddress();
				String cip = ip.getHostAddress();
				int port = dp.getPort();
				System.out.println(cip+"["+port+"] �Ը޼���");
				
				
				byte[] buffermsg = dp.getData();
				String clientmsg = new String(buffermsg,0,dp.getLength());
				System.out.println(clientmsg);
				
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
