package javaBasic0515;

import java.util.Random;

public class ex7 {

	public static void main(String[] args) {
	int[] lotto=new int[46];
	Random r=new Random();
	//입력부
    for(int a=0; a<6; a++) {
		  int i=r.nextInt(45)+1;
		if(lotto[i]!=0 ) {
				    a--;
				}else {
				lotto[i]=1; 
			   }
		 
    }
    //출력부
	for(int a=0;a<lotto.length;a++) {
		if(lotto[a]==1) {
			System.out.println(a);			
		}
	}
	
	//if(lotto[i] ! =0 ) {
	//	    i--;
	//	}else {
	//		lotto[i]=1; <-구형
	//   }
	// 변수 선언의 위치를 주의하자!
	// 준가로의 위치를 주의하자!
	//변수란 타입이 있고 명이 있고 초기값은 있을수도 있고 없을수도있다
	

	}
}