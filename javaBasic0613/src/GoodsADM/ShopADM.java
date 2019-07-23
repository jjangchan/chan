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
			default : System.out.println("1~4 번만 입력해주세요.");
			}
		}
	}

	private void insert() {
		Goods newGoods = new Goods();
		System.out.println("추가 할 물품을 입력 :");
		String name = in.nextLine();
		System.out.println(" 추가할 할 물품을 수량 :");
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
		System.out.println("1. 물품등록");
		System.out.println("2. 물품리스트");
		System.out.println("3. 이전메뉴");
		
	}

}
