package ex1;

import java.util.Scanner;

public class Member {
	String[] member=new String[5];
	Scanner in=new Scanner(System.in);
	Member(){  //�޼���(������)-��ü�� �����ɶ� ������,�� �ѹ��� ����
             //������ �޼���� �ݵ�� Ŭ���� �̸��� �����ϴ�.		
		for(;;) {
			menu();		
			int selmenu=in.nextInt();
			in.nextLine();
			switch(selmenu) {
			case 1: add(); break;
			case 2: del(); break;
			case 3: list(); break;
			case 4: mod(); break;
			default:System.out.println("������");	
			}
		}
	}
	private void mod() {
		System.out.println("���� �� ���� ��ȣ�� �Է��ϼ���.");
		list();
		System.out.println("��ȣ�Է�>");
		int delnum=in.nextInt();
		in.nextLine();
		System.out.println("������ id�� �Է��ϼ���");
		String newID=in.nextLine();
		member[delnum]=newID;
		
	}
	private void del() {
		System.out.println("������ ���� ��ȣ�� �Է��ϼ���.");
		list();
		System.out.println("��ȣ�Է�>");
		int delnum=in.nextInt();
		in.nextLine();
		member[delnum]=null;
	}
	public void menu() {//�޼��� ���� �� ���� 
		System.out.println("------------------");
		System.out.println("1. add");
		System.out.println("2. del");
		System.out.println("3. list");
		System.out.println("4. mod");
		System.out.println("-------------------");
	}
			
	public void add() {//����� �߰� �޼���
		System.out.println("�߰��� id�� �Է��ϼ���>");
		String id=in.nextLine();
		for(int i=0; i<member.length;i++) {
			if(member[i]==null) {
				member[i]=id;
				break;
			}
		}
	}
	public void list() {// ����� ���� �޼���
		for(int i=0; i<member.length;i++) {
			if(member[i]!=null) {
				System.out.println(i+"�� ��:"+member[i]);
			}
		}
		
		
	}
}
				

	
	
	
