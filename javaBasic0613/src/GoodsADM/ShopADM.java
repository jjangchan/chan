package GoodsADM;

import java.util.ArrayList;
import java.util.Scanner;

import Object.Goods;

public class ShopADM {
	private static ShopADM Ssingleton=null;
	private ShopADM() {}
	private ArrayList<Goods> gList = new ArrayList<>();
	public ArrayList<Goods> getgList() {
		return gList;
	}
	private Scanner in = new Scanner(System.in);
	
	public static ShopADM getInstence() {
		if(Ssingleton == null) {
			Ssingleton = new ShopADM();
		}
		return Ssingleton;
	}
	

	public void ShopManager() {
       boolean frag = true;
		
		while(frag) {
			menu();
			int sNum = in.nextInt();
			in.nextLine();
			switch(sNum) {
			case 1 : insert(); break;
			case 2 : list(); break;
			case 3 : frag = false; break;
			default : System.out.println("1~4 ���� �Է����ּ���.");
			}
		}
	}

	private void insert() {
		Goods newGoods = new Goods();
		System.out.println("�߰� �� ��ǰ�� �Է� :");
		String name = in.nextLine();
		System.out.println(" �߰��� �� ��ǰ�� ���� :");
		int cnt = in.nextInt();
		in.nextLine();
		newGoods.setName(name);
		newGoods.setCnt(cnt);
		gList.add(newGoods);
		
	}

	

	private void list() {
		for(int i=0;i<gList.size();i++) {
			System.out.println(gList.get(i).getName()+" / "+gList.get(i).getCnt());
		}
		
	}

	private void menu() {
		System.out.println("1. ��ǰ���");
		System.out.println("2. ��ǰ����Ʈ");
		System.out.println("3. �����޴�");
		
	}

}
