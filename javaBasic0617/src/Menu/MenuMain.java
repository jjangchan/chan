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
			System.out.println(menuList.get(i).getMenuname()+" / "+menuList.get(i).getMenuPrice()+"��");
		}
		
	}
	private void add() {
		Onemanu menulist = new Onemanu();
		System.out.println("�߰� �� ��ǰ�� �Է�");
		menulist.setMenuname(in.nextLine());
		System.out.println("�߰� �� ��ǰ�� ������ �Է�");
		menulist.setMenuPrice(in.nextInt());
		menuList.add(menulist);
		
	}
	private void menu() {
		System.out.println("�޴�");
		System.out.println("1. �޴� �߰�");
		System.out.println("2. �޴� ����");
		System.out.println("3. ���� �޴�");
	
	}
	

}
