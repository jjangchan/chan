package javaBasic0514;

import java.util.Scanner;

public class ex01 {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		String id=in.nextLine();

		String sign="!@#$%^&*";
		
		System.out.println("����� �Է��� id��"+id+"�Դϴ�.");
		System.out.println("����� �Է��� id�� ���̴� :"+id.length());
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
				System.out.println("��밡��");
			}else {
				System.out.println("���Ұ���");
			}
			
			
			
			
		
	
	  	
		
		
		
	
	        
	
	
	
	}

}
