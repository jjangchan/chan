package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import DB.DAO;
import DB.MemberDTO;
import Function.Fun;
import Function.MainStart;

import Function.data;

public class SendClient extends Thread {
	Socket mysk = null;
	ServerCenter sc;
	String taket = null;
	int price = 0;
	int cnt = 0;
	private InputStream is;
	private OutputStream os;
	private String imsi = null;
	private DAO dao;
	private ArrayList<Fun> event;
	private MainStart ms;
	private ArrayList<String> broker;
	private ArrayList<ServerSocket> chkSS;
	private ArrayList<String> chkST;
	private ArrayList<Integer> port;
	private String myid = "1234";

	SendClient(Socket mysk, ServerCenter sc) {
		this.sc = sc;
		this.mysk = mysk;
		dao = DAO.getInstence();
		ms = MainStart.getInstence();
		event = ms.getCenF();
		for (int i = 0; i < event.size(); i++) {
			event.get(i).setscTT(this);
		}
		try {
			is = mysk.getInputStream();
			os = mysk.getOutputStream();
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
						if (imsi.indexOf("/") != -1) {
							if (imsi.substring(0, imsi.indexOf("/")).equals("로그인")) {
								log(imsi);
							}

						} else if (imsi.indexOf("@") != -1) {
							if (imsi.substring(0, imsi.indexOf("@")).equals("매수")) {
								StringTokenizer st = new StringTokenizer(imsi, "@");
								imsi = st.nextToken();
								buying(imsi);
							} else {
								StringTokenizer st = new StringTokenizer(imsi, "@");
								imsi = st.nextToken();
								sell(imsi);
							}
						} else {
							switch (imsi) {
							case "회원가입":
								joinn();
								break;
							case "신성이엔지":
								event(imsi);
								break;
							case "모나미":
								event(imsi);
								break;
							case "SK하이닉스":
								event(imsi);
								break;
							case "셀트리온":
								event(imsi);
								break;
							case "삼성전자":
								event(imsi);
								break;
							case "잔고 내역":
								balance(imsi);
								break;
							}
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}).start();

	}

	private void log(String imsi) {
		try {
			String pwd = null;
			imsi = imsi.substring(imsi.indexOf("/") + 1);
			if (imsi.indexOf("/") != -1) {
				StringTokenizer st = new StringTokenizer(imsi, "/");
				int cnt = 0;
				while (st.hasMoreTokens()) {
					cnt++;
					switch (cnt) {
					case 1:
						myid = st.nextToken();
						break;
					case 2:
						pwd = st.nextToken();
						break;
					}
				}

				if (dao.serchM(myid, 2) != null) {
					if (dao.serchM(myid, 2).equals(pwd)) {
						imsi = "로그인 되었습니다.";
						os.write(imsi.getBytes());
						os.flush();

					} else {
						imsi = "로그인 할 수 없습니다.(비밀번호틀림)";
						os.write(imsi.getBytes());
						os.flush();

					}
				} else {
					imsi = "로그인 할 수 없습니다.(존재하지 않는 ID)";
					os.write(imsi.getBytes());
					os.flush();
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void balance(String msg) {
		System.out.println(msg);
		for (int i = 0; i < event.size(); i++) {
			event.get(i).sendB(this, msg, myid);
		}
	}

	public void sendMsg(String msg) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					System.out.println(msg);
					os.write(msg.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();

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
				if (vs < cnt) {
					os.write("매수 수량이 부족합니다".getBytes());
				} else {

					for (int i = 0; i < event.size(); i++) {
						if (event.get(i).getStockN().equals(taket)) {
							event.get(i).sell(price, cnt, myid, this);
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

		price = Integer.parseInt(imsi);
		cnt = Integer.parseInt(imsi);

		for (int i = 0; i < event.size(); i++) {
			if (event.get(i).getStockN().equals(taket)) {
				event.get(i).buysing(price, cnt, myid, this);
				break;
			}
		}

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
					port = sc.getPortT();
					int chknum = 0;
					Socket mysk1 = null;
					for (int i = 0; i < chkST.size(); i++) {
						if (imsi.equals(chkST.get(i).substring(chkST.get(i).indexOf("*") + 1))) {
							os.write(("@" + port.get(i)).getBytes());
							System.out.println("종목서버 대기중...");
							mysk1 = chkSS.get(i).accept();
							System.out.println("종목서버 입장 완료");
							break;
						}
					}

					System.out.println(event.size());
					for (int z = 0; z < event.size(); z++) {
						System.out.println(event.get(z));
						if (event.get(z).getStockN().equals(imsi)) {
							chknum = z;
							event.get(chknum).socketchk(mysk1, "y");
							break;
						}
					}

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
			MemberDTO mdto = new MemberDTO();
			while (frag) {
				byte[] buf = new byte[1024];
				is.read(buf);
				imsi = new String(buf).trim();
				if (imsi.indexOf("@") != -1) {
					if (imsi.substring(0, imsi.indexOf("@")).equals("중복확인")) {
						if (dao.serchM(imsi.substring(imsi.indexOf("@") + 1), 1) == null) {
							mdto.setId(imsi.substring(imsi.indexOf("@") + 1));
							imsi = "사용 할 수 있습니다.";
							os.write(imsi.getBytes());
							os.flush();
						} else {
							imsi = "사용 중인 id가 있습니다.";
							os.write(imsi.getBytes());
							os.flush();
						}
					}
				}
				if (imsi.indexOf("/") != -1) {
					StringTokenizer st = new StringTokenizer(imsi, "/");
					int cnt = 0;
					while (st.hasMoreTokens()) {
						cnt++;
						switch (cnt) {
						case 1:
							mdto.setPwd(st.nextToken());
							break;
						case 2:
							mdto.setName(st.nextToken());
							break;
						case 3:
							mdto.setAddr(st.nextToken());
							break;
						}
					}

					dao.insertM(mdto);

					imsi = "회원가입 되었습니다.";
					os.write(imsi.getBytes());
					os.flush();
					frag = false;
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
