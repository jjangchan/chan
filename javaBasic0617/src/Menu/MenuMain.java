package Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuMain {
	private static MenuMain msingleton = null;
	private Scanner in = new Scanner(System.in);	
	private MenuMain() {}
	private ArrayList<Onemanu> menuList = new ArrayList<>();	
    
	public static MenuMain getinstence() {
		if(msingleton == null) {
			msingleton = new MenuMain();
		}
		return msingleton;
	}
	
	public ArrayList<Onemanu> getMenuList() {
		return menuList;
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
	public void list() {
		for(int i=0;i<menuList.size();i++) {
			System.out.println(menuList.get(i).getMenuname()+" / "+menuList.get(i).getMenuPrice()+"원");
		}
		
	}
	private void add() {
		Onemanu menulist = new Onemanu();
		System.out.println("추가 할 제품을 입력");
		menulist.setMenuname(in.nextLine());
		System.out.println("추가 한 제품에 가격을 입력");
		menulist.setMenuPrice(in.nextInt());
		menuList.add(menulist);
		
	}
	private void menu() {
		System.out.println("메뉴");
		System.out.println("1. 메뉴 추가");
		System.out.println("2. 메뉴 보기");
		System.out.println("3. 이전 메뉴");
	
	}
	

}
