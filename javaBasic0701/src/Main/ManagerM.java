package Main;

import java.util.ArrayList;
import java.util.Scanner;

import MemberD.MemberDAO;
import MemberD.MemberDTO;

public class ManagerM {
	ArrayList<MemberDTO> m ;
	MemberDAO dao;
	private String id;

	private String name;
	private String adr;
	private String sign1="!@#$%^&*";
	private String sign2="0123456789";
	Scanner in = new Scanner(System.in);
	
	public ManagerM() {
		seting();
		setDB();
		int snum;
		boolean frag = true;
		while(frag) {
			Menu();
			snum = in.nextInt();
			in.nextLine();
		switch(snum) {
		case 1 : add(); break;
		case 2 : mod(); break;
		case 3 : del(); break;
		case 4 : see(); break;
		case 5 : frag=false;break;
		default : System.out.println("1~5���� �Է����ּ���.");
		
		}
		}
		
	}
	
	private void seting() {
		dao = MemberDAO.getInstence();
	}
	
	private void setDB() {
		if(dao.getList()==null) {
			m = new ArrayList();
		}else {
			m = dao.getList();
		}
	}
	
	private void see() {
	
		for(int i=0;i<m.size();i++) {
			System.out.println("ID :"+m.get(i).getId()+"/name :"+m.get(i).getName()+"/adr :"+m.get(i).getAdr()+"/point"+m.get(i).getPoint());
		}
		
	}

	private void del() {
		System.out.println("���� �� id�� �Է����ּ���");
		id = in.nextLine();
		dao.delete(id);
		setDB();
		
	}

	private void mod() {
		String y;
		MemberDTO dto = new MemberDTO();
		System.out.println("�̸��� ���� �Ͻðڽ��ϴ� ?y");
		y = in.nextLine();
		if("y".equals(y) || "Y".equals(y)) {
			System.out.println("���� �� �̸� �Է�");
			name = in.nextLine();
			dto.setName(name);
		}
		System.out.println("�ּҸ� ���� �Ͻðڽ��ϴ� ?y");
		y = in.nextLine();
		if("y".equals(y) || "Y".equals(y)) {
			System.out.println("���� �� �ּ� �Է�");
			adr = in.nextLine();
			dto.setAdr(adr);
		}
		System.out.println(" �ش� id�� �Է����ּ���");
		id = in.nextLine();
		dto.setId(id);
		dao.update(dto);
		setDB();
	}

	private void add() {
		MemberDTO dto = new MemberDTO();
		ArrayList<MemberDTO> c;

		int cnt1 = 0;
		int cnt2 = 0;
		
		boolean frag = true;
	
        while(frag) {
			System.out.println("id�� �Է����ּ���(5�����̻�,����1�� ����,Ư������1������)");
			id = in.nextLine();
			
			for(int i=0;i<m.size();i++) {
				if(m.get(i).getId().equals(id)) {
					System.out.println("�ߺ��˴ϴ�. �ٽ� �Է����ּ���");
					id = in.nextLine();
					i--;
				}
			}
			
				if(id.length()>4) {
					for(int a=0;a< id.length();a++) {
						char imsi1 = id.charAt(a);
						for(int b=0;b<sign1.length();b++) {
							char imsi2 = sign1.charAt(b);
						if(imsi1 == imsi2) {
							cnt1++;
						}
						}
					}
					for(int a=0;a< id.length();a++) {
						char imsi1 = id.charAt(a);
						for(int b=0;b<sign2.length();b++) {
							char imsi2 = sign2.charAt(b);
						if(imsi1 == imsi2) {
							cnt2++;
						}
						}
					}
					if(cnt1>0 && cnt2>0) {
						dto.setId(id);
						System.out.println("�̸��� �Է�");
						name = in.nextLine();
						dto.setName(name);
						System.out.println("�ּҸ� �Է�");
						adr = in.nextLine();
						dto.setAdr(adr);
						dao.insert(dto);
						frag = false;
					}else {
						System.out.println("���� 1�� , Ư������ 1���� �������ּ���.");
					}
				}else {
					System.out.println("5���� �̻� �Է����ּ���.");
				}
		
			
			
		}
    	setDB();
		                                                                                                                                                                                                                                                                                                                                                                                                                                                      
	}

	private void Menu() {
		System.out.println("�޴�");
		System.out.println("1. ���");
		System.out.println("2. ����");
		System.out.println("3. ����");
		System.out.println("4. ����");
		System.out.println("5. ����");
	
	}

}
