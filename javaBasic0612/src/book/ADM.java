package book;

import java.util.Scanner;

public class ADM {
	Scanner in = new Scanner(System.in);
	MemberDAO dao=null;
	
	ADM(){
		dao=MemberDAO.getInstance();
		boolean frag = true;
		Function f = new Function();
		while(frag) {
			
			f.menu();
			int num = in.nextInt();
			in.nextLine();
			switch(num) {
			
			case 1 : inputinsert(f); break;
			case 2 : inputupdate(f);break;
			case 3 : inputselect(f);break;
			case 4 : inputdelete(f);break;
			case 5 : frag=false; break;
			default : System.out.println("1~4번 만 눌러주세요");
			}
		}
	}
	
	public void inputinsert(Function f) {
		f.insert();
		dao.insert(f.getFt1());
		
	}
	
	public void inputupdate(Function f) {
		f.update();
		dao.update(f.getFt2());
	}
	
	public void inputselect(Function f) {
		f.select();
	}
	
	public void inputdelete(Function f) {
		f.delete();
		dao.delete(f.getFt3());
	}

}
