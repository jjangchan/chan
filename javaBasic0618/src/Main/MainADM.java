package Main;

import java.util.Scanner;

import funtion.Fuction;

public class MainADM {
	Scanner in = new Scanner(System.in);
	private Fuction f = null;
	
	MainADM() {
		seting();
		menumane();
	}
	
	private void menumane() {
         boolean frag = true;
		
		while(frag){
			menu();
			int snum = in.nextInt();
			in.nextLine();
			switch(snum) {
			case 1 : inputadd();break;
			case 2 : inputmod();break;
			case 3 : inputlist();break;
			case 4 : inputdel();break;
			case 5 : inputserh();break;
			case 6 : inputcm();break;
			case 7 : inputcmsee();break;
			case 8 : frag = false; break;
			default : System.out.println("1~6���� ����");
			}
		}
	}
	
	private void seting() {
		f=Fuction.getInstence();
		
	}
	
	private void inputserh() {
		f.select();
		
	}

	private void inputdel() {
		f.del();
		
	}

	private void inputlist() {
		f.list();
		
	}

	private void inputmod() {
		f.mod();
		
	}

	private void inputadd() {
		f.add();
	
	}
	
	private void inputcm() {
		f.cminsert();
	
	}
	
	private void inputcmsee() {
		f.cmsee();
	
	}

	private void menu() {
		System.out.println("ȸ���������α׷�");
		System.out.println("1. ȸ������");
		System.out.println("2. ȸ������");
		System.out.println("3. ȸ������Ʈ");
		System.out.println("4. ȸ��Ż��");
		System.out.println("5. ȸ���˻�");
		System.out.println("6. ��۴ޱ�");
		System.out.println("7. ��ۺ���");
		System.out.println("8. ����");
	}
	


}
