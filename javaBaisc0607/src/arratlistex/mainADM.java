package arratlistex;

import java.util.ArrayList;
import java.util.Scanner;

public class mainADM {
	ArrayList<Member> list=new ArrayList<>();

	Scanner in=new Scanner(System.in);	
	mainADM(){
		while(true) {
			menu();
			int num=in.nextInt();
			in.nextLine();
			
			switch(num) {
			case 1:input(); break;
			case 2:del(); break;
			case 3:mod(); break;
			case 4:list(); break;
			default:
				
			}
		}
	}
	private void input() {
		
		Member imsiMember=new Member();
		System.out.println("id�Է�");
		String id=in.nextLine();
		
		for(int i=0;i<list.size();i++) {
			if(id.equals(list.get(i).id)) {
				System.out.println("�ߺ�");
				System.out.println("id�Է�");
				id=in.nextLine();
				i=0;
			}
		}
		imsiMember.minput(id);
		list.add(imsiMember);
	
		
	}
	
	
    private void del() {
		list();
		System.out.println("������ ��ȣ �Է� :");
		int delnum=in.nextInt();
		in.nextLine();
		
		list.remove(delnum);
	}
    private void list() {
		for(int i=0;i<list.size();i++) {
			//list[i].viewinfo();
			System.out.print(i+"�� ���� :");
			list.get(i).viewinfo();
		}
	}
    private void mod() {
    	list();
		System.out.println("���� �� ��ȣ �Է� :");
		int delnum=in.nextInt();
		in.nextLine();
		
		list.get(delnum).mmod();
	}
    private void menu() {
		System.out.println("�޴����� :");
		System.out.println("1. �߰�");
		System.out.println("2. ����");
		System.out.println("3. ����");
		System.out.println("4. ���");
	}
    private void menu2() {
		System.out.println("�޴����� :");
		System.out.println("1. �߰�");
		
	}

}
