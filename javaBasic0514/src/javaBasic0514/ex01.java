package javaBasic0514;

import java.util.Scanner;

public class ex01 {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		String id=in.nextLine();

		String sign="!@#$%^&*";
		
		System.out.println("당신이 입력한 id는"+id+"입니다.");
		System.out.println("당신이 입력한 id의 길이는 :"+id.length());
		int myct=0;
		for(int a=0;a<id.length();a++) {
			for(int b=0;b<sign.length();b++) {
				char imsi1=id.charAt(a);
				char kk=sign.charAt(b);
				if(kk==imsi1) {
					myct++;
				}
				}
			}if(myct>0) {
				System.out.println("사용가능");
			}else {
				System.out.println("사용불가능");
			}
			
			
			
			
		
	
	  	
		
		
		
	
	        
	
	
	
	}

}
