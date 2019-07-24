package member;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

import ADM.MemberADM;
import DB.MemberDAO;

public class Chatting {
	
	MemberADM adm ;
	MemberDAO dao = MemberDAO.getInstence();
	ArrayList<InetAddress> getip ;
	DatagramSocket ds;
	DatagramPacket dp;
	byte buff[] = new byte[256];
	public Chatting(MemberADM adm){
		this.adm = adm;
		getip = adm.getGetip2();
		chat();
	}
	
	public void chat() {
		try {
			boolean frag = true;
			ds = new DatagramSocket(6060);
			while(frag) {
				dp = new DatagramPacket(buff, buff.length);
				ds.receive(dp);
				
				InetAddress iip = dp.getAddress();
				int port = dp.getPort();
				byte[] buffmsg = dp.getData();
				String msg = new String(buffmsg,0,dp.getLength());
				
				for(int i=0;i<getip.size();i++) {
					if(!getip.get(i).equals(iip)) {
						iip = getip.get(i);
						byte[] n = msg.getBytes();
						dp = new DatagramPacket(n,n.length,iip,port);
						ds.send(dp);
						
					}
				}
			
			}
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

						
