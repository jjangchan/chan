package ex1;

import java.util.Scanner;

public class Member {
	String[] member=new String[5];
	Scanner in=new Scanner(System.in);
	Member(){  //메서드(생성자)-객체가 생성될때 시작점,딱 한번만 실행
             //생성자 메서드는 반드시 클래스 이름과 동일하다.		
		for(;;) {
			menu();		
			int selmenu=in.nextInt();
			in.nextLine();
			switch(selmenu) {
			case 1: add(); break;
			case 2: del(); break;
			case 3: list(); break;
			case 4: mod(); break;
			default:System.out.println("정은지");	
			}
		}
	}
	private void mod() {
		System.out.println("수정 할 고객의 번호를 입력하세요.");
		list();
		System.out.println("번호입력>");
		int delnum=in.nextInt();
		in.nextLine();
		System.out.println("수정할 id를 입력하세요");
		String newID=in.nextLine();
		member[delnum]=newID;
		
	}
	private void del() {
		System.out.println("삭제할 고객의 번호를 입력하세요.");
		list();
		System.out.println("번호입력>");
		int delnum=in.nextInt();
		in.nextLine();
		member[delnum]=null;
	}
	public void menu() {//메서드 정의 및 구현 
		System.out.println("------------------");
		System.out.println("1. add");
		System.out.println("2. del");
		System.out.println("3. list");
		System.out.println("4. mod");
		System.out.println("-------------------");
	}
			
	public void add() {//사용자 추가 메서드
		System.out.println("추가할 id를 입력하세요>");
		String id=in.nextLine();
		for(int i=0; i<member.length;i++) {
			if(member[i]==null) {
				member[i]=id;
				break;
			}
		}
	}
	public void list() {// 사용자 보기 메서드
		for(int i=0; i<member.length;i++) {
			if(member[i]!=null) {
				System.out.println(i+"번 고객:"+member[i]);
			}
		}
		
		
	}
}
				

	
	
	
