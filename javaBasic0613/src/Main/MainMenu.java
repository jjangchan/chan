package Main;

import java.util.Scanner;

import GoodsADM.ShopADM;
import MemberADM.MemberCenter;
import Object.Member;
import ShoppingUser.MemberShopping;

public class MainMenu {
	Scanner in = new Scanner(System.in);
	private MemberCenter mc = null;
	private ShopADM sc =null;
	MainMenu(){
		boolean frag = true;
		
		while(frag) {
			menu();
			int sNum = in.nextInt();
			in.nextLine();
			switch(sNum) {
			case 1 : member(); break;
			case 2 : shop(); break;
			case 3 : login(); break;
			case 4 : frag = false; break;
			default : System.out.println("1~4 번만 입력해주세요.");
			}
		}
	  
	}
	
	
	private void login() { //다시 check
		System.out.println("id를 입력해주세요");
		String id =in.nextLine();
		Member nowM = mc.logMember(id);
		if(nowM != null) {
			new MemberShopping(nowM);
		}
		
		
	}


	private void shop() {
		sc=ShopADM.getInstence();
		sc.ShopManager();
		
	}


	private void member() {
		mc=MemberCenter.getInstence();
		mc.MemberProcess();
		
	}


	private void menu() {
		System.out.println("메뉴");
		System.out.println("1. 회원관리");
		System.out.println("2. 물품 관리");
		System.out.println("3. 로그인");
		System.out.println("4. 종료");
	}


}
