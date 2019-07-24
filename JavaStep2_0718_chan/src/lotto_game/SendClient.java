package lotto_game;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

import TatalD.MemberDAO;
import TatalD.MemberDTO;

public class SendClient extends Thread {
	InputStream is;
	OutputStream os;
	Socket myclient = null;
	String taket = "/";
	int cnt = 0;
	String id;
	

	MemberDAO dao = MemberDAO.getInstence();
	String[] slotto = new String[46];
	String[] clotto = new String[46];
	Random r = new Random();
	MemberDTO dto = new MemberDTO();
	ArrayList<String> clottoT = new ArrayList<>();
	ArrayList<String> slottoT = new ArrayList<>();
	ArrayList<MemberDTO> chklog;

	SendClient(Socket s) {
		this.myclient = s;
	}

	@Override
	public void run() {
		menu();
	}
	private void menu() {
		try {
			is = myclient.getInputStream();
			os = myclient.getOutputStream();
			
			while(true) {
				System.out.println("1");
				byte[] buf = new byte[100];
				is.read(buf);
				String imsi = new String(buf).trim();
				switch(imsi) {
				case "o" : Streamst(); break; 
				case "y" : joinn(); break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void joinn() {
		try {
			boolean frag = true;
            while (frag) {
            	String imsi = "id 입력해주세요.";
				os.write(imsi.getBytes());
				
				is = myclient.getInputStream();
				byte[]buf = new byte[100];
				is.read(buf);
				id = new String(buf).trim();
				dto.setId(id);
				chklog = dao.getList(dto);

				if (chklog == null) {
					imsi = "pwd를 입력해주세요.";
					os.write(imsi.getBytes());

					buf = new byte[100];
					is.read(buf);
					String pwd = new String(buf).trim();
					dto.setPwd(pwd);

					imsi = "name을 입력해주세요.";
					os.write(imsi.getBytes());

					buf = new byte[100];
					is.read(buf);
					String name = new String(buf).trim();
					dto.setPwd(name);
					dao.insert2(dto);
					frag = false;
				} else {
					imsi = "id가 중복 됩니다..";
					os.write(imsi.getBytes());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void Streamst() {
		try {
			boolean frag = true;
			while (frag) {
				byte[] buf = new byte[100];
				is.read(buf);
				id = new String(buf).trim();
				System.out.println(id);
				dto.setId(id);
				chklog = dao.getList(dto);
				if (chklog == null) {
					System.out.println("2");
					id = "없는 id 입니다.";
					os.write(id.getBytes());
				} else {
					System.out.println("3");
					String imsi = "pwd를 입력해 주세요.";
					os.write(imsi.getBytes());
					buf = new byte[100];
					is.read(buf);
					String pwd = new String(buf).trim();
					System.out.println(pwd);
					for (int i = 0; i < chklog.size(); i++) {
						if (chklog.get(i).getPwd().equals(pwd)) {
							imsi = "로그인 성공! 로또  번호를 보내주세요~\r\n" + "1~45번까지 로또 번호를 입력해주세요!";

							os.write(imsi.getBytes());
							frag = false;
							break;
						} else {
							pwd = "비밀번호가 틀립니다.";
							os.write(pwd.getBytes());
						}
					}
				}

			}
			receiveData();
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void receiveData() {
		try {
			int cnt = 0;
			int cnt1 = 0;
			String imsi = "";
			while (true) {
				// cnt1 = 1~2 맞춘 값 ,cnt1 =3 총값
				cnt1++;
				is = myclient.getInputStream();
				byte[] buff = new byte[250];
				is.read(buff);
		

				String lotto = new String(buff).trim();
				System.out.println(lotto);
				clottoT.add(lotto);
				for (int i = 0; i < 6; i++) {
					cnt++; // db에 컬럼명을 분류 하려고
					imsi = lotto.substring(0, lotto.indexOf(taket)); // 개별 로또 추출
					int imsi2 = Integer.parseInt(imsi); // 개별 로또 값 int형 변환
					setDB(imsi2, cnt); // db에 개별 로또번호랑 cnt 카운터수
					clotto[imsi2] = "o"; // 받은 개별 로또 마다 로그 남기기
					lotto = lotto.substring(lotto.indexOf(taket) + 1); // 로또 값 가공
					if (cnt == 6) {
						cnt = 0;
					}

				}
				for (int i = 0; i < clotto.length; i++) {
					if (clotto[i] == null) {
						clotto[i] = "c"; // 디폴트값을 구별하기 위해서 c로지정
					}
				}
				System.out.println(cnt1);
				sendData(cnt1); // 결과에 대해 client 에게 보내기
				if (cnt1 == 3) {
					cnt1 = 0;
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void sendData(int cnt1) {
		String imsi = "";
		String imsi1 = "";
		String imsi2 = "";
		String imsi3 = "";
		String imsi22 = null;
		String bounsS = null;
		int bouns=0;
		System.out.println("senddate");
		for (int i = 0; i < 7; i++) { // 서버에서 랜덤으로 뽑은 로또 중복안되게 체크 하기
			int rnum = r.nextInt(45) + 1;
			if (slotto[rnum] == null) {
				if(i<6) {
					slotto[rnum] = "o";
				}else {
					slotto[rnum] = "보너스";
					bounsS = "("+rnum+": 보너스 번호)";
				}
			} else {
				i--;
			}
		}
		
//		slotto[1]="o";
//		slotto[2]="o";
//		slotto[3]="o";
//		slotto[4]="o";
//		slotto[5]="o";
//		slotto[17]="o";
//		slotto[13]="보너스";
					

		for (int i = 0; i < slotto.length; i++) {
			if (slotto[i] == null) {
				slotto[i] = "s"; // 서버의 디폴트 값을 s로 로그 남기기
			} else if(slotto[i] == "o") {
				imsi3 = i + "/" + imsi3;
			}
		}

		slottoT.add(imsi3+bounsS); // 서버에 대한 로또 결과를 arraylist 에 저장

		for (int i = 0; i < slotto.length; i++) { // 서버 랑 클라이언트에 로또 당첨값을 비교하는것
			if (slotto[i] == clotto[i]) {
				cnt++; // 비교한 갯수 카운터
				slotto[i]="s";
				clotto[i]="c";
				imsi ="("+ i + " 번호 ) " + imsi; // 당첨 된값을 string 형으로 가공 하기
			}
		}
		if(cnt==5) {
			for(int i=0; i<slotto.length;i++) {
				if(slotto[i]=="보너스" && clotto[i]=="o") {
					imsi22 =imsi+"("+i+" : 보너스 번호)"+"를 맞췄습니다."+" / "+(7-cnt)+" 등  ";
					bouns++;
					System.out.println(bouns);
				}
			}
		}
		if(cnt==6) {
				
			imsi =imsi+"를 맞췄습니다."+" / "+(7-cnt)+" 등  ";
		}else if(cnt>2 && bouns==0){
			imsi =imsi+"를 맞췄습니다."+" / "+(8-cnt)+" 등  ";
		}
		try {
			if (cnt1 < 3) { // 1~2번 맞춘값만
				if (cnt<3) {
					imsi = "꽝. 다음 기회에.";
					os.write(imsi.getBytes());
				} else if(bouns==0){
					os.write(imsi.getBytes());
				}else if(bouns==1) {
					os.write(imsi22.getBytes());
				}
			} else { // 3번 은 모든 결과값을
				for (int i = 0; i < 3; i++) {

					imsi2 = clottoT.get(i);
					imsi1 = slottoT.get(i);
					imsi2 = "[당신의 " + i + " 회 차 " + "로또 번호]" + "[" + imsi2 + "]";
					imsi1 = "[오늘의 " + i + " 회 차 " + "로또 번호]" + "[" + imsi1 + "]";
					os.write((imsi2 + "/" + imsi1).getBytes());

				}
				cnt1 = 0; // 카운터수 초기화 시켜주기
				clottoT = new ArrayList<String>();
				slottoT = new ArrayList<String>();
			}
			cnt=0;
			bouns=0;
			slotto = new String[46]; // 배열 초기화
			clotto = new String[46];
			imsi = "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setDB(int imsi, int cnt) {
		switch(cnt) {
			case 1 :dto.setId(id);
					dto.setLotto1(imsi);
					break;
			case 2 :dto.setLotto2(imsi);
					break;
			case 3 :dto.setLotto3(imsi);
					break;
			case 4 :dto.setLotto4(imsi);
					break;
			case 5 :dto.setLotto5(imsi);
					break;
			case 6 :dto.setLotto6(imsi);
					dao.insert(dto);
					break;
		}
	}
}
