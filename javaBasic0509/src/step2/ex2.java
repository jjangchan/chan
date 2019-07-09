package step2;

import java.util.Random; //반드시시켜야함  문장 12번 단추키
import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		Random r = new Random();  //ctrl + shift + 알파벳o
		
		int com=r.nextInt(3)+1;                               //컴은 1,2,3 번 에 랜덤으로 돌아간다
		//System.out.println(com);
		System.out.println("1:가위, 2:바위, 3:보 선택하세요>");
		int a = in.nextInt();
		
		
		
		
		System.out.println("com:"+com+"/나:"+a);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		if(a==1) {
		    if(com==2) {
				System.out.println("짐");
			}else {
				if(com==1) {
					System.out.println("비김");
				}else {
					System.out.println("이김");
				}
			}
		}
		if(a==2) {
			if(com==2) {
				System.out.println("비김");
			}else {
				if(com==3) {
					System.out.println("짐");
				}else {
					System.out.println("이김");
				}
			}
		}
		if(a==3) {
			if(com==3) {
				System.out.println("비김");
			}else {
				if(com==2) {
					System.out.println("이김");
				}else {
					System.out.println("짐");
				}
			}
		}
				
		
		
		
		
		
		
		
	
		
		

	
	
	
	
	
	
	

	}
	
}
	
	
	
