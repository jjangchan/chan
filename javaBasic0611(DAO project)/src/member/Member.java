package member;

import java.util.List;
import java.util.Scanner;

public class Member {
	Scanner in=new Scanner(System.in);
	int id;
	String name=null;
	String mail=null;
	String addr=null;
	MemberDTO memberDTO=new MemberDTO();
	MemberDTO memberDTO2=new MemberDTO();
	MemberDTO memberDTO3=new MemberDTO();
	List<MemberDTO> su = null;
	
	
	
	public void menu() {
		System.out.println("메뉴");
		System.out.println("1. 삽입");
		System.out.println("2. 수정");
		System.out.println("3. 검색");
		System.out.println("4. 삭제");
		System.out.println("5. 종료");
	}
	
	public void insert() {
		System.out.println("삽입할 성함을 넣어주세요");
		name=in.nextLine();
		memberDTO.setName(name);
		System.out.println("삽입할 주소를 넣어주세요");
		addr=in.nextLine();
		memberDTO.setAddr(addr);
		System.out.println("삽입할 메일을 넣어주세요");
		mail=in.nextLine();
		memberDTO.setMail(mail);
	}
	
	public void update() {
		System.out.println("수정 할 이름을 입력해주세요");
		name=in.nextLine();
		memberDTO2.setName(name);
		System.out.println("수정 할 주소를 넣어주세요");
		addr=in.nextLine();
		memberDTO2.setAddr(addr);
		System.out.println("수정 할 메일을 넣어주세요");
		mail=in.nextLine();
		memberDTO2.setMail(mail);
		System.out.println("수정 시킬 id을 넣어주세요");
		id=in.nextInt();
		in.nextLine();
		memberDTO2.setId(id);
	}
	
	public void delete() {
		System.out.println("삭제 할 id을 입력해주세요");
		id=in.nextInt();
		in.nextLine();
		memberDTO3.setId(id);
	}
	
	public void select() {
		su=MemberDAO.getInstance().getList();
		System.out.println("검색결과 순서 :id/addr/mail/name");
		for(int i=0;i<su.size();i++) {
			System.out.println("----------------------");
			System.out.print(su.get(i).getId()+" / ");
			System.out.print(su.get(i).getAddr()+" / ");
			System.out.print(su.get(i).getMail()+" / ");
			System.out.println(su.get(i).getName());
			System.out.println("---------------------");
		
		}
	}
	
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	
	public MemberDTO getMemberDTO2() {
		return memberDTO2;
	}
	
	public MemberDTO getMemberDTO3() {
		return memberDTO3;
	}
	
}
	
	
	
	
	
	

	

