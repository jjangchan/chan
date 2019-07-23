package shop;

import java.util.Scanner;

public class ADM {
	Scanner in=new Scanner(System.in);
	
	ADM(){
		Member m=new Member();
		//회원으로 쇼핑하기
		//비회원으로 쇼핑하기
		m.setDate();
		m.shopping();
	}

}
