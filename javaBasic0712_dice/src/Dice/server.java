package Dice;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Random;

public class server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		DatagramSocket ds = null;
		DatagramPacket dp1 = null;
		DatagramPacket dp = null;
		int port = 6060;
		byte[] buffer = new byte[256];
		Random r = new Random();
		int dicenum=0;
		int[] player1 = new int[5];
		int[] player2 = new int[5];
		
		try {
			ds = new DatagramSocket(port);
			
			InetAddress p1 = null;
			InetAddress p2 = null;
			int imsi=0;
			int cntp1=0;
			int cntp2=0;
			try {
				while(true) {
					byte[] buffer1 = new byte[256];
				dp1 = new DatagramPacket(buffer, buffer.length);
				ds.receive(dp1);
				
				buffer1 = dp1.getData();
				String msg = new String(buffer1, 0, buffer1.length);
				System.out.println("["+dp1.getAddress()+"] 님 접속"+"\n"+msg);

			
				
				if(p1==null) {
					p1=dp1.getAddress();	//player 1에 IP저장
					
				}else if(p2==null) {
					p2=dp1.getAddress();  //player 2에 IP저장
				}
				
			
				if(cntp1<5 || cntp2<5) {
					
				if(msg.indexOf("/dice")!=-1) { //입력시 랜덤 수 보내줌
					System.out.println("동작완료");
					dicenum=r.nextInt(6)+1;
				
					
					if(dp1.getAddress().equals(p1)) { 
						for(int i=0;i<5;i++) {	//P1일경우 P1에 저장
						
							if(player1[i]==0) {
								player1[i]=dicenum;
								System.out.println("p1의 i번인덱스"+i);
								System.out.println(player1[i]);
								imsi = i;
								break;
							}
						}
					}else if(dp1.getAddress().equals(p2)) { //P2일경우 P2에 저장
						for(int i=0;i<5;i++) {
							if(player2[i]==0) {
								player2[i]=dicenum;
								System.out.println("p2의 i번인덱스"+i);
								System.out.println(player2[i]);
								imsi = i;
								break;
							}
							}
					}
					
					
					buffer1 = ("당신의 주사위 번호는   : "+dicenum).getBytes();
				dp = new DatagramPacket(buffer1, buffer1.length, dp1.getAddress(), port);
				ds.send(dp);
				}
				
				if(p1.equals(dp.getAddress())) {
					cntp1++;
					
				}else {
					cntp2++;
				}
				System.out.println("player 1 : "+cntp1 + "/" + "player 2 : "+cntp2);
				
				String result="[게임결과]"+"/n";
				if(cntp1==5) {
					for(int i=0;i<=imsi;i++) {
						result+=(p1+"  님   "+player1[i]+"  /  "+p2+"  님   "+player2[i]+"\n");
					}
					result +="/n"+"◆게임 종료◆";
					buffer1 = new byte[256];
					buffer1 = (result).getBytes();
					dp = new DatagramPacket(buffer1, buffer1.length, p1, port);
					ds.send(dp);
				}
				
				
				if(cntp2==5) {
					for(int i=0;i<=imsi;i++) {
						result+=(p1+"  님   "+player1[i]+"  /  "+p2+"  님   "+player2[i]+"\n");
					}
					result +="/n"+"◆게임 종료◆";
					buffer1 = new byte[256];
					buffer1 = (result).getBytes();
					dp = new DatagramPacket(buffer1, buffer1.length, p2, port);
					ds.send(dp);
				}
				
				
				}else {
					buffer1 = ("주사위 게임입니다. 기능은 '/dice' 밖에는 없습니다.").getBytes();
					dp = new DatagramPacket(buffer1, buffer1.length, dp1.getAddress(), port);
					ds.send(dp);
				}
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
