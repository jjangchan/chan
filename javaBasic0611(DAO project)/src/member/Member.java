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
		System.out.println("�޴�");
		System.out.println("1. ����");
		System.out.println("2. ����");
		System.out.println("3. �˻�");
		System.out.println("4. ����");
		System.out.println("5. ����");
	}
	
	public void insert() {
		System.out.println("������ ������ �־��ּ���");
		name=in.nextLine();
		memberDTO.setName(name);
		System.out.println("������ �ּҸ� �־��ּ���");
		addr=in.nextLine();
		memberDTO.setAddr(addr);
		System.out.println("������ ������ �־��ּ���");
		mail=in.nextLine();
		memberDTO.setMail(mail);
	}
	
	public void update() {
		System.out.println("���� �� �̸��� �Է����ּ���");
		name=in.nextLine();
		memberDTO2.setName(name);
		System.out.println("���� �� �ּҸ� �־��ּ���");
		addr=in.nextLine();
		memberDTO2.setAddr(addr);
		System.out.println("���� �� ������ �־��ּ���");
		mail=in.nextLine();
		memberDTO2.setMail(mail);
		System.out.println("���� ��ų id�� �־��ּ���");
		id=in.nextInt();
		in.nextLine();
		memberDTO2.setId(id);
	}
	
	public void delete() {
		System.out.println("���� �� id�� �Է����ּ���");
		id=in.nextInt();
		in.nextLine();
		memberDTO3.setId(id);
	}
	
	public void select() {
		su=MemberDAO.getInstance().getList();
		System.out.println("�˻���� ���� :id/addr/mail/name");
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
	
	
	
	
	
	

	

