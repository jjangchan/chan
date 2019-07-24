package ADM;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

import DB.MemberDAO;
import DB.MemberDTO;
import member.Chatting;

public class MemberADM {
	
	byte[] buff = new byte[258];
	MemberDTO dto = new MemberDTO();
	MemberDAO dao = MemberDAO.getInstence();
	ArrayList<MemberDTO> glist;
	ArrayList<MemberDTO> totalglist;
	ArrayList<InetAddress> getip = new ArrayList<>();   // ip리스트
	ArrayList<InetAddress> getip2 = new ArrayList<>();  //1:1 대화 ip 
	
	MemberDTO m = new MemberDTO();
	DatagramSocket ds;
	DatagramPacket dp;
	String taket = "/";
	String taket2 ="/r";
	String taket3 =" ";
	String taket4 ="/r abc asdas";
	
	

	int cnt=0;
	InetAddress ip;
	int port;
	private String id;
	private String pwd;
    String imsi;
	public MemberADM(){
		logchk();
		
	}
	
	public void logchk() {
//		System.out.println(taket4.substring(0,taket4.indexOf(taket2)+2));
//		taket4 = taket4.substring(taket4.indexOf(taket2)+3);
//		System.out.println(taket4);
//		System.out.println(taket4.substring(0,taket4.indexOf(taket3)));
//		System.out.println(taket4.substring(taket4.indexOf(taket3)+1));
		try {
			boolean frag = true;
			ds = new DatagramSocket(6060);
			while(frag) {
				dp = new DatagramPacket(buff, buff.length);
				ds.receive(dp);
				ip = dp.getAddress();
				String cip = "/"+ip.getHostAddress(); //db에 최신 ip 업데이트
		
				getip.add(ip); //ip 리스트 넣기 
				port = dp.getPort();
				byte[] buffmsg = dp.getData();
				String log = new String(buffmsg,0,dp.getLength());
				
				id = log.substring(0,log.indexOf(taket));
				pwd = log.substring(log.indexOf(taket)+1);
				System.out.println(ip+"[ip] / "+id+"님의 로그인");
				m.setId(id);
				m.setIp(cip);
				
				dao.update(m);
				
				
				
				if(dao.getList(id) !=null) {
					glist = dao.getList(id);
					for(int i=0;i<glist.size();i++) {
						if(glist.get(i).getPwd().equals(pwd)) {
							cnt++;
							imsi = glist.get(i).getName()+"님 께서 접속 하셨습니다.";
							byte[]n = imsi.getBytes();
							dp = new DatagramPacket(n,n.length,ip,port);
							ds.send(dp);
							System.out.println("ok");
							if(cnt==2) {
								frag = false;
								
							}
						}else {
							imsi = "비밀번호가 일치 하지 않습니다.";
							byte[]n = imsi.getBytes();
							dp = new DatagramPacket(n,n.length,ip,port);
							ds.send(dp);
							System.out.println("ok");
						}
					}
				}else {
					imsi = "없는 id 입니다.";
					byte[]n = imsi.getBytes();
					dp = new DatagramPacket(n,n.length,ip,port);
					ds.send(dp);
					System.out.println("ok");
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ds.close();
		chat();
	}
	
	public void chat() {
		setlist();
		try {
			ds = new DatagramSocket(6060);
			dp = new DatagramPacket(buff, buff.length);
			boolean frag = true;
			while(frag) {
				ds.receive(dp);
				byte[] ulog = dp.getData();
				String clog = new String(ulog,0,dp.getLength());
				ip = dp.getAddress();
				if(clog.substring(0,clog.indexOf(taket2)+2).equals(taket2)) {
					// 1:1 채팅방
					clog = clog.substring(clog.indexOf(taket2)+3);
					System.out.println(clog.substring(0,clog.indexOf(taket3)));
					if(dao.getid(clog.substring(0,clog.indexOf(taket3))) != null) {
						imsi = clog.substring(clog.indexOf(taket3)+1);
						getip2.add(ip);
						glist = dao.getid(clog.substring(0,clog.indexOf(taket3)));
						//ip db에 select 문으로 던져서 받은 ip 리스트에 있는 ip 조사해서 1:1 가능 한 현재 접속 ip,상대방 ip넣기
						for(int i=0;i<getip.size();i++) {
							String imsiip =""+getip.get(i);
							if(glist.get(0).getIp().equals(imsiip)) {
								getip2.add(getip.get(i));
//								System.out.println(getip2.get(i)+"님 과 대화 ");
//								System.out.println(getip2.get(0));
//								System.out.println(getip2.get(1));
								frag = false;
								ds.close();
								new Chatting(this);
								break;
							}else if(i==totalglist.size()-1 &&  !glist.get(0).getIp().equals(imsiip)) {
								imsi = "해당 아이디는 로그인 되어 있지 않습니다.";
								byte[] n = imsi.getBytes();
								dp = new DatagramPacket(n, n.length,ip,port);
								ds.send(dp);
								
								
								continue;
							}
						}
					}else {
						imsi = "해당 아이디는 없습니다.";
						byte[] n = imsi.getBytes();
						dp = new DatagramPacket(n, n.length,ip,port);
						ds.send(dp);
						frag = false;
						ds.close();
						logchk();
						continue;
					}
				}else {
					//전체 채팅방 
					System.out.println("업데이트중");
					imsi = "업데이트중.";
					byte[] n = imsi.getBytes();
					dp = new DatagramPacket(n, n.length,ip,port);
					ds.send(dp);
					frag = false;
					ds.close();
					logchk();
					continue;
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<InetAddress> getGetip2() {
		return getip2;
	}

	public String getImsi() {
		return imsi;
	}

	public void setlist() {
		if(dao.totalList()!=null) {
			totalglist = dao.totalList();
		}else {
			totalglist = new ArrayList<MemberDTO>();
		}
	}
}
						
						

					
