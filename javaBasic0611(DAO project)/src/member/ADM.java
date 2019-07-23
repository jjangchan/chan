package member;

import java.util.Scanner;

public class ADM {
	MemberDAO dao = null; //check ��� ����
	Scanner in=new Scanner(System.in);
	
	ADM(){
		boolean frag=true;
		dao=MemberDAO.getInstance();
		Member m=new Member();
		
		while(frag) {
			m.menu();
			int num=in.nextInt();
			in.nextLine();
			
			switch(num) {
			case 1 :inputinsert(m);break; //(m) check ��� ���� 
			case 2 :inputupdate(m);break;
			case 3 :inputselect(m);break;
			case 4 :inputdelete(m);break;
			case 5 :frag=false; break;
			default :System.out.println("�߸��Է�");
			
			}
		}
	}
	
	public void inputinsert(Member m) { //check ��� ���� 
		m.insert();
		dao.insert(m.getMemberDTO());
	}
	
	public void inputupdate(Member m) {
		m.update();
		dao.update(m.getMemberDTO2());
	}
	
	public void inputdelete(Member m) {
		m.delete();
		dao.delete(m.getMemberDTO3());
	}
	
	public void inputselect(Member m) {
		m.select();
	}
	
}

	
		
		
		
			
			
		
	
	
	

	
