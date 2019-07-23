package MemberADM;

import java.util.ArrayList;
import java.util.Scanner;

import Object.Member;

public class MemberCenter {
	private Scanner in = new Scanner(System.in);
	private static MemberCenter msingleton = null;
	private ArrayList<Member> mList=new ArrayList<>();
	private MemberCenter(){}
	
	String id = null;
	String name = null;
	
	public static MemberCenter getInstence() {
		if(msingleton == null) {
			msingleton = new MemberCenter();
		}
		return msingleton;
	}
	
	
	public void MemberProcess() {
        boolean frag = true;
		
		while(frag) {
			menu();
			int sNum = in.nextInt();
			in.nextLine();
			switch(sNum) {
			case 1 : join(); break;
			case 2 : mod(); break;
			case 3 : del(); break;
			case 4 : list(); break;
			case 5 : frag = false; break;
			default : System.out.println("1~5 ���� �Է����ּ���.");
			}
		}
	}

	private void menu() {
		System.out.println("�޴�");
		System.out.println("1. ȸ������");
		System.out.println("2. ȸ������");
		System.out.println("3. ȸ������");
		System.out.println("4. ȸ������");
		System.out.println("5. �����޴�");
	}
	
	private void list() {
		for(int i = 0; i < mList.size();i++) {
			System.out.println(i+"��"+mList.get(i).getId()+" / "+mList.get(i).getName());
			
		}
		
	}

	private void del() {
		list();
		System.out.println("���� id ��ȣ�� �����ϼ���");
		int del = in.nextInt();
		in.nextLine();
		mList.remove(del);
	}

	private void mod() {
		String y;
		int m;
		System.out.println("���̵� ���� :y �ƴϿ� : y���� ������");
		y=in.nextLine();
		if("y".equals(y) || "Y".equals(y)) {
			list();
			System.out.println("���� �� ��ȣ�� �����ּ���");
			m=in.nextInt();
			in.nextLine();
			System.out.println("���� ���̵� �Է����ּ���");
			y=in.nextLine();
			mList.get(m).setId(y);
			System.out.println("���̵� �����Ϸ�");
		}
		System.out.println("name ���� :y �ƴϿ� : y���� ������");
		y=in.nextLine();
		if("y".equals(y) || "Y".equals(y)) {
			list();
			System.out.println("���� �� ��ȣ�� �����ּ���");
			m=in.nextInt();
			in.nextLine();
			System.out.println("���� name�� �Է����ּ���");
			y=in.nextLine();
			mList.get(m).setName(y);
			System.out.println("name �����Ϸ�");
		}
		
		
		
		
	}

	private void join() {
		System.out.println("id�� �Է����ּ���");
		id = in.nextLine();
		System.out.println("name�� �Է����ּ���");
		name = in.nextLine();
		Member newM = new Member();
		newM.setId(id);
		newM.setName(name);
		mList.add(newM);
		
	}
	
	public Member logMember(String id) { //�ٽ� check
		Member m = null;
		for(int i=0;i<mList.size();i++) {
			if(mList.get(i).getId().equals(id)) {
				m = mList.get(i);
			}
		}
		return m;
	}
	

}
