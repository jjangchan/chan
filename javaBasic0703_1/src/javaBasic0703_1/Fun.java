package javaBasic0703_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fun {
	
	ArrayList<Member> list = new ArrayList<>();
	FileInputStream fi = null;
	FileOutputStream fo = null;
	Scanner in = new Scanner(System.in);
	String membertxt = "member.txt";
	private static Fun fsingleton;
	public static Fun getInstence() {
		if(fsingleton == null) {
			fsingleton = new Fun();
		}
		return fsingleton;
	}
	
	
	private Fun(){}
	
	public void seting() {
		setsee();
		setio();
	}
	
	public void inputadd() {
		Member m = new Member();
		System.out.println("id 입력");
		m.setId(in.nextLine());
		System.out.println("pwd 입력");
		m.setPwd(in.nextLine());
		list.add(m);
		setio();
		
	}
	
	public void inputsee() {
		
		for(int i=0; i<list.size();i++) {
			System.out.println("------------------");
			System.out.println(i+"번 회원");
			System.out.println("id :"+list.get(i).getId());
			System.out.println("pwd :"+list.get(i).getPwd());
			System.out.println("-------------------");
			
		}
	}
	
	public void setsee() {
		try {
			fi = new FileInputStream("member.txt");
			Member m = new Member();
			int k = 0;
			String id = "";
			char a;
			while((k = fi.read()) != -1) {
				a = (char) k;
				
				if(k==47) {
					
					m.setId(id);
					id="";
				}else if(k==10) {
					m.setPwd(id);
					list.add(m);
					id="";
					m = new Member();
				}else if(k!=47 && k!=10 && k!=13){
					id = id+a;
				}
			}
		}catch(Exception e) {
		}finally {
			try {
				if(fo != null) fo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void setio() {
		
		String sing = "/";
		String sing2 = "\r\n";
		try {
			fo = new FileOutputStream(membertxt);
			
			
			for(int i=0;i<list.size();i++) {
				fo.write((list.get(i).getId()+sing+list.get(i).getPwd()+sing2).getBytes());
			}
			fo.flush();
		} catch(Exception e) {
			
		}finally {
			try {
				if(fo != null) fo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void inputdel() {
		inputsee();
		System.out.println("지울 회원 번호 입력");
		int deln = in.nextInt();
		in.nextLine();
		list.remove(deln);
		setio();
	}
	
	public void inputmod() {
		inputsee();
		String y;
		System.out.println("수정할 회원 번호");
		int modn = in.nextInt();
		in.nextLine();
		System.out.println("아이디 수정 하시겠습니다?yes : y를 눌러주세요");
		y = in.nextLine();
		if("y".equals(y) || "Y".equals(y)) {
			System.out.println("수정할 id 입력");
			String id = in.nextLine();
			list.get(modn).setId(id);;
			
		}
		System.out.println("pwd 수정 하시겠습니다?yes : y를 눌러주세요");
		y = in.nextLine();
		if("y".equals(y) || "Y".equals(y)) {
			System.out.println("수정할 pwd 입력");
			String pwd = in.nextLine();
			list.get(modn).setPwd(pwd);;
		}
		setio();
	}
}



	





		
			
			
			
	
			
			
	
