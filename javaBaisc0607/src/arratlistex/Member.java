package arratlistex;

import java.util.Scanner;

public class Member {
	String id;
	String pwd;
	Scanner in=new Scanner(System.in);
	public void minput(String imsiid){
		id=imsiid;
		System.out.println("pwd : ");
		pwd=in.nextLine();
		
		
	}
	
	public void viewinfo() {
		System.out.println(id+"/"+pwd);
	}
	
	public void mmod() {
		System.out.println("<¼öÁ¤> name : ");
		pwd=in.nextLine();
		
	}

}
