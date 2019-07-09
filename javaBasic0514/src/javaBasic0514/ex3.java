package javaBasic0514;

import java.util.Scanner;

public class ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String id=in.nextLine();
		String sign="!@#$%^&*";
		
		System.out.println("당신이 입력한 id는"+id+"입니다.");
		System.out.println("id에 글자수는 :"+id.length());
		int mycnt1=0;
		
		for(int a=0; a<id.length();a++) {
			char imsi1=id.charAt(a);
			for(int b=0; b<sign.length();b++) {
				char imsi2=sign.charAt(b);
				if(id.length()>=8) {
				 if(imsi1==imsi2) {
					 mycnt1++;
		           }
			}
			}
		}if(mycnt1>=2 ) {
			System.out.println("사용가능");
		}else {
			System.out.println("사용불가능");
		}

	}

}
