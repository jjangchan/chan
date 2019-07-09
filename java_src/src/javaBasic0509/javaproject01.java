package javaBasic0509;

import java.util.Random;
import java.util.Scanner;

public class javaproject01 {

	public static void main(String[] args) {
		//키보드로부터 엔터 받는변수 선언하기
		//랜덤 변수 선언하기
		//컴퓨터,사용자의 누적변수 선언하기
		//회당 컴퓨터,플레이어가 획득한 점수 변수  선언하기
	    //계속 반복되는 for문 설정
		//브레이크 설정.
		//주의점. break아래의 코딩은 실행되지 않는다.
		//선언문 시작.끝 표시하기
		//누적문 만들기
		//턴 변수 만들기
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
