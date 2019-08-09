package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import DB.DAO;
import DB.MemberDTO;
import Function.Fun;
import Function.MainStart;

import Function.data;

public class SendClient extends Thread{
	Socket mysk = null;
	ServerCenter sc;
	String taket=null;
	int price=0;
	int cnt=0;
	private InputStream is;
	private OutputStream os;
	private ObjectOutputStream oo;
	private String imsi=null;
	private DAO dao;
	private ArrayList<Fun> event;
	private MainStart ms;
	private ArrayList<String> broker;
	private ArrayList<ServerSocket> chkSS;
	private ArrayList<String> chkST;
	private String myid="1234";
	SendClient(Socket mysk,ServerCenter sc) {
		this.sc = sc;
		this.mysk = mysk;
		dao = DAO.getInstence();
		ms = MainStart.getInstence();
		try {
			is = mysk.getInputStream();
			os = mysk.getOutputStream();
			oo = new ObjectOutputStream(os);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public String getMyid() {
		return myid;
	}


	@Override
	public void run() {
		receiveDate();
	}


	private void receiveDate() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						byte[] buf = new byte[1024];
						is.read(buf);
						imsi = new String(buf).trim();
						System.out.println(mysk.getPort());
						switch(imsi) {
							case "회원가입" : joinn();break;
							case "신성이엔지" : event(imsi);break;
							case "모나미" : event(imsi);break;
							case "SK하이닉스" : event(imsi);break;
							case "셀트리온" : event(imsi);break;
							case "삼성전자" : event(imsi);break;
							case "매수" : buying(imsi);break;
							case "매도" : sell(imsi);break;
							case "잔고" : balance(imsi);break;
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}



		}).start();

	}
	
	private void balance(String msg) {
		for(int i=0;i<event.size();i++) {
			event.get(i).sendB(this, msg , myid);
		}
	}
	
	public void sendMsg(String msg) {
		synchronized (this) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						os.write(msg.getBytes());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}).start();
		}
	}
			
	
	private void sell(String chk) {
		try {
			if ("매도".equals(chk)) {
				
				byte[] buf = new byte[1024];
				is.read(buf);
				imsi = new String(buf).trim();
				
				price = Integer.parseInt(imsi);
				buf = new byte[1024];
				is.read(buf);
				imsi = new String(buf).trim();
				cnt = Integer.parseInt(imsi);
				int vs = dao.serchB(myid, taket, 2);
				System.out.println(vs);
				if(vs<cnt) {
					os.write("매수 수량이 부족합니다".getBytes());
				}else {
					event = ms.getCenF();
					
					for(int i=0; i< event.size();i++) {
						if(event.get(i).getStockN().equals(taket)) {
							event.get(i).sell(price,cnt,myid,this);
							break;
						}
					}
				}
			} 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					

	
	private void buying(String chk) {
		try {
			if ("매수".equals(chk)) {
				
				byte[] buf = new byte[1024];
				is.read(buf);
				imsi = new String(buf).trim();
				
				price = Integer.parseInt(imsi);
				buf = new byte[1024];
				is.read(buf);
				imsi = new String(buf).trim();
				cnt = Integer.parseInt(imsi);
				event = ms.getCenF();
				
				for(int i=0; i< event.size();i++) {
					if(event.get(i).getStockN().equals(taket)) {
						event.get(i).buysing(price,cnt,myid,this);
						break;
					}
				}
				
				
				
			} 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendOJ() {
		// 1. sendClient 에서 수행한다.

		data d = new data();
		d.setBroker(broker);
		try {
			oo.reset();
			oo.writeObject(d);
			oo.flush();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}


	private void event2() {
		// 2. sendClient 에서 수행한다.
		event = ms.getCenF();
		int chknum = 0;
		boolean frag = true;
		System.out.println(imsi);
		for (int i = 0; i < event.size(); i++) {
			if (event.get(i).getStockN().equals(imsi)) {
				chknum = i;
				break;
			}
		}
		event.get(chknum).objchk(this, "y");
		broker = event.get(chknum).getBroker();
	}
	
	private void event(String taket) {
		// 1. 서버를 나눈다.
		this.taket = taket;
		new Thread(new Runnable() {
			
			@Override
			public void run() {

				try {
					chkSS = sc.getServerT();
					chkST = sc.getsT();
					int chknum = 0;
					event = ms.getCenF();
					Socket mysk1 = null;
					for (int i = 0; i < chkST.size(); i++) {
						if (imsi.equals(chkST.get(i).substring(chkST.get(i).indexOf("*") + 1))) {
							System.out.println("종목서버 대기중...");
							mysk1 = chkSS.get(i).accept();
							System.out.println("종목서버 입장 완료");
							break;
						}
					}

					InputStream is1 = mysk1.getInputStream();
					for (int z = 0; z < event.size(); z++) {
						System.out.println(event.get(z));
						if (event.get(z).getStockN().equals(imsi)) {
							chknum = z;
							event.get(chknum).socketchk(mysk1, "y");
							break;
						}
					}

					byte[] buff = new byte[1024];
					is1.read(buff);
					imsi = new String(buff).trim();
					event.get(chknum).socketchk(mysk, imsi);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();

	}
	
	public void joinn() {
		try {
			boolean frag = true;
			while(frag) {
				MemberDTO mdto = new MemberDTO();
				byte[] buf = new byte[1024];
				is.read(buf);
				imsi = new String(buf).trim();
				
				if(dao.serchM(imsi)==null) {
					mdto.setId(imsi);
					imsi = "중복 되는 id가 없습니다.";
					os.write(imsi.getBytes());
					os.flush();
					
					buf = new byte[1024];
					is.read(buf);
					imsi = new String(buf).trim();
					
					mdto.setPwd(imsi);
					
					buf = new byte[1024];
					is.read(buf);
					imsi = new String(buf).trim();
					
					mdto.setName(imsi);
					
					buf = new byte[1024];
					is.read(buf);
					imsi = new String(buf).trim();
					
					mdto.setAddr(imsi);
					dao.insertM(mdto);
					
					imsi = "회원가입 되었습니다.";
					os.write(imsi.getBytes());
					os.flush();
					frag = false;
				}else {
					imsi = "id가 중복 됩니다.";
					os.write(imsi.getBytes());
					os.flush();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
				

}
