package GUI;

import java.util.ArrayList;

import Client.SendServer;
import Function.data;

public class ADM {
	SendServer ss;
	private static ADM asingleton;
	private JOIN j = new JOIN(this);
	private LOGF l = new LOGF(this);
	private FUCT f = new FUCT(this);
	private Pevent p;
	private Balance b = new Balance(this);
	private Event e = new Event(this);
	private ArrayList<String> eventT = new ArrayList<>();
	private ArrayList<Pevent> peventT = new ArrayList<>();
	
	//종목 객체 arrayList
	public ArrayList<Pevent> getPeventT() {
		return peventT;
	}
	
	public static ADM getInstence() {
		if(asingleton==null) {
			asingleton = new ADM();
		}
		return asingleton;
	}
	private ADM() {}
	
	public SendServer getSs() {
		return ss;
	}
	
	public void start(SendServer ss) {
		this.ss = ss;
		eventT.add("삼성전자");
		eventT.add("신성이엔지");
		eventT.add("셀트리온");
		eventT.add("모나미");
		eventT.add("SK하이닉스");
		for(int i=0;i<eventT.size();i++) {
			p = new Pevent(eventT.get(i));
			peventT.add(p);
		}
		System.out.println(peventT.size());
		l.setVisible(true);
	}
	
	public void sendC(String msg) {
		if (msg.equals("회원가입")) {
			j.setVisible(true);
			ss.send(msg);
		} else if (msg.indexOf("@") != -1) {
			if (msg.substring(0, msg.indexOf("@")).equals("중복확인")) {
				ss.send(msg);
				
			}
		} else if(msg.substring(0,2).equals("로그")) {
			f.setVisible(true);
		} else if(msg.equals("종목 보기")) {
			e.setVisible(true);
		} else if(msg.equals("뒤로 가기1")) {
			f.setVisible(true);
		} else if(msg.equals("잔고 내역")) {
			b.setVisible(true);
			ss.send(msg);
		} else if(msg.equals("뒤로 가기2")) {
			f.setVisible(true);
		} else if(msg.equals("신성이엔지")) {
			ss.send(msg);
			for(int i=0;i<peventT.size();i++) {
				if(peventT.get(i).getEvent().equals(msg)) {
					peventT.get(i).setVisible(true);
					break;
				}
			}
		}
	}
		

	
	public void sendG(String msg) {
		synchronized (this) {
			String imsi = msg.substring(0, 2);
			switch (imsi) {
			case "사용":
				j.mb(msg);
				break;
			case "로그":
				l.mb(msg);
				break;
			case "!!":
				e.eventmsg(msg);
				break;
			case "##":
				b.info(msg.substring(2));
			}

		}
	}
	
	public void sendP(String event) {
		synchronized (this) {
			System.out.println(event);
			for(int i=0;i<peventT.size();i++) {
				if(peventT.get(i).getEvent().equals(event)) {
					peventT.get(i).chart();
				}
			}
		}
	}
	
	public void sendB(data d) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i<peventT.size();i++) {
					if(peventT.get(i).getEvent().equals(d.getevent())) {
						peventT.get(i).jjlist(d.getBroker());
					}
				}
			}
		}).start();
	}
	
	public void sendC(data d) {
		for(int i = 0; i<peventT.size();i++) {
			if(peventT.get(i).getEvent().equals(d.getevent())) {
				peventT.get(i).info(d.getChart(), d.getRow(), d.getCenterP());
				
			}
		}
	}
}
			

