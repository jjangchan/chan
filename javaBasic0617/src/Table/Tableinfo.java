package Table;

import java.util.ArrayList;
import java.util.Scanner;

import Menu.MenuMain;
import Menu.Onemanu;

public class Tableinfo {
	private Scanner in = new Scanner(System.in);
	private ArrayList<Onemenuinfo> orderlist = new ArrayList<>();
	private ArrayList<Onemanu> mymenu = new ArrayList<>();
	private MenuMain mp = null;
	public Tableinfo(){
		inti();
	}
	
	private void inti() {
		mp=MenuMain.getinstence();
		mymenu=mp.getMenuList();
	}

	public void menuMain() {
		boolean frag = true;
		while(frag) {
			menu();
			int selnum = in.nextInt();
			in.nextLine();
			switch(selnum) {
			case 1 : add(); break;
			case 2 : list(); break;
			case 3 : frag = false; break;
			default : break;
			}
		}
	}
	
	private void menu() {
		System.out.println("주문");
		System.out.println("1. 주문하기");
		System.out.println("2. 주문내역");
		System.out.println("3. 이전메뉴");		
	}
	
	private void list() {
		for(int i=0;i<orderlist.size();i++) {
			System.out.println(i+"번 주문 상품");
			orderlist.get(i).prt();
		
		}
		
	}

	private void add() {
		mp.list();
		Onemenuinfo myM = new Onemenuinfo();
		System.out.println("주문 할 제품 번호를 입력하세요");
		int sNum = in.nextInt();
		in.nextLine();
		System.out.println("수량을 입력해주세요");
		int sNumcnt = in.nextInt();
		in.nextLine();
		myM.setMenuName(mymenu.get(sNum).getMenuname());
		myM.setCnt(mymenu.get(sNum).getMenuPrice());
		myM.setCnt(sNumcnt);
		myM.setOneMenuFlag(sNum);
		
		orderlist.add(myM);
	}

}
