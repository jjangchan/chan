package Function;

import java.util.ArrayList;

import Server.ServerCenter;

public class MainStart {
	private MainStart() {}
	private static MainStart msingleton;
	public static MainStart getInstence() {
		if(msingleton == null) {
			msingleton = new MainStart();
		}
		return msingleton;
	}
	ArrayList<String> stockN = new ArrayList<>();
	ArrayList<Fun> cenF = new ArrayList<>();
	
	
	public ArrayList<Fun> getCenF() {
		return cenF;
	}
	public void setCenF(ArrayList<Fun> cenF) {
		this.cenF = cenF;
	}
	
	public void event(){
//		stockN.add("삼성전자");
		stockN.add("신성이엔지");
//		stockN.add("모나미");
//		stockN.add("SK하이닉스");
//		stockN.add("셀트리온");
		
		for(int i=0;i<stockN.size();i++) {
			Fun go = new Fun(stockN.get(i));
			cenF.add(go);
			go.start();
		}
		new ServerCenter();
	}
}
