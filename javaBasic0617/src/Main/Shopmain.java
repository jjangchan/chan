package Main;

import java.util.Scanner;

import Menu.MenuMain;
import Table.Tableinfo;

public class Shopmain {
	private Tableinfo[] tableinfo = new Tableinfo[5];
	private Scanner in = new Scanner(System.in);
	private MenuMain mm = null;
	Shopmain(){
		setin();
		init();	
		boolean frag = true;
		while(frag) {
			menu();
			int selnum = in.nextInt();
			in.nextLine();
			switch(selnum) {
			case 1 : newTable(); break;
			case 2 : tableList(); break;
			case 3 : menuADM(); break;
			case 4 : frag = false; break;
			default : break;
			}
		}
	}

	private void setin() {
		mm = MenuMain.getinstence();
	}

	private void menuADM() {
		mm.menuMain();
		
	}

	private void tableList() {
		
	}

	private void newTable() {
		for(int i=0;i<tableinfo.length;i++) {
			if(tableinfo[i]==null) {
				Tableinfo nowT = new Tableinfo();
				System.out.println(i+"번 테이블");
				tableinfo[i] = nowT;
			}
		}
				
	}

	private void menu() {
		System.out.println("메뉴");
		System.out.println("1. 좌석배정");
		System.out.println("2. 좌석정보");
		System.out.println("3. 메뉴관리");
		System.out.println("4. 종류");
		
	}

	private void init() {
		
		
	}
	

}
