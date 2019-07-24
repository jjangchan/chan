package LottoC;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class WithServerLottoC {
	String id = null;
	String pwd = null;
	String name = null;
	int lotto = 0;
	String lottoT = "";
	InputStream reMsg = null;
	OutputStream sendMsg = null;
	int[] chk = new int[46];
	Socket myClient = null;
	String msg;
	boolean frag;
	
	Scanner in = new Scanner(System.in);

	public WithServerLottoC(Socket s) {
		this.myClient = s;
		try {
			reMsg = myClient.getInputStream();
			sendMsg = myClient.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adm();
	}
	
	private void menu() {
		System.out.println("메뉴");
		System.out.println("1. 로또 하기");
		System.out.println("2. 회원 가입");
		System.out.println("3. 종료");
	}
	
	private void adm() {
	    boolean frag1 = true;
	    while(frag1) {
	    	menu();
	    	int snum = in.nextInt();
	    	in.nextLine();
	    	switch(snum) {
	    	case 1 : streamSet(); break;
	    	case 2 : join(); break;
	    	case 3 : frag1 = false; break;
	    	default:System.out.println("1~3번만 입력바람");
	    	}
	    }
	    
	}

	private void join() {
		System.out.println("회원 가입 하시겠습니까?(y입력)");
		String join = in.nextLine();
		try {
			sendMsg.write(join.getBytes());
			frag = true;
			while(frag) {
				reMsg = myClient.getInputStream();
				byte[] reBuf = new byte[100];
				reMsg.read(reBuf);
				msg = new String(reBuf).trim();
				System.out.println(msg);
				
				id=in.nextLine();
				sendMsg.write(id.getBytes());
				
				reBuf = new byte[100];
				reMsg.read(reBuf);
				msg = new String(reBuf).trim();
				System.out.println(msg);
				
				if(!"id".equals(msg.substring(0,2))) {
					pwd=in.nextLine();
					sendMsg.write(pwd.getBytes());
					
					reBuf = new byte[100];
					reMsg.read(reBuf);
					msg = new String(reBuf).trim();
					System.out.println(msg);
					
					name=in.nextLine();
					sendMsg.write(name.getBytes());

					frag = false;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void streamSet() {
		try {
			
		    frag = true;
		    System.out.println("게임을 시작하시겠습니까!(o입력)");
		    id = in.nextLine();
		    sendMsg.write(id.getBytes());
			while(frag) {
				
	
				System.out.println("ID를 입력해주세요!");
				id = in.nextLine();
				sendMsg.write(id.getBytes());
				byte[] reBuf = new byte[100];
				reMsg.read(reBuf);
				msg = new String(reBuf).trim();
				System.out.println(msg);
					if(!"없는".equals(msg.substring(0,2))) {
						id = in.nextLine();
						sendMsg.write(id.getBytes());
						
						reBuf = new byte[100];
						reMsg.read(reBuf);
						msg = new String(reBuf).trim();
						System.out.println(msg);
						if("로그인".equals(msg.substring(0,3))) {
						
							frag = false;
						}
					}
					
				
			}
			sendData();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void sendData() {
		try {
			receiveData();
			int cnt = 0;
			boolean frag = true;
			while (frag) {
				cnt++;
				if (cnt < 4) {
					lottoT="";
					for (int i = 0; i < 6; i++) {
						lotto = in.nextInt();
						in.nextLine();
						if(lotto==0) {
							System.out.println("0 번호는 없습니다. 다시입력 바람");
							i--;
						}
						if(lotto>45) {
							System.out.println("45 이하 까지 입력 해주세요");
							i--;
						}else if(lotto<46 && lotto!=0){
							if (chk[lotto] == 0) {
								chk[lotto] = 1;
								lottoT = lotto + "/" + lottoT;
								System.out.println(lotto+" 번호 입력됨");
							} else if (chk[lotto] != 0) {
								System.out.println("중복 : 로또 번호를 다시 입력해주세요!");
								i--;
							}
							
						}

					}
					System.out.println(lottoT);
					sendMsg = myClient.getOutputStream();
					sendMsg.write(lottoT.getBytes());
					System.out.println("write");
					chk = new int[46];
				}else {
					System.out.println("게임을 끝났습니다. 더 하시겠습니까?y");
					String yorn = in.nextLine();
					if(yorn.equalsIgnoreCase("y") ) {
						cnt=0;
					}else {
						frag = false;
					}
				}


			}
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	private void receiveData() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {

					while (true) {

						byte[] reBuf = new byte[100];
						reMsg.read(reBuf);
						msg = new String(reBuf).trim();
						System.out.println(msg);

					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		}

}
