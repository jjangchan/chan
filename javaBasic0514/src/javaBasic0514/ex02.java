package javaBasic0514;

import java.util.Scanner;

public class ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String id=in.nextLine();
		String sign="!@#$%^&*";
		
		System.out.println("����� �Է��� id��"+id+"�Դϴ�.");
		System.out.println("id�� ���ڼ��� :"+id.length());
		int mycnt1=0;
		if(id.length()>7) {
			for(int a=0; a<id.length();a++) {
				char imsi1=id.charAt(a);
				for(int b=0; b<sign.length();b++) {
					char imsi2=sign.charAt(b);
					if(imsi1==imsi2) {
					mycnt1++;
				}
				}
			}if(mycnt1>1 ) {
				System.out.println("��밡��");
			}else {
				System.out.println("���Ұ���");
				System.out.println("Ư�����ڴ� 2�� �̻��̿��� �մϴ�.");
			}
		}else {
			System.out.println("8���� �̻� �̿��� �մϴ�.");
		}
		
	
	}

}
