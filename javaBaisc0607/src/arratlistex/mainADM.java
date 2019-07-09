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
		System.out.println("id입력");
		String id=in.nextLine();
		
		for(int i=0;i<list.size();i++) {
			if(id.equals(list.get(i).id)) {
				System.out.println("중복");
				System.out.println("id입력");
				id=in.nextLine();
				i=0;
			}
		}
		imsiMember.minput(id);
		list.add(imsiMember);
	
		
	}
	
	
    private void del() {
		list();
		System.out.println("삭제할 번호 입력 :");
		int delnum=in.nextInt();
		in.nextLine();
		
		list.remove(delnum);
	}
    private void list() {
		for(int i=0;i<list.size();i++) {
			//list[i].viewinfo();
			System.out.print(i+"번 고객님 :");
			list.get(i).viewinfo();
		}
	}
    private void mod() {
    	list();
		System.out.println("수정 할 번호 입력 :");
		int delnum=in.nextInt();
		in.nextLine();
		
		list.get(delnum).mmod();
	}
    private void menu() {
		System.out.println("메뉴선택 :");
		System.out.println("1. 추가");
		System.out.println("2. 삭제");
		System.out.println("3. 수정");
		System.out.println("4. 목록");
	}
    private void menu2() {
		System.out.println("메뉴선택 :");
		System.out.println("1. 추가");
		
	}

}
