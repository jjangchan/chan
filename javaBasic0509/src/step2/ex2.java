package step2;

import java.util.Random; //�ݵ�ý��Ѿ���  ���� 12�� ����Ű
import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		Random r = new Random();  //ctrl + shift + ���ĺ�o
		
		int com=r.nextInt(3)+1;                               //���� 1,2,3 �� �� �������� ���ư���
		//System.out.println(com);
		System.out.println("1:����, 2:����, 3:�� �����ϼ���>");
		int a = in.nextInt();
		
		
		
		
		System.out.println("com:"+com+"/��:"+a);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		if(a==1) {
		    if(com==2) {
				System.out.println("��");
			}else {
				if(com==1) {
					System.out.println("���");
				}else {
					System.out.println("�̱�");
				}
			}
		}
		if(a==2) {
			if(com==2) {
				System.out.println("���");
			}else {
				if(com==3) {
					System.out.println("��");
				}else {
					System.out.println("�̱�");
				}
			}
		}
		if(a==3) {
			if(com==3) {
				System.out.println("���");
			}else {
				if(com==2) {
					System.out.println("�̱�");
				}else {
					System.out.println("��");
				}
			}
		}
				
		
		
		
		
		
		
		
	
		
		

	
	
	
	
	
	
	

	}
	
}
	
	
	
