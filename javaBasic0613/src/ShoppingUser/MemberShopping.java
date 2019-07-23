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
			default: System.out.println("1~3번만 눌러주세요.");
			}
		}
	}
	
	private void menu() {
		System.out.println("1. 물품구경");
		System.out.println("2. 장바구니보기");
		System.out.println("3. 이전메뉴");
		
	}

	private void viewBasket() {
		ArrayList<Goods> mlist = nowUser.getMybasket();
		
		for(int i=1;i<mlist.size();i++) {
			System.out.println(nowUser.getName()+"님");
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
			System.out.println(i+"번 : "+glist.get(i).getName()+"/"+glist.get(i).getCnt());
		}
			
		System.out.println("물건 구매: y/취소 :x");
		String x = in.nextLine();
		if("x".equals(x) || "X".equals(x)) {
		}else if("y".equals(x) || "Y".equals(x)) {
		    System.out.println("구매 하실 물건의 번호를 입력해주세요 ");
			snum1 = in.nextInt();
			in.nextLine();
			myb.setName(glist.get(snum1).getName());

			boolean chek = true;
			while(chek) {
				System.out.println("수량을 입력해주세요");
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
					System.out.println("재고 수량 보다 같거나 작게 입력해주세요");
					
				}
				
			}
			
		}
	}
	

			
	



	private void infoUser() {
		System.out.println(nowUser.getId()+"/"+nowUser.getName());
	}

}
