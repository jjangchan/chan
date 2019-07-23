package shop;

import java.util.ArrayList;
import java.util.Scanner;

import goods.goods2;



public class Member {
	private Scanner in=new Scanner(System.in);
	private String id=null;
	private String name=null;
	private ArrayList<String> basketList=new ArrayList<>();
	private goods2 mygood=null;
	private ArrayList<String> imsi= new ArrayList<>();
	public Member() {
		mygood=goods2.getinstance();
	}
	
	public void setDate() {
		System.out.println("id를 입력하세요 :");
		id=in.nextLine();
		System.out.println("이름을 입력하세요.");
		name=in.nextLine();
	}
	public void shopping() { //비회원전용
		System.out.println("로그인정보 :"+id);
		System.out.println("1. 물건구매");
		//System.out.println("2. 장바구니보기");
		//System.out.println("3. 종료");
		
		//test
		addList();
	}
	public void addList() {
		goodsList();
		System.out.println("물건 번호 선택");
		int num=in.nextInt();
		in.nextLine();
		basketList.add(imsi.get(num));
		viewBasketList();
		
	}
	public void viewBasketList() {
		System.out.println("-------------장바구니----");
		for(int i=0;i<basketList.size();i++ ) {
			System.out.println(i+"번 물건 :"+basketList.get(i));
		}
		System.out.println("-----------------------");
	shopping();
	}
	
	
	public void goodsList() {
		
		imsi=mygood.getGlist();
		for(int i=0;i<imsi.size();i++) {
			System.out.println(i+"번 물건 :"+imsi.get(i));
		}
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	
                                                                                                                                  
}
