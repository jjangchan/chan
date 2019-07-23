package ShoppingUser;

import java.util.ArrayList;
import java.util.Scanner;

import GoodsADM.ShopADM;
import Object.Goods;
import Object.Member;

public class MemberShopping {
	private ShopADM shopLink = null;
	private Member nowUser = null;
	private Scanner in = new Scanner(System.in);
	

	
	public MemberShopping(Member c) {
		this.nowUser=c;
		infoUser();
		boolean pFlag=true;
		while(pFlag) {
			menu();
			int selNum = in.nextInt();
			in.nextLine();
			switch(selNum) {
			case 1: list(); break;
			case 2: viewBasket(); break;
			case 3:  pFlag=false;; break;
			default: System.out.println("1~3���� �����ּ���.");
			}
		}
	}
	
	private void menu() {
		System.out.println("1. ��ǰ����");
		System.out.println("2. ��ٱ��Ϻ���");
		System.out.println("3. �����޴�");
		
	}

	private void viewBasket() {
		ArrayList<Goods> mlist = nowUser.getMybasket();
		
		for(int i=1;i<mlist.size();i++) {
			System.out.println(nowUser.getName()+"��");
			System.out.println(mlist.get(i).getName()+" / "+mlist.get(i).getCnt());
		}
		
	}

	private void list() {
		
		shopLink = ShopADM.getInstence();
		ArrayList<Goods> glist = shopLink.getgList();
		System.out.println(glist.size());
		int snum3;
		int snum2;
		int snum1;
		Goods myb = new Goods();
		for(int i=0;i<glist.size();i++) {
			System.out.println(i+"�� : "+glist.get(i).getName()+"/"+glist.get(i).getCnt());
		}
			
		System.out.println("���� ����: y/��� :x");
		String x = in.nextLine();
		if("x".equals(x) || "X".equals(x)) {
		}else if("y".equals(x) || "Y".equals(x)) {
		    System.out.println("���� �Ͻ� ������ ��ȣ�� �Է����ּ��� ");
			snum1 = in.nextInt();
			in.nextLine();
			myb.setName(glist.get(snum1).getName());

			boolean chek = true;
			while(chek) {
				System.out.println("������ �Է����ּ���");
				snum2=in.nextInt();
				in.nextLine();
				if(glist.get(snum1).getCnt()>=snum2) {
					myb.setCnt(snum2);
					nowUser.getMybasket().add(myb);
					snum3 = glist.get(snum1).getCnt();
					glist.get(snum1).setCnt(snum3-snum2);
					if(glist.get(snum1).getCnt()==0) {
						glist.remove(snum1);
					}
					chek = false;
				}else {
					System.out.println("��� ���� ���� ���ų� �۰� �Է����ּ���");
					
				}
				
			}
			
		}
	}
	

			
	



	private void infoUser() {
		System.out.println(nowUser.getId()+"/"+nowUser.getName());
	}

}
