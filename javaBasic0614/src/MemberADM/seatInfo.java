package MemberADM;

import java.util.Scanner;

import Info.MADM;
import Object.Seat;


public class seatInfo {
	private static seatInfo ssingleton = null;
	seatInfo(){}
	Scanner in = new Scanner(System.in);
	Seat[]sN = new Seat[10];
	int mynum;
	String myn;
	private MADM mp = null;
	private Seat ps = new Seat();
	
	
	public static seatInfo getInstence() {
		if(ssingleton == null) {
			ssingleton = new seatInfo();
		}
		return ssingleton;
	}
	
	public void Sadd() {
		boolean chk = true;
		while(chk) {
			System.out.println("앉고 싶은 0번 자리~9번 자리 중 선택하세요.");
			mynum = in.nextInt();
			in.nextLine();
			if(mynum<=9) {
				if(sN[mynum] == null) {
					sN[mynum] = new Seat();
	                ps.setSeatI(mynum);			
					System.out.println("성함을 입력해주세요");
					myn = in.nextLine();
					ps.setSeatN(myn);
					
					chk = false;
				}else {
					System.out.println("이미 있는 자리입니다.");
				}
			}else {
				System.out.println("0~9번 만 선택해주세요");
			}
		}
    }
	
	public void Sout() {
		System.out.println("계산 할 테이블 번호를 입력해주세요.");
		mynum = in.nextInt();
		for(int i=0;i<sN.length;i++) {
			if(sN[i] != null) {
				System.out.println(sN[i].getSeatI()+" / "+sN[i].getSeatN());
			}else {
				System.out.println("선택 하신 테이블은 비워있는 자리입니다.");
				break;
			}
		}
		sN[mynum] = null;
	}
	
	private void Slist() {
		for(int i=0;i<sN.length;i++) {
			if(sN[i] != null) {
				System.out.println(sN[i].getSeatI()+" / "+sN[i].getSeatN());
			}
		}
	}
	
	public void Smy() {
	    Slist();
		System.out.println("주문 할 좌석을 선택해주세요");
		mynum = in.nextInt();
		in.nextLine();
		sN[mynum] = mp.Mprocess();
	}
	
			
	
	
				
	
			

}
