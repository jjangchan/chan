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
			default : System.out.println("1~3���� �Է�");
			}
		}
	}
	
	private void menu() {
		System.out.println("������");
		System.out.println("1.�մ� �湮");
		System.out.println("2.�ֹ� �ޱ�");
		System.out.println("3.�մ� ���");
		System.out.println("4. ����");
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
