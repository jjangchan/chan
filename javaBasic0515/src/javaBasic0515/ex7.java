package javaBasic0515;

import java.util.Random;

public class ex7 {

	public static void main(String[] args) {
	int[] lotto=new int[46];
	Random r=new Random();
	//�Էº�
    for(int a=0; a<6; a++) {
		  int i=r.nextInt(45)+1;
		if(lotto[i]!=0 ) {
				    a--;
				}else {
				lotto[i]=1; 
			   }
		 
    }
    //��º�
	for(int a=0;a<lotto.length;a++) {
		if(lotto[a]==1) {
			System.out.println(a);			
		}
	}
	
	//if(lotto[i] ! =0 ) {
	//	    i--;
	//	}else {
	//		lotto[i]=1; <-����
	//   }
	// ���� ������ ��ġ�� ��������!
	// �ذ����� ��ġ�� ��������!
	//������ Ÿ���� �ְ� ���� �ְ� �ʱⰪ�� �������� �ְ� ���������ִ�
	

	}
}