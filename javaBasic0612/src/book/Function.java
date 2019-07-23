package book;

import java.util.List;
import java.util.Scanner;

public class Function {
	MemberDTO ft1=new MemberDTO();
	MemberDTO ft2=new MemberDTO();
	MemberDTO ft3=new MemberDTO();
	Scanner in = new Scanner(System.in);
	String name = null;
	String author = null;
	String rent_id = null;
	String reg_date = null;
	int ISBN = 0;
	
	List<MemberDTO> t = null; //check 기능 설명

	public void menu() {
		System.out.println("메뉴");
		System.out.println("1. 삽입");
		System.out.println("2. 수정");
		System.out.println("3. 검색");
		System.out.println("4. 삭제");
		System.out.println("5. 종료");
	}
	
	public void insert() {
		System.out.println("삽입 할 책명을 입력해주세요.");
		name=in.nextLine();
		ft1.setName(name);
		System.out.println("삽입 할 저자를 입력해주세요");
		author=in.nextLine();
		ft1.setAuthor(author);
		System.out.println("삽입 할 대여자명을 입력해주세요");
		rent_id=in.nextLine();
		ft1.setRent_id(rent_id);
		
	}
	
	public void update() {
		System.out.println("수정 할 책명을 입력해주세요");
		System.out.println("수정 안 할 시 x를 눌러주세요");
		name=in.nextLine();
		if("x".equals(name) || "X".equals(name)) {
			
		}else {
			ft2.setName(name);
		}
		System.out.println("수정 할 저자명을 입력해주세요");
		System.out.println("수정 안 할 시 x를 눌러주세요");
		author=in.nextLine();
		if("x".equals(name) || "X".equals(name)) {
			
		}else {
			ft2.setAuthor(author);
		}
		System.out.println("수정 할 대여자명을 입력해주세요");
		System.out.println("수정 안 할 시 x를 눌러주세요");
		rent_id=in.nextLine();
		if("x".equals(rent_id) || "X".equals(rent_id)) {
			
		}else {
			ft2.setAuthor(rent_id);
		}
		System.out.println("해당하는 isbn명을 입력해주세요");
	    ISBN=in.nextInt();
		in.nextLine();
		ft2.setISBN(ISBN);
	}
	
	public void delete() {
		System.out.println("삭제할 ISBN명을 입력해주세요");
		ISBN=in.nextInt();
		in.nextLine();
		ft3.setISBN(ISBN);
	}
	
	public void select() {
		t=MemberDAO.getInstance().getList(); //다시 check 기능 설명
		System.out.println("목록 : reg_date / isbn / name / author / rent_id");
		if(t==null) {
			System.out.println("등록된 데이터베이스가 없습니다.");
		}else {
			for(int i=0;i<t.size();i++) {
				System.out.println("----------------------");
				System.out.println(t.get(i).getReg_date());
				System.out.print(t.get(i).getISBN()+" / ");
				System.out.print(t.get(i).getName()+" / ");
				System.out.print(t.get(i).getAuthor()+" / ");
				System.out.println(t.get(i).getRent_id());
				System.out.println("---------------------");
			}
		}
	}
			
	
	public MemberDTO getFt1() { //다시 check 기능 설명
		return ft1;
	}
	
	public MemberDTO getFt2() {
		return ft2;
	}
	
	public MemberDTO getFt3() {
		return ft3;
	}
	
	
	
}
