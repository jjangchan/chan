package javaBasic0509;

import java.util.Random;
import java.util.Scanner;

public class javaproject01 {

	public static void main(String[] args) {
		//Ű����κ��� ���� �޴º��� �����ϱ�
		//���� ���� �����ϱ�
		//��ǻ��,������� �������� �����ϱ�
		//ȸ�� ��ǻ��,�÷��̾ ȹ���� ���� ����  �����ϱ�
	    //��� �ݺ��Ǵ� for�� ����
		//�극��ũ ����.
		//������. break�Ʒ��� �ڵ��� ������� �ʴ´�.
		//���� ����.�� ǥ���ϱ�
		//������ �����
		//�� ���� �����
		//
		
		Scanner in=new Scanner(System.in);
		Random r=new Random();
		int sum=0;
		
		int a=88;
		if(a>=90) {
			System.out.println("A");
		}else if(a>=70){
			if(a>=80) {
				System.out.println("B-1");
			}else if(a>=70) {
				System.out.println("B-2");
			}
		}else if(a>=50) {
			System.out.println("C");
		}
		for(int i=0; i<100; i++) {
			if(i>10) {
				break;
			}
		}
		
		
		for(int c=0; c<3; c++) {
			sum=sum+a;
		}System.out.println(sum);
		
		
		
		
		
	
	
	
	
	
	}
	
}
