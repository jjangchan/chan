package Table;

import java.util.ArrayList;
import java.util.Scanner;

import Menu.MenuMain;
import Menu.OneMenu;

public class TableInfo {
	private ArrayList<OneMenuInfo> orderList=new ArrayList<>(); // 내가 주문한 메뉴내역
	private ArrayList<OneMenu> nowMenu= new ArrayList<>();   // 가게의 메뉴판
	private Scanner in = new Scanner(System.in);
	private MenuMain mm = null;
	public TableInfo(){
		init();
		
	}
	
	public void init(){
		mm = MenuMain.getInstance();
		nowMenu = mm.getMenuList();
	}

	public void menuMain() {
		boolean flag = true;
		while(flag) {
			menu();
			int selNum = in.nextInt();
			in.nextLine();
			switch(selNum) {
			case 1: add(); break;
			case 2: list(); break;
			case 3: flag=false; break;
				default : 
			}
		}
	}
	
	private void menuList() {
		for(int i=0; i < nowMenu.size(); i++) {
			System.out.println("메뉴번호 "+i+":"+nowMenu.get(i).getMenuName()+
					"/"+nowMenu.get(i).getMenuPrice());
		}
	}
	public void list() {
		for(int i=0; i < orderList.size(); i++) {
			System.out.println(i + " 번 주문 상품------");
			orderList.get(i).prt();
		}
		
	}
	private void add() {
		menuList();
		System.out.println(" 메뉴 번호를 선택하세요 : ");
		int menuNum = in.nextInt();
		in.nextLine();
		System.out.println(" 수량을 선택하세요");
		int menuNumCnt = in.nextInt();
		in.nextLine();
		
		OneMenuInfo imsiOne = new OneMenuInfo();
		imsiOne.setOneMenuFlag(menuNum);
		imsiOne.setMenuName(nowMenu.get(menuNum).getMenuName());
		imsiOne.setMenuPrice(nowMenu.get(menuNum).getMenuPrice());
		imsiOne.setCnt(menuNumCnt);

		orderList.add(imsiOne);
	}
	public void menu() {
		System.out.println("-- tableInfo Menu ---");
		System.out.println(" 1. 메뉴선택");
		System.out.println(" 2. 주문내역");
		System.out.println(" 3. 이전메뉴로");
	}
	
	
	
	
	

}
