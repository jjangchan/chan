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
	
	List<MemberDTO> t = null; //check ��� ����

	public void menu() {
		System.out.println("�޴�");
		System.out.println("1. ����");
		System.out.println("2. ����");
		System.out.println("3. �˻�");
		System.out.println("4. ����");
		System.out.println("5. ����");
	}
	
	public void insert() {
		System.out.println("���� �� å���� �Է����ּ���.");
		name=in.nextLine();
		ft1.setName(name);
		System.out.println("���� �� ���ڸ� �Է����ּ���");
		author=in.nextLine();
		ft1.setAuthor(author);
		System.out.println("���� �� �뿩�ڸ��� �Է����ּ���");
		rent_id=in.nextLine();
		ft1.setRent_id(rent_id);
		
	}
	
	public void update() {
		System.out.println("���� �� å���� �Է����ּ���");
		System.out.println("���� �� �� �� x�� �����ּ���");
		name=in.nextLine();
		if("x".equals(name) || "X".equals(name)) {
			
		}else {
			ft2.setName(name);
		}
		System.out.println("���� �� ���ڸ��� �Է����ּ���");
		System.out.println("���� �� �� �� x�� �����ּ���");
		author=in.nextLine();
		if("x".equals(name) || "X".equals(name)) {
			
		}else {
			ft2.setAuthor(author);
		}
		System.out.println("���� �� �뿩�ڸ��� �Է����ּ���");
		System.out.println("���� �� �� �� x�� �����ּ���");
		rent_id=in.nextLine();
		if("x".equals(rent_id) || "X".equals(rent_id)) {
			
		}else {
			ft2.setAuthor(rent_id);
		}
		System.out.println("�ش��ϴ� isbn���� �Է����ּ���");
	    ISBN=in.nextInt();
		in.nextLine();
		ft2.setISBN(ISBN);
	}
	
	public void delete() {
		System.out.println("������ ISBN���� �Է����ּ���");
		ISBN=in.nextInt();
		in.nextLine();
		ft3.setISBN(ISBN);
	}
	
	public void select() {
		t=MemberDAO.getInstance().getList(); //�ٽ� check ��� ����
		System.out.println("��� : reg_date / isbn / name / author / rent_id");
		if(t==null) {
			System.out.println("��ϵ� �����ͺ��̽��� �����ϴ�.");
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
			
	
	public MemberDTO getFt1() { //�ٽ� check ��� ����
		return ft1;
	}
	
	public MemberDTO getFt2() {
		return ft2;
	}
	
	public MemberDTO getFt3() {
		return ft3;
	}
	
	
	
}
