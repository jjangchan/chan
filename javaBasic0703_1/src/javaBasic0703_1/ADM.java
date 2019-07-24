package javaBasic0703_1;

import java.util.Scanner;

public class ADM {
	Scanner in = new Scanner(System.in);
	Fun f;
	
	public ADM() {
		seting();
		boolean frag = true;
		while(frag) {
			menu();
			int snum = in.nextInt();
			in.nextLine();
			switch(snum) {
			case 1 : add(); break;
			case 2 : see(); break;
			case 3 : mod(); break;
			case 4 : del(); break;
			case 5 : frag = false; break;
			default : System.out.println("1~5번만 선택");
			}
		}
		
	}
	
	private void mod() {
		f.inputmod();
		
	}

	private void del() {
		f.inputdel();
		
	}

	public void seting() {
		f = Fun.getInstence();
		f.seting();
	}

	private void see() {
		f.inputsee();
	}

	private void add() {
		f.inputadd();
		
	}
	
	private void menu() {
		System.out.println("메뉴선택");
		System.out.println("1. 추가");
		System.out.println("2. 리스트");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 종료");
	}
}
		

	
