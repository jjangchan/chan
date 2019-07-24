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
		default : System.out.println("1~5번만 입력해주세요.");
		
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
		System.out.println("삭제 할 id를 입력해주세요");
		id = in.nextLine();
		dao.delete(id);
		setDB();
		
	}

	private void mod() {
		String y;
		MemberDTO dto = new MemberDTO();
		System.out.println("이름을 수정 하시겠습니다 ?y");
		y = in.nextLine();
		if("y".equals(y) || "Y".equals(y)) {
			System.out.println("수정 할 이름 입력");
			name = in.nextLine();
			dto.setName(name);
		}
		System.out.println("주소를 수정 하시겠습니다 ?y");
		y = in.nextLine();
		if("y".equals(y) || "Y".equals(y)) {
			System.out.println("수정 할 주소 입력");
			adr = in.nextLine();
			dto.setAdr(adr);
		}
		System.out.println(" 해당 id을 입력해주세요");
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
			System.out.println("id를 입력해주세요(5글자이상,숫자1개 포함,특수문자1개포함)");
			id = in.nextLine();
			
			for(int i=0;i<m.size();i++) {
				if(m.get(i).getId().equals(id)) {
					System.out.println("중복됩니다. 다시 입력해주세요");
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
						System.out.println("이름을 입력");
						name = in.nextLine();
						dto.setName(name);
						System.out.println("주소를 입력");
						adr = in.nextLine();
						dto.setAdr(adr);
						dao.insert(dto);
						frag = false;
					}else {
						System.out.println("숫자 1개 , 특수문자 1개를 포함해주세요.");
					}
				}else {
					System.out.println("5글자 이상 입력해주세요.");
				}
		
			
			
		}
    	setDB();
		                                                                                                                                                                                                                                                                                                                                                                                                                                                      
	}

	private void Menu() {
		System.out.println("메뉴");
		System.out.println("1. 등록");
		System.out.println("2. 수정");
		System.out.println("3. 삭제");
		System.out.println("4. 보기");
		System.out.println("5. 종류");
	
	}

}
