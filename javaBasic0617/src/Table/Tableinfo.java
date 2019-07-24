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
		System.out.println("�ֹ�");
		System.out.println("1. �ֹ��ϱ�");
		System.out.println("2. �ֹ�����");
		System.out.println("3. �����޴�");		
	}
	
	private void list() {
		for(int i=0;i<orderlist.size();i++) {
			System.out.println(i+"�� �ֹ� ��ǰ");
			orderlist.get(i).prt();
		
		}
		
	}

	private void add() {
		mp.list();
		Onemenuinfo myM = new Onemenuinfo();
		System.out.println("�ֹ� �� ��ǰ ��ȣ�� �Է��ϼ���");
		int sNum = in.nextInt();
		in.nextLine();
		System.out.println("������ �Է����ּ���");
		int sNumcnt = in.nextInt();
		in.nextLine();
		myM.setMenuName(mymenu.get(sNum).getMenuname());
		myM.setCnt(mymenu.get(sNum).getMenuPrice());
		myM.setCnt(sNumcnt);
		myM.setOneMenuFlag(sNum);
		
		orderlist.add(myM);
	}

}
