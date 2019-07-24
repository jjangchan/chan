package Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuMain {
	public static ArrayList<OneMenu> menuList = new ArrayList<>();
	private Scanner in = new Scanner(System.in);
	private static MenuMain mm=null;
	
	private MenuMain(){
		
	}
	
	public static ArrayList<OneMenu> getMenuList() {
		return menuList;
	}
	
	public static MenuMain getInstance() {
		if(mm==null) {
			mm = new MenuMain();
		}
		return mm;
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
	private void menu() {
		System.out.println("메뉴선택 ------------");
		System.out.println(" 1. 메뉴추가 ------------");
		System.out.println(" 2. 메뉴보기 ------------");
		System.out.println(" 3. 메뉴관리종료 ------------");
	}
	private void list() {
		// TODO Auto-generated method stub
		for(int i=0; i < menuList.size(); i++) {
			System.out.println("메뉴번호 "+i+":"+menuList.get(i).getMenuName()+
					"/"+menuList.get(i).getMenuPrice());
		}
	}

	private void add() {
		OneMenu imsiM = new OneMenu();
		System.out.println("메뉴이름을 입력하세요");
		imsiM.setMenuName(in.nextLine());
		System.out.println("메뉴가격을 입력하세요");
		imsiM.setMenuPrice(in.nextInt());
		in.nextLine();
		
		menuList.add(imsiM);
		
		
	}
	

}






