package step2;

import java.util.Random;
import java.util.Scanner;

public class ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner in = new Scanner(System.in);
		Random r = new Random(); // Ctrl + Shift + ���ĺ� o
		int mypoint=0;
		
		for(int i=0; i<3; i++) {
			// �ʱⰪ ; ���� ; ������
	
			// ����
			int com = r.nextInt(3) + 1;
	                  // random�� 012 >> +1������ �ؼ� ���� ���� 1,2,3
			System.out.println("1: ����, 2: ����, 3:��  �����ϼ���>");
			int a = in.nextInt();
			in.nextLine();

			if(com==1) {
				if(a==1) {
					System.out.println("���");
				}else if(a==2) {
					System.out.println("���� �̱�");
					mypoint++;
				}else if(a==3){
					System.out.println("���� �̱�");
				}
			}
			
			if(com==2) {
				if(a==1) {
					System.out.println("���� �̱�");
				}else if(a==2) {
					System.out.println("���");
				}else if(a==3){
					System.out.println("���� �̱�");
					mypoint++;
				}
			}
			
			if(com==3) {
				if(a==1) {
					System.out.println("���� �̱�");
					mypoint++;
				}else if(a==2) {
					System.out.println("���� �̱�");
				}else if(a==3){
					System.out.println("���");
				}
			}
			
			System.out.println("Com:" + com + "/ �� : " + a);
			//��
		
		}
		
		if(mypoint > 2) {
			System.out.println(mypoint+" / ���������� ���� �̱�");
		}else {
			System.out.println(mypoint+" / ���������� ���� �̱�");
		}
		
		
      
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		

	
	
	
	
	
	
	

	}
	
}
	
	
	
