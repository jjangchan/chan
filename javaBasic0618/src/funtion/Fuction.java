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
			System.out.println("ȸ�������� id�� �Է�");
			sid = in.nextLine();
			for(int i=0;i<adto.size();i++) {
				if(adto.get(i).getId().equals(sid)) {
					System.out.println("�̹� ��ϵ� ���̵��Դϴ�.");
					break;
				}else {
					ft1.setId(sid);
					System.out.println("ȸ�������� pwd�� �Է�");
					ft1.setPwd(in.nextLine());
					System.out.println("ȸ�������� name�� �Է�");
					ft1.setName(in.nextLine());
					System.out.println("ȸ�������� ph�� �Է�");
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
		System.out.println("��� ���� �Ͻðڽ��ϱ�? y");
		y = in.nextLine();
		if("y".equals(y) || "Y".equals(y)) {
			System.out.println("���� �� ��� �Է�");
			ft2.setPwd(in.nextLine());
		}
		System.out.println("��ȣ�� ���� �Ͻðڽ��ϱ�? y");
		y = in.nextLine();
		if("y".equals(y) || "Y".equals(y)) {
			System.out.println("���� �� ��ȣ ���� �Է�");
			ft2.setPh(in.nextInt());
			in.nextLine();
		}
	    System.out.println("������ �ش��ϴ� ���̵� �Է�");
	    ft2.setId(in.nextLine());
		adto.add(ft2);
		dao.update(ft2);
		setingA();
	
	}
	
	public void del() {
		list();
		System.out.println("���� �� ���̵� �Է��ϼ���");
		String DID = in.nextLine();
		dao.delete(DID);
		setingA();
	}
	
	public void list() {
		for(int i=0;i<adto.size();i++) {
			System.out.println(i+"�� :"+adto.get(i).getId()+"/"+adto.get(i).getName()+"/"+adto.get(i).getPh());
		}
	}
	
	public void select() {
		
		System.out.println("�˻� �Ͻ� ���̵� �Է��ϼ���");
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
			System.out.println("����� ����� ���� id�� �Է��ϼ���.");
			uid=in.nextLine();
			System.out.println("�ڽ��� ���̵� �Է��Ͻÿ�");
			myid = in.nextLine();
			for(int i=0;i<adto.size();i++) {
				if(adto.get(i).getId().equals(uid) && adto.get(i).getId().equals(myid)) {
					ift1.setId(uid);
					ift1.setMy_id(myid);
					
					System.out.println("����� �Է��Ͻÿ�(50���ڹ̸�)");
					cm = in.nextLine();
					if(cm.length()>50) {
						System.out.println("50���ڰ� �ѽ��ϴ�.");
					}else {
						ift1.setCm(cm);
						System.out.println("�ڽ��� �̸��� �Է��Ͻÿ�");
						ift1.setName(in.nextLine());
						
						dao2.insert(ift1);
						frag = false;
						break;
					}
				}else {
					System.out.println("�������� �ʴ� ���̵��Դϴ�.");
					break;
				}
			}
		}
	}
	
	public void cmsee() {
		list();
		System.out.println("����� �� ���̵� �Է��ϼ���");
		String id = in.nextLine();
	    adto2 = dao2.select(id);
	    System.out.println(id+"���� �����");
	    for(int i=0;i<adto2.size();i++) {
	    	
	    	System.out.print("id :"+adto2.get(i).getMy_id()+" / ");
	        System.out.print("�̸� :"+adto2.get(i).getName()+" / ");
	    	System.out.println("��� :"+adto2.get(i).getCm()+" / ");
	    	
	    }
	}
}
						
