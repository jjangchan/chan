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
			default : System.out.println("1~5 번만 입력해주세요.");
			}
		}
	}

	private void menu() {
		System.out.println("메뉴");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원수정");
		System.out.println("3. 회원삭제");
		System.out.println("4. 회원보기");
		System.out.println("5. 이전메뉴");
	}
	
	private void list() {
		for(int i = 0; i < mList.size();i++) {
			System.out.println(i+"번"+mList.get(i).getId()+" / "+mList.get(i).getName());
			
		}
		
	}

	private void del() {
		list();
		System.out.println("지울 id 번호를 선택하세요");
		int del = in.nextInt();
		in.nextLine();
		mList.remove(del);
	}

	private void mod() {
		String y;
		int m;
		System.out.println("아이디 수정 :y 아니요 : y뺴고 눌러요");
		y=in.nextLine();
		if("y".equals(y) || "Y".equals(y)) {
			list();
			System.out.println("수정 할 번호를 눌러주세요");
			m=in.nextInt();
			in.nextLine();
			System.out.println("수정 아이디를 입력해주세요");
			y=in.nextLine();
			mList.get(m).setId(y);
			System.out.println("아이디 수정완료");
		}
		System.out.println("name 수정 :y 아니요 : y뺴고 눌러요");
		y=in.nextLine();
		if("y".equals(y) || "Y".equals(y)) {
			list();
			System.out.println("수정 할 번호를 눌러주세요");
			m=in.nextInt();
			in.nextLine();
			System.out.println("수정 name를 입력해주세요");
			y=in.nextLine();
			mList.get(m).setName(y);
			System.out.println("name 수정완료");
		}
		
		
		
		
	}

	private void join() {
		System.out.println("id를 입력해주세요");
		id = in.nextLine();
		System.out.println("name을 입력해주세요");
		name = in.nextLine();
		Member newM = new Member();
		newM.setId(id);
		newM.setName(name);
		mList.add(newM);
		
	}
	
	public Member logMember(String id) { //다시 check
		Member m = null;
		for(int i=0;i<mList.size();i++) {
			if(mList.get(i).getId().equals(id)) {
				m = mList.get(i);
			}
		}
		return m;
	}
	

}
