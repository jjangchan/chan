package Main;

import java.util.Scanner;

import MemberADM.seatInfo;

public class Maininfo {
	Scanner in = new Scanner(System.in);
	private seatInfo ss = null;
	
	Maininfo(){
		
		boolean frag = true;
		while(frag) {
			menu();
			int num = in.nextInt();
			in.nextLine();
			switch(num) {
			case 1 : inputV();break;
			case 2 : outputV(); break;
			case 3 : order(); break; 
			case 4 : frag = false; break;
			default : System.out.println("1~3번만 입력");
			}
		}
	}
	
	private void menu() {
		System.out.println("포스기");
		System.out.println("1.손님 방문");
		System.out.println("2.주문 받기");
		System.out.println("3.손님 계산");
		System.out.println("4. 종료");
	}
	
	private void inputV() {
		ss = seatInfo.getInstence();
		ss.Sadd();
	}
	
	private void outputV() {
		ss = seatInfo.getInstence();
		ss.Sout();
	}
	
	private void order() {
		ss = seatInfo.getInstence();
		ss.Smy();
	}

}
