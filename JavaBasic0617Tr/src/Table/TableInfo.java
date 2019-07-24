package Table;

import java.util.ArrayList;
import java.util.Scanner;

import Menu.MenuMain;
import Menu.OneMenu;

public class TableInfo {
	private ArrayList<OneMenuInfo> orderList=new ArrayList<>(); // ���� �ֹ��� �޴�����
	private ArrayList<OneMenu> nowMenu= new ArrayList<>();   // ������ �޴���
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
			System.out.println("�޴���ȣ "+i+":"+nowMenu.get(i).getMenuName()+
					"/"+nowMenu.get(i).getMenuPrice());
		}
	}
	public void list() {
		for(int i=0; i < orderList.size(); i++) {
			System.out.println(i + " �� �ֹ� ��ǰ------");
			orderList.get(i).prt();
		}
		
	}
	private void add() {
		menuList();
		System.out.println(" �޴� ��ȣ�� �����ϼ��� : ");
		int menuNum = in.nextInt();
		in.nextLine();
		System.out.println(" ������ �����ϼ���");
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
		System.out.println(" 1. �޴�����");
		System.out.println(" 2. �ֹ�����");
		System.out.println(" 3. �����޴���");
	}
	
	
	
	
	

}
