package Step1;

import java.util.Scanner;

public class MainGame {
	Function f;
	Scanner in = new Scanner(System.in);
	MainGame(){
		seting();
		boolean frag = true;
		while(frag) {
			menu();
			int snum = in.nextInt();
			in.nextLine();
			switch(snum) {
				case 1 : input(); break;
				case 2 : chek(); break;
				case 3 : frag = false; break;
				default : System.out.println("1~2번만 입력");
			}
		}
	
	}
	
	private void chek() {
		f.list();
		
	}

	private void input() {
		f.add();
		
	}

	private void seting() {
		f = Function.getInstence();
	}
	
	private void menu() {
		System.out.println("다트 점수판");
		System.out.println("1. 점수입력");
		System.out.println("2. 점수확인");
		System.out.println("3. 종료");
	}

}
