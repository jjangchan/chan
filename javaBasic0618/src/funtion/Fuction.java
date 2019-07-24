package funtion;

import java.util.ArrayList;
import java.util.Scanner;

import tatalD.I_memberDAO;
import tatalD.I_memberDTO;
import tatalD.MemberDAO;
import tatalD.MemberDTO;

public class Fuction {
	private Scanner in = new Scanner(System.in);
	ArrayList<MemberDTO> adto = new ArrayList<>();
	ArrayList<I_memberDTO> adto2 =null;
	
	

	private MemberDAO dao = null;
	private I_memberDAO dao2 = null;
	private static Fuction fsingleton;
	public static Fuction getInstence() {
		if(fsingleton == null) {
			fsingleton = new Fuction();
		}
		return fsingleton;
	}
	
	public Fuction() {
		seting();
		setingA();
	}
	
	private void setingA() {
		adto=dao.getList();
		if(adto==null) {
			adto=new ArrayList<>();
		}
	}
		
	
	private void seting() {
		dao=MemberDAO.getInstence();
		dao2=I_memberDAO.getInstence();
	}
	
	public void add() {
		
		MemberDTO ft1 = new MemberDTO();
		boolean frag = true;
		String sid;
		while(frag) {
			System.out.println("회원가입할 id를 입력");
			sid = in.nextLine();
			for(int i=0;i<adto.size();i++) {
				if(adto.get(i).getId().equals(sid)) {
					System.out.println("이미 등록된 아이디입니다.");
					break;
				}else {
					ft1.setId(sid);
					System.out.println("회원가입할 pwd을 입력");
					ft1.setPwd(in.nextLine());
					System.out.println("회원가입할 name을 입력");
					ft1.setName(in.nextLine());
					System.out.println("회원가입할 ph을 입력");
					ft1.setPh(in.nextInt());
					in.nextLine();
					adto.add(ft1);
					dao.insert(ft1);
					frag = false;
					break;
				}
			}
			
		}
	}
		
				
	
	public void mod() {
		list();
		String y;
		MemberDTO ft2 = new MemberDTO();
		System.out.println("비번 수정 하시겠습니까? y");
		y = in.nextLine();
		if("y".equals(y) || "Y".equals(y)) {
			System.out.println("수정 할 비번 입력");
			ft2.setPwd(in.nextLine());
		}
		System.out.println("번호를 수정 하시겠습니까? y");
		y = in.nextLine();
		if("y".equals(y) || "Y".equals(y)) {
			System.out.println("수정 할 번호 숫자 입력");
			ft2.setPh(in.nextInt());
			in.nextLine();
		}
	    System.out.println("수정에 해당하는 아이디 입력");
	    ft2.setId(in.nextLine());
		adto.add(ft2);
		dao.update(ft2);
		setingA();
	
	}
	
	public void del() {
		list();
		System.out.println("삭제 할 아이디 입력하세요");
		String DID = in.nextLine();
		dao.delete(DID);
		setingA();
	}
	
	public void list() {
		for(int i=0;i<adto.size();i++) {
			System.out.println(i+"번 :"+adto.get(i).getId()+"/"+adto.get(i).getName()+"/"+adto.get(i).getPh());
		}
	}
	
	public void select() {
		
		System.out.println("검색 하실 아이디를 입력하세요");
		String id = in.nextLine();
	    adto = dao.select(id);
	    for(int i=0;i<adto.size();i++) {
	    	
	    	System.out.print("id :"+adto.get(i).getId()+" / ");
	    	System.out.print("pwd :"+adto.get(i).getPwd()+" / ");
	    	System.out.print("name :"+adto.get(i).getName()+" / ");
	    	System.out.println("ph :"+adto.get(i).getPh()+" / ");
	    	
	    }
	}
	
	public void cminsert() {
		list();
		I_memberDTO ift1 = new I_memberDTO();
		boolean frag = true;
		String uid;
		String myid;
		String cm;
		while(frag) {
			System.out.println("댓글을 남기고 싶은 id를 입력하세요.");
			uid=in.nextLine();
			System.out.println("자신의 아이디를 입력하시오");
			myid = in.nextLine();
			for(int i=0;i<adto.size();i++) {
				if(adto.get(i).getId().equals(uid) && adto.get(i).getId().equals(myid)) {
					ift1.setId(uid);
					ift1.setMy_id(myid);
					
					System.out.println("댓글을 입력하시오(50글자미만)");
					cm = in.nextLine();
					if(cm.length()>50) {
						System.out.println("50글자가 넘습니다.");
					}else {
						ift1.setCm(cm);
						System.out.println("자신의 이름을 입력하시오");
						ift1.setName(in.nextLine());
						
						dao2.insert(ift1);
						frag = false;
						break;
					}
				}else {
					System.out.println("존재하지 않는 아이디입니다.");
					break;
				}
			}
		}
	}
	
	public void cmsee() {
		list();
		System.out.println("댓글을 볼 아이디를 입력하세요");
		String id = in.nextLine();
	    adto2 = dao2.select(id);
	    System.out.println(id+"님의 댓글함");
	    for(int i=0;i<adto2.size();i++) {
	    	
	    	System.out.print("id :"+adto2.get(i).getMy_id()+" / ");
	        System.out.print("이름 :"+adto2.get(i).getName()+" / ");
	    	System.out.println("댓글 :"+adto2.get(i).getCm()+" / ");
	    	
	    }
	}
}
						
