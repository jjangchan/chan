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
		System.out.println("id�� �Է��ϼ��� :");
		id=in.nextLine();
		System.out.println("�̸��� �Է��ϼ���.");
		name=in.nextLine();
	}
	public void shopping() { //��ȸ������
		System.out.println("�α������� :"+id);
		System.out.println("1. ���Ǳ���");
		//System.out.println("2. ��ٱ��Ϻ���");
		//System.out.println("3. ����");
		
		//test
		addList();
	}
	public void addList() {
		goodsList();
		System.out.println("���� ��ȣ ����");
		int num=in.nextInt();
		in.nextLine();
		basketList.add(imsi.get(num));
		viewBasketList();
		
	}
	public void viewBasketList() {
		System.out.println("-------------��ٱ���----");
		for(int i=0;i<basketList.size();i++ ) {
			System.out.println(i+"�� ���� :"+basketList.get(i));
		}
		System.out.println("-----------------------");
	shopping();
	}
	
	
	public void goodsList() {
		
		imsi=mygood.getGlist();
		for(int i=0;i<imsi.size();i++) {
			System.out.println(i+"�� ���� :"+imsi.get(i));
		}
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	
                                                                                                                                  
}
