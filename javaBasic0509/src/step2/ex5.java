package step2;

import java.util.Random;
import java.util.Scanner;

public class ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner in = new Scanner(System.in);
		Random r = new Random(); // Ctrl + Shift + 알파벳 o
		int mypoint=0;
		
		for(int i=0; i<3; i++) {
			// 초기값 ; 조건 ; 증감식
	
			// 시작
			int com = r.nextInt(3) + 1;
	                  // random값 012 >> +1보정을 해서 최종 범위 1,2,3
			System.out.println("1: 가위, 2: 바위, 3:보  선택하세요>");
			int a = in.nextInt();
			in.nextLine();

			if(com==1) {
				if(a==1) {
					System.out.println("비김");
				}else if(a==2) {
					System.out.println("내가 이김");
					mypoint++;
				}else if(a==3){
					System.out.println("컴이 이김");
				}
			}
			
			if(com==2) {
				if(a==1) {
					System.out.println("컴이 이김");
				}else if(a==2) {
					System.out.println("비김");
				}else if(a==3){
					System.out.println("내가 이김");
					mypoint++;
				}
			}
			
			if(com==3) {
				if(a==1) {
					System.out.println("내가 이김");
					mypoint++;
				}else if(a==2) {
					System.out.println("컴이 이김");
				}else if(a==3){
					System.out.println("비김");
				}
			}
			
			System.out.println("Com:" + com + "/ 나 : " + a);
			//끝
		
		}
		
		if(mypoint > 2) {
			System.out.println(mypoint+" / 최종적으로 내가 이김");
		}else {
			System.out.println(mypoint+" / 최종적으로 컴이 이김");
		}
		
		
      
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		

	
	
	
	
	
	
	

	}
	
}
	
	
	
